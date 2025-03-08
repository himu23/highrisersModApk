package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.a;

public class c extends g {
    public a e;

    public c() {
        super("cta_locale");
    }

    public g b() {
        c cVar = new c();
        a((g) cVar);
        return cVar;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.e == null) {
            String a = a("install_" + str, (String) null);
            String a2 = a("skip_ad_" + str, (String) null);
            this.e = new a(a, a2, a("skip_in_" + str, (String) null));
        }
    }
}
