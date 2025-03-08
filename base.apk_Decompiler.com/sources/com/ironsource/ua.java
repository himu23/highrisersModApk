package com.ironsource;

import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ua {
    private static final int q = 0;
    private ArrayList<Placement> a;
    private m0 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Placement n;
    private a o;
    private boolean p;

    public ua() {
        this.a = new ArrayList<>();
        this.b = new m0();
    }

    public ua(int i2, boolean z, int i3, int i4, m0 m0Var, a aVar, int i5, boolean z2, boolean z3, long j2, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.b = m0Var;
        this.f = i4;
        this.o = aVar;
        this.g = i5;
        this.p = z2;
        this.h = z3;
        this.i = j2;
        this.j = z4;
        this.k = z5;
        this.l = z6;
        this.m = z7;
    }

    public Placement a() {
        Iterator<Placement> it = this.a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.n;
    }

    public Placement a(String str) {
        Iterator<Placement> it = this.a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a(Placement placement) {
        if (placement != null) {
            this.a.add(placement);
            if (this.n == null || placement.isPlacementId(0)) {
                this.n = placement;
            }
        }
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.p;
    }

    public ArrayList<Placement> e() {
        return this.a;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public long i() {
        return TimeUnit.SECONDS.toMillis((long) this.e);
    }

    public boolean j() {
        return this.d;
    }

    public a k() {
        return this.o;
    }

    public boolean l() {
        return this.h;
    }

    public long m() {
        return this.i;
    }

    public m0 n() {
        return this.b;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return this.l;
    }

    public boolean q() {
        return this.k;
    }

    public String toString() {
        return "RewardedVideoConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + '}';
    }
}
