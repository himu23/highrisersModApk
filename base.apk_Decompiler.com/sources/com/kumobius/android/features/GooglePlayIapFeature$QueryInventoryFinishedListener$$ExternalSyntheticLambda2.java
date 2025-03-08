package com.kumobius.android.features;

import com.kumobius.android.features.GooglePlayIapFeature;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ GooglePlayIapFeature.QueryInventoryFinishedListener f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda2(GooglePlayIapFeature.QueryInventoryFinishedListener queryInventoryFinishedListener, List list) {
        this.f$0 = queryInventoryFinishedListener;
        this.f$1 = list;
    }

    public final void run() {
        this.f$0.m42lambda$onQueryPurchasesResponse$1$comkumobiusandroidfeaturesGooglePlayIapFeature$QueryInventoryFinishedListener(this.f$1);
    }
}
