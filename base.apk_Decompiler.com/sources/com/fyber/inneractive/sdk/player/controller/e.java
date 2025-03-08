package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.player.ui.l;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p0;

public class e extends n<w> {
    public boolean C;
    public boolean D = false;
    public boolean E;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c cVar, l lVar, b0 b0Var, s sVar, boolean z, boolean z2, Skip skip, boolean z3, String str, boolean z4) {
        super(cVar, lVar, b0Var, sVar, z2, skip, str, z4);
        this.C = z;
        this.E = z3;
    }

    public static boolean d(int i) {
        return i > -1 && i <= 8;
    }

    public void A() {
        super.A();
        this.d.b(false);
        if (this.C) {
            this.d.i();
        }
    }

    public boolean B() {
        return !this.C;
    }

    public void D() {
        g gVar;
        super.D();
        c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null && gVar.e.equals(b.Completed) && this.C) {
            this.d.i();
        }
    }

    public void a(boolean z) {
        c cVar;
        g gVar;
        if (z && (cVar = this.a) != null && (gVar = cVar.b) != null && !gVar.e.equals(b.Completed) && !this.d.f()) {
            h(false);
        }
        super.a(z);
    }

    public void b() {
        if (this.h) {
            v();
        } else {
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r3 = (r3 = r3.b).e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(boolean r3) {
        /*
            r2 = this;
            super.d((boolean) r3)
            boolean r3 = r2.C
            r0 = 0
            if (r3 == 0) goto L_0x0014
            com.fyber.inneractive.sdk.player.ui.l r3 = r2.d
            r3.i()
            com.fyber.inneractive.sdk.player.ui.l r3 = r2.d
            r3.d((boolean) r0)
            r2.f = r0
        L_0x0014:
            r2.C()
            com.fyber.inneractive.sdk.player.c r3 = r2.a
            if (r3 == 0) goto L_0x002c
            com.fyber.inneractive.sdk.player.controller.g r3 = r3.b
            if (r3 != 0) goto L_0x0020
            goto L_0x002c
        L_0x0020:
            com.fyber.inneractive.sdk.player.enums.b r3 = r3.e
            com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Preparing
            if (r3 == r1) goto L_0x002a
            com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Prepared
            if (r3 != r1) goto L_0x002c
        L_0x002a:
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            com.fyber.inneractive.sdk.player.ui.l r1 = r2.d
            r1.b((boolean) r3)
            com.fyber.inneractive.sdk.player.ui.l r3 = r2.d
            r3.c((boolean) r0)
            com.fyber.inneractive.sdk.player.ui.l r3 = r2.d
            com.fyber.inneractive.sdk.player.ui.c r1 = new com.fyber.inneractive.sdk.player.ui.c
            r1.<init>()
            r1.b = r0
            com.fyber.inneractive.sdk.player.ui.b r0 = new com.fyber.inneractive.sdk.player.ui.b
            r0.<init>(r1)
            r3.d((com.fyber.inneractive.sdk.player.ui.b) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.e.d(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k() {
        /*
            r7 = this;
            super.k()
            com.fyber.inneractive.sdk.player.c r0 = r7.a
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x006f
            com.fyber.inneractive.sdk.player.controller.g r0 = r0.b
            if (r0 == 0) goto L_0x006f
            boolean r0 = r7.D
            if (r0 == 0) goto L_0x0012
            goto L_0x006f
        L_0x0012:
            r0 = 2
            com.fyber.inneractive.sdk.player.ui.l r3 = r7.d     // Catch:{ all -> 0x002c }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x002c }
            java.lang.String r4 = "audio"
            java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ all -> 0x002c }
            android.media.AudioManager r3 = (android.media.AudioManager) r3     // Catch:{ all -> 0x002c }
            int r4 = r3.getRingerMode()     // Catch:{ all -> 0x002c }
            int r3 = r3.getStreamVolume(r0)     // Catch:{ all -> 0x002a }
            goto L_0x002f
        L_0x002a:
            goto L_0x002e
        L_0x002c:
            r4 = 0
        L_0x002e:
            r3 = 0
        L_0x002f:
            boolean r5 = r7.C
            if (r5 != 0) goto L_0x0042
            com.fyber.inneractive.sdk.config.b0 r5 = r7.b
            com.fyber.inneractive.sdk.config.a0 r5 = (com.fyber.inneractive.sdk.config.a0) r5
            com.fyber.inneractive.sdk.config.c0 r5 = r5.f
            java.lang.Boolean r5 = r5.d
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0042
            goto L_0x0052
        L_0x0042:
            boolean r5 = r7.E
            if (r5 == 0) goto L_0x0056
            com.fyber.inneractive.sdk.config.b0 r5 = r7.b
            com.fyber.inneractive.sdk.config.a0 r5 = (com.fyber.inneractive.sdk.config.a0) r5
            com.fyber.inneractive.sdk.config.c0 r5 = r5.f
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r5 = r5.j
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r6 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r5 == r6) goto L_0x0056
        L_0x0052:
            r7.g(r2)
            goto L_0x006a
        L_0x0056:
            if (r3 <= 0) goto L_0x006a
            if (r4 != r0) goto L_0x006a
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r3 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r7)
            r0[r2] = r3
            java.lang.String r3 = "%s setting default volume. unmuting player"
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r0)
            r7.i(r2)
        L_0x006a:
            r7.E()
            r7.D = r1
        L_0x006f:
            r7.h(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.e.k():boolean");
    }

    public int o() {
        return IAConfigManager.M.u.b.a("VideoFullscreenBufferingTimeout", 12, 1) * 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int s() {
        /*
            r8 = this;
            com.fyber.inneractive.sdk.config.global.features.b r0 = r8.p()
            r1 = -1
            if (r0 == 0) goto L_0x000c
            int r0 = r0.d()
            goto L_0x000d
        L_0x000c:
            r0 = -1
        L_0x000d:
            com.fyber.inneractive.sdk.config.IAConfigManager r2 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.j r2 = r2.u
            com.fyber.inneractive.sdk.config.i r2 = r2.b
            com.fyber.inneractive.sdk.config.b0 r3 = r8.b
            com.fyber.inneractive.sdk.config.enums.Skip r4 = r8.A
            boolean r5 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
            java.lang.String r6 = "vast_configuration"
            com.fyber.inneractive.sdk.config.g r2 = r2.a((java.lang.String) r6)
            java.lang.String r6 = "skip_d"
            r2.getClass()
            java.util.Map<java.lang.String, java.lang.String> r7 = r2.a     // Catch:{ Exception -> 0x003b }
            boolean r7 = r7.containsKey(r6)     // Catch:{ Exception -> 0x003b }
            if (r7 == 0) goto L_0x003c
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.a     // Catch:{ Exception -> 0x003b }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x003b }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x003d
        L_0x003b:
        L_0x003c:
            r2 = -1
        L_0x003d:
            int r2 = java.lang.Math.max(r2, r1)
            if (r4 != 0) goto L_0x004d
            if (r3 == 0) goto L_0x004d
            com.fyber.inneractive.sdk.config.a0 r3 = (com.fyber.inneractive.sdk.config.a0) r3
            com.fyber.inneractive.sdk.config.c0 r3 = r3.f
            if (r3 == 0) goto L_0x004d
            com.fyber.inneractive.sdk.config.enums.Skip r4 = r3.h
        L_0x004d:
            r3 = 5
            if (r5 == 0) goto L_0x0077
            boolean r1 = d((int) r0)
            if (r1 == 0) goto L_0x0057
            goto L_0x008d
        L_0x0057:
            boolean r0 = d((int) r2)
            if (r0 == 0) goto L_0x005e
            goto L_0x007b
        L_0x005e:
            java.lang.Integer r0 = r4.value()
            int r0 = r0.intValue()
            boolean r0 = d((int) r0)
            if (r0 == 0) goto L_0x0075
            java.lang.Integer r0 = r4.value()
            int r0 = r0.intValue()
            goto L_0x008d
        L_0x0075:
            r0 = 5
            goto L_0x008d
        L_0x0077:
            if (r2 <= r1) goto L_0x007d
            if (r2 > r3) goto L_0x007d
        L_0x007b:
            r0 = r2
            goto L_0x008d
        L_0x007d:
            com.fyber.inneractive.sdk.config.enums.Skip r0 = com.fyber.inneractive.sdk.config.enums.Skip.DEFAULT
            if (r4 != r0) goto L_0x0085
            r0 = 99999(0x1869f, float:1.40128E-40)
            goto L_0x008d
        L_0x0085:
            java.lang.Integer r0 = r4.value()
            int r0 = r0.intValue()
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.e.s():int");
    }

    public void u() {
        this.u = true;
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a((Object) this));
        c(false);
    }

    public void w() {
        ListenerT listenert = this.g;
        if (listenert != null) {
            listenert.k();
        }
    }

    public void y() {
        this.d.d(true);
        C();
        n();
        k();
        h(true);
    }

    public void a(p0 p0Var) {
        r.b bVar;
        TapAction tapAction = ((a0) this.b).f.i;
        if (tapAction == TapAction.CTR) {
            a(false, VideoClickOrigin.VIDEO, p0Var);
        } else if (tapAction == TapAction.FULLSCREEN || tapAction == TapAction.DO_NOTHING) {
            r rVar = (r) this.c.a(r.class);
            rVar.getClass();
            String a = rVar.a("click_action", r.e.mKey);
            r.b[] values = r.b.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bVar = r.b.NONE;
                    break;
                }
                bVar = values[i];
                if (a.equalsIgnoreCase(bVar.mKey)) {
                    break;
                }
                i++;
            }
            if (bVar.equals(r.b.OPEN) || (this.w != k.NONE && IAConfigManager.M.E.d())) {
                a(false, VideoClickOrigin.VIDEO, p0Var);
            }
        } else {
            IAlog.a("% sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a((Object) this), tapAction);
        }
    }
}
