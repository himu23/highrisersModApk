package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class b {
    public static final b aSA = J("wvem", "WEB_VIEW_ERROR_MESSAGES");
    public static final b aSB = J("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");
    public static final b aSC = J("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");
    public static final b aSD = J("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");
    public static final b aSE = J("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");
    private static final Set<String> aSb = new HashSet(32);
    public static final b aSc = J("sas", "AD_SOURCE");
    public static final b aSd = J("srt", "AD_RENDER_TIME");
    public static final b aSe = J("sft", "AD_FETCH_TIME");
    public static final b aSf = J("sfs", "AD_FETCH_SIZE");
    public static final b aSg = J("sadb", "AD_DOWNLOADED_BYTES");
    public static final b aSh = J("sacb", "AD_CACHED_BYTES");
    public static final b aSi = J("stdl", "TIME_TO_DISPLAY_FROM_LOAD");
    public static final b aSj = J("stdi", "TIME_TO_DISPLAY_FROM_INIT");
    public static final b aSk = J("snas", "AD_NUMBER_IN_SESSION");
    public static final b aSl = J("snat", "AD_NUMBER_TOTAL");
    public static final b aSm = J("stah", "TIME_AD_HIDDEN_FROM_SHOW");
    public static final b aSn = J("stas", "TIME_TO_SKIP_FROM_SHOW");
    public static final b aSo = J("stac", "TIME_TO_CLICK_FROM_SHOW");
    public static final b aSp = J("stbe", "TIME_TO_EXPAND_FROM_SHOW");
    public static final b aSq = J("stbc", "TIME_TO_CONTRACT_FROM_SHOW");
    public static final b aSr = J("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");
    public static final b aSs = J("sugs", "AD_USED_GRAPHIC_STREAM");
    public static final b aSt = J("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");
    public static final b aSu = J("stpd", "INTERSTITIAL_PAUSED_DURATION");
    public static final b aSv = J("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");
    public static final b aSw = J("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");
    public static final b aSx = J("schc", "AD_CANCELLED_HTML_CACHING");
    public static final b aSy = J("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");
    public static final b aSz = J("vssc", "VIDEO_STREAM_STALLED_COUNT");
    private final String aSa;
    private final String name;

    static {
        J("sisw", "IS_STREAMING_WEBKIT");
        J("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        J("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        J("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        J("skr", "STOREKIT_REDIRECTED");
        J("sklf", "STOREKIT_LOAD_FAILURE");
        J("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private static b J(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = aSb;
            if (set.contains(str)) {
                throw new IllegalArgumentException("Key has already been used: " + str);
            } else if (!TextUtils.isEmpty(str2)) {
                set.add(str);
                return new b(str, str2);
            } else {
                throw new IllegalArgumentException("No debug name specified");
            }
        } else {
            throw new IllegalArgumentException("No key name specified");
        }
    }

    private b(String str, String str2) {
        this.name = str;
        this.aSa = str2;
    }
}
