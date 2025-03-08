package com.ironsource.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.g8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.json.JSONObject;

public abstract class a<Listener extends AdapterAdListener> extends BaseAdAdapter<u, Listener> implements AdapterAdFullScreenInterface<Listener>, AdapterBannerInterface<Listener>, AdapterNativeAdInterface<Listener> {
    protected AbstractAdapter a;
    protected WeakReference<Listener> b = new WeakReference<>((Object) null);

    public a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        super(ad_unit, networkSettings, uuid);
        this.a = abstractAdapter;
    }

    public static a<?> a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return new b0(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return new o(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return new j(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return new t(abstractAdapter, networkSettings, uuid);
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("ad unit not supported - " + ad_unit);
        return null;
    }

    private void a(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        a(g8.a(adData.getConfiguration()), g8.a(adData.getAdUnitData()), adData);
    }

    private void b(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error(a("Method '" + str + "' is not supported for " + getClass().getName()));
    }

    /* access modifiers changed from: protected */
    public String a() {
        return a((String) null);
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        String ad_unit = b().toString();
        if (TextUtils.isEmpty(str)) {
            return ad_unit;
        }
        return ad_unit + " - " + str;
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        b("destroyAd");
    }

    /* access modifiers changed from: protected */
    public abstract void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData);

    /* access modifiers changed from: protected */
    public abstract IronSource.AD_UNIT b();

    /* access modifiers changed from: protected */
    public boolean b(JSONObject jSONObject) {
        b("isAdAvailable");
        return false;
    }

    /* access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        b("showAd");
    }

    public void destroyAd(AdData adData) {
        a(g8.a(adData.getConfiguration()));
    }

    public boolean isAdAvailable(AdData adData) {
        return b(g8.a(adData.getConfiguration()));
    }

    public void loadAd(AdData adData, Activity activity, ISBannerSize iSBannerSize, Listener listener) {
        a(adData, listener);
    }

    public void loadAd(AdData adData, Activity activity, Listener listener) {
        a(adData, listener);
    }

    public void releaseMemory() {
        IronLog.INTERNAL.verbose(a());
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter != null) {
            abstractAdapter.releaseMemory(b(), new JSONObject());
            this.a = null;
        }
    }

    public void showAd(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        c(g8.a(adData.getConfiguration()));
    }
}
