package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class v0 {
    public final WeakReference<Thread> a;
    public final WeakReference<c0> b;
    public final int c;
    public final Runnable d = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            String str;
            v0 v0Var = v0.this;
            c0 c0Var = (c0) u.a(v0Var.b);
            Thread thread = (Thread) u.a(v0.this.a);
            v0Var.getClass();
            if (c0Var != null && c0Var.p() != r0.DONE && c0Var.p() != r0.RESOLVED) {
                if (v0.a(c0Var)) {
                    String str2 = "";
                    if (thread != null) {
                        StackTraceElement[] stackTrace = thread.getStackTrace();
                        Exception exc = new Exception();
                        exc.setStackTrace(stackTrace);
                        str = u.a((Throwable) exc);
                    } else {
                        str = str2;
                    }
                    if (c0Var != null) {
                        str2 = c0Var.a();
                    }
                    s.a aVar = new s.a(r.NETWORK_REQUEST_PASSED_ALLOWED_TIME, c0Var instanceof d0 ? ((d0) c0Var).r : null, c0Var instanceof o0 ? ((o0) c0Var).u : null, (c0Var == null || c0Var.m() == null) ? null : c0Var.m().c());
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", str2);
                    } catch (Exception unused) {
                        IAlog.e("Got exception adding param to json object: %s, %s", "url", str2);
                    }
                    try {
                        jSONObject.put("stack_trace", str);
                    } catch (Exception unused2) {
                        IAlog.e("Got exception adding param to json object: %s, %s", "stack_trace", str);
                    }
                    Integer valueOf = Integer.valueOf(v0Var.c);
                    try {
                        jSONObject.put("total_time", valueOf);
                    } catch (Exception unused3) {
                        IAlog.e("Got exception adding param to json object: %s, %s", "total_time", valueOf);
                    }
                    aVar.f.put(jSONObject);
                    aVar.a((String) null);
                }
                IAlog.a("%s : NetworkWatchdogHolder should cancel by timeout: %d", IAlog.a((Object) v0Var), Integer.valueOf(v0Var.c));
                c0Var.d();
            }
        }
    }

    public v0(c0 c0Var, Thread thread, int i) {
        this.b = new WeakReference<>(c0Var);
        this.a = new WeakReference<>(thread);
        this.c = i;
    }

    public static boolean a(c0<?> c0Var) {
        boolean z = c0Var != null && c0Var.j();
        IAlog.a("%s : NetworkWatchdogHolder : should report: %s", IAlog.a((Class<?>) v0.class), Boolean.valueOf(z));
        return z;
    }
}
