package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.o;
import com.applovin.impl.adview.p;
import com.applovin.impl.adview.q;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements AppLovinBroadcastManager.Receiver, b.a, u.a {
    private final Handler acG = new Handler(Looper.getMainLooper());
    protected AppLovinAdDisplayListener agA;
    protected AppLovinAdClickListener agC;
    protected AppLovinAdVideoPlaybackListener agR;
    protected final d agj;
    protected v agn;
    protected Activity ahM;
    protected final e aiL;
    private final com.applovin.impl.sdk.utils.a aiO;
    private final i.a aiP;
    protected AppLovinAdView aiQ;
    protected final n aiR;
    protected final n aiS;
    /* access modifiers changed from: private */
    public final AtomicBoolean aiT = new AtomicBoolean();
    private long aiU;
    protected long aiV = -1;
    protected long aiW;
    private boolean aiX;
    protected boolean aiY;
    protected int aiZ;
    protected boolean aja;
    /* access modifiers changed from: private */
    public int ajb = 0;
    /* access modifiers changed from: private */
    public final ArrayList<Long> ajc = new ArrayList<>();
    protected int ajd = 0;
    protected int aje = 0;
    protected int ajf = i.aAb;
    protected boolean ajg;
    protected final com.applovin.impl.sdk.b.b ajh;
    protected r aji;
    private final j ajj;
    private boolean ajk = false;
    protected final x logger;
    protected final com.applovin.impl.sdk.n sdk;
    protected final long startTimeMillis = SystemClock.elapsedRealtime();
    private final AtomicBoolean videoEndListenerNotified = new AtomicBoolean();

    /* renamed from: com.applovin.impl.adview.activity.b.a$a  reason: collision with other inner class name */
    public interface C0062a {
        void a(a aVar);

        void a(String str, Throwable th);
    }

    public abstract void a(ViewGroup viewGroup);

    public abstract void bE(long j);

    public abstract void pauseVideo();

    public abstract void sA();

    public boolean sB() {
        return this.aiX;
    }

    /* access modifiers changed from: protected */
    public abstract void sD();

    /* access modifiers changed from: protected */
    public abstract boolean sI();

    /* access modifiers changed from: protected */
    public abstract boolean sJ();

    /* access modifiers changed from: protected */
    public abstract void sL();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ajb;
        aVar.ajb = i + 1;
        return i;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.applovin.impl.adview.activity.b.a] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.applovin.impl.adview.activity.b.b] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v29, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.applovin.impl.adview.activity.b.e] */
    /* JADX WARNING: type inference failed for: r1v31, types: [com.applovin.impl.adview.activity.b.g] */
    /* JADX WARNING: type inference failed for: r1v32, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v33, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v34, types: [com.applovin.impl.adview.activity.b.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.applovin.impl.sdk.ad.e r16, com.applovin.sdk.AppLovinAdClickListener r17, com.applovin.sdk.AppLovinAdDisplayListener r18, com.applovin.sdk.AppLovinAdVideoPlaybackListener r19, java.util.Map<java.lang.String, java.lang.Object> r20, com.applovin.impl.sdk.n r21, android.app.Activity r22, com.applovin.impl.adview.activity.b.a.C0062a r23) {
        /*
            r9 = r21
            r10 = r23
            boolean r0 = r16.Hx()
            r11 = r16
            boolean r1 = r11 instanceof com.applovin.impl.b.a
            java.lang.String r12 = "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter."
            java.lang.String r13 = "AppLovinFullscreenActivity"
            java.lang.String r14 = " and throwable: "
            if (r1 == 0) goto L_0x00a1
            java.lang.String r15 = "Failed to create FullscreenVastVideoAdPresenter with sdk: "
            if (r0 == 0) goto L_0x0070
            com.applovin.impl.adview.activity.b.c r0 = new com.applovin.impl.adview.activity.b.c     // Catch:{ all -> 0x002e }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x002e }
            goto L_0x0181
        L_0x002e:
            r0 = move-exception
            r21.BN()
            boolean r1 = com.applovin.impl.sdk.x.Fn()
            if (r1 == 0) goto L_0x003f
            com.applovin.impl.sdk.x r1 = r21.BN()
            r1.b((java.lang.String) r13, (java.lang.String) r12, (java.lang.Throwable) r0)
        L_0x003f:
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x0055 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0055 }
            goto L_0x0181
        L_0x0055:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        L_0x0070:
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x0086 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0086 }
            goto L_0x0181
        L_0x0086:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        L_0x00a1:
            boolean r1 = r16.hasVideoUrl()
            if (r1 == 0) goto L_0x016d
            boolean r1 = r16.Hz()
            if (r1 == 0) goto L_0x00e0
            com.applovin.impl.adview.activity.b.g r0 = new com.applovin.impl.adview.activity.b.g     // Catch:{ all -> 0x00c3 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00c3 }
            goto L_0x0181
        L_0x00c3:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenWebVideoAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        L_0x00e0:
            if (r0 == 0) goto L_0x013b
            com.applovin.impl.adview.activity.b.e r0 = new com.applovin.impl.adview.activity.b.e     // Catch:{ all -> 0x00f8 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00f8 }
            goto L_0x0181
        L_0x00f8:
            r0 = move-exception
            r21.BN()
            boolean r1 = com.applovin.impl.sdk.x.Fn()
            if (r1 == 0) goto L_0x0109
            com.applovin.impl.sdk.x r1 = r21.BN()
            r1.b((java.lang.String) r13, (java.lang.String) r12, (java.lang.Throwable) r0)
        L_0x0109:
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x011e }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x011e }
            goto L_0x0181
        L_0x011e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        L_0x013b:
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x0150 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0150 }
            goto L_0x0181
        L_0x0150:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenVideoAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        L_0x016d:
            com.applovin.impl.adview.activity.b.b r0 = new com.applovin.impl.adview.activity.b.b     // Catch:{ all -> 0x0188 }
            r1 = r0
            r2 = r16
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0188 }
        L_0x0181:
            r0.sz()
            r10.a(r0)
            return
        L_0x0188:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenGraphicAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.b.a.a(com.applovin.impl.sdk.ad.e, com.applovin.sdk.AppLovinAdClickListener, com.applovin.sdk.AppLovinAdDisplayListener, com.applovin.sdk.AppLovinAdVideoPlaybackListener, java.util.Map, com.applovin.impl.sdk.n, android.app.Activity, com.applovin.impl.adview.activity.b.a$a):void");
    }

    a(e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.aiL = eVar;
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.ahM = activity;
        this.agC = appLovinAdClickListener;
        this.agA = appLovinAdDisplayListener;
        this.agR = appLovinAdVideoPlaybackListener;
        com.applovin.impl.sdk.b.b bVar = new com.applovin.impl.sdk.b.b(activity, nVar);
        this.ajh = bVar;
        bVar.a(this);
        d dVar = new d(eVar, nVar);
        this.agj = dVar;
        this.ajj = new j(nVar);
        b bVar2 = new b();
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNt)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNA)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_undefined"));
        }
        o oVar = new o(nVar.getWrappingSdk(), AppLovinAdSize.INTERSTITIAL, activity);
        this.aiQ = oVar;
        oVar.setAdClickListener(bVar2);
        this.aiQ.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                x xVar = a.this.logger;
                if (x.Fn()) {
                    a.this.logger.f("AppLovinFullscreenActivity", "Web content rendered");
                }
            }

            public void adHidden(AppLovinAd appLovinAd) {
                x xVar = a.this.logger;
                if (x.Fn()) {
                    a.this.logger.f("AppLovinFullscreenActivity", "Closing from WebView");
                }
                a.this.dismiss();
            }
        });
        this.aiQ.getController().setStatsManagerHelper(dVar);
        p pVar = new p(map, nVar);
        if (pVar.rN()) {
            this.agn = new v(pVar, activity);
        }
        nVar.BD().trackImpression(eVar);
        List<Integer> Gf = eVar.Gf();
        if (eVar.Ge() >= 0 || Gf != null) {
            n nVar2 = new n(eVar.Gg(), activity);
            this.aiR = nVar2;
            nVar2.setVisibility(8);
            nVar2.setOnClickListener(bVar2);
        } else {
            this.aiR = null;
        }
        n nVar3 = new n(j.a.WHITE_ON_TRANSPARENT, activity);
        this.aiS = nVar3;
        nVar3.setOnClickListener(new a$$ExternalSyntheticLambda1(this));
        if (eVar.Hb()) {
            this.aiP = new i.a() {
                public void ge(int i) {
                    if (a.this.ajf != i.aAb) {
                        a.this.ajg = true;
                    }
                    com.applovin.impl.adview.d qZ = a.this.aiQ.getController().qZ();
                    if (i.gx(i) && !i.gx(a.this.ajf)) {
                        qZ.bq("javascript:al_muteSwitchOn();");
                    } else if (i == 2) {
                        qZ.bq("javascript:al_muteSwitchOff();");
                    }
                    a.this.ajf = i;
                }
            };
        } else {
            this.aiP = null;
        }
        this.aiO = new com.applovin.impl.sdk.utils.a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (!a.this.aiT.get()) {
                    if (activity.getClass().getName().equals(u.af(activity.getApplicationContext()))) {
                        AppLovinSdkUtils.runOnUiThread(new a$3$$ExternalSyntheticLambda0(this));
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void sP() {
                x.H("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
                try {
                    a.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        dismiss();
    }

    private void sz() {
        if (this.aiP != null) {
            this.sdk.Cj().a(this.aiP);
        }
        if (this.aiO != null) {
            this.sdk.BM().a(this.aiO);
        }
    }

    /* access modifiers changed from: protected */
    public void checkCachedAdResourcesImmediately(boolean z) {
        List<Uri> a = u.a(z, this.aiL, this.sdk, (Context) this.ahM);
        if (a.isEmpty()) {
            return;
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQr)).booleanValue()) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.i("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + a);
            }
            q.a(this.aiL, this.agA, "Missing ad resources", (Throwable) null, (AppLovinFullscreenActivity) null);
            dismiss();
            return;
        }
        if (x.Fn()) {
            x xVar2 = this.logger;
            xVar2.i("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + a);
        }
        this.aiL.FA();
    }

    /* access modifiers changed from: protected */
    public void checkCachedAdResourcesAsync(boolean z) {
        u.a(z, this.aiL, this.sdk, com.applovin.impl.sdk.n.getApplicationContext(), (u.a) this);
    }

    public void onCachedResourcesChecked(boolean z) {
        if (!z) {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQr)).booleanValue()) {
                if (x.Fn()) {
                    this.logger.i("AppLovinFullscreenActivity", "Dismissing ad due to unavailable resources");
                }
                q.a(this.aiL, this.agA, "Unavailable ad resources", (Throwable) null, (AppLovinFullscreenActivity) null);
                dismiss();
                return;
            }
            if (x.Fn()) {
                this.logger.i("AppLovinFullscreenActivity", "Streaming ad due to unavailable ad resources");
            }
            this.aiL.FA();
        }
    }

    /* access modifiers changed from: protected */
    public void au(boolean z) {
        d(z, ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNr)).longValue());
        m.a(this.agA, (AppLovinAd) this.aiL);
        this.sdk.Cf().ab(this.aiL);
        if (this.aiL.hasVideoUrl() || sK()) {
            m.a(this.agR, (AppLovinAd) this.aiL);
        }
        new com.applovin.impl.adview.activity.b(this.ahM).c(this.aiL);
        this.agj.JM();
        this.aiL.setHasShown(true);
    }

    public void onResume() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "onResume()");
        }
        this.agj.bV(SystemClock.elapsedRealtime() - this.aiU);
        bt("javascript:al_onAppResumed();");
        sH();
        if (this.ajh.Jy()) {
            this.ajh.Jw();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z);
        }
        bt("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void onPause() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "onPause()");
        }
        this.aiU = SystemClock.elapsedRealtime();
        bt("javascript:al_onAppPaused();");
        if (this.ajh.Jy()) {
            this.ajh.Jw();
        }
        sG();
    }

    public void dismiss() {
        this.aiX = true;
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "dismiss()");
        }
        e eVar = this.aiL;
        if (eVar != null) {
            eVar.getAdEventTracker().IM();
        }
        this.acG.removeCallbacksAndMessages((Object) null);
        d("javascript:al_onPoststitialDismiss();", (long) this.aiL.GJ());
        sE();
        this.agj.rb();
        this.ajj.destroy();
        if (this.aiP != null) {
            this.sdk.Cj().b(this.aiP);
        }
        if (this.aiO != null) {
            this.sdk.BM().b(this.aiO);
        }
        if (sF()) {
            this.ahM.finish();
            return;
        }
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        onDestroy();
    }

    public void onStop() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public void onDestroy() {
        AppLovinAdView appLovinAdView = this.aiQ;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.aiQ.destroy();
            this.aiQ = null;
            if ((parent instanceof ViewGroup) && sF()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        sD();
        sE();
        this.agC = null;
        this.agA = null;
        this.agR = null;
        this.ahM = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        if (this.logger != null && x.Fn()) {
            x xVar = this.logger;
            xVar.g("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
        }
    }

    public void onBackPressed() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.ajk) {
            dismiss();
        }
        if (this.aiL.GL()) {
            bu("javascript:onBackPressed();");
        }
    }

    /* access modifiers changed from: protected */
    public void bt(String str) {
        if (this.aiL.GM()) {
            d(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void bu(String str) {
        d(str, 0);
    }

    /* access modifiers changed from: protected */
    public void d(String str, long j) {
        if (j >= 0) {
            a((Runnable) new a$$ExternalSyntheticLambda4(this, str), j);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bv(String str) {
        AppLovinAdView appLovinAdView;
        com.applovin.impl.adview.d qZ;
        if (StringUtils.isValidString(str) && (appLovinAdView = this.aiQ) != null && (qZ = appLovinAdView.getController().qZ()) != null) {
            qZ.bq(str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(n nVar, long j, Runnable runnable) {
        if (j < ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNb)).longValue()) {
            this.sdk.BO().a(new ab(this.sdk, "fadeInCloseButton", new a$$ExternalSyntheticLambda3(nVar, runnable)), q.b.MAIN, TimeUnit.SECONDS.toMillis(j), true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(n nVar, Runnable runnable) {
        nVar.bringToFront();
        runnable.run();
    }

    /* access modifiers changed from: protected */
    public int sC() {
        int Gt = this.aiL.Gt();
        return (Gt <= 0 && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNq)).booleanValue()) ? this.aiZ + 1 : Gt;
    }

    /* access modifiers changed from: protected */
    public void a(int i, boolean z, boolean z2, long j) {
        int i2 = i;
        if (this.videoEndListenerNotified.compareAndSet(false, true)) {
            if (this.aiL.hasVideoUrl() || sK()) {
                m.a(this.agR, (AppLovinAd) this.aiL, (double) i2, z2);
            }
            if (this.aiL.hasVideoUrl()) {
                this.agj.bU((long) i2);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
            this.sdk.BD().trackVideoEnd(this.aiL, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i, z);
            long j2 = -1;
            if (this.aiV != -1) {
                j2 = SystemClock.elapsedRealtime() - this.aiV;
            }
            this.sdk.BD().trackFullScreenAdClosed(this.aiL, j2, this.ajc, j, this.ajg, this.ajf);
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AppLovinFullscreenActivity", "Video ad ended at percent: " + i2 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + j2 + "ms");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sE() {
        if (this.aiT.compareAndSet(false, true)) {
            m.b(this.agA, (AppLovinAd) this.aiL);
            this.sdk.Cf().ac(this.aiL);
        }
    }

    /* access modifiers changed from: protected */
    public boolean sF() {
        return this.ahM instanceof AppLovinFullscreenActivity;
    }

    /* access modifiers changed from: protected */
    public void sG() {
        r rVar = this.aji;
        if (rVar != null) {
            rVar.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void sH() {
        r rVar = this.aji;
        if (rVar != null) {
            rVar.resume();
        }
    }

    /* access modifiers changed from: protected */
    public boolean sK() {
        return AppLovinAdType.INCENTIVIZED == this.aiL.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.aiL.getType();
    }

    /* access modifiers changed from: protected */
    public void bF(long j) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        }
        this.aji = r.b(j, this.sdk, new a$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sO() {
        if (!this.aiL.GW().getAndSet(true)) {
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.sdk.e.x(this.aiL, this.sdk), q.b.REWARD);
        }
    }

    /* access modifiers changed from: protected */
    public void d(boolean z, long j) {
        if (this.aiL.GK()) {
            d(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    /* access modifiers changed from: protected */
    public void sM() {
        com.applovin.impl.adview.d qZ;
        if (this.aiQ != null && this.aiL.Gs() && (qZ = this.aiQ.getController().qZ()) != null) {
            this.ajj.a((View) qZ, (j.a) new a$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        n nVar;
        if (u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            this.sdk.Cc().b(this.aiL, com.applovin.impl.sdk.n.getApplicationContext());
        }
        this.sdk.Cs().a(r.a.BLACK_VIEW, (Map<String, String>) CollectionUtils.map("clcode", this.aiL.getClCode()));
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQF)).booleanValue()) {
            dismiss();
            return;
        }
        this.ajk = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQG)).booleanValue();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQH)).booleanValue() && (nVar = this.aiR) != null) {
            nVar.setVisibility(0);
        }
    }

    public void sN() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.aiY = true;
    }

    public void rl() {
        if (x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "Handling al_onPoststitialShow undefined");
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction()) && !this.aiY) {
            sN();
        } else if ("com.applovin.al_onPoststitialShow_undefined".equals(intent.getAction())) {
            rl();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.acG);
    }

    private class b implements View.OnClickListener, AppLovinAdClickListener {
        private b() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            x xVar = a.this.logger;
            if (x.Fn()) {
                a.this.logger.f("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            m.a(a.this.agC, appLovinAd);
            a.this.agj.JN();
            a.this.aje++;
        }

        public void onClick(View view) {
            if (view != a.this.aiR || !((Boolean) a.this.sdk.a(com.applovin.impl.sdk.c.b.aNc)).booleanValue()) {
                x xVar = a.this.logger;
                if (x.Fn()) {
                    x xVar2 = a.this.logger;
                    xVar2.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            a.c(a.this);
            if (a.this.aiL.GL()) {
                a aVar = a.this;
                aVar.bu("javascript:al_onCloseButtonTapped(" + a.this.ajb + "," + a.this.ajd + "," + a.this.aje + ");");
            }
            List<Integer> Gf = a.this.aiL.Gf();
            x xVar3 = a.this.logger;
            if (x.Fn()) {
                x xVar4 = a.this.logger;
                xVar4.f("AppLovinFullscreenActivity", "Handling close button tap " + a.this.ajb + " with multi close delay: " + Gf);
            }
            if (Gf == null || Gf.size() <= a.this.ajb) {
                a.this.dismiss();
                return;
            }
            a.this.ajc.add(Long.valueOf(SystemClock.elapsedRealtime() - a.this.aiV));
            List<j.a> Gh = a.this.aiL.Gh();
            if (Gh != null && Gh.size() > a.this.ajb) {
                a.this.aiR.b(Gh.get(a.this.ajb));
            }
            x xVar5 = a.this.logger;
            if (x.Fn()) {
                x xVar6 = a.this.logger;
                xVar6.f("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + Gf.get(a.this.ajb));
            }
            a.this.aiR.setVisibility(8);
            a aVar2 = a.this;
            aVar2.a(aVar2.aiR, (long) Gf.get(a.this.ajb).intValue(), new a$b$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void sQ() {
            a.this.aiV = SystemClock.elapsedRealtime();
        }
    }
}
