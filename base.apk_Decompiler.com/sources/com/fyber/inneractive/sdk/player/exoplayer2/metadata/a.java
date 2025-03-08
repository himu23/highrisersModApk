package com.fyber.inneractive.sdk.player.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0124a();
    public final b[] a;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.metadata.a$a  reason: collision with other inner class name */
    public class C0124a implements Parcelable.Creator<a> {
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        public Object[] newArray(int i) {
            return new a[0];
        }
    }

    public interface b extends Parcelable {
    }

    public a(List<? extends b> list) {
        b[] bVarArr = new b[list.size()];
        this.a = bVarArr;
        list.toArray(bVarArr);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((a) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (b writeParcelable : this.a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public a(Parcel parcel) {
        this.a = new b[parcel.readInt()];
        int i = 0;
        while (true) {
            b[] bVarArr = this.a;
            if (i < bVarArr.length) {
                bVarArr[i] = (b) parcel.readParcelable(b.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }
}
