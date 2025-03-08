package com.applovin.exoplayer2.k;

import android.net.Uri;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.mediationsdk.config.VersionInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public final String Jx;
    public final Map<String, String> ZA;
    @Deprecated
    public final long ZB;
    public final Object ZC;
    public final long Zx;
    public final int Zy;
    public final byte[] Zz;
    public final Uri ef;
    public final int jF;
    public final long uc;
    public final long wC;

    public boolean fg(int i) {
        return (this.jF & i) == i;
    }

    public static final class a {
        private String Jx;
        private Map<String, String> ZA;
        private Object ZC;
        private long Zx;
        private int Zy;
        private byte[] Zz;
        private Uri ef;
        private int jF;
        private long uc;
        private long wC;

        public a G(byte[] bArr) {
            this.Zz = bArr;
            return this;
        }

        public a aL(String str) {
            this.Jx = str;
            return this;
        }

        public a bl(long j) {
            this.uc = j;
            return this;
        }

        public a d(Map<String, String> map) {
            this.ZA = map;
            return this;
        }

        public a e(Uri uri) {
            this.ef = uri;
            return this;
        }

        public a fh(int i) {
            this.Zy = i;
            return this;
        }

        public a fi(int i) {
            this.jF = i;
            return this;
        }

        public a() {
            this.Zy = 1;
            this.ZA = Collections.emptyMap();
            this.wC = -1;
        }

        private a(l lVar) {
            this.ef = lVar.ef;
            this.Zx = lVar.Zx;
            this.Zy = lVar.Zy;
            this.Zz = lVar.Zz;
            this.ZA = lVar.ZA;
            this.uc = lVar.uc;
            this.wC = lVar.wC;
            this.Jx = lVar.Jx;
            this.jF = lVar.jF;
            this.ZC = lVar.ZC;
        }

        public a aK(String str) {
            this.ef = Uri.parse(str);
            return this;
        }

        public l oj() {
            com.applovin.exoplayer2.l.a.q(this.ef, "The uri must be set.");
            return new l(this.ef, this.Zx, this.Zy, this.Zz, this.ZA, this.uc, this.wC, this.Jx, this.jF, this.ZC);
        }
    }

    public static String ff(int i) {
        if (i == 1) {
            return i9.a;
        }
        if (i == 2) {
            return i9.b;
        }
        if (i == 3) {
            return VersionInfo.GIT_BRANCH;
        }
        throw new IllegalStateException();
    }

    private l(Uri uri, long j, int i, byte[] bArr, Map<String, String> map, long j2, long j3, String str, int i2, Object obj) {
        long j4 = j;
        byte[] bArr2 = bArr;
        long j5 = j2;
        long j6 = j3;
        long j7 = j4 + j5;
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkArgument(j7 >= 0);
        com.applovin.exoplayer2.l.a.checkArgument(j5 >= 0);
        if (j6 <= 0 && j6 != -1) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        this.ef = uri;
        this.Zx = j4;
        this.Zy = i;
        this.Zz = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.ZA = Collections.unmodifiableMap(new HashMap(map));
        this.uc = j5;
        this.ZB = j7;
        this.wC = j6;
        this.Jx = str;
        this.jF = i2;
        this.ZC = obj;
    }

    public final String oh() {
        return ff(this.Zy);
    }

    public a oi() {
        return new a();
    }

    public String toString() {
        return "DataSpec[" + oh() + " " + this.ef + ", " + this.uc + ", " + this.wC + ", " + this.Jx + ", " + this.jF + m2.i.e;
    }
}
