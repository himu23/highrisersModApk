package com.fyber.inneractive.sdk.network.timeouts.request;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.config.global.s;

public class c {
    public a a(String str, String str2, s sVar, boolean z) {
        j jVar = (j) sVar.a(j.class);
        if (TextUtils.isEmpty(str2)) {
            return new b(str, jVar);
        }
        if (z) {
            return new d(str, jVar, str2);
        }
        return new e(str, jVar, str2);
    }
}
