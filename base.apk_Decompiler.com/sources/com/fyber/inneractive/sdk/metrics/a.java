package com.fyber.inneractive.sdk.metrics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class a {
    public final String a;

    public a(String str) {
        this.a = str;
    }

    public static boolean a(int i, int i2, JSONArray jSONArray, List<Long> list) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.HOURS.toMillis((long) i);
        int i3 = 0;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            long optLong = jSONArray.optLong(i4, 0);
            if (optLong > currentTimeMillis) {
                i3++;
                list.add(Long.valueOf(optLong));
            }
        }
        if (i3 >= i2) {
            return true;
        }
        return false;
    }
}
