package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class a implements a.C0047a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: u */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: dz */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final String Jx;
    public final byte[] Kb;
    public final int Kc;
    public final int Kd;

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

    public a(String str, byte[] bArr, int i, int i2) {
        this.Jx = str;
        this.Kb = bArr;
        this.Kc = i;
        this.Kd = i2;
    }

    private a(Parcel parcel) {
        this.Jx = (String) ai.R(parcel.readString());
        this.Kb = (byte[]) ai.R(parcel.createByteArray());
        this.Kc = parcel.readInt();
        this.Kd = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.Jx.equals(aVar.Jx) || !Arrays.equals(this.Kb, aVar.Kb) || this.Kc != aVar.Kc || this.Kd != aVar.Kd) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.Jx.hashCode()) * 31) + Arrays.hashCode(this.Kb)) * 31) + this.Kc) * 31) + this.Kd;
    }

    public String toString() {
        return "mdta: key=" + this.Jx;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jx);
        parcel.writeByteArray(this.Kb);
        parcel.writeInt(this.Kc);
        parcel.writeInt(this.Kd);
    }
}
