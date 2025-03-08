package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public class s extends b {
    public s(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public boolean b() {
        return false;
    }

    public void a() {
        boolean equals = "true".equals(this.b.get("shouldUseCustomClose"));
        if (InneractiveAdManager.isCurrentUserAChild()) {
            equals = false;
        }
        this.c.c(equals);
    }
}
