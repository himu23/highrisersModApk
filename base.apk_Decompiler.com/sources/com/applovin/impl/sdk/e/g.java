package com.applovin.impl.sdk.e;

import android.net.Uri;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;

public class g extends f {
    /* access modifiers changed from: private */
    public final a aTR;
    private boolean aTS;
    private boolean aTT;

    public void bg(boolean z) {
        this.aTS = z;
    }

    public void bh(boolean z) {
        this.aTT = z;
    }

    public g(a aVar, n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, nVar, appLovinAdLoadListener);
        this.aTR = aVar;
    }

    public void run() {
        super.run();
        boolean FF = this.aTR.FF();
        boolean z = this.aTT;
        if (FF || z) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Begin caching for streaming ad #" + this.aTR.getAdIdNumber() + "...");
            }
            if (((Boolean) this.sdk.a(b.aLQ)).booleanValue()) {
                K(Kl());
                ArrayList arrayList = new ArrayList();
                if (!FF) {
                    Ko();
                    b Kt = Kt();
                    if (Kt != null) {
                        arrayList.add(Kt);
                    }
                } else if (this.aTS) {
                    Ko();
                    b Kt2 = Kt();
                    if (Kt2 != null) {
                        arrayList.add(Kt2);
                    }
                    c Ks = Ks();
                    if (Ks != null) {
                        arrayList.add(Ks);
                    }
                } else {
                    b Kt3 = Kt();
                    if (Kt3 != null) {
                        K(Arrays.asList(new a[]{Kt3}));
                    }
                    Ko();
                    c Ks2 = Ks();
                    if (Ks2 != null) {
                        arrayList.add(Ks2);
                    }
                }
                K(arrayList);
                Ko();
            } else {
                Km();
                if (FF) {
                    if (this.aTS) {
                        Ko();
                    }
                    Kq();
                    if (!this.aTS) {
                        Ko();
                    }
                    Kr();
                } else {
                    Ko();
                    Kq();
                }
            }
        } else {
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str2 = this.tag;
                xVar4.f(str2, "Begin processing for non-streaming ad #" + this.aTR.getAdIdNumber() + "...");
            }
            if (((Boolean) this.sdk.a(b.aLQ)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(Kl());
                b Kt4 = Kt();
                if (Kt4 != null) {
                    arrayList2.add(Kt4);
                }
                c Ks3 = Ks();
                if (Ks3 != null) {
                    arrayList2.add(Ks3);
                }
                K(arrayList2);
                Ko();
            } else {
                Km();
                Kq();
                Kr();
                Ko();
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - this.aTR.getCreatedAtMillis();
        d.a(this.aTR, this.sdk);
        d.a(currentTimeMillis, (AppLovinAdBase) this.aTR, this.sdk);
        b(this.aTR);
        Ki();
    }

    private void Kq() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching HTML resources...");
        }
        String a = a(this.aTR.FB(), this.aTR.Gx(), (e) this.aTR);
        if (this.aTR.shouldInjectOpenMeasurementScriptDuringCaching() && this.aTR.isOpenMeasurementEnabled()) {
            a = this.sdk.Cp().dl(a);
        }
        this.aTR.cP(a);
        this.aTR.aN(true);
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            String str = this.tag;
            xVar3.f(str, "Finish caching non-video resources for ad #" + this.aTR.getAdIdNumber());
        }
        x xVar4 = this.logger;
        String str2 = this.tag;
        xVar4.C(str2, "Ad updated with cachedHTML = " + this.aTR.FB());
    }

    private void Kr() {
        Uri dr;
        if (!Kj() && (dr = dr(this.aTR.FJ())) != null) {
            if (this.aTR.Hz()) {
                this.aTR.cP(this.aTR.FB().replaceFirst(this.aTR.FE(), dr.toString()));
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Replaced video URL with cached video URI in HTML for web video ad");
                }
            }
            this.aTR.FH();
            this.aTR.j(dr);
        }
    }

    private c Ks() {
        return b(this.aTR.FJ(), new c.a() {
            public void q(Uri uri) {
                if (uri != null) {
                    if (g.this.aTR.Hz()) {
                        g.this.aTR.cP(g.this.aTR.FB().replaceFirst(g.this.aTR.FE(), uri.toString()));
                        x xVar = g.this.logger;
                        if (x.Fn()) {
                            g.this.logger.f(g.this.tag, "Replaced video URL with cached video URI in HTML for web video ad");
                        }
                    }
                    g.this.aTR.FH();
                    g.this.aTR.j(uri);
                }
            }
        });
    }

    private b Kt() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching HTML resources...");
        }
        return a(this.aTR.FB(), this.aTR.Gx(), (f.a) new f.a() {
            public void du(String str) {
                if (g.this.aTR.shouldInjectOpenMeasurementScriptDuringCaching() && g.this.aTR.isOpenMeasurementEnabled()) {
                    str = g.this.sdk.Cp().dl(str);
                }
                g.this.aTR.cP(str);
                g.this.aTR.aN(true);
                x xVar = g.this.logger;
                if (x.Fn()) {
                    x xVar2 = g.this.logger;
                    String str2 = g.this.tag;
                    xVar2.f(str2, "Finish caching non-video resources for ad #" + g.this.aTR.getAdIdNumber());
                }
                x xVar3 = g.this.logger;
                String str3 = g.this.tag;
                xVar3.C(str3, "Ad updated with cachedHTML = " + g.this.aTR.FB());
            }
        });
    }
}
