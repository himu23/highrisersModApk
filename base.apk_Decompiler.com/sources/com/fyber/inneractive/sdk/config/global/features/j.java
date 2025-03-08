package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class j extends g {
    public j() {
        super("load_timeouts");
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    public static String i(String str) {
        return TextUtils.isEmpty(str) ? "all_mediators" : str.toLowerCase(Locale.US);
    }

    public int b(String str, String str2) {
        return a(a(str, "bidding", "global_timeout", i(str2)), a(a(str, "bidding", "global_timeout", "all_mediators"), a(a(str, "global_timeout", "all_mediators"), g(str) ? 30000 : 10000)));
    }

    public int c(String str, String str2) {
        return a(a(str, "global_timeout", i(str2)), a(a(str, "global_timeout", "all_mediators"), a(a(str, "global_timeout", "all_mediators"), g(str) ? 30000 : 10000)));
    }

    public int d() {
        return a(a("timeout", "threshold"), 300);
    }

    public int e(String str) {
        return a(str + "_global_timeout", g(str) ? 30000 : 10000);
    }

    public int f(String str) {
        return a(a("timeout", "threshold", i(str)), a(a("timeout", "threshold", "all_mediators"), 300));
    }

    public boolean g(String str) {
        return UnitDisplayType.INTERSTITIAL.name().equalsIgnoreCase(str) || UnitDisplayType.REWARDED.name().equalsIgnoreCase(str);
    }

    public final int h(String str) {
        "read".equalsIgnoreCase(str);
        return 5000;
    }

    public boolean e() {
        return a("reverse_retries", true);
    }

    public g b() {
        j jVar = new j();
        a((g) jVar);
        return jVar;
    }
}
