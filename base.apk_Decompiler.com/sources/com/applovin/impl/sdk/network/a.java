package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import org.json.JSONObject;

public class a extends d {
    /* access modifiers changed from: private */
    public final c<JSONObject> aHl;
    /* access modifiers changed from: private */
    public final String aoM;

    public a(String str, c<JSONObject> cVar, n nVar) {
        super("CommunicatorRequestTask", nVar, str);
        this.aoM = str;
        this.aHl = cVar;
    }

    public void run() {
        this.sdk.BO().b((d) new w<JSONObject>(this.aHl, this.sdk, Kh()) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                this.sdk.Ch().a(a.this.aoM, a.this.aHl.zL(), i, jSONObject, (String) null, true);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                this.sdk.Ch().a(a.this.aoM, a.this.aHl.zL(), i, jSONObject, str, false);
            }
        });
    }
}
