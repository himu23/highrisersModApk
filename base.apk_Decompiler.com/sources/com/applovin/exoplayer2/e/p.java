package com.applovin.exoplayer2.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.c.b;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.v;
import com.google.android.gms.games.GamesStatusCodes;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public final class p {
    public final int dM;
    private final com.applovin.exoplayer2.g.a dx;
    public final int mI;
    public final int uB;
    public final int uC;
    public final int uD;
    public final int uE;
    public final int uF;
    public final int uG;
    public final int uH;
    public final long uI;
    public final a uJ;

    private static int bN(int i) {
        switch (i) {
            case GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static int bO(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    public static class a {
        public final long[] uK;
        public final long[] uL;

        public a(long[] jArr, long[] jArr2) {
            this.uK = jArr;
            this.uL = jArr2;
        }
    }

    public p(byte[] bArr, int i) {
        x xVar = new x(bArr);
        xVar.fx(i * 8);
        this.uB = xVar.bQ(16);
        this.uC = xVar.bQ(16);
        this.uD = xVar.bQ(24);
        this.uE = xVar.bQ(24);
        int bQ = xVar.bQ(20);
        this.dM = bQ;
        this.uF = bN(bQ);
        this.mI = xVar.bQ(3) + 1;
        int bQ2 = xVar.bQ(5) + 1;
        this.uG = bQ2;
        this.uH = bO(bQ2);
        this.uI = xVar.fy(36);
        this.uJ = null;
        this.dx = null;
    }

    private p(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, a aVar, com.applovin.exoplayer2.g.a aVar2) {
        this.uB = i;
        this.uC = i2;
        this.uD = i3;
        this.uE = i4;
        this.dM = i5;
        this.uF = bN(i5);
        this.mI = i6;
        this.uG = i7;
        this.uH = bO(i7);
        this.uI = j;
        this.uJ = aVar;
        this.dx = aVar2;
    }

    public long dd() {
        long j = this.uI;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.dM);
    }

    public long an(long j) {
        return ai.b((j * ((long) this.dM)) / 1000000, 0, this.uI - 1);
    }

    public long ii() {
        long j;
        long j2;
        int i = this.uE;
        if (i > 0) {
            j = (((long) i) + ((long) this.uD)) / 2;
            j2 = 1;
        } else {
            int i2 = this.uB;
            j = ((((i2 != this.uC || i2 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : (long) i2) * ((long) this.mI)) * ((long) this.uG)) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public v a(byte[] bArr, com.applovin.exoplayer2.g.a aVar) {
        bArr[4] = ByteCompanionObject.MIN_VALUE;
        int i = this.uE;
        if (i <= 0) {
            i = -1;
        }
        return new v.a().m("audio/flac").I(i).N(this.mI).O(this.dM).c((List<byte[]>) Collections.singletonList(bArr)).b(d(aVar)).bT();
    }

    public com.applovin.exoplayer2.g.a d(com.applovin.exoplayer2.g.a aVar) {
        com.applovin.exoplayer2.g.a aVar2 = this.dx;
        return aVar2 == null ? aVar : aVar2.g(aVar);
    }

    public p a(a aVar) {
        return new p(this.uB, this.uC, this.uD, this.uE, this.dM, this.mI, this.uG, this.uI, aVar, this.dx);
    }

    public p g(List<String> list) {
        return new p(this.uB, this.uC, this.uD, this.uE, this.dM, this.mI, this.uG, this.uI, this.uJ, d(a(list, (List<com.applovin.exoplayer2.g.c.a>) Collections.emptyList())));
    }

    public p h(List<com.applovin.exoplayer2.g.c.a> list) {
        return new p(this.uB, this.uC, this.uD, this.uE, this.dM, this.mI, this.uG, this.uI, this.uJ, d(a((List<String>) Collections.emptyList(), list)));
    }

    private static com.applovin.exoplayer2.g.a a(List<String> list, List<com.applovin.exoplayer2.g.c.a> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] m = ai.m(str, m2.i.b);
            if (m.length != 2) {
                q.h("FlacStreamMetadata", "Failed to parse Vorbis comment: " + str);
            } else {
                arrayList.add(new b(m[0], m[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.applovin.exoplayer2.g.a((List<? extends a.C0047a>) arrayList);
    }
}
