package com.fyber.inneractive.sdk.ignite;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.i;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.ignite.g;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.ironsource.y8;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class c implements ServiceConnection {
    public Context a;
    public IIgniteServiceAPI b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final Bundle g = new Bundle();
    public g h;
    public final List<n> i = new CopyOnWriteArrayList();
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public long m = 0;
    public final Object n = new Object();
    public boolean o = false;
    public long p;
    public Runnable q;
    public boolean r = false;
    public h s;
    public s t;

    public class a implements Runnable {
        public final /* synthetic */ ServiceConnection a;

        public a(ServiceConnection serviceConnection) {
            this.a = serviceConnection;
        }

        public void run() {
            synchronized (c.this.n) {
                Intent intent = new Intent();
                intent.setClassName(c.this.c, "com.digitalturbine.ignite.cl.IgniteRemoteService");
                Context context = c.this.a;
                if (context != null) {
                    context.bindService(intent, this.a, 1);
                }
            }
        }
    }

    public class b implements g.a {
        public final /* synthetic */ d a;

        public b(d dVar) {
            this.a = dVar;
        }
    }

    public static class d {
        public final String a;
        public final p<?> b;
        public final k c;

        public d(String str, k kVar, p<?> pVar) {
            this.a = str;
            this.c = kVar;
            this.b = pVar;
        }
    }

    public c() {
        h();
    }

    public void c() {
        h hVar;
        if (g() == null && (hVar = this.s) != null) {
            hVar.a();
            this.s = null;
        } else if (!TextUtils.isEmpty(this.c) && !e()) {
            q.a(new a(this));
        }
    }

    public boolean d() {
        return e() && this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r1 = this;
            boolean r0 = r1.k
            if (r0 == 0) goto L_0x0014
            com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI r0 = r1.b
            if (r0 == 0) goto L_0x0014
            android.os.IBinder r0 = r0.asBinder()
            boolean r0 = r0.isBinderAlive()
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.ignite.c.e():boolean");
    }

    public final boolean f() {
        return this.m > 0 && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > this.m;
    }

    public final String g() {
        List<ResolveInfo> queryIntentServices;
        Intent intent = new Intent("com.digitalturbine.ignite.cl.IgniteRemoteService");
        Context context = this.a;
        if (context == null || (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) == null || queryIntentServices.size() <= 0) {
            return null;
        }
        return queryIntentServices.get(0).serviceInfo.packageName;
    }

    public final void h() {
        this.h = new g(new C0099c());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009a */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
            r4 = this;
            r5 = 0
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "onServiceConnected"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI r6 = com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI.Stub.asInterface(r6)
            r4.b = r6
            r6 = 1
            r4.k = r6
            boolean r0 = r4.e()
            java.lang.String r1 = "Failed to resolve ignite version"
            r2 = 0
            if (r0 == 0) goto L_0x0037
            com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI r0 = r4.b     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = r0.version()     // Catch:{ Exception -> 0x0032 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r3 = "igniteVersion"
            java.lang.String r0 = r0.getString(r3)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0038
        L_0x0032:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.fyber.inneractive.sdk.util.IAlog.e(r1, r0)
        L_0x0037:
            r0 = r2
        L_0x0038:
            r4.d = r0
            boolean r0 = r4.o
            if (r0 == 0) goto L_0x0043
            r4.a()
            goto L_0x00f0
        L_0x0043:
            r4.o = r6
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest$a r6 = com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest.newBuilder()     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r0.c     // Catch:{ all -> 0x00c5 }
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r3 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r3 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r3     // Catch:{ all -> 0x00c5 }
            r3.setAppId(r0)     // Catch:{ all -> 0x00c5 }
            android.app.Application r0 = com.fyber.inneractive.sdk.util.p.a     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x00c5 }
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r3 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r3 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r3     // Catch:{ all -> 0x00c5 }
            r3.setBundle(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = com.fyber.inneractive.sdk.external.InneractiveAdManager.getVersion()     // Catch:{ all -> 0x00c5 }
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r3 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r3 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r3     // Catch:{ all -> 0x00c5 }
            r3.setSdkVersion(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r4.c     // Catch:{ all -> 0x00c5 }
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r3 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r3 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r3     // Catch:{ all -> 0x00c5 }
            r3.setIgnitePackageName(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r4.c     // Catch:{ all -> 0x00c5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c5 }
            if (r0 != 0) goto L_0x009f
            android.content.Context r0 = r4.a     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x009f
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = r4.c     // Catch:{ Exception -> 0x009a }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r5)     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = r0.versionName     // Catch:{ Exception -> 0x009a }
            goto L_0x00a0
        L_0x009a:
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)     // Catch:{ all -> 0x00c5 }
        L_0x009f:
            r0 = r2
        L_0x00a0:
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r1 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r1 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r1     // Catch:{ all -> 0x00c5 }
            r1.setIgniteVersionName(r0)     // Catch:{ all -> 0x00c5 }
            android.content.Context r0 = r4.a     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = com.fyber.inneractive.sdk.util.p.b((android.content.Context) r0)     // Catch:{ all -> 0x00c5 }
            r6.c()     // Catch:{ all -> 0x00c5 }
            MessageType r1 = r6.b     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r1 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r1     // Catch:{ all -> 0x00c5 }
            r1.setAppSignature(r0)     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r6 = r6.a()     // Catch:{ all -> 0x00c5 }
            com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest r6 = (com.fyber.inneractive.sdk.ignite.IgniteRequestOuterClass$IgniteRequest) r6     // Catch:{ all -> 0x00c5 }
            byte[] r2 = r6.toByteArray()     // Catch:{ all -> 0x00c5 }
            goto L_0x00cc
        L_0x00c5:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "Failed to build ignite request"
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r5)
        L_0x00cc:
            if (r2 == 0) goto L_0x00f0
            com.fyber.inneractive.sdk.network.k0 r5 = new com.fyber.inneractive.sdk.network.k0
            com.fyber.inneractive.sdk.ignite.d r6 = new com.fyber.inneractive.sdk.ignite.d
            r6.<init>(r4)
            com.fyber.inneractive.sdk.config.global.s r0 = r4.t
            com.fyber.inneractive.sdk.network.x r1 = com.fyber.inneractive.sdk.network.x.a()
            com.fyber.inneractive.sdk.network.g r1 = r1.b()
            r5.<init>(r6, r2, r1, r0)
            com.fyber.inneractive.sdk.config.IAConfigManager r6 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.network.y r6 = r6.s
            java.util.concurrent.BlockingQueue<com.fyber.inneractive.sdk.network.c0<?>> r6 = r6.a
            r6.offer(r5)
            com.fyber.inneractive.sdk.network.r0 r6 = com.fyber.inneractive.sdk.network.r0.QUEUED
            r5.a((com.fyber.inneractive.sdk.network.r0) r6)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.ignite.c.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        IAlog.a("onServiceDisconnected", new Object[0]);
        this.k = false;
        this.m = 0;
        h hVar = this.s;
        if (hVar != null) {
            hVar.a();
            this.s = null;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.ignite.c$c  reason: collision with other inner class name */
    public class C0099c implements n {
        public C0099c() {
        }

        public void a(String str, String str2) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.a(str, str2);
                }
            }
        }

        public void b(String str) {
            c.this.a(i.FAILED_TO_AUTHENTICATE, str);
            boolean unused = c.this.r = false;
            h hVar = c.this.s;
            if (hVar != null) {
                hVar.a();
                c.this.s = null;
            }
        }

        public void c(String str) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.c(str);
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x007b */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x004e A[SYNTHETIC, Splitter:B:12:0x004e] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(java.lang.String r8) {
            /*
                r7 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r8)
                if (r0 != 0) goto L_0x009b
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                java.lang.String r2 = "ignite authenticated successfully"
                com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
                com.fyber.inneractive.sdk.ignite.c r1 = com.fyber.inneractive.sdk.ignite.c.this
                android.os.Bundle r1 = r1.g
                java.lang.String r2 = "clientToken"
                r1.putString(r2, r8)
                com.fyber.inneractive.sdk.ignite.c r1 = com.fyber.inneractive.sdk.ignite.c.this
                r2 = 1
                boolean unused = r1.l = r2
                com.fyber.inneractive.sdk.ignite.c r1 = com.fyber.inneractive.sdk.ignite.c.this
                r1.getClass()
                boolean r3 = android.text.TextUtils.isEmpty(r8)
                java.lang.String r4 = ""
                if (r3 != 0) goto L_0x0047
                java.lang.String r3 = "\\."
                java.lang.String[] r8 = r8.split(r3)     // Catch:{ Exception -> 0x0040 }
                java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0040 }
                r8 = r8[r2]     // Catch:{ Exception -> 0x0040 }
                r5 = 8
                byte[] r8 = android.util.Base64.decode(r8, r5)     // Catch:{ Exception -> 0x0040 }
                java.lang.String r5 = "UTF-8"
                r3.<init>(r8, r5)     // Catch:{ Exception -> 0x0040 }
                goto L_0x0048
            L_0x0040:
                java.lang.Object[] r8 = new java.lang.Object[r0]
                java.lang.String r3 = "Failed to decode str"
                com.fyber.inneractive.sdk.util.IAlog.a(r3, r8)
            L_0x0047:
                r3 = r4
            L_0x0048:
                boolean r8 = r3.isEmpty()
                if (r8 != 0) goto L_0x0088
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0081 }
                r8.<init>(r3)     // Catch:{ Exception -> 0x0081 }
                java.lang.String r3 = "exp"
                long r5 = r8.optLong(r3)     // Catch:{ Exception -> 0x0081 }
                r1.m = r5     // Catch:{ Exception -> 0x0081 }
                java.lang.String r8 = "Ignite session will exp in: %s"
                java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0081 }
                java.lang.String r2 = "dd/MM/yyyy HH:mm:ss"
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0081 }
                long r5 = r3.toMillis(r5)     // Catch:{ Exception -> 0x0081 }
                java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x007b }
                r3.<init>(r2)     // Catch:{ Exception -> 0x007b }
                java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x007b }
                r2.setTimeInMillis(r5)     // Catch:{ Exception -> 0x007b }
                java.util.Date r2 = r2.getTime()     // Catch:{ Exception -> 0x007b }
                java.lang.String r4 = r3.format(r2)     // Catch:{ Exception -> 0x007b }
            L_0x007b:
                r1[r0] = r4     // Catch:{ Exception -> 0x0081 }
                com.fyber.inneractive.sdk.util.IAlog.a(r8, r1)     // Catch:{ Exception -> 0x0081 }
                goto L_0x0088
            L_0x0081:
                java.lang.Object[] r8 = new java.lang.Object[r0]
                java.lang.String r1 = "Failed to resolve expiration time"
                com.fyber.inneractive.sdk.util.IAlog.a(r1, r8)
            L_0x0088:
                com.fyber.inneractive.sdk.ignite.c r8 = com.fyber.inneractive.sdk.ignite.c.this
                boolean unused = r8.r = r0
                com.fyber.inneractive.sdk.ignite.c r8 = com.fyber.inneractive.sdk.ignite.c.this
                com.fyber.inneractive.sdk.ignite.h r8 = r8.s
                if (r8 == 0) goto L_0x009b
                r8.b()
                com.fyber.inneractive.sdk.ignite.c r8 = com.fyber.inneractive.sdk.ignite.c.this
                r0 = 0
                r8.s = r0
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.ignite.c.C0099c.d(java.lang.String):void");
        }

        public void a(String str, int i, double d) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.a(str, i, d);
                }
            }
        }

        public void a(String str) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.a(str);
                }
            }
        }

        public void b(String str, String str2, String str3) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.b(str, str2, str3);
                }
            }
        }

        public void a(String str, String str2, String str3) {
            for (n next : c.this.i) {
                if (next != null) {
                    next.a(str, str2, str3);
                }
            }
        }
    }

    public void a(s sVar) {
        this.t = sVar;
        if (((i) sVar.a(i.class)).a(y8.h, false)) {
            String g2 = g();
            this.c = g2;
            if (!TextUtils.isEmpty(g2)) {
                c();
            }
            this.p = TimeUnit.SECONDS.toMillis((long) IAConfigManager.M.w.a.b.a("igniteInstallTimeOutInSeconds", 15, 1));
        }
    }

    public void b() {
        Runnable runnable = this.q;
        if (runnable != null) {
            q.b.removeCallbacks(runnable);
            this.q = null;
        }
    }

    public final boolean a(Exception exc) {
        return !(exc instanceof t0) || ((t0) exc).a != 204;
    }

    public void a(i iVar, String str) {
        if (!this.j) {
            this.j = true;
            s.a aVar = new s.a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_FAILED_TO_START, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
            JSONObject jSONObject = new JSONObject();
            String e2 = iVar.e();
            try {
                jSONObject.put("error_code", e2);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "error_code", e2);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("message", str);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "message", str);
                }
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    public void a() {
        if (e() && !TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.f) && !this.r) {
            try {
                this.r = true;
                this.g.putInt("sdkFlowTypeKey", 1);
                this.b.authenticate(this.e, this.f, this.g, this.h.b);
            } catch (RemoteException unused) {
                this.r = false;
                IAlog.a("Failed to authenticate ignite", new Object[0]);
            }
        }
    }

    public void a(h hVar) {
        this.s = hVar;
        if (!e()) {
            c();
        } else if (!this.l || f()) {
            a();
        }
    }

    public void a(String str, d dVar) {
        if (!TextUtils.isEmpty(str)) {
            IAlog.a("Starting install timeout with %d", Long.valueOf(this.p));
            e eVar = new e(this);
            this.q = eVar;
            q.b.postDelayed(eVar, this.p);
            if (!d() || f()) {
                for (n next : this.i) {
                    if (next != null) {
                        next.b((String) null, (f() ? i.SESSION_EXPIRED : i.NOT_CONNECTED).e(), (String) null);
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HandleAndroidInvocationsUseCase.KEY_PACKAGE_NAME, str);
                jSONObject.put("data", jSONObject2);
                IIgniteServiceAPI iIgniteServiceAPI = this.b;
                String jSONObject3 = jSONObject.toString();
                Bundle bundle = this.g;
                Bundle bundle2 = new Bundle();
                g gVar = this.h;
                b bVar = new b(dVar);
                gVar.getClass();
                iIgniteServiceAPI.install(jSONObject3, bundle, bundle2, new o(gVar.a, bVar));
            } catch (Exception unused) {
                IAlog.a("Failed to install app", new Object[0]);
            }
        }
    }

    public void a(n nVar) {
        this.i.add(nVar);
    }
}
