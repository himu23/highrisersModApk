package com.kumobius.android.features;

import com.android.billingclient.api.BillingResult;
import com.kumobius.android.features.GooglePlayIapFeature;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ GooglePlayIapFeature.QueryInventoryFinishedListener f$0;
    public final /* synthetic */ BillingResult f$1;

    public /* synthetic */ GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda3(GooglePlayIapFeature.QueryInventoryFinishedListener queryInventoryFinishedListener, BillingResult billingResult) {
        this.f$0 = queryInventoryFinishedListener;
        this.f$1 = billingResult;
    }

    public final void run() {
        this.f$0.m43lambda$onQueryPurchasesResponse$3$comkumobiusandroidfeaturesGooglePlayIapFeature$QueryInventoryFinishedListener(this.f$1);
    }
}
