package com.applovin.exoplayer2.m.a;

import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.view.Surface;
import com.applovin.exoplayer2.m.l;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i extends GLSurfaceView {
    private Surface Hm;
    private final Handler acG;
    private final CopyOnWriteArrayList<a> afS;
    private final SensorManager afT;
    private final Sensor afU;
    private final d afV;
    private final h afW;
    private SurfaceTexture afX;
    private boolean afY;
    private boolean afZ;
    private boolean aga;

    public interface a {
        void a(Surface surface);
    }

    public a getCameraMotionListener() {
        return this.afW;
    }

    public l getVideoFrameMetadataListener() {
        return this.afW;
    }

    public Surface getVideoSurface() {
        return this.Hm;
    }

    public void a(a aVar) {
        this.afS.add(aVar);
    }

    public void b(a aVar) {
        this.afS.remove(aVar);
    }

    public void setDefaultStereoMode(int i) {
        this.afW.setDefaultStereoMode(i);
    }

    public void setUseSensorRotation(boolean z) {
        this.afY = z;
        qL();
    }

    public void onResume() {
        super.onResume();
        this.afZ = true;
        qL();
    }

    public void onPause() {
        this.afZ = false;
        qL();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.acG.post(new i$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qM() {
        Surface surface = this.Hm;
        if (surface != null) {
            Iterator<a> it = this.afS.iterator();
            while (it.hasNext()) {
                it.next().a(surface);
            }
        }
        a(this.afX, surface);
        this.afX = null;
        this.Hm = null;
    }

    private void qL() {
        boolean z = this.afY && this.afZ;
        Sensor sensor = this.afU;
        if (sensor != null && z != this.aga) {
            if (z) {
                this.afT.registerListener(this.afV, sensor, 0);
            } else {
                this.afT.unregisterListener(this.afV);
            }
            this.aga = z;
        }
    }

    private static void a(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
