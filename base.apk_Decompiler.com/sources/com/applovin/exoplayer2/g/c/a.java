package com.applovin.exoplayer2.g.c;

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
        /* renamed from: f */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: di */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final int Jt;
    public final int Ju;
    public final int Jv;
    public final byte[] Jw;
    public final int dE;
    public final String eg;
    public final int height;
    public final String oc;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    public a(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.Jt = i;
        this.eg = str;
        this.oc = str2;
        this.dE = i2;
        this.height = i3;
        this.Ju = i4;
        this.Jv = i5;
        this.Jw = bArr;
    }

    a(Parcel parcel) {
        this.Jt = parcel.readInt();
        this.eg = (String) ai.R(parcel.readString());
        this.oc = (String) ai.R(parcel.readString());
        this.dE = parcel.readInt();
        this.height = parcel.readInt();
        this.Ju = parcel.readInt();
        this.Jv = parcel.readInt();
        this.Jw = (byte[]) ai.R(parcel.createByteArray());
    }

    public void F(ac.a aVar) {
        aVar.a(this.Jw, this.Jt);
    }

    public String toString() {
        return "Picture: mimeType=" + this.eg + ", description=" + this.oc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.Jt == aVar.Jt && this.eg.equals(aVar.eg) && this.oc.equals(aVar.oc) && this.dE == aVar.dE && this.height == aVar.height && this.Ju == aVar.Ju && this.Jv == aVar.Jv && Arrays.equals(this.Jw, aVar.Jw)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.Jt) * 31) + this.eg.hashCode()) * 31) + this.oc.hashCode()) * 31) + this.dE) * 31) + this.height) * 31) + this.Ju) * 31) + this.Jv) * 31) + Arrays.hashCode(this.Jw);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Jt);
        parcel.writeString(this.eg);
        parcel.writeString(this.oc);
        parcel.writeInt(this.dE);
        parcel.writeInt(this.height);
        parcel.writeInt(this.Ju);
        parcel.writeInt(this.Jv);
        parcel.writeByteArray(this.Jw);
    }
}
