package com.applovin.impl.sdk.a;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

public class d {
    private final View VG;
    private final FriendlyObstructionPurpose aIC;
    private final String aID;

    public View IQ() {
        return this.VG;
    }

    public FriendlyObstructionPurpose IR() {
        return this.aIC;
    }

    public String IS() {
        return this.aID;
    }

    public d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.VG = view;
        this.aIC = friendlyObstructionPurpose;
        this.aID = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        View view = this.VG;
        if (view == null ? dVar.VG != null : !view.equals(dVar.VG)) {
            return false;
        }
        if (this.aIC != dVar.aIC) {
            return false;
        }
        String str = this.aID;
        String str2 = dVar.aID;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        View view = this.VG;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.aIC;
        int hashCode2 = (hashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.aID;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }
}
