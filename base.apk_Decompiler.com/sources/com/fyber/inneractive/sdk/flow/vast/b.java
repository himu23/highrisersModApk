package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

public class b {
    public final UnitDisplayType a;
    public final boolean b;
    public final int c;
    public final int d;
    public final b0 e;

    public b(UnitDisplayType unitDisplayType, boolean z, int i, int i2, b0 b0Var) {
        this.a = unitDisplayType;
        this.b = z;
        this.c = i;
        this.d = i2;
        this.e = b0Var;
    }

    public int a() {
        return this.d;
    }

    public b0 b() {
        return this.e;
    }

    public UnitDisplayType c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return this.b;
    }
}
