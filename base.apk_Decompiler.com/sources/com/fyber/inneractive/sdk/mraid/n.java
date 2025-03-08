package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public class n extends a {
    public n(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        String str = this.b.get("uri");
        if (str == null || "".equals(str)) {
            this.c.a(g.PLAY_VIDEO, "Video can't be played with null or empty URL");
            return;
        }
        L l = ((IAmraidWebViewController) this.c).g;
        if (l != null) {
            ((i.h) l).a(str);
        }
    }

    public String c() {
        return this.b.get("uri");
    }
}
