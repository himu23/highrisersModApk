package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

public class j6 implements z4 {
    private static Map<String, Object> a = new HashMap();

    public static class b {
        String a;
        String b;
        String c;
        Context d;
        String e;

        /* access modifiers changed from: package-private */
        public b a(Context context) {
            this.d = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b a(String str) {
            this.b = str;
            return this;
        }

        public j6 a() {
            return new j6(this);
        }

        /* access modifiers changed from: package-private */
        public b b(String str) {
            this.c = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b c(String str) {
            this.a = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b d(String str) {
            this.e = str;
            return this;
        }
    }

    private j6(b bVar) {
        a(bVar);
        a(bVar.d);
    }

    private void a(Context context) {
        a.put(z3.e, l2.b(context));
    }

    private void a(b bVar) {
        Context context = bVar.d;
        l3 b2 = l3.b(context);
        a.put(z3.i, SDKUtils.encodeString(b2.e()));
        a.put(z3.j, SDKUtils.encodeString(b2.f()));
        a.put(z3.k, Integer.valueOf(b2.a()));
        a.put(z3.l, SDKUtils.encodeString(b2.d()));
        a.put(z3.m, SDKUtils.encodeString(b2.c()));
        a.put(z3.d, SDKUtils.encodeString(context.getPackageName()));
        a.put(z3.f, SDKUtils.encodeString(bVar.b));
        a.put(z3.g, SDKUtils.encodeString(bVar.a));
        a.put(z3.b, SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        a.put(z3.n, z3.s);
        a.put("origin", z3.p);
        if (!TextUtils.isEmpty(bVar.e)) {
            a.put(z3.h, SDKUtils.encodeString(bVar.e));
        }
    }

    public static void a(String str) {
        a.put(z3.e, SDKUtils.encodeString(str));
    }

    public Map<String, Object> a() {
        return a;
    }
}
