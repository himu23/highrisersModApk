package com.applovin.impl.b;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;

public class h {
    private final String aXH;
    private final String aXI;

    public String My() {
        return this.aXH;
    }

    public String Mz() {
        return this.aXI;
    }

    private h(String str, String str2) {
        this.aXH = str;
        this.aXI = str2;
    }

    public static h b(y yVar, n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            try {
                return new h(yVar.LJ().get("apiFramework"), yVar.LK());
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("VastJavaScriptResource", "Error occurred while initializing", th);
                }
                nVar.Cs().g("VastJavaScriptResource", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.aXH;
        if (str == null ? hVar.aXH != null : !str.equals(hVar.aXH)) {
            return false;
        }
        String str2 = this.aXI;
        String str3 = hVar.aXI;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.aXH;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aXI;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.aXH + "', javascriptResourceUrl='" + this.aXI + "'}";
    }
}
