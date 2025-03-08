package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import org.json.JSONObject;

public class a {
    public InneractiveAdSpot a;
    public boolean b = false;
    public boolean c;
    public long d = 0;
    public long e = 0;
    public long f = 0;

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.b = false;
    }

    public void a(boolean z) {
        this.c = z;
        String str = "skip";
        if (!this.b) {
            Object[] objArr = new Object[2];
            objArr[0] = "AdExperienceLatency: ";
            if (!z) {
                str = "close";
            }
            objArr[1] = str;
            IAlog.a("%s%s timer started", objArr);
            this.d = System.currentTimeMillis();
            this.b = true;
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "AdExperienceLatency: ";
        if (!z) {
            str = "close";
        }
        objArr2[1] = str;
        IAlog.a("%s%s timer could not start. Timer is in action!", objArr2);
    }

    public void b() {
        if (this.b && this.e > 0) {
            this.f += System.currentTimeMillis() - this.e;
            this.e = 0;
        }
    }

    public void a(String str) {
        s sVar;
        if (this.b) {
            String a2 = a0.a(this.d, this.f);
            InneractiveAdSpot inneractiveAdSpot = this.a;
            q adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            s.a aVar = new s.a(this.c ? r.USER_SKIP_ACTION_LATENCY : r.USER_CLOSE_ACTION_LATENCY, adContent != null ? adContent.a : null, adContent != null ? adContent.d() : null, (adContent == null || (sVar = adContent.c) == null) ? null : sVar.c());
            JSONObject jSONObject = new JSONObject();
            String str2 = this.c ? "skip_action_latency" : "close_action_latency";
            try {
                jSONObject.put(str2, a2);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", str2, a2);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("origin", str);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "origin", str);
                }
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
            a();
        }
    }
}
