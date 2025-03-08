package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.i;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a implements g {
    public final g a;
    public final byte[] b;
    public final byte[] c;
    public CipherInputStream d;

    public a(g gVar, byte[] bArr, byte[] bArr2) {
        this.a = gVar;
        this.b = bArr;
        this.c = bArr2;
    }

    public long a(j jVar) throws IOException {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                this.d = new CipherInputStream(new i(this.a, jVar), instance);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void close() throws IOException {
        this.d = null;
        this.a.close();
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d != null);
        int read = this.d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public Uri a() {
        return this.a.a();
    }
}
