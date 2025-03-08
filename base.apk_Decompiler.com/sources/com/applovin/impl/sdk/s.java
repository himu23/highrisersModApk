package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class s {
    private final Map<String, Object> aEQ;
    private final long aER;

    /* renamed from: do  reason: not valid java name */
    private final String f17do = UUID.randomUUID().toString();
    private final String name;

    public Map<String, Object> EU() {
        return this.aEQ;
    }

    public long EV() {
        return this.aER;
    }

    public String getName() {
        return this.name;
    }

    public String mQ() {
        return this.f17do;
    }

    public s(String str, Map<String, String> map, Map<String, Object> map2) {
        this.name = str;
        HashMap hashMap = new HashMap();
        this.aEQ = hashMap;
        hashMap.putAll(map);
        hashMap.put("applovin_sdk_super_properties", map2);
        this.aER = System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.aER != sVar.aER) {
            return false;
        }
        String str = this.name;
        if (str == null ? sVar.name != null : !str.equals(sVar.name)) {
            return false;
        }
        Map<String, Object> map = this.aEQ;
        if (map == null ? sVar.aEQ != null : !map.equals(sVar.aEQ)) {
            return false;
        }
        String str2 = this.f17do;
        String str3 = sVar.f17do;
        if (str2 != null) {
            if (!str2.equals(str3)) {
                return false;
            }
            return true;
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.aEQ;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.aER;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f17do;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Event{name='" + this.name + "', id='" + this.f17do + "', creationTimestampMillis=" + this.aER + ", parameters=" + this.aEQ + '}';
    }
}
