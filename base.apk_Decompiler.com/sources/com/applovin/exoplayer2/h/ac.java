package com.applovin.exoplayer2.h;

import android.os.Bundle;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.c;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.List;

public final class ac implements g {
    public static final g.a<ac> br = new ac$$ExternalSyntheticLambda0();
    private final v[] NF;
    private int dS;
    public final int fR;

    private static int ea(int i) {
        return i | 16384;
    }

    public ac(v... vVarArr) {
        a.checkArgument(vVarArr.length > 0);
        this.NF = vVarArr;
        this.fR = vVarArr.length;
        lL();
    }

    public v dZ(int i) {
        return this.NF[i];
    }

    public int w(v vVar) {
        int i = 0;
        while (true) {
            v[] vVarArr = this.NF;
            if (i >= vVarArr.length) {
                return -1;
            }
            if (vVar == vVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Arrays.hashCode(this.NF);
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
        ac acVar = (ac) obj;
        if (this.fR != acVar.fR || !Arrays.equals(this.NF, acVar.NF)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ac v(Bundle bundle) {
        return new ac((v[]) c.a(v.br, (List<Bundle>) bundle.getParcelableArrayList(t(0)), s.ga()).toArray(new v[0]));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }

    private void lL() {
        String aa = aa(this.NF[0].dq);
        int ea = ea(this.NF[0].ds);
        int i = 1;
        while (true) {
            v[] vVarArr = this.NF;
            if (i >= vVarArr.length) {
                return;
            }
            if (!aa.equals(aa(vVarArr[i].dq))) {
                a("languages", this.NF[0].dq, this.NF[i].dq, i);
                return;
            } else if (ea != ea(this.NF[i].ds)) {
                a("role flags", Integer.toBinaryString(this.NF[0].ds), Integer.toBinaryString(this.NF[i].ds), i);
                return;
            } else {
                i++;
            }
        }
    }

    private static String aa(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void a(String str, String str2, String str3, int i) {
        q.c("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }
}
