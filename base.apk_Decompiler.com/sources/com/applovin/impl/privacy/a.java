package com.applovin.impl.privacy;

import android.content.Context;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.x;

public class a {
    private static final C0080a axn = new C0080a("Age Restricted User", d.aRr);
    private static final C0080a axo = new C0080a("Has User Consent", d.aRq);
    private static final C0080a axp = new C0080a("\"Do Not Sell\"", d.aRs);

    public static C0080a zO() {
        return axn;
    }

    public static C0080a zP() {
        return axo;
    }

    public static C0080a zQ() {
        return axp;
    }

    public static boolean a(boolean z, Context context) {
        return a(d.aRr, Boolean.valueOf(z), context);
    }

    public static boolean b(boolean z, Context context) {
        return a(d.aRq, Boolean.valueOf(z), context);
    }

    public static boolean c(boolean z, Context context) {
        return a(d.aRs, Boolean.valueOf(z), context);
    }

    public static String A(Context context) {
        return a(axn, context) + a(axo, context) + a(axp, context);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.c.d, java.lang.Object, com.applovin.impl.sdk.c.d<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.applovin.impl.sdk.c.d<java.lang.Boolean> r2, java.lang.Boolean r3, android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0017
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to update compliance value for key: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppLovinSdk"
            com.applovin.impl.sdk.x.H(r3, r2)
            return r0
        L_0x0017:
            r1 = 0
            java.lang.Object r1 = com.applovin.impl.sdk.c.e.b(r2, r1, (android.content.Context) r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.applovin.impl.sdk.c.e.a(r2, r3, (android.content.Context) r4)
            r2 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r3) goto L_0x0027
            r0 = 1
        L_0x0027:
            return r0
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.privacy.a.a(com.applovin.impl.sdk.c.d, java.lang.Boolean, android.content.Context):boolean");
    }

    private static String a(C0080a aVar, Context context) {
        return "\n" + aVar.name + " - " + aVar.C(context);
    }

    /* renamed from: com.applovin.impl.privacy.a$a  reason: collision with other inner class name */
    public static class C0080a {
        private final d<Boolean> axq;
        /* access modifiers changed from: private */
        public final String name;

        public String getName() {
            return this.name;
        }

        C0080a(String str, d<Boolean> dVar) {
            this.name = str;
            this.axq = dVar;
        }

        public Boolean B(Context context) {
            if (context != null) {
                return (Boolean) e.b(this.axq, null, context);
            }
            x.H("AppLovinSdk", "Failed to get value for key: " + this.axq);
            return null;
        }

        public String C(Context context) {
            Boolean B = B(context);
            return B != null ? B.toString() : "No value set";
        }
    }
}
