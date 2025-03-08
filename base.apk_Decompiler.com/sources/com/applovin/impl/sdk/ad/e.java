package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.u;
import com.applovin.impl.adview.y;
import com.applovin.impl.sdk.af;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e extends AppLovinAdImpl {
    private List<com.applovin.impl.sdk.d.a> aGA;
    private List<com.applovin.impl.sdk.d.a> aGB;
    private List<com.applovin.impl.sdk.d.a> aGC;
    private List<com.applovin.impl.sdk.d.a> aGD;
    private c aGE;
    private final List<Uri> aGw = CollectionUtils.synchronizedList();
    private final AtomicBoolean aGx = new AtomicBoolean();
    private final AtomicBoolean aGy = new AtomicBoolean();
    private final AtomicReference<com.applovin.impl.sdk.b.c> aGz = new AtomicReference<>();

    public enum a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    public enum b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public enum d {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public abstract void FA();

    public abstract String FD();

    public AtomicBoolean GW() {
        return this.aGx;
    }

    public List<Uri> Gn() {
        return this.aGw;
    }

    public abstract com.applovin.impl.sdk.a.b getAdEventTracker();

    public abstract boolean isOpenMeasurementEnabled();

    public class c {
        public final int aGN;
        public final int aGO;
        public final int aGP;
        public final int aGQ;
        public final int aGR;

        private c() {
            this.aGN = AppLovinSdkUtils.dpToPx(n.getApplicationContext(), e.this.GO());
            this.aGO = AppLovinSdkUtils.dpToPx(n.getApplicationContext(), e.this.GP());
            this.aGP = AppLovinSdkUtils.dpToPx(n.getApplicationContext(), e.this.GQ());
            this.aGQ = AppLovinSdkUtils.dpToPx(n.getApplicationContext(), ((Integer) e.this.sdk.a(com.applovin.impl.sdk.c.b.aMq)).intValue());
            this.aGR = AppLovinSdkUtils.dpToPx(n.getApplicationContext(), ((Integer) e.this.sdk.a(com.applovin.impl.sdk.c.b.aMp)).intValue());
        }
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        super(jSONObject, jSONObject2, bVar, nVar);
    }

    public b Gb() {
        String upperCase = getStringFromAdObject("ad_target", b.DEFAULT.toString()).toUpperCase(Locale.ENGLISH);
        if ("ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase)) {
            return b.ACTIVITY_PORTRAIT;
        }
        if ("ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase)) {
            return b.ACTIVITY_LANDSCAPE;
        }
        return b.DEFAULT;
    }

    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", (String) null);
    }

    public Bundle getDirectDownloadParameters() {
        return JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", (JSONObject) null));
    }

    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", (String) null);
    }

    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.adObjectLock) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.adObject, "omid_verification_script_resources", (JSONArray) null);
            if (jSONArray != null) {
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
                    try {
                        URL url = new URL(JsonUtils.getString(jSONObject, "url", (String) null));
                        String string = JsonUtils.getString(jSONObject, "vendor_key", (String) null);
                        String string2 = JsonUtils.getString(jSONObject, "parameters", (String) null);
                        if (!StringUtils.isValidString(string) || !StringUtils.isValidString(string2)) {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                            i++;
                        } else {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                            i++;
                        }
                    } catch (Throwable th) {
                        this.sdk.BN();
                        if (x.Fn()) {
                            this.sdk.BN().c("DirectAd", "Failed to parse OMID verification script resource", th);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean shouldInjectOpenMeasurementScriptDuringCaching() {
        return getBooleanFromAdObject("iopmsdc", false);
    }

    public long Gc() {
        return getLongFromAdObject("close_delay", 0);
    }

    public long Gd() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5));
    }

    public long Ge() {
        List<Integer> Gf = Gf();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (Gf == null || Gf.size() <= 0) ? 0 : (long) Gf.get(0).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0;
        }
        return longFromAdObject;
    }

    public List<Integer> Gf() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", (List<Integer>) null);
    }

    public j.a Gg() {
        List<Integer> Gi = Gi();
        int intFromAdObject = getIntFromAdObject("close_style", (Gi == null || Gi.size() <= 0) ? -1 : Gi.get(0).intValue());
        return intFromAdObject == -1 ? aO(hasVideoUrl()) : gC(intFromAdObject);
    }

    public List<j.a> Gh() {
        List<Integer> Gi = Gi();
        if (Gi == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Gi.size());
        for (Integer intValue : Gi) {
            arrayList.add(gC(intValue.intValue()));
        }
        return arrayList;
    }

    private List<Integer> Gi() {
        return getIntegerListFromAdObject("multi_close_style", (List<Integer>) null);
    }

    public j.a Gj() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? Gg() : gC(intFromAdObject);
    }

    public boolean Gk() {
        return getBooleanFromAdObject("dismiss_on_skip", false);
    }

    public boolean Gl() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", false);
    }

    public boolean Gm() {
        return getBooleanFromAdObject("html_resources_cached", false);
    }

    public void aN(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    public void k(Uri uri) {
        this.aGw.add(uri);
    }

    public String Go() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return JsonUtils.getString(jsonObjectFromAdObject, "video_button_html", "");
        }
        return "";
    }

    public u Gp() {
        return new u(getJsonObjectFromAdObject("video_button_properties", (JSONObject) null), this.sdk);
    }

    public boolean Gq() {
        return getBooleanFromAdObject("video_clickable", false);
    }

    public boolean Gr() {
        return getBooleanFromAdObject("lock_current_orientation", false);
    }

    public boolean Gs() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQA));
    }

    public int Gt() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public int Gu() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public a Gv() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return a.DO_NOT_DISMISS;
            }
        }
        return a.UNSPECIFIED;
    }

    public List<String> Gw() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", (String) null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public List<String> Gx() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", (String) null);
        if (stringFromAdObject != null) {
            return CollectionUtils.explode(stringFromAdObject);
        }
        return this.sdk.b(com.applovin.impl.sdk.c.b.aLN);
    }

    public boolean Gy() {
        return getBooleanFromAdObject("sruifwvc", false);
    }

    public boolean Gz() {
        return getBooleanFromAdObject("require_interaction_for_click", false);
    }

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    public boolean GA() {
        return getBooleanFromAdObject("sscomt", false);
    }

    public String GB() {
        return getStringFromFullResponse("event_id", (String) null);
    }

    public boolean GC() {
        return getBooleanFromAdObject("progress_bar_enabled", false);
    }

    public int GD() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public int GE() {
        int U;
        synchronized (this.adObjectLock) {
            U = com.applovin.impl.sdk.utils.u.U(this.adObject);
        }
        return U;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return 90;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int GF() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.adObjectLock
            monitor-enter(r0)
            org.json.JSONObject r1 = r4.adObject     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "graphic_completion_percent"
            r3 = -1
            int r1 = com.applovin.impl.sdk.utils.JsonUtils.getInt(r1, r2, r3)     // Catch:{ all -> 0x0018 }
            if (r1 < 0) goto L_0x0014
            r2 = 100
            if (r1 > r2) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            r0 = 90
            return r0
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.ad.e.GF():int");
    }

    public int GG() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public long GH() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1);
    }

    public int GI() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public int GJ() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public boolean GK() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", false);
    }

    public boolean GL() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", false);
    }

    public boolean GM() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", false);
    }

    public c GN() {
        if (this.aGE == null) {
            this.aGE = new c();
        }
        return this.aGE;
    }

    public int GO() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMS)).intValue());
    }

    public int GP() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMT)).intValue());
    }

    public int GQ() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMR)).intValue());
    }

    public boolean GR() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aMQ));
    }

    public boolean GS() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNd));
    }

    public long GT() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    public int GU() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean GV() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", true);
    }

    public boolean GX() {
        return getBooleanFromAdObject("show_nia", false);
    }

    public String GY() {
        return getStringFromAdObject("nia_title", "");
    }

    public String GZ() {
        return getStringFromAdObject("nia_message", "");
    }

    public String Ha() {
        return getStringFromAdObject("nia_button_title", "");
    }

    public boolean Hb() {
        return getBooleanFromAdObject("avoms", false);
    }

    public boolean Hc() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    public String Hd() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    public String He() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    public String Hf() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    public List<com.applovin.impl.sdk.d.a> Hg() {
        List<com.applovin.impl.sdk.d.a> a2;
        List<com.applovin.impl.sdk.d.a> list = this.aGA;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("video_end_urls", this.adObject, getClCode(), Hk(), this.sdk);
            this.aGA = a2;
        }
        return a2;
    }

    public List<com.applovin.impl.sdk.d.a> Hh() {
        List<com.applovin.impl.sdk.d.a> a2;
        List<com.applovin.impl.sdk.d.a> list = this.aGB;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.aGB = a2;
        }
        return a2;
    }

    public List<com.applovin.impl.sdk.d.a> Hi() {
        List<com.applovin.impl.sdk.d.a> a2;
        List<com.applovin.impl.sdk.d.a> list = this.aGC;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.aGC = a2;
        }
        return a2;
    }

    public List<com.applovin.impl.sdk.d.a> a(MotionEvent motionEvent, boolean z, boolean z2) {
        List<com.applovin.impl.sdk.d.a> a2;
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("click_tracking_urls", this.adObject, c(motionEvent, z, z2), b(motionEvent, z, z2), Hl(), Gl(), this.sdk);
        }
        return a2;
    }

    public List<com.applovin.impl.sdk.d.a> a(MotionEvent motionEvent, boolean z) {
        List<com.applovin.impl.sdk.d.a> a2;
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("video_click_tracking_urls", this.adObject, c(motionEvent, true, z), (String) null, Hl(), Gl(), this.sdk);
        }
        return a2.isEmpty() ? a(motionEvent, true, z) : a2;
    }

    public List<com.applovin.impl.sdk.d.a> Hj() {
        List<com.applovin.impl.sdk.d.a> a2;
        List<com.applovin.impl.sdk.d.a> list = this.aGD;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a2 = com.applovin.impl.sdk.utils.u.a("imp_urls", this.adObject, getClCode(), (Map<String, String>) null, (String) null, Hl(), Gl(), this.sdk);
            this.aGD = a2;
        }
        return a2;
    }

    public List<String> getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        for (String replace : stringListFromAdObject) {
            arrayList.add(replace.replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    private String Hk() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    private String b(MotionEvent motionEvent, boolean z, boolean z2) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", (String) null);
        Map<String, String> c2 = c(motionEvent, z, z2);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, c2);
        }
        return null;
    }

    private Map<String, String> c(MotionEvent motionEvent, boolean z, boolean z2) {
        Point Y = h.Y(n.getApplicationContext());
        HashMap hashMap = new HashMap(7);
        hashMap.put("{CLCODE}", getClCode());
        float f = -1.0f;
        hashMap.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        if (motionEvent != null) {
            f = motionEvent.getRawY();
        }
        hashMap.put("{CLICK_Y}", String.valueOf(f));
        hashMap.put("{SCREEN_WIDTH}", String.valueOf(Y.x));
        hashMap.put("{SCREEN_HEIGHT}", String.valueOf(Y.y));
        hashMap.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        hashMap.put("{IS_INSTALL}", String.valueOf(z2));
        return hashMap;
    }

    public List<String> d(MotionEvent motionEvent, boolean z, boolean z2) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map<String, String> c2 = c(motionEvent, z, z2);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        for (String replace : stringListFromAdObject) {
            arrayList.add(StringUtils.replace(replace, c2));
        }
        return arrayList;
    }

    public Map<String, String> Hl() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.putAll(JsonUtils.toStringMap(getJsonObjectFromAdObject("http_headers_for_postbacks", new JSONObject())));
        } catch (JSONException e) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("DirectAd", "Failed to retrieve http headers forx postbacks", e);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", false)) {
            hashMap.put("User-Agent", af.Fy());
        }
        return hashMap;
    }

    public boolean Hm() {
        return getBooleanFromAdObject("playback_requires_user_action", true);
    }

    public String Hn() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public boolean Ho() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf("com.applovin.apps.test.playables".equals(n.getApplicationContext().getPackageName())));
    }

    public y Hp() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return new y(jsonObjectFromAdObject);
        }
        return null;
    }

    public int Hq() {
        int i;
        if (com.applovin.impl.sdk.utils.u.c(getSize())) {
            i = 1;
        } else {
            i = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQu)).booleanValue() ? 0 : -1;
        }
        return getIntFromAdObject("whalt", i);
    }

    public List<String> Hr() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public List<String> Hs() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", (String) null));
    }

    public Uri Ht() {
        String stringFromAdObject = getStringFromAdObject("play_image", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public void l(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "play_image", uri.toString());
        }
    }

    public Uri Hu() {
        String stringFromAdObject = getStringFromAdObject("pause_image", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public void m(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "pause_image", uri.toString());
        }
    }

    public Uri Hv() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public void n(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }

    public Uri Hw() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public void o(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "unmute_image", uri);
        }
    }

    public boolean yf() {
        return this.aGy.get();
    }

    public void yg() {
        this.aGy.set(true);
    }

    public void a(com.applovin.impl.sdk.b.c cVar) {
        this.aGz.set(cVar);
    }

    public com.applovin.impl.sdk.b.c yh() {
        return this.aGz.getAndSet((Object) null);
    }

    public boolean Hx() {
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.SHOULD_USE_EXOPLAYER);
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return getBooleanFromAdObject("suep", false);
    }

    public boolean Hy() {
        return getBooleanFromAdObject("upiosp", false);
    }

    public boolean Hz() {
        return getBooleanFromAdObject("web_video", false);
    }

    public d HA() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", (String) null);
        if ("top".equals(stringFromAdObject)) {
            return d.TOP;
        }
        if ("bottom".equals(stringFromAdObject)) {
            return d.BOTTOM;
        }
        if ("left".equals(stringFromAdObject)) {
            return d.LEFT;
        }
        if ("right".equals(stringFromAdObject)) {
            return d.RIGHT;
        }
        return d.RESIZE_ASPECT;
    }

    public boolean FF() {
        this.sdk.BN();
        if (!x.Fn()) {
            return false;
        }
        this.sdk.BN().i("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    public Uri FI() {
        this.sdk.BN();
        if (!x.Fn()) {
            return null;
        }
        this.sdk.BN().i("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    public Uri FK() {
        this.sdk.BN();
        if (!x.Fn()) {
            return null;
        }
        this.sdk.BN().i("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    public Uri FL() {
        this.sdk.BN();
        if (!x.Fn()) {
            return null;
        }
        this.sdk.BN().i("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    private j.a aO(boolean z) {
        return z ? j.a.WHITE_ON_TRANSPARENT : j.a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public j.a gC(int i) {
        if (i == 1) {
            return j.a.WHITE_ON_TRANSPARENT;
        }
        if (i == 2) {
            return j.a.INVISIBLE;
        }
        if (i == 3) {
            return j.a.TRANSPARENT_SKIP;
        }
        return j.a.WHITE_ON_BLACK;
    }
}
