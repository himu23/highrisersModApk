package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.y2;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class c {
    private final String a = "eventId";
    private final String b = y2.a.d;
    private final String c = "InterstitialEvents";
    private final String d = "events";
    private final String e = "events";
    JSONObject f;
    int g;
    private String h;

    c() {
    }

    private String a(int i) {
        return i != 2 ? "events" : "InterstitialEvents";
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    public abstract String a(ArrayList<y3> arrayList, JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public String a(JSONArray jSONArray) {
        try {
            if (this.f != null) {
                JSONObject jSONObject = new JSONObject(this.f.toString());
                jSONObject.put(y2.a.d, IronSourceUtils.getTimestamp());
                jSONObject.put(a(this.g), jSONArray);
                return jSONObject.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public JSONObject a(y3 y3Var) {
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(y3Var.a()) ? new JSONObject(y3Var.a()) : new JSONObject();
            jSONObject.put("eventId", y3Var.c());
            jSONObject.put(y2.a.d, y3Var.d());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.h = str;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return TextUtils.isEmpty(this.h) ? a() : this.h;
    }

    public abstract String c();
}
