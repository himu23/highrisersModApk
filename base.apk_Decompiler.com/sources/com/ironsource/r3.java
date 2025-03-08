package com.ironsource;

import java.util.Date;

public class r3 {
    private long a = new Date().getTime();

    public static long a(r3 r3Var) {
        if (r3Var == null) {
            return 0;
        }
        return new Date().getTime() - r3Var.a;
    }
}
