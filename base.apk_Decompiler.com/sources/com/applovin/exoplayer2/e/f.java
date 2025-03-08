package com.applovin.exoplayer2.e;

import android.net.Uri;
import com.applovin.exoplayer2.e.b.b;
import com.applovin.exoplayer2.e.e.d;
import com.applovin.exoplayer2.e.g.g;
import com.applovin.exoplayer2.e.i.a;
import com.applovin.exoplayer2.e.i.ac;
import com.applovin.exoplayer2.e.i.c;
import com.applovin.exoplayer2.e.i.e;
import com.applovin.exoplayer2.e.i.w;
import com.applovin.exoplayer2.l.l;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f implements l {
    private static final int[] ug = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};
    private static final Constructor<? extends h> uh;
    private boolean ui;
    private boolean uj;
    private int uk;
    private int ul;
    private int um;
    private int un;
    private int uo;
    private int uq;
    private int ur;
    private int us = 1;
    private int ut;
    private int uu = 112800;

    static {
        Constructor<? extends U> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.applovin.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
                constructor = Class.forName("com.applovin.exoplayer2.ext.flac.FlacExtractor").asSubclass(h.class).getConstructor(new Class[]{Integer.TYPE});
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        uh = constructor;
    }

    public synchronized h[] createExtractors() {
        return a(Uri.EMPTY, new HashMap());
    }

    public synchronized h[] a(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int e = l.e(map);
        if (e != -1) {
            b(e, arrayList);
        }
        int g = l.g(uri);
        if (!(g == -1 || g == e)) {
            b(g, arrayList);
        }
        for (int i : ug) {
            if (!(i == e || i == g)) {
                b(i, arrayList);
            }
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    private void b(int i, List<h> list) {
        int i2 = 2;
        switch (i) {
            case 0:
                list.add(new a());
                return;
            case 1:
                list.add(new c());
                return;
            case 2:
                boolean z = this.uk | this.ui;
                if (!this.uj) {
                    i2 = 0;
                }
                list.add(new e(i2 | z ? 1 : 0));
                return;
            case 3:
                boolean z2 = this.ul | this.ui;
                if (!this.uj) {
                    i2 = 0;
                }
                list.add(new com.applovin.exoplayer2.e.a.a(i2 | z2 ? 1 : 0));
                return;
            case 4:
                Constructor<? extends h> constructor = uh;
                if (constructor != null) {
                    try {
                        list.add((h) constructor.newInstance(new Object[]{Integer.valueOf(this.um)}));
                        return;
                    } catch (Exception e) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                    }
                } else {
                    list.add(new b(this.um));
                    return;
                }
            case 5:
                list.add(new com.applovin.exoplayer2.e.c.b());
                return;
            case 6:
                list.add(new d(this.un));
                return;
            case 7:
                boolean z3 = this.ur | this.ui;
                if (!this.uj) {
                    i2 = 0;
                }
                list.add(new com.applovin.exoplayer2.e.f.d(i2 | z3 ? 1 : 0));
                return;
            case 8:
                list.add(new com.applovin.exoplayer2.e.g.e(this.uq));
                list.add(new g(this.uo));
                return;
            case 9:
                list.add(new com.applovin.exoplayer2.e.h.c());
                return;
            case 10:
                list.add(new w());
                return;
            case 11:
                list.add(new ac(this.us, this.ut, this.uu));
                return;
            case 12:
                list.add(new com.applovin.exoplayer2.e.j.a());
                return;
            case 14:
                list.add(new com.applovin.exoplayer2.e.d.a());
                return;
            default:
                return;
        }
    }
}
