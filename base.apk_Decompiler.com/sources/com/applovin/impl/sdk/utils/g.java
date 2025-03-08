package com.applovin.impl.sdk.utils;

import android.content.Context;

public class g {
    public static int a(int i, Context context) {
        if (h.KY()) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }
}
