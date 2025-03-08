package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.TreeSet;

public final class h {
    public final int a;
    public final String b;
    public final TreeSet<l> c = new TreeSet<>();
    public long d;

    public h(int i, String str, long j) {
        this.a = i;
        this.b = str;
        this.d = j;
    }

    public int a() {
        long j = this.d;
        return (((this.a * 31) + this.b.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
    }
}
