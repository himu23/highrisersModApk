package com.applovin.exoplayer2.e.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import kotlin.UByte;

final class e {
    private final y uO = new y(8);
    private int yM;

    public boolean a(i iVar) throws IOException {
        long B;
        int i;
        long j = iVar.m1771if();
        long j2 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        int i2 = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i2 != 0 && j <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j2 = j;
        }
        int i3 = (int) j2;
        iVar.c(this.uO.hO(), 0, 4);
        long pv = this.uO.pv();
        this.yM = 4;
        while (pv != 440786851) {
            int i4 = this.yM + 1;
            this.yM = i4;
            if (i4 == i3) {
                return false;
            }
            iVar.c(this.uO.hO(), 0, 1);
            pv = ((pv << 8) & -256) | ((long) (this.uO.hO()[0] & UByte.MAX_VALUE));
        }
        long B2 = B(iVar);
        long j3 = (long) this.yM;
        if (B2 == Long.MIN_VALUE) {
            return false;
        }
        if (i2 != 0 && j3 + B2 >= j) {
            return false;
        }
        while (true) {
            int i5 = this.yM;
            long j4 = j3 + B2;
            if (((long) i5) < j4) {
                if (B(iVar) != Long.MIN_VALUE && B >= 0 && B <= 2147483647L) {
                    if (i != 0) {
                        int B3 = (int) (B = B(iVar));
                        iVar.bI(B3);
                        this.yM += B3;
                    }
                }
            } else if (((long) i5) == j4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private long B(i iVar) throws IOException {
        int i = 0;
        iVar.c(this.uO.hO(), 0, 1);
        byte b = this.uO.hO()[0] & UByte.MAX_VALUE;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (~i2);
        iVar.c(this.uO.hO(), 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.uO.hO()[i] & UByte.MAX_VALUE) + (i4 << 8);
        }
        this.yM += i3 + 1;
        return (long) i4;
    }
}
