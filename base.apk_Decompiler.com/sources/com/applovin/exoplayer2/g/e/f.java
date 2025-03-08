package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() {
        /* renamed from: o */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: dr */
        public f[] newArray(int i) {
            return new f[i];
        }
    };
    public final String JO;
    public final String eg;
    public final String oc;
    public final byte[] tf;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.eg = str;
        this.JO = str2;
        this.oc = str3;
        this.tf = bArr;
    }

    f(Parcel parcel) {
        super("GEOB");
        this.eg = (String) ai.R(parcel.readString());
        this.JO = (String) ai.R(parcel.readString());
        this.oc = (String) ai.R(parcel.readString());
        this.tf = (byte[]) ai.R(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!ai.r(this.eg, fVar.eg) || !ai.r(this.JO, fVar.JO) || !ai.r(this.oc, fVar.oc) || !Arrays.equals(this.tf, fVar.tf)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.eg;
        int i = 0;
        int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.JO;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.oc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.tf);
    }

    public String toString() {
        return this.f5do + ": mimeType=" + this.eg + ", filename=" + this.JO + ", description=" + this.oc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eg);
        parcel.writeString(this.JO);
        parcel.writeString(this.oc);
        parcel.writeByteArray(this.tf);
    }
}
