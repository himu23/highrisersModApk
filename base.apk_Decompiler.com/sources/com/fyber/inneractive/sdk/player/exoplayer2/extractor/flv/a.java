package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.c;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.Collections;
import java.util.List;

public final class a extends d {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public a(n nVar) {
        super(nVar);
    }

    public boolean a(k kVar) throws d.a {
        if (!this.b) {
            int l = kVar.l();
            int i = (l >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.a(i.a((String) null, "audio/mpeg", (String) null, -1, -1, 1, e[(l >> 2) & 3], -1, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.a(i.a((String) null, i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, (int) GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY, (l & 1) == 1 ? 2 : 3, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
                this.c = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.d);
            }
            this.b = true;
        } else {
            kVar.f(1);
        }
        return true;
    }

    public void b(k kVar, long j) {
        k kVar2 = kVar;
        if (this.d == 2) {
            int a = kVar.a();
            this.a.a(kVar2, a);
            this.a.a(j, 1, a, 0, (byte[]) null);
            return;
        }
        int l = kVar.l();
        if (l == 0 && !this.c) {
            int a2 = kVar.a();
            byte[] bArr = new byte[a2];
            System.arraycopy(kVar2.a, kVar2.b, bArr, 0, a2);
            kVar2.b += a2;
            Pair<Integer, Integer> a3 = c.a(bArr);
            this.a.a(i.a((String) null, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), -1, (List<byte[]>) Collections.singletonList(bArr), (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
            this.c = true;
        } else if (this.d != 10 || l == 1) {
            int a4 = kVar.a();
            this.a.a(kVar2, a4);
            this.a.a(j, 1, a4, 0, (byte[]) null);
        }
    }
}
