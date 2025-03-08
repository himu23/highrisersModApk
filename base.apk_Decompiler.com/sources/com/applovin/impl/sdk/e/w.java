package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinErrorCodes;
import com.ironsource.i9;
import java.util.concurrent.TimeUnit;

public abstract class w<T> extends d implements b.d<T> {
    /* access modifiers changed from: private */
    public final c<T> aHl;
    protected b.a aHv;
    /* access modifiers changed from: private */
    public q.b aUY;
    /* access modifiers changed from: private */
    public com.applovin.impl.sdk.c.b<String> aUZ;
    /* access modifiers changed from: private */
    public com.applovin.impl.sdk.c.b<String> aVa;
    private final b.d<T> apS;

    public abstract void a(int i, String str, T t);

    public void a(q.b bVar) {
        this.aUY = bVar;
    }

    public abstract void d(T t, int i);

    public void e(com.applovin.impl.sdk.c.b<String> bVar) {
        this.aUZ = bVar;
    }

    public void f(com.applovin.impl.sdk.c.b<String> bVar) {
        this.aVa = bVar;
    }

    public w(c<T> cVar, n nVar) {
        this(cVar, nVar, false);
    }

    public w(c<T> cVar, final n nVar, boolean z) {
        super("TaskRepeatRequest", nVar, z);
        this.aUY = q.b.BACKGROUND;
        this.aUZ = null;
        this.aVa = null;
        if (cVar != null) {
            dq(cVar.zL());
            this.aHl = cVar;
            this.aHv = new b.a();
            this.apS = new b.d<T>() {
                public void d(T t, int i) {
                    w.this.aHl.gD(0);
                    w.this.d(t, i);
                }

                public void a(int i, String str, T t) {
                    long j;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if ((i == -1009 && !w.this.aHl.Ib()) || (!z2 && !z3 && !w.this.aHl.Ia())) {
                        w.this.a(i, str, t);
                        return;
                    }
                    String HT = w.this.aHl.HT();
                    if (w.this.aHl.HV() > 0) {
                        x xVar = w.this.logger;
                        if (x.Fn()) {
                            x xVar2 = w.this.logger;
                            String str2 = w.this.tag;
                            xVar2.h(str2, "Unable to send request due to server failure (code " + i + "). " + w.this.aHl.HV() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds((long) w.this.aHl.HY()) + " seconds...");
                        }
                        int HV = w.this.aHl.HV() - 1;
                        w.this.aHl.gD(HV);
                        if ((((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aKI)).booleanValue() && w.this.aHl.zL().endsWith("4.0/ad")) || HV == 0) {
                            w wVar = w.this;
                            wVar.g(wVar.aUZ);
                            if (StringUtils.isValidString(HT) && HT.length() >= 4) {
                                x xVar3 = w.this.logger;
                                if (x.Fn()) {
                                    x xVar4 = w.this.logger;
                                    String str3 = w.this.tag;
                                    xVar4.g(str3, "Switching to backup endpoint " + HT);
                                }
                                w.this.aHl.cU(HT);
                                z = true;
                            }
                        }
                        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNZ)).booleanValue() && z) {
                            j = 0;
                        } else if (w.this.aHl.HZ()) {
                            j = TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, (double) w.this.aHl.HW()));
                        } else {
                            j = (long) w.this.aHl.HY();
                        }
                        q BO = nVar.BO();
                        w wVar2 = w.this;
                        BO.a((d) wVar2, wVar2.aUY, j);
                        return;
                    }
                    if (HT == null || !HT.equals(w.this.aHl.zL())) {
                        w wVar3 = w.this;
                        wVar3.g(wVar3.aUZ);
                    } else {
                        w wVar4 = w.this;
                        wVar4.g(wVar4.aVa);
                    }
                    w.this.a(i, str, t);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    public void run() {
        b BQ = getSdk().BQ();
        if (!getSdk().Bp() && !getSdk().isEnabled()) {
            x.H("AppLovinSdk", "AppLovin SDK is disabled");
            a(-22, (String) null, (Object) null);
        } else if (!StringUtils.isValidString(this.aHl.zL()) || this.aHl.zL().length() < 4) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Task has an invalid or null request endpoint.");
            }
            a(AppLovinErrorCodes.INVALID_URL, (String) null, (Object) null);
        } else {
            if (TextUtils.isEmpty(this.aHl.HQ())) {
                this.aHl.cV(this.aHl.vS() != null ? i9.b : i9.a);
            }
            BQ.a(this.aHl, this.aHv, this.apS);
        }
    }

    /* access modifiers changed from: private */
    public <ST> void g(com.applovin.impl.sdk.c.b<ST> bVar) {
        if (bVar != null) {
            getSdk().BP().a((com.applovin.impl.sdk.c.b<?>) bVar, (Object) bVar.JD());
        }
    }
}
