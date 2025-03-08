package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import java.util.Collections;
import java.util.List;

public final class b extends c {
    public final int b;
    public final long c;
    public final long d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final a l;
    public final List<a> m;
    public final List<String> n;
    public final long o;

    public static final class a implements Comparable<Long> {
        public final String a;
        public final long b;
        public final int c;
        public final long d;
        public final boolean e;
        public final String f;
        public final String g;
        public final long h;
        public final long i;

        public a(String str, long j, int i2, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.a = str;
            this.b = j;
            this.c = i2;
            this.d = j2;
            this.e = z;
            this.f = str2;
            this.g = str3;
            this.h = j3;
            this.i = j4;
        }

        public int compareTo(Object obj) {
            Long l = (Long) obj;
            if (this.d > l.longValue()) {
                return 1;
            }
            return this.d < l.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, long j2, long j3, boolean z, int i3, int i4, int i5, long j4, boolean z2, boolean z3, a aVar, List<a> list, List<String> list2) {
        super(str);
        String str2 = str;
        this.b = i2;
        this.d = j3;
        this.e = z;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = j4;
        this.j = z2;
        this.k = z3;
        this.l = aVar;
        this.m = Collections.unmodifiableList(list);
        if (!list.isEmpty()) {
            a aVar2 = list.get(list.size() - 1);
            this.o = aVar2.d + aVar2.b;
        } else {
            this.o = 0;
        }
        this.c = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.o + j2;
        this.n = Collections.unmodifiableList(list2);
    }
}
