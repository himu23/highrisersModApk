package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;

public class i {
    private a aXJ;
    private Uri aXK;
    private String aXL;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    public a MA() {
        return this.aXJ;
    }

    public Uri MB() {
        return this.aXK;
    }

    public String MC() {
        return this.aXL;
    }

    public void dR(String str) {
        this.aXL = str;
    }

    public void u(Uri uri) {
        this.aXK = uri;
    }

    private i() {
    }

    static i a(y yVar, i iVar, n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            if (iVar == null) {
                try {
                    iVar = new i();
                } catch (Throwable th) {
                    nVar.BN();
                    if (x.Fn()) {
                        nVar.BN().c("VastNonVideoResource", "Error occurred while initializing", th);
                    }
                    nVar.Cs().g("VastNonVideoResource", th);
                    return null;
                }
            }
            if (iVar.aXK == null && !StringUtils.isValidString(iVar.aXL)) {
                String a2 = a(yVar, "StaticResource");
                if (URLUtil.isValidUrl(a2)) {
                    iVar.aXK = Uri.parse(a2);
                    iVar.aXJ = a.STATIC;
                    return iVar;
                }
                String a3 = a(yVar, "IFrameResource");
                if (StringUtils.isValidString(a3)) {
                    iVar.aXJ = a.IFRAME;
                    if (URLUtil.isValidUrl(a3)) {
                        iVar.aXK = Uri.parse(a3);
                    } else {
                        iVar.aXL = a3;
                    }
                    return iVar;
                }
                String a4 = a(yVar, "HTMLResource");
                if (StringUtils.isValidString(a4)) {
                    iVar.aXJ = a.HTML;
                    if (URLUtil.isValidUrl(a4)) {
                        iVar.aXK = Uri.parse(a4);
                    } else {
                        iVar.aXL = a4;
                    }
                }
            }
            return iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static String a(y yVar, String str) {
        y dK = yVar.dK(str);
        if (dK != null) {
            return dK.LK();
        }
        return null;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.aXJ + ", resourceUri=" + this.aXK + ", resourceContents='" + this.aXL + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.aXJ != iVar.aXJ) {
            return false;
        }
        Uri uri = this.aXK;
        if (uri == null ? iVar.aXK != null : !uri.equals(iVar.aXK)) {
            return false;
        }
        String str = this.aXL;
        String str2 = iVar.aXL;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        a aVar = this.aXJ;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.aXK;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.aXL;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }
}
