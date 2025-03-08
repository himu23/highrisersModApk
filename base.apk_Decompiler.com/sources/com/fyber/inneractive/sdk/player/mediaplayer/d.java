package com.fyber.inneractive.sdk.player.mediaplayer;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.unity3d.services.core.device.MimeTypes;

public class d implements Runnable {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a aVar = this.a;
        String c = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        AudioManager audioManager = (AudioManager) aVar.a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        IAlog.a("%s unmute maxVolume = %d currentVolume = %d targetVolume = %s", aVar.c(), Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        if (f == 0.0f) {
            f = 0.1f;
        }
        aVar.setVolume(f, f);
        IAlog.d(c + "timelog: unmute took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }
}
