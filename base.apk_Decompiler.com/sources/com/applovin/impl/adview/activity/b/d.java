package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.adview.k;
import com.applovin.impl.b.a;
import com.applovin.impl.b.f;
import com.applovin.impl.b.g;
import com.applovin.impl.b.k;
import com.applovin.impl.b.l;
import com.applovin.impl.b.m;
import com.applovin.impl.b.o;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class d extends f {
    /* access modifiers changed from: private */
    public final a ajq;
    /* access modifiers changed from: private */
    public final Set<k> videoProgressTrackers;

    public d(e eVar, Activity activity, Map<String, Object> map, n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.videoProgressTrackers = hashSet;
        a aVar = (a) eVar;
        this.ajq = aVar;
        if (aVar.LZ()) {
            this.industryIconImageView = g.b(aVar.LY().Mv(), activity, nVar);
            this.industryIconImageView.setOnClickListener(new d$$ExternalSyntheticLambda0(this, activity, nVar));
        }
        hashSet.addAll(aVar.a(a.c.VIDEO, l.aXV));
        maybeFireTrackers(a.c.IMPRESSION);
        maybeFireTrackers(a.c.VIDEO, "creativeView");
        aVar.getAdEventTracker().IL();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, n nVar, View view) {
        Uri Mw = this.ajq.LY().Mw();
        if (Mw != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("AppLovinFullscreenActivity", "Industry Icon clicked, opening URL: " + Mw);
            }
            maybeFireTrackers(a.c.INDUSTRY_ICON_CLICK);
            s.a(Mw, (Context) activity, nVar);
        }
    }

    public void onPause() {
        super.onPause();
        maybeFireTrackers(this.ajC ? a.c.COMPANION : a.c.VIDEO, "pause");
        this.ajq.getAdEventTracker().Jb();
    }

    public void onResume() {
        super.onResume();
        maybeFireTrackers(this.ajC ? a.c.COMPANION : a.c.VIDEO, "resume");
        this.ajq.getAdEventTracker().Jc();
    }

    public void dismiss() {
        if (this.ajq != null) {
            maybeFireTrackers(a.c.VIDEO, "close");
            maybeFireTrackers(a.c.COMPANION, "close");
        }
        super.dismiss();
    }

    public void sA() {
        a((ViewGroup) null);
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        if (td()) {
            maybeFireTrackers(a.c.INDUSTRY_ICON_IMPRESSION);
            this.industryIconImageView.setVisibility(0);
        }
        this.countdownManager.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1), new k.a() {
            public void rB() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(d.this.videoDurationMillis - ((long) (d.this.ajM.getDuration() - d.this.ajM.getCurrentPosition())));
                int videoPercentViewed = d.this.getVideoPercentViewed();
                HashSet hashSet = new HashSet();
                for (com.applovin.impl.b.k kVar : new HashSet(d.this.videoProgressTrackers)) {
                    if (kVar.h(seconds, videoPercentViewed)) {
                        hashSet.add(kVar);
                        d.this.videoProgressTrackers.remove(kVar);
                    }
                }
                d.this.maybeFireTrackers((Set<com.applovin.impl.b.k>) hashSet);
                if (videoPercentViewed >= 25 && videoPercentViewed < 50) {
                    d.this.ajq.getAdEventTracker().IX();
                } else if (videoPercentViewed >= 50 && videoPercentViewed < 75) {
                    d.this.ajq.getAdEventTracker().IY();
                } else if (videoPercentViewed >= 75) {
                    d.this.ajq.getAdEventTracker().IZ();
                }
            }

            public boolean rC() {
                return !d.this.ajC;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (this.aju != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aju, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        if (this.ajv != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajv, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        if (this.ajw != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajw, FriendlyObstructionPurpose.OTHER, "countdown clock"));
        }
        if (this.agb != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agb, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        if (this.ajy != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajy, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        if (this.muteButtonImageView != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.muteButtonImageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        if (this.ajx != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajx, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.ajq.getAdEventTracker().a(this.ajM, arrayList);
    }

    /* access modifiers changed from: protected */
    public void bG(long j) {
        super.bG(j);
        this.ajq.getAdEventTracker().b((float) TimeUnit.MILLISECONDS.toSeconds(j), u.P(this.sdk));
    }

    public void a(MotionEvent motionEvent, Bundle bundle) {
        maybeFireTrackers(a.c.VIDEO_CLICK);
        this.ajq.getAdEventTracker().Jg();
        super.a(motionEvent, bundle);
    }

    public void pauseVideo() {
        this.countdownManager.W();
        super.pauseVideo();
    }

    public void sY() {
        maybeFireTrackers(a.c.VIDEO, "skip");
        this.ajq.getAdEventTracker().Jf();
        super.sY();
    }

    /* access modifiers changed from: protected */
    public void sZ() {
        super.sZ();
        a aVar = this.ajq;
        if (aVar != null) {
            aVar.getAdEventTracker().Jd();
        }
    }

    /* access modifiers changed from: protected */
    public void ta() {
        super.ta();
        a aVar = this.ajq;
        if (aVar != null) {
            aVar.getAdEventTracker().Je();
        }
    }

    public void handleMediaError(String str) {
        maybeFireTrackers(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.ajq.getAdEventTracker().dj(str);
        super.handleMediaError(str);
    }

    public void tb() {
        super.tb();
        maybeFireTrackers(a.c.VIDEO, this.isVideoMuted ? "mute" : "unmute");
        this.ajq.getAdEventTracker().bc(this.isVideoMuted);
    }

    public void tc() {
        maybeFireRemainingCompletionTrackers();
        if (!m.c(this.ajq)) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            dismiss();
        } else if (!this.ajC) {
            maybeFireTrackers(a.c.COMPANION, "creativeView");
            this.ajq.getAdEventTracker().Ja();
            super.tc();
        }
    }

    private void maybeFireRemainingCompletionTrackers() {
        if (sI() && !this.videoProgressTrackers.isEmpty()) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("AppLovinFullscreenActivity", "Firing " + this.videoProgressTrackers.size() + " un-fired video progress trackers when video was completed.");
            }
            maybeFireTrackers(this.videoProgressTrackers);
        }
    }

    /* access modifiers changed from: private */
    public void maybeFireTrackers(Set<com.applovin.impl.b.k> set) {
        maybeFireTrackers(set, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(a.c cVar) {
        maybeFireTrackers(cVar, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(a.c cVar, String str) {
        maybeFireTrackers(cVar, str, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(a.c cVar, f fVar) {
        maybeFireTrackers(cVar, "", fVar);
    }

    private void maybeFireTrackers(a.c cVar, String str, f fVar) {
        maybeFireTrackers(this.ajq.a(cVar, str), fVar);
    }

    private void maybeFireTrackers(Set<com.applovin.impl.b.k> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.ajM.getCurrentPosition());
            o LV = this.ajq.LV();
            Uri MI = LV != null ? LV.MI() : null;
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
            }
            m.a(set, seconds, MI, fVar, this.sdk);
        }
    }

    /* access modifiers changed from: protected */
    public void sL() {
        long j;
        int Ge;
        long j2 = 0;
        if (this.ajq.GT() >= 0 || this.ajq.GU() >= 0) {
            if (this.ajq.GT() >= 0) {
                j = this.ajq.GT();
            } else {
                a aVar = this.ajq;
                com.applovin.impl.b.n LU = aVar.LU();
                if (LU != null && LU.MH() > 0) {
                    j2 = TimeUnit.SECONDS.toMillis((long) LU.MH());
                } else if (this.videoDurationMillis > 0) {
                    j2 = this.videoDurationMillis;
                }
                if (aVar.GV() && (Ge = (int) aVar.Ge()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) Ge);
                }
                j = (long) (((double) j2) * (((double) this.ajq.GU()) / 100.0d));
            }
            bF(j);
        }
    }

    private boolean td() {
        return this.industryIconImageView != null && this.ajq.LZ();
    }
}
