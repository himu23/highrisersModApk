package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new a();
    public final String b;
    public final String c;

    public class a implements Parcelable.Creator<k> {
        public Object createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        public Object[] newArray(int i) {
            return new k[i];
        }
    }

    public k(String str, String str2, String str3) {
        super(str);
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.a.equals(kVar.a) || !u.a((Object) this.b, (Object) kVar.b) || !u.a((Object) this.c, (Object) kVar.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public k(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
