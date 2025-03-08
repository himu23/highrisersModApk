package com.ironsource;

import android.webkit.JavascriptInterface;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020\u001f\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020\"¢\u0006\u0004\b-\u0010.J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J8\u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0007J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\b\u0010\u001c\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006/"}, d2 = {"Lcom/ironsource/ub;", "", "", "callbackName", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "", "args", "", "a", "adNetwork", "", "isBidding", "isTest", "loadInterstitialAd", "isInterstitialReady", "showInterstitialAd", "loadRewardedVideoAd", "isRewardedVideoReady", "showRewardedVideoAd", "description", "", "width", "height", "loadBannerAd", "", "marginPercentageFromTop", "addBannerAdToScreen", "destroyBannerAd", "onDataLoaded", "closeTestSuite", "Lcom/ironsource/qb;", "Lcom/ironsource/qb;", "mAdsManager", "Lcom/ironsource/vb;", "b", "Lcom/ironsource/vb;", "mJavaScriptEvaluator", "Lcom/ironsource/x6;", "c", "Lcom/ironsource/x6;", "mUILifeCycleListener", "adsManager", "uiLifeCycleListener", "javaScriptEvaluator", "<init>", "(Lcom/ironsource/qb;Lcom/ironsource/x6;Lcom/ironsource/vb;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ub {
    private final qb a;
    private final vb b;
    private final x6 c;

    public ub(qb qbVar, x6 x6Var, vb vbVar) {
        Intrinsics.checkNotNullParameter(qbVar, "adsManager");
        Intrinsics.checkNotNullParameter(x6Var, "uiLifeCycleListener");
        Intrinsics.checkNotNullParameter(vbVar, "javaScriptEvaluator");
        this.a = qbVar;
        this.b = vbVar;
        this.c = x6Var;
    }

    private final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.b.a(str, ad_unit, list);
    }

    @JavascriptInterface
    public final void addBannerAdToScreen(double d) {
        this.a.a(d);
    }

    @JavascriptInterface
    public final void closeTestSuite() {
        destroyBannerAd();
        this.c.onClosed();
    }

    @JavascriptInterface
    public final void destroyBannerAd() {
        this.a.a();
    }

    @JavascriptInterface
    public final void isInterstitialReady() {
        boolean c2 = this.a.c();
        a("isInterstitialReady", IronSource.AD_UNIT.INTERSTITIAL, cc.a.a(Boolean.valueOf(c2)));
    }

    @JavascriptInterface
    public final void isRewardedVideoReady() {
        boolean d = this.a.d();
        a("isRewardedVideoReady", IronSource.AD_UNIT.REWARDED_VIDEO, cc.a.a(Boolean.valueOf(d)));
    }

    @JavascriptInterface
    public final void loadBannerAd(String str, boolean z, boolean z2, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        Intrinsics.checkNotNullParameter(str2, "description");
        this.a.a(new wb(str, z, Boolean.valueOf(z2)), str2, i, i2);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        this.a.a(new wb(str, z, Boolean.valueOf(z2)));
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        this.a.b(new wb(str, z, Boolean.valueOf(z2)));
    }

    @JavascriptInterface
    public final void onDataLoaded() {
        this.c.onUIReady();
    }

    @JavascriptInterface
    public final void showInterstitialAd() {
        this.a.e();
    }

    @JavascriptInterface
    public final void showRewardedVideoAd() {
        this.a.f();
    }
}
