package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.v;
import java.nio.ByteBuffer;

public interface h {

    public interface c {

        /* renamed from: com.applovin.exoplayer2.b.h$c$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$E(c _this, long j) {
            }

            public static void $default$F(c _this, long j) {
            }

            public static void $default$b(c _this, Exception exc) {
            }

            public static void $default$dR(c _this) {
            }
        }

        void A(boolean z);

        void E(long j);

        void F(long j);

        void b(Exception exc);

        void dQ();

        void dR();

        void e(int i, long j, long j2);
    }

    long F(boolean z);

    void G(boolean z);

    void Y();

    void a(am amVar);

    void a(d dVar);

    void a(c cVar);

    void a(k kVar);

    void a(v vVar, int i, int[] iArr) throws a;

    boolean a(ByteBuffer byteBuffer, long j, int i) throws b, e;

    am av();

    void aw(int i);

    boolean cR();

    boolean d(v vVar);

    void dI();

    void dJ();

    void dK();

    void dL() throws e;

    boolean dM();

    void dN();

    void dO();

    void dP();

    int e(v vVar);

    void h(float f);

    void pause();

    public static final class a extends Exception {
        public final v dU;

        public a(Throwable th, v vVar) {
            super(th);
            this.dU = vVar;
        }

        public a(String str, v vVar) {
            super(str);
            this.dU = vVar;
        }
    }

    public static final class b extends Exception {
        public final boolean by;
        public final v dU;
        public final int jU;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(int r3, int r4, int r5, int r6, com.applovin.exoplayer2.v r7, boolean r8, java.lang.Exception r9) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "AudioTrack init failed "
                r0.<init>(r1)
                r0.append(r3)
                java.lang.String r1 = " Config("
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = ", "
                r0.append(r4)
                r0.append(r5)
                r0.append(r4)
                r0.append(r6)
                java.lang.String r4 = ")"
                r0.append(r4)
                if (r8 == 0) goto L_0x002a
                java.lang.String r4 = " (recoverable)"
                goto L_0x002c
            L_0x002a:
                java.lang.String r4 = ""
            L_0x002c:
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4, r9)
                r2.jU = r3
                r2.by = r8
                r2.dU = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.b.h.b.<init>(int, int, int, int, com.applovin.exoplayer2.v, boolean, java.lang.Exception):void");
        }
    }

    public static final class e extends Exception {
        public final boolean by;
        public final v dU;
        public final int errorCode;

        public e(int i, v vVar, boolean z) {
            super("AudioTrack write failed: " + i);
            this.by = z;
            this.errorCode = i;
            this.dU = vVar;
        }
    }

    public static final class d extends Exception {
        public final long jV;
        public final long jW;

        public d(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.jV = j;
            this.jW = j2;
        }
    }
}
