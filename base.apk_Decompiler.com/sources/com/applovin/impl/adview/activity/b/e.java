package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.aw;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.u;
import com.applovin.exoplayer2.k.p;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.ui.f;
import com.applovin.exoplayer2.ui.g;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.w;
import com.applovin.impl.adview.x;
import com.applovin.impl.sdk.a.d;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class e extends a implements AppLovinCommunicatorSubscriber {
    protected final ProgressBar agb;
    private final Handler ajA;
    protected final k ajB;
    protected boolean ajC;
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    private final com.applovin.impl.adview.activity.a.c ajt = new com.applovin.impl.adview.activity.a.c(this.aiL, this.ahM, this.sdk);
    protected final com.applovin.impl.adview.a aju;
    protected final n ajv;
    protected h ajw;
    protected w ajx;
    protected ProgressBar ajy;
    private final a ajz;
    private final Handler countdownHandler;
    protected final k countdownManager;
    protected boolean isVideoMuted;
    private final boolean isVideoStream;
    private long lastVideoPositionFromPauseMillis;
    private final AtomicBoolean mediaErrorHandled;
    protected final aw mediaPlayer;
    protected final ImageView muteButtonImageView;
    protected int savedVideoPercentViewed;
    protected long videoDurationMillis;
    protected final g videoView;
    protected boolean videoWasCompleted;

    /* access modifiers changed from: protected */
    public void bG(long j) {
        this.videoDurationMillis = j;
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    public e(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        a aVar = new a();
        this.ajz = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.countdownHandler = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.ajA = handler2;
        k kVar = new k(handler, this.sdk);
        this.countdownManager = kVar;
        this.ajB = new k(handler2, this.sdk);
        boolean FF = this.aiL.FF();
        this.isVideoStream = FF;
        this.isVideoMuted = u.P(this.sdk);
        this.lastVideoPositionFromPauseMillis = -1;
        this.mediaErrorHandled = new AtomicBoolean();
        this.ajD = new AtomicBoolean();
        this.ajE = -2;
        this.ajF = 0;
        if (eVar.hasVideoUrl()) {
            if (u.a(com.applovin.impl.sdk.c.b.aMb, nVar)) {
                checkCachedAdResourcesAsync(!FF);
            }
            c cVar = new c();
            if (eVar.Gc() >= 0) {
                n nVar2 = new n(eVar.Gj(), activity);
                this.ajv = nVar2;
                nVar2.setVisibility(8);
                nVar2.setOnClickListener(cVar);
            } else {
                this.ajv = null;
            }
            boolean z = true;
            if (a(this.isVideoMuted, nVar)) {
                ImageView imageView = new ImageView(activity);
                this.muteButtonImageView = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                av(this.isVideoMuted);
            } else {
                this.muteButtonImageView = null;
            }
            String Go = eVar.Go();
            if (StringUtils.isValidString(Go)) {
                x xVar = new x(nVar);
                xVar.a(new WeakReference(aVar));
                w wVar = new w(xVar, activity);
                this.ajx = wVar;
                wVar.bs(Go);
            } else {
                this.ajx = null;
            }
            if (FF) {
                com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNp)).intValue(), 16842874);
                this.aju = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.aju = null;
            }
            final int sC = sC();
            z = (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aMZ)).booleanValue() || sC <= 0) ? false : z;
            if (this.ajw == null && z) {
                this.ajw = new h(activity);
                int Gu = eVar.Gu();
                this.ajw.setTextColor(Gu);
                this.ajw.setTextSize((float) ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMY)).intValue());
                this.ajw.setFinishedStrokeColor(Gu);
                this.ajw.setFinishedStrokeWidth((float) ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMX)).intValue());
                this.ajw.setMax(sC);
                this.ajw.setProgress(sC);
                kVar.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1), new k.a() {
                    public void rB() {
                        if (e.this.ajw != null) {
                            long seconds = ((long) sC) - TimeUnit.MILLISECONDS.toSeconds(e.this.videoView.getPlayer().aN());
                            if (seconds <= 0) {
                                e.this.aja = true;
                            } else if (e.this.tg()) {
                                e.this.ajw.setProgress((int) seconds);
                            }
                        }
                    }

                    public boolean rC() {
                        return e.this.tg();
                    }
                });
            }
            if (eVar.GC()) {
                final Integer num = (Integer) nVar.a(com.applovin.impl.sdk.c.b.aNn);
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.agb = progressBar;
                a(progressBar, eVar.GD(), num.intValue());
                kVar.a("PROGRESS_BAR", ((Long) nVar.a(com.applovin.impl.sdk.c.b.aNm)).longValue(), new k.a() {
                    public void rB() {
                        if (e.this.ajC) {
                            e.this.agb.setVisibility(8);
                            return;
                        }
                        e.this.agb.setProgress((int) ((((float) e.this.mediaPlayer.aN()) / ((float) e.this.videoDurationMillis)) * ((float) num.intValue())));
                    }

                    public boolean rC() {
                        return !e.this.ajC;
                    }
                });
            } else {
                this.agb = null;
            }
            aw cY = new aw.a(activity).cY();
            this.mediaPlayer = cY;
            b bVar = new b();
            cY.f((an.b) bVar);
            cY.u(0);
            g gVar = new g(activity);
            this.videoView = gVar;
            gVar.nG();
            gVar.setControllerVisibilityListener(bVar);
            gVar.setPlayer(cY);
            gVar.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLm, activity, bVar));
            prepareMediaPlayer();
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    public void sA() {
        a((ViewGroup) null);
    }

    public void a(ViewGroup viewGroup) {
        this.ajt.a(this.muteButtonImageView, this.ajv, this.ajx, this.aju, this.agb, this.ajw, this.videoView, this.aiQ, this.agn, (ImageView) null, viewGroup);
        if (this.agn != null) {
            this.agn.sg();
        }
        this.mediaPlayer.k(true);
        if (this.aiL.Hc()) {
            this.ajh.a(this.aiL, new e$$ExternalSyntheticLambda6(this));
        }
        if (this.isVideoStream) {
            sZ();
        }
        this.aiQ.renderAd(this.aiL);
        this.agj.bT(this.isVideoStream ? 1 : 0);
        if (this.ajv != null) {
            this.sdk.BO().a(new ab(this.sdk, "scheduleSkipButton", new e$$ExternalSyntheticLambda7(this)), q.b.MAIN, this.aiL.Gd(), true);
        }
        super.au(this.isVideoMuted);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sX() {
        bE(250);
    }

    /* access modifiers changed from: protected */
    public void prepareMediaPlayer() {
        if (!u.a(com.applovin.impl.sdk.c.b.aMb, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        com.applovin.exoplayer2.h.u c2 = new u.a(new p(this.ahM, ai.a((Context) this.ahM, "com.applovin.sdk"))).c(com.applovin.exoplayer2.ab.a(this.aiL.FI()));
        this.mediaPlayer.h(this.isVideoMuted ^ true ? 1.0f : 0.0f);
        this.mediaPlayer.a((com.applovin.exoplayer2.h.p) c2);
        this.mediaPlayer.aD();
        this.mediaPlayer.k(false);
    }

    /* access modifiers changed from: protected */
    public void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Gc(), new e$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tn() {
        this.ajE = -1;
        this.ajF = SystemClock.elapsedRealtime();
    }

    private void a(ProgressBar progressBar, int i, int i2) {
        progressBar.setMax(i2);
        progressBar.setPadding(0, 0, 0, 0);
        if (com.applovin.impl.sdk.utils.h.KX()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i));
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            bE(0);
            if (this.ajC) {
                this.ajB.start();
            }
        } else if (this.ajC) {
            this.ajB.W();
        } else {
            pauseVideo();
        }
    }

    public void dismiss() {
        this.countdownManager.rA();
        this.ajB.rA();
        this.countdownHandler.removeCallbacksAndMessages((Object) null);
        this.ajA.removeCallbacksAndMessages((Object) null);
        sD();
        super.dismiss();
    }

    public void onDestroy() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQM)).booleanValue()) {
            com.applovin.impl.sdk.utils.x.k(this.ajx);
            this.ajx = null;
        }
        this.mediaPlayer.release();
        if (this.isVideoStream) {
            AppLovinCommunicator.getInstance(this.ahM).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (this.aiL.Gq()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri FL = this.aiL.FL();
            if (FL != null) {
                if (this.aiQ != null) {
                    context = this.aiQ.getContext();
                } else {
                    com.applovin.impl.sdk.n nVar = this.sdk;
                    context = com.applovin.impl.sdk.n.getApplicationContext();
                }
                this.sdk.BD().trackAndLaunchVideoClick(this.aiL, FL, motionEvent, bundle, this, context);
                m.a(this.agC, (AppLovinAd) this.aiL);
                this.agj.JN();
                this.aje++;
                return;
            }
            return;
        }
        tf();
    }

    private void tf() {
        w wVar;
        com.applovin.impl.adview.u Gp = this.aiL.Gp();
        if (Gp != null && Gp.sa() && !this.ajC && (wVar = this.ajx) != null) {
            AppLovinSdkUtils.runOnUiThread(new e$$ExternalSyntheticLambda4(this, wVar.getVisibility() == 4, Gp.sb()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(boolean z, long j) {
        if (z) {
            v.a(this.ajx, j, (Runnable) null);
        } else {
            v.b(this.ajx, j, (Runnable) null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean tg() {
        return !this.aja && !this.ajC && this.videoView.getPlayer().v();
    }

    public void th() {
        this.ajE = SystemClock.elapsedRealtime() - this.ajF;
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            xVar2.f("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.ajE + "ms");
        }
        if (sJ()) {
            pauseVideo();
            sG();
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
            }
            this.ajh.Jx();
            return;
        }
        sY();
    }

    public void sY() {
        this.ajd++;
        this.agj.JQ();
        if (this.aiL.Gk()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            dismiss();
            return;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video...");
        }
        tc();
    }

    public void pauseVideo() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Pausing video");
        }
        if (this.mediaPlayer.v()) {
            this.lastVideoPositionFromPauseMillis = this.mediaPlayer.aN();
            this.mediaPlayer.k(false);
            this.countdownManager.W();
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar3 = this.logger;
                xVar3.f("AppLovinFullscreenActivity", "Paused video at position " + this.lastVideoPositionFromPauseMillis + "ms");
                return;
            }
            return;
        }
        com.applovin.impl.sdk.x xVar4 = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Nothing to pause");
        }
    }

    /* access modifiers changed from: protected */
    public void ti() {
        this.savedVideoPercentViewed = getVideoPercentViewed();
        this.mediaPlayer.k(false);
    }

    public void bE(long j) {
        a((Runnable) new e$$ExternalSyntheticLambda2(this), j);
    }

    /* access modifiers changed from: protected */
    public void tj() {
        if (this.ajC) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.h("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
            }
        } else if (this.sdk.Ce().isApplicationPaused()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.h("AppLovinFullscreenActivity", "Skip video resume - app paused");
            }
        } else {
            long j = this.lastVideoPositionFromPauseMillis;
            if (j >= 0) {
                com.applovin.impl.sdk.x xVar3 = this.logger;
                if (com.applovin.impl.sdk.x.Fn()) {
                    com.applovin.impl.sdk.x xVar4 = this.logger;
                    xVar4.f("AppLovinFullscreenActivity", "Resuming video at position " + j + "ms for MediaPlayer: " + this.mediaPlayer);
                }
                this.mediaPlayer.k(true);
                this.countdownManager.start();
                this.lastVideoPositionFromPauseMillis = -1;
                if (!this.mediaPlayer.v()) {
                    sZ();
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.x xVar5 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar6 = this.logger;
                xVar6.f("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.mediaPlayer.v());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sZ() {
        AppLovinSdkUtils.runOnUiThread(new e$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tm() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    /* access modifiers changed from: protected */
    public void ta() {
        AppLovinSdkUtils.runOnUiThread(new e$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tl() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
    }

    /* access modifiers changed from: protected */
    public void handleMediaError(String str) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            xVar2.i("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.aiL);
        }
        if (this.mediaErrorHandled.compareAndSet(false, true)) {
            if (com.applovin.impl.sdk.utils.u.a(com.applovin.impl.sdk.c.b.aLV, this.sdk)) {
                this.sdk.Cc().c(this.aiL, com.applovin.impl.sdk.n.getApplicationContext());
            }
            if (this.agA instanceof com.applovin.impl.sdk.ad.h) {
                ((com.applovin.impl.sdk.ad.h) this.agA).onAdDisplayFailed(str);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public boolean sI() {
        if (this.aiL != null && getVideoPercentViewed() >= this.aiL.GE()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int getVideoPercentViewed() {
        aw awVar = this.mediaPlayer;
        if (awVar == null) {
            return 0;
        }
        long aN = awVar.aN();
        if (this.videoWasCompleted) {
            return 100;
        }
        return aN > 0 ? (int) ((((float) aN) / ((float) this.videoDurationMillis)) * 100.0f) : this.savedVideoPercentViewed;
    }

    /* access modifiers changed from: protected */
    public boolean sJ() {
        return sK() && !sI();
    }

    public void tc() {
        ti();
        final long GH = this.aiL.GH();
        if (GH > 0) {
            this.aiW = 0;
            final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNv);
            final Integer num = (Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNy);
            ProgressBar progressBar = new ProgressBar(this.ahM, (AttributeSet) null, 16842872);
            this.ajy = progressBar;
            a(progressBar, this.aiL.GG(), num.intValue());
            this.ajB.a("POSTITIAL_PROGRESS_BAR", l.longValue(), new k.a() {
                public void rB() {
                    e.this.ajy.setProgress((int) ((((float) e.this.aiW) / ((float) GH)) * ((float) num.intValue())));
                    e.this.aiW += l.longValue();
                }

                public boolean rC() {
                    return e.this.aiW < GH;
                }
            });
            this.ajB.start();
        }
        this.ajt.a(this.aiR, this.agn, this.aiQ, this.ajy);
        d("javascript:al_onPoststitialShow(" + this.ajd + "," + this.aje + ");", (long) this.aiL.GI());
        if (this.aiR != null) {
            if (this.aiL.Ge() >= 0) {
                a(this.aiR, this.aiL.Ge(), new e$$ExternalSyntheticLambda3(this));
            } else {
                this.aiR.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        ProgressBar progressBar2 = this.ajy;
        if (progressBar2 != null) {
            arrayList.add(new d(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
        sM();
        this.ajC = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tk() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    private static boolean a(boolean z, com.applovin.impl.sdk.n nVar) {
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNe)).booleanValue()) {
            return false;
        }
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNf)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNh)).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void av(boolean z) {
        if (com.applovin.impl.sdk.utils.h.KX()) {
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
        boolean z = this.isVideoMuted;
        this.isVideoMuted = !z;
        this.mediaPlayer.h(z ? 1.0f : 0.0f);
        av(this.isVideoMuted);
        d(this.isVideoMuted, 0);
    }

    public void sR() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void sS() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        sY();
    }

    /* access modifiers changed from: protected */
    public void sD() {
        super.a(getVideoPercentViewed(), this.isVideoStream, sI(), this.ajE);
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
                long j3 = this.videoDurationMillis;
                if (j3 > 0) {
                    j2 = j3;
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

    public void sN() {
        super.sN();
        this.ajt.k(this.ajx);
        this.ajt.k(this.ajv);
        if (!sK() || this.ajC) {
            sT();
        }
    }

    public void rl() {
        super.rl();
        sT();
    }

    /* access modifiers changed from: private */
    public void sT() {
        this.ajt.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.aiL.getAdIdNumber() && this.isVideoStream) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.videoWasCompleted && !this.mediaPlayer.v()) {
                    handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    private class b implements an.b, f.d, AppLovinTouchToClickListener.OnClickListener {
        public /* synthetic */ void a(com.applovin.exoplayer2.ab abVar, int i) {
            an.b.CC.$default$a((an.b) this, abVar, i);
        }

        public /* synthetic */ void a(ac acVar) {
            an.b.CC.$default$a((an.b) this, acVar);
        }

        public /* synthetic */ void a(an.e eVar, an.e eVar2, int i) {
            an.b.CC.$default$a(this, eVar, eVar2, i);
        }

        public /* synthetic */ void a(an anVar, an.c cVar) {
            an.b.CC.$default$a((an.b) this, anVar, cVar);
        }

        public /* synthetic */ void a(ad adVar, com.applovin.exoplayer2.j.h hVar) {
            an.b.CC.$default$a((an.b) this, adVar, hVar);
        }

        public /* synthetic */ void aa(int i) {
            an.b.CC.$default$aa(this, i);
        }

        public /* synthetic */ void ab(int i) {
            an.b.CC.$default$ab(this, i);
        }

        public /* synthetic */ void ac(int i) {
            an.b.CC.$default$ac(this, i);
        }

        public /* synthetic */ void b(ak akVar) {
            an.b.CC.$default$b((an.b) this, akVar);
        }

        public /* synthetic */ void b(am amVar) {
            an.b.CC.$default$b((an.b) this, amVar);
        }

        public /* synthetic */ void b(ba baVar, int i) {
            an.b.CC.$default$b(this, baVar, i);
        }

        public /* synthetic */ void cD() {
            an.b.CC.$default$cD(this);
        }

        public /* synthetic */ void d(an.a aVar) {
            an.b.CC.$default$d(this, aVar);
        }

        public /* synthetic */ void d(boolean z, int i) {
            an.b.CC.$default$d(this, z, i);
        }

        public /* synthetic */ void e(boolean z, int i) {
            an.b.CC.$default$e(this, z, i);
        }

        public /* synthetic */ void w(boolean z) {
            an.b.CC.$default$w(this, z);
        }

        public /* synthetic */ void x(boolean z) {
            an.b.CC.$default$x(this, z);
        }

        public /* synthetic */ void y(boolean z) {
            an.b.CC.$default$y(this, z);
        }

        public /* synthetic */ void z(boolean z) {
            an.b.CC.$default$z(this, z);
        }

        private b() {
        }

        public void Z(int i) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar2 = e.this.logger;
                xVar2.f("AppLovinFullscreenActivity", "Player state changed to state " + i + " and will play when ready: " + e.this.mediaPlayer.aE());
            }
            if (i == 2) {
                e.this.sZ();
                e.this.agj.JR();
            } else if (i == 3) {
                e.this.mediaPlayer.h(e.this.isVideoMuted ^ true ? 1.0f : 0.0f);
                e.this.aiZ = (int) TimeUnit.MILLISECONDS.toSeconds(e.this.mediaPlayer.aM());
                e eVar = e.this;
                eVar.bG(eVar.mediaPlayer.aM());
                e.this.sL();
                com.applovin.impl.sdk.x xVar3 = e.this.logger;
                if (com.applovin.impl.sdk.x.Fn()) {
                    com.applovin.impl.sdk.x xVar4 = e.this.logger;
                    xVar4.f("AppLovinFullscreenActivity", "MediaPlayer prepared: " + e.this.mediaPlayer);
                }
                e.this.countdownManager.start();
                if (e.this.ajv != null) {
                    e.this.te();
                }
                e.this.ta();
                if (e.this.ajh.Jy()) {
                    e.this.pauseVideo();
                }
            } else if (i == 4) {
                com.applovin.impl.sdk.x xVar5 = e.this.logger;
                if (com.applovin.impl.sdk.x.Fn()) {
                    e.this.logger.f("AppLovinFullscreenActivity", "Video completed");
                }
                e.this.videoWasCompleted = true;
                if (!e.this.aiY) {
                    e.this.tc();
                } else if (e.this.sK()) {
                    e.this.sT();
                }
            }
        }

        public void a(ak akVar) {
            e eVar = e.this;
            eVar.handleMediaError("Video view error (" + com.applovin.impl.sdk.utils.u.a(akVar, e.this.sdk) + ")");
            e.this.dismiss();
        }

        public void onClick(View view, MotionEvent motionEvent) {
            e.this.a(motionEvent, (Bundle) null);
        }

        public void eZ(int i) {
            if (i == 0) {
                e.this.videoView.nG();
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            if (view == e.this.ajv) {
                e.this.th();
            } else if (view == e.this.muteButtonImageView) {
                e.this.tb();
            } else {
                com.applovin.impl.sdk.x xVar = e.this.logger;
                if (com.applovin.impl.sdk.x.Fn()) {
                    com.applovin.impl.sdk.x xVar2 = e.this.logger;
                    xVar2.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                }
            }
        }
    }

    private class a implements x.a {
        private a() {
        }

        public void a(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            e.this.a(wVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        public void b(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            e.this.dismiss();
        }

        public void c(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            e.this.th();
        }

        public void a(w wVar, Bundle bundle) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            e.this.a(wVar.getAndClearLastClickEvent(), bundle);
        }

        public void a(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            s.a(uri, e.this.aiQ.getController(), e.this.sdk);
        }

        public void b(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            s.b(uri, e.this.aiQ.getController().getCurrentAd(), e.this.sdk);
        }
    }
}
