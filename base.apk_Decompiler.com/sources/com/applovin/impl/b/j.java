package com.applovin.impl.b;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.unity3d.ads.metadata.MediationMetaData;

public class j {
    private String name;
    private String version;

    private j() {
    }

    public static j a(y yVar, j jVar, n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            if (jVar == null) {
                try {
                    jVar = new j();
                } catch (Throwable th) {
                    nVar.BN();
                    if (x.Fn()) {
                        nVar.BN().c("VastSystemInfo", "Error occurred while initializing", th);
                    }
                    nVar.Cs().g("VastSystemInfo", th);
                    return null;
                }
            }
            if (!StringUtils.isValidString(jVar.name)) {
                String LK = yVar.LK();
                if (StringUtils.isValidString(LK)) {
                    jVar.name = LK;
                }
            }
            if (!StringUtils.isValidString(jVar.version)) {
                String str = yVar.LJ().get(MediationMetaData.KEY_VERSION);
                if (StringUtils.isValidString(str)) {
                    jVar.version = str;
                }
            }
            return jVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.name + "', version='" + this.version + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.name;
        if (str == null ? jVar.name != null : !str.equals(jVar.name)) {
            return false;
        }
        String str2 = this.version;
        String str3 = jVar.version;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
