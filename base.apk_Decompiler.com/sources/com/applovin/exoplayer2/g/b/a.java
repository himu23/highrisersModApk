package com.applovin.exoplayer2.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class a implements a.C0047a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: e */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: dh */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private static final v Jk = new v.a().m("application/id3").bT();
    private static final v Jl = new v.a().m("application/x-scte35").bT();
    public final String Jm;
    public final String Jn;
    public final long Jo;
    public final long Jp;
    public final byte[] Jq;
    private int dS;

    public /* synthetic */ void F(ac.a aVar) {
        a.C0047a.CC.$default$F(this, aVar);
    }

    public int describeContents() {
        return 0;
    }

    public a(String str, String str2, long j, long j2, byte[] bArr) {
        this.Jm = str;
        this.Jn = str2;
        this.Jo = j;
        this.Jp = j2;
        this.Jq = bArr;
    }

    a(Parcel parcel) {
        this.Jm = (String) ai.R(parcel.readString());
        this.Jn = (String) ai.R(parcel.readString());
        this.Jo = parcel.readLong();
        this.Jp = parcel.readLong();
        this.Jq = (byte[]) ai.R(parcel.createByteArray());
    }

    public v kE() {
        String str = this.Jm;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Jl;
            case 1:
            case 2:
                return Jk;
            default:
                return null;
        }
    }

    public byte[] kF() {
        if (kE() != null) {
            return this.Jq;
        }
        return null;
    }

    public int hashCode() {
        if (this.dS == 0) {
            String str = this.Jm;
            int i = 0;
            int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.Jn;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.Jo;
            long j2 = this.Jp;
            this.dS = ((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.Jq);
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
        a aVar = (a) obj;
        if (this.Jo != aVar.Jo || this.Jp != aVar.Jp || !ai.r(this.Jm, aVar.Jm) || !ai.r(this.Jn, aVar.Jn) || !Arrays.equals(this.Jq, aVar.Jq)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "EMSG: scheme=" + this.Jm + ", id=" + this.Jp + ", durationMs=" + this.Jo + ", value=" + this.Jn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jm);
        parcel.writeString(this.Jn);
        parcel.writeLong(this.Jo);
        parcel.writeLong(this.Jp);
        parcel.writeByteArray(this.Jq);
    }
}
