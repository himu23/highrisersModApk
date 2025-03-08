package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.e.e;
import com.applovin.exoplayer2.g.e.i;
import com.applovin.exoplayer2.l.ai;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class r {
    private static final Pattern uN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int dO = -1;
    public int dP = -1;

    public boolean bP(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.dO = i2;
        this.dP = i3;
        return true;
    }

    public boolean ij() {
        return (this.dO == -1 || this.dP == -1) ? false : true;
    }

    public boolean e(a aVar) {
        for (int i = 0; i < aVar.kD(); i++) {
            a.C0047a de = aVar.de(i);
            if (de instanceof e) {
                e eVar = (e) de;
                if ("iTunSMPB".equals(eVar.oc) && D(eVar.JN)) {
                    return true;
                }
            } else if (de instanceof i) {
                i iVar = (i) de;
                if ("com.apple.iTunes".equals(iVar.JU) && "iTunSMPB".equals(iVar.oc) && D(iVar.JN)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean D(String str) {
        Matcher matcher = uN.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) ai.R(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) ai.R(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.dO = parseInt;
            this.dP = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
