package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class z8 {
    private String a;

    public z8(String str) {
        this.a = str;
    }

    private n6 a() throws Exception {
        n6 n6Var = new n6(this.a, "metadata.json");
        if (!n6Var.exists()) {
            a(n6Var);
        }
        return n6Var;
    }

    private void a(n6 n6Var) throws Exception {
        IronSourceStorageUtils.saveFile(new JSONObject().toString().getBytes(), n6Var.getPath());
    }

    private boolean a(JSONObject jSONObject) throws Exception {
        return IronSourceStorageUtils.saveFile(jSONObject.toString().getBytes(), a().getPath()) != 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(String str) throws Exception {
        JSONObject b = b();
        if (!b.has(str)) {
            return true;
        }
        b.remove(str);
        return a(b);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(String str, JSONObject jSONObject) throws Exception {
        JSONObject b;
        b = b();
        b.put(str, jSONObject);
        return a(b);
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<n6> arrayList) throws Exception {
        Iterator<n6> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!a(it.next().getName())) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public synchronized JSONObject b() throws Exception {
        return new JSONObject(IronSourceStorageUtils.readFile(a()));
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b(String str, JSONObject jSONObject) throws Exception {
        JSONObject b;
        b = b();
        JSONObject optJSONObject = b.optJSONObject(str);
        if (optJSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                optJSONObject.putOpt(next, jSONObject.opt(next));
            }
        } else {
            b.putOpt(str, jSONObject);
        }
        return a(b);
    }
}
