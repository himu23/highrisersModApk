package com.ironsource;

import java.util.HashMap;
import org.json.JSONObject;

public class vc {
    private HashMap<String, Boolean> a = new a();
    /* access modifiers changed from: private */
    public int b = 4;
    /* access modifiers changed from: private */
    public int c = 4;

    class a extends HashMap<String, Boolean> {
        a() {
            boolean z = true;
            put(w5.k, Boolean.valueOf(vc.this.b == 0));
            put(w5.l, Boolean.valueOf(vc.this.c != 0 ? false : z));
            Boolean bool = Boolean.FALSE;
            put(w5.m, bool);
            put(w5.n, bool);
        }
    }

    vc() {
    }

    public JSONObject a() {
        return new JSONObject(this.a);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i, boolean z) {
        boolean z2 = true;
        if (this.a.containsKey(str)) {
            this.a.put(str, Boolean.valueOf(i == 0));
        }
        this.a.put(w5.m, Boolean.valueOf(z));
        if ((!this.a.get(w5.l).booleanValue() && !this.a.get(w5.k).booleanValue()) || !this.a.get(w5.m).booleanValue()) {
            z2 = false;
        }
        this.a.put(w5.n, Boolean.valueOf(z2));
    }
}
