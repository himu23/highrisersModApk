package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        /* renamed from: l */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: do  reason: not valid java name */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    public final String JF;
    public final int JG;
    public final int JH;
    public final long JI;
    private final h[] JJ;
    public final long wE;

    public int describeContents() {
        return 0;
    }

    public c(String str, int i, int i2, long j, long j2, h[] hVarArr) {
        super("CHAP");
        this.JF = str;
        this.JG = i;
        this.JH = i2;
        this.wE = j;
        this.JI = j2;
        this.JJ = hVarArr;
    }

    c(Parcel parcel) {
        super("CHAP");
        this.JF = (String) ai.R(parcel.readString());
        this.JG = parcel.readInt();
        this.JH = parcel.readInt();
        this.wE = parcel.readLong();
        this.JI = parcel.readLong();
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
        c cVar = (c) obj;
        if (this.JG == cVar.JG && this.JH == cVar.JH && this.wE == cVar.wE && this.JI == cVar.JI && ai.r(this.JF, cVar.JF) && Arrays.equals(this.JJ, cVar.JJ)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.JG) * 31) + this.JH) * 31) + ((int) this.wE)) * 31) + ((int) this.JI)) * 31;
        String str = this.JF;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.JF);
        parcel.writeInt(this.JG);
        parcel.writeInt(this.JH);
        parcel.writeLong(this.wE);
        parcel.writeLong(this.JI);
        parcel.writeInt(this.JJ.length);
        for (h writeParcelable : this.JJ) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
