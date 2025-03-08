package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class c implements a.C0047a {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        /* renamed from: w */
        public c createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, a.class.getClassLoader());
            return new c(arrayList);
        }

        /* renamed from: dB */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    public final List<a> Ki;

    public /* synthetic */ void F(ac.a aVar) {
        a.C0047a.CC.$default$F(this, aVar);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
            /* renamed from: x */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            /* renamed from: dC */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        public static final Comparator<a> Kj = new c$a$$ExternalSyntheticLambda0();
        public final long Kk;
        public final int Kl;
        public final long sC;

        public int describeContents() {
            return 0;
        }

        public a(long j, long j2, int i) {
            com.applovin.exoplayer2.l.a.checkArgument(j < j2);
            this.sC = j;
            this.Kk = j2;
            this.Kl = i;
        }

        public String toString() {
            return ai.a("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.sC), Long.valueOf(this.Kk), Integer.valueOf(this.Kl));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.sC == aVar.sC && this.Kk == aVar.Kk && this.Kl == aVar.Kl) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.sC), Long.valueOf(this.Kk), Integer.valueOf(this.Kl));
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.sC);
            parcel.writeLong(this.Kk);
            parcel.writeInt(this.Kl);
        }
    }

    public c(List<a> list) {
        this.Ki = list;
        com.applovin.exoplayer2.l.a.checkArgument(!j(list));
    }

    public String toString() {
        return "SlowMotion: segments=" + this.Ki;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.Ki.equals(((c) obj).Ki);
    }

    public int hashCode() {
        return this.Ki.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.Ki);
    }

    private static boolean j(List<a> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j = list.get(0).Kk;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).sC < j) {
                return true;
            }
            j = list.get(i).Kk;
        }
        return false;
    }
}
