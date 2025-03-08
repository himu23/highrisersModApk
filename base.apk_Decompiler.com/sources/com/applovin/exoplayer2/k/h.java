package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.net.URLDecoder;

public final class h extends e {
    private int Nd;
    private int Zt;
    private byte[] tf;
    private l tw;

    public h() {
        super(false);
    }

    public long a(l lVar) throws IOException {
        b(lVar);
        this.tw = lVar;
        Uri uri = lVar.ef;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        a.checkArgument(equals, "Unsupported scheme: " + scheme);
        String[] l = ai.l(uri.getSchemeSpecificPart(), ",");
        if (l.length == 2) {
            String str = l[1];
            if (l[0].contains(";base64")) {
                try {
                    this.tf = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw com.applovin.exoplayer2.ai.b("Error while parsing Base64 encoded string: " + str, e);
                }
            } else {
                this.tf = ai.bk(URLDecoder.decode(str, Charsets.US_ASCII.name()));
            }
            if (lVar.uc <= ((long) this.tf.length)) {
                int i = (int) lVar.uc;
                this.Nd = i;
                this.Zt = this.tf.length - i;
                if (lVar.wC != -1) {
                    this.Zt = (int) Math.min((long) this.Zt, lVar.wC);
                }
                c(lVar);
                return lVar.wC != -1 ? lVar.wC : (long) this.Zt;
            }
            this.tf = null;
            throw new j(2008);
        }
        throw com.applovin.exoplayer2.ai.b("Unexpected URI format: " + uri, (Throwable) null);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.Zt;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(ai.R(this.tf), this.Nd, bArr, i, min);
        this.Nd += min;
        this.Zt -= min;
        fe(min);
        return min;
    }

    public Uri getUri() {
        l lVar = this.tw;
        if (lVar != null) {
            return lVar.ef;
        }
        return null;
    }

    public void close() {
        if (this.tf != null) {
            this.tf = null;
            oe();
        }
        this.tw = null;
    }
}
