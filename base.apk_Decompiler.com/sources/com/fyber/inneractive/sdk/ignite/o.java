package com.fyber.inneractive.sdk.ignite;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.ignite.c;
import com.fyber.inneractive.sdk.ignite.g;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.m2;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import org.json.JSONObject;

public class o extends IIgniteServiceCallback.Stub {
    public final n a;
    public final g.a b;

    public o(n nVar, g.a aVar) {
        this.a = nVar;
        this.b = aVar;
    }

    public final String a(String str) {
        try {
            return new JSONObject(str).optString("taskId");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ Exception -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "data"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r6
            java.lang.String r2 = "InstallCallback onError %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            com.fyber.inneractive.sdk.ignite.n r1 = r5.a
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r5.a(r6)
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0028 }
            org.json.JSONObject r3 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = "message"
            java.lang.String r3 = r3.optString(r4)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0029
        L_0x0028:
            r3 = r2
        L_0x0029:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x003a }
            r4.<init>(r6)     // Catch:{ Exception -> 0x003a }
            org.json.JSONObject r6 = r4.optJSONObject(r0)     // Catch:{ Exception -> 0x003a }
            if (r6 == 0) goto L_0x003a
            java.lang.String r0 = "code"
            java.lang.String r2 = r6.optString(r0)     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            com.fyber.inneractive.sdk.ignite.n r6 = r5.a
            r6.b(r1, r3, r2)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.ignite.o.onError(java.lang.String):void");
    }

    public void onProgress(String str) {
        JSONObject optJSONObject;
        IAlog.a("InstallCallback onProgress %s", str);
        try {
            String a2 = a(str);
            JSONObject optJSONObject2 = new JSONObject(str).optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(NotificationCompat.CATEGORY_PROGRESS)) != null) {
                int optInt = optJSONObject.optInt(m2.h.h);
                double optDouble = optJSONObject.optDouble(m2.h.X);
                n nVar = this.a;
                if (nVar != null) {
                    nVar.a(a2, optInt, optDouble);
                }
            }
        } catch (Exception unused) {
            IAlog.a("Failed to resolve progress data", new Object[0]);
        }
    }

    public void onScheduled(String str) {
        String str2;
        IAlog.a("InstallCallback onScheduled %s", str);
        try {
            String a2 = a(str);
            try {
                str2 = new JSONObject(str).getJSONObject(m2.h.F).optString(HandleAndroidInvocationsUseCase.KEY_PACKAGE_NAME);
            } catch (Exception unused) {
                str2 = null;
            }
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(a2, str2);
            }
        } catch (Exception unused2) {
            IAlog.a("Failed to resolve taskId", new Object[0]);
        }
    }

    public void onStart(String str) {
        IAlog.a("InstallCallback onStart %s", str);
        if (this.a != null) {
            this.a.a(a(str));
        }
    }

    public void onSuccess(String str) {
        IAlog.a("InstallCallback onSuccess %s", str);
        if (this.a != null) {
            this.a.c(a(str));
            g.a aVar = this.b;
            if (aVar != null) {
                c.b bVar = (c.b) aVar;
                c cVar = c.this;
                String str2 = bVar.a.a;
                cVar.getClass();
                if (!TextUtils.isEmpty(str2)) {
                    j0 j0Var = new j0(new f(cVar, str2), str2, x.a().b());
                    IAConfigManager.M.s.a.offer(j0Var);
                    j0Var.a(r0.QUEUED);
                }
                c.d dVar = bVar.a;
                p<?> pVar = dVar.b;
                k kVar = dVar.c;
                j jVar = pVar.h;
                r rVar = r.IGNITE_FLOW_INSTALL_DONE;
                if (kVar == null) {
                    kVar = k.SINGLE_TAP;
                }
                ((p.a) jVar).a(rVar, kVar);
            }
        }
    }
}
