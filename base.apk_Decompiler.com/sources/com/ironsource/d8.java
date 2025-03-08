package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.e6;
import com.ironsource.m2;
import com.ironsource.y2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d8 {
    private static final String b = "d8";
    private static final String c = "supersonic_shared_preferen";
    private static final String d = "version";
    private static final String e = "back_button_state";
    private static final String f = "search_keys";
    private static final String g = "^\\d+_\\d+$";
    private static d8 h;
    private SharedPreferences a;

    private d8(Context context) {
        this.a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized d8 a(Context context) {
        d8 d8Var;
        synchronized (d8.class) {
            if (h == null) {
                h = new d8(context);
            }
            d8Var = h;
        }
        return d8Var;
    }

    private boolean b(String str) {
        return str.matches(g);
    }

    public static synchronized d8 e() {
        d8 d8Var;
        synchronized (d8.class) {
            d8Var = h;
        }
        return d8Var;
    }

    public String a(String str) {
        String string = this.a.getString(str, (String) null);
        return string != null ? string : JsonUtils.EMPTY_JSON;
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor edit = this.a.edit();
        for (String str : strArr) {
            if (b(str)) {
                arrayList.add(str);
                edit.remove(str);
            }
        }
        edit.apply();
        return arrayList;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.a.getString("ssaUserData", (String) null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put(y2.a.d, str);
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("ssaUserData", jSONObject.toString());
            edit.apply();
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public e6.a b() {
        int parseInt = Integer.parseInt(this.a.getString(e, "2"));
        return parseInt == 0 ? e6.a.None : parseInt == 1 ? e6.a.Device : parseInt == 2 ? e6.a.Controller : e6.a.Controller;
    }

    public String c() {
        return this.a.getString("version", "-1");
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(e, str);
        edit.apply();
    }

    public List<String> d() {
        String string = this.a.getString(f, (String) null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            ab abVar = new ab(string);
            if (abVar.a(m2.h.R)) {
                try {
                    arrayList.addAll(abVar.a((JSONArray) abVar.b(m2.h.R)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public void d(String str) {
        if (!c().equalsIgnoreCase(str)) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("version", str);
            edit.apply();
        }
    }

    public void e(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(f, str);
        edit.apply();
    }
}
