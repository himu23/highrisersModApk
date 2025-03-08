package com.ironsource;

import android.content.Context;
import android.os.Build;
import com.ironsource.m2;
import com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public abstract class i2 implements b5 {
    private a5 a;

    protected i2(JSONObject jSONObject, Context context) {
        this.a = a(jSONObject, context);
        Logger.i("i2", "created ConnectivityAdapter with strategy " + this.a.getClass().getSimpleName());
    }

    private a5 a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(m2.i.f0) == 1) {
            return new BroadcastReceiverStrategy(this);
        }
        return (Build.VERSION.SDK_INT < 23 || !k0.c(context, "android.permission.ACCESS_NETWORK_STATE")) ? new BroadcastReceiverStrategy(this) : new j9(this);
    }

    public JSONObject a(Context context) {
        return this.a.c(context);
    }

    public void a() {
    }

    public void a(String str, JSONObject jSONObject) {
    }

    public void b() {
        this.a.a();
    }

    public void b(Context context) {
        this.a.b(context);
    }

    public void b(String str, JSONObject jSONObject) {
    }

    public void c(Context context) {
        this.a.a(context);
    }
}
