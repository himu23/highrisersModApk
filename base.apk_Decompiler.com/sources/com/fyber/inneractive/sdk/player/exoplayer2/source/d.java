package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;

public class d implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ IOException d;
    public final /* synthetic */ f.a e;

    public d(f.a aVar, j jVar, int i, int i2, i iVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        this.e = aVar;
        this.a = obj;
        this.b = j;
        this.c = j2;
        this.d = iOException;
    }

    public void run() {
        f.a aVar = this.e;
        f fVar = aVar.b;
        f.a.a(aVar, this.b);
        f.a.a(this.e, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadError called. with exception %s", ((u) fVar).b(), this.d);
    }
}
