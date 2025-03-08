package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.h;
import com.fyber.inneractive.sdk.player.exoplayer2.source.m;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public final class g implements m, j.b, e.b {
    public final e a;
    public final d b;
    public final int c;
    public final f.a d;
    public final b e;
    public final IdentityHashMap<o, Integer> f = new IdentityHashMap<>();
    public final k g = new k();
    public final Handler h = new Handler();
    public final long i;
    public m.a j;
    public int k;
    public boolean l;
    public s m;
    public j[] n;
    public j[] o;
    public h p;

    public g(e eVar, d dVar, int i2, f.a aVar, b bVar, long j2) {
        this.a = eVar;
        this.b = dVar;
        this.c = i2;
        this.d = aVar;
        this.e = bVar;
        this.i = j2;
    }

    public s b() {
        return this.m;
    }

    public void c() {
        g();
    }

    public void c(long j2) {
    }

    public long d() {
        long j2;
        long j3 = Long.MAX_VALUE;
        for (j jVar : this.o) {
            if (jVar.y) {
                j2 = Long.MIN_VALUE;
            } else if (jVar.h()) {
                j2 = jVar.x;
            } else {
                long j4 = jVar.w;
                f last = jVar.k.getLast();
                if (!last.F) {
                    if (jVar.k.size() > 1) {
                        LinkedList<f> linkedList = jVar.k;
                        last = linkedList.get(linkedList.size() - 2);
                    } else {
                        last = null;
                    }
                }
                if (last != null) {
                    j4 = Math.max(j4, last.g);
                }
                int size = jVar.j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    j4 = Math.max(j4, jVar.j.valueAt(i2).d());
                }
                j2 = j4;
            }
            if (j2 != Long.MIN_VALUE) {
                j3 = Math.min(j3, j2);
            }
        }
        if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j3;
    }

    public long f() {
        return -9223372036854775807L;
    }

    public void a(m.a aVar) {
        this.a.h.add(this);
        this.j = aVar;
        a aVar2 = this.a.k;
        ArrayList arrayList = new ArrayList(aVar2.b);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a.C0117a aVar3 = (a.C0117a) arrayList.get(i2);
            if (aVar3.b.k > 0 || a(aVar3, "avc")) {
                arrayList2.add(aVar3);
            } else if (a(aVar3, "mp4a")) {
                arrayList3.add(aVar3);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List<a.C0117a> list = aVar2.c;
        List<a.C0117a> list2 = aVar2.d;
        int size = list.size() + 1 + list2.size();
        this.n = new j[size];
        this.k = size;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(!arrayList.isEmpty());
        a.C0117a[] aVarArr = new a.C0117a[arrayList.size()];
        arrayList.toArray(aVarArr);
        j a2 = a(0, aVarArr, aVar2.e, aVar2.f);
        this.n[0] = a2;
        a2.c.h = true;
        a2.g();
        int i3 = 0;
        int i4 = 1;
        while (i3 < list.size()) {
            j a3 = a(1, new a.C0117a[]{list.get(i3)}, (i) null, Collections.emptyList());
            this.n[i4] = a3;
            a3.g();
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            a.C0117a aVar4 = list2.get(i5);
            j a4 = a(3, new a.C0117a[]{aVar4}, (i) null, Collections.emptyList());
            a4.a(0).a(aVar4.b);
            a4.n = true;
            a4.i();
            this.n[i4] = a4;
            i5++;
            i4++;
        }
    }

    public void e() throws IOException {
        j[] jVarArr = this.n;
        if (jVarArr != null) {
            for (j j2 : jVarArr) {
                j2.j();
            }
        }
    }

    public final void g() {
        if (this.m != null) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.j).a((p) this);
            return;
        }
        for (j g2 : this.n) {
            g2.g();
        }
    }

    public long b(long j2) {
        this.g.a.clear();
        for (j d2 : this.o) {
            d2.d(j2);
        }
        return j2;
    }

    public long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        long j3;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr2 = eVarArr;
        o[] oVarArr2 = oVarArr;
        long j4 = j2;
        int[] iArr = new int[eVarArr2.length];
        int[] iArr2 = new int[eVarArr2.length];
        for (int i3 = 0; i3 < eVarArr2.length; i3++) {
            o oVar = oVarArr2[i3];
            if (oVar == null) {
                i2 = -1;
            } else {
                i2 = this.f.get(oVar).intValue();
            }
            iArr[i3] = i2;
            iArr2[i3] = -1;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = eVarArr2[i3];
            if (eVar != null) {
                r b2 = eVar.b();
                int i4 = 0;
                while (true) {
                    j[] jVarArr = this.n;
                    if (i4 >= jVarArr.length) {
                        break;
                    } else if (jVarArr[i4].t.a(b2) != -1) {
                        iArr2[i3] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.f.clear();
        int length = eVarArr2.length;
        o[] oVarArr3 = new o[length];
        o[] oVarArr4 = new o[eVarArr2.length];
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr3 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[eVarArr2.length];
        ArrayList arrayList = new ArrayList(this.n.length);
        int i5 = 0;
        boolean z = false;
        while (i5 < this.n.length) {
            for (int i6 = 0; i6 < eVarArr2.length; i6++) {
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar2 = null;
                oVarArr4[i6] = iArr[i6] == i5 ? oVarArr2[i6] : null;
                if (iArr2[i6] == i5) {
                    eVar2 = eVarArr2[i6];
                }
                eVarArr3[i6] = eVar2;
            }
            int i7 = i5;
            ArrayList arrayList2 = arrayList;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr4 = eVarArr3;
            z |= this.n[i5].a(eVarArr3, zArr, oVarArr4, zArr2, !this.l);
            boolean z2 = false;
            for (int i8 = 0; i8 < eVarArr2.length; i8++) {
                if (iArr2[i8] == i7) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(oVarArr4[i8] != null);
                    oVarArr3[i8] = oVarArr4[i8];
                    this.f.put(oVarArr4[i8], Integer.valueOf(i7));
                    z2 = true;
                } else if (iArr[i8] == i7) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(oVarArr4[i8] == null);
                }
            }
            if (z2) {
                arrayList2.add(this.n[i7]);
            }
            i5 = i7 + 1;
            arrayList = arrayList2;
            eVarArr3 = eVarArr4;
            long j5 = j2;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(oVarArr3, 0, oVarArr2, 0, length);
        j[] jVarArr2 = new j[arrayList3.size()];
        this.o = jVarArr2;
        arrayList3.toArray(jVarArr2);
        j[] jVarArr3 = this.o;
        if (jVarArr3.length > 0) {
            jVarArr3[0].c.h = true;
            int i9 = 1;
            while (true) {
                j[] jVarArr4 = this.o;
                if (i9 >= jVarArr4.length) {
                    break;
                }
                jVarArr4[i9].c.h = false;
                i9++;
            }
        }
        this.p = new h(this.o);
        if (!this.l || !z) {
            j3 = j2;
        } else {
            j3 = j2;
            b(j3);
            for (int i10 = 0; i10 < eVarArr2.length; i10++) {
                if (oVarArr2[i10] != null) {
                    zArr2[i10] = true;
                }
            }
        }
        this.l = true;
        return j3;
    }

    public boolean a(long j2) {
        return this.p.a(j2);
    }

    public long a() {
        return this.p.a();
    }

    public void a(p pVar) {
        if (this.m != null) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.j).a((p) this);
        }
    }

    public void a(a.C0117a aVar, long j2) {
        int c2;
        for (j jVar : this.n) {
            c cVar = jVar.c;
            int a2 = cVar.f.a(aVar.b);
            if (!(a2 == -1 || (c2 = cVar.p.c(a2)) == -1)) {
                cVar.p.a(c2, j2);
            }
        }
        g();
    }

    public final j a(int i2, a.C0117a[] aVarArr, i iVar, List<i> list) {
        c cVar = new c(this.a, aVarArr, this.b, this.g, list);
        b bVar = this.e;
        long j2 = this.i;
        return new j(i2, this, cVar, bVar, j2, iVar, this.c, this.d);
    }

    public static boolean a(a.C0117a aVar, String str) {
        String str2 = aVar.b.c;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String startsWith : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
