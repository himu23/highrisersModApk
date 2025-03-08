package com.kumobius.android.features;

public interface ICloudFeature {
    void cloudClearAll();

    void cloudPushData(String[] strArr, String[] strArr2);

    void cloudReady();
}
