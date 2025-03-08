package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.f;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b implements f {
    public final a a;
    public final long b;
    public final int c;
    public j d;
    public File e;
    public OutputStream f;
    public FileOutputStream g;
    public long h;
    public long i;
    public o j;

    public static class a extends a.C0128a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(a aVar, long j2, int i2) {
        this.a = (a) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(aVar);
        this.b = j2;
        this.c = i2;
    }

    public void a(j jVar) throws a {
        if (jVar.e != -1 || jVar.a(2)) {
            this.d = jVar;
            this.i = 0;
            try {
                b();
            } catch (IOException e2) {
                throw new a(e2);
            }
        } else {
            this.d = null;
        }
    }

    public final void b() throws IOException {
        long j2;
        long j3 = this.d.e;
        if (j3 == -1) {
            j2 = this.b;
        } else {
            j2 = Math.min(j3 - this.i, this.b);
        }
        long j4 = j2;
        a aVar = this.a;
        j jVar = this.d;
        this.e = aVar.a(jVar.f, this.i + jVar.c, j4);
        FileOutputStream fileOutputStream = new FileOutputStream(this.e);
        this.g = fileOutputStream;
        if (this.c > 0) {
            o oVar = this.j;
            if (oVar == null) {
                this.j = new o(this.g, this.c);
            } else {
                oVar.a(fileOutputStream);
            }
            this.f = this.j;
        } else {
            this.f = fileOutputStream;
        }
        this.h = 0;
    }

    public void close() throws a {
        if (this.d != null) {
            try {
                a();
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws a {
        if (this.d != null) {
            int i4 = 0;
            while (i4 < i3) {
                try {
                    if (this.h == this.b) {
                        a();
                        b();
                    }
                    int min = (int) Math.min((long) (i3 - i4), this.b - this.h);
                    this.f.write(bArr, i2 + i4, min);
                    i4 += min;
                    long j2 = (long) min;
                    this.h += j2;
                    this.i += j2;
                } catch (IOException e2) {
                    throw new a(e2);
                }
            }
        }
    }

    public final void a() throws IOException {
        OutputStream outputStream = this.f;
        if (outputStream != null) {
            try {
                outputStream.flush();
                this.g.getFD().sync();
                u.a((Closeable) this.f);
                this.f = null;
                File file = this.e;
                this.e = null;
                this.a.a(file);
            } catch (Throwable th) {
                u.a((Closeable) this.f);
                this.f = null;
                File file2 = this.e;
                this.e = null;
                file2.delete();
                throw th;
            }
        }
    }
}
