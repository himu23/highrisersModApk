package com.fyber.inneractive.sdk.measurement;

public enum g {
    VERIFICATION_RESOURCE_REJECTED(1),
    VERIFICATION_NOT_SUPPORTED(2),
    ERROR_DURING_RESOURCE_LOAD(3);
    
    public int mReason;

    /* access modifiers changed from: public */
    g(int i) {
        this.mReason = i;
    }
}
