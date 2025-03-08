package com.fyber.inneractive.sdk.rtb.data.types;

public enum a {
    VAST_1_0(1),
    VAST_2_0(2),
    VAST_3_0(3),
    VAST_1_0_WRAPPER(4),
    VAST_2_0_WRAPPER(5),
    VAST_3_0_WRAPPER(6);
    
    public int value;

    /* access modifiers changed from: public */
    a(int i) {
        this.value = i;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
