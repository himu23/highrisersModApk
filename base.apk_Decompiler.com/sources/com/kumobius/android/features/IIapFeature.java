package com.kumobius.android.features;

public interface IIapFeature {
    boolean iapCanPurchase(String str);

    String iapGetDescription(String str);

    String iapGetError();

    String iapGetName(String str);

    String iapGetPrice(String str);

    int iapGetStatus();

    void iapInit();

    void iapLoadProducts(String[] strArr);

    void iapPurchase(String str);

    void iapRestore();

    void onDestroy();

    void onResume();

    void onStart();
}
