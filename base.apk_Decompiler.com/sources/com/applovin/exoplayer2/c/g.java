package com.applovin.exoplayer2.c;

import java.nio.ByteBuffer;

public class g extends a {
    private final int mQ;
    public final c rG;
    public ByteBuffer rH;
    public boolean rI;
    public long rJ;
    public ByteBuffer rK;
    private final int rL;

    public static final class a extends IllegalStateException {
        public final int rM;
        public final int rN;

        public a(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + ")");
            this.rM = i;
            this.rN = i2;
        }
    }

    public static g hf() {
        return new g(0);
    }

    public g(int i) {
        this(i, 0);
    }

    public g(int i, int i2) {
        this.rG = new c();
        this.rL = i;
        this.mQ = i2;
    }

    public void bx(int i) {
        ByteBuffer byteBuffer = this.rK;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.rK = ByteBuffer.allocate(i);
        } else {
            this.rK.clear();
        }
    }

    public void by(int i) {
        int i2 = i + this.mQ;
        ByteBuffer byteBuffer = this.rH;
        if (byteBuffer == null) {
            this.rH = bz(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            this.rH = byteBuffer;
            return;
        }
        ByteBuffer bz = bz(i3);
        bz.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            bz.put(byteBuffer);
        }
        this.rH = bz;
    }

    public final boolean hg() {
        return bv(1073741824);
    }

    public final void hh() {
        ByteBuffer byteBuffer = this.rH;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.rK;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.rH;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.rK;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.rI = false;
    }

    private ByteBuffer bz(int i) {
        int i2;
        int i3 = this.rL;
        if (i3 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.rH;
        if (byteBuffer == null) {
            i2 = 0;
        } else {
            i2 = byteBuffer.capacity();
        }
        throw new a(i2, i);
    }
}
