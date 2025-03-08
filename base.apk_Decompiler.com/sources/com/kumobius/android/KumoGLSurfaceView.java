package com.kumobius.android;

import android.opengl.GLSurfaceView;

public class KumoGLSurfaceView extends GLSurfaceView {
    public KumoGLSurfaceView(KumoAppActivity kumoAppActivity) {
        super(kumoAppActivity);
        setEGLContextClientVersion(kumoAppActivity.getResources().getInteger(R.integer.glVersion));
        setEGLConfigChooser(true);
        trySetPreserveEGLContextOnPause(true);
        setRenderer(new KumoSurfaceViewRenderer(kumoAppActivity, this));
    }

    private void trySetPreserveEGLContextOnPause(boolean z) {
        setPreserveEGLContextOnPause(z);
    }
}
