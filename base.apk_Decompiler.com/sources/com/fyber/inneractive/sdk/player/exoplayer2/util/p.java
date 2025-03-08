package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.ArrayList;
import java.util.Comparator;

public class p {
    public static final Comparator<c> h = new a();
    public static final Comparator<c> i = new b();
    public final int a;
    public final ArrayList<c> b = new ArrayList<>();
    public final c[] c = new c[5];
    public int d = -1;
    public int e;
    public int f;
    public int g;

    public class a implements Comparator<c> {
        public int compare(Object obj, Object obj2) {
            return ((c) obj).a - ((c) obj2).a;
        }
    }

    public class b implements Comparator<c> {
        public int compare(Object obj, Object obj2) {
            float f = ((c) obj).c;
            float f2 = ((c) obj2).c;
            if (f < f2) {
                return -1;
            }
            return f2 < f ? 1 : 0;
        }
    }

    public static class c {
        public int a;
        public int b;
        public float c;
    }

    public p(int i2) {
        this.a = i2;
    }
}
