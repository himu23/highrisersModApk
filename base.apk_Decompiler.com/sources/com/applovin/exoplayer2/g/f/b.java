package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.common.b.d;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class b implements a.C0047a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: v */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: dA */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final long Ke;
    public final long Kf;
    public final long Kg;
    public final long Kh;
    public final long wy;

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

    public b(long j, long j2, long j3, long j4, long j5) {
        this.Ke = j;
        this.Kf = j2;
        this.wy = j3;
        this.Kg = j4;
        this.Kh = j5;
    }

    private b(Parcel parcel) {
        this.Ke = parcel.readLong();
        this.Kf = parcel.readLong();
        this.wy = parcel.readLong();
        this.Kg = parcel.readLong();
        this.Kh = parcel.readLong();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.Ke == bVar.Ke && this.Kf == bVar.Kf && this.wy == bVar.wy && this.Kg == bVar.Kg && this.Kh == bVar.Kh) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + d.ae(this.Ke)) * 31) + d.ae(this.Kf)) * 31) + d.ae(this.wy)) * 31) + d.ae(this.Kg)) * 31) + d.ae(this.Kh);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.Ke + ", photoSize=" + this.Kf + ", photoPresentationTimestampUs=" + this.wy + ", videoStartPosition=" + this.Kg + ", videoSize=" + this.Kh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Ke);
        parcel.writeLong(this.Kf);
        parcel.writeLong(this.wy);
        parcel.writeLong(this.Kg);
        parcel.writeLong(this.Kh);
    }
}
