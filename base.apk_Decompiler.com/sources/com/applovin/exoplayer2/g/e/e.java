package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() {
        /* renamed from: n */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: dq */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    public final String JN;
    public final String dq;
    public final String oc;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.dq = str;
        this.oc = str2;
        this.JN = str3;
    }

    e(Parcel parcel) {
        super("COMM");
        this.dq = (String) ai.R(parcel.readString());
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
        e eVar = (e) obj;
        if (!ai.r(this.oc, eVar.oc) || !ai.r(this.dq, eVar.dq) || !ai.r(this.JN, eVar.JN)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dq;
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
        return this.f5do + ": language=" + this.dq + ", description=" + this.oc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5do);
        parcel.writeString(this.dq);
        parcel.writeString(this.JN);
    }
}
