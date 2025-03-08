package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class q implements SensorEventListener, AppLovinBroadcastManager.Receiver {
    private final int aVY;
    private final float aVZ;
    private final Sensor aWa;
    private final Sensor aWb;
    private float[] aWc;
    private float aWd;
    private final SensorManager afT;
    private final n sdk;

    public float Lr() {
        return this.aWd;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public q(n nVar) {
        this.sdk = nVar;
        SensorManager sensorManager = (SensorManager) n.getApplicationContext().getSystemService("sensor");
        this.afT = sensorManager;
        this.aWa = sensorManager.getDefaultSensor(9);
        this.aWb = sensorManager.getDefaultSensor(4);
        this.aVY = ((Integer) nVar.a(b.aOX)).intValue();
        this.aVZ = ((Float) nVar.a(b.aOW)).floatValue();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void Lq() {
        this.afT.unregisterListener(this);
        if (((Boolean) this.sdk.BP().a(b.aOT)).booleanValue()) {
            a(this.aWa);
        }
        if (((Boolean) this.sdk.BP().a(b.aOU)).booleanValue()) {
            a(this.aWb);
        }
    }

    private void a(Sensor sensor) {
        try {
            this.afT.registerListener(this, sensor, (int) TimeUnit.MILLISECONDS.toMicros((long) this.aVY));
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("SensorDataManager", "Unable to register sensor listener", th);
            }
        }
    }

    public float Ls() {
        float[] fArr = this.aWc;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.aWc = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.aWd * this.aVZ;
            this.aWd = f;
            this.aWd = f + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.afT.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            Lq();
        }
    }
}
