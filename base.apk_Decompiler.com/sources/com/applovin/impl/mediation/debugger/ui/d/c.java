package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.R;

public class c {
    protected int ahg;
    protected int apK;
    protected String apL;
    protected String aqT;
    protected int asA;
    protected boolean asB;
    protected b asu;
    protected SpannedString asv;
    protected SpannedString asw;
    protected int asx;
    protected int asy;
    protected int asz;
    protected boolean iV;

    public int getTextColor() {
        return this.ahg;
    }

    public boolean isEnabled() {
        return this.iV;
    }

    public int tO() {
        return this.asy;
    }

    public int tP() {
        return this.asA;
    }

    public int vP() {
        return this.apK;
    }

    public String vQ() {
        return this.apL;
    }

    public int wB() {
        return this.asx;
    }

    public SpannedString wG() {
        return this.asw;
    }

    public boolean wH() {
        return this.asB;
    }

    public SpannedString wU() {
        return this.asv;
    }

    public int wV() {
        return this.asz;
    }

    public String wk() {
        return this.aqT;
    }

    public enum b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        
        private final int ahF;

        public int wY() {
            return this.ahF;
        }

        private b(int i) {
            this.ahF = i;
        }

        public int wT() {
            if (this == SECTION) {
                return R.layout.mediation_debugger_list_section;
            }
            if (this == SECTION_CENTERED) {
                return R.layout.mediation_debugger_list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            if (this == DETAIL) {
                return R.layout.applovin_debugger_list_item_detail;
            }
            return R.layout.mediation_debugger_list_item_right_detail;
        }
    }

    public static int getViewTypeCount() {
        return b.COUNT.wY();
    }

    protected c(b bVar) {
        this.asx = 0;
        this.asy = 0;
        this.ahg = ViewCompat.MEASURED_STATE_MASK;
        this.apK = ViewCompat.MEASURED_STATE_MASK;
        this.asz = 0;
        this.asA = 0;
        this.asu = bVar;
    }

    private c(a aVar) {
        this.asx = 0;
        this.asy = 0;
        this.ahg = ViewCompat.MEASURED_STATE_MASK;
        this.apK = ViewCompat.MEASURED_STATE_MASK;
        this.asz = 0;
        this.asA = 0;
        this.asu = aVar.asu;
        this.iV = aVar.iV;
        this.asv = aVar.asv;
        this.asw = aVar.asw;
        this.aqT = aVar.aqT;
        this.apL = aVar.apL;
        this.asx = aVar.asx;
        this.asy = aVar.asy;
        this.ahg = aVar.ahg;
        this.apK = aVar.apK;
        this.asz = aVar.asz;
        this.asA = aVar.asA;
        this.asB = aVar.asB;
    }

    public int wS() {
        return this.asu.wY();
    }

    public int wT() {
        return this.asu.wT();
    }

    public static a wW() {
        return a(b.RIGHT_DETAIL);
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public static class a {
        int ahg = ViewCompat.MEASURED_STATE_MASK;
        int apK = ViewCompat.MEASURED_STATE_MASK;
        String apL;
        String aqT;
        int asA = 0;
        boolean asB;
        final b asu;
        SpannedString asv;
        SpannedString asw;
        int asx = 0;
        int asy = 0;
        int asz = 0;
        boolean iV;

        public a a(SpannedString spannedString) {
            this.asv = spannedString;
            return this;
        }

        public a aF(boolean z) {
            this.iV = z;
            return this;
        }

        public a aG(boolean z) {
            this.asB = z;
            return this;
        }

        public a b(SpannedString spannedString) {
            this.asw = spannedString;
            return this;
        }

        public a bQ(String str) {
            this.aqT = str;
            return this;
        }

        public a bR(String str) {
            this.apL = str;
            return this;
        }

        public a gk(int i) {
            this.asy = i;
            return this;
        }

        public a gl(int i) {
            this.ahg = i;
            return this;
        }

        public a gm(int i) {
            this.apK = i;
            return this;
        }

        public a gn(int i) {
            this.asA = i;
            return this;
        }

        public a(b bVar) {
            this.asu = bVar;
        }

        public a bO(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a bP(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a y(Context context) {
            this.asy = R.drawable.applovin_ic_disclosure_arrow;
            this.asA = g.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public c wX() {
            return new c(this);
        }
    }
}
