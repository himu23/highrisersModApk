package com.applovin.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class b {
    private final Context E;
    private final a F;
    /* access modifiers changed from: private */
    public boolean G;

    /* renamed from: com.applovin.exoplayer2.b$b  reason: collision with other inner class name */
    public interface C0032b {
        void m();
    }

    public b(Context context, Handler handler, C0032b bVar) {
        this.E = context.getApplicationContext();
        this.F = new a(handler, bVar);
    }

    public void setEnabled(boolean z) {
        if (z && !this.G) {
            this.E.registerReceiver(this.F, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.G = true;
        } else if (!z && this.G) {
            this.E.unregisterReceiver(this.F);
            this.G = false;
        }
    }

    private final class a extends BroadcastReceiver implements Runnable {
        private final C0032b H;
        private final Handler I;

        public a(Handler handler, C0032b bVar) {
            this.I = handler;
            this.H = bVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.I.post(this);
            }
        }

        public void run() {
            if (b.this.G) {
                this.H.m();
            }
        }
    }
}
