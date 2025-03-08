package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/ironsource/zb;", "", "", "b", "c", "", "callbackName", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "", "args", "a", "d", "Lcom/ironsource/vb;", "Lcom/ironsource/vb;", "mJavaScriptEvaluator", "javaScriptEvaluator", "<init>", "(Lcom/ironsource/vb;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class zb {
    private final vb a;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"com/ironsource/zb$a", "Lcom/ironsource/mediationsdk/sdk/LevelPlayInterstitialListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", "onAdReady", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onAdLoadFailed", "onAdOpened", "onAdShowSucceeded", "onAdShowFailed", "onAdClicked", "onAdClosed", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements LevelPlayInterstitialListener {
        final /* synthetic */ zb a;

        a(zb zbVar) {
            this.a = zbVar;
        }

        public void onAdClicked(AdInfo adInfo) {
            this.a.a(ac.f, IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(adInfo));
        }

        public void onAdClosed(AdInfo adInfo) {
            this.a.a(ac.g, IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(adInfo));
        }

        public void onAdLoadFailed(IronSourceError ironSourceError) {
            zb zbVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            cc ccVar = cc.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            zbVar.a(ac.b, ad_unit, ccVar.a(objArr));
        }

        public void onAdOpened(AdInfo adInfo) {
            this.a.a(ac.c, IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(adInfo));
        }

        public void onAdReady(AdInfo adInfo) {
            this.a.a(ac.a, IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(adInfo));
        }

        public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            zb zbVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            cc ccVar = cc.a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            zbVar.a(ac.e, ad_unit, ccVar.a(objArr));
        }

        public void onAdShowSucceeded(AdInfo adInfo) {
            this.a.a(ac.d, IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(adInfo));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0013"}, d2 = {"com/ironsource/zb$b", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoManualListener;", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", "onAdReady", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onAdLoadFailed", "onAdAvailable", "onAdUnavailable", "onAdOpened", "onAdShowFailed", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "onAdClicked", "onAdRewarded", "onAdClosed", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements LevelPlayRewardedVideoManualListener, LevelPlayRewardedVideoListener {
        final /* synthetic */ zb a;

        b(zb zbVar) {
            this.a = zbVar;
        }

        public void onAdAvailable(AdInfo adInfo) {
            this.a.a(ac.h, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(adInfo));
        }

        public void onAdClicked(Placement placement, AdInfo adInfo) {
            this.a.a(ac.f, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(yb.a.a(placement), adInfo));
        }

        public void onAdClosed(AdInfo adInfo) {
            this.a.a(ac.g, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(adInfo));
        }

        public void onAdLoadFailed(IronSourceError ironSourceError) {
            zb zbVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            cc ccVar = cc.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            zbVar.a(ac.b, ad_unit, ccVar.a(objArr));
        }

        public void onAdOpened(AdInfo adInfo) {
            this.a.a(ac.c, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(adInfo));
        }

        public void onAdReady(AdInfo adInfo) {
            this.a.a(ac.a, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(adInfo));
        }

        public void onAdRewarded(Placement placement, AdInfo adInfo) {
            this.a.a(ac.i, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(yb.a.a(placement), adInfo));
        }

        public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            zb zbVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            cc ccVar = cc.a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            zbVar.a(ac.e, ad_unit, ccVar.a(objArr));
        }

        public void onAdUnavailable() {
            this.a.a(ac.n, IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(new Object[0]));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"com/ironsource/zb$c", "Lcom/ironsource/mediationsdk/sdk/LevelPlayBannerListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", "onAdLoaded", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onAdLoadFailed", "onAdClicked", "onAdLeftApplication", "onAdScreenPresented", "onAdScreenDismissed", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements LevelPlayBannerListener {
        final /* synthetic */ zb a;

        c(zb zbVar) {
            this.a = zbVar;
        }

        public void onAdClicked(AdInfo adInfo) {
            this.a.a(ac.f, IronSource.AD_UNIT.BANNER, cc.a.a(adInfo));
        }

        public void onAdLeftApplication(AdInfo adInfo) {
            this.a.a(ac.k, IronSource.AD_UNIT.BANNER, cc.a.a(adInfo));
        }

        public void onAdLoadFailed(IronSourceError ironSourceError) {
            zb zbVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            cc ccVar = cc.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            zbVar.a(ac.b, ad_unit, ccVar.a(objArr));
        }

        public void onAdLoaded(AdInfo adInfo) {
            this.a.a(ac.j, IronSource.AD_UNIT.BANNER, cc.a.a(adInfo));
        }

        public void onAdScreenDismissed(AdInfo adInfo) {
            this.a.a(ac.m, IronSource.AD_UNIT.BANNER, cc.a.a(adInfo));
        }

        public void onAdScreenPresented(AdInfo adInfo) {
            this.a.a(ac.l, IronSource.AD_UNIT.BANNER, cc.a.a(adInfo));
        }
    }

    public zb(vb vbVar) {
        Intrinsics.checkNotNullParameter(vbVar, "javaScriptEvaluator");
        this.a = vbVar;
    }

    /* access modifiers changed from: private */
    public final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.a.a(str, ad_unit, list);
    }

    private final void b() {
        yb ybVar = yb.a;
        ybVar.a((LevelPlayInterstitialListener) null);
        ybVar.a((LevelPlayRewardedVideoBaseListener) null);
        ybVar.a((LevelPlayBannerListener) null);
    }

    private final void c() {
        yb.a.i();
    }

    public final void a() {
        b();
        c();
    }

    public final void d() {
        yb ybVar = yb.a;
        ybVar.a((LevelPlayInterstitialListener) new a(this));
        ybVar.a((LevelPlayRewardedVideoBaseListener) new b(this));
        ybVar.a((LevelPlayBannerListener) new c(this));
    }
}
