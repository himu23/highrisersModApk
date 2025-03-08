package com.fyber.inneractive.sdk.web;

import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class z {
    public final String a;
    public final String b;
    public final Map<String, String> c;

    public z(WebResourceRequest webResourceRequest) {
        Map<String, String> map;
        this.a = webResourceRequest.getUrl().toString();
        this.b = webResourceRequest.getMethod();
        if (webResourceRequest.getRequestHeaders() == null) {
            map = Collections.emptyMap();
        } else {
            map = webResourceRequest.getRequestHeaders();
        }
        this.c = new HashMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        if (this.a.equals(zVar.a) && this.b.equals(zVar.b)) {
            return this.c.equals(zVar.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
