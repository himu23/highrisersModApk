package com.fyber.inneractive.sdk.player.exoplayer2;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.fyber.inneractive.sdk.player.exoplayer2.video.b;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();
    public int A;
    public final String a;
    public final int b;
    public final String c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.a d;
    public final String e;
    public final String f;
    public final int g;
    public final List<byte[]> h;
    public final com.fyber.inneractive.sdk.player.exoplayer2.drm.a i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final b q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    public class a implements Parcelable.Creator<i> {
        public Object createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        public Object[] newArray(int i) {
            return new i[i];
        }
    }

    public i(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, b bVar, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar, com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar2) {
        this.a = str;
        this.e = str2;
        this.f = str3;
        this.c = str4;
        this.b = i2;
        this.g = i3;
        this.j = i4;
        this.k = i5;
        this.l = f2;
        this.m = i6;
        this.n = f3;
        this.p = bArr;
        this.o = i7;
        this.q = bVar;
        this.r = i8;
        this.s = i9;
        this.t = i10;
        this.u = i11;
        this.v = i12;
        this.x = i13;
        this.y = str5;
        this.z = i14;
        this.w = j2;
        this.h = list == null ? Collections.emptyList() : list;
        this.i = aVar;
        this.d = aVar2;
    }

    public static i a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar) {
        return a(str, str2, (String) null, i2, i3, i4, i5, f2, list, i6, f3, (byte[]) null, -1, (b) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null);
    }

    public int b() {
        int i2;
        int i3 = this.j;
        if (i3 == -1 || (i2 = this.k) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.b == iVar.b && this.g == iVar.g && this.j == iVar.j && this.k == iVar.k && this.l == iVar.l && this.m == iVar.m && this.n == iVar.n && this.o == iVar.o && this.r == iVar.r && this.s == iVar.s && this.t == iVar.t && this.u == iVar.u && this.v == iVar.v && this.w == iVar.w && this.x == iVar.x && u.a((Object) this.a, (Object) iVar.a) && u.a((Object) this.y, (Object) iVar.y) && this.z == iVar.z && u.a((Object) this.e, (Object) iVar.e) && u.a((Object) this.f, (Object) iVar.f) && u.a((Object) this.c, (Object) iVar.c) && u.a((Object) this.i, (Object) iVar.i) && u.a((Object) this.d, (Object) iVar.d) && u.a((Object) this.q, (Object) iVar.q) && Arrays.equals(this.p, iVar.p) && this.h.size() == iVar.h.size()) {
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    if (!Arrays.equals(this.h.get(i2), iVar.h.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Format(" + this.a + ", " + this.e + ", " + this.f + ", " + this.b + ", " + this.y + ", [" + this.j + ", " + this.k + ", " + this.l + "], [" + this.r + ", " + this.s + "])";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.c);
        parcel.writeInt(this.b);
        parcel.writeInt(this.g);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p != null ? 1 : 0);
        byte[] bArr = this.p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.o);
        parcel.writeParcelable(this.q, i2);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.w);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.h.get(i3));
        }
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.d, 0);
    }

    public static i a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, b bVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar) {
        return new i(str, (String) null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, bVar, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, aVar, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public static i a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar, int i7, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, aVar, i7, str4, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.A == 0) {
            String str = this.a;
            int i7 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
            String str2 = this.e;
            if (str2 == null) {
                i2 = 0;
            } else {
                i2 = str2.hashCode();
            }
            int i8 = (hashCode + i2) * 31;
            String str3 = this.f;
            if (str3 == null) {
                i3 = 0;
            } else {
                i3 = str3.hashCode();
            }
            int i9 = (i8 + i3) * 31;
            String str4 = this.c;
            if (str4 == null) {
                i4 = 0;
            } else {
                i4 = str4.hashCode();
            }
            int i10 = (((((((((((i9 + i4) * 31) + this.b) * 31) + this.j) * 31) + this.k) * 31) + this.r) * 31) + this.s) * 31;
            String str5 = this.y;
            if (str5 == null) {
                i5 = 0;
            } else {
                i5 = str5.hashCode();
            }
            int i11 = (((i10 + i5) * 31) + this.z) * 31;
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar = this.i;
            if (aVar == null) {
                i6 = 0;
            } else {
                i6 = aVar.hashCode();
            }
            int i12 = (i11 + i6) * 31;
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar2 = this.d;
            if (aVar2 != null) {
                i7 = Arrays.hashCode(aVar2.a);
            }
            this.A = i12 + i7;
        }
        return this.A;
    }

    public static i a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar, int i9, String str4, com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar2) {
        return new i(str, (String) null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, i4, i5, i6, i7, i8, i9, str4, -1, Long.MAX_VALUE, list, aVar, aVar2);
    }

    public static i a(String str, String str2, String str3, String str4, int i2, int i3, String str5, int i4) {
        return new i(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i3, str5, i4, Long.MAX_VALUE, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public static i a(String str, String str2, String str3, int i2, int i3, String str4, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar) {
        return a(str, str2, (String) null, i2, i3, str4, -1, aVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static i a(String str, String str2, String str3, int i2, int i3, String str4, int i4, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar, long j2, List<byte[]> list) {
        return new i(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, aVar, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public static i a(String str, String str2, String str3, int i2, List<byte[]> list, String str4, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar) {
        return new i(str, (String) null, str2, (String) null, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, aVar, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public static i a(String str, String str2, long j2) {
        return new i((String) null, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, (String) null, -1, j2, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public static i a(String str, String str2, String str3, int i2, com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar) {
        return new i(str, (String) null, str2, (String) null, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, aVar, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
    }

    public i a(long j2) {
        return new i(this.a, this.e, this.f, this.c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, j2, this.h, this.i, this.d);
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f);
        String str = this.y;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        a(mediaFormat, "max-input-size", this.g);
        a(mediaFormat, "width", this.j);
        a(mediaFormat, "height", this.k);
        float f2 = this.l;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        a(mediaFormat, "rotation-degrees", this.m);
        a(mediaFormat, "channel-count", this.r);
        a(mediaFormat, "sample-rate", this.s);
        a(mediaFormat, "encoder-delay", this.u);
        a(mediaFormat, "encoder-padding", this.v);
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.h.get(i2)));
        }
        b bVar = this.q;
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.c);
            a(mediaFormat, "color-standard", bVar.a);
            a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public i(Parcel parcel) {
        this.a = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.c = parcel.readString();
        this.b = parcel.readInt();
        this.g = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (b) parcel.readParcelable(b.class.getClassLoader());
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.h.add(parcel.createByteArray());
        }
        this.i = (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) parcel.readParcelable(com.fyber.inneractive.sdk.player.exoplayer2.drm.a.class.getClassLoader());
        this.d = (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) parcel.readParcelable(com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.class.getClassLoader());
    }

    public static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }
}
