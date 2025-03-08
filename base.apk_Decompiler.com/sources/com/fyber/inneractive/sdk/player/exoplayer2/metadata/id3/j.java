package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new a();
    public final String b;
    public final String c;

    public class a implements Parcelable.Creator<j> {
        public Object createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        public Object[] newArray(int i) {
            return new j[i];
        }
    }

    public j(String str, String str2, String str3) {
        super(str);
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.a.equals(jVar.a) || !u.a((Object) this.b, (Object) jVar.b) || !u.a((Object) this.c, (Object) jVar.c)) {
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

    public j(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
