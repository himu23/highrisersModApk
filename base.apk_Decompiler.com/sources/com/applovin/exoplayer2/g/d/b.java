package com.applovin.exoplayer2.g.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class b implements a.C0047a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: h */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: dk */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final String JB;
    public final boolean JC;
    public final int JD;
    public final String Jj;
    public final int dv;
    public final String name;

    public /* synthetic */ void F(ac.a aVar) {
        a.C0047a.CC.$default$F(this, aVar);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.exoplayer2.g.d.b c(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r14) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "Invalid bitrate: "
            java.lang.String r2 = "icy-br"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.lang.String r3 = "IcyHeaders"
            r4 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            int r7 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0036 }
            int r7 = r7 * 1000
            if (r7 <= 0) goto L_0x0023
            r1 = 1
            goto L_0x0034
        L_0x0023:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0037 }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x0037 }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x0037 }
            java.lang.String r1 = r8.toString()     // Catch:{ NumberFormatException -> 0x0037 }
            com.applovin.exoplayer2.l.q.h(r3, r1)     // Catch:{ NumberFormatException -> 0x0037 }
            r1 = 0
            r7 = -1
        L_0x0034:
            r8 = r7
            goto L_0x004d
        L_0x0036:
            r7 = -1
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r8 = "Invalid bitrate header: "
            r1.<init>(r8)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.applovin.exoplayer2.l.q.h(r3, r1)
            r8 = r7
            r1 = 0
            goto L_0x004d
        L_0x004b:
            r1 = 0
            r8 = -1
        L_0x004d:
            java.lang.String r2 = "icy-genre"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            r7 = 0
            if (r2 == 0) goto L_0x0061
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            r1 = 1
            goto L_0x0062
        L_0x0061:
            r9 = r7
        L_0x0062:
            java.lang.String r2 = "icy-name"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0075
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = 1
            goto L_0x0076
        L_0x0075:
            r10 = r7
        L_0x0076:
            java.lang.String r2 = "icy-url"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0089
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = 1
            goto L_0x008a
        L_0x0089:
            r11 = r7
        L_0x008a:
            java.lang.String r2 = "icy-pub"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            r12 = r1
            r1 = 1
            goto L_0x00a4
        L_0x00a3:
            r12 = 0
        L_0x00a4:
            java.lang.String r2 = "icy-metaint"
            java.lang.Object r14 = r14.get(r2)
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x00e0
            java.lang.Object r14 = r14.get(r5)
            java.lang.String r14 = (java.lang.String) r14
            int r2 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x00cf }
            if (r2 <= 0) goto L_0x00bc
            r6 = r2
            goto L_0x00cc
        L_0x00bc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ce }
            r4.<init>(r0)     // Catch:{ NumberFormatException -> 0x00ce }
            r4.append(r14)     // Catch:{ NumberFormatException -> 0x00ce }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x00ce }
            com.applovin.exoplayer2.l.q.h(r3, r4)     // Catch:{ NumberFormatException -> 0x00ce }
            r4 = r1
        L_0x00cc:
            r1 = r4
            goto L_0x00de
        L_0x00ce:
            r6 = r2
        L_0x00cf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            com.applovin.exoplayer2.l.q.h(r3, r14)
        L_0x00de:
            r13 = r6
            goto L_0x00e1
        L_0x00e0:
            r13 = -1
        L_0x00e1:
            if (r1 == 0) goto L_0x00e9
            com.applovin.exoplayer2.g.d.b r14 = new com.applovin.exoplayer2.g.d.b
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x00e9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.g.d.b.c(java.util.Map):com.applovin.exoplayer2.g.d.b");
    }

    public b(int i, String str, String str2, String str3, boolean z, int i2) {
        com.applovin.exoplayer2.l.a.checkArgument(i2 == -1 || i2 > 0);
        this.dv = i;
        this.JB = str;
        this.name = str2;
        this.Jj = str3;
        this.JC = z;
        this.JD = i2;
    }

    b(Parcel parcel) {
        this.dv = parcel.readInt();
        this.JB = parcel.readString();
        this.name = parcel.readString();
        this.Jj = parcel.readString();
        this.JC = ai.K(parcel);
        this.JD = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.dv != bVar.dv || !ai.r(this.JB, bVar.JB) || !ai.r(this.name, bVar.name) || !ai.r(this.Jj, bVar.Jj) || this.JC != bVar.JC || this.JD != bVar.JD) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.dv) * 31;
        String str = this.JB;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Jj;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + (this.JC ? 1 : 0)) * 31) + this.JD;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.JB + "\", bitrate=" + this.dv + ", metadataInterval=" + this.JD;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dv);
        parcel.writeString(this.JB);
        parcel.writeString(this.name);
        parcel.writeString(this.Jj);
        ai.a(parcel, this.JC);
        parcel.writeInt(this.JD);
    }
}
