package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

class z {
    private final Queue<AppLovinAdImpl> aFu = new LinkedList();
    private final Object aFv = new Object();

    z() {
    }

    /* access modifiers changed from: package-private */
    public int Fq() {
        int size;
        synchronized (this.aFv) {
            size = this.aFu.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        boolean z;
        synchronized (this.aFv) {
            z = Fq() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void c(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.aFv) {
            if (Fq() <= 25) {
                this.aFu.offer(appLovinAdImpl);
            } else {
                x.H("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl Fr() {
        AppLovinAdImpl poll;
        synchronized (this.aFv) {
            poll = !isEmpty() ? this.aFu.poll() : null;
        }
        return poll;
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl Fs() {
        AppLovinAdImpl peek;
        synchronized (this.aFv) {
            peek = this.aFu.peek();
        }
        return peek;
    }

    /* access modifiers changed from: package-private */
    public void d(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.aFv) {
            this.aFu.remove(appLovinAdImpl);
        }
    }
}
