package com.applovin.exoplayer2.g.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        /* renamed from: A */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: dF */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    public final boolean KA;
    public final long KB;
    public final int KC;
    public final int KD;
    public final int KE;
    public final long Ks;
    public final boolean Kt;
    public final boolean Ku;
    public final boolean Kv;
    public final boolean Kw;
    public final long Kx;
    public final long Ky;
    public final List<a> Kz;

    private d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.Ks = j;
        this.Kt = z;
        this.Ku = z2;
        this.Kv = z3;
        this.Kw = z4;
        this.Kx = j2;
        this.Ky = j3;
        this.Kz = Collections.unmodifiableList(list);
        this.KA = z5;
        this.KB = j4;
        this.KC = i;
        this.KD = i2;
        this.KE = i3;
    }

    private d(Parcel parcel) {
        this.Ks = parcel.readLong();
        boolean z = false;
        this.Kt = parcel.readByte() == 1;
        this.Ku = parcel.readByte() == 1;
        this.Kv = parcel.readByte() == 1;
        this.Kw = parcel.readByte() == 1;
        this.Kx = parcel.readLong();
        this.Ky = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(a.C(parcel));
        }
        this.Kz = Collections.unmodifiableList(arrayList);
        this.KA = parcel.readByte() == 1 ? true : z;
        this.KB = parcel.readLong();
        this.KC = parcel.readInt();
        this.KD = parcel.readInt();
        this.KE = parcel.readInt();
    }

    static d a(y yVar, long j, ag agVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        long j2;
        boolean z2;
        List list;
        long j3;
        boolean z3;
        boolean z4;
        long j4;
        boolean z5;
        ag agVar2 = agVar;
        long pv = yVar.pv();
        boolean z6 = (yVar.po() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int po = yVar.po();
            boolean z7 = (po & 128) != 0;
            boolean z8 = (po & 64) != 0;
            boolean z9 = (po & 32) != 0;
            boolean z10 = (po & 16) != 0;
            long e = (!z8 || z10) ? -9223372036854775807L : g.e(yVar, j);
            if (!z8) {
                int po2 = yVar.po();
                ArrayList arrayList = new ArrayList(po2);
                for (int i4 = 0; i4 < po2; i4++) {
                    int po3 = yVar.po();
                    long e2 = !z10 ? g.e(yVar, j) : -9223372036854775807L;
                    arrayList.add(new a(po3, e2, agVar2.br(e2)));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long po4 = (long) yVar.po();
                boolean z11 = (128 & po4) != 0;
                j4 = ((((po4 & 1) << 32) | yVar.pv()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j4 = -9223372036854775807L;
            }
            i3 = yVar.pp();
            z = z8;
            i2 = yVar.po();
            i = yVar.po();
            list = emptyList;
            long j5 = e;
            z2 = z5;
            j2 = j4;
            z3 = z10;
            z4 = z7;
            j3 = j5;
        } else {
            list = emptyList;
            z4 = false;
            z3 = false;
            j3 = -9223372036854775807L;
            z2 = false;
            j2 = -9223372036854775807L;
            i3 = 0;
            i2 = 0;
            i = 0;
            z = false;
        }
        return new d(pv, z6, z4, z, z3, j3, agVar2.br(j3), list, z2, j2, i3, i2, i);
    }

    public static final class a {
        public final int KF;
        public final long KG;
        public final long KH;

        private a(int i, long j, long j2) {
            this.KF = i;
            this.KG = j;
            this.KH = j2;
        }

        public void B(Parcel parcel) {
            parcel.writeInt(this.KF);
            parcel.writeLong(this.KG);
            parcel.writeLong(this.KH);
        }

        public static a C(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Ks);
        parcel.writeByte(this.Kt ? (byte) 1 : 0);
        parcel.writeByte(this.Ku ? (byte) 1 : 0);
        parcel.writeByte(this.Kv ? (byte) 1 : 0);
        parcel.writeByte(this.Kw ? (byte) 1 : 0);
        parcel.writeLong(this.Kx);
        parcel.writeLong(this.Ky);
        int size = this.Kz.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.Kz.get(i2).B(parcel);
        }
        parcel.writeByte(this.KA ? (byte) 1 : 0);
        parcel.writeLong(this.KB);
        parcel.writeInt(this.KC);
        parcel.writeInt(this.KD);
        parcel.writeInt(this.KE);
    }
}
