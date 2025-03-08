package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface f {
    public static final ByteBuffer jO = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void Y();

    a a(a aVar) throws b;

    boolean cR();

    void d(ByteBuffer byteBuffer);

    void dG();

    ByteBuffer dH();

    void dI();

    boolean isActive();

    public static final class a {
        public static final a jP = new a(-1, -1, -1);
        public final int dL;
        public final int dM;
        public final int jQ;
        public final int jR;

        public a(int i, int i2, int i3) {
            this.dM = i;
            this.dL = i2;
            this.jQ = i3;
            this.jR = ai.fJ(i3) ? ai.P(i3, i2) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.dM + ", channelCount=" + this.dL + ", encoding=" + this.jQ + ']';
        }
    }

    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }
}
