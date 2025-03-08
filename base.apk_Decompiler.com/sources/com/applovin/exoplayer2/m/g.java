package com.applovin.exoplayer2.m;

import android.view.Surface;
import com.applovin.exoplayer2.f.h;
import com.applovin.exoplayer2.f.i;

public class g extends h {
    public final int adJ;
    public final boolean adK;

    public g(Throwable th, i iVar, Surface surface) {
        super(th, iVar);
        this.adJ = System.identityHashCode(surface);
        this.adK = surface == null || surface.isValid();
    }
}
