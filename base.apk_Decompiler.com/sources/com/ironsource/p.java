package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.json.JSONObject;

public class p {
    private IronSource.AD_UNIT a;
    private String b;
    private NetworkSettings c;
    private int d;
    private int e;
    private JSONObject f;
    private String g;
    private int h;
    private String i;

    public p(IronSource.AD_UNIT ad_unit, String str, int i2, JSONObject jSONObject, String str2, int i3, String str3, NetworkSettings networkSettings, int i4) {
        this.a = ad_unit;
        this.b = str;
        this.e = i2;
        this.f = jSONObject;
        this.g = str2;
        this.h = i3;
        this.i = str3;
        this.c = networkSettings;
        this.d = i4;
    }

    public IronSource.AD_UNIT a() {
        return this.a;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public JSONObject e() {
        return this.f;
    }

    public int f() {
        return this.d;
    }

    public NetworkSettings g() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public String i() {
        return this.b;
    }
}
