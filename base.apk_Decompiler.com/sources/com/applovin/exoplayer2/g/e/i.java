package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() {
        /* renamed from: p */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        /* renamed from: du */
        public i[] newArray(int i) {
            return new i[i];
        }
    };
    public final String JN;
    public final String JU;
    public final String oc;

    public i(String str, String str2, String str3) {
        super("----");
        this.JU = str;
        this.oc = str2;
        this.JN = str3;
    }

    i(Parcel parcel) {
        super("----");
        this.JU = (String) ai.R(parcel.readString());
        this.oc = (String) ai.R(parcel.readString());
        this.JN = (String) ai.R(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!ai.r(this.oc, iVar.oc) || !ai.r(this.JU, iVar.JU) || !ai.r(this.JN, iVar.JN)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.JU;
        int i = 0;
        int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.oc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.JN;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.f5do + ": domain=" + this.JU + ", description=" + this.oc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5do);
        parcel.writeString(this.JU);
        parcel.writeString(this.JN);
    }
}
