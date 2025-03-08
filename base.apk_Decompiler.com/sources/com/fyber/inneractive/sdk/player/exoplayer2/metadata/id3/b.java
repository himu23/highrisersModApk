package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final byte[] b;

    public class a implements Parcelable.Creator<b> {
        public Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        public Object[] newArray(int i) {
            return new b[i];
        }
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.a.equals(bVar.a) || !Arrays.equals(this.b, bVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Arrays.hashCode(this.b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
    }

    public b(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.createByteArray();
    }
}
