package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.adview.activity.a.d;
import com.applovin.impl.adview.n;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends a implements com.applovin.impl.adview.g {
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    private final d ajR = new d(this.aiL, this.ahM, this.sdk);
    private double ajS;
    private double ajT;
    private final AtomicBoolean ajU;
    private final com.applovin.impl.adview.a aju;
    /* access modifiers changed from: private */
    public final n ajv;
    private boolean isVideoMuted;
    private final boolean isVideoStream;
    /* access modifiers changed from: private */
    public final ImageView muteButtonImageView;

    public void b(double d) {
        this.ajS = d;
    }

    public void bE(long j) {
    }

    public void pauseVideo() {
    }

    public g(e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        boolean FF = this.aiL.FF();
        this.isVideoStream = FF;
        this.ajU = new AtomicBoolean();
        this.ajD = new AtomicBoolean();
        this.isVideoMuted = u.P(this.sdk);
        this.ajE = -2;
        this.ajF = 0;
        if (u.a(b.aMb, nVar)) {
            checkCachedAdResourcesAsync(false);
        }
        a aVar = new a();
        if (eVar.Gc() >= 0) {
            n nVar2 = new n(eVar.Gj(), activity);
            this.ajv = nVar2;
            nVar2.setVisibility(8);
            nVar2.setOnClickListener(aVar);
        } else {
            this.ajv = null;
        }
        if (a(this.isVideoMuted, nVar)) {
            ImageView imageView = new ImageView(activity);
            this.muteButtonImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(aVar);
            av(this.isVideoMuted);
        } else {
            this.muteButtonImageView = null;
        }
        if (FF) {
            com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) nVar.a(b.aNp)).intValue(), 16842874);
            this.aju = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            return;
        }
        this.aju = null;
    }

    public void sA() {
        a((ViewGroup) null);
    }

    public void a(ViewGroup viewGroup) {
        this.ajR.a(this.muteButtonImageView, this.ajv, this.aiR, this.aju, this.agn, this.aiQ, viewGroup);
        this.aiQ.getController().a((com.applovin.impl.adview.g) this);
        if (!u.a(b.aMb, this.sdk)) {
            checkCachedAdResourcesImmediately(false);
        }
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.aiQ.renderAd(this.aiL);
        if (this.ajv != null) {
            this.sdk.BO().a(new ab(this.sdk, "scheduleSkipButton", new g$$ExternalSyntheticLambda1(this)), q.b.MAIN, this.aiL.Gd(), true);
        }
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "updateMainViewOM", new g$$ExternalSyntheticLambda2(this)), q.b.MAIN, 500);
        super.au(this.isVideoMuted);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sX() {
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
    }

    /* access modifiers changed from: private */
    public void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Gc(), new g$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tn() {
        this.ajE = -1;
        this.ajF = SystemClock.elapsedRealtime();
    }

    public void th() {
        this.ajE = SystemClock.elapsedRealtime() - this.ajF;
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            xVar2.f("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.ajE + "ms");
        }
        if (sJ()) {
            sG();
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
            }
            this.ajh.Jx();
            return;
        }
        sY();
    }

    private void sY() {
        this.ajd++;
        this.agj.JQ();
        if (this.aiL.Gk()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            dismiss();
            return;
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video...");
        }
        tc();
    }

    public void tc() {
        if (this.ajU.compareAndSet(false, true)) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Showing postitial...");
            }
            bu("javascript:al_showPostitial();");
            n nVar = this.ajv;
            if (nVar != null) {
                nVar.setVisibility(8);
            }
            ImageView imageView = this.muteButtonImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            com.applovin.impl.adview.a aVar = this.aju;
            if (aVar != null) {
                aVar.qO();
            }
            if (this.aiR != null) {
                if (this.aiL.Ge() >= 0) {
                    a(this.aiR, this.aiL.Ge(), new g$$ExternalSyntheticLambda3(this));
                } else {
                    this.aiR.setVisibility(0);
                }
            }
            this.aiQ.getController().qW();
            sM();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ts() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    public void sN() {
        super.sN();
        sT();
    }

    public void rl() {
        super.rl();
        sT();
    }

    private void sT() {
        this.ajR.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
        this.ajS = 100.0d;
    }

    public void a(double d) {
        bu("javascript:al_setVideoMuted(" + this.isVideoMuted + ");");
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
        if (this.ajv != null) {
            te();
        }
        this.aiQ.getController().qV();
        this.ajT = d;
        sL();
        if (this.aiL.Hc()) {
            this.ajh.a(this.aiL, (Runnable) null);
        }
    }

    public void ru() {
        tc();
    }

    public void rv() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    public void rw() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
    }

    public void dismiss() {
        sD();
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public boolean sJ() {
        return sK() && !sI();
    }

    /* access modifiers changed from: protected */
    public boolean sI() {
        return this.ajS >= ((double) this.aiL.GE());
    }

    public void sR() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void sS() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        sY();
    }

    /* access modifiers changed from: protected */
    public void sD() {
        super.a((int) this.ajS, this.isVideoStream, sI(), this.ajE);
    }

    /* access modifiers changed from: protected */
    public void sL() {
        long j;
        long millis;
        long j2 = 0;
        if (this.aiL.GT() >= 0 || this.aiL.GU() >= 0) {
            if (this.aiL.GT() >= 0) {
                j = this.aiL.GT();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.aiL;
                if (this.ajT > 0.0d) {
                    j2 = TimeUnit.SECONDS.toMillis((long) this.ajT);
                }
                if (aVar.GV()) {
                    int FM = (int) ((com.applovin.impl.sdk.ad.a) this.aiL).FM();
                    if (FM > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) FM);
                    } else {
                        int Ge = (int) aVar.Ge();
                        if (Ge > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) Ge);
                        }
                    }
                    j2 += millis;
                }
                j = (long) (((double) j2) * (((double) this.aiL.GU()) / 100.0d));
            }
            bF(j);
        }
    }

    private static boolean a(boolean z, com.applovin.impl.sdk.n nVar) {
        if (!((Boolean) nVar.a(b.aNe)).booleanValue()) {
            return false;
        }
        if (!((Boolean) nVar.a(b.aNf)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) nVar.a(b.aNh)).booleanValue();
    }

    private void av(boolean z) {
        if (h.KX()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.ahM.getDrawable(z ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.muteButtonImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.muteButtonImageView.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri Hv = z ? this.aiL.Hv() : this.aiL.Hw();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.muteButtonImageView.setImageURI(Hv);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: protected */
    public void tb() {
        this.isVideoMuted = !this.isVideoMuted;
        bu("javascript:al_setVideoMuted(" + this.isVideoMuted + ");");
        av(this.isVideoMuted);
        d(this.isVideoMuted, 0);
    }

    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            if (view == g.this.ajv) {
                g.this.th();
            } else if (view == g.this.muteButtonImageView) {
                g.this.tb();
            } else {
                x xVar = g.this.logger;
                if (x.Fn()) {
                    x xVar2 = g.this.logger;
                    xVar2.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                }
            }
        }
    }
}
