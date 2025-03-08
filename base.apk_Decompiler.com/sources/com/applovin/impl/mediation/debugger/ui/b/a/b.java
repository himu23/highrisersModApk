package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.privacy.a;

public class b extends c {
    private final Context E;
    private final a.C0080a arW;
    private final boolean arX;

    public boolean isEnabled() {
        return false;
    }

    public b(a.C0080a aVar, boolean z, Context context) {
        super(c.b.RIGHT_DETAIL);
        this.arW = aVar;
        this.E = context;
        this.asv = new SpannedString(aVar.getName());
        this.arX = z;
    }

    public SpannedString wG() {
        return new SpannedString(this.arW.C(this.E));
    }

    public boolean wH() {
        Boolean B = this.arW.B(this.E);
        if (B != null) {
            return B.equals(Boolean.valueOf(this.arX));
        }
        return false;
    }
}
