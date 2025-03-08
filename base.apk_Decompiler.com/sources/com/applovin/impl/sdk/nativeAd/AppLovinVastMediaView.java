package com.applovin.impl.sdk.nativeAd;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.exoplayer2.ab;
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
import com.applovin.impl.adview.k;
import com.applovin.impl.b.a;
import com.applovin.impl.b.f;
import com.applovin.impl.b.l;
import com.applovin.impl.b.m;
import com.applovin.impl.b.o;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinVastMediaView extends AppLovinMediaView implements AppLovinCommunicatorSubscriber, u.a {
    private static final String COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING = "PROGRESS_TRACKING";
    private static final long FADE_ANIMATION_DURATION_MILLIS = 250;
    private static final String TAG = "AppLovinVastMediaView";
    private final AtomicBoolean automaticPauseHandled = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean automaticResumeHandled = new AtomicBoolean();
    private final Handler countdownHandler;
    /* access modifiers changed from: private */
    public final k countdownManager;
    private ImageView industryIconImageView;
    private final AtomicBoolean initialOnAttachedToWindowHandled = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean isVideoMuted = true;
    /* access modifiers changed from: private */
    public boolean isVideoPausedByUser;
    private final boolean isVideoStream;
    private long lastVideoPositionFromPauseMillis = -1;
    /* access modifiers changed from: private */
    public final com.applovin.impl.sdk.utils.a lifecycleCallbacksAdapter;
    private final AtomicBoolean mediaErrorHandled = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final aw mediaPlayer;
    /* access modifiers changed from: private */
    public ImageView muteButtonImageView;
    /* access modifiers changed from: private */
    public ImageView playPauseButtonImageView;
    /* access modifiers changed from: private */
    public FrameLayout replayIconContainer;
    private int savedVideoPercentViewed;
    private long startTimeMillis;
    /* access modifiers changed from: private */
    public final com.applovin.impl.b.a vastAd;
    /* access modifiers changed from: private */
    public long videoDurationMillis;
    private final AtomicBoolean videoEndListenerNotified = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final Set<com.applovin.impl.b.k> videoProgressTrackers;
    /* access modifiers changed from: private */
    public final g videoView;
    /* access modifiers changed from: private */
    public boolean videoWasCompleted;
    private LinearLayout videoWidgetLinearLayout;
    /* access modifiers changed from: private */
    public Activity viewActivity;

    public String getCommunicatorId() {
        return TAG;
    }

    public AppLovinVastMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, Context context) {
        super(appLovinNativeAdImpl, nVar, context);
        int i;
        Handler handler = new Handler(Looper.getMainLooper());
        this.countdownHandler = handler;
        this.countdownManager = new k(handler, this.sdk);
        HashSet hashSet = new HashSet();
        this.videoProgressTrackers = hashSet;
        this.lifecycleCallbacksAdapter = new com.applovin.impl.sdk.utils.a() {
            public void onActivityResumed(Activity activity) {
                if (activity.equals(AppLovinVastMediaView.this.viewActivity) && !AppLovinVastMediaView.this.isVideoPausedByUser) {
                    AppLovinVastMediaView.this.maybeHandleResume();
                }
            }

            public void onActivityPaused(Activity activity) {
                if (activity.equals(AppLovinVastMediaView.this.viewActivity)) {
                    AppLovinVastMediaView.this.maybeHandlePause();
                }
            }
        };
        com.applovin.impl.b.a vastAd2 = appLovinNativeAdImpl.getVastAd();
        this.vastAd = vastAd2;
        boolean FF = vastAd2.FF();
        this.isVideoStream = FF;
        if (u.a(com.applovin.impl.sdk.c.b.aMb, nVar)) {
            checkCachedAdResourcesAsync(!FF);
        }
        if (FF) {
            AppLovinCommunicator.getInstance(context).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        if (vastAd2.LZ()) {
            this.industryIconImageView = com.applovin.impl.b.g.b(vastAd2.LY().Mv(), context, nVar);
            int dpToPx = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPz)).intValue());
            this.industryIconImageView.setLayoutParams(new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPB)).intValue()));
            this.industryIconImageView.setOnClickListener(new a());
            addView(this.industryIconImageView);
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.videoWidgetLinearLayout = linearLayout;
            linearLayout.setOrientation(0);
            this.videoWidgetLinearLayout.setBackgroundResource(R.drawable.applovin_rounded_black_background);
            this.videoWidgetLinearLayout.setAlpha(((Float) nVar.a(com.applovin.impl.sdk.c.b.aPF)).floatValue());
            ImageView imageView = new ImageView(context);
            this.playPauseButtonImageView = imageView;
            imageView.setClickable(true);
            d dVar = new d();
            this.playPauseButtonImageView.setOnClickListener(dVar);
            int dpToPx2 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPD)).intValue());
            this.playPauseButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(dpToPx2, dpToPx2));
            populatePlayPauseImage(false);
            this.videoWidgetLinearLayout.addView(this.playPauseButtonImageView);
            this.muteButtonImageView = new ImageView(context);
            if (populateMuteImage(this.isVideoMuted)) {
                i = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPC)).intValue());
                this.muteButtonImageView.setClickable(true);
                this.muteButtonImageView.setOnClickListener(dVar);
                this.muteButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(i, i));
                this.videoWidgetLinearLayout.addView(this.muteButtonImageView);
            } else {
                i = 0;
            }
            int dpToPx3 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPE)).intValue());
            this.videoWidgetLinearLayout.setPadding(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
            int i2 = dpToPx3 * 2;
            this.videoWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(dpToPx2 + i + i2, Math.max(dpToPx2, i) + i2, 8388691));
            addView(this.videoWidgetLinearLayout);
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPH)).booleanValue()) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.replayIconContainer = frameLayout;
            frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.replayIconContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.replayIconContainer.setVisibility(4);
            this.replayIconContainer.setOnClickListener(new d());
            ImageView imageView2 = new ImageView(getContext());
            int dpToPx4 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPI)).intValue());
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(dpToPx4, dpToPx4, 17));
            imageView2.setImageResource(R.drawable.applovin_ic_replay_icon);
            imageView2.setAdjustViewBounds(true);
            imageView2.setMaxHeight(this.replayIconContainer.getHeight());
            imageView2.setMaxWidth(this.replayIconContainer.getWidth());
            this.replayIconContainer.addView(imageView2);
            addView(this.replayIconContainer);
        }
        aw cY = new aw.a(getContext()).cY();
        this.mediaPlayer = cY;
        c cVar = new c();
        cY.f((an.b) cVar);
        cY.u(0);
        g gVar = new g(getContext());
        this.videoView = gVar;
        gVar.nG();
        gVar.setControllerVisibilityListener(cVar);
        gVar.setPlayer(cY);
        gVar.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLn, getContext(), new b(appLovinNativeAdImpl)));
        addView(gVar);
        bringChildToFront(this.industryIconImageView);
        bringChildToFront(this.videoWidgetLinearLayout);
        prepareMediaPlayer();
        appLovinNativeAdImpl.setVideoView(gVar);
        hashSet.addAll(vastAd2.a(a.c.VIDEO, l.aXV));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeHandleOnAttachedToWindow();
        if (!this.isVideoPausedByUser) {
            maybeHandleResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        maybeHandlePause();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        finishVideo();
        ImageView imageView = this.industryIconImageView;
        if (imageView != null) {
            imageView.setOnClickListener((View.OnClickListener) null);
        }
        ImageView imageView2 = this.playPauseButtonImageView;
        if (imageView2 != null) {
            imageView2.setOnClickListener((View.OnClickListener) null);
        }
        ImageView imageView3 = this.muteButtonImageView;
        if (imageView3 != null) {
            imageView3.setOnClickListener((View.OnClickListener) null);
        }
        FrameLayout frameLayout = this.replayIconContainer;
        if (frameLayout != null) {
            frameLayout.setOnClickListener((View.OnClickListener) null);
        }
        this.videoView.setOnTouchListener((View.OnTouchListener) null);
        this.viewActivity = null;
        this.mediaPlayer.release();
        this.vastAd.getAdEventTracker().IM();
        this.countdownManager.rA();
        this.countdownHandler.removeCallbacksAndMessages((Object) null);
        if (this.isVideoStream) {
            AppLovinCommunicator.getInstance(getContext()).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        super.destroy();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.vastAd.getAdIdNumber() && this.isVideoStream) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.videoWasCompleted && !this.mediaPlayer.v()) {
                    handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    private void prepareMediaPlayer() {
        if (!u.a(com.applovin.impl.sdk.c.b.aMb, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        com.applovin.exoplayer2.h.u c2 = new u.a(new p(getContext(), ai.a(getContext(), "com.applovin.sdk"))).c(ab.a(this.vastAd.FI()));
        this.mediaPlayer.h(this.isVideoMuted ^ true ? 1.0f : 0.0f);
        this.mediaPlayer.a((com.applovin.exoplayer2.h.p) c2);
        this.mediaPlayer.aD();
        this.mediaPlayer.k(false);
    }

    private void maybeHandleOnAttachedToWindow() {
        if (this.initialOnAttachedToWindowHandled.compareAndSet(false, true)) {
            if (this.industryIconImageView != null && this.vastAd.LZ()) {
                maybeFireTrackers(a.c.INDUSTRY_ICON_IMPRESSION);
                this.industryIconImageView.setVisibility(0);
            }
            this.startTimeMillis = SystemClock.elapsedRealtime();
            maybeFireTrackers(a.c.IMPRESSION);
            maybeFireTrackers(a.c.VIDEO, "creativeView");
            this.vastAd.getAdEventTracker().IL();
            this.vastAd.setHasShown(true);
            this.sdk.BD().trackImpression(this.vastAd);
            this.viewActivity = com.applovin.impl.sdk.utils.b.y(com.applovin.impl.sdk.utils.u.A((View) this));
            this.sdk.BM().a(this.lifecycleCallbacksAdapter);
            this.mediaPlayer.k(true);
            this.countdownManager.a(COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING, TimeUnit.SECONDS.toMillis(1), new k.a() {
                public void rB() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis - (AppLovinVastMediaView.this.mediaPlayer.aM() - AppLovinVastMediaView.this.mediaPlayer.aN()));
                    int access$900 = AppLovinVastMediaView.this.getVideoPercentViewed();
                    HashSet hashSet = new HashSet();
                    Iterator it = new HashSet(AppLovinVastMediaView.this.videoProgressTrackers).iterator();
                    while (it.hasNext()) {
                        com.applovin.impl.b.k kVar = (com.applovin.impl.b.k) it.next();
                        if (kVar.h(seconds, access$900)) {
                            hashSet.add(kVar);
                            AppLovinVastMediaView.this.videoProgressTrackers.remove(kVar);
                        }
                    }
                    AppLovinVastMediaView.this.maybeFireTrackers((Set<com.applovin.impl.b.k>) hashSet);
                    if (access$900 >= 25 && access$900 < 50) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IX();
                    } else if (access$900 >= 50 && access$900 < 75) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IY();
                    } else if (access$900 >= 75) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IZ();
                    }
                }

                public boolean rC() {
                    return !AppLovinVastMediaView.this.videoWasCompleted;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void maybeHandlePause() {
        if (this.automaticPauseHandled.compareAndSet(false, true)) {
            maybeFireTrackers(a.c.VIDEO, "pause");
            this.vastAd.getAdEventTracker().Jb();
            pauseVideo();
            populatePlayPauseImage(true);
            this.automaticResumeHandled.set(false);
        }
    }

    /* access modifiers changed from: private */
    public void maybeHandleResume() {
        if (this.automaticResumeHandled.compareAndSet(false, true)) {
            maybeFireTrackers(a.c.VIDEO, "resume");
            this.vastAd.getAdEventTracker().Jc();
            if (this.lastVideoPositionFromPauseMillis >= 0) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    xVar2.f(TAG, "Resuming video at position " + this.lastVideoPositionFromPauseMillis);
                }
                this.mediaPlayer.k(true);
                this.countdownManager.start();
                this.lastVideoPositionFromPauseMillis = -1;
            } else {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    x xVar4 = this.logger;
                    xVar4.f(TAG, "Invalid last video position, isVideoPlaying=" + this.mediaPlayer.v());
                }
            }
            populatePlayPauseImage(false);
            this.automaticPauseHandled.set(false);
        }
    }

    /* access modifiers changed from: private */
    public void finishVideo() {
        maybeFireTrackers(a.c.VIDEO, "close");
        maybeHandlePause();
        this.sdk.BM().b(this.lifecycleCallbacksAdapter);
        if (this.videoWasCompleted) {
            maybeFireRemainingCompletionTrackers();
            this.vastAd.getAdEventTracker().Ja();
        }
        if (this.videoEndListenerNotified.compareAndSet(false, true)) {
            this.sdk.BD().trackVideoEnd(this.vastAd, TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.startTimeMillis), getVideoPercentViewed(), this.isVideoStream);
        }
    }

    private void pauseVideo() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(TAG, "Pausing video");
        }
        this.savedVideoPercentViewed = getVideoPercentViewed();
        this.lastVideoPositionFromPauseMillis = this.mediaPlayer.aN();
        this.mediaPlayer.k(false);
        this.countdownManager.W();
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            xVar3.f(TAG, "Paused video at position " + this.lastVideoPositionFromPauseMillis + " ms");
        }
    }

    private void checkCachedAdResourcesImmediately(boolean z) {
        if (!com.applovin.impl.sdk.utils.u.a(z, (e) this.vastAd, this.sdk, getContext()).isEmpty()) {
            handleUnavailableCachedResources();
        }
    }

    private void checkCachedAdResourcesAsync(boolean z) {
        com.applovin.impl.sdk.utils.u.a(z, (e) this.vastAd, this.sdk, n.getApplicationContext(), (u.a) this);
    }

    public void onCachedResourcesChecked(boolean z) {
        if (!z) {
            handleUnavailableCachedResources();
        }
    }

    private void handleUnavailableCachedResources() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.i(TAG, "Video failed due to unavailable resources");
        }
        finishVideo();
        showMediaImageView();
    }

    /* access modifiers changed from: private */
    public void handleMediaError(String str) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.i(TAG, str);
        }
        maybeFireTrackers(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.vastAd.getAdEventTracker().dj(str);
        if (this.mediaErrorHandled.compareAndSet(false, true)) {
            finishVideo();
            showMediaImageView();
        }
    }

    /* access modifiers changed from: private */
    public void showMediaImageView() {
        if (this.imageView.getDrawable() != null) {
            this.imageView.setVisibility(0);
            this.videoView.setVisibility(8);
            LinearLayout linearLayout = this.videoWidgetLinearLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ImageView imageView = this.industryIconImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void maybeFireRemainingCompletionTrackers() {
        if (getVideoPercentViewed() >= this.vastAd.GE() && !this.videoProgressTrackers.isEmpty()) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h(TAG, "Firing " + this.videoProgressTrackers.size() + " un-fired video progress trackers when video was completed.");
            }
            maybeFireTrackers(this.videoProgressTrackers);
        }
    }

    /* access modifiers changed from: private */
    public int getVideoPercentViewed() {
        long aN = this.mediaPlayer.aN();
        if (this.videoWasCompleted) {
            return 100;
        }
        return aN > 0 ? (int) ((((float) aN) / ((float) this.videoDurationMillis)) * 100.0f) : this.savedVideoPercentViewed;
    }

    private void populatePlayPauseImage(boolean z) {
        if (this.playPauseButtonImageView != null) {
            com.applovin.impl.b.a aVar = this.vastAd;
            Uri Ht = z ? aVar.Ht() : aVar.Hu();
            if (Ht != null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                this.playPauseButtonImageView.setImageURI(Ht);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return;
            }
            this.playPauseButtonImageView.setImageResource(z ? R.drawable.applovin_ic_play_icon : R.drawable.applovin_ic_pause_icon);
        }
    }

    /* access modifiers changed from: private */
    public boolean populateMuteImage(boolean z) {
        if (this.muteButtonImageView == null) {
            return false;
        }
        com.applovin.impl.b.a aVar = this.vastAd;
        Uri Hv = z ? aVar.Hv() : aVar.Hw();
        if (Hv != null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.muteButtonImageView.setImageURI(Hv);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return true;
        } else if (!h.KX()) {
            return false;
        } else {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getContext().getDrawable(z ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable == null) {
                return false;
            }
            this.muteButtonImageView.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void maybeFireTrackers(Set<com.applovin.impl.b.k> set) {
        maybeFireTrackers(set, f.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    public void maybeFireTrackers(a.c cVar) {
        maybeFireTrackers(cVar, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(a.c cVar, String str) {
        maybeFireTrackers(cVar, str, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(a.c cVar, f fVar) {
        maybeFireTrackers(cVar, "", fVar);
    }

    private void maybeFireTrackers(a.c cVar, String str, f fVar) {
        maybeFireTrackers(this.vastAd.a(cVar, str), fVar);
    }

    private void maybeFireTrackers(Set<com.applovin.impl.b.k> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.mediaPlayer.aN());
            o LV = this.vastAd.LV();
            Uri MI = LV != null ? LV.MI() : null;
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f(TAG, "Firing " + set.size() + " tracker(s): " + set);
            }
            m.a(set, seconds, MI, fVar, this.sdk);
        }
    }

    private class c implements an.b, f.d {
        public /* synthetic */ void a(ab abVar, int i) {
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

        private c() {
        }

        public void Z(int i) {
            x xVar = AppLovinVastMediaView.this.logger;
            if (x.Fn()) {
                x xVar2 = AppLovinVastMediaView.this.logger;
                xVar2.f(AppLovinVastMediaView.TAG, "Player state changed to state " + i + " and will play when ready: " + AppLovinVastMediaView.this.mediaPlayer.aE());
            }
            if (i == 3) {
                AppLovinVastMediaView.this.mediaPlayer.h(AppLovinVastMediaView.this.isVideoMuted ^ true ? 1.0f : 0.0f);
                AppLovinVastMediaView appLovinVastMediaView = AppLovinVastMediaView.this;
                long unused = appLovinVastMediaView.videoDurationMillis = appLovinVastMediaView.mediaPlayer.aM();
                AppLovinVastMediaView.this.vastAd.getAdEventTracker().b((float) TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis), com.applovin.impl.sdk.utils.u.P(AppLovinVastMediaView.this.sdk));
                x xVar3 = AppLovinVastMediaView.this.logger;
                if (x.Fn()) {
                    x xVar4 = AppLovinVastMediaView.this.logger;
                    xVar4.f(AppLovinVastMediaView.TAG, "MediaPlayer prepared: " + AppLovinVastMediaView.this.mediaPlayer);
                }
                AppLovinVastMediaView.this.countdownManager.start();
            } else if (i == 4) {
                x xVar5 = AppLovinVastMediaView.this.logger;
                if (x.Fn()) {
                    AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Video completed");
                }
                boolean unused2 = AppLovinVastMediaView.this.videoWasCompleted = true;
                AppLovinVastMediaView.this.finishVideo();
                if (AppLovinVastMediaView.this.replayIconContainer != null) {
                    v.a(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new AppLovinVastMediaView$c$$ExternalSyntheticLambda0(this));
                } else {
                    AppLovinVastMediaView.this.showMediaImageView();
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void HH() {
            AppLovinVastMediaView.this.mediaPlayer.b(0);
        }

        public void a(ak akVar) {
            AppLovinVastMediaView appLovinVastMediaView = AppLovinVastMediaView.this;
            appLovinVastMediaView.handleMediaError("Video view error (" + com.applovin.impl.sdk.utils.u.a(akVar, AppLovinVastMediaView.this.sdk) + ")");
        }

        public void eZ(int i) {
            if (i == 0) {
                AppLovinVastMediaView.this.videoView.nG();
            }
        }
    }

    private class b implements AppLovinTouchToClickListener.OnClickListener {
        private final AppLovinNativeAdImpl aHh;

        public b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.aHh = appLovinNativeAdImpl;
        }

        public void onClick(View view, MotionEvent motionEvent) {
            Uri FL;
            AppLovinVastMediaView.this.maybeFireTrackers(a.c.VIDEO_CLICK);
            AppLovinVastMediaView.this.vastAd.getAdEventTracker().Jg();
            if (AppLovinVastMediaView.this.vastAd.Gq() && (FL = AppLovinVastMediaView.this.vastAd.FL()) != null) {
                x xVar = AppLovinVastMediaView.this.logger;
                if (x.Fn()) {
                    AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Clicking through video");
                }
                AppLovinVastMediaView.this.sdk.BD().maybeSubmitPersistentPostbacks(AppLovinVastMediaView.this.vastAd.a(motionEvent, false));
                this.aHh.handleNativeAdClick(FL, (Uri) null, motionEvent, AppLovinVastMediaView.this.getContext());
            }
        }
    }

    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            Uri Mw;
            com.applovin.impl.b.g LY = AppLovinVastMediaView.this.vastAd.LY();
            if (LY != null && (Mw = LY.Mw()) != null) {
                x xVar = AppLovinVastMediaView.this.logger;
                if (x.Fn()) {
                    x xVar2 = AppLovinVastMediaView.this.logger;
                    xVar2.f(AppLovinVastMediaView.TAG, "Industry icon clicked, opening URL: " + Mw);
                }
                AppLovinVastMediaView.this.maybeFireTrackers(a.c.INDUSTRY_ICON_CLICK);
                s.a(Mw, view.getContext(), AppLovinVastMediaView.this.sdk);
            }
        }
    }

    private class d implements View.OnClickListener {
        private d() {
        }

        public void onClick(View view) {
            if (view == AppLovinVastMediaView.this.playPauseButtonImageView) {
                if (AppLovinVastMediaView.this.mediaPlayer.v()) {
                    boolean unused = AppLovinVastMediaView.this.isVideoPausedByUser = true;
                    AppLovinVastMediaView.this.maybeHandlePause();
                    return;
                }
                boolean unused2 = AppLovinVastMediaView.this.isVideoPausedByUser = false;
                AppLovinVastMediaView.this.maybeHandleResume();
            } else if (view == AppLovinVastMediaView.this.muteButtonImageView) {
                boolean access$1400 = AppLovinVastMediaView.this.isVideoMuted;
                boolean z = !access$1400;
                boolean unused3 = AppLovinVastMediaView.this.isVideoMuted = z;
                AppLovinVastMediaView.this.mediaPlayer.h(access$1400 ? 1.0f : 0.0f);
                boolean unused4 = AppLovinVastMediaView.this.populateMuteImage(z);
            } else if (view == AppLovinVastMediaView.this.replayIconContainer) {
                v.b(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new AppLovinVastMediaView$d$$ExternalSyntheticLambda0(this));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void sQ() {
            boolean unused = AppLovinVastMediaView.this.videoWasCompleted = false;
            AppLovinVastMediaView.this.automaticResumeHandled.set(false);
            AppLovinVastMediaView.this.sdk.BM().a(AppLovinVastMediaView.this.lifecycleCallbacksAdapter);
            AppLovinVastMediaView.this.maybeHandleResume();
        }
    }
}
