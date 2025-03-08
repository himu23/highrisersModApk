package com.applovin.exoplayer2.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;

public abstract class a {
    protected final C0038a tB;
    protected final f tC;
    protected c tD;
    private final int tE;

    public static final class b implements d {
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    protected interface d {
        long timeUsToTargetTime(long j);
    }

    protected interface f {

        /* renamed from: com.applovin.exoplayer2.e.a$f$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$ib(f _this) {
            }
        }

        e b(i iVar, long j) throws IOException;

        void ib();
    }

    /* access modifiers changed from: protected */
    public void b(boolean z, long j) {
    }

    public final v hS() {
        return this.tB;
    }

    public final boolean hT() {
        return this.tD != null;
    }

    protected a(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.tC = fVar;
        this.tE = i;
        this.tB = new C0038a(dVar, j, j2, j3, j4, j5, j6);
    }

    public final void ag(long j) {
        c cVar = this.tD;
        if (cVar == null || cVar.hY() != j) {
            this.tD = ah(j);
        }
    }

    public int a(i iVar, u uVar) throws IOException {
        while (true) {
            c cVar = (c) com.applovin.exoplayer2.l.a.N(this.tD);
            long b2 = cVar.hV();
            long c2 = cVar.hW();
            long d2 = cVar.hZ();
            if (c2 - b2 <= ((long) this.tE)) {
                a(false, b2);
                return a(iVar, b2, uVar);
            } else if (!a(iVar, d2)) {
                return a(iVar, d2, uVar);
            } else {
                iVar.ic();
                e b3 = this.tC.b(iVar, cVar.hX());
                int a = b3.bs;
                if (a == -3) {
                    a(false, d2);
                    return a(iVar, d2, uVar);
                } else if (a == -2) {
                    cVar.k(b3.tP, b3.tQ);
                } else if (a == -1) {
                    cVar.l(b3.tP, b3.tQ);
                } else if (a == 0) {
                    a(iVar, b3.tQ);
                    a(true, b3.tQ);
                    return a(iVar, b3.tQ, uVar);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public c ah(long j) {
        long j2 = j;
        return new c(j2, this.tB.timeUsToTargetTime(j2), this.tB.tG, this.tB.tH, this.tB.tI, this.tB.tJ, this.tB.tK);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z, long j) {
        this.tD = null;
        this.tC.ib();
        b(z, j);
    }

    /* access modifiers changed from: protected */
    public final boolean a(i iVar, long j) throws IOException {
        long ie = j - iVar.ie();
        if (ie < 0 || ie > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        iVar.bH((int) ie);
        return true;
    }

    /* access modifiers changed from: protected */
    public final int a(i iVar, long j, u uVar) {
        if (j == iVar.ie()) {
            return 0;
        }
        uVar.uc = j;
        return 1;
    }

    protected static class c {
        private long tG;
        private long tH;
        private long tI;
        private long tJ;
        private final long tK;
        private final long tL;
        private final long tM;
        private long tN;

        /* access modifiers changed from: private */
        public long hV() {
            return this.tI;
        }

        /* access modifiers changed from: private */
        public long hW() {
            return this.tJ;
        }

        /* access modifiers changed from: private */
        public long hX() {
            return this.tM;
        }

        /* access modifiers changed from: private */
        public long hY() {
            return this.tL;
        }

        /* access modifiers changed from: private */
        public long hZ() {
            return this.tN;
        }

        protected static long a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) (((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2))));
            return ai.b(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        protected c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.tL = j;
            this.tM = j2;
            this.tG = j3;
            this.tH = j4;
            this.tI = j5;
            this.tJ = j6;
            this.tK = j7;
            this.tN = a(j2, j3, j4, j5, j6, j7);
        }

        /* access modifiers changed from: private */
        public void k(long j, long j2) {
            this.tG = j;
            this.tI = j2;
            ia();
        }

        /* access modifiers changed from: private */
        public void l(long j, long j2) {
            this.tH = j;
            this.tJ = j2;
            ia();
        }

        private void ia() {
            this.tN = a(this.tM, this.tG, this.tH, this.tI, this.tJ, this.tK);
        }
    }

    public static final class e {
        public static final e tO = new e(-3, -9223372036854775807L, -1);
        /* access modifiers changed from: private */
        public final int bs;
        /* access modifiers changed from: private */
        public final long tP;
        /* access modifiers changed from: private */
        public final long tQ;

        private e(int i, long j, long j2) {
            this.bs = i;
            this.tP = j;
            this.tQ = j2;
        }

        public static e m(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e n(long j, long j2) {
            return new e(-2, j, j2);
        }

        public static e aj(long j) {
            return new e(0, -9223372036854775807L, j);
        }
    }

    /* renamed from: com.applovin.exoplayer2.e.a$a  reason: collision with other inner class name */
    public static class C0038a implements v {
        private final long fH;
        private final d tF;
        /* access modifiers changed from: private */
        public final long tG;
        /* access modifiers changed from: private */
        public final long tH;
        /* access modifiers changed from: private */
        public final long tI;
        /* access modifiers changed from: private */
        public final long tJ;
        /* access modifiers changed from: private */
        public final long tK;

        public long dd() {
            return this.fH;
        }

        public boolean hU() {
            return true;
        }

        public C0038a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.tF = dVar;
            this.fH = j;
            this.tG = j2;
            this.tH = j3;
            this.tI = j4;
            this.tJ = j5;
            this.tK = j6;
        }

        public v.a ai(long j) {
            return new v.a(new w(j, c.a(this.tF.timeUsToTargetTime(j), this.tG, this.tH, this.tI, this.tJ, this.tK)));
        }

        public long timeUsToTargetTime(long j) {
            return this.tF.timeUsToTargetTime(j);
        }
    }
}
