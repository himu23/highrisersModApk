package com.ironsource.adapters.ironsource.nativeAd;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.m2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.p6;
import com.ironsource.t6;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J,\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractNativeAdAdapter;", "Lcom/ironsource/adapters/ironsource/IronSourceAdapter;", "Lorg/json/JSONObject;", "config", "", "serverData", "prepareLoadParams", "appKey", "userId", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdSmashListener;", "listener", "", "initNativeAdForBidding", "adData", "loadNativeAdForBidding", "", "", "getNativeAdBiddingData", "destroyNativeAd", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "releaseMemory", "Lcom/ironsource/p6;", "nativeAd", "Lcom/ironsource/p6;", "adapter", "<init>", "(Lcom/ironsource/adapters/ironsource/IronSourceAdapter;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class IronSourceNativeAdAdapter extends AbstractNativeAdAdapter<IronSourceAdapter> {
    private p6 nativeAd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IronSourceNativeAdAdapter(IronSourceAdapter ironSourceAdapter) {
        super(ironSourceAdapter);
        Intrinsics.checkNotNullParameter(ironSourceAdapter, "adapter");
    }

    /* access modifiers changed from: private */
    public static final void loadNativeAdForBidding$lambda$0(IronSourceNativeAdAdapter ironSourceNativeAdAdapter, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener, String str) {
        Intrinsics.checkNotNullParameter(ironSourceNativeAdAdapter, "this$0");
        Intrinsics.checkNotNullParameter(jSONObject, "$config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, "$listener");
        try {
            p6 a = p6.j.a();
            a.a((t6.a) new IronSourceNativeAdListener(new IronSourceNativeAdViewBinder(a, ironSourceNativeAdAdapter.getNativeAdProperties(jSONObject)), nativeAdSmashListener));
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            JSONObject prepareLoadParams = ironSourceNativeAdAdapter.prepareLoadParams(jSONObject, str);
            Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "activity");
            a.a(currentActiveActivity, prepareLoadParams);
            ironSourceNativeAdAdapter.nativeAd = a;
        } catch (Exception e) {
            nativeAdSmashListener.onNativeAdLoadFailed(new IronSourceError(510, "IronSourceAdapter loadNativeAd exception " + e.getMessage()));
        }
    }

    private final JSONObject prepareLoadParams(JSONObject jSONObject, String str) {
        JSONObject put = new JSONObject().put("demandSourceName", ((IronSourceAdapter) getAdapter()).getDemandSourceName(jSONObject)).put(m2.q, "2").put("inAppBidding", true).put(((IronSourceAdapter) getAdapter()).ADM_KEY, d.c().b(str));
        HashMap<String, String> initParams = ((IronSourceAdapter) getAdapter()).getInitParams();
        Intrinsics.checkNotNullExpressionValue(initParams, "extraParams");
        for (Map.Entry next : initParams.entrySet()) {
            put.put((String) next.getKey(), (String) next.getValue());
        }
        Intrinsics.checkNotNullExpressionValue(put, "loadParams");
        return put;
    }

    public void destroyNativeAd(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        p6 p6Var = this.nativeAd;
        if (p6Var != null) {
            p6Var.destroy();
        }
    }

    public Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        return ((IronSourceAdapter) getAdapter()).getBiddingData();
    }

    public void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((IronSourceAdapter) getAdapter()).initSDK(str, jSONObject);
        nativeAdSmashListener.onNativeAdInitSuccess();
    }

    public void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        postOnUIThread(new IronSourceNativeAdAdapter$$ExternalSyntheticLambda0(this, jSONObject, nativeAdSmashListener, str));
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
    }
}
