/*
 * Copyright (c) 2023 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server;

import java.util.List;

import org.eclipse.milo.opcua.sdk.server.identity.Identity;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

public interface RoleManager {

    /**
     * Grant roles to a Client based on {@link Identity}.
     *
     * @param identity the {@link Identity} of the Client.
     * @return the {@link NodeId}s of the roles granted to the Client.
     */
    List<NodeId> getRoleIds(Identity identity);

    /**
     * Grant roles to a Client.
     * <p>
     * The standard mapping rules allow roles to be granted based on:
     * <ul>
     *     <li>user identity</li>
     *     <li>application identity</li>
     *     <li>endpoint</li>
     * </ul>
     *
     * @param identity the {@link Identity} of the Client.
     * @param applicationUri the applicationUri of the Client.
     * @param endpoint the endpoint the Client is connected to.
     * @return the {@link NodeId}s of the roles granted to the Client.
     */
    default List<NodeId> getRoleIds(Identity identity, String applicationUri, EndpointDescription endpoint) {
        return getRoleIds(identity);
    }

}
