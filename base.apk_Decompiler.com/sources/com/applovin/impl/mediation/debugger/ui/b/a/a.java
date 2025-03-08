package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.R;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class a extends c {
    private final Context E;
    private final b arV;

    public b wA() {
        return this.arV;
    }

    public a(b bVar, Context context) {
        super(c.b.DETAIL);
        this.arV = bVar;
        this.E = context;
        this.asv = wC();
        this.asw = wD();
    }

    public boolean isEnabled() {
        return this.arV.vl() != b.a.MISSING;
    }

    public int wB() {
        int vx = this.arV.vx();
        return vx > 0 ? vx : R.drawable.applovin_ic_mediation_placeholder;
    }

    public int tO() {
        return isEnabled() ? R.drawable.applovin_ic_disclosure_arrow : super.wB();
    }

    public int tP() {
        return g.a(R.color.applovin_sdk_disclosureButtonColor, this.E);
    }

    private SpannedString wC() {
        return StringUtils.createSpannedString(this.arV.getDisplayName(), isEnabled() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    private SpannedString wD() {
        if (!isEnabled()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(wE());
        spannableStringBuilder.append(new SpannableString("\n"));
        spannableStringBuilder.append(wF());
        if (this.arV.vl() == b.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append(new SpannableString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString wE() {
        if (!this.arV.vo()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
        }
        if (!TextUtils.isEmpty(this.arV.getSdkVersion())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.arV.getSdkVersion(), ViewCompat.MEASURED_STATE_MASK));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString(this.arV.vp() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
    }

    private SpannedString wF() {
        if (!this.arV.vp()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", SupportMenu.CATEGORY_MASK);
        }
        if (TextUtils.isEmpty(this.arV.getAdapterVersion())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.arV.getAdapterVersion(), ViewCompat.MEASURED_STATE_MASK));
        if (this.arV.vq()) {
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, WorkQueueKt.MASK, 0)));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.arV.vs(), ViewCompat.MEASURED_STATE_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + this.asv + ", detailText=" + this.asw + ", network=" + this.arV + "}";
    }
}
