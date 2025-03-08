package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.a;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.dv.e;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.util.IAlog;

public abstract class b {
    public e a;
    public String b;
    public j c;
    public boolean d = true;

    public abstract e a();

    public void a(n nVar) {
        this.a = a();
    }

    public abstract void a(String str, a0 a0Var) throws Exception;

    public abstract boolean b();

    public e a(String str) throws Exception {
        this.d = str != null;
        e eVar = this.a;
        eVar.getClass();
        eVar.c = System.currentTimeMillis();
        this.c.a(this);
        String a2 = this.c.a();
        this.a.h = a2;
        a0 b2 = a.b(this.b);
        IAlog.a("%sGot unit config for unitId: %s from config manager", IAlog.a((Object) this), this.b);
        IAlog.a("%s%s", IAlog.a((Object) this), b2);
        if (this.d) {
            a(str, b2);
        } else if (!(this instanceof e)) {
            h hVar = new h(a2);
            if (hVar.a) {
                String str2 = hVar.b;
                if (str2 == null || TextUtils.isEmpty(str2.trim())) {
                    throw new Exception("empty ad content detected. failing fast.");
                }
                a(str2, b2);
            }
        } else {
            a(a2, b2);
        }
        return this.a;
    }
}
