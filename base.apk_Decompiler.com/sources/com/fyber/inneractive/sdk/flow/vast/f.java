package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.model.vast.c;
import com.fyber.inneractive.sdk.model.vast.h;
import java.util.Comparator;

public class f implements Comparator<c> {
    public int a;
    public int b;

    public f(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public Integer a(c cVar) {
        h hVar = cVar.a;
        if (hVar == h.Html) {
            return 3;
        }
        if (hVar == h.Iframe) {
            return 2;
        }
        if (hVar == h.Static) {
            return 1;
        }
        return -1;
    }

    public int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        int i = cVar.c * cVar.d;
        int i2 = cVar2.c * cVar2.d;
        int i3 = this.a * this.b;
        int abs = Math.abs(i - i3);
        int abs2 = Math.abs(i2 - i3);
        if (abs >= abs2) {
            if (abs <= abs2) {
                float floatValue = Float.valueOf((float) this.a).floatValue() / Float.valueOf((float) this.b).floatValue();
                float abs3 = Math.abs(floatValue - (Float.valueOf((float) cVar.c).floatValue() / Float.valueOf((float) cVar.d).floatValue()));
                float abs4 = Math.abs(floatValue - (Float.valueOf((float) cVar2.c).floatValue() / Float.valueOf((float) cVar2.d).floatValue()));
                if (abs3 >= abs4) {
                    if (abs3 <= abs4) {
                        int compareTo = a(cVar2).compareTo(a(cVar));
                        if (compareTo != 0) {
                            return compareTo;
                        }
                        return 0;
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
