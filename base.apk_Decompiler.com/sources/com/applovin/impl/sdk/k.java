package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.communicator.c;
import com.applovin.impl.mediation.b.a;
import com.applovin.impl.mediation.b.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.mediationsdk.d;
import com.ironsource.w5;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class k implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {
    private final AppLovinCommunicator agf;
    private final n sdk;

    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    k(n nVar) {
        this.sdk = nVar;
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(n.getApplicationContext());
        this.agf = instance;
        if (!nVar.Bq() && ((Boolean) nVar.a(b.aRd)).booleanValue()) {
            instance.a(nVar);
            instance.subscribe((AppLovinCommunicatorSubscriber) this, c.akg);
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("safedk_init")) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
            bundle.putString("applovin_random_token", this.sdk.BB());
            bundle.putString("compass_random_token", this.sdk.BA());
            bundle.putString("device_type", AppLovinSdkUtils.isTablet(n.getApplicationContext()) ? "tablet" : "phone");
            bundle.putString("init_success", String.valueOf(z));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(com.applovin.impl.mediation.e.c.f(this.sdk)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", (JSONObject) null);
            Bundle bundle2 = (Bundle) bundle.clone();
            bundle2.putString("user_id", this.sdk.Bz());
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject());
            if (!((Boolean) this.sdk.a(b.aRe)).booleanValue()) {
                JSONObject jSONObject4 = new JSONObject();
                JsonUtils.putBoolean(jSONObject4, "deactivated", true);
                JsonUtils.putJSONObject(jSONObject3, "safeDKDeactivation", jSONObject4);
            }
            bundle2.putBundle(d.f, JsonUtils.toBundle(jSONObject3));
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            c(bundle2, "safedk_init");
        }
    }

    public void z(String str, String str2) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("user_info")) {
            Bundle bundle = new Bundle(2);
            bundle.putString("user_id", StringUtils.emptyIfNull(str));
            bundle.putString("applovin_random_token", str2);
            c(bundle, "user_info");
        }
    }

    public void a(a aVar, String str) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("max_ad_events")) {
            Bundle k = k(aVar);
            k.putString("type", str);
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("CommunicatorService", "Sending \"max_ad_events\" message: " + k);
            }
            c(k, "max_ad_events");
        }
    }

    public void j(a aVar) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("max_revenue_events")) {
            Bundle k = k(aVar);
            k.putAll(JsonUtils.toBundle(aVar.xy()));
            k.putString("country_code", this.sdk.getConfiguration().getCountryCode());
            BundleUtils.putStringIfValid("user_segment", this.sdk.getUserSegment().getName(), k);
            c(k, "max_revenue_events");
        }
    }

    public void b(a aVar, String str) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("ad_callback_blocked_after_hidden")) {
            Bundle k = k(aVar);
            k.putString("callback_name", str);
            c(k, "ad_callback_blocked_after_hidden");
        }
    }

    public void b(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("adapter_initialization_status")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            c(bundle, "adapter_initialization_status");
        }
    }

    public void Bd() {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("privacy_setting_updated")) {
            c(new Bundle(), "privacy_setting_updated");
        }
    }

    public void A(String str, String str2) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("network_sdk_version_updated")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString("sdk_version", str);
            c(bundle, "network_sdk_version_updated");
        }
    }

    public void G(List<String> list) {
        if (!((Boolean) this.sdk.a(b.aRd)).booleanValue() || !this.agf.hasSubscriber("live_networks_updated")) {
            return;
        }
        if (list == null || list.isEmpty()) {
            c(Bundle.EMPTY, "live_networks_updated");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("live_networks", new ArrayList(list));
        c(bundle, "live_networks_updated");
    }

    public void H(List<String> list) {
        if (!((Boolean) this.sdk.a(b.aRd)).booleanValue() || !this.agf.hasSubscriber("test_mode_networks_updated")) {
            return;
        }
        if (list == null || list.isEmpty()) {
            c(Bundle.EMPTY, "test_mode_networks_updated");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("test_mode_networks", new ArrayList(list));
        c(bundle, "test_mode_networks_updated");
    }

    public void b(String str, String str2, String str3) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("responses")) {
            String maybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String maybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", maybeConvertToIndentedString);
            bundle.putString(com.ironsource.mediationsdk.utils.c.Y1, maybeConvertToIndentedString2);
            c(bundle, "responses");
        }
    }

    public void a(String str, String str2, int i, Object obj, String str3, boolean z) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber("receive_http_response")) {
            Bundle bundle = new Bundle();
            bundle.putString(w5.x, str);
            bundle.putString("url", str2);
            bundle.putInt("code", i);
            bundle.putBundle(m2.h.E0, JsonUtils.toBundle(obj));
            bundle.putBoolean("success", z);
            BundleUtils.putString("error_message", str3, bundle);
            c(bundle, "receive_http_response");
        }
    }

    public void c(Bundle bundle, String str) {
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue() && this.agf.hasSubscriber(str) && !this.sdk.Bq()) {
            this.agf.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this));
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        long j;
        long j2;
        int i;
        Map<String, Object> map;
        Map<String, Object> map2;
        Map<String, Object> map3;
        Map<String, Object> map4;
        if (((Boolean) this.sdk.a(b.aRd)).booleanValue()) {
            if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map5 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString(w5.x, "");
                if (!map5.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map5.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                }
                this.sdk.Cu().a(new h.a().dd(messageData.getString("url")).de(messageData.getString("backup_url")).n(stringMap).p(map5).o(stringMap2).aV(((Boolean) this.sdk.a(b.aPL)).booleanValue()).db(string).IF());
            } else if ("send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
                String string2 = messageData2.getString("http_method", i9.b);
                if (messageData2.containsKey("timeout_sec")) {
                    j = TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec"));
                } else {
                    j = ((Long) this.sdk.a(b.aOc)).longValue();
                }
                int i2 = messageData2.getInt("retry_count", ((Integer) this.sdk.a(b.aOd)).intValue());
                if (messageData2.containsKey("retry_delay_sec")) {
                    j2 = TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec"));
                } else {
                    j2 = ((Long) this.sdk.a(b.aOe)).longValue();
                }
                Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
                long j3 = j2;
                if (i9.a.equalsIgnoreCase(string2)) {
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        if (this.sdk.BV() != null) {
                            map4 = this.sdk.BV().a((Map<String, String>) null, false, false);
                        } else {
                            map4 = this.sdk.BS().a((Map<String, String>) null, false, false);
                        }
                        stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(map4)));
                    }
                    i = i2;
                    map = null;
                } else {
                    map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        if (this.sdk.BV() != null) {
                            map3 = this.sdk.BV().DI();
                            map2 = this.sdk.BV().CV();
                        } else {
                            map3 = this.sdk.BS().Db();
                            map2 = this.sdk.BS().CV();
                        }
                        if (!map2.containsKey("idfv") || !map2.containsKey("idfv_scope")) {
                            i = i2;
                        } else {
                            i = i2;
                            int intValue = ((Integer) map2.get("idfv_scope")).intValue();
                            map2.remove("idfv");
                            map2.remove("idfv_scope");
                            map3.put("idfv", (String) map2.get("idfv"));
                            map3.put("idfv_scope", Integer.valueOf(intValue));
                        }
                        map3.put("server_installed_at", this.sdk.a(b.aKu));
                        map3.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                        map.put("app", map3);
                        map.put(m2.h.G, map2);
                    } else {
                        i = i2;
                    }
                }
                this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.sdk.network.a(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.c.D(this.sdk).cW(messageData2.getString("url")).cY(messageData2.getString("backup_url")).k(stringMap3).cX(string2).l(BundleUtils.toStringMap(messageData2.getBundle("headers"))).K(map != null ? new JSONObject(map) : null).gF((int) j).gE(i).gG((int) j3).ad(new JSONObject()).aS(messageData2.getBoolean("is_encoding_enabled", false)).Ig(), this.sdk), q.b.MAIN);
            } else if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.BD().addCustomQueryParams(u.s(BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
            } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.BD().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            } else if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.Cy().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            }
        }
    }

    public boolean respondsToTopic(String str) {
        return c.akg.contains(str);
    }

    private Bundle k(a aVar) {
        Object obj;
        String str;
        Bundle bundle = new Bundle();
        bundle.putString(w5.x, aVar.xA());
        bundle.putString("network_name", aVar.yA());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.getThirdPartyAdPlacementId());
        bundle.putString("ad_format", aVar.getFormat().getLabel());
        BundleUtils.putStringIfValid("creative_id", aVar.getCreativeId(), bundle);
        BundleUtils.putStringIfValid("adomain", aVar.xB(), bundle);
        BundleUtils.putStringIfValid("dsp_name", aVar.getDspName(), bundle);
        if (aVar.xF()) {
            BundleUtils.putStringIfValid("hybrid_ad_format", aVar.xE().getLabel(), bundle);
        }
        if (aVar.xD()) {
            bundle.putString("custom_js_network_name", aVar.getNetworkName());
        } else if ("CUSTOM_NETWORK_SDK".equalsIgnoreCase(aVar.yA())) {
            bundle.putString("custom_sdk_network_name", aVar.getNetworkName());
        }
        bundle.putAll(JsonUtils.toBundle(aVar.xw()));
        if (aVar instanceof e) {
            if (aVar instanceof com.applovin.impl.mediation.b.b) {
                obj = ((com.applovin.impl.mediation.b.b) aVar).getAdView();
            } else {
                if (aVar instanceof com.applovin.impl.mediation.b.d) {
                    com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) aVar;
                    if (!dVar.ur()) {
                        obj = dVar.yl() != null ? dVar.yl() : dVar.ym();
                    }
                }
                obj = null;
            }
            if (obj != null) {
                str = obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
            } else {
                str = "N/A";
            }
            bundle.putString("ad_view", str);
        }
        return bundle;
    }
}
