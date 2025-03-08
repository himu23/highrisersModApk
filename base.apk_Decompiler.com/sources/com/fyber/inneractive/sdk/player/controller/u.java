package com.fyber.inneractive.sdk.player.controller;

import android.view.Surface;
import com.fyber.inneractive.sdk.player.cache.n;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.c;
import com.fyber.inneractive.sdk.player.exoplayer2.d;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.g;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.l;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;
import com.fyber.inneractive.sdk.player.mediaplayer.a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.WeakReference;

public class u implements l.a, VideoRendererEventListener, e.a, f {
    public final WeakReference<d> a;
    public boolean b = false;

    public u(d dVar) {
        this.a = new WeakReference<>(dVar);
    }

    public void a() {
    }

    public void a(m mVar) {
    }

    public void a(p pVar, Object obj) {
    }

    public void a(s sVar, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f fVar) {
    }

    public void a(boolean z) {
    }

    public void a(boolean z, int i) {
        e eVar;
        i iVar;
        IAlog.a("%sonPlayerStateChanged called with pwr = %s state = %d", b(), Boolean.valueOf(z), Integer.valueOf(i));
        d dVar = (d) this.a.get();
        if (dVar != null && (eVar = dVar.s) != null && !dVar.A) {
            if (i == 3) {
                if (z) {
                    dVar.a(b.Playing);
                } else if (dVar.e == b.Preparing) {
                    if (eVar != null) {
                        g gVar = (g) eVar;
                        if (gVar.r != null && gVar.r.a > 0) {
                            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar2 = gVar.r.b[0];
                            if (eVar2 == null) {
                                iVar = null;
                            } else {
                                iVar = eVar2.c();
                            }
                            if (iVar != null) {
                                int i2 = iVar.j;
                                int i3 = iVar.k;
                                dVar.t = i2;
                                dVar.u = i3;
                            }
                        }
                    }
                    this.b = true;
                    dVar.a(b.Prepared);
                }
            } else if (i == 2) {
                if (dVar.e == b.Playing) {
                    dVar.a(b.Buffering);
                }
            } else if (i == 4) {
                dVar.a(b.Completed);
            }
        }
    }

    public final String b() {
        d dVar = (d) this.a.get();
        if (dVar == null) {
            return u.class.getName();
        }
        return IAlog.a((Object) dVar);
    }

    public void onDroppedFrames(int i, long j) {
    }

    public void onRenderedFirstFrame(Surface surface) {
    }

    public void onVideoDecoderInitialized(String str, long j, long j2) {
    }

    public void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    public void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    public void onVideoInputFormatChanged(i iVar) {
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        d dVar = (d) this.a.get();
        if (dVar != null) {
            dVar.t = i;
            dVar.u = i2;
        }
    }

    public void a(d dVar) {
        String str;
        d dVar2 = (d) this.a.get();
        if (dVar2 != null && (dVar.getCause() instanceof c.e) && (this.b || (dVar2.H && dVar2.B))) {
            dVar2.v = true;
            e eVar = dVar2.s;
            if (eVar != null) {
                ((g) eVar).b();
                dVar2.s = null;
            }
            dVar2.a(false);
            dVar2.a(dVar2.G);
            dVar2.i.post(new h(dVar2, false));
        } else if (dVar2 == null || !dVar2.B || this.b || !n.f.a() || dVar2.I >= dVar2.p) {
            if (dVar.getCause() == null) {
                str = "empty";
            } else {
                str = dVar.getCause().getMessage();
            }
            a.l lVar = new a.l(dVar, str);
            IAlog.a("%sonPlayerError called with %s for sendErrorState", b(), lVar);
            d dVar3 = (d) com.fyber.inneractive.sdk.util.u.a(this.a);
            if (dVar3 != null) {
                dVar3.a((Exception) lVar);
            }
        } else {
            e eVar2 = dVar2.s;
            if (eVar2 != null) {
                ((g) eVar2).b();
                dVar2.s = null;
            }
            dVar2.a(true);
            dVar2.a(dVar2.G);
            dVar2.I++;
            dVar2.i.post(new h(dVar2, true));
        }
    }
}
