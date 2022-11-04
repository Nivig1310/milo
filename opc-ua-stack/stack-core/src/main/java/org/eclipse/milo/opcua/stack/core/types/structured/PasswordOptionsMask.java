/*
 * Copyright (c) 2022 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.eclipse.milo.opcua.stack.core.types.builtin.OptionSetUI32;
import org.eclipse.milo.opcua.stack.core.types.builtin.OptionSetUInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part18/5.2.2">https://reference.opcfoundation.org/v105/Core/docs/Part18/5.2.2</a>
 */
@EqualsAndHashCode(
    callSuper = true
)
@ToString
public class PasswordOptionsMask extends OptionSetUI32<PasswordOptionsMask.Field> {
    public PasswordOptionsMask(UInteger value) {
        super(value);
    }

    public boolean getSupportInitialPasswordChange() {
        return get(Field.SupportInitialPasswordChange);
    }

    public boolean getSupportDisableUser() {
        return get(Field.SupportDisableUser);
    }

    public boolean getSupportDisableDeleteForUser() {
        return get(Field.SupportDisableDeleteForUser);
    }

    public boolean getSupportNoChangeForUser() {
        return get(Field.SupportNoChangeForUser);
    }

    public boolean getSupportDescriptionForUser() {
        return get(Field.SupportDescriptionForUser);
    }

    public boolean getRequiresUpperCaseCharacters() {
        return get(Field.RequiresUpperCaseCharacters);
    }

    public boolean getRequiresLowerCaseCharacters() {
        return get(Field.RequiresLowerCaseCharacters);
    }

    public boolean getRequiresDigitCharacters() {
        return get(Field.RequiresDigitCharacters);
    }

    public boolean getRequiresSpecialCharacters() {
        return get(Field.RequiresSpecialCharacters);
    }

    @Override
    public UInteger getValue() {
        return (UInteger) value;
    }

    @Override
    public Set<PasswordOptionsMask.Field> toSet() {
        return Arrays.stream(Field.values())
            .filter(this::get)
            .collect(Collectors.toSet());
    }

    public static PasswordOptionsMask of(PasswordOptionsMask.Field... fields) {
        long bits = 0L;

        for (Field f : fields) {
            bits |= (1L << f.bitIndex);
        }

        return new PasswordOptionsMask(UInteger.valueOf(bits));
    }

    public enum Field implements OptionSetUInteger.BitIndex {
        SupportInitialPasswordChange(0),

        SupportDisableUser(1),

        SupportDisableDeleteForUser(2),

        SupportNoChangeForUser(3),

        SupportDescriptionForUser(4),

        RequiresUpperCaseCharacters(5),

        RequiresLowerCaseCharacters(6),

        RequiresDigitCharacters(7),

        RequiresSpecialCharacters(8);

        private final int bitIndex;

        Field(int bitIndex) {
            this.bitIndex = bitIndex;
        }

        @Override
        public int getBitIndex() {
            return bitIndex;
        }
    }
}
