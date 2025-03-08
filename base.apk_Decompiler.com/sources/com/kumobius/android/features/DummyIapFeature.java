package com.kumobius.android.features;

import com.kumobius.android.KumoAppActivity;

public class DummyIapFeature implements IIapFeature {
    public boolean iapCanPurchase(String str) {
        return false;
    }

    public String iapGetDescription(String str) {
        return "";
    }

    public String iapGetError() {
        return "not implemented";
    }

    public String iapGetName(String str) {
        return "";
    }

    public String iapGetPrice(String str) {
        return "";
    }

    public int iapGetStatus() {
        return 0;
    }

    public void iapInit() {
    }

    public void iapLoadProducts(String[] strArr) {
    }

    public void iapPurchase(String str) {
    }

    public void iapRestore() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public DummyIapFeature(KumoAppActivity kumoAppActivity) {
    }
}
