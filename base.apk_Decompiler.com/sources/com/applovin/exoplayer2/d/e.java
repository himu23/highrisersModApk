package com.applovin.exoplayer2.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class e implements Parcelable, Comparator<a> {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() {
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: bD */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    private int dS;
    private final a[] tb;
    public final String tc;
    public final int td;

    public int describeContents() {
        return 0;
    }

    public e(List<a> list) {
        this((String) null, false, (a[]) list.toArray(new a[0]));
    }

    public e(a... aVarArr) {
        this((String) null, aVarArr);
    }

    public e(String str, a... aVarArr) {
        this(str, true, aVarArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.applovin.exoplayer2.d.e$a[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private e(java.lang.String r1, boolean r2, com.applovin.exoplayer2.d.e.a... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.tc = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.applovin.exoplayer2.d.e$a[] r3 = (com.applovin.exoplayer2.d.e.a[]) r3
        L_0x000e:
            r0.tb = r3
            int r1 = r3.length
            r0.td = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.d.e.<init>(java.lang.String, boolean, com.applovin.exoplayer2.d.e$a[]):void");
    }

    e(Parcel parcel) {
        this.tc = parcel.readString();
        a[] aVarArr = (a[]) ai.R((a[]) parcel.createTypedArray(a.CREATOR));
        this.tb = aVarArr;
        this.td = aVarArr.length;
    }

    public a bC(int i) {
        return this.tb[i];
    }

    public e B(String str) {
        if (ai.r(this.tc, str)) {
            return this;
        }
        return new e(str, false, this.tb);
    }

    public int hashCode() {
        if (this.dS == 0) {
            String str = this.tc;
            this.dS = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.tb);
        }
        return this.dS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!ai.r(this.tc, eVar.tc) || !Arrays.equals(this.tb, eVar.tb)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compare(a aVar, a aVar2) {
        if (h.aj.equals(aVar.ey)) {
            return h.aj.equals(aVar2.ey) ? 0 : 1;
        }
        return aVar.ey.compareTo(aVar2.ey);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tc);
        parcel.writeTypedArray(this.tb, 0);
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
            /* renamed from: b */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: bE */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        private int dS;
        public final String eg;
        public final UUID ey;
        public final String te;
        public final byte[] tf;

        public int describeContents() {
            return 0;
        }

        public a(UUID uuid, String str, byte[] bArr) {
            this(uuid, (String) null, str, bArr);
        }

        public a(UUID uuid, String str, String str2, byte[] bArr) {
            this.ey = (UUID) com.applovin.exoplayer2.l.a.checkNotNull(uuid);
            this.te = str;
            this.eg = (String) com.applovin.exoplayer2.l.a.checkNotNull(str2);
            this.tf = bArr;
        }

        a(Parcel parcel) {
            this.ey = new UUID(parcel.readLong(), parcel.readLong());
            this.te = parcel.readString();
            this.eg = (String) ai.R(parcel.readString());
            this.tf = parcel.createByteArray();
        }

        public boolean a(UUID uuid) {
            return h.aj.equals(this.ey) || uuid.equals(this.ey);
        }

        public a o(byte[] bArr) {
            return new a(this.ey, this.te, this.eg, bArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            if (!ai.r(this.te, aVar.te) || !ai.r(this.eg, aVar.eg) || !ai.r(this.ey, aVar.ey) || !Arrays.equals(this.tf, aVar.tf)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            if (this.dS == 0) {
                int hashCode = this.ey.hashCode() * 31;
                String str = this.te;
                if (str == null) {
                    i = 0;
                } else {
                    i = str.hashCode();
                }
                this.dS = ((((hashCode + i) * 31) + this.eg.hashCode()) * 31) + Arrays.hashCode(this.tf);
            }
            return this.dS;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.ey.getMostSignificantBits());
            parcel.writeLong(this.ey.getLeastSignificantBits());
            parcel.writeString(this.te);
            parcel.writeString(this.eg);
            parcel.writeByteArray(this.tf);
        }
    }
}
