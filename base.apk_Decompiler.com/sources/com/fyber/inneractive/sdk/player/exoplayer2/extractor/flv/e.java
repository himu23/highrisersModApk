package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.video.a;
import com.unity3d.services.core.device.MimeTypes;

public final class e extends d {
    public final k b = new k(i.a);
    public final k c = new k(4);
    public int d;
    public boolean e;
    public int f;

    public e(n nVar) {
        super(nVar);
    }

    public boolean a(k kVar) throws d.a {
        int l = kVar.l();
        int i = (l >> 4) & 15;
        int i2 = l & 15;
        if (i2 == 7) {
            this.f = i;
            return i != 5;
        }
        throw new d.a("Video format not supported: " + i2);
    }

    public void b(k kVar, long j) throws l {
        int l = kVar.l();
        long n = j + (((long) kVar.n()) * 1000);
        if (l == 0 && !this.e) {
            k kVar2 = new k(new byte[kVar.a()]);
            kVar.a(kVar2.a, 0, kVar.a());
            a b2 = a.b(kVar2);
            this.d = b2.b;
            this.a.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, MimeTypes.VIDEO_H264, (String) null, -1, -1, b2.c, b2.d, -1.0f, b2.a, -1, b2.e, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
            this.e = true;
        } else if (l == 1 && this.e) {
            byte[] bArr = this.c.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (kVar.a() > 0) {
                kVar.a(this.c.a, i, this.d);
                this.c.e(0);
                int o = this.c.o();
                this.b.e(0);
                this.a.a(this.b, 4);
                this.a.a(kVar, o);
                i2 = i2 + 4 + o;
            }
            this.a.a(n, this.f == 1 ? 1 : 0, i2, 0, (byte[]) null);
        }
    }
}
