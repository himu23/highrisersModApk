package com.applovin.exoplayer2.g.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.v;
import java.util.Arrays;

public final class c implements a.C0047a {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        /* renamed from: i */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: dl */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    public final byte[] JE;
    public final String Jj;
    public final String title;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    public c(byte[] bArr, String str, String str2) {
        this.JE = bArr;
        this.title = str;
        this.Jj = str2;
    }

    c(Parcel parcel) {
        this.JE = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(parcel.createByteArray());
        this.title = parcel.readString();
        this.Jj = parcel.readString();
    }

    public void F(ac.a aVar) {
        String str = this.title;
        if (str != null) {
            aVar.a((CharSequence) str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.JE, ((c) obj).JE);
    }

    public int hashCode() {
        return Arrays.hashCode(this.JE);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.title, this.Jj, Integer.valueOf(this.JE.length)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.JE);
        parcel.writeString(this.title);
        parcel.writeString(this.Jj);
    }
}
