package com.fyber.inneractive.sdk.player.exoplayer2;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.b;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.g;
import java.io.IOException;

public abstract class a implements n {
    public final int a;
    public o b;
    public int c;
    public int d;
    public o e;
    public long f;
    public boolean g = true;
    public boolean h;

    public a(int i) {
        this.a = i;
    }

    public final int a() {
        return this.d;
    }

    public final void a(int i) {
        this.c = i;
    }

    public abstract void a(long j, boolean z) throws d;

    public abstract void a(boolean z) throws d;

    public void a(i[] iVarArr) throws d {
    }

    public final void c() {
        this.h = true;
    }

    public final void d() throws d {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d == 2);
        this.d = 1;
        r();
    }

    public final void e() throws IOException {
        this.e.a();
    }

    public final void f() throws d {
        boolean z = true;
        if (this.d != 1) {
            z = false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z);
        this.d = 2;
        q();
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public g j() {
        return null;
    }

    public final int k() {
        return this.a;
    }

    public final void l() {
        boolean z = true;
        if (this.d != 1) {
            z = false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    public final a m() {
        return this;
    }

    public final o n() {
        return this.e;
    }

    public abstract void p();

    public abstract void q() throws d;

    public abstract void r() throws d;

    public final void a(o oVar, i[] iVarArr, o oVar2, long j, boolean z, long j2) throws d {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d == 0);
        this.b = oVar;
        this.d = 1;
        a(z);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.h);
        this.e = oVar2;
        this.g = false;
        this.f = j2;
        a(iVarArr);
        a(j, z);
    }

    public final void a(i[] iVarArr, o oVar, long j) throws d {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.h);
        this.e = oVar;
        this.g = false;
        this.f = j;
        a(iVarArr);
    }

    public final void a(long j) throws d {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    public final int a(j jVar, b bVar, boolean z) {
        int a2 = this.e.a(jVar, bVar, z);
        if (a2 == -4) {
            if (bVar.b(4)) {
                this.g = true;
                if (this.h) {
                    return -4;
                }
                return -3;
            }
            bVar.d += this.f;
        } else if (a2 == -5) {
            i iVar = jVar.a;
            long j = iVar.w;
            if (j != Long.MAX_VALUE) {
                jVar.a = iVar.a(j + this.f);
            }
        }
        return a2;
    }
}
