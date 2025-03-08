package com.kumobius.android.features;

import com.kumobius.android.KumoAppActivity;

public interface IFeatureFactory<T> {
    T create(KumoAppActivity kumoAppActivity);
}
