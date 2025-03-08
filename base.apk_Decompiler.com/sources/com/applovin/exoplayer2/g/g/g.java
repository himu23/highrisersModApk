package com.applovin.exoplayer2.g.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.y;

public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() {
        /* renamed from: J */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: dI */
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    public final long KK;
    public final long KL;

    private g(long j, long j2) {
        this.KK = j;
        this.KL = j2;
    }

    static g b(y yVar, long j, ag agVar) {
        long e = e(yVar, j);
        return new g(e, agVar.br(e));
    }

    static long e(y yVar, long j) {
        long po = (long) yVar.po();
        if ((128 & po) != 0) {
            return 8589934591L & ((((po & 1) << 32) | yVar.pv()) + j);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.KK);
        parcel.writeLong(this.KL);
    }
}
