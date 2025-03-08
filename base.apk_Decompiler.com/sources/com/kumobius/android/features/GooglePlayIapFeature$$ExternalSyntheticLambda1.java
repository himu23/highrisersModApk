package com.kumobius.android.features;

import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayIapFeature$$ExternalSyntheticLambda1 implements AcknowledgePurchaseResponseListener {
    public final /* synthetic */ Purchase f$0;

    public /* synthetic */ GooglePlayIapFeature$$ExternalSyntheticLambda1(Purchase purchase) {
        this.f$0 = purchase;
    }

    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        GooglePlayIapFeature.lambda$handlePurchases$6(this.f$0, billingResult);
    }
}
