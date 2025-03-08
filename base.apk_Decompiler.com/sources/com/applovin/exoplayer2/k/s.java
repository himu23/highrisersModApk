package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.applovin.exoplayer2.l.ai;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class s extends e {
    private long Zj;
    private boolean Zk;
    private RandomAccessFile aaI;
    private Uri ef;

    public Uri getUri() {
        return this.ef;
    }

    public static class b extends j {
        public b(Throwable th, int i) {
            super(th, i);
        }

        public b(String str, Throwable th, int i) {
            super(str, th, i);
        }
    }

    public s() {
        super(false);
    }

    public long a(l lVar) throws b {
        Uri uri = lVar.ef;
        this.ef = uri;
        b(lVar);
        RandomAccessFile f = f(uri);
        this.aaI = f;
        try {
            f.seek(lVar.uc);
            long length = lVar.wC == -1 ? this.aaI.length() - lVar.uc : lVar.wC;
            this.Zj = length;
            if (length >= 0) {
                this.Zk = true;
                c(lVar);
                return this.Zj;
            }
            throw new b((String) null, (Throwable) null, 2008);
        } catch (IOException e) {
            throw new b(e, 2000);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws b {
        if (i2 == 0) {
            return 0;
        }
        if (this.Zj == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) ai.R(this.aaI)).read(bArr, i, (int) Math.min(this.Zj, (long) i2));
            if (read > 0) {
                this.Zj -= (long) read;
                fe(read);
            }
            return read;
        } catch (IOException e) {
            throw new b(e, 2000);
        }
    }

    public void close() throws b {
        this.ef = null;
        try {
            RandomAccessFile randomAccessFile = this.aaI;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.aaI = null;
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
        } catch (IOException e) {
            throw new b(e, 2000);
        } catch (Throwable th) {
            this.aaI = null;
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
            throw th;
        }
    }

    private static RandomAccessFile f(Uri uri) throws b {
        int i = 2006;
        try {
            return new RandomAccessFile((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath()), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        } catch (FileNotFoundException e) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e, 1004);
            }
            if (ai.acV < 21 || !a.i(e.getCause())) {
                i = 2005;
            }
            throw new b(e, i);
        } catch (SecurityException e2) {
            throw new b(e2, 2006);
        } catch (RuntimeException e3) {
            throw new b(e3, 2000);
        }
    }

    private static final class a {
        /* access modifiers changed from: private */
        public static boolean i(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }
}
