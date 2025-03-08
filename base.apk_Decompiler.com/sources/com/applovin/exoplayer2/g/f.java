package com.applovin.exoplayer2.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.e;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class f extends e implements Handler.Callback {
    private boolean IF;
    private boolean IG;
    private final c Jb;
    private final e Jc;
    private final Handler Jd;
    private final d Je;
    private b Jf;
    private long Jg;
    private a Jh;
    private long dD;

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) {
        this.Jh = null;
        this.Jg = -9223372036854775807L;
        this.IF = false;
        this.IG = false;
    }

    /* access modifiers changed from: protected */
    public void ac() {
        this.Jh = null;
        this.Jg = -9223372036854775807L;
        this.Jf = null;
    }

    public boolean cR() {
        return this.IG;
    }

    public String getName() {
        return "MetadataRenderer";
    }

    public boolean isReady() {
        return true;
    }

    public f(e eVar, Looper looper) {
        this(eVar, looper, c.Ja);
    }

    public f(e eVar, Looper looper, c cVar) {
        super(5);
        Handler handler;
        this.Jc = (e) a.checkNotNull(eVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = ai.b(looper, (Handler.Callback) this);
        }
        this.Jd = handler;
        this.Jb = (c) a.checkNotNull(cVar);
        this.Je = new d();
        this.Jg = -9223372036854775807L;
    }

    public int b(v vVar) {
        if (!this.Jb.d(vVar)) {
            return as.CC.ae(0);
        }
        return as.CC.ae(vVar.dR == 0 ? 4 : 2);
    }

    /* access modifiers changed from: protected */
    public void a(v[] vVarArr, long j, long j2) {
        this.Jf = this.Jb.s(vVarArr[0]);
    }

    public void g(long j, long j2) {
        boolean z = true;
        while (z) {
            kG();
            z = aP(j);
        }
    }

    private void a(a aVar, List<a.C0047a> list) {
        for (int i = 0; i < aVar.kD(); i++) {
            v kE = aVar.de(i).kE();
            if (kE == null || !this.Jb.d(kE)) {
                list.add(aVar.de(i));
            } else {
                b s = this.Jb.s(kE);
                byte[] bArr = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar.de(i).kF());
                this.Je.clear();
                this.Je.by(bArr.length);
                ((ByteBuffer) ai.R(this.Je.rH)).put(bArr);
                this.Je.hh();
                a a = s.a(this.Je);
                if (a != null) {
                    a(a, list);
                }
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            i((a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void kG() {
        if (!this.IF && this.Jh == null) {
            this.Je.clear();
            w ae = ae();
            int a = a(ae, (g) this.Je, 0);
            if (a == -4) {
                if (this.Je.gY()) {
                    this.IF = true;
                    return;
                }
                this.Je.dD = this.dD;
                this.Je.hh();
                a a2 = ((b) ai.R(this.Jf)).a(this.Je);
                if (a2 != null) {
                    ArrayList arrayList = new ArrayList(a2.kD());
                    a(a2, (List<a.C0047a>) arrayList);
                    if (!arrayList.isEmpty()) {
                        this.Jh = new a((List<? extends a.C0047a>) arrayList);
                        this.Jg = this.Je.rJ;
                    }
                }
            } else if (a == -5) {
                this.dD = ((v) com.applovin.exoplayer2.l.a.checkNotNull(ae.dU)).dD;
            }
        }
    }

    private boolean aP(long j) {
        boolean z;
        a aVar = this.Jh;
        if (aVar == null || this.Jg > j) {
            z = false;
        } else {
            h(aVar);
            this.Jh = null;
            this.Jg = -9223372036854775807L;
            z = true;
        }
        if (this.IF && this.Jh == null) {
            this.IG = true;
        }
        return z;
    }

    private void h(a aVar) {
        Handler handler = this.Jd;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            i(aVar);
        }
    }

    private void i(a aVar) {
        this.Jc.a(aVar);
    }
}
