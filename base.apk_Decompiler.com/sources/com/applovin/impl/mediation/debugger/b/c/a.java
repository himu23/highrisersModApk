package com.applovin.impl.mediation.debugger.b.c;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import java.util.List;
import org.json.JSONObject;

public class a {
    private final String aoS;
    private final boolean aoT;
    private final String name;

    public String getName() {
        return this.name;
    }

    public String vj() {
        return this.aoS;
    }

    public boolean vk() {
        return this.aoT;
    }

    a(JSONObject jSONObject, n nVar) {
        this.name = JsonUtils.getString(jSONObject, "name", "");
        this.aoS = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", (List) null);
        if (list != null) {
            this.aoT = u.M(list);
        } else {
            this.aoT = u.dE(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
    }

    public static boolean a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || u.M(str2, str) != 1) {
            return str3 == null || u.M(str3, str) != -1;
        }
        return false;
    }
}
