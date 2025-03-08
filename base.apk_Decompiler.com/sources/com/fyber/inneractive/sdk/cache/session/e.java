package com.fyber.inneractive.sdk.cache.session;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public int a;
    public int b;
    public int c;
    public long d;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.fyber.inneractive.sdk.cache.session.enums.a[] r0 = com.fyber.inneractive.sdk.cache.session.enums.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.cache.session.enums.a r1 = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.cache.session.enums.a r1 = com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.cache.session.enums.a r1 = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.cache.session.e.a.<clinit>():void");
        }
    }

    public e() {
        this(0, 0, 0, System.currentTimeMillis());
    }

    public JSONObject a(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("time", this.d);
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("imp", this.a);
        if (z2) {
            jSONObject.put("com", this.c);
        }
        jSONObject.put("cli", this.b);
        return jSONObject;
    }

    public e(int i, int i2, int i3, long j) {
        this.d = j;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static e a(JSONObject jSONObject) {
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("time");
            int optInt = jSONObject.optInt("cli", -1);
            int optInt2 = jSONObject.optInt("imp", -1);
            int optInt3 = jSONObject.optInt("com", -1);
            if (optLong != 0 && optInt >= 0 && optInt2 >= 0 && optInt3 >= 0) {
                return new e(optInt2, optInt, optInt3, optLong);
            }
        }
        return null;
    }
}
