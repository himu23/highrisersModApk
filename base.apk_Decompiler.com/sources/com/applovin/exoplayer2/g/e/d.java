package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class d extends h {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        /* renamed from: m */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: dp */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    private final h[] JJ;
    public final String JK;
    public final boolean JL;
    public final String[] JM;
    public final boolean vd;

    public d(String str, boolean z, boolean z2, String[] strArr, h[] hVarArr) {
        super("CTOC");
        this.JK = str;
        this.JL = z;
        this.vd = z2;
        this.JM = strArr;
        this.JJ = hVarArr;
    }

    d(Parcel parcel) {
        super("CTOC");
        this.JK = (String) ai.R(parcel.readString());
        boolean z = true;
        this.JL = parcel.readByte() != 0;
        this.vd = parcel.readByte() == 0 ? false : z;
        this.JM = (String[]) ai.R(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.JJ = new h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.JJ[i] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.JL != dVar.JL || this.vd != dVar.vd || !ai.r(this.JK, dVar.JK) || !Arrays.equals(this.JM, dVar.JM) || !Arrays.equals(this.JJ, dVar.JJ)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (this.JL ? 1 : 0)) * 31) + (this.vd ? 1 : 0)) * 31;
        String str = this.JK;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.JK);
        parcel.writeByte(this.JL ? (byte) 1 : 0);
        parcel.writeByte(this.vd ? (byte) 1 : 0);
        parcel.writeStringArray(this.JM);
        parcel.writeInt(this.JJ.length);
        for (h writeParcelable : this.JJ) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
