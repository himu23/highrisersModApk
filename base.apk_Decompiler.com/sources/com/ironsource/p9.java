package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class p9 {
    private static final int e = 0;
    private static final String f = "adapterName";
    private ArrayList<q9> a = new ArrayList<>();
    private q9 b;
    private m0 c;
    private JSONObject d;

    public p9(m0 m0Var) {
        this.c = m0Var;
    }

    public q9 a() {
        Iterator<q9> it = this.a.iterator();
        while (it.hasNext()) {
            q9 next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.b;
    }

    public q9 a(String str) {
        Iterator<q9> it = this.a.iterator();
        while (it.hasNext()) {
            q9 next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a(q9 q9Var) {
        if (q9Var != null) {
            this.a.add(q9Var);
            if (this.b == null || q9Var.isPlacementId(0)) {
                this.b = q9Var;
            }
        }
    }

    public void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public String b() {
        JSONObject jSONObject = this.d;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString(f))) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : this.d.optString(f);
    }

    public m0 c() {
        return this.c;
    }
}
