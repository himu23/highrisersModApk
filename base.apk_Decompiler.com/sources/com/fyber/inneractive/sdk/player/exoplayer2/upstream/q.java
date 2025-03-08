package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class q implements g {
    public final a0<? super q> a;
    public RandomAccessFile b;
    public Uri c;
    public long d;
    public boolean e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public q(a0<? super q> a0Var) {
        this.a = a0Var;
    }

    public long a(j jVar) throws a {
        try {
            this.c = jVar.a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(jVar.a.getPath(), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            this.b = randomAccessFile;
            randomAccessFile.seek(jVar.d);
            long j = jVar.e;
            if (j == -1) {
                j = this.b.length() - jVar.d;
            }
            this.d = j;
            if (j >= 0) {
                this.e = true;
                a0<? super q> a0Var = this.a;
                if (a0Var != null) {
                    ((l) a0Var).a(this, jVar);
                }
                return this.d;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public Uri a() {
        return this.c;
    }

    public void close() throws a {
        this.c = null;
        try {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.b = null;
            if (this.e) {
                this.e = false;
                a0<? super q> a0Var = this.a;
                if (a0Var != null) {
                    ((l) a0Var).a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.b = null;
            if (this.e) {
                this.e = false;
                a0<? super q> a0Var2 = this.a;
                if (a0Var2 != null) {
                    ((l) a0Var2).a(this);
                }
            }
            throw th;
        }
    }

    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.b.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                long j2 = (long) read;
                this.d -= j2;
                a0<? super q> a0Var = this.a;
                if (a0Var != null) {
                    l lVar = (l) a0Var;
                    synchronized (lVar) {
                        lVar.d += j2;
                    }
                }
            }
            return read;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }
}
