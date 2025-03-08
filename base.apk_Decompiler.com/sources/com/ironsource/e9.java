package com.ironsource;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.b;
import com.ironsource.q1;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004BE\u0012\u0010\u0010,\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00101\u001a\u000200\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\u0006\u00104\u001a\u00020\u001f¢\u0006\u0004\b5\u00106J<\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017J \u0010\u0015\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0014J\b\u0010!\u001a\u00020\u0014H\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010\u000f\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010'\u001a\u00020\u001fH\u0014J\b\u0010(\u001a\u00020\u000bH\u0014J\b\u0010)\u001a\u00020\u001fH\u0014J\b\u0010*\u001a\u00020\u000bH\u0014¨\u00067"}, d2 = {"Lcom/ironsource/e9;", "Lcom/ironsource/q1;", "Lcom/ironsource/h9;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "Lcom/ironsource/a0;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "providerSettings", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "adapter", "", "sessionDepth", "", "currentAuctionId", "Lcom/ironsource/d1;", "item", "b", "Lcom/ironsource/x;", "e", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "", "a", "I", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "nativeAdListener", "Lcom/ironsource/t1;", "smash", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "", "isReload", "C", "Lcom/ironsource/t;", "event", "", "", "Lorg/json/JSONObject;", "r", "l", "D", "i", "", "providersList", "Lcom/ironsource/a9;", "configs", "userId", "Lcom/ironsource/k8;", "publisherDataHolder", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "segment", "isOneToken", "<init>", "(Ljava/util/List;Lcom/ironsource/a9;Ljava/lang/String;Lcom/ironsource/k8;Lcom/ironsource/mediationsdk/IronSourceSegment;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class e9 extends q1<h9, AdapterAdListener> implements a0 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e9(List<? extends NetworkSettings> list, a9 a9Var, String str, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z) {
        super(new f9(str, list, a9Var), k8Var, ironSourceSegment, z);
        Intrinsics.checkNotNullParameter(a9Var, w5.p);
        Intrinsics.checkNotNullParameter(k8Var, "publisherDataHolder");
    }

    /* access modifiers changed from: protected */
    public void C() {
    }

    /* access modifiers changed from: protected */
    public boolean D() {
        return false;
    }

    public final void I() {
        oc ocVar;
        r8 r8Var;
        IronLog.INTERNAL.verbose();
        try {
            h9 h9Var = (h9) this.a.d();
            if (h9Var != null) {
                Integer r = h9Var.r();
                int a = r == null ? this.C.a(this.o.b()) : r.intValue();
                v vVar = this.s;
                if (!(vVar == null || (r8Var = vVar.g) == null)) {
                    r8Var.a(a);
                }
                h9Var.O();
                this.a.a((t1<?>) null);
            }
            this.i = null;
            a(q1.f.NONE);
        } catch (Throwable th) {
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str));
            v vVar2 = this.s;
            if (vVar2 != null && (ocVar = vVar2.k) != null) {
                ocVar.c(str);
            }
        }
    }

    public Map<String, Object> a(t tVar) {
        Intrinsics.checkNotNullParameter(tVar, NotificationCompat.CATEGORY_EVENT);
        Map<String, Object> a = super.a(tVar);
        Placement placement = this.i;
        if (placement != null) {
            Intrinsics.checkNotNullExpressionValue(a, "data");
            a.put("placement", placement.getPlacementName());
        }
        UUID uuid = this.w;
        if (uuid != null) {
            Intrinsics.checkNotNullExpressionValue(a, "data");
            a.put("objectId", uuid);
        }
        Intrinsics.checkNotNullExpressionValue(a, "data");
        return a;
    }

    public final void a(InternalNativeAdListener internalNativeAdListener) {
        Intrinsics.checkNotNullParameter(internalNativeAdListener, "nativeAdListener");
        a((x) new d9(internalNativeAdListener));
    }

    /* access modifiers changed from: protected */
    public void a(IronSourceError ironSourceError, boolean z) {
        this.t.a(ironSourceError);
    }

    public final void a(Placement placement) {
        String str;
        int i;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placement = " + placement);
        if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            objArr[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load native ad - %s", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            i = s.b(this.o.b());
        } else if (b.b(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName(), this.o.b())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format("placement %s is capped", Arrays.copyOf(new Object[]{placement.getPlacementName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            i = s.f(this.o.b());
        } else {
            str = null;
            i = 510;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(b(str));
            a(i, str, false);
            return;
        }
        this.i = placement;
        w();
    }

    /* access modifiers changed from: protected */
    public void a(t1<?> t1Var, AdInfo adInfo) {
        if (t1Var instanceof h9) {
            h9 h9Var = (h9) t1Var;
            this.t.a(h9Var.P(), h9Var.Q(), adInfo);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public h9 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, int i, String str, d1 d1Var) {
        Intrinsics.checkNotNullParameter(networkSettings, "providerSettings");
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter2 = baseAdAdapter;
        Intrinsics.checkNotNullParameter(baseAdAdapter2, "adapter");
        Intrinsics.checkNotNullParameter(str, "currentAuctionId");
        d1 d1Var2 = d1Var;
        Intrinsics.checkNotNullParameter(d1Var2, "item");
        return new h9(this, new p(IronSource.AD_UNIT.NATIVE_AD, this.o.p(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter2, this.i, d1Var2, this);
    }

    /* access modifiers changed from: protected */
    public JSONObject b(NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(networkSettings, "providerSettings");
        JSONObject nativeAdSettings = networkSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    /* access modifiers changed from: protected */
    public x e() {
        return new s3();
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "NA";
    }

    /* access modifiers changed from: protected */
    public String l() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return false;
    }
}
