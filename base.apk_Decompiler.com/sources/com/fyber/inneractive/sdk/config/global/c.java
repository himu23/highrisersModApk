package com.fyber.inneractive.sdk.config.global;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public class c implements d {
    public Set<Long> a = new HashSet();
    public boolean b;

    public c(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong != 0) {
                    this.a.add(Long.valueOf(optLong));
                }
            }
        }
        this.b = z;
    }

    public boolean a(e eVar) {
        if (this.a.isEmpty() || eVar == null || eVar.a == null) {
            return false;
        }
        for (Long equals : this.a) {
            if (equals.equals(eVar.a)) {
                return !this.b;
            }
        }
        return this.b;
    }

    public String toString() {
        return String.format("%s - %s include: %b", new Object[]{"demand", this.a, Boolean.valueOf(this.b)});
    }
}
