/*
 * Copyright (c) 2022 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.serialization.codecs;

import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.serialization.SerializationContext;
import org.eclipse.milo.opcua.stack.core.serialization.UaDataType;
import org.eclipse.milo.opcua.stack.core.serialization.UaDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaEncoder;

public abstract class GenericDataTypeCodec<T extends UaDataType> implements DataTypeCodec {

    public abstract Class<T> getType();

    @Override
    public Object decode(SerializationContext context, UaDecoder decoder) throws UaSerializationException {
        Object untypedValue = decodeType(context, decoder);
        try {
            return getType().cast(untypedValue);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
        }
    }

    @Override
    public void encode(SerializationContext context, UaEncoder encoder, Object value) throws UaSerializationException {
        T typedValue;
        try {
            typedValue = getType().cast(value);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
        }
        encodeType(context, encoder, typedValue);
    }

    public abstract T decodeType(SerializationContext context, UaDecoder decoder) throws UaSerializationException;

    public abstract void encodeType(SerializationContext context, UaEncoder encoder, T value) throws UaSerializationException;

}

