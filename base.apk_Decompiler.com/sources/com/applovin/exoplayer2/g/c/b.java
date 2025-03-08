package com.applovin.exoplayer2.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.ironsource.m2;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class b implements a.C0047a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: g */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: dj */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final String Jn;
    public final String Jx;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    public b(String str, String str2) {
        this.Jx = str;
        this.Jn = str2;
    }

    b(Parcel parcel) {
        this.Jx = (String) ai.R(parcel.readString());
        this.Jn = (String) ai.R(parcel.readString());
    }

    public void F(ac.a aVar) {
        String str = this.Jx;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                aVar.c((CharSequence) this.Jn);
                return;
            case 1:
                aVar.a((CharSequence) this.Jn);
                return;
            case 2:
                aVar.g((CharSequence) this.Jn);
                return;
            case 3:
                aVar.d((CharSequence) this.Jn);
                return;
            case 4:
                aVar.b((CharSequence) this.Jn);
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "VC: " + this.Jx + m2.i.b + this.Jn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.Jx.equals(bVar.Jx) || !this.Jn.equals(bVar.Jn)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.Jx.hashCode()) * 31) + this.Jn.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jx);
        parcel.writeString(this.Jn);
    }
}
