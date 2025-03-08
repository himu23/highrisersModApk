package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final String b;
    public final String c;
    public final String d;
    public final byte[] e;

    public class a implements Parcelable.Creator<f> {
        public Object createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        public Object[] newArray(int i) {
            return new f[i];
        }
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!u.a((Object) this.b, (Object) fVar.b) || !u.a((Object) this.c, (Object) fVar.c) || !u.a((Object) this.d, (Object) fVar.d) || !Arrays.equals(this.e, fVar.e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.e);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.e);
    }

    public f(Parcel parcel) {
        super("GEOB");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createByteArray();
    }
}
