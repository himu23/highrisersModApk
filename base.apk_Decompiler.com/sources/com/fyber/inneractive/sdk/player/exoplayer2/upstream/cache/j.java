package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a;
import java.util.Comparator;
import java.util.TreeSet;

public final class j implements f, Comparator<g> {
    public final TreeSet<g> a = new TreeSet<>(this);
    public long b;

    public j(long j) {
    }

    public void a(a aVar, g gVar) {
        this.a.remove(gVar);
        this.b -= gVar.c;
    }

    public void b(a aVar, g gVar) {
        this.a.add(gVar);
        this.b += gVar.c;
        a(aVar, 0);
    }

    public int compare(Object obj, Object obj2) {
        g gVar = (g) obj;
        g gVar2 = (g) obj2;
        long j = gVar.f;
        long j2 = gVar2.f;
        if (j - j2 == 0) {
            return gVar.compareTo(gVar2);
        }
        return j < j2 ? -1 : 1;
    }

    public void a(a aVar, g gVar, g gVar2) {
        this.a.remove(gVar);
        this.b -= gVar.c;
        b(aVar, gVar2);
    }

    public final void a(a aVar, long j) {
        while (this.b + j > 10485760) {
            try {
                aVar.a(this.a.first());
            } catch (a.C0128a unused) {
            }
        }
    }
}
