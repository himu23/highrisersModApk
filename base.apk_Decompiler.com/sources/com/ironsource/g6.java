package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

public class g6 {
    private HashMap<String, Object> a = new HashMap<>();

    public g6 a(String str, Object obj) {
        if (obj != null) {
            this.a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }

    public HashMap<String, Object> a() {
        return this.a;
    }
}
