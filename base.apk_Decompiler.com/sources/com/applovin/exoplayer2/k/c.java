package com.applovin.exoplayer2.k;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.applovin.exoplayer2.l.ai;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c extends e {
    private final AssetManager Zh;
    private InputStream Zi;
    private long Zj;
    private boolean Zk;
    private Uri ef;

    public Uri getUri() {
        return this.ef;
    }

    public static final class a extends j {
        public a(Throwable th, int i) {
            super(th, i);
        }
    }

    public c(Context context) {
        super(false);
        this.Zh = context.getAssets();
    }

    public long a(l lVar) throws a {
        try {
            Uri uri = lVar.ef;
            this.ef = uri;
            String str = (String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            b(lVar);
            InputStream open = this.Zh.open(str, 1);
            this.Zi = open;
            if (open.skip(lVar.uc) >= lVar.uc) {
                if (lVar.wC != -1) {
                    this.Zj = lVar.wC;
                } else {
                    long available = (long) this.Zi.available();
                    this.Zj = available;
                    if (available == 2147483647L) {
                        this.Zj = -1;
                    }
                }
                this.Zk = true;
                c(lVar);
                return this.Zj;
            }
            throw new a((Throwable) null, 2008);
        } catch (a e) {
            throw e;
        } catch (IOException e2) {
            throw new a(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Zj;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        }
        int read = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.Zj;
        if (j2 != -1) {
            this.Zj = j2 - ((long) read);
        }
        fe(read);
        return read;
    }

    public void close() throws a {
        this.ef = null;
        try {
            InputStream inputStream = this.Zi;
            if (inputStream != null) {
                inputStream.close();
            }
            this.Zi = null;
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
        } catch (IOException e) {
            throw new a(e, 2000);
        } catch (Throwable th) {
            this.Zi = null;
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
            throw th;
        }
    }
}
