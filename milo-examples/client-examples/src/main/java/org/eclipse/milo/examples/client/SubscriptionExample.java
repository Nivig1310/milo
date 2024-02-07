/*
 * Copyright (c) 2024 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.examples.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.subscriptions2.OpcUaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.subscriptions2.OpcUaSubscription;
import org.eclipse.milo.opcua.stack.core.NodeIds;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionExample implements ClientExample {

    public static void main(String[] args) throws Exception {
        var example = new SubscriptionExample();

        new ClientExampleRunner(example).run();
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {
        client.connect();

        var subscription = new OpcUaSubscription(client);

        // Set a listener for data changes at the subscription level.
        subscription.setSubscriptionListener(new OpcUaSubscription.SubscriptionListener() {
            @Override
            public void onDataReceived(
                OpcUaSubscription subscription,
                List<OpcUaMonitoredItem> items, List<DataValue> values
            ) {

                for (int i = 0; i < items.size(); i++) {
                    logger.info(
                        "subscription onDataReceived: item={}, value={}",
                        items.get(i).getReadValueId().getNodeId(), values.get(i).getValue()
                    );
                }
            }
        });

        // Create the subscription on the server.
        subscription.create();

        var monitoredItem = OpcUaMonitoredItem.newDataItem(NodeIds.Server_ServerStatus_CurrentTime);

        // Set a listener for data changes at the monitored item level.
        monitoredItem.setDataValueListener(
            (item, value) ->
                logger.info(
                    "monitoredItem onDataReceived: item={}, value={}",
                    item.getReadValueId().getNodeId(), value.getValue()
                )
        );

        // Add the MonitoredItem to the Subscription
        subscription.addMonitoredItem(monitoredItem);

        // Synchronize the MonitoredItems with the server.
        // This will create, modify, and delete items as necessary.
        subscription.synchronizeMonitoredItems();

        if (monitoredItem.getCreateResult().orElseThrow().isGood()) {
            logger.info("item created for nodeId={}", monitoredItem.getReadValueId().getNodeId());

            // Let the example run for 5 seconds before completing.
            Thread.sleep(5000);

            // Remove the MonitoredItem from the Subscription.
            subscription.removeMonitoredItem(monitoredItem);

            // Synchronize the MonitoredItems with the server.
            // This will create, modify, and delete items as necessary.
            subscription.synchronizeMonitoredItems();

            // Delete the Subscription from the server.
            subscription.delete();
        } else {
            logger.warn(
                "failed to create item for nodeId={}: {}",
                monitoredItem.getReadValueId().getNodeId(),
                monitoredItem.getCreateResult().orElseThrow()
            );
        }

        future.complete(client);
    }

}
