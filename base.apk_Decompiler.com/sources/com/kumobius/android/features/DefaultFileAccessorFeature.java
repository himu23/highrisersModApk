package com.kumobius.android.features;

import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.kumobius.android.KumoAppActivity;
import com.kumobius.android.Utils;

public class DefaultFileAccessorFeature implements IFileAccessorFeature {
    private static final String s_TAG = "KumoJava";
    private final KumoAppActivity m_Activity;

    public void fileAccessInit() {
    }

    public DefaultFileAccessorFeature(KumoAppActivity kumoAppActivity) {
        this.m_Activity = kumoAppActivity;
    }

    public AssetFileDescriptor openFd(String str) {
        try {
            String assetPath = Utils.getAssetPath(this.m_Activity, str);
            if (assetPath != null) {
                return this.m_Activity.getAssets().openFd(assetPath);
            }
            return null;
        } catch (Exception e) {
            Log.w(s_TAG, e);
            return null;
        }
    }
}
