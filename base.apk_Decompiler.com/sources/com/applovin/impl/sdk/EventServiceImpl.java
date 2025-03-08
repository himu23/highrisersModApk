package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.m2;
import com.ironsource.t4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList(new String[]{"landing", m2.h.f0, "resumed", "cf_start", "tos_ok", "gdpr_ok"});
    private final Map<String, Object> aES;
    private final AtomicBoolean aET = new AtomicBoolean();
    private final n sdk;

    public String toString() {
        return "EventService{}";
    }

    public EventServiceImpl(n nVar) {
        this.sdk = nVar;
        if (((Boolean) nVar.a(b.aLE)).booleanValue()) {
            this.aES = JsonUtils.toStringObjectMap((String) nVar.b(d.aRG, JsonUtils.EMPTY_JSON));
            return;
        }
        this.aES = new HashMap();
        nVar.a(d.aRG, JsonUtils.EMPTY_JSON);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.aET.compareAndSet(false, true)) {
            this.sdk.BF().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            x.H("AppLovinEventService", "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.aES.remove(str);
            EY();
        } else {
            List<String> b = this.sdk.b(b.aLD);
            if (!u.a(obj, b, this.sdk)) {
                x.H("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b);
                return;
            }
            this.aES.put(str, u.a(obj, this.sdk));
            EY();
        }
    }

    public Map<String, Object> getSuperProperties() {
        return CollectionUtils.map(this.aES);
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            x.e("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            this.sdk.Cs().d("AppLovinEventService", "trackIAP", th);
        }
        trackEvent("iap", map2);
    }

    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null);
    }

    public void trackEvent(String str, Map<String, String> map, Map<String, String> map2) {
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        s sVar = new s(str, map, this.aES);
        boolean contains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        try {
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, contains, "submitTrackEventPostback", new EventServiceImpl$$ExternalSyntheticLambda0(this, sVar, map2, contains)), q.b.BACKGROUND);
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN2 = this.sdk.BN();
                BN2.c("AppLovinEventService", "Unable to track event: " + sVar, th);
            }
            this.sdk.Cs().d("AppLovinEventService", "trackEvent", th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(s sVar, Map map, boolean z) {
        Map<String, String> a = a(sVar, false);
        Map<String, Object> EU = sVar.EU();
        if (((Boolean) this.sdk.a(b.aQd)).booleanValue() || ((Boolean) this.sdk.a(b.aPY)).booleanValue()) {
            EU.putAll(a);
            a = null;
        }
        this.sdk.Cu().a(h.ID().dd(EW()).de(EX()).n(a).p(EU).o(a(sVar, (Map<String, String>) map)).aW(((Boolean) this.sdk.a(b.aQn)).booleanValue()).aV(((Boolean) this.sdk.a(b.aPL)).booleanValue()).aX(z).b(p.a.gW(((Integer) this.sdk.a(b.aPV)).intValue())).IF());
    }

    public void trackEventSynchronously(String str) {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        s sVar = new s(str, new HashMap(), this.aES);
        Map<String, String> a = a(sVar, true);
        Map<String, Object> EU = sVar.EU();
        if (((Boolean) this.sdk.a(b.aQd)).booleanValue() || ((Boolean) this.sdk.a(b.aPY)).booleanValue()) {
            EU.putAll(a);
            a = null;
        }
        this.sdk.Cu().a(h.ID().dd(EW()).de(EX()).n(a).p(EU).o(a(sVar, (Map<String, String>) null)).aW(((Boolean) this.sdk.a(b.aQn)).booleanValue()).aV(((Boolean) this.sdk.a(b.aPL)).booleanValue()).IF());
    }

    private String EW() {
        return ((String) this.sdk.a(b.aLy)) + "4.0/pix";
    }

    private String EX() {
        return ((String) this.sdk.a(b.aLz)) + "4.0/pix";
    }

    private Map<String, String> a(s sVar, boolean z) {
        Map<String, Object> map;
        boolean contains = this.sdk.b(b.aLC).contains(sVar.getName());
        if (this.sdk.BV() != null) {
            map = this.sdk.BV().a((Map<String, String>) null, z, false);
        } else {
            map = this.sdk.BS().a((Map<String, String>) null, z, false);
        }
        map.put(NotificationCompat.CATEGORY_EVENT, contains ? sVar.getName() : "postinstall");
        map.put("event_id", sVar.mQ());
        map.put(t4.R0, Long.toString(sVar.EV()));
        if (!contains) {
            map.put("sub_event", sVar.getName());
        }
        return u.s(map);
    }

    private Map<String, String> a(s sVar, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        boolean contains = this.sdk.b(b.aLC).contains(sVar.getName());
        map2.put("AppLovin-Event", contains ? sVar.getName() : "postinstall");
        if (!contains) {
            map2.put("AppLovin-Sub-Event", sVar.getName());
        }
        return map2;
    }

    private void EY() {
        if (((Boolean) this.sdk.a(b.aLE)).booleanValue()) {
            this.sdk.a(d.aRG, CollectionUtils.toJsonString(this.aES, JsonUtils.EMPTY_JSON));
        }
    }
}
