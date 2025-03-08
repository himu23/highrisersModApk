package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public class p extends b {
    public p(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        Map<String, String> map = this.b;
        this.c.setOrientationProperties(map == null || !map.containsKey("allowOrientationChange") || !"false".equals(this.b.get("allowOrientationChange")), this.b.get("forceOrientation"));
    }

    public boolean b() {
        return false;
    }
}
