package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.f;

public class u0 {
    public static boolean a(String str) {
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        return property != null && property.trim().length() > 0 && str != null && str.toLowerCase().startsWith("fyberInternalTesting".toLowerCase()) && str.contains("crash");
    }
}
