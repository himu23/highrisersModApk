package com.applovin.exoplayer2.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.e;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import java.util.Collections;
import java.util.List;

public final class m extends e implements Handler.Callback {
    private boolean IF;
    private boolean IG;
    private final Handler Jd;
    private g OA;
    private j OB;
    private k OC;
    private k OD;
    private int OE;
    private long OF;
    private final l Ov;
    private final i Ow;
    private boolean Ox;
    private int Oy;
    private v Oz;
    private final w W;

    public boolean cR() {
        return this.IG;
    }

    public String getName() {
        return "TextRenderer";
    }

    public boolean isReady() {
        return true;
    }

    public m(l lVar, Looper looper) {
        this(lVar, looper, i.Ot);
    }

    public m(l lVar, Looper looper, i iVar) {
        super(3);
        Handler handler;
        this.Ov = (l) a.checkNotNull(lVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = ai.b(looper, (Handler.Callback) this);
        }
        this.Jd = handler;
        this.Ow = iVar;
        this.W = new w();
        this.OF = -9223372036854775807L;
    }

    public int b(v vVar) {
        if (this.Ow.d(vVar)) {
            return as.CC.ae(vVar.dR == 0 ? 4 : 2);
        } else if (u.aY(vVar.dz)) {
            return as.CC.ae(1);
        } else {
            return as.CC.ae(0);
        }
    }

    public void bg(long j) {
        a.checkState(U());
        this.OF = j;
    }

    /* access modifiers changed from: protected */
    public void a(v[] vVarArr, long j, long j2) {
        this.Oz = vVarArr[0];
        if (this.OA != null) {
            this.Oy = 1;
        } else {
            mc();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) {
        mf();
        this.IF = false;
        this.IG = false;
        this.OF = -9223372036854775807L;
        if (this.Oy != 0) {
            md();
            return;
        }
        ma();
        ((g) a.checkNotNull(this.OA)).dI();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
        if (r11 != false) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(long r9, long r11) {
        /*
            r8 = this;
            boolean r11 = r8.U()
            r12 = 1
            if (r11 == 0) goto L_0x001b
            long r0 = r8.OF
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x001b
            int r11 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x001b
            r8.ma()
            r8.IG = r12
        L_0x001b:
            boolean r11 = r8.IG
            if (r11 == 0) goto L_0x0020
            return
        L_0x0020:
            com.applovin.exoplayer2.i.k r11 = r8.OD
            if (r11 != 0) goto L_0x0045
            com.applovin.exoplayer2.i.g r11 = r8.OA
            java.lang.Object r11 = com.applovin.exoplayer2.l.a.checkNotNull(r11)
            com.applovin.exoplayer2.i.g r11 = (com.applovin.exoplayer2.i.g) r11
            r11.bd(r9)
            com.applovin.exoplayer2.i.g r11 = r8.OA     // Catch:{ h -> 0x0040 }
            java.lang.Object r11 = com.applovin.exoplayer2.l.a.checkNotNull(r11)     // Catch:{ h -> 0x0040 }
            com.applovin.exoplayer2.i.g r11 = (com.applovin.exoplayer2.i.g) r11     // Catch:{ h -> 0x0040 }
            java.lang.Object r11 = r11.hd()     // Catch:{ h -> 0x0040 }
            com.applovin.exoplayer2.i.k r11 = (com.applovin.exoplayer2.i.k) r11     // Catch:{ h -> 0x0040 }
            r8.OD = r11     // Catch:{ h -> 0x0040 }
            goto L_0x0045
        L_0x0040:
            r9 = move-exception
            r8.a(r9)
            return
        L_0x0045:
            int r11 = r8.P()
            r0 = 2
            if (r11 == r0) goto L_0x004d
            return
        L_0x004d:
            com.applovin.exoplayer2.i.k r11 = r8.OC
            r1 = 0
            if (r11 == 0) goto L_0x0066
            long r2 = r8.me()
            r11 = 0
        L_0x0057:
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x0067
            int r11 = r8.OE
            int r11 = r11 + r12
            r8.OE = r11
            long r2 = r8.me()
            r11 = 1
            goto L_0x0057
        L_0x0066:
            r11 = 0
        L_0x0067:
            com.applovin.exoplayer2.i.k r2 = r8.OD
            r3 = 0
            if (r2 == 0) goto L_0x00a7
            boolean r4 = r2.gY()
            if (r4 == 0) goto L_0x008f
            if (r11 != 0) goto L_0x00a7
            long r4 = r8.me()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00a7
            int r2 = r8.Oy
            if (r2 != r0) goto L_0x0089
            r8.md()
            goto L_0x00a7
        L_0x0089:
            r8.ma()
            r8.IG = r12
            goto L_0x00a7
        L_0x008f:
            long r4 = r2.rJ
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x00a7
            com.applovin.exoplayer2.i.k r11 = r8.OC
            if (r11 == 0) goto L_0x009c
            r11.release()
        L_0x009c:
            int r11 = r2.be(r9)
            r8.OE = r11
            r8.OC = r2
            r8.OD = r3
            goto L_0x00a9
        L_0x00a7:
            if (r11 == 0) goto L_0x00b7
        L_0x00a9:
            com.applovin.exoplayer2.i.k r11 = r8.OC
            com.applovin.exoplayer2.l.a.checkNotNull(r11)
            com.applovin.exoplayer2.i.k r11 = r8.OC
            java.util.List r9 = r11.bf(r9)
            r8.k(r9)
        L_0x00b7:
            int r9 = r8.Oy
            if (r9 != r0) goto L_0x00bc
            return
        L_0x00bc:
            boolean r9 = r8.IF     // Catch:{ h -> 0x0131 }
            if (r9 != 0) goto L_0x0135
            com.applovin.exoplayer2.i.j r9 = r8.OB     // Catch:{ h -> 0x0131 }
            if (r9 != 0) goto L_0x00d7
            com.applovin.exoplayer2.i.g r9 = r8.OA     // Catch:{ h -> 0x0131 }
            java.lang.Object r9 = com.applovin.exoplayer2.l.a.checkNotNull(r9)     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.i.g r9 = (com.applovin.exoplayer2.i.g) r9     // Catch:{ h -> 0x0131 }
            java.lang.Object r9 = r9.hc()     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.i.j r9 = (com.applovin.exoplayer2.i.j) r9     // Catch:{ h -> 0x0131 }
            if (r9 != 0) goto L_0x00d5
            return
        L_0x00d5:
            r8.OB = r9     // Catch:{ h -> 0x0131 }
        L_0x00d7:
            int r10 = r8.Oy     // Catch:{ h -> 0x0131 }
            if (r10 != r12) goto L_0x00ef
            r10 = 4
            r9.bs(r10)     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.i.g r10 = r8.OA     // Catch:{ h -> 0x0131 }
            java.lang.Object r10 = com.applovin.exoplayer2.l.a.checkNotNull(r10)     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.i.g r10 = (com.applovin.exoplayer2.i.g) r10     // Catch:{ h -> 0x0131 }
            r10.D(r9)     // Catch:{ h -> 0x0131 }
            r8.OB = r3     // Catch:{ h -> 0x0131 }
            r8.Oy = r0     // Catch:{ h -> 0x0131 }
            return
        L_0x00ef:
            com.applovin.exoplayer2.w r10 = r8.W     // Catch:{ h -> 0x0131 }
            int r10 = r8.a((com.applovin.exoplayer2.w) r10, (com.applovin.exoplayer2.c.g) r9, (int) r1)     // Catch:{ h -> 0x0131 }
            r11 = -4
            if (r10 != r11) goto L_0x012d
            boolean r10 = r9.gY()     // Catch:{ h -> 0x0131 }
            if (r10 == 0) goto L_0x0103
            r8.IF = r12     // Catch:{ h -> 0x0131 }
            r8.Ox = r1     // Catch:{ h -> 0x0131 }
            goto L_0x011b
        L_0x0103:
            com.applovin.exoplayer2.w r10 = r8.W     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.v r10 = r10.dU     // Catch:{ h -> 0x0131 }
            if (r10 != 0) goto L_0x010a
            return
        L_0x010a:
            long r10 = r10.dD     // Catch:{ h -> 0x0131 }
            r9.dD = r10     // Catch:{ h -> 0x0131 }
            r9.hh()     // Catch:{ h -> 0x0131 }
            boolean r10 = r8.Ox     // Catch:{ h -> 0x0131 }
            boolean r11 = r9.gZ()     // Catch:{ h -> 0x0131 }
            r11 = r11 ^ r12
            r10 = r10 & r11
            r8.Ox = r10     // Catch:{ h -> 0x0131 }
        L_0x011b:
            boolean r10 = r8.Ox     // Catch:{ h -> 0x0131 }
            if (r10 != 0) goto L_0x00bc
            com.applovin.exoplayer2.i.g r10 = r8.OA     // Catch:{ h -> 0x0131 }
            java.lang.Object r10 = com.applovin.exoplayer2.l.a.checkNotNull(r10)     // Catch:{ h -> 0x0131 }
            com.applovin.exoplayer2.i.g r10 = (com.applovin.exoplayer2.i.g) r10     // Catch:{ h -> 0x0131 }
            r10.D(r9)     // Catch:{ h -> 0x0131 }
            r8.OB = r3     // Catch:{ h -> 0x0131 }
            goto L_0x00bc
        L_0x012d:
            r9 = -3
            if (r10 != r9) goto L_0x00bc
            return
        L_0x0131:
            r9 = move-exception
            r8.a(r9)
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.m.g(long, long):void");
    }

    /* access modifiers changed from: protected */
    public void ac() {
        this.Oz = null;
        this.OF = -9223372036854775807L;
        mf();
        mb();
    }

    private void ma() {
        this.OB = null;
        this.OE = -1;
        k kVar = this.OC;
        if (kVar != null) {
            kVar.release();
            this.OC = null;
        }
        k kVar2 = this.OD;
        if (kVar2 != null) {
            kVar2.release();
            this.OD = null;
        }
    }

    private void mb() {
        ma();
        ((g) a.checkNotNull(this.OA)).release();
        this.OA = null;
        this.Oy = 0;
    }

    private void mc() {
        this.Ox = true;
        this.OA = this.Ow.x((v) a.checkNotNull(this.Oz));
    }

    private void md() {
        mb();
        mc();
    }

    private long me() {
        if (this.OE == -1) {
            return Long.MAX_VALUE;
        }
        a.checkNotNull(this.OC);
        if (this.OE >= this.OC.lX()) {
            return Long.MAX_VALUE;
        }
        return this.OC.ej(this.OE);
    }

    private void k(List<a> list) {
        Handler handler = this.Jd;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            l(list);
        }
    }

    private void mf() {
        k(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            l((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void l(List<a> list) {
        this.Ov.e(list);
    }

    private void a(h hVar) {
        q.c("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.Oz, hVar);
        mf();
        md();
    }
}
