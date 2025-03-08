package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class m extends h {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() {
        /* renamed from: t */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: dy */
        public m[] newArray(int i) {
            return new m[i];
        }
    };
    public final String Jj;
    public final String oc;

    public m(String str, String str2, String str3) {
        super(str);
        this.oc = str2;
        this.Jj = str3;
    }

    m(Parcel parcel) {
        super((String) ai.R(parcel.readString()));
        this.oc = parcel.readString();
        this.Jj = (String) ai.R(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (!this.f5do.equals(mVar.f5do) || !ai.r(this.oc, mVar.oc) || !ai.r(this.Jj, mVar.Jj)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f5do.hashCode()) * 31;
        String str = this.oc;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Jj;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.f5do + ": url=" + this.Jj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5do);
        parcel.writeString(this.oc);
        parcel.writeString(this.Jj);
    }
}
