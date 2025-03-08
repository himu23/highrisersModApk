package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    protected final Context E;
    private final Map<String, Object> aRf = new HashMap();
    private final Object aRg = new Object();
    protected final SharedPreferences ayw;
    protected final n sdk;

    public c(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.ayw = applicationContext.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(b.class.getName());
            Class.forName(a.class.getName());
        } catch (Throwable unused) {
        }
        JG();
    }

    public <T> T a(b<T> bVar) {
        if (bVar != null) {
            synchronized (this.aRg) {
                Object obj = this.aRf.get(bVar.getName());
                if (obj == null) {
                    T JD = bVar.JD();
                    return JD;
                }
                T af = bVar.af(obj);
                return af;
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.c.b<java.lang.String>, com.applovin.impl.sdk.c.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> b(com.applovin.impl.sdk.c.b<java.lang.String> r1) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.applovin.impl.sdk.utils.CollectionUtils.explode(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.c.c.b(com.applovin.impl.sdk.c.b):java.util.List");
    }

    public List<MaxAdFormat> c(b<String> bVar) {
        ArrayList arrayList = new ArrayList(6);
        for (String formatFromString : b(bVar)) {
            arrayList.add(MaxAdFormat.formatFromString(formatFromString));
        }
        return arrayList;
    }

    public <T> void a(b<?> bVar, Object obj) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.aRg) {
                this.aRf.put(bVar.getName(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    public void JF() {
        String JI = JI();
        synchronized (this.aRg) {
            SharedPreferences.Editor edit = this.ayw.edit();
            for (b next : b.JE()) {
                Object obj = this.aRf.get(next.getName());
                if (obj != null) {
                    this.sdk.a(JI + next.getName(), obj, edit);
                }
            }
            edit.apply();
        }
    }

    public void JG() {
        String JI = JI();
        synchronized (this.aRg) {
            for (b next : b.JE()) {
                try {
                    String name = next.getName();
                    Object a = this.sdk.a(JI + name, null, next.JD().getClass(), this.ayw);
                    if (a != null) {
                        this.aRf.put(next.getName(), a);
                    }
                } catch (Throwable th) {
                    x.e("SettingsManager", "Unable to load \"" + next.getName() + "\"", th);
                    this.sdk.Cs().d("SettingsManager", "initSettings", th);
                }
            }
        }
    }

    public void M(JSONObject jSONObject) {
        synchronized (this.aRg) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        b<Long> a = a(next, (b) null);
                        if (a != null) {
                            this.aRf.put(a.getName(), a(next, jSONObject, a.JD()));
                            if (a == b.aQg) {
                                this.aRf.put(b.aQh.getName(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        x.e("SettingsManager", "Unable to parse JSON settingsValues array", e);
                        this.sdk.Cs().d("SettingsManager", "loadSettings", e);
                    } catch (Throwable th) {
                        x.e("SettingsManager", "Unable to convert setting object ", th);
                        this.sdk.Cs().d("SettingsManager", "loadSettings", th);
                    }
                }
            }
        }
    }

    public void JH() {
        synchronized (this.aRg) {
            this.aRf.clear();
        }
        this.sdk.a(this.ayw);
    }

    private String JI() {
        return "com.applovin.sdk." + u.dD(this.sdk.getSdkKey()) + ".";
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    public <T> b<T> a(String str, b<T> bVar) {
        synchronized (this.aRg) {
            for (b<T> next : b.JE()) {
                if (next.getName().equals(str)) {
                    return next;
                }
            }
            return bVar;
        }
    }

    public boolean isVerboseLoggingEnabled() {
        return this.sdk.getSettings().isVerboseLoggingEnabled() || ((Boolean) a(b.aKq)).booleanValue();
    }
}
