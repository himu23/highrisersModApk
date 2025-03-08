package com.fyber.inneractive.sdk.player.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class a implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0113a();
    public final b[] a;
    public int b;
    public final int c;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.drm.a$a  reason: collision with other inner class name */
    public class C0113a implements Parcelable.Creator<a> {
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        public Object[] newArray(int i) {
            return new a[i];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new C0114a();
        public int a;
        public final UUID b;
        public final String c;
        public final byte[] d;
        public final boolean e;

        /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b$a  reason: collision with other inner class name */
        public class C0114a implements Parcelable.Creator<b> {
            public Object createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            public Object[] newArray(int i) {
                return new b[i];
            }
        }

        public b(UUID uuid, String str, byte[] bArr, boolean z) {
            this.b = (UUID) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(uuid);
            this.c = (String) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(str);
            this.d = (byte[]) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(bArr);
            this.e = z;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            if (!this.c.equals(bVar.c) || !u.a((Object) this.b, (Object) bVar.b) || !Arrays.equals(this.d, bVar.d)) {
                return false;
            }
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.b.getMostSignificantBits());
            parcel.writeLong(this.b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeByteArray(this.d);
            parcel.writeByte(this.e ? (byte) 1 : 0);
        }

        public int hashCode() {
            if (this.a == 0) {
                this.a = (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d);
            }
            return this.a;
        }

        public b(Parcel parcel) {
            this.b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            this.d = parcel.createByteArray();
            this.e = parcel.readByte() != 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(boolean r4, com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b... r5) {
        /*
            r3 = this;
            r3.<init>()
            if (r4 == 0) goto L_0x000c
            java.lang.Object r4 = r5.clone()
            r5 = r4
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[] r5 = (com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[]) r5
        L_0x000c:
            java.util.Arrays.sort(r5, r3)
            r4 = 1
        L_0x0010:
            int r0 = r5.length
            if (r4 >= r0) goto L_0x0044
            int r0 = r4 + -1
            r0 = r5[r0]
            java.util.UUID r0 = r0.b
            r1 = r5[r4]
            java.util.UUID r1 = r1.b
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r4 = r4 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Duplicate data for uuid: "
            r1.<init>(r2)
            r4 = r5[r4]
            java.util.UUID r4 = r4.b
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0044:
            r3.a = r5
            int r4 = r5.length
            r3.c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.drm.a.<init>(boolean, com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[]):void");
    }

    public int compare(Object obj, Object obj2) {
        b bVar = (b) obj;
        b bVar2 = (b) obj2;
        UUID uuid = com.fyber.inneractive.sdk.player.exoplayer2.b.b;
        if (uuid.equals(bVar.b)) {
            return uuid.equals(bVar2.b) ? 0 : 1;
        }
        return bVar.b.compareTo(bVar2.b);
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

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, 0);
    }

    public int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.a);
        }
        return this.b;
    }

    public a(Parcel parcel) {
        b[] bVarArr = (b[]) parcel.createTypedArray(b.CREATOR);
        this.a = bVarArr;
        this.c = bVarArr.length;
    }
}
