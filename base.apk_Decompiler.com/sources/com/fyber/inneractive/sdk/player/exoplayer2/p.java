package com.fyber.inneractive.sdk.player.exoplayer2;

public abstract class p {
    public static final p a = new a();

    public class a extends p {
        public int a() {
            return 0;
        }

        public int a(Object obj) {
            return -1;
        }

        public c a(int i, c cVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        public int b() {
            return 0;
        }

        public b a(int i, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static final class b {
        public Object a;
        public Object b;
        public int c;
        public long d;
        public long e;
    }

    public static final class c {
        public Object a;
        public boolean b;
        public int c;
        public int d;
        public long e;
        public long f;
        public long g;
    }

    public abstract int a();

    public abstract int a(Object obj);

    public abstract b a(int i, b bVar, boolean z);

    public final c a(int i, c cVar) {
        return a(i, cVar, false, 0);
    }

    public abstract c a(int i, c cVar, boolean z, long j);

    public abstract int b();

    public final boolean c() {
        return b() == 0;
    }
}
