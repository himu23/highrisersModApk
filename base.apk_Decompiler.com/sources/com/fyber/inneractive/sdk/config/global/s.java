package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.config.global.features.a;
import com.fyber.inneractive.sdk.config.global.features.b;
import com.fyber.inneractive.sdk.config.global.features.c;
import com.fyber.inneractive.sdk.config.global.features.d;
import com.fyber.inneractive.sdk.config.global.features.e;
import com.fyber.inneractive.sdk.config.global.features.g;
import com.fyber.inneractive.sdk.config.global.features.h;
import com.fyber.inneractive.sdk.config.global.features.i;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.config.global.features.k;
import com.fyber.inneractive.sdk.config.global.features.l;
import com.fyber.inneractive.sdk.config.global.features.m;
import com.fyber.inneractive.sdk.config.global.features.n;
import com.fyber.inneractive.sdk.config.global.features.o;
import com.fyber.inneractive.sdk.config.global.features.p;
import com.fyber.inneractive.sdk.config.global.features.q;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.w;
import com.fyber.inneractive.sdk.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class s {
    public final r a = new r();
    public String b = "";
    public Map<Class<? extends g>, g> c;
    public JSONArray d;

    public s() {
        e();
        Map<Class<? extends g>, g> a2 = a();
        this.c = a2;
        IAlog.a("%s: created. Supported features: %s", "SupportedFeaturesProvider", a2);
    }

    public static s b() {
        boolean f = f();
        s sVar = new s();
        if (f) {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            iAConfigManager.L.a("", true);
            iAConfigManager.E.a(iAConfigManager.L);
        }
        return sVar;
    }

    public static boolean f() {
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.featuresConfig");
        if (TextUtils.isEmpty(property)) {
            return false;
        }
        try {
            IAConfigManager.M.z.a = l.a(new JSONObject(property));
            return true;
        } catch (Exception unused) {
            IAlog.a("failed parsing local features json", new Object[0]);
            return false;
        }
    }

    public Map<Class<? extends g>, g> a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.c.entrySet()) {
            hashMap.put(next.getKey(), ((g) next.getValue()).b());
        }
        return hashMap;
    }

    public JSONArray c() {
        JSONArray jSONArray = this.d;
        if (jSONArray == null || jSONArray.length() == 0) {
            JSONArray a2 = g.a(this.c, false);
            this.d = a2;
            IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", a2);
        }
        return this.d;
    }

    public JSONArray d() {
        JSONArray a2 = g.a(this.c, true);
        IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", a2);
        return a2;
    }

    public void e() {
        this.a.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put(r.class, new r());
        hashMap.put(c.class, new c());
        hashMap.put(l.class, new l());
        hashMap.put(e.class, new e());
        hashMap.put(k.class, new k());
        hashMap.put(d.class, new d());
        hashMap.put(q.class, new q());
        hashMap.put(h.class, new h());
        hashMap.put(i.class, new i());
        hashMap.put(p.class, new p());
        hashMap.put(n.class, new n());
        hashMap.put(b.class, new b());
        hashMap.put(m.class, new m());
        hashMap.put(a.class, new a());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.f.class, new com.fyber.inneractive.sdk.config.global.features.f());
        hashMap.put(j.class, new j());
        this.c = hashMap;
        this.d = null;
    }

    public void a(e eVar) {
        for (g next : this.c.values()) {
            ArrayList arrayList = (ArrayList) next.c();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                List<d> list = bVar.d;
                if (list != null) {
                    Iterator<d> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d next2 = it.next();
                        if (next2.a(eVar)) {
                            next.c.remove(bVar.a);
                            next.d.remove(bVar.a);
                            this.d = null;
                            IAlog.a("%s: Experiment %s filtered! after response %s", "SupportedFeaturesProvider", bVar.a, next2);
                            break;
                        }
                    }
                }
            }
        }
    }

    public <T extends g> T a(Class<T> cls) {
        if (this.c.containsKey(cls)) {
            T t = (g) this.c.get(cls);
            if (cls.isInstance(t)) {
                return t;
            }
        }
        try {
            return (g) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            IAlog.a("Couldn't create a feature for %s", e, cls.getName());
            return null;
        }
    }

    public void a(String str, boolean z) {
        char c2;
        k kVar;
        this.b = str;
        a aVar = IAConfigManager.M.z;
        aVar.b = this;
        for (g next : this.c.values()) {
            boolean z2 = next instanceof o;
            if ((z2 && z) || (!z2 && !z)) {
                l lVar = aVar.a;
                if (!(next == null || lVar == null)) {
                    q a2 = lVar.a(next.b);
                    char c3 = 2;
                    int i = 1;
                    if (a2 != null) {
                        next.a = a2.a;
                        IAlog.a("%s: Feature before variant merge: %s", "a", next);
                        Map<String, b> map = a2.c;
                        for (String str2 : map.keySet()) {
                            b bVar = map.get(str2);
                            if (bVar != null) {
                                int nextInt = new Random().nextInt(100) + i;
                                int i2 = 3;
                                if (bVar.b < nextInt) {
                                    Object[] objArr = new Object[4];
                                    objArr[0] = "a";
                                    objArr[i] = bVar.a;
                                    objArr[c3] = Integer.valueOf(nextInt);
                                    objArr[3] = Integer.valueOf(bVar.b);
                                    IAlog.a("%s: Experiment '%s' filtered! rand: %d, with perc: %d", objArr);
                                } else {
                                    List<d> list = bVar.d;
                                    if (list != null) {
                                        Iterator<d> it = list.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            d next2 = it.next();
                                            try {
                                                Long valueOf = Long.valueOf(IAConfigManager.M.d);
                                                e eVar = new e();
                                                eVar.b = valueOf;
                                                eVar.c = com.fyber.inneractive.sdk.serverapi.a.a(aVar.b.b);
                                                if (next2.a(eVar)) {
                                                    Object[] objArr2 = new Object[i2];
                                                    objArr2[0] = "a";
                                                    objArr2[i] = bVar.a;
                                                    objArr2[2] = next2;
                                                    IAlog.a("%s: Experiment '%s' filtered! with %s", objArr2);
                                                    break;
                                                }
                                            } catch (NumberFormatException unused) {
                                                Object[] objArr3 = new Object[i];
                                                objArr3[0] = "a";
                                                IAlog.a("%s: invalid publisherId", objArr3);
                                                i2 = 3;
                                            }
                                        }
                                    }
                                    if (next instanceof r) {
                                        Iterator<k> it2 = bVar.c.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            k next3 = it2.next();
                                            n nVar = next3.a;
                                            if (!(nVar == null || nVar.a() == null || !next3.a.a().containsKey("use_fmp_cache_mechanism"))) {
                                                w wVar = IAConfigManager.M.I.get(x.Video);
                                                if (wVar == null || !wVar.a("vid_cache")) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    Object[] objArr4 = new Object[4];
                                    objArr4[0] = "a";
                                    objArr4[i] = bVar.a;
                                    objArr4[2] = Integer.valueOf(nextInt);
                                    objArr4[3] = Integer.valueOf(bVar.b);
                                    IAlog.a("%s: Experiment '%s' NOT filtered! rand: %d, with perc: %d", objArr4);
                                    List<k> list2 = bVar.c;
                                    int nextInt2 = new Random().nextInt(100) + i;
                                    Object[] objArr5 = new Object[3];
                                    objArr5[0] = "a";
                                    objArr5[i] = bVar.a;
                                    int i3 = 2;
                                    objArr5[2] = Integer.valueOf(nextInt2);
                                    IAlog.a("%s: selectVariant for experiment '%s' generated random number: %d", objArr5);
                                    Iterator<k> it3 = list2.iterator();
                                    int i4 = 0;
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            c2 = 1;
                                            kVar = null;
                                            break;
                                        }
                                        kVar = it3.next();
                                        i4 += kVar.c;
                                        Object[] objArr6 = new Object[i3];
                                        objArr6[0] = "a";
                                        objArr6[i] = kVar;
                                        IAlog.a("%s: selectVariant variant found: %s", objArr6);
                                        if (i4 >= nextInt2) {
                                            c2 = 1;
                                            break;
                                        }
                                        Object[] objArr7 = new Object[i3];
                                        objArr7[0] = "a";
                                        objArr7[1] = kVar.b;
                                        IAlog.a("%s: selectVariant variant '%s' percentage outside selected range", objArr7);
                                        i = 1;
                                        i3 = 2;
                                    }
                                    if (kVar != null) {
                                        Object[] objArr8 = new Object[3];
                                        objArr8[0] = "a";
                                        objArr8[c2] = bVar.a;
                                        objArr8[2] = kVar;
                                        IAlog.a("%s: experiment '%s' variant selected! %s", objArr8);
                                    } else {
                                        Object[] objArr9 = new Object[2];
                                        objArr9[0] = "a";
                                        objArr9[c2] = bVar.a;
                                        IAlog.a("%s: experiment '%s' no variant was selected! using control group", objArr9);
                                    }
                                    next.c.put(bVar.a, bVar);
                                    if (kVar != null) {
                                        next.d.put(bVar.a, kVar);
                                    }
                                    c3 = 2;
                                    i = 1;
                                }
                                c3 = 2;
                            }
                        }
                    }
                    IAlog.a("%s: Feature after variant merge: %s", "a", next);
                }
            }
        }
    }
}
