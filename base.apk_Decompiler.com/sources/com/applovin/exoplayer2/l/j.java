package com.applovin.exoplayer2.l;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

public final class j implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private static final int[] abU = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private final int[] abV;
    private final b abW;
    private EGLDisplay abX;
    private EGLContext abY;
    private EGLSurface abZ;
    private SurfaceTexture aca;
    private final Handler jS;

    public interface b {
        void oU();
    }

    public static final class a extends RuntimeException {
        private a(String str) {
            super(str);
        }
    }

    public j(Handler handler) {
        this(handler, (b) null);
    }

    public j(Handler handler, b bVar) {
        this.jS = handler;
        this.abW = bVar;
        this.abV = new int[1];
    }

    public void fm(int i) {
        EGLDisplay oT = oT();
        this.abX = oT;
        EGLConfig a2 = a(oT);
        EGLContext a3 = a(this.abX, a2, i);
        this.abY = a3;
        this.abZ = a(this.abX, a2, a3, i);
        g(this.abV);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.abV[0]);
        this.aca = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public void release() {
        this.jS.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.aca;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.abV, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.abX;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent(this.abX, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface = this.abZ;
            if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.abX, this.abZ);
            }
            EGLContext eGLContext = this.abY;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.abX, eGLContext);
            }
            if (ai.acV >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay2 = this.abX;
            if (eGLDisplay2 != null && !eGLDisplay2.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.abX);
            }
            this.abX = null;
            this.abY = null;
            this.abZ = null;
            this.aca = null;
        }
    }

    public SurfaceTexture oR() {
        return (SurfaceTexture) a.checkNotNull(this.aca);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.jS.post(this);
    }

    public void run() {
        oS();
        SurfaceTexture surfaceTexture = this.aca;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    private void oS() {
        b bVar = this.abW;
        if (bVar != null) {
            bVar.oU();
        }
    }

    private static EGLDisplay oT() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                return eglGetDisplay;
            }
            throw new a("eglInitialize failed");
        }
        throw new a("eglGetDisplay failed");
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig eGLConfig;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, abU, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (eglChooseConfig && iArr[0] > 0 && (eGLConfig = eGLConfigArr[0]) != null) {
            return eGLConfig;
        }
        throw new a(ai.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new a("eglCreateContext failed");
    }

    private static EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i) {
        EGLSurface eGLSurface;
        if (i == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurface == null) {
                throw new a("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
            return eGLSurface;
        }
        throw new a("eglMakeCurrent failed");
    }

    private static void g(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        n.oX();
    }
}
