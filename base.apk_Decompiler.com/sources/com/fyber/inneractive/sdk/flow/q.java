package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.config.y;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.web.r;

public abstract class q<T extends e> {
    public InneractiveAdRequest a;
    public T b;
    public s c;
    public final b0 d;
    public boolean e = false;
    public boolean f = false;

    public q(b0 b0Var, s sVar) {
        this.d = b0Var;
        this.c = sVar;
    }

    public abstract void a();

    public void a(InneractiveAdRequest inneractiveAdRequest) {
        this.a = inneractiveAdRequest;
    }

    public void a(T t) {
        this.b = t;
    }

    public void a(String str) {
    }

    public boolean a(boolean z, i iVar) {
        return false;
    }

    public s b() {
        return this.c;
    }

    public r c() {
        return null;
    }

    public T d() {
        return this.b;
    }

    public boolean e() {
        y yVar = ((a0) this.d).e;
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h() {
        return IAConfigManager.M.l || this.f;
    }

    public void i() {
    }

    public abstract boolean isVideoAd();
}
