package com.ironsource;

import org.json.JSONObject;

public class p2 {
    public static final String a = "SSA_CORE.SDKController.runFunction";

    public static String a(q2 q2Var) {
        return String.format("%1$s('%2$s%3$s'%4$s)", new Object[]{a, q2Var.b(), a(q2Var.c()), b(q2Var)});
    }

    private static String a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? "" : jSONObject.toString();
    }

    private static String b(q2 q2Var) {
        if (q2Var.d() == null || q2Var.a() == null) {
            return "";
        }
        return String.format(", '%1$s', '%2$s'", new Object[]{q2Var.d(), q2Var.a()});
    }
}
