package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: j */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: dm */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final int Jt;
    public final byte[] Jw;
    public final String eg;
    public final String oc;

    public a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.eg = str;
        this.oc = str2;
        this.Jt = i;
        this.Jw = bArr;
    }

    a(Parcel parcel) {
        super("APIC");
        this.eg = (String) ai.R(parcel.readString());
        this.oc = parcel.readString();
        this.Jt = parcel.readInt();
        this.Jw = (byte[]) ai.R(parcel.createByteArray());
    }

    public void F(ac.a aVar) {
        aVar.a(this.Jw, this.Jt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.Jt != aVar.Jt || !ai.r(this.eg, aVar.eg) || !ai.r(this.oc, aVar.oc) || !Arrays.equals(this.Jw, aVar.Jw)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.Jt) * 31;
        String str = this.eg;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.oc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.Jw);
    }

    public String toString() {
        return this.f5do + ": mimeType=" + this.eg + ", description=" + this.oc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eg);
        parcel.writeString(this.oc);
        parcel.writeInt(this.Jt);
        parcel.writeByteArray(this.Jw);
    }
}
