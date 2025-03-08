package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public class c {
    public final g a;
    public final g b;
    public final k c;
    public final a.C0117a[] d;
    public final e e;
    public final r f;
    public final List<i> g;
    public boolean h;
    public byte[] i;
    public IOException j;
    public a.C0117a k;
    public Uri l;
    public byte[] m;
    public String n;
    public byte[] o;
    public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e p;

    public static final class a extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.c {
        public final String l;
        public byte[] m;

        public a(g gVar, j jVar, i iVar, int i, Object obj, byte[] bArr, String str) {
            super(gVar, jVar, 3, iVar, i, obj, bArr);
            this.l = str;
        }
    }

    public static final class b {
        public com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a a;
        public boolean b;
        public a.C0117a c;

        public b() {
            a();
        }

        public void a() {
            this.a = null;
            this.b = false;
            this.c = null;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c$c  reason: collision with other inner class name */
    public static final class C0116c extends com.fyber.inneractive.sdk.player.exoplayer2.trackselection.a {
        public int g;

        public C0116c(r rVar, int[] iArr) {
            super(rVar, iArr);
            this.g = a(rVar.a(0));
        }

        public void a(long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.g, elapsedRealtime)) {
                for (int i = this.b - 1; i >= 0; i--) {
                    if (!b(i, elapsedRealtime)) {
                        this.g = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int d() {
            return 0;
        }

        public int e() {
            return this.g;
        }

        public Object g() {
            return null;
        }
    }

    public c(e eVar, a.C0117a[] aVarArr, d dVar, k kVar, List<i> list) {
        this.e = eVar;
        this.d = aVarArr;
        this.c = kVar;
        this.g = list;
        i[] iVarArr = new i[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            iVarArr[i2] = aVarArr[i2].b;
            iArr[i2] = i2;
        }
        b bVar = (b) dVar;
        this.a = bVar.a(1);
        this.b = bVar.a(3);
        r rVar = new r(iVarArr);
        this.f = rVar;
        this.p = new C0116c(rVar, iArr);
    }

    public final void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(str.toLowerCase(Locale.getDefault()).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.l = uri;
        this.m = bArr;
        this.n = str;
        this.o = bArr2;
    }
}
