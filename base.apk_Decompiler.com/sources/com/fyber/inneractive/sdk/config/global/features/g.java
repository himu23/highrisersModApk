package com.fyber.inneractive.sdk.config.global.features;

import com.fyber.inneractive.sdk.config.global.b;
import com.fyber.inneractive.sdk.config.global.k;
import com.fyber.inneractive.sdk.config.global.n;
import com.fyber.inneractive.sdk.config.global.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class g extends p {
    public String b;
    public Map<String, b> c = new HashMap();
    public Map<String, k> d = new HashMap();

    public g(String str) {
        this.b = str;
    }

    public String a(String str, String str2) {
        String str3;
        Iterator<String> it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str3 = null;
                break;
            }
            str3 = this.d.get(it.next()).c(str);
            if (str3 != null) {
                break;
            }
        }
        if (str3 != null) {
            return str3;
        }
        n nVar = this.a;
        return nVar != null ? nVar.a(str, str2) : str2;
    }

    public abstract g b();

    public Integer b(String str) {
        Integer num;
        Iterator<String> it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = this.d.get(it.next()).b(str);
            if (num != null) {
                break;
            }
        }
        return num == null ? super.b(str) : num;
    }

    public List<b> c() {
        return new ArrayList(this.c.values());
    }

    public Boolean d(String str) {
        Boolean bool;
        Iterator<String> it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bool = null;
                break;
            }
            bool = this.d.get(it.next()).d(str);
            if (bool != null) {
                break;
            }
        }
        return bool == null ? super.d(str) : bool;
    }

    public String toString() {
        return String.format("id: %s, params: %s exp: %s", new Object[]{this.b, this.a, this.c});
    }

    public String c(String str) {
        return a(str, (String) null);
    }

    public int a(String str, int i) {
        Integer b2 = b(str);
        return b2 != null ? b2.intValue() : i;
    }

    public Double a(String str) {
        Double d2;
        Iterator<String> it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                d2 = null;
                break;
            }
            d2 = this.d.get(it.next()).a(str);
            if (d2 != null) {
                break;
            }
        }
        return d2 == null ? super.a(str) : d2;
    }

    public boolean a(String str, boolean z) {
        Boolean d2 = d(str);
        return d2 != null ? d2.booleanValue() : z;
    }

    public void a(g gVar) {
        gVar.b = this.b;
        gVar.a = this.a;
        gVar.c = new HashMap(this.c);
        gVar.d = new HashMap(this.d);
    }
}
