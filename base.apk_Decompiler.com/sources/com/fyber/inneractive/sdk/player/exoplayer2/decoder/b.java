package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import java.nio.ByteBuffer;

public class b {
    public int a;
    public final a b = new a();
    public ByteBuffer c;
    public long d;
    public final int e;

    public b(int i) {
        this.e = i;
    }

    public static b b() {
        return new b(0);
    }

    public final boolean b(int i) {
        return (this.a & i) == i;
    }

    public void a() {
        this.a = 0;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final ByteBuffer a(int i) {
        int i2;
        int i3 = this.e;
        if (i3 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            i2 = 0;
        } else {
            i2 = byteBuffer.capacity();
        }
        throw new IllegalStateException("Buffer too small (" + i2 + " < " + i + ")");
    }
}
