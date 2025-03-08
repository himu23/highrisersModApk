package com.applovin.exoplayer2.g.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.v;

public final class a implements a.C0047a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: d */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel.readInt(), (String) com.applovin.exoplayer2.l.a.checkNotNull(parcel.readString()));
        }

        /* renamed from: dg */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final int Ji;
    public final String Jj;

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

    public a(int i, String str) {
        this.Ji = i;
        this.Jj = str;
    }

    public String toString() {
        return "Ait(controlCode=" + this.Ji + ",url=" + this.Jj + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jj);
        parcel.writeInt(this.Ji);
    }
}
