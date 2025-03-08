package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;

public class g implements Comparable<g> {
    public final String a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    public g(String str, long j, long j2, long j3, File file) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        if (!this.a.equals(gVar.a)) {
            return this.a.compareTo(gVar.a);
        }
        int i = ((this.b - gVar.b) > 0 ? 1 : ((this.b - gVar.b) == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }
}
