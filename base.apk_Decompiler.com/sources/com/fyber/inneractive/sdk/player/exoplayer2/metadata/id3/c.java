package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new a();
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final h[] g;

    public class a implements Parcelable.Creator<c> {
        public Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        public Object[] newArray(int i) {
            return new c[i];
        }
    }

    public c(String str, int i, int i2, long j, long j2, h[] hVarArr) {
        super("CHAP");
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = hVarArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && u.a((Object) this.b, (Object) cVar.b) && Arrays.equals(this.g, cVar.g)) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g.length);
        for (h writeParcelable : this.g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public int hashCode() {
        int i = (((((((this.c + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.d) * 31) + ((int) this.e)) * 31) + ((int) this.f)) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    public c(Parcel parcel) {
        super("CHAP");
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        int readInt = parcel.readInt();
        this.g = new h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.g[i] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
