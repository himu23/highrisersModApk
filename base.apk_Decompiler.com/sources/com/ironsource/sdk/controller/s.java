package com.ironsource.sdk.controller;

import android.app.Activity;
import android.media.AudioManager;
import com.ironsource.n5;
import com.unity3d.services.core.device.MimeTypes;

class s {

    class a implements Runnable {
        final /* synthetic */ AudioManager a;

        a(AudioManager audioManager) {
            this.a = audioManager;
        }

        public void run() {
            s.a(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ AudioManager a;

        b(AudioManager audioManager) {
            this.a = audioManager;
        }

        public void run() {
            s.d(this.a);
        }
    }

    s() {
    }

    public static void a(Activity activity) {
        n5.a.a(new a((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)));
    }

    /* access modifiers changed from: private */
    public static void a(AudioManager audioManager) {
        try {
            audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Activity activity) {
        n5.a.a(new b((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)));
    }

    /* access modifiers changed from: private */
    public static void d(AudioManager audioManager) {
        try {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
