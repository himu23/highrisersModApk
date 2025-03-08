package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.common.b.b;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class d implements a.C0047a {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        /* renamed from: y */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: dD */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    public final float Km;
    public final int Kn;

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

    public d(float f, int i) {
        this.Km = f;
        this.Kn = i;
    }

    private d(Parcel parcel) {
        this.Km = parcel.readFloat();
        this.Kn = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.Km == dVar.Km && this.Kn == dVar.Kn) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + b.n(this.Km)) * 31) + this.Kn;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.Km + ", svcTemporalLayerCount=" + this.Kn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.Km);
        parcel.writeInt(this.Kn);
    }
}
