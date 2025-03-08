package com.ironsource;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class g4 {
    private static final String e = "EventsTracker";
    private z4 a;
    /* access modifiers changed from: private */
    public b4 b;
    private g5 c;
    private ExecutorService d;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            try {
                pa paVar = new pa();
                ArrayList<Pair<String, String>> d = g4.this.b.d();
                if (i9.b.equals(g4.this.b.e())) {
                    paVar = t5.b(g4.this.b.b(), this.a, d);
                } else if (i9.a.equals(g4.this.b.e())) {
                    paVar = t5.a(g4.this.b.b(), this.a, d);
                }
                g4 g4Var = g4.this;
                g4Var.a("response status code: " + paVar.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public g4(b4 b4Var, z4 z4Var) {
        if (b4Var == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        } else if (b4Var.c() != null) {
            this.b = b4Var;
            this.a = z4Var;
            this.c = b4Var.c();
            this.d = Executors.newSingleThreadExecutor();
        } else {
            throw new InvalidParameterException("Null formatter not supported ");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (this.b.f()) {
            Log.d(e, str);
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception unused) {
        }
    }

    private void b(String str) {
        this.d.submit(new a(str));
    }

    public void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", new Object[]{str, map.toString()}));
        if (this.b.a() && !str.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventname", str);
            a((Map<String, Object>) hashMap, this.a.a());
            a((Map<String, Object>) hashMap, map);
            b(this.c.a(hashMap));
        }
    }
}
