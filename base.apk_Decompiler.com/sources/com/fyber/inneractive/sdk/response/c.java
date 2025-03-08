package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.util.g0;
import com.fyber.inneractive.sdk.util.p;
import java.io.IOException;

public class c extends b {
    public void a(String str, a0 a0Var) throws IOException {
        String str2;
        f fVar = (f) this.a;
        if (str == null) {
            str2 = null;
        } else {
            str2 = g0.g.a(str);
        }
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.assetResponse");
        if (!TextUtils.isEmpty(property)) {
            String c = p.c(property);
            if (!TextUtils.isEmpty(c)) {
                str2 = c;
            }
        }
        fVar.J = str2;
    }

    public boolean b() {
        return true;
    }

    public e a() {
        f fVar = new f();
        this.a = fVar;
        return fVar;
    }
}
