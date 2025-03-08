package com.ironsource;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.t1;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004BI\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0014\u0010#\u001a\u0010\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/ironsource/h9;", "Lcom/ironsource/t1;", "Lcom/ironsource/a0;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/NativeAdListener;", "Lcom/ironsource/u;", "", "F", "O", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAdViewBinder", "onAdLoadSuccess", "onAdOpened", "Lcom/ironsource/t;", "event", "", "", "", "a", "<set-?>", "r", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "P", "()Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "s", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "Q", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "Lcom/ironsource/ia;", "threadInterface", "Lcom/ironsource/p;", "adSmashData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "adapter", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "Lcom/ironsource/d1;", "item", "listener", "<init>", "(Lcom/ironsource/ia;Lcom/ironsource/p;Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;Lcom/ironsource/mediationsdk/model/Placement;Lcom/ironsource/d1;Lcom/ironsource/a0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class h9 extends t1<a0> implements NativeAdListener, u {
    private AdapterNativeAdData r;
    private AdapterNativeAdViewBinder s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h9(ia iaVar, p pVar, BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, Placement placement, d1 d1Var, a0 a0Var) {
        super(iaVar, pVar, baseAdAdapter, new h0(pVar.g(), pVar.g().getNativeAdSettings(), IronSource.AD_UNIT.NATIVE_AD), d1Var, a0Var);
        Intrinsics.checkNotNullParameter(iaVar, "threadInterface");
        Intrinsics.checkNotNullParameter(pVar, "adSmashData");
        Intrinsics.checkNotNullParameter(d1Var, "item");
        this.g = placement;
    }

    /* access modifiers changed from: protected */
    public void F() {
        oc ocVar;
        if (!(this.c instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() != null) {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            Intrinsics.checkNotNull(baseAdAdapter, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
            AdData adData = this.k;
            Intrinsics.checkNotNullExpressionValue(adData, "mCurrentAdData");
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getInstance().currentActiveActivity");
            ((AdapterNativeAdInterface) baseAdAdapter).loadAd(adData, currentActiveActivity, this);
        } else {
            IronLog.INTERNAL.error(a("activity must not be null"));
            v vVar = this.d;
            if (vVar != null && (ocVar = vVar.k) != null) {
                ocVar.c("activity must not be null");
            }
        }
    }

    public final void O() {
        r8 r8Var;
        oc ocVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(t1.h.NONE);
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
        if (baseAdAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (baseAdAdapter instanceof AdapterNativeAdInterface) {
                Intrinsics.checkNotNull(baseAdAdapter, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                AdData adData = this.k;
                Intrinsics.checkNotNullExpressionValue(adData, "mCurrentAdData");
                ((AdapterNativeAdInterface) baseAdAdapter).destroyAd(adData);
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            v vVar = this.d;
            if (!(vVar == null || (ocVar = vVar.k) == null)) {
                ocVar.c(str);
            }
        }
        v vVar2 = this.d;
        if (vVar2 != null && (r8Var = vVar2.g) != null) {
            Integer r2 = r();
            Intrinsics.checkNotNullExpressionValue(r2, "sessionDepth");
            r8Var.a(r2.intValue());
        }
    }

    public final AdapterNativeAdData P() {
        return this.r;
    }

    public final AdapterNativeAdViewBinder Q() {
        return this.s;
    }

    public Map<String, Object> a(t tVar) {
        Intrinsics.checkNotNullParameter(tVar, NotificationCompat.CATEGORY_EVENT);
        Map<String, Object> a = super.a(tVar);
        if (this.g != null) {
            Intrinsics.checkNotNullExpressionValue(a, "data");
            a.put("placement", j());
        }
        Intrinsics.checkNotNullExpressionValue(a, "data");
        return a;
    }

    public void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        this.r = adapterNativeAdData;
        this.s = adapterNativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    public void onAdOpened() {
        oc ocVar;
        IronLog.INTERNAL.verbose(d());
        if (x()) {
            super.onAdOpened();
        } else if (this.e != t1.h.FAILED) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("unexpected onAdOpened for %s, state - %s", Arrays.copyOf(new Object[]{k(), this.e}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            v vVar = this.d;
            if (vVar != null && (ocVar = vVar.k) != null) {
                ocVar.l(format);
            }
        }
    }
}
