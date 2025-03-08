package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.HashSet;
import java.util.Set;

public class f {
    private static final Set<String> aSP = new HashSet(32);
    private static final Set<f> aSR = new HashSet(16);
    public static final f aSS = m1876do(ServiceProvider.NAMED_AD_REQ);
    public static final f aST = m1876do("ad_imp");
    public static final f aSU = m1876do("max_ad_imp");
    public static final f aSV = m1876do("ad_session_start");
    public static final f aSW = m1876do("ad_imp_session");
    public static final f aSX = m1876do("max_ad_imp_session");
    public static final f aSY = m1876do("cached_files_expired");
    public static final f aSZ = m1876do("cache_drop_count");
    public static final f aTa = c("sdk_reset_state_count", true);
    public static final f aTb = c("ad_response_process_failures", true);
    public static final f aTc = c("response_process_failures", true);
    public static final f aTd = c("incent_failed_to_display_count", true);
    public static final f aTe = m1876do("app_paused_and_resumed");
    public static final f aTf = c("ad_rendered_with_mismatched_sdk_key", true);
    public static final f aTg = m1876do("ad_shown_outside_app_count");
    public static final f aTh = m1876do("med_ad_req");
    public static final f aTi = c("med_ad_response_process_failures", true);
    public static final f aTj = c("med_waterfall_ad_no_fill", true);
    public static final f aTk = c("med_waterfall_ad_adapter_load_failed", true);
    public static final f aTl = c("med_waterfall_ad_invalid_response", true);
    private final String aSQ;

    public static Set<f> JV() {
        return aSR;
    }

    public String getName() {
        return this.aSQ;
    }

    static {
        m1876do("fullscreen_ad_nil_vc_count");
        m1876do("applovin_bundle_missing");
    }

    private f(String str) {
        this.aSQ = str;
    }

    /* renamed from: do  reason: not valid java name */
    private static f m1876do(String str) {
        return c(str, false);
    }

    private static f c(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = aSP;
            if (!set.contains(str)) {
                set.add(str);
                f fVar = new f(str);
                if (z) {
                    aSR.add(fVar);
                }
                return fVar;
            }
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        throw new IllegalArgumentException("No key name specified");
    }
}
