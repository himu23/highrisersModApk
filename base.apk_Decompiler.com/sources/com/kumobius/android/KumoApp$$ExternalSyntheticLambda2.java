package com.kumobius.android;

import com.kumobius.android.features.GooglePlayIapFeature;
import com.kumobius.android.features.IFeatureFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class KumoApp$$ExternalSyntheticLambda2 implements IFeatureFactory {
    public final Object create(KumoAppActivity kumoAppActivity) {
        return new GooglePlayIapFeature(kumoAppActivity);
    }
}
