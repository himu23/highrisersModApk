package com.kumobius.android;

import android.app.KeyguardManager;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class KumoSurfaceViewRenderer implements GLSurfaceView.Renderer {
    private static final String s_TAG = "KumoJava";
    private final KumoAppActivity m_Context;
    private boolean m_FirstCreate = true;
    private int m_Height = 0;
    private KeyguardManager m_KeyguardManager;
    private final KumoGLSurfaceView m_Parent;
    private float m_RefreshRateGuess = 0.0f;
    private int m_Width = 0;

    public KumoSurfaceViewRenderer(KumoAppActivity kumoAppActivity, KumoGLSurfaceView kumoGLSurfaceView) {
        this.m_Context = kumoAppActivity;
        this.m_Parent = kumoGLSurfaceView;
        try {
            this.m_KeyguardManager = (KeyguardManager) kumoAppActivity.getSystemService("keyguard");
        } catch (Exception e) {
            Log.w(s_TAG, e);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        KeyguardManager keyguardManager = this.m_KeyguardManager;
        if (keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode()) {
            KumoAppActivity kumoAppActivity = this.m_Context;
            NativeInterface.render(kumoAppActivity, this.m_RefreshRateGuess, kumoAppActivity.hasDpad());
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        setSize(i, i2);
        Rect safeArea = getSafeArea();
        Log.v(s_TAG, "Safe Area: " + safeArea.left + ", " + safeArea.top + ", " + safeArea.right + ", " + safeArea.bottom);
        NativeInterface.resized(this.m_Context, this.m_Width, this.m_Height, safeArea);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Thread.currentThread().setPriority(10);
        Log.v(s_TAG, "Render priority = " + Process.getThreadPriority(Process.myTid()));
        float refreshRate = this.m_Context.getWindowManager().getDefaultDisplay().getRefreshRate();
        this.m_RefreshRateGuess = refreshRate;
        if (refreshRate >= 1.0f / refreshRate) {
            this.m_RefreshRateGuess = 1.0f / refreshRate;
        }
        Log.v(s_TAG, "Claimed fps: " + (1.0f / this.m_RefreshRateGuess) + " (" + this.m_RefreshRateGuess + " s)");
        if (this.m_FirstCreate) {
            String locale = Locale.getDefault().toString();
            Log.v(s_TAG, "Requested locale: " + locale);
            StringBuilder sb = new StringBuilder();
            sb.append(this.m_Context.getOverrides());
            for (String append : KumoAppBase.getOverrides()) {
                sb.append(',');
                sb.append(append);
            }
            setSize(this.m_Parent.getWidth(), this.m_Parent.getHeight());
            Rect safeArea = getSafeArea();
            Log.v(s_TAG, "Safe Area: " + safeArea.left + ", " + safeArea.top + ", " + safeArea.right + ", " + safeArea.bottom);
            KumoAppActivity kumoAppActivity = this.m_Context;
            NativeInterface.init(kumoAppActivity, Utils.getBundleAssetsPath(kumoAppActivity), Utils.getUserDataDir(this.m_Context), this.m_Width, this.m_Height, safeArea, locale, sb.toString(), this.m_Context.getUseLoFi());
            this.m_FirstCreate = false;
            return;
        }
        Log.v(s_TAG, "OpenGL context lost, recreating resources...");
        NativeInterface.contextLost(this.m_Context);
    }

    private Rect getSafeArea() {
        int i;
        int i2;
        int i3;
        WindowInsets m;
        DisplayCutout m2;
        int i4 = 0;
        if (Build.VERSION.SDK_INT < 28 || (m = this.m_Context.getWindow().getDecorView().getRootWindowInsets()) == null || (m2 = m.getDisplayCutout()) == null) {
            i3 = 0;
            i2 = 0;
            i = 0;
        } else {
            int max = Math.max(0, (int) (this.m_Parent.getScaleX() * ((float) m2.getSafeInsetLeft())));
            i2 = Math.max(0, (int) (this.m_Parent.getScaleX() * ((float) m2.getSafeInsetRight())));
            i = Math.max(0, (int) (this.m_Parent.getScaleY() * ((float) m2.getSafeInsetTop())));
            i3 = Math.max(0, (int) (this.m_Parent.getScaleY() * ((float) m2.getSafeInsetBottom())));
            i4 = max;
        }
        return new Rect(i4, i, i2, i3);
    }

    private boolean setSize(int i, int i2) {
        int i3;
        int i4;
        int orientationMode = Utils.getOrientationMode(this.m_Context);
        if (orientationMode == 2 ? i > i2 : orientationMode != 3 && i < i2) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        if (this.m_Width == i4 && this.m_Height == i3) {
            return false;
        }
        this.m_Width = i4;
        this.m_Height = i3;
        Log.v(s_TAG, "New Screen Size: " + i + "x" + i2);
        Log.v(s_TAG, "     Using Size: " + this.m_Width + "x" + this.m_Height);
        return true;
    }
}
