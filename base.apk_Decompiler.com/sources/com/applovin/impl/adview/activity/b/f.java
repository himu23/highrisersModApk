package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
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
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.w;
import com.applovin.impl.adview.x;
import com.applovin.impl.sdk.a.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
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
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends a implements AppLovinCommunicatorSubscriber {
    protected final ProgressBar agb;
    private final Handler ajA;
    protected final k ajB;
    protected boolean ajC;
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    /* access modifiers changed from: private */
    public MediaPlayer ajL;
    protected final AppLovinVideoView ajM;
    /* access modifiers changed from: private */
    public final b ajN;
    private final a ajO;
    private int ajP;
    private final com.applovin.impl.adview.activity.a.c ajt = new com.applovin.impl.adview.activity.a.c(this.aiL, this.ahM, this.sdk);
    protected final com.applovin.impl.adview.a aju;
    protected final n ajv;
    protected h ajw;
    protected w ajx;
    protected ProgressBar ajy;
    private final Handler countdownHandler;
    protected final k countdownManager;
    protected ImageView industryIconImageView = null;
    protected boolean isVideoMuted;
    private final boolean isVideoStream;
    private final AtomicBoolean mediaErrorHandled;
    protected final ImageView muteButtonImageView;
    private int savedVideoPercentViewed;
    protected long videoDurationMillis;
    /* access modifiers changed from: private */
    public boolean videoWasCompleted;

    /* access modifiers changed from: protected */
    public void bG(long j) {
        this.videoDurationMillis = j;
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    public f(e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        b bVar = new b();
        this.ajN = bVar;
        a aVar = new a();
        this.ajO = aVar;
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
        this.ajP = -1;
        this.mediaErrorHandled = new AtomicBoolean();
        this.ajD = new AtomicBoolean();
        this.ajE = -2;
        this.ajF = 0;
        if (eVar.hasVideoUrl()) {
            if (u.a(com.applovin.impl.sdk.c.b.aMb, nVar)) {
                checkCachedAdResourcesAsync(!FF);
            }
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
            this.ajM = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(bVar);
            appLovinVideoView.setOnCompletionListener(bVar);
            appLovinVideoView.setOnErrorListener(bVar);
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLm, activity, bVar));
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
                        if (f.this.ajw != null) {
                            long seconds = ((long) sC) - TimeUnit.MILLISECONDS.toSeconds((long) f.this.ajM.getCurrentPosition());
                            if (seconds <= 0) {
                                f.this.aja = true;
                            } else if (f.this.tg()) {
                                f.this.ajw.setProgress((int) seconds);
                            }
                        }
                    }

                    public boolean rC() {
                        return f.this.tg();
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
                        if (f.this.ajC) {
                            f.this.agb.setVisibility(8);
                            return;
                        }
                        f.this.agb.setProgress((int) ((((float) f.this.ajM.getCurrentPosition()) / ((float) f.this.videoDurationMillis)) * ((float) num.intValue())));
                    }

                    public boolean rC() {
                        return !f.this.ajC;
                    }
                });
                return;
            }
            this.agb = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    public void sA() {
        a((ViewGroup) null);
    }

    public void a(ViewGroup viewGroup) {
        String str;
        this.ajt.a(this.muteButtonImageView, this.ajv, this.ajx, this.aju, this.agb, this.ajw, this.ajM, this.aiQ, this.agn, this.industryIconImageView, viewGroup);
        if (com.applovin.impl.sdk.utils.h.La() && (str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.AUDIO_FOCUS_REQUEST)) != null) {
            this.ajM.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (!u.a(com.applovin.impl.sdk.c.b.aMb, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        this.ajM.setVideoURI(this.aiL.FI());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.aiL.Hc()) {
            this.ajh.a(this.aiL, new f$$ExternalSyntheticLambda2(this));
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.ajM.start();
        if (this.isVideoStream) {
            sZ();
        }
        this.aiQ.renderAd(this.aiL);
        this.agj.bT(this.isVideoStream ? 1 : 0);
        if (this.ajv != null) {
            this.sdk.BO().a(new ab(this.sdk, "scheduleSkipButton", new f$$ExternalSyntheticLambda3(this)), q.b.MAIN, this.aiL.Gd(), true);
        }
        super.au(this.isVideoMuted);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sX() {
        bE(250);
    }

    /* access modifiers changed from: private */
    public void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Gc(), new f$$ExternalSyntheticLambda7(this));
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
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.g("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQM)).booleanValue()) {
                com.applovin.impl.sdk.utils.x.k(this.ajx);
                this.ajx = null;
            }
            if (this.isVideoStream) {
                AppLovinCommunicator.getInstance(this.ahM).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.ajM;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.ajM.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.ajL;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void a(MotionEvent motionEvent, Bundle bundle) {
        if (this.aiL.Gq()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri FL = this.aiL.FL();
            if (FL != null) {
                this.sdk.BD().trackAndLaunchVideoClick(this.aiL, FL, motionEvent, bundle, this, this.aiQ != null ? this.aiQ.getContext() : com.applovin.impl.sdk.n.getApplicationContext());
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
            AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda4(this, wVar.getVisibility() == 4, Gp.sb()));
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
        return !this.aja && !this.ajC && this.ajM.isPlaying();
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
        this.ajP = this.ajM.getCurrentPosition();
        this.ajM.pause();
        this.countdownManager.W();
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            xVar3.f("AppLovinFullscreenActivity", "Paused video at position " + this.ajP + "ms");
        }
    }

    private void aw(boolean z) {
        this.savedVideoPercentViewed = getVideoPercentViewed();
        if (z) {
            this.ajM.pause();
        } else {
            this.ajM.stopPlayback();
        }
    }

    public void bE(long j) {
        a((Runnable) new f$$ExternalSyntheticLambda6(this), j);
    }

    /* access modifiers changed from: private */
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
        } else if (this.ajP >= 0) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar4 = this.logger;
                xVar4.f("AppLovinFullscreenActivity", "Resuming video at position " + this.ajP + "ms for MediaPlayer: " + this.ajL);
            }
            this.ajM.seekTo(this.ajP);
            this.ajM.start();
            this.countdownManager.start();
            this.ajP = -1;
            a((Runnable) new f$$ExternalSyntheticLambda9(this), 250);
        } else {
            com.applovin.impl.sdk.x xVar5 = this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Invalid last video position");
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tr() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
            com.applovin.impl.adview.a aVar2 = this.aju;
            Objects.requireNonNull(aVar2);
            a((Runnable) new f$$ExternalSyntheticLambda10(aVar2), 2000);
        }
    }

    /* access modifiers changed from: protected */
    public void sZ() {
        AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tq() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    /* access modifiers changed from: protected */
    public void ta() {
        AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tp() {
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
            if (u.a(com.applovin.impl.sdk.c.b.aLV, this.sdk)) {
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
        return getVideoPercentViewed() >= this.aiL.GE();
    }

    /* access modifiers changed from: protected */
    public int getVideoPercentViewed() {
        long currentPosition = (long) this.ajM.getCurrentPosition();
        if (this.videoWasCompleted) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.videoDurationMillis)) * 100.0f) : this.savedVideoPercentViewed;
    }

    /* access modifiers changed from: protected */
    public boolean sJ() {
        return sK() && !sI();
    }

    public void tc() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Showing postitial...");
        }
        aw(this.aiL.Hy());
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
                    f.this.ajy.setProgress((int) ((((float) f.this.aiW) / ((float) GH)) * ((float) num.intValue())));
                    f.this.aiW += l.longValue();
                }

                public boolean rC() {
                    return f.this.aiW < GH;
                }
            });
            this.ajB.start();
        }
        this.ajt.a(this.aiR, this.agn, this.aiQ, this.ajy);
        d("javascript:al_onPoststitialShow(" + this.ajd + "," + this.aje + ");", (long) this.aiL.GI());
        if (this.aiR != null) {
            if (this.aiL.Ge() >= 0) {
                a(this.aiR, this.aiL.Ge(), new f$$ExternalSyntheticLambda8(this));
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
    public /* synthetic */ void to() {
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

    private void av(boolean z) {
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
        MediaPlayer mediaPlayer = this.ajL;
        if (mediaPlayer != null) {
            try {
                float f = this.isVideoMuted ? 1.0f : 0.0f;
                mediaPlayer.setVolume(f, f);
                boolean z = !this.isVideoMuted;
                this.isVideoMuted = z;
                av(z);
                d(this.isVideoMuted, 0);
            } catch (Throwable unused) {
            }
        }
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
                if ((string != null || i < 200 || i >= 300) && !this.videoWasCompleted && !this.ajM.isPlaying()) {
                    handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    private class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private b() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = f.this.ajL = mediaPlayer;
            mediaPlayer.setOnInfoListener(f.this.ajN);
            mediaPlayer.setOnErrorListener(f.this.ajN);
            float f = f.this.isVideoMuted ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            f.this.aiZ = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
            f.this.bG((long) mediaPlayer.getDuration());
            f.this.sL();
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar2 = f.this.logger;
                xVar2.f("AppLovinFullscreenActivity", "MediaPlayer prepared: " + f.this.ajL);
            }
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                com.applovin.impl.sdk.x xVar2 = f.this.logger;
                xVar2.f("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            }
            if (i == 701) {
                f.this.sZ();
                f.this.agj.JR();
                return false;
            } else if (i == 3) {
                f.this.countdownManager.start();
                if (f.this.ajv != null) {
                    f.this.te();
                }
                f.this.ta();
                if (!f.this.ajh.Jy()) {
                    return false;
                }
                f.this.pauseVideo();
                return false;
            } else if (i != 702) {
                return false;
            } else {
                f.this.ta();
                return false;
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            f fVar = f.this;
            fVar.handleMediaError("Video view error (" + i + "," + i2 + ")");
            f.this.ajM.start();
            return true;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Video completed");
            }
            boolean unused = f.this.videoWasCompleted = true;
            if (!f.this.aiY) {
                f.this.tc();
            } else if (f.this.sK()) {
                f.this.sT();
            }
        }

        public void onClick(View view, MotionEvent motionEvent) {
            f.this.a(motionEvent, (Bundle) null);
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            if (view == f.this.ajv) {
                f.this.th();
            } else if (view == f.this.muteButtonImageView) {
                f.this.tb();
            } else {
                com.applovin.impl.sdk.x xVar = f.this.logger;
                if (com.applovin.impl.sdk.x.Fn()) {
                    com.applovin.impl.sdk.x xVar2 = f.this.logger;
                    xVar2.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                }
            }
        }
    }

    private class a implements x.a {
        private a() {
        }

        public void a(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            f.this.a(wVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        public void b(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            f.this.dismiss();
        }

        public void c(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            f.this.th();
        }

        public void a(w wVar, Bundle bundle) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            f.this.a(wVar.getAndClearLastClickEvent(), bundle);
        }

        public void a(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            s.a(uri, f.this.aiQ.getController(), f.this.sdk);
        }

        public void b(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fn()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            s.b(uri, f.this.aiQ.getController().getCurrentAd(), f.this.sdk);
        }
    }
}
