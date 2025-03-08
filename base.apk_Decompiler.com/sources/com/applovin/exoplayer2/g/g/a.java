package com.applovin.exoplayer2.g.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;

public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: z */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: dE */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final long Ko;
    public final long Kp;
    public final byte[] Kq;

    private a(long j, byte[] bArr, long j2) {
        this.Ko = j2;
        this.Kp = j;
        this.Kq = bArr;
    }

    private a(Parcel parcel) {
        this.Ko = parcel.readLong();
        this.Kp = parcel.readLong();
        this.Kq = (byte[]) ai.R(parcel.createByteArray());
    }

    static a a(y yVar, int i, long j) {
        long pv = yVar.pv();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        return new a(pv, bArr, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Ko);
        parcel.writeLong(this.Kp);
        parcel.writeByteArray(this.Kq);
    }
}
