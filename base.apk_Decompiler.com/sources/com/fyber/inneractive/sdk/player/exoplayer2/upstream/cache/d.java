package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.f;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.h;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class d implements g {
    public final a a;
    public final g b;
    public final g c;
    public final g d;
    public final a e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public g i;
    public boolean j;
    public Uri k;
    public int l;
    public String m;
    public long n;
    public long o;
    public g p;
    public boolean q;
    public boolean r;
    public long s;

    public interface a {
        void a(long j, long j2);
    }

    public d(a aVar, g gVar, g gVar2, f fVar, int i2, a aVar2) {
        this.a = aVar;
        this.b = gVar2;
        boolean z = false;
        this.f = (i2 & 1) != 0;
        this.g = (i2 & 2) != 0;
        this.h = (i2 & 4) != 0 ? true : z;
        this.d = gVar;
        if (fVar != null) {
            this.c = new z(gVar, fVar);
        } else {
            this.c = null;
        }
        this.e = aVar2;
    }

    public long a(j jVar) throws IOException {
        try {
            Uri uri = jVar.a;
            this.k = uri;
            this.l = jVar.g;
            String str = jVar.f;
            if (str == null) {
                str = uri.toString();
            }
            this.m = str;
            this.n = jVar.d;
            boolean z = (this.g && this.q) || (jVar.e == -1 && this.h);
            this.r = z;
            long j2 = jVar.e;
            if (j2 == -1) {
                if (!z) {
                    long a2 = this.a.a(str);
                    this.o = a2;
                    if (a2 != -1) {
                        long j3 = a2 - jVar.d;
                        this.o = j3;
                        if (j3 <= 0) {
                            throw new h(0);
                        }
                    }
                    a(true);
                    return this.o;
                }
            }
            this.o = j2;
            a(true);
            return this.o;
        } catch (IOException e2) {
            a(e2);
            throw e2;
        }
    }

    public void close() throws IOException {
        this.k = null;
        a aVar = this.e;
        if (aVar != null && this.s > 0) {
            aVar.a(this.a.a(), this.s);
            this.s = 0;
        }
        try {
            b();
        } catch (IOException e2) {
            a(e2);
            throw e2;
        }
    }

    public final void b() throws IOException {
        g gVar = this.i;
        if (gVar != null) {
            try {
                gVar.close();
                this.i = null;
                this.j = false;
            } finally {
                g gVar2 = this.p;
                if (gVar2 != null) {
                    this.a.b(gVar2);
                    this.p = null;
                }
            }
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        try {
            int a2 = this.i.a(bArr, i2, i3);
            if (a2 >= 0) {
                if (this.i == this.b) {
                    this.s += (long) a2;
                }
                long j2 = (long) a2;
                this.n += j2;
                long j3 = this.o;
                if (j3 != -1) {
                    this.o = j3 - j2;
                }
            } else {
                if (this.j) {
                    long j4 = this.n;
                    if (this.i == this.c) {
                        this.a.a(this.m, j4);
                    }
                    this.o = 0;
                }
                b();
                long j5 = this.o;
                if ((j5 > 0 || j5 == -1) && a(false)) {
                    return a(bArr, i2, i3);
                }
            }
            return a2;
        } catch (IOException e2) {
            a(e2);
            throw e2;
        }
    }

    public Uri a() {
        g gVar = this.i;
        return gVar == this.d ? gVar.a() : this.k;
    }

    public final boolean a(boolean z) throws IOException {
        g gVar;
        j jVar;
        long j2;
        IOException iOException = null;
        if (this.r) {
            gVar = null;
        } else if (this.f) {
            try {
                gVar = this.a.b(this.m, this.n);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            gVar = this.a.c(this.m, this.n);
        }
        if (gVar == null) {
            this.i = this.d;
            Uri uri = this.k;
            long j3 = this.n;
            jVar = new j(uri, (byte[]) null, j3, j3, this.o, this.m, this.l);
        } else if (gVar.d) {
            Uri fromFile = Uri.fromFile(gVar.e);
            long j4 = this.n - gVar.b;
            long j5 = gVar.c - j4;
            long j6 = this.o;
            if (j6 != -1) {
                j5 = Math.min(j5, j6);
            }
            j jVar2 = new j(fromFile, (byte[]) null, this.n, j4, j5, this.m, this.l);
            this.i = this.b;
            jVar = jVar2;
        } else {
            long j7 = gVar.c;
            if (j7 == -1) {
                j7 = this.o;
            } else {
                long j8 = this.o;
                if (j8 != -1) {
                    j7 = Math.min(j7, j8);
                }
            }
            Uri uri2 = this.k;
            long j9 = this.n;
            jVar = new j(uri2, (byte[]) null, j9, j9, j7, this.m, this.l);
            g gVar2 = this.c;
            if (gVar2 != null) {
                this.i = gVar2;
                this.p = gVar;
            } else {
                this.i = this.d;
                this.a.b(gVar);
            }
        }
        boolean z2 = true;
        this.j = jVar.e == -1;
        try {
            j2 = this.i.a(jVar);
        } catch (IOException e2) {
            if (!z && this.j) {
                Throwable th = e2;
                while (true) {
                    if (th != null) {
                        if ((th instanceof h) && ((h) th).a == 0) {
                            break;
                        }
                        th = th.getCause();
                    } else {
                        break;
                    }
                }
            }
            iOException = e2;
            if (iOException == null) {
                j2 = 0;
                z2 = false;
            } else {
                throw iOException;
            }
        }
        if (this.j && j2 != -1) {
            this.o = j2;
            long j10 = jVar.d + j2;
            if (this.i == this.c) {
                this.a.a(this.m, j10);
            }
        }
        return z2;
    }

    public final void a(IOException iOException) {
        if (this.i == this.b || (iOException instanceof a.C0128a)) {
            this.q = true;
        }
    }
}
