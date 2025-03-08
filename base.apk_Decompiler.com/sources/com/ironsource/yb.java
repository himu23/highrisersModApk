package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.m2;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bJ\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0006\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0006\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0006\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0006\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0012J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u000eJ\u0010\u0010\u0006\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010!J \u0010\u0006\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0019J\u0016\u0010\u0006\u001a\u00020*2\u0006\u0010\"\u001a\u00020!2\u0006\u0010)\u001a\u00020(J\u0010\u0010\t\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010*J\u0010\u0010\u0006\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010*J\u000e\u0010\t\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002¨\u00062"}, d2 = {"Lcom/ironsource/yb;", "", "", "adapterVersion", "sdkVersion", "Lorg/json/JSONObject;", "a", "Landroid/content/Context;", "context", "b", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "d", "", "isDemandOnlyMode", "Lcom/ironsource/mediationsdk/sdk/LevelPlayInterstitialListener;", "listener", "", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoBaseListener;", "Lcom/ironsource/mediationsdk/sdk/LevelPlayBannerListener;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "Lcom/ironsource/wb;", "loadAdConfig", "", "i", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "networkSettings", "g", "e", "Landroid/app/Activity;", "activity", "h", "f", "description", "width", "height", "Lcom/ironsource/mediationsdk/ISBannerSize;", "size", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "banner", "message", "eventId", "data", "key", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class yb {
    public static final yb a = new yb();

    private yb() {
    }

    private final JSONObject a(String str, String str2) {
        return new JSONObject(MapsKt.mapOf(TuplesKt.to(tb.c, str), TuplesKt.to("sdkVersion", str2)));
    }

    public final int a() {
        return m3.p();
    }

    public final ISBannerSize a(String str, int i, int i2) {
        return new ISBannerSize(str, i, i2);
    }

    public final IronSourceBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iSBannerSize, "size");
        IronSourceBannerLayout b = p.o().b(activity, iSBannerSize);
        Intrinsics.checkNotNullExpressionValue(b, "getInstance().createBanner(activity, size)");
        return b;
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return k0.a(context, c(context));
    }

    public final String a(NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        String providerDefaultInstance = networkSettings.getProviderDefaultInstance();
        return providerDefaultInstance == null ? new String() : providerDefaultInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getPlacementName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.ironsource.mediationsdk.model.Placement r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0008
            java.lang.String r1 = r1.getPlacementName()
            if (r1 != 0) goto L_0x000d
        L_0x0008:
            java.lang.String r1 = new java.lang.String
            r1.<init>()
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.yb.a(com.ironsource.mediationsdk.model.Placement):java.lang.String");
    }

    public final String a(String str) {
        List split$default;
        Intrinsics.checkNotNullParameter(str, m2.h.W);
        try {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "-", false, 2, (Object) null)) {
                String str2 = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) str, new String[]{"-"}, false, 0, 6, (Object) null));
                if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "_", false, 2, (Object) null)) {
                    return str2;
                }
                split$default = StringsKt.split$default((CharSequence) str2, new String[]{"_"}, false, 0, 6, (Object) null);
            } else if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "_", false, 2, (Object) null)) {
                return str;
            } else {
                split$default = StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
            }
            return (String) CollectionsKt.first(split$default);
        } catch (Exception e) {
            IronLog.INTERNAL.error(e.getMessage());
            return str;
        }
    }

    public final JSONObject a(boolean z) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z);
        Intrinsics.checkNotNullExpressionValue(mediationAdditionalData, "getMediationAdditionalData(isDemandOnlyMode)");
        return mediationAdditionalData;
    }

    public final void a(int i, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        va.i().a(new y3(i, jSONObject));
    }

    public final void a(Activity activity) {
        if (activity != null) {
            IronSource.showInterstitial(activity);
        } else {
            IronSource.showInterstitial();
        }
    }

    public final void a(IronSource.AD_UNIT ad_unit, wb wbVar) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        Intrinsics.checkNotNullParameter(wbVar, "loadAdConfig");
        p.o().a(ad_unit, wbVar);
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.destroyBanner(ironSourceBannerLayout);
    }

    public final void a(LevelPlayBannerListener levelPlayBannerListener) {
        f1.a().b(levelPlayBannerListener);
    }

    public final void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        u5.a().b(levelPlayInterstitialListener);
    }

    public final void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        oa.a().b(levelPlayRewardedVideoBaseListener);
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        return networkSettings.isBidder(ad_unit);
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return k0.b(context, c(context));
    }

    public final JSONObject b() {
        JSONObject b = q4.a().b();
        Intrinsics.checkNotNullExpressionValue(b, "getProperties().toJSON()");
        return b;
    }

    public final void b(Activity activity) {
        if (activity != null) {
            IronSource.showRewardedVideo(activity);
        } else {
            IronSource.showRewardedVideo();
        }
    }

    public final void b(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.loadBanner(ironSourceBannerLayout);
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        IronLog.INTERNAL.error(str);
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return k0.g(context);
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, AdapterBaseWrapper> d = c.b().d();
            Intrinsics.checkNotNullExpressionValue(d, "networkAdaptersMap");
            for (Map.Entry next : d.entrySet()) {
                if (((AdapterBaseWrapper) next.getValue()).getAdapterBaseInterface() != null) {
                    yb ybVar = a;
                    Object key = next.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                    String a2 = ybVar.a((String) key);
                    AdapterBaseInterface adapterBaseInterface = ((AdapterBaseWrapper) next.getValue()).getAdapterBaseInterface();
                    Intrinsics.checkNotNullExpressionValue(adapterBaseInterface, "entry.value.adapterBaseInterface");
                    String adapterVersion = adapterBaseInterface.getAdapterVersion();
                    Intrinsics.checkNotNullExpressionValue(adapterVersion, "adapterBaseInterface.adapterVersion");
                    jSONObject.putOpt(a2, ybVar.a(adapterVersion, adapterBaseInterface.getNetworkSDKVersion()));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final ConcurrentHashMap<String, List<String>> d() {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putAll(c.b().c());
        concurrentHashMap.putAll(k8.b().c());
        return concurrentHashMap;
    }

    public final boolean e() {
        return IronSource.isInterstitialReady();
    }

    public final boolean f() {
        return IronSource.isRewardedVideoAvailable();
    }

    public final void g() {
        IronSource.loadInterstitial();
    }

    public final void h() {
        IronSource.loadRewardedVideo();
    }

    public final void i() {
        p.o().P();
    }
}
