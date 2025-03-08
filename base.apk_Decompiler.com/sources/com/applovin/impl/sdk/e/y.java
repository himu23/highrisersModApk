package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import java.util.Map;
import org.json.JSONObject;

public abstract class y extends aa {
    /* access modifiers changed from: protected */
    public abstract void y(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract c yh();

    /* access modifiers changed from: protected */
    public abstract void zM();

    protected y(String str, n nVar) {
        super(str, nVar);
    }

    public void run() {
        c yh = yh();
        if (yh != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Reporting pending reward: " + yh + "...");
            }
            a(c(yh), new b.d<JSONObject>() {
                /* renamed from: a */
                public void d(JSONObject jSONObject, int i) {
                    y.this.y(jSONObject);
                }

                public void a(int i, String str, JSONObject jSONObject) {
                    y.this.gu(i);
                }
            });
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            this.logger.i(this.tag, "Pending reward not found");
        }
        zM();
    }

    /* access modifiers changed from: protected */
    public int KN() {
        return ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMg)).intValue();
    }

    private JSONObject c(c cVar) {
        JSONObject KO = KO();
        JsonUtils.putString(KO, "result", cVar.JC());
        Map<String, String> JB = cVar.JB();
        if (JB != null) {
            JsonUtils.putJSONObject(KO, "params", new JSONObject(JB));
        }
        return KO;
    }
}
