package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements g {
    public final AssetManager a;
    public final a0<? super c> b;
    public Uri c;
    public InputStream d;
    public long e;
    public boolean f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, a0<? super c> a0Var) {
        this.a = context.getAssets();
        this.b = a0Var;
    }

    public long a(j jVar) throws a {
        try {
            Uri uri = jVar.a;
            this.c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream open = this.a.open(path, 1);
            this.d = open;
            if (open.skip(jVar.d) >= jVar.d) {
                long j = jVar.e;
                if (j != -1) {
                    this.e = j;
                } else {
                    long available = (long) this.d.available();
                    this.e = available;
                    if (available == 2147483647L) {
                        this.e = -1;
                    }
                }
                this.f = true;
                a0<? super c> a0Var = this.b;
                if (a0Var != null) {
                    ((l) a0Var).a(this, jVar);
                }
                return this.e;
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
            InputStream inputStream = this.d;
            if (inputStream != null) {
                inputStream.close();
            }
            this.d = null;
            if (this.f) {
                this.f = false;
                a0<? super c> a0Var = this.b;
                if (a0Var != null) {
                    ((l) a0Var).a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.d = null;
            if (this.f) {
                this.f = false;
                a0<? super c> a0Var2 = this.b;
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
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int read = this.d.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.e;
            if (j2 != -1) {
                this.e = j2 - ((long) read);
            }
            a0<? super c> a0Var = this.b;
            if (a0Var != null) {
                l lVar = (l) a0Var;
                synchronized (lVar) {
                    lVar.d += (long) read;
                }
            }
            return read;
        } else if (this.e == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }
}
