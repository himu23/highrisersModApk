package com.applovin.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.unity3d.services.core.device.MimeTypes;

final class ay {
    /* access modifiers changed from: private */
    public final Handler I;
    private final AudioManager K;
    private final Context hr;
    private final a ip;
    private b iq;
    private int ir = 3;
    private int is;
    private boolean it;

    public interface a {
        void ai(int i);

        void f(int i, boolean z);
    }

    public ay(Context context, Handler handler, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.hr = applicationContext;
        this.I = handler;
        this.ip = aVar;
        AudioManager audioManager = (AudioManager) com.applovin.exoplayer2.l.a.N((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.K = audioManager;
        this.is = a(audioManager, 3);
        this.it = b(audioManager, this.ir);
        b bVar = new b();
        try {
            applicationContext.registerReceiver(bVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.iq = bVar;
        } catch (RuntimeException e) {
            q.b("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public void aj(int i) {
        if (this.ir != i) {
            this.ir = i;
            dc();
            this.ip.ai(i);
        }
    }

    public int da() {
        if (ai.acV >= 28) {
            return ay$$ExternalSyntheticApiModelOutline0.m(this.K, this.ir);
        }
        return 0;
    }

    public int db() {
        return this.K.getStreamMaxVolume(this.ir);
    }

    public void release() {
        b bVar = this.iq;
        if (bVar != null) {
            try {
                this.hr.unregisterReceiver(bVar);
            } catch (RuntimeException e) {
                q.b("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.iq = null;
        }
    }

    /* access modifiers changed from: private */
    public void dc() {
        int a2 = a(this.K, this.ir);
        boolean b2 = b(this.K, this.ir);
        if (this.is != a2 || this.it != b2) {
            this.is = a2;
            this.it = b2;
            this.ip.f(a2, b2);
        }
    }

    private static int a(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            q.b("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    private static boolean b(AudioManager audioManager, int i) {
        if (ai.acV >= 23) {
            return ay$$ExternalSyntheticApiModelOutline0.m(audioManager, i);
        }
        return a(audioManager, i) == 0;
    }

    private final class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            ay.this.I.post(new ay$b$$ExternalSyntheticLambda0(ay.this));
        }
    }
}
