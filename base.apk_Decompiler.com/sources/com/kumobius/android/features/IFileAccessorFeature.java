package com.kumobius.android.features;

import android.content.res.AssetFileDescriptor;

public interface IFileAccessorFeature {
    void fileAccessInit();

    AssetFileDescriptor openFd(String str);
}
