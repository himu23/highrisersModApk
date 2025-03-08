package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.player.cache.d;
import com.fyber.inneractive.sdk.player.cache.h;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.g;
import com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.k;
import com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Iterator;
import java.util.List;

public class d extends g implements d.b, d.c {
    public boolean A;
    public final boolean B;
    public Bitmap C;
    public int D;
    public String E;
    public final List<h> F;
    public n G;
    public boolean H;
    public int I;
    public final int p;
    public final s q;
    public final int r;
    public e s;
    public int t = 0;
    public int u = 0;
    public boolean v = false;
    public Surface w;
    public com.fyber.inneractive.sdk.player.exoplayer2.n[] x;
    public Handler y;
    public u z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar = d.this.s;
            if (eVar != null) {
                g gVar = (g) eVar;
                gVar.a(gVar.a(), -9223372036854775807L);
                ((g) d.this.s).e.f.sendEmptyMessage(5);
                ((g) d.this.s).b();
                d.this.s = null;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r6v9, types: [com.fyber.inneractive.sdk.config.global.features.g] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r5, boolean r6, com.fyber.inneractive.sdk.config.global.s r7) {
        /*
            r4 = this;
            r4.<init>(r5)
            r5 = 0
            r4.t = r5
            r4.u = r5
            r4.v = r5
            r0 = 0
            r4.w = r0
            r4.A = r5
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r1.<init>()
            r4.F = r1
            r4.G = r0
            r4.I = r5
            r4.B = r6
            r4.q = r7
            com.fyber.inneractive.sdk.config.j r6 = com.fyber.inneractive.sdk.config.IAConfigManager.c()
            com.fyber.inneractive.sdk.config.i r6 = r6.a()
            r1 = 6
            r2 = 3
            java.lang.String r3 = "extractor_source_retry_count"
            int r6 = r6.a(r3, r1, r2)
            r4.r = r6
            if (r7 != 0) goto L_0x0033
            goto L_0x003c
        L_0x0033:
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r6 = com.fyber.inneractive.sdk.config.global.features.r.class
            com.fyber.inneractive.sdk.config.global.features.g r6 = r7.a(r6)
            r0 = r6
            com.fyber.inneractive.sdk.config.global.features.r r0 = (com.fyber.inneractive.sdk.config.global.features.r) r0
        L_0x003c:
            if (r0 != 0) goto L_0x0040
            r6 = 0
            goto L_0x0044
        L_0x0040:
            int r6 = r0.g()
        L_0x0044:
            r4.p = r6
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "Creating IAExoPlayer2Controller"
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.d.<init>(android.content.Context, boolean, com.fyber.inneractive.sdk.config.global.s):void");
    }

    public boolean a() {
        return this.B;
    }

    public void b(boolean z2) {
        e eVar;
        c(true);
        this.n = z2;
        com.fyber.inneractive.sdk.player.exoplayer2.n[] nVarArr = this.x;
        if (nVarArr != null && (eVar = this.s) != null && !this.A && nVarArr.length >= 2) {
            ((g) eVar).a(new e.c(nVarArr[1], 2, Float.valueOf(0.0f)));
            this.v = true;
        }
    }

    public void d(boolean z2) {
        c(false);
        this.n = z2;
        if (this.s != null && !this.A) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            float f = ((float) streamVolume) / ((float) streamMaxVolume);
            IAlog.a(" unmute maxVolume = %d currentVolume = %d targetVolume = %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
            if (f == 0.0f) {
                f = 0.1f;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.n[] nVarArr = this.x;
            if (nVarArr != null && nVarArr.length >= 2) {
                e eVar = this.s;
                ((g) eVar).a(new e.c(nVarArr[1], 2, Float.valueOf(f)));
            }
            this.v = false;
        }
    }

    public Bitmap e() {
        return this.C;
    }

    public String f() {
        return this.B ? "exo_c" : "exo";
    }

    public int g() {
        return this.u;
    }

    public int h() {
        return this.t;
    }

    public boolean i() {
        return this.v;
    }

    public void k() {
        b bVar;
        b bVar2 = this.e;
        if (bVar2 == b.Idle || bVar2 == b.Completed || bVar2 == (bVar = b.Paused) || bVar2 == b.Prepared) {
            IAlog.a("%s paused called when player is in mState: %s ignoring", IAlog.a((Object) this), bVar2);
            return;
        }
        e eVar = this.s;
        if (eVar != null && !this.A) {
            ((g) eVar).a(false);
        }
        m();
        a(bVar);
    }

    public void a(int i, boolean z2) {
        IAlog.a("%sseekTo called with %d playAfterSeek = %s", IAlog.a((Object) this), Integer.valueOf(i), Boolean.valueOf(z2));
        e eVar = this.s;
        if (eVar != null && !this.A) {
            ((g) eVar).a(z2);
            g gVar = (g) this.s;
            gVar.a(gVar.a(), (long) i);
        }
    }

    public int c() {
        long j;
        e eVar = this.s;
        if (eVar == null || this.A) {
            return 0;
        }
        g gVar = (g) eVar;
        if (gVar.o.c() || gVar.l > 0) {
            j = gVar.v;
        } else {
            gVar.o.a(gVar.t.a, gVar.h, false);
            j = com.fyber.inneractive.sdk.player.exoplayer2.b.b(gVar.h.e) + com.fyber.inneractive.sdk.player.exoplayer2.b.b(gVar.t.c);
        }
        return (int) j;
    }

    public boolean j() {
        return this.s != null && !this.A && this.e == b.Playing;
    }

    public void l() {
        IAlog.a("%sstart called", IAlog.a((Object) this));
        if (!j()) {
            a(b.Start_in_progress);
            ((g) this.s).a(true);
        }
    }

    public void a(Surface surface) {
        e eVar;
        IAlog.a("%ssetSurface called with %s", IAlog.a((Object) this), surface);
        this.w = surface;
        com.fyber.inneractive.sdk.player.exoplayer2.n[] nVarArr = this.x;
        if (nVarArr != null && (eVar = this.s) != null && !this.A) {
            ((g) eVar).a(new e.c(nVarArr[0], 1, surface));
        }
    }

    public void b() {
        if (this.s != null) {
            if (!this.A) {
                this.A = true;
                q.a(new a());
            }
            u uVar = this.z;
            if (uVar != null) {
                uVar.a.clear();
            }
            this.z = null;
        }
        for (h next : this.F) {
            next.a(next.o);
            com.fyber.inneractive.sdk.player.cache.n nVar = com.fyber.inneractive.sdk.player.cache.n.f;
            nVar.d.remove(next.a());
        }
        this.F.clear();
        super.b();
    }

    public void a(boolean z2) {
        boolean z3 = z2;
        if (this.s == null && !this.A) {
            this.H = z3;
            IAlog.a("%sMediaPlayerController: creating media player", IAlog.a((Object) this));
            u uVar = this.z;
            if (uVar != null) {
                uVar.a.clear();
            }
            this.z = new u(this);
            this.y = new Handler(Looper.getMainLooper());
            com.fyber.inneractive.sdk.player.exoplayer2.n[] nVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.n[(z3 ? 2 : 1)];
            this.x = nVarArr;
            Context context = this.a;
            c cVar = c.a;
            nVarArr[0] = new MediaCodecVideoRenderer(context, cVar, 5000, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d>) null, false, this.y, this.z, -1);
            if (z3) {
                this.x[1] = new MediaCodecAudioRenderer(cVar, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d>) null, true, (Handler) null, (AudioRendererEventListener) null);
            }
            g gVar = new g(this.x, new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b((e.a) null), new com.fyber.inneractive.sdk.player.exoplayer2.c(new k(true, 65536, 0), 15000, 30000, 2500, 5000));
            this.s = gVar;
            gVar.f.add(this.z);
        }
    }

    public int d() {
        long j;
        com.fyber.inneractive.sdk.player.exoplayer2.e eVar = this.s;
        if (eVar == null || this.A) {
            return 0;
        }
        g gVar = (g) eVar;
        if (gVar.o.c()) {
            j = -9223372036854775807L;
        } else {
            j = com.fyber.inneractive.sdk.player.exoplayer2.b.b(gVar.o.a(gVar.a(), gVar.g).f);
        }
        return (int) j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e} */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.fyber.inneractive.sdk.player.exoplayer2.source.n] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.fyber.inneractive.sdk.player.cache.e] */
    /* JADX WARNING: type inference failed for: r8v2, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h] */
    /* JADX WARNING: type inference failed for: r8v3, types: [com.fyber.inneractive.sdk.player.exoplayer2.source.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            com.fyber.inneractive.sdk.player.exoplayer2.e r3 = r0.s
            if (r3 == 0) goto L_0x00fd
            boolean r3 = r0.A
            if (r3 != 0) goto L_0x00fd
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r23)
            r6 = 0
            r4[r6] = r5
            r5 = 1
            r4[r5] = r1
            java.lang.String r7 = "%sloadMediaPlayerUri called with %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r4)
            r0.E = r1
            r0.D = r2
            android.net.Uri r9 = android.net.Uri.parse(r24)
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            java.lang.String r1 = r9.getPath()
            if (r1 != 0) goto L_0x0031
            goto L_0x0069
        L_0x0031:
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r4 = ".mpd"
            boolean r4 = r1.endsWith(r4)
            if (r4 == 0) goto L_0x003e
            goto L_0x006c
        L_0x003e:
            java.lang.String r4 = ".m3u8"
            boolean r4 = r1.endsWith(r4)
            if (r4 == 0) goto L_0x0048
            r6 = 2
            goto L_0x006c
        L_0x0048:
            java.lang.String r4 = ".ism"
            boolean r4 = r1.endsWith(r4)
            if (r4 != 0) goto L_0x006b
            java.lang.String r4 = ".isml"
            boolean r4 = r1.endsWith(r4)
            if (r4 != 0) goto L_0x006b
            java.lang.String r4 = ".ism/manifest"
            boolean r4 = r1.endsWith(r4)
            if (r4 != 0) goto L_0x006b
            java.lang.String r4 = ".isml/manifest"
            boolean r1 = r1.endsWith(r4)
            if (r1 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r6 = 3
            goto L_0x006c
        L_0x006b:
            r6 = 1
        L_0x006c:
            boolean r1 = r0.B
            if (r1 == 0) goto L_0x0082
            com.fyber.inneractive.sdk.player.cache.n r1 = com.fyber.inneractive.sdk.player.cache.n.f
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0082
            if (r6 == r3) goto L_0x0082
            com.fyber.inneractive.sdk.player.cache.e r1 = new com.fyber.inneractive.sdk.player.cache.e
            com.fyber.inneractive.sdk.config.global.s r4 = r0.q
            r1.<init>(r0, r0, r2, r4)
            goto L_0x00d5
        L_0x0082:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.l
            r2 = 0
            r1.<init>(r2, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.p r4 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.p
            com.fyber.inneractive.sdk.config.IAConfigManager r5 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.util.z0 r5 = r5.y
            java.lang.String r11 = r5.a()
            r13 = 2000(0x7d0, float:2.803E-42)
            r14 = 2000(0x7d0, float:2.803E-42)
            r15 = 1
            r10 = r4
            r12 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.n r5 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.n
            android.content.Context r7 = r0.a
            r5.<init>(r7, r1, r4)
            android.content.Context r1 = r0.a
            java.lang.String r4 = "ia-vid-cache-ex2"
            java.io.File r1 = com.fyber.inneractive.sdk.player.cache.n.a((android.content.Context) r1, (java.lang.String) r4)
            if (r1 == 0) goto L_0x00d7
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.j r4 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.j
            r7 = 10485760(0xa00000, double:5.180654E-317)
            r4.<init>(r7)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.k r10 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.k
            r10.<init>(r1, r4, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e r1 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.r r19 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.r
            r19.<init>()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c r2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c
            r2.<init>(r10, r7)
            r21 = 2
            r22 = 0
            r16 = r1
            r17 = r10
            r18 = r5
            r20 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22)
        L_0x00d5:
            r10 = r1
            goto L_0x00d8
        L_0x00d7:
            r10 = r5
        L_0x00d8:
            if (r6 == r3) goto L_0x00ed
            com.fyber.inneractive.sdk.player.exoplayer2.source.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.source.l
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.c r11 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.c
            r11.<init>()
            int r12 = r0.r
            android.os.Handler r13 = r0.y
            com.fyber.inneractive.sdk.player.controller.u r14 = r0.z
            r15 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x00f8
        L_0x00ed:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h
            android.os.Handler r12 = r0.y
            com.fyber.inneractive.sdk.player.controller.u r13 = r0.z
            r11 = 3
            r8 = r1
            r8.<init>((android.net.Uri) r9, (com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a) r10, (int) r11, (android.os.Handler) r12, (com.fyber.inneractive.sdk.player.exoplayer2.source.f) r13)
        L_0x00f8:
            r0.G = r1
            r0.a((com.fyber.inneractive.sdk.player.exoplayer2.source.n) r1)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.d.a(java.lang.String, int):void");
    }

    public final void a(n nVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.e eVar = this.s;
        if (eVar != null && nVar != null) {
            g gVar = (g) eVar;
            if (!gVar.o.c() || gVar.p != null) {
                gVar.o = p.a;
                gVar.p = null;
                Iterator<e.a> it = gVar.f.iterator();
                while (it.hasNext()) {
                    it.next().a(gVar.o, gVar.p);
                }
            }
            if (gVar.i) {
                gVar.i = false;
                gVar.q = com.fyber.inneractive.sdk.player.exoplayer2.source.s.d;
                gVar.r = gVar.c;
                gVar.b.a((Object) null);
                Iterator<e.a> it2 = gVar.f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(gVar.q, gVar.r);
                }
            }
            gVar.m++;
            gVar.e.f.obtainMessage(0, 1, 0, nVar).sendToTarget();
            a(b.Preparing);
        }
    }
}
