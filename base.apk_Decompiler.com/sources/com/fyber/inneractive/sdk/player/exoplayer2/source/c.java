package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.util.IAlog;

public class c implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ f.a d;

    public c(f.a aVar, j jVar, int i, int i2, i iVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.d = aVar;
        this.a = obj;
        this.b = j;
        this.c = j2;
    }

    public void run() {
        f.a aVar = this.d;
        f fVar = aVar.b;
        f.a.a(aVar, this.b);
        f.a.a(this.d, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadCanceled called.", ((u) fVar).b());
    }
}
