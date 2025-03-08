package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.b;

public interface w {
    b0.a a(p0 p0Var, i iVar);

    b0.a a(String str, p0 p0Var, b.a aVar, boolean z);

    void a(View view, String str);

    void a(String str, String str2);

    void a(boolean z);

    void a(boolean z, Orientation orientation);

    void e();

    void g();

    void h();

    void j();

    void k();

    void l();

    void onCompleted();

    void onPlayerError();

    void onProgress(int i, int i2);

    k q();

    void s();
}
