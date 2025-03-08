package com.ironsource.mediationsdk.ads.nativead;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.e9;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.g9;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0011\b\u0002\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\"\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010\u00128\u0006@BX\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00107\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00104R\u0016\u00109\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u00104R\u0016\u0010;\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b:\u00104R\u0016\u0010?\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006E"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdInterface;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface;", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "", "a", "b", "loadAd", "destroyAd", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "listener", "setListener", "Ljava/util/UUID;", "getObjectId", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAdViewBinder", "onNativeAdLoaded", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onNativeAdLoadFailed", "onNativeAdImpression", "onNativeAdClicked", "", "Ljava/lang/String;", "mPlacementName", "Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/ironsource/mediationsdk/model/Placement;", "mPlacement", "c", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "mListener", "Lcom/ironsource/e9;", "d", "Lcom/ironsource/e9;", "mAdManager", "e", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "mAdapterNativeAdData", "<set-?>", "f", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "getNativeAdViewBinder", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mWasInitCalled", "getTitle", "()Ljava/lang/String;", "title", "getAdvertiser", "advertiser", "getBody", "body", "getCallToAction", "callToAction", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "getIcon", "()Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "icon", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;", "builder", "<init>", "(Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;)V", "Builder", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class LevelPlayNativeAd implements NativeAdInterface, NativeAdDataInterface, InternalNativeAdListener {
    private String a;
    private Placement b;
    private LevelPlayNativeAdListener c;
    private e9 d;
    private AdapterNativeAdData e;
    private AdapterNativeAdViewBinder f;
    private final AtomicBoolean g;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;", "", "", "placementName", "withPlacementName", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "listener", "withListener", "Landroid/app/Activity;", "activity", "withActivity", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "build", "a", "Ljava/lang/String;", "getMPlacementName$mediationsdk_release", "()Ljava/lang/String;", "setMPlacementName$mediationsdk_release", "(Ljava/lang/String;)V", "mPlacementName", "b", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "getMListener$mediationsdk_release", "()Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "setMListener$mediationsdk_release", "(Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;)V", "mListener", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Builder {
        private String a;
        private LevelPlayNativeAdListener b;

        public final LevelPlayNativeAd build() {
            return new LevelPlayNativeAd(this, (DefaultConstructorMarker) null);
        }

        public final LevelPlayNativeAdListener getMListener$mediationsdk_release() {
            return this.b;
        }

        public final String getMPlacementName$mediationsdk_release() {
            return this.a;
        }

        public final void setMListener$mediationsdk_release(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            this.b = levelPlayNativeAdListener;
        }

        public final void setMPlacementName$mediationsdk_release(String str) {
            this.a = str;
        }

        public final Builder withActivity(Activity activity) {
            ContextProvider.getInstance().updateActivity(activity);
            IronLog ironLog = IronLog.INTERNAL;
            StringBuilder sb = new StringBuilder("activity is updated to: ");
            sb.append(activity != null ? activity.hashCode() : 0);
            ironLog.verbose(sb.toString());
            return this;
        }

        public final Builder withListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            Intrinsics.checkNotNullParameter(levelPlayNativeAdListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b = levelPlayNativeAdListener;
            return this;
        }

        public final Builder withPlacementName(String str) {
            this.a = str;
            return this;
        }
    }

    private LevelPlayNativeAd(Builder builder) {
        this.g = new AtomicBoolean(false);
        this.a = builder.getMPlacementName$mediationsdk_release();
        this.c = builder.getMListener$mediationsdk_release();
    }

    public /* synthetic */ LevelPlayNativeAd(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private final void a() {
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("init() has failed", IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd) {
        Unit unit;
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        levelPlayNativeAd.b();
        e9 e9Var = levelPlayNativeAd.d;
        if (e9Var != null) {
            e9Var.a(levelPlayNativeAd.b);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            levelPlayNativeAd.a();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "$adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "$nativeAdViewBinder");
        levelPlayNativeAd.e = adapterNativeAdData;
        levelPlayNativeAd.f = adapterNativeAdViewBinder;
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoaded(levelPlayNativeAd, adInfo);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdClicked(levelPlayNativeAd, adInfo);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(levelPlayNativeAd, ironSourceError);
        }
    }

    private final void b() {
        if (this.g.compareAndSet(false, true)) {
            e9 i = p.o().i();
            this.d = i;
            if (i != null) {
                i.a((InternalNativeAdListener) this);
                g9 o = p.o().o(this.a);
                Intrinsics.checkNotNullExpressionValue(o, "getInstance().getNativeAdPlacement(mPlacementName)");
                this.b = new Placement(o);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdImpression(levelPlayNativeAd, adInfo);
        }
    }

    public void destroyAd() {
        IronLog.API.info(String.valueOf(this));
        try {
            e9 e9Var = this.d;
            if (e9Var != null) {
                e9Var.I();
            }
        } catch (Throwable unused) {
            IronLog.API.error("destroyNativeAd()");
        }
    }

    public String getAdvertiser() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    public String getBody() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    public String getCallToAction() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    public NativeAdDataInterface.Image getIcon() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getIcon();
        }
        return null;
    }

    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.f;
    }

    public final UUID getObjectId() {
        e9 e9Var = this.d;
        if (e9Var != null) {
            return e9Var.h();
        }
        return null;
    }

    public String getTitle() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    public void loadAd() {
        IronLog.API.info(String.valueOf(this));
        String h = p.o().h();
        Intrinsics.checkNotNullExpressionValue(h, "initError");
        if (h.length() > 0) {
            LevelPlayNativeAdListener levelPlayNativeAdListener = this.c;
            if (levelPlayNativeAdListener != null) {
                levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("loadAd(): " + h, IronSourceConstants.NATIVE_AD_UNIT));
                return;
            }
            return;
        }
        IronSourceThreadManager.INSTANCE.getInitHandler().post(new LevelPlayNativeAd$$ExternalSyntheticLambda0(this));
    }

    public void onNativeAdClicked(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda4(this, adInfo), 0, 2, (Object) null);
    }

    public void onNativeAdImpression(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda1(this, adInfo), 0, 2, (Object) null);
    }

    public void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda3(this, ironSourceError), 0, 2, (Object) null);
    }

    public void onNativeAdLoaded(AdInfo adInfo, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda2(this, adapterNativeAdData, adapterNativeAdViewBinder, adInfo), 0, 2, (Object) null);
    }

    public final void setListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
        this.c = levelPlayNativeAdListener;
    }
}
