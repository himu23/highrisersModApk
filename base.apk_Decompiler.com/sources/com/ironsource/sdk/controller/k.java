package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.e6;
import com.ironsource.h3;
import com.ironsource.sdk.controller.f;
import com.ironsource.v2;
import com.ironsource.w2;
import com.ironsource.w9;
import com.ironsource.x2;
import com.ironsource.x8;
import java.util.Map;
import org.json.JSONObject;

public interface k {

    public interface a {
        void a(f.a aVar);
    }

    public interface b {
        void a(x8 x8Var);
    }

    void a(Activity activity);

    void a(Context context);

    void a(h3 h3Var);

    void a(h3 h3Var, Map<String, String> map, v2 v2Var);

    void a(h3 h3Var, Map<String, String> map, w2 w2Var);

    void a(f.c cVar, a aVar);

    void a(String str, w2 w2Var);

    void a(String str, String str2, h3 h3Var, v2 v2Var);

    void a(String str, String str2, h3 h3Var, w2 w2Var);

    void a(String str, String str2, h3 h3Var, x2 x2Var);

    void a(String str, String str2, w9 w9Var);

    void a(String str, String str2, Map<String, String> map, w9 w9Var);

    void a(Map<String, String> map, w9 w9Var);

    void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, v2 v2Var);

    void a(JSONObject jSONObject, w2 w2Var);

    void a(JSONObject jSONObject, x2 x2Var);

    boolean a(String str);

    void b();

    void b(Context context);

    void b(h3 h3Var, Map<String, String> map, w2 w2Var);

    void b(JSONObject jSONObject);

    @Deprecated
    void c();

    void d();

    void destroy();

    void e();

    e6.c getType();
}
