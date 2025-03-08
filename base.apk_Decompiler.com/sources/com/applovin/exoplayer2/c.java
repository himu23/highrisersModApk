package com.applovin.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.applovin.exoplayer2.b.d;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.unity3d.services.core.device.MimeTypes;

final class c {
    private final AudioManager K;
    private final a L;
    private b M;
    private d N;
    private int O;
    private int P;
    private float Q = 1.0f;
    private AudioFocusRequest R;
    private boolean S;

    public interface b {
        void b(float f);

        void l(int i);
    }

    private boolean i(int i) {
        return i == 1 || this.P != 1;
    }

    public float n() {
        return this.Q;
    }

    public c(Context context, Handler handler, b bVar) {
        this.K = (AudioManager) com.applovin.exoplayer2.l.a.checkNotNull((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.M = bVar;
        this.L = new a(handler);
        this.O = 0;
    }

    public void a(d dVar) {
        if (!ai.r(this.N, dVar)) {
            this.N = dVar;
            int b2 = b(dVar);
            this.P = b2;
            boolean z = true;
            if (!(b2 == 1 || b2 == 0)) {
                z = false;
            }
            com.applovin.exoplayer2.l.a.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int a(boolean z, int i) {
        if (i(i)) {
            p();
            if (z) {
                return 1;
            }
            return -1;
        } else if (z) {
            return o();
        } else {
            return -1;
        }
    }

    public void release() {
        this.M = null;
        p();
    }

    private int o() {
        if (this.O == 1) {
            return 1;
        }
        if ((ai.acV >= 26 ? r() : q()) == 1) {
            j(1);
            return 1;
        }
        j(0);
        return -1;
    }

    private void p() {
        if (this.O != 0) {
            if (ai.acV >= 26) {
                t();
            } else {
                s();
            }
            j(0);
        }
    }

    private int q() {
        return this.K.requestAudioFocus(this.L, ai.fM(((d) com.applovin.exoplayer2.l.a.checkNotNull(this.N)).jG), this.P);
    }

    private int r() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.R;
        if (audioFocusRequest == null || this.S) {
            if (audioFocusRequest == null) {
                g$$ExternalSyntheticApiModelOutline0.m();
                builder = g$$ExternalSyntheticApiModelOutline0.m(this.P);
            } else {
                g$$ExternalSyntheticApiModelOutline0.m();
                builder = g$$ExternalSyntheticApiModelOutline0.m(this.R);
            }
            this.R = builder.setAudioAttributes(((d) com.applovin.exoplayer2.l.a.checkNotNull(this.N)).dA()).setWillPauseWhenDucked(u()).setOnAudioFocusChangeListener(this.L).build();
            this.S = false;
        }
        return this.K.requestAudioFocus(this.R);
    }

    private void s() {
        this.K.abandonAudioFocus(this.L);
    }

    private void t() {
        AudioFocusRequest audioFocusRequest = this.R;
        if (audioFocusRequest != null) {
            int unused = this.K.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private boolean u() {
        d dVar = this.N;
        return dVar != null && dVar.jE == 1;
    }

    private static int b(d dVar) {
        if (dVar == null) {
            return 0;
        }
        switch (dVar.jG) {
            case 0:
                q.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (dVar.jE == 1) {
                    return 2;
                }
                break;
            case 16:
                if (ai.acV >= 19) {
                    return 4;
                }
                return 2;
            default:
                q.h("AudioFocusManager", "Unidentified audio usage: " + dVar.jG);
                return 0;
        }
        return 3;
    }

    private void j(int i) {
        if (this.O != i) {
            this.O = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.Q != f) {
                this.Q = f;
                b bVar = this.M;
                if (bVar != null) {
                    bVar.b(f);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void k(int i) {
        if (i == -3 || i == -2) {
            if (i == -2 || u()) {
                l(0);
                j(2);
                return;
            }
            j(3);
        } else if (i == -1) {
            l(-1);
            p();
        } else if (i != 1) {
            q.h("AudioFocusManager", "Unknown focus change type: " + i);
        } else {
            j(1);
            l(1);
        }
    }

    private void l(int i) {
        b bVar = this.M;
        if (bVar != null) {
            bVar.l(i);
        }
    }

    private class a implements AudioManager.OnAudioFocusChangeListener {
        private final Handler I;

        public a(Handler handler) {
            this.I = handler;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(int i) {
            c.this.k(i);
        }

        public void onAudioFocusChange(int i) {
            this.I.post(new c$a$$ExternalSyntheticLambda0(this, i));
        }
    }
}
