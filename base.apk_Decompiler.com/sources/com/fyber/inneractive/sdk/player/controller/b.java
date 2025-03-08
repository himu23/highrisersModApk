package com.fyber.inneractive.sdk.player.controller;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.flow.vast.e;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.player.controller.w;

public interface b<ListenerT extends w> {
    void a(long j);

    void a(Bitmap bitmap);

    void a(h hVar, int i);

    void a(c cVar);

    void a(ListenerT listenert);

    void b(int i);

    e c();

    void c(boolean z);

    void d(boolean z);

    boolean d();

    void destroy();

    boolean e();

    void h();

    void pauseVideo();
}
