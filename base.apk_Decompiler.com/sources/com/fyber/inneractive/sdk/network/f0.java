package com.fyber.inneractive.sdk.network;

import android.util.Log;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.k;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.network.c0;
import com.fyber.inneractive.sdk.response.b;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.u;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class f0<T> implements c0<T> {
    public volatile boolean a;
    public final w<T> b;
    public g c;
    public c0.a d;
    public j e;
    public volatile r0 f;
    public final String g;
    public final s h;
    public long i;
    public long j;
    public long k;
    public long l;
    public int m;
    public boolean n;
    public boolean o;
    public final Object p;
    public boolean q;

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ Exception b;
        public final /* synthetic */ boolean c;

        public a(Object obj, Exception exc, boolean z) {
            this.a = obj;
            this.b = exc;
            this.c = z;
        }

        public void run() {
            f0.this.b.a(this.a, this.b, this.c);
        }
    }

    public f0(w<T> wVar, g gVar) {
        this(wVar, gVar, (s) null);
    }

    public void a(b0 b0Var, String str, String str2) {
    }

    public String c() {
        return null;
    }

    public void c(long j2) {
        synchronized (this.p) {
            if (this.o) {
                this.k = j2;
                this.m = (int) (((long) this.m) + (j2 - this.i));
                this.o = false;
            }
        }
    }

    public void d() {
        boolean z;
        boolean z2;
        synchronized (this.p) {
            z = this.n;
        }
        if (z) {
            a(System.currentTimeMillis());
            return;
        }
        synchronized (this.p) {
            z2 = this.o;
        }
        if (z2) {
            c(System.currentTimeMillis());
        }
    }

    public String f() {
        return this.g;
    }

    public boolean g() {
        return this.a;
    }

    public a<T> k() {
        return null;
    }

    public boolean l() {
        return !(this instanceof q0);
    }

    public s m() {
        return this.h;
    }

    public u0 n() {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        return new u0(iAConfigManager.u.b.a("connect_timeout", 5000, 1), iAConfigManager.u.b.a("read_timeout", 5000, 1));
    }

    public r0 p() {
        return this.f;
    }

    public String q() {
        return "application/json; charset=utf-8";
    }

    public byte[] u() {
        return null;
    }

    public Map<String, String> w() {
        return null;
    }

    public int x() {
        return this.m;
    }

    public int y() {
        int i2;
        synchronized (this.p) {
            i2 = this.m;
        }
        return i2;
    }

    public f0(w<T> wVar, g gVar, s sVar) {
        this.a = false;
        this.f = r0.INITIAL;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.b = wVar;
        this.c = gVar;
        this.g = UUID.randomUUID().toString();
        this.h = sVar;
    }

    public void b() {
        try {
            j jVar = this.e;
            if (jVar != null) {
                jVar.a();
            }
            this.c.b();
        } catch (Exception unused) {
        }
    }

    public int h() {
        Integer b2;
        s sVar = this.h;
        if (sVar == null || (b2 = ((k) sVar.a(k.class)).b("watchdog_buffer_time_ms")) == null) {
            return 500;
        }
        return b2.intValue();
    }

    public boolean j() {
        if (!this.q) {
            return false;
        }
        k kVar = (k) IAConfigManager.M.L.a(k.class);
        if (kVar.a("should_add_request_watchdog", false) || kVar.a("should_report_request_watchdog", false)) {
            return true;
        }
        return false;
    }

    public boolean s() {
        if (!this.q || !((k) IAConfigManager.M.L.a(k.class)).a("should_manage_request_watchdog", true)) {
            return false;
        }
        return true;
    }

    public j a(String str) throws Exception {
        try {
            c0.a aVar = this.d;
            if (aVar != null) {
                aVar.a("sdkInitNetworkRequest");
            }
            this.e = this.c.a(this, p.g(), str);
            c0.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a("sdkGotServerResponse");
            }
            return this.e;
        } catch (b e2) {
            IAlog.a("failed start network request", e2, new Object[0]);
            throw e2;
        } catch (x0 e3) {
            IAlog.a("failed read network response", e3, new Object[0]);
            throw e3;
        } catch (Exception e4) {
            IAlog.a("failed start network request", e4, new Object[0]);
            throw e4;
        }
    }

    public void b(long j2) {
        synchronized (this.p) {
            if (!this.n) {
                this.n = true;
                this.j = j2;
            }
        }
    }

    public void d(long j2) {
        synchronized (this.p) {
            if (!this.o) {
                this.o = true;
                this.i = j2;
            }
        }
    }

    public void a(T t, Exception exc, boolean z) {
        if (!z) {
            a(r0.RESOLVED);
        }
        q.b.post(new a(t, exc, z));
    }

    public void a(r0 r0Var) {
        c0.a aVar;
        this.f = r0Var;
        if (r0Var == r0.QUEUED_FOR_RETRY && (aVar = this.d) != null) {
            aVar.a("sdkRequestEndedButWillBeRetried");
        }
    }

    public e a(int i2, n nVar, j jVar, g gVar) throws Exception {
        try {
            com.fyber.inneractive.sdk.response.a a2 = com.fyber.inneractive.sdk.response.a.a(i2);
            if (a2 == null) {
                a2 = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            b a3 = b.a.a.a(a2);
            if (a3 == null) {
                IAlog.e("Received ad type %s does not have an appropriate parser!", Integer.valueOf(i2));
                if (b.a.a.a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while fetching an ad - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                throw new a0("Could not find parser for ad type " + i2);
            }
            IAlog.a("Received ad type %s - Got parser! %s", Integer.valueOf(i2), a3);
            if (jVar != null) {
                a3.c = jVar;
            }
            a3.a = a3.a();
            if (nVar != null) {
                a3.c = new com.fyber.inneractive.sdk.response.k(nVar);
            }
            e a4 = a3.a((String) null);
            a4.I = (long) x();
            if (gVar != null) {
                a4.s = gVar;
            }
            c0.a aVar = this.d;
            if (aVar != null) {
                aVar.a("sdkParsedResponse");
            }
            return a4;
        } catch (Exception e2) {
            IAlog.a("failed parse ad network request", e2, new Object[0]);
            throw new a0(e2);
        }
    }

    public f0(f0<T> f0Var) {
        this.a = false;
        this.f = r0.INITIAL;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.b = f0Var.b;
        this.c = f0Var.c;
        this.g = UUID.randomUUID().toString();
        this.h = f0Var.h;
        this.m = f0Var.m;
        this.i = f0Var.i;
        this.k = f0Var.k;
        this.j = f0Var.j;
        this.l = f0Var.l;
    }

    public int a(Map<String, List<String>> map) {
        List list = map != null ? map.get("Content-Length") : null;
        if (list != null) {
            return u.a((String) list.get(0), -1);
        }
        return -1;
    }

    public void a(long j2) {
        synchronized (this.p) {
            if (this.n) {
                this.l = j2;
                this.m = (int) (((long) this.m) + (j2 - this.j));
                this.n = false;
            }
        }
    }
}
