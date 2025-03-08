package com.fyber.inneractive.sdk.cache.session;

import com.applovin.sdk.AppLovinEventTypes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Runnable {
    public final /* synthetic */ d a;

    public class a implements Runnable {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        public void run() {
            d dVar = b.this.a;
            JSONObject jSONObject = this.a;
            dVar.getClass();
            for (com.fyber.inneractive.sdk.cache.session.enums.b bVar : com.fyber.inneractive.sdk.cache.session.enums.b.values()) {
                if (bVar != com.fyber.inneractive.sdk.cache.session.enums.b.NONE) {
                    String name = bVar.name();
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray = jSONObject.getJSONArray(name);
                    } catch (JSONException unused) {
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        e a2 = e.a(jSONArray.optJSONObject(i));
                        if (!(a2 == null || a2.a == 0)) {
                            dVar.a(bVar, a2);
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("currentSession");
            if (optJSONObject != null) {
                f fVar = new f();
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2 = optJSONObject.getJSONArray(AppLovinEventTypes.USER_VIEWED_CONTENT);
                } catch (JSONException unused2) {
                }
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2 = jSONArray2.getJSONObject(i2);
                    } catch (JSONException unused3) {
                    }
                    com.fyber.inneractive.sdk.cache.session.enums.b a3 = com.fyber.inneractive.sdk.cache.session.enums.b.a(jSONObject2.optString("type"), jSONObject2.optString("subType"));
                    e a4 = e.a(jSONObject2.optJSONObject("session_data"));
                    if (a4 != null) {
                        fVar.a.put(a3, a4);
                    }
                }
                dVar.a(fVar);
            }
            b.this.a.getClass();
        }
    }

    public b(d dVar) {
        this.a = dVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038 A[SYNTHETIC, Splitter:B:18:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            android.app.Application r0 = com.fyber.inneractive.sdk.util.p.a
            java.lang.String r1 = "session_details.json"
            r2 = 0
            r3 = 0
            java.io.FileInputStream r4 = r0.openFileInput(r1)     // Catch:{ all -> 0x0023 }
            int r5 = r4.available()     // Catch:{ all -> 0x0024 }
            byte[] r6 = new byte[r5]     // Catch:{ all -> 0x0024 }
            int r7 = r4.read(r6)     // Catch:{ all -> 0x0024 }
            if (r7 != r5) goto L_0x001e
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0024 }
            java.lang.String r7 = "UTF-8"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0024 }
            goto L_0x001f
        L_0x001e:
            r5 = r3
        L_0x001f:
            com.fyber.inneractive.sdk.util.u.a((java.io.Closeable) r4)
            goto L_0x0032
        L_0x0023:
            r4 = r3
        L_0x0024:
            java.lang.String r5 = "readFileFromContext failed reading %s"
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0062 }
            r6[r2] = r1     // Catch:{ all -> 0x0062 }
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r6)     // Catch:{ all -> 0x0062 }
            com.fyber.inneractive.sdk.util.u.a((java.io.Closeable) r4)
            r5 = r3
        L_0x0032:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L_0x005c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x003f }
            r4.<init>(r5)     // Catch:{ all -> 0x003f }
            r3 = r4
            goto L_0x0046
        L_0x003f:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "Failed parsing SessionCache"
            com.fyber.inneractive.sdk.util.IAlog.e(r4, r2)
        L_0x0046:
            if (r3 == 0) goto L_0x0053
            android.os.Handler r0 = com.fyber.inneractive.sdk.util.q.b
            com.fyber.inneractive.sdk.cache.session.b$a r1 = new com.fyber.inneractive.sdk.cache.session.b$a
            r1.<init>(r3)
            r0.post(r1)
            goto L_0x0061
        L_0x0053:
            r0.deleteFile(r1)
            com.fyber.inneractive.sdk.cache.session.d r0 = r8.a
            r0.getClass()
            goto L_0x0061
        L_0x005c:
            com.fyber.inneractive.sdk.cache.session.d r0 = r8.a
            r0.getClass()
        L_0x0061:
            return
        L_0x0062:
            r0 = move-exception
            com.fyber.inneractive.sdk.util.u.a((java.io.Closeable) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.cache.session.b.run():void");
    }
}
