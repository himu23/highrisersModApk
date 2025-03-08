package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.c1;
import org.w3c.dom.Node;

public class v extends f {
    public String f;

    public static v c(Node node) {
        v vVar = new v();
        super.b(node);
        vVar.f = c1.a(c1.d(node, "VASTAdTagURI"));
        return vVar;
    }
}
