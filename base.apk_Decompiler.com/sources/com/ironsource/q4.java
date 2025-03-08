package com.ironsource;

import java.util.Map;
import org.json.JSONObject;

public class q4 {
    public static final String b = "userId";
    private static q4 c;
    private JSONObject a = new JSONObject();

    private q4() {
    }

    public static synchronized q4 a() {
        q4 q4Var;
        synchronized (q4.class) {
            if (c == null) {
                c = new q4();
            }
            q4Var = c;
        }
        return q4Var;
    }

    public synchronized String a(String str) {
        return this.a.optString(str);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            org.json.JSONObject r0 = r1.a     // Catch:{ Exception -> 0x000a, all -> 0x0007 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x000a, all -> 0x0007 }
            goto L_0x000a
        L_0x0007:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000a:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q4.a(java.lang.String, java.lang.Object):void");
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                a(next, map.get(next));
            }
        }
    }

    public synchronized JSONObject b() {
        return this.a;
    }
}
