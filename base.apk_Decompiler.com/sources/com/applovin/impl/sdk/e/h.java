package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.b.a;
import com.applovin.impl.b.i;
import com.applovin.impl.b.o;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class h extends f {
    /* access modifiers changed from: private */
    public final a vastAd;

    public h(a aVar, n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, nVar, appLovinAdLoadListener);
        this.vastAd = aVar;
    }

    public void run() {
        super.run();
        boolean FF = this.vastAd.FF();
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder("Begin caching for VAST ");
            sb.append(FF ? "streaming " : "");
            sb.append("ad #");
            sb.append(this.aiL.getAdIdNumber());
            sb.append("...");
            xVar2.f(str, sb.toString());
        }
        if (FF) {
            if (((Boolean) this.sdk.a(b.aLQ)).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Kl());
                arrayList.addAll(Ky());
                K(arrayList);
                if (this.vastAd.LR()) {
                    Ko();
                    ArrayList arrayList2 = new ArrayList();
                    a Kz = Kz();
                    if (Kz != null) {
                        arrayList2.add(Kz);
                    }
                    b KB = KB();
                    if (KB != null) {
                        arrayList2.add(KB);
                    }
                    c KA = KA();
                    if (KA != null) {
                        arrayList2.add(KA);
                    }
                    K(arrayList2);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    if (this.vastAd.LQ() == a.b.COMPANION_AD) {
                        a Kz2 = Kz();
                        if (Kz2 != null) {
                            arrayList3.add(Kz2);
                        }
                        b KB2 = KB();
                        if (KB2 != null) {
                            arrayList3.add(KB2);
                        }
                        K(arrayList3);
                        Ko();
                        c KA2 = KA();
                        if (KA2 != null) {
                            arrayList4.add(KA2);
                        }
                        K(arrayList4);
                    } else {
                        c KA3 = KA();
                        if (KA3 != null) {
                            arrayList3.add(KA3);
                        }
                        K(arrayList3);
                        Ko();
                        a Kz3 = Kz();
                        if (Kz3 != null) {
                            arrayList4.add(Kz3);
                        }
                        b KB3 = KB();
                        if (KB3 != null) {
                            arrayList4.add(KB3);
                        }
                        K(arrayList4);
                    }
                }
            } else {
                Km();
                Kx();
                if (this.vastAd.LR()) {
                    Ko();
                }
                if (this.vastAd.LQ() == a.b.COMPANION_AD) {
                    Ku();
                    Kw();
                } else {
                    Kv();
                }
                if (!this.vastAd.LR()) {
                    Ko();
                }
                if (this.vastAd.LQ() == a.b.COMPANION_AD) {
                    Kv();
                } else {
                    Ku();
                    Kw();
                }
            }
        } else if (((Boolean) this.sdk.a(b.aLQ)).booleanValue()) {
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(Ky());
            arrayList5.addAll(Kl());
            a Kz4 = Kz();
            if (Kz4 != null) {
                arrayList5.add(Kz4);
            }
            c KA4 = KA();
            if (KA4 != null) {
                arrayList5.add(KA4);
            }
            b KB4 = KB();
            if (KB4 != null) {
                arrayList5.add(KB4);
            }
            K(arrayList5);
            Ko();
        } else {
            Km();
            Kx();
            Ku();
            Kv();
            Kw();
            Ko();
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.f(str2, "Finished caching VAST ad #" + this.vastAd.getAdIdNumber());
        }
        long currentTimeMillis = System.currentTimeMillis() - this.vastAd.getCreatedAtMillis();
        d.a(this.vastAd, this.sdk);
        d.a(currentTimeMillis, (AppLovinAdBase) this.vastAd, this.sdk);
        b(this.vastAd);
        this.vastAd.FH();
        Ki();
    }

    private void Ku() {
        if (!Kj()) {
            if (this.vastAd.Md()) {
                com.applovin.impl.b.d LX = this.vastAd.LX();
                if (LX != null) {
                    i Mo = LX.Mo();
                    if (Mo != null) {
                        Uri MB = Mo.MB();
                        String uri = MB != null ? MB.toString() : "";
                        String MC = Mo.MC();
                        if (!URLUtil.isValidUrl(uri) && !StringUtils.isValidString(MC)) {
                            x xVar = this.logger;
                            if (x.Fn()) {
                                this.logger.h(this.tag, "Companion ad does not have any resources attached. Skipping...");
                            }
                        } else if (Mo.MA() == i.a.STATIC) {
                            x xVar2 = this.logger;
                            if (x.Fn()) {
                                x xVar3 = this.logger;
                                String str = this.tag;
                                xVar3.f(str, "Caching static companion ad at " + uri + "...");
                            }
                            Uri b = b(uri, Collections.emptyList(), false);
                            if (b != null) {
                                Mo.u(b);
                                this.vastAd.aN(true);
                                return;
                            }
                            x xVar4 = this.logger;
                            if (x.Fn()) {
                                this.logger.i(this.tag, "Failed to cache static companion ad");
                            }
                        } else if (Mo.MA() == i.a.HTML) {
                            if (StringUtils.isValidString(uri)) {
                                x xVar5 = this.logger;
                                if (x.Fn()) {
                                    x xVar6 = this.logger;
                                    String str2 = this.tag;
                                    xVar6.f(str2, "Begin caching HTML companion ad. Fetching from " + uri + "...");
                                }
                                String dt = dt(uri);
                                if (StringUtils.isValidString(dt)) {
                                    x xVar7 = this.logger;
                                    if (x.Fn()) {
                                        this.logger.f(this.tag, "HTML fetched. Caching HTML now...");
                                    }
                                    Mo.dR(a(dt, (List<String>) Collections.emptyList(), (e) this.vastAd));
                                    this.vastAd.aN(true);
                                    return;
                                }
                                x xVar8 = this.logger;
                                if (x.Fn()) {
                                    x xVar9 = this.logger;
                                    String str3 = this.tag;
                                    xVar9.i(str3, "Unable to load companion ad resources from " + uri);
                                    return;
                                }
                                return;
                            }
                            x xVar10 = this.logger;
                            if (x.Fn()) {
                                x xVar11 = this.logger;
                                String str4 = this.tag;
                                xVar11.f(str4, "Caching provided HTML for companion ad. No fetch required. HTML: " + MC);
                            }
                            if (((Boolean) this.sdk.a(b.aPJ)).booleanValue()) {
                                MC = dv(MC);
                            }
                            Mo.dR(a(MC, (List<String>) Collections.emptyList(), (e) this.vastAd));
                            this.vastAd.aN(true);
                        } else if (Mo.MA() == i.a.IFRAME) {
                            x xVar12 = this.logger;
                            if (x.Fn()) {
                                this.logger.f(this.tag, "Skip caching of iFrame resource...");
                            }
                        }
                    } else {
                        x xVar13 = this.logger;
                        if (x.Fn()) {
                            this.logger.i(this.tag, "Failed to retrieve non-video resources from companion ad. Skipping...");
                        }
                    }
                } else {
                    x xVar14 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "No companion ad provided. Skipping...");
                    }
                }
            } else {
                x xVar15 = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Companion ad caching disabled. Skipping...");
                }
            }
        }
    }

    private void Kv() {
        o LV;
        Uri FI;
        if (!Kj()) {
            if (!this.vastAd.Me()) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Video caching disabled. Skipping...");
                }
            } else if (this.vastAd.LU() != null && (LV = this.vastAd.LV()) != null && (FI = LV.FI()) != null) {
                Uri a = a(FI.toString(), (List<String>) Collections.emptyList(), false);
                if (a != null) {
                    x xVar2 = this.logger;
                    if (x.Fn()) {
                        x xVar3 = this.logger;
                        String str = this.tag;
                        xVar3.f(str, "Video file successfully cached into: " + a);
                    }
                    LV.j(a);
                    return;
                }
                x xVar4 = this.logger;
                if (x.Fn()) {
                    x xVar5 = this.logger;
                    String str2 = this.tag;
                    xVar5.i(str2, "Failed to cache video file: " + LV);
                }
            }
        }
    }

    private void Kw() {
        String str;
        if (!Kj()) {
            if (this.vastAd.Mc() != null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str2 = this.tag;
                    xVar2.f(str2, "Begin caching HTML template. Fetching from " + this.vastAd.Mc() + "...");
                }
                str = c(this.vastAd.Mc().toString(), this.vastAd.Gx());
            } else {
                str = this.vastAd.Mb();
            }
            if (StringUtils.isValidString(str)) {
                String a = a(str, this.vastAd.Gx(), this.aiL);
                if (this.vastAd.shouldInjectOpenMeasurementScriptDuringCaching() && this.vastAd.isOpenMeasurementEnabled()) {
                    a = this.sdk.Cp().dl(a);
                }
                this.vastAd.dO(a);
                x xVar3 = this.logger;
                if (x.Fn()) {
                    x xVar4 = this.logger;
                    String str3 = this.tag;
                    xVar4.f(str3, "Finish caching HTML template " + this.vastAd.Mb() + " for ad #" + this.vastAd.getAdIdNumber());
                    return;
                }
                return;
            }
            x xVar5 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Unable to load HTML template");
            }
        }
    }

    private void Kx() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching play & pause images...");
        }
        Uri c = c(this.aiL.Ht(), "play");
        if (c != null) {
            this.aiL.l(c);
        }
        Uri c2 = c(this.aiL.Hu(), "pause");
        if (c2 != null) {
            this.aiL.m(c2);
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            String str = this.tag;
            xVar3.f(str, "Ad updated with playImageFilename = " + this.aiL.Ht() + ", pauseImageFilename = " + this.aiL.Hu());
        }
    }

    private String dv(String str) {
        String str2 = str;
        for (String next : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.sdk.a(b.aPK)), 1)) {
            if (!TextUtils.isEmpty(next)) {
                if (!this.aiL.shouldCancelHtmlCachingIfShown() || !this.aiL.hasShown()) {
                    Uri b = b(next, Collections.emptyList(), false);
                    if (b != null) {
                        str2 = str2.replace(next, b.toString());
                        this.aiL.k(b);
                        this.aHi.JT();
                    } else {
                        x xVar = this.logger;
                        if (x.Fn()) {
                            x xVar2 = this.logger;
                            String str3 = this.tag;
                            xVar2.i(str3, "Failed to cache JavaScript resource: " + next);
                        }
                        this.aHi.JU();
                    }
                } else {
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "Cancelling HTML JavaScript caching due to ad being shown already");
                    }
                    this.aHi.JS();
                    return str;
                }
            }
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public List<c> Ky() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching play & pause images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiL.Ht() != null) {
            arrayList.add(a(this.aiL.Ht().toString(), new c.a() {
                public void q(Uri uri) {
                    h.this.aiL.l(uri);
                    x xVar = h.this.logger;
                    if (x.Fn()) {
                        x xVar2 = h.this.logger;
                        String str = h.this.tag;
                        xVar2.f(str, "Ad updated with playImageUri = " + uri);
                    }
                }
            }));
        }
        if (this.aiL.Hu() != null) {
            arrayList.add(a(this.aiL.Hu().toString(), new c.a() {
                public void q(Uri uri) {
                    h.this.aiL.m(uri);
                    x xVar = h.this.logger;
                    if (x.Fn()) {
                        x xVar2 = h.this.logger;
                        String str = h.this.tag;
                        xVar2.f(str, "Ad updated with pauseImageUri = " + uri);
                    }
                }
            }));
        }
        return arrayList;
    }

    private a Kz() {
        if (!this.vastAd.Md()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        com.applovin.impl.b.d LX = this.vastAd.LX();
        if (LX == null) {
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "No companion ad provided. Skipping...");
            }
            return null;
        }
        final i Mo = LX.Mo();
        if (Mo == null) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri MB = Mo.MB();
        String uri = MB != null ? MB.toString() : "";
        String MC = Mo.MC();
        if (!URLUtil.isValidUrl(uri) && !StringUtils.isValidString(MC)) {
            x xVar4 = this.logger;
            if (x.Fn()) {
                this.logger.h(this.tag, "Companion ad does not have any resources attached. Skipping...");
            }
        } else if (Mo.MA() == i.a.STATIC) {
            x xVar5 = this.logger;
            if (x.Fn()) {
                x xVar6 = this.logger;
                String str = this.tag;
                xVar6.f(str, "Caching static companion ad at " + uri + "...");
            }
            return new c(uri, this.vastAd, Collections.emptyList(), false, this.aHi, this.sdk, new c.a() {
                public void q(Uri uri) {
                    if (uri != null) {
                        Mo.u(uri);
                        h.this.vastAd.aN(true);
                        return;
                    }
                    x xVar = h.this.logger;
                    if (x.Fn()) {
                        h.this.logger.i(h.this.tag, "Failed to cache static companion ad");
                    }
                }
            });
        } else if (Mo.MA() == i.a.HTML) {
            if (StringUtils.isValidString(uri)) {
                x xVar7 = this.logger;
                if (x.Fn()) {
                    x xVar8 = this.logger;
                    String str2 = this.tag;
                    xVar8.f(str2, "Begin caching HTML companion ad. Fetching from " + uri + "...");
                }
                String dt = dt(uri);
                if (StringUtils.isValidString(dt)) {
                    x xVar9 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "HTML fetched. Caching HTML now...");
                    }
                    return a(dt, (List<String>) Collections.emptyList(), (f.a) new f.a() {
                        public void du(String str) {
                            Mo.dR(str);
                            h.this.vastAd.aN(true);
                        }
                    });
                }
                x xVar10 = this.logger;
                if (x.Fn()) {
                    x xVar11 = this.logger;
                    String str3 = this.tag;
                    xVar11.i(str3, "Unable to load companion ad resources from " + uri);
                }
            } else {
                x xVar12 = this.logger;
                if (x.Fn()) {
                    x xVar13 = this.logger;
                    String str4 = this.tag;
                    xVar13.f(str4, "Caching provided HTML for companion ad. No fetch required. HTML: " + MC);
                }
                return a(MC, (List<String>) Collections.emptyList(), (f.a) new f.a() {
                    public void du(String str) {
                        Mo.dR(str);
                        h.this.vastAd.aN(true);
                    }
                });
            }
        } else if (Mo.MA() == i.a.IFRAME) {
            x xVar14 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Skip caching of iFrame resource...");
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0 = r6.vastAd.LV();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.impl.sdk.e.c KA() {
        /*
            r6 = this;
            com.applovin.impl.b.a r0 = r6.vastAd
            boolean r0 = r0.Me()
            r1 = 0
            if (r0 != 0) goto L_0x001b
            com.applovin.impl.sdk.x r0 = r6.logger
            boolean r0 = com.applovin.impl.sdk.x.Fn()
            if (r0 == 0) goto L_0x001a
            com.applovin.impl.sdk.x r0 = r6.logger
            java.lang.String r2 = r6.tag
            java.lang.String r3 = "Video caching disabled. Skipping..."
            r0.f(r2, r3)
        L_0x001a:
            return r1
        L_0x001b:
            com.applovin.impl.b.a r0 = r6.vastAd
            com.applovin.impl.b.n r0 = r0.LU()
            if (r0 != 0) goto L_0x0024
            return r1
        L_0x0024:
            com.applovin.impl.b.a r0 = r6.vastAd
            com.applovin.impl.b.o r0 = r0.LV()
            if (r0 != 0) goto L_0x002d
            return r1
        L_0x002d:
            android.net.Uri r2 = r0.FI()
            if (r2 != 0) goto L_0x0034
            return r1
        L_0x0034:
            com.applovin.impl.sdk.x r1 = r6.logger
            boolean r1 = com.applovin.impl.sdk.x.Fn()
            if (r1 == 0) goto L_0x0056
            com.applovin.impl.sdk.x r1 = r6.logger
            java.lang.String r3 = r6.tag
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Caching video file "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r5 = " creative..."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.f(r3, r4)
        L_0x0056:
            java.lang.String r1 = r2.toString()
            java.util.List r2 = java.util.Collections.emptyList()
            com.applovin.impl.sdk.e.h$6 r3 = new com.applovin.impl.sdk.e.h$6
            r3.<init>(r0)
            r0 = 0
            com.applovin.impl.sdk.e.c r0 = r6.a(r1, r2, r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.h.KA():com.applovin.impl.sdk.e.c");
    }

    /* access modifiers changed from: protected */
    public b KB() {
        if (!TextUtils.isEmpty(this.vastAd.Mb())) {
            return a(this.vastAd.Mb(), this.vastAd.Gx(), (f.a) new f.a() {
                public void du(String str) {
                    if (h.this.vastAd.shouldInjectOpenMeasurementScriptDuringCaching() && h.this.vastAd.isOpenMeasurementEnabled()) {
                        str = h.this.sdk.Cp().dl(str);
                    }
                    h.this.vastAd.dO(str);
                    x xVar = h.this.logger;
                    if (x.Fn()) {
                        x xVar2 = h.this.logger;
                        String str2 = h.this.tag;
                        xVar2.f(str2, "Finish caching HTML template " + h.this.vastAd.Mb() + " for ad #" + h.this.vastAd.getAdIdNumber());
                    }
                }
            });
        }
        x xVar = this.logger;
        if (!x.Fn()) {
            return null;
        }
        this.logger.f(this.tag, "Unable to load HTML template");
        return null;
    }

    /* access modifiers changed from: package-private */
    public void Ko() {
        this.vastAd.getAdEventTracker().IK();
        super.Ko();
    }

    /* access modifiers changed from: package-private */
    public void Kn() {
        this.vastAd.getAdEventTracker().IM();
        super.Kn();
    }
}
