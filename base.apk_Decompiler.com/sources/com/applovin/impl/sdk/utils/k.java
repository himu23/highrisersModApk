package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.n;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class k implements SensorEventListener, AppLovinBroadcastManager.Receiver {
    private final Sensor aVL;
    private final a aVM;
    private float aVN;
    private final SensorManager afT;
    private final n sdk;

    public interface a {
        void tA();

        void tz();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public k(n nVar, a aVar) {
        this.sdk = nVar;
        SensorManager sensorManager = (SensorManager) n.getApplicationContext().getSystemService("sensor");
        this.afT = sensorManager;
        this.aVL = sensorManager.getDefaultSensor(1);
        this.aVM = aVar;
    }

    public void Lm() {
        this.afT.unregisterListener(this);
        this.afT.registerListener(this, this.aVL, (int) TimeUnit.MILLISECONDS.toMicros(50));
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void Ln() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.afT.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.aVN;
            float f2 = (f * 0.5f) + (max * 0.5f);
            this.aVN = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.aVM.tA();
            } else if (f > -0.8f && f2 < -0.8f) {
                this.aVM.tz();
            }
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.afT.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            Lm();
        }
    }
}
