package com.applovin.impl.mediation;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class f {
    private final Map<String, g> ama = Collections.synchronizedMap(new HashMap(16));
    private final Object amb = new Object();
    private final Map<String, Class<? extends MaxAdapter>> amc = new HashMap();
    private final Set<String> amd = new HashSet();
    private final Object ame = new Object();
    private final Set<a> amf = new HashSet();
    private final x mLogger;
    private final n mSdk;

    public f(n nVar) {
        if (nVar != null) {
            this.mSdk = nVar;
            this.mLogger = nVar.BN();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public Collection<String> tX() {
        Set unmodifiableSet;
        synchronized (this.amb) {
            HashSet hashSet = new HashSet(this.amc.size());
            for (Class<? extends MaxAdapter> name : this.amc.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    public Collection<String> tY() {
        Set<T> unmodifiableSet;
        synchronized (this.amb) {
            unmodifiableSet = Collections.unmodifiableSet(this.amd);
        }
        return unmodifiableSet;
    }

    public Collection<JSONObject> tZ() {
        ArrayList arrayList;
        synchronized (this.ame) {
            arrayList = new ArrayList(this.amf.size());
            for (a ua : this.amf) {
                arrayList.add(ua.ua());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public g c(com.applovin.impl.mediation.b.f fVar) {
        return a(fVar, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.impl.mediation.g a(com.applovin.impl.mediation.b.f r10, boolean r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Loaded "
            java.lang.String r1 = "Failed to load "
            java.lang.String r2 = "Not attempting to load "
            if (r10 == 0) goto L_0x0109
            java.lang.String r3 = r10.yA()
            java.lang.String r4 = r10.vt()
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            r6 = 0
            if (r5 == 0) goto L_0x0038
            boolean r10 = com.applovin.impl.sdk.x.Fn()
            if (r10 == 0) goto L_0x0037
            com.applovin.impl.sdk.x r10 = r9.mLogger
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "No adapter name provided for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = ", not loading the adapter "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.i(r11, r0)
        L_0x0037:
            return r6
        L_0x0038:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x005f
            boolean r10 = com.applovin.impl.sdk.x.Fn()
            if (r10 == 0) goto L_0x005e
            com.applovin.impl.sdk.x r10 = r9.mLogger
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to find default className for '"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.i(r11, r0)
        L_0x005e:
            return r6
        L_0x005f:
            if (r11 == 0) goto L_0x006c
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r5 = r9.ama
            java.lang.Object r5 = r5.get(r4)
            com.applovin.impl.mediation.g r5 = (com.applovin.impl.mediation.g) r5
            if (r5 == 0) goto L_0x006c
            return r5
        L_0x006c:
            java.lang.Object r5 = r9.amb
            monitor-enter(r5)
            java.util.Set<java.lang.String> r7 = r9.amd     // Catch:{ all -> 0x0106 }
            boolean r7 = r7.contains(r4)     // Catch:{ all -> 0x0106 }
            if (r7 != 0) goto L_0x00e6
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r2 = r9.amc     // Catch:{ all -> 0x0106 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ all -> 0x0106 }
            if (r2 == 0) goto L_0x0088
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r2 = r9.amc     // Catch:{ all -> 0x0106 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0106 }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0095
        L_0x0088:
            java.lang.Class r2 = r9.bB(r4)     // Catch:{ all -> 0x0106 }
            if (r2 != 0) goto L_0x0095
            java.util.Set<java.lang.String> r10 = r9.amd     // Catch:{ all -> 0x0106 }
            r10.add(r4)     // Catch:{ all -> 0x0106 }
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x0095:
            com.applovin.impl.mediation.g r7 = r9.a((com.applovin.impl.mediation.b.f) r10, (java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>) r2, (boolean) r11)     // Catch:{ all -> 0x0106 }
            if (r7 == 0) goto L_0x00c6
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00b4
            com.applovin.impl.sdk.x r1 = r9.mLogger     // Catch:{ all -> 0x0106 }
            java.lang.String r6 = "MediationAdapterManager"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r8.<init>(r0)     // Catch:{ all -> 0x0106 }
            r8.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0106 }
            r1.f(r6, r0)     // Catch:{ all -> 0x0106 }
        L_0x00b4:
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r0 = r9.amc     // Catch:{ all -> 0x0106 }
            r0.put(r4, r2)     // Catch:{ all -> 0x0106 }
            if (r11 == 0) goto L_0x00c4
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r11 = r9.ama     // Catch:{ all -> 0x0106 }
            java.lang.String r10 = r10.vt()     // Catch:{ all -> 0x0106 }
            r11.put(r10, r7)     // Catch:{ all -> 0x0106 }
        L_0x00c4:
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r7
        L_0x00c6:
            boolean r10 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x00df
            com.applovin.impl.sdk.x r10 = r9.mLogger     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r0.<init>(r1)     // Catch:{ all -> 0x0106 }
            r0.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0106 }
            r10.i(r11, r0)     // Catch:{ all -> 0x0106 }
        L_0x00df:
            java.util.Set<java.lang.String> r10 = r9.amd     // Catch:{ all -> 0x0106 }
            r10.add(r4)     // Catch:{ all -> 0x0106 }
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x00e6:
            boolean r10 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x0104
            com.applovin.impl.sdk.x r10 = r9.mLogger     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r0.<init>(r2)     // Catch:{ all -> 0x0106 }
            r0.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = " due to prior errors"
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0106 }
            r10.f(r11, r0)     // Catch:{ all -> 0x0106 }
        L_0x0104:
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x0106:
            r10 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            throw r10
        L_0x0109:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "No adapter spec specified"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.f.a(com.applovin.impl.mediation.b.f, boolean):com.applovin.impl.mediation.g");
    }

    public void a(String str, String str2, com.applovin.impl.mediation.b.a aVar) {
        synchronized (this.ame) {
            this.mSdk.BN();
            if (x.Fn()) {
                x BN = this.mSdk.BN();
                BN.i("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.amf.add(new a(str, str2, aVar, this.mSdk));
        }
    }

    private g a(com.applovin.impl.mediation.b.f fVar, Class<? extends MaxAdapter> cls, boolean z) {
        try {
            return new g(fVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.mSdk.getWrappingSdk()}), z, this.mSdk);
        } catch (Throwable th) {
            x.e("MediationAdapterManager", "Failed to load adapter: " + fVar, th);
            return null;
        }
    }

    private Class<? extends MaxAdapter> bB(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            x.H("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class a {
        private final String amg;
        private final JSONObject amh;
        private final String className;
        private final MaxAdFormat format;

        /* access modifiers changed from: package-private */
        public JSONObject ua() {
            return this.amh;
        }

        a(String str, String str2, com.applovin.impl.mediation.b.a aVar, n nVar) {
            this.className = str;
            this.amg = str2;
            JSONObject jSONObject = new JSONObject();
            this.amh = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (aVar != null) {
                this.format = aVar.getFormat();
                JsonUtils.putString(jSONObject, "format", aVar.getFormat().getLabel());
                return;
            }
            this.format = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.className.equals(aVar.className) || !this.amg.equals(aVar.amg)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.format;
            MaxAdFormat maxAdFormat2 = aVar.format;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int hashCode = ((this.className.hashCode() * 31) + this.amg.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.format;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.className + "', operationTag='" + this.amg + "', format=" + this.format + '}';
        }
    }
}
