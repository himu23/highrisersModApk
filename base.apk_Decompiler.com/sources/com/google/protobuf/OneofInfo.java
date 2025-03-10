package com.google.protobuf;

import java.lang.reflect.Field;

@CheckReturnValue
final class OneofInfo {
    private final Field caseField;
    private final int id;
    private final Field valueField;

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public Field getValueField() {
        return this.valueField;
    }

    public OneofInfo(int i, Field field, Field field2) {
        this.id = i;
        this.caseField = field;
        this.valueField = field2;
    }
}
