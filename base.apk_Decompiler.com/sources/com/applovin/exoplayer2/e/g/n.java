package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.google.android.gms.drive.DriveFile;

final class n {
    public final k AG;
    public final long[] Bq;
    public final long fH;
    public final int jA;
    public final int[] tR;
    public final long[] tS;
    public final int zH;
    public final int[] zJ;

    public n(k kVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z = false;
        a.checkArgument(iArr.length == jArr2.length);
        a.checkArgument(jArr.length == jArr2.length);
        a.checkArgument(iArr2.length == jArr2.length ? true : z);
        this.AG = kVar;
        this.tS = jArr;
        this.tR = iArr;
        this.zH = i;
        this.Bq = jArr2;
        this.zJ = iArr2;
        this.fH = j;
        this.jA = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | DriveFile.MODE_WRITE_ONLY;
        }
    }

    public int aA(long j) {
        for (int a = ai.a(this.Bq, j, true, false); a >= 0; a--) {
            if ((this.zJ[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int aB(long j) {
        for (int b = ai.b(this.Bq, j, true, false); b < this.Bq.length; b++) {
            if ((this.zJ[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
