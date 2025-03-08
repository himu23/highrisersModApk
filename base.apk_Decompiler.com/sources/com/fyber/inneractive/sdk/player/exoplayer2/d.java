package com.fyber.inneractive.sdk.player.exoplayer2;

public final class d extends Exception {
    public d(int i, String str, Throwable th, int i2) {
        super((String) null, th);
    }

    public static d a(Exception exc, int i) {
        return new d(1, (String) null, exc, i);
    }
}
