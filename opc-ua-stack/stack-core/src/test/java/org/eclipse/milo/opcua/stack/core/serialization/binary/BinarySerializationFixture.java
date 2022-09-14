/*
 * Copyright (c) 2022 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.serialization.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.eclipse.milo.opcua.stack.core.serialization.TestSerializationContext;
import org.testng.annotations.BeforeMethod;

public abstract class BinarySerializationFixture {

    ByteBuf buffer;
    OpcUaBinaryEncoder writer;
    OpcUaBinaryDecoder reader;

    @BeforeMethod
    public void setUp() {
        buffer = Unpooled.buffer();

        writer = new OpcUaBinaryEncoder(new TestSerializationContext()).setBuffer(buffer);
        reader = new OpcUaBinaryDecoder(new TestSerializationContext()).setBuffer(buffer);
    }

}
