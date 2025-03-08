package com.ironsource;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ca {
    public static final String a = "com.google.market";
    public static final String b = "com.android.vending";
    public static final String c = "isInstalled";
    private static final String d = "ca";
    private static final ArrayList<String> e = new a();

    class a extends ArrayList<String> {
        a() {
            add(ca.a);
            add("com.android.vending");
        }
    }

    class b extends JSONObject {
        final /* synthetic */ boolean a;

        b(boolean z) throws JSONException {
            this.a = z;
            put("isInstalled", z);
        }
    }

    private enum c {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{ca.a}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});
        
        private static final Map<String, c> h = null;
        private final int a;
        private final String[] b;

        static {
            h = new HashMap();
            for (c cVar : values()) {
                for (String put : cVar.d()) {
                    h.put(put, cVar);
                }
            }
        }

        private c(int i2, String[] strArr) {
            this.a = i2;
            this.b = strArr;
        }

        /* access modifiers changed from: private */
        public static ArrayList<String> b() {
            return new ArrayList<>(h.keySet());
        }

        /* access modifiers changed from: private */
        public int c() {
            return this.a;
        }

        /* access modifiers changed from: private */
        public String[] d() {
            return this.b;
        }
    }

    private static JSONObject a(Context context) {
        return a(context, e);
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> b2 = b(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next, a(b2.contains(next.trim().toLowerCase())));
            }
        } catch (Exception unused) {
            Log.d(d, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject a(boolean z) throws JSONException {
        return new b(z);
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> s = m3.s(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo next : s) {
            if (next != null) {
                arrayList.add(next.packageName.toLowerCase());
            }
        }
        return arrayList;
    }

    public static Integer c(Context context) {
        JSONObject a2 = a(context, c.b());
        int i = 0;
        for (c cVar : c.values()) {
            String[] a3 = cVar.d();
            int length = a3.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    JSONObject optJSONObject = a2.optJSONObject(a3[i2]);
                    if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                        i = (int) (((double) i) + Math.pow(2.0d, (double) (cVar.c() - 1)));
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        return Integer.valueOf(i);
    }

    public static boolean d(Context context) {
        JSONObject a2 = a(context);
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = a2.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }
}
