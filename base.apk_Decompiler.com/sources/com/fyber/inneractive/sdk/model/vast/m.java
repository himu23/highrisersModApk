package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.c1;
import org.w3c.dom.Node;

public class m extends f {
    public static m c(Node node) {
        m mVar = new m();
        super.b(node);
        c1.a(c1.d(node, "AdTitle"));
        c1.a(c1.d(node, "Description"));
        return mVar;
    }
}
