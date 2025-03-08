package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() {
        /* renamed from: r */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* renamed from: dw */
        public k[] newArray(int i) {
            return new k[i];
        }
    };
    public final byte[] Ka;
    public final String owner;

    public k(String str, byte[] bArr) {
        super("PRIV");
        this.owner = str;
        this.Ka = bArr;
    }

    k(Parcel parcel) {
        super("PRIV");
        this.owner = (String) ai.R(parcel.readString());
        this.Ka = (byte[]) ai.R(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (!ai.r(this.owner, kVar.owner) || !Arrays.equals(this.Ka, kVar.Ka)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.owner;
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.Ka);
    }

    public String toString() {
        return this.f5do + ": owner=" + this.owner;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.Ka);
    }
}
