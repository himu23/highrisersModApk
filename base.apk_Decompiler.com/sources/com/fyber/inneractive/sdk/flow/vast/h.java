package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.q;
import java.util.Comparator;

public class h implements Comparator<o> {
    public int a;
    public int b;
    public int c;

    public h(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final Integer a(String str) {
        q a2 = q.a(str);
        if (a2 == q.MEDIA_TYPE_MP4) {
            return 3;
        }
        if (a2 == q.MEDIA_TYPE_3GPP) {
            return 2;
        }
        if (a2 == q.MEDIA_TYPE_WEBM) {
            return 1;
        }
        return -1;
    }

    public int compare(Object obj, Object obj2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        o oVar = (o) obj;
        o oVar2 = (o) obj2;
        if (!TextUtils.equals("VPAID", oVar2.f)) {
            if (!TextUtils.equals("VPAID", oVar.f)) {
                Integer num = oVar.e;
                if (num == null) {
                    i = 0;
                } else {
                    i = num.intValue();
                }
                Integer num2 = oVar2.e;
                if (num2 == null) {
                    i2 = 0;
                } else {
                    i2 = num2.intValue();
                }
                int i7 = this.a;
                if (i2 <= i7 || i > i7) {
                    if (i <= i7 || i2 > i7) {
                        int compareTo = a(oVar2.d).compareTo(a(oVar.d));
                        if (compareTo != 0) {
                            return compareTo;
                        }
                        if (i >= i2) {
                            if (i <= i2) {
                                Integer num3 = oVar.b;
                                if (num3 == null) {
                                    i3 = 0;
                                } else {
                                    i3 = num3.intValue();
                                }
                                Integer num4 = oVar.c;
                                if (num4 == null) {
                                    i4 = 0;
                                } else {
                                    i4 = num4.intValue();
                                }
                                Integer num5 = oVar2.b;
                                if (num5 == null) {
                                    i5 = 0;
                                } else {
                                    i5 = num5.intValue();
                                }
                                Integer num6 = oVar2.c;
                                if (num6 == null) {
                                    i6 = 0;
                                } else {
                                    i6 = num6.intValue();
                                }
                                int i8 = i3 * i4;
                                int i9 = i5 * i6;
                                int i10 = this.b * this.c;
                                int abs = Math.abs(i8 - i10);
                                int abs2 = Math.abs(i9 - i10);
                                if (abs >= abs2) {
                                    if (abs > abs2) {
                                        return 1;
                                    }
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
