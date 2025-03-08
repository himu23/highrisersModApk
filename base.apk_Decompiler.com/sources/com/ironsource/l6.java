package com.ironsource;

import android.util.Log;
import com.ironsource.za;
import java.util.HashMap;
import java.util.Map;

public class l6 {
    private static l6 b;
    private g4 a;

    private l6() {
    }

    private static l6 a() {
        if (b == null) {
            b = new l6();
        }
        return b;
    }

    public static void a(b4 b4Var, j6 j6Var) {
        if (b4Var != null) {
            try {
                a().a = new g4(b4Var, j6Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(za.a aVar) {
        a(aVar, (Map<String, Object>) new HashMap());
    }

    public static void a(za.a aVar, Map<String, Object> map) {
        g4 g4Var = a().a;
        if (g4Var == null) {
            Log.d(z3.a, z3.S);
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.b));
        }
        g4Var.a(aVar.a, map);
    }
}
