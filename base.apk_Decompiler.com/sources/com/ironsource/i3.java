package com.ironsource;

import android.text.TextUtils;
import com.ironsource.e6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class i3 {
    private final Map<String, h3> a = new LinkedHashMap();
    private final Map<String, h3> b = new LinkedHashMap();
    private final Map<String, h3> c = new LinkedHashMap();

    private void a(e6.e eVar, String str, h3 h3Var) {
        Map<String, h3> b2;
        if (!TextUtils.isEmpty(str) && h3Var != null && (b2 = b(eVar)) != null) {
            b2.put(str, h3Var);
        }
    }

    private Map<String, h3> b(e6.e eVar) {
        if (eVar.name().equalsIgnoreCase(e6.e.RewardedVideo.name())) {
            return this.a;
        }
        if (eVar.name().equalsIgnoreCase(e6.e.Interstitial.name())) {
            return this.b;
        }
        if (eVar.name().equalsIgnoreCase(e6.e.Banner.name())) {
            return this.c;
        }
        return null;
    }

    public h3 a(e6.e eVar, p7 p7Var) {
        h3 h3Var = new h3(p7Var);
        a(eVar, p7Var.d(), h3Var);
        return h3Var;
    }

    public h3 a(e6.e eVar, String str) {
        Map<String, h3> b2;
        if (TextUtils.isEmpty(str) || (b2 = b(eVar)) == null) {
            return null;
        }
        return b2.get(str);
    }

    public h3 a(e6.e eVar, String str, Map<String, String> map, r9 r9Var) {
        h3 h3Var = new h3(str, str, map, r9Var);
        a(eVar, str, h3Var);
        return h3Var;
    }

    public Collection<h3> a(e6.e eVar) {
        Map<String, h3> b2 = b(eVar);
        return b2 != null ? b2.values() : new ArrayList();
    }

    public void b(e6.e eVar, String str) {
        Map<String, h3> b2;
        h3 remove;
        if (!TextUtils.isEmpty(str) && (b2 = b(eVar)) != null && (remove = b2.remove(str)) != null) {
            remove.a();
        }
    }
}
