package com.applovin.impl.a.a.b.a.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.R;

public class a extends c {
    private final Context E;
    private final com.applovin.impl.a.a.a.a akL;

    public boolean isEnabled() {
        return true;
    }

    public a(com.applovin.impl.a.a.a.a aVar, Context context) {
        super(c.b.DETAIL);
        this.akL = aVar;
        this.E = context;
        this.asv = tQ();
        this.asw = tR();
    }

    public int tO() {
        return isEnabled() ? R.drawable.applovin_ic_disclosure_arrow : super.wB();
    }

    public int tP() {
        return g.a(R.color.applovin_sdk_disclosureButtonColor, this.E);
    }

    private SpannedString tQ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(this.akL.tG());
        spannableStringBuilder.append(" - ");
        spannableStringBuilder.append(this.akL.getNetworkName());
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString tR() {
        return new SpannedString("Displayed " + u.i(this.akL.tI(), true));
    }
}
