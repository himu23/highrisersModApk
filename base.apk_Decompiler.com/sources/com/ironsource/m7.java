package com.ironsource;

import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class m7 {
    private static final int p = 0;
    private ArrayList<InterstitialPlacement> a;
    private m0 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private a g;
    private boolean h;
    private boolean i;
    private long j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private InterstitialPlacement o;

    public m7() {
        this.a = new ArrayList<>();
        this.b = new m0();
    }

    public m7(int i2, boolean z, int i3, m0 m0Var, a aVar, int i4, boolean z2, boolean z3, long j2, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.b = m0Var;
        this.g = aVar;
        this.k = z4;
        this.l = z5;
        this.f = i4;
        this.h = z2;
        this.i = z3;
        this.j = j2;
        this.m = z6;
        this.n = z7;
    }

    public InterstitialPlacement a() {
        Iterator<InterstitialPlacement> it = this.a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.o;
    }

    public InterstitialPlacement a(String str) {
        Iterator<InterstitialPlacement> it = this.a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a(InterstitialPlacement interstitialPlacement) {
        if (interstitialPlacement != null) {
            this.a.add(interstitialPlacement);
            if (this.o == null || interstitialPlacement.isPlacementId(0)) {
                this.o = interstitialPlacement;
            }
        }
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis((long) this.e);
    }

    public boolean f() {
        return this.d;
    }

    public a g() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    public long i() {
        return this.j;
    }

    public m0 j() {
        return this.b;
    }

    public boolean k() {
        return this.h;
    }

    public boolean l() {
        return this.k;
    }

    public boolean m() {
        return this.n;
    }

    public boolean n() {
        return this.m;
    }

    public boolean o() {
        return this.l;
    }

    public String toString() {
        return "InterstitialConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + '}';
    }
}
