package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: k */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: dn */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final byte[] tf;

    public b(String str, byte[] bArr) {
        super(str);
        this.tf = bArr;
    }

    b(Parcel parcel) {
        super((String) ai.R(parcel.readString()));
        this.tf = (byte[]) ai.R(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f5do.equals(bVar.f5do) || !Arrays.equals(this.tf, bVar.tf)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f5do.hashCode()) * 31) + Arrays.hashCode(this.tf);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5do);
        parcel.writeByteArray(this.tf);
    }
}
