package com.applovin.exoplayer2.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import java.util.Arrays;
import java.util.List;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: c */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: df */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private final C0047a[] IZ;

    /* renamed from: com.applovin.exoplayer2.g.a$a  reason: collision with other inner class name */
    public interface C0047a extends Parcelable {

        /* renamed from: com.applovin.exoplayer2.g.a$a$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$F(C0047a _this, ac.a aVar) {
            }

            public static v $default$kE(C0047a _this) {
                return null;
            }

            public static byte[] $default$kF(C0047a _this) {
                return null;
            }
        }

        void F(ac.a aVar);

        v kE();

        byte[] kF();
    }

    public int describeContents() {
        return 0;
    }

    public a(C0047a... aVarArr) {
        this.IZ = aVarArr;
    }

    public a(List<? extends C0047a> list) {
        this.IZ = (C0047a[]) list.toArray(new C0047a[0]);
    }

    a(Parcel parcel) {
        this.IZ = new C0047a[parcel.readInt()];
        int i = 0;
        while (true) {
            C0047a[] aVarArr = this.IZ;
            if (i < aVarArr.length) {
                aVarArr[i] = (C0047a) parcel.readParcelable(C0047a.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public int kD() {
        return this.IZ.length;
    }

    public C0047a de(int i) {
        return this.IZ[i];
    }

    public a g(a aVar) {
        return aVar == null ? this : b(aVar.IZ);
    }

    public a b(C0047a... aVarArr) {
        if (aVarArr.length == 0) {
            return this;
        }
        return new a((C0047a[]) ai.a((T[]) this.IZ, (T[]) aVarArr));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.IZ, ((a) obj).IZ);
    }

    public int hashCode() {
        return Arrays.hashCode(this.IZ);
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.IZ);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.IZ.length);
        for (C0047a writeParcelable : this.IZ) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
