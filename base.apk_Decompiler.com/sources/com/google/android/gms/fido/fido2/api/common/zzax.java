package com.google.android.gms.fido.fido2.api.common;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public final class zzax extends Exception {
    public zzax(String str) {
        super(String.format("User verification requirement %s not supported", new Object[]{str}));
    }
}
