package com.fyber.inneractive.sdk.model.vast;

import androidx.core.app.NotificationCompat;
import com.fyber.inneractive.sdk.util.c1;
import org.w3c.dom.Node;

public class s {
    public String a;
    public String b;
    public String c;

    public static s a(Node node) {
        if (node == null) {
            return null;
        }
        s sVar = new s();
        sVar.a = c1.b(node, NotificationCompat.CATEGORY_EVENT);
        sVar.b = c1.a(node);
        sVar.c = c1.b(node, "offset");
        return sVar;
    }

    public String toString() {
        return "VTracking:  name:" + this.a + " url:" + this.b + " offset:" + this.c;
    }
}
