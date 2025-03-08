package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class e implements v.c {
    public final int a;
    public final List<i> b;

    public e(int i, List<i> list) {
        this.a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(i.a((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (a) null));
        }
        this.b = list;
    }

    public SparseArray<v> a() {
        return new SparseArray<>();
    }

    public final boolean a(int i) {
        return (i & this.a) != 0;
    }

    public v a(int i, v.b bVar) {
        if (i == 2) {
            return new o(new i());
        }
        if (i == 3 || i == 4) {
            return new o(new m(bVar.a));
        }
        if (i != 15) {
            if (i == 21) {
                return new o(new l());
            }
            if (i != 27) {
                if (i == 36) {
                    return new o(new k(a(bVar)));
                }
                if (i == 89) {
                    return new o(new g(bVar.b));
                }
                if (i != 138) {
                    if (i != 129) {
                        if (i != 130) {
                            if (i != 134) {
                                if (i != 135) {
                                    return null;
                                }
                            } else if (a(16)) {
                                return null;
                            } else {
                                return new r(new t());
                            }
                        }
                    }
                    return new o(new b(bVar.a));
                }
                return new o(new f(bVar.a));
            } else if (a(4)) {
                return null;
            } else {
                return new o(new j(a(bVar), a(1), a(8)));
            }
        } else if (a(2)) {
            return null;
        } else {
            return new o(new d(false, bVar.a));
        }
    }

    public final s a(v.b bVar) {
        byte b2;
        String str;
        if (a(32)) {
            return new s(this.b);
        }
        byte[] bArr = bVar.c;
        int length = bArr.length;
        int i = 0;
        List<i> list = this.b;
        while (length - i > 0) {
            byte b3 = bArr[i] & UByte.MAX_VALUE;
            int i2 = i + 2;
            int i3 = (bArr[i + 1] & UByte.MAX_VALUE) + i2;
            boolean z = true;
            ArrayList arrayList = list;
            if (b3 == 134) {
                ArrayList arrayList2 = new ArrayList();
                int i4 = i + 3;
                byte b4 = bArr[i2] & Ascii.US;
                for (int i5 = 0; i5 < b4; i5++) {
                    String str2 = new String(bArr, i4, 3, Charset.defaultCharset());
                    byte b5 = bArr[i4 + 3];
                    if ((b5 & ByteCompanionObject.MIN_VALUE) != 0) {
                        b2 = b5 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        b2 = 1;
                    }
                    arrayList2.add(i.a((String) null, str, (String) null, -1, 0, str2, b2, (a) null, Long.MAX_VALUE, Collections.emptyList()));
                    i4 += 6;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i4 >= 0 && i4 <= length);
                }
                arrayList = arrayList2;
            }
            if (i3 < 0 || i3 > length) {
                z = false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z);
            i = i3;
            list = arrayList;
        }
        return new s(list);
    }
}
