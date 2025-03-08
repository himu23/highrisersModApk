package com.applovin.impl.b;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.ironsource.w5;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class k {
    private String aXR;
    private String aXS;
    private long aXT = -1;
    private int aXU = -1;
    private String ahJ;

    public String Ai() {
        return this.aXR;
    }

    public String MD() {
        return this.aXS;
    }

    public boolean h(long j, int i) {
        long j2 = this.aXT;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.aXU;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    private k() {
    }

    public static k b(y yVar, e eVar, n nVar) {
        List<String> explode;
        int size;
        long seconds;
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            try {
                String LK = yVar.LK();
                if (StringUtils.isValidString(LK)) {
                    k kVar = new k();
                    kVar.aXS = LK;
                    kVar.ahJ = yVar.LJ().get(w5.x);
                    kVar.aXR = yVar.LJ().get(NotificationCompat.CATEGORY_EVENT);
                    kVar.aXU = a(kVar.Ai(), eVar);
                    String str = yVar.LJ().get("offset");
                    if (StringUtils.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            kVar.aXU = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":") && (size = explode.size()) > 0) {
                            int i = size - 1;
                            long j = 0;
                            for (int i2 = i; i2 >= 0; i2--) {
                                String str2 = (explode = CollectionUtils.explode(trim, ":")).get(i2);
                                if (StringUtils.isNumeric(str2)) {
                                    int parseInt = Integer.parseInt(str2);
                                    if (i2 == i) {
                                        seconds = (long) parseInt;
                                    } else if (i2 == size - 2) {
                                        seconds = TimeUnit.MINUTES.toSeconds((long) parseInt);
                                    } else if (i2 == size - 3) {
                                        seconds = TimeUnit.HOURS.toSeconds((long) parseInt);
                                    }
                                    j += seconds;
                                }
                            }
                            kVar.aXT = j;
                            kVar.aXU = -1;
                        }
                    }
                    return kVar;
                }
                nVar.BN();
                if (!x.Fn()) {
                    return null;
                }
                nVar.BN().i("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("VastTracker", "Error occurred while initializing", th);
                }
                nVar.Cs().g("VastTracker", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static int a(String str, e eVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (eVar != null) {
            return eVar.GE();
        }
        return 95;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.aXT != kVar.aXT || this.aXU != kVar.aXU) {
            return false;
        }
        String str = this.ahJ;
        if (str == null ? kVar.ahJ != null : !str.equals(kVar.ahJ)) {
            return false;
        }
        String str2 = this.aXR;
        if (str2 == null ? kVar.aXR == null : str2.equals(kVar.aXR)) {
            return this.aXS.equals(kVar.aXS);
        }
        return false;
    }

    public int hashCode() {
        String str = this.ahJ;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aXR;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long j = this.aXT;
        return ((((((hashCode + i) * 31) + this.aXS.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.aXU;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.ahJ + "', event='" + this.aXR + "', uriString='" + this.aXS + "', offsetSeconds=" + this.aXT + ", offsetPercent=" + this.aXU + '}';
    }
}
