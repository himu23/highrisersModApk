package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.vast.e;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.web.d;

public class b {
    public final com.fyber.inneractive.sdk.model.vast.b a;
    public String b;
    public e c;

    public static class a {
        public final String a;
        public final int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    public b(InneractiveAdRequest inneractiveAdRequest, g gVar, s sVar, com.fyber.inneractive.sdk.model.vast.b bVar) {
        this.a = bVar;
    }

    public void a(e eVar) {
        this.c = eVar;
    }

    public final void a(d.C0138d dVar, d dVar2, String str) {
        if (dVar != null) {
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
            if (!TextUtils.isEmpty(str)) {
                inneractiveInfrastructureError.setCause(new Exception(str));
            }
            dVar.a(dVar2, inneractiveInfrastructureError);
        }
    }
}
