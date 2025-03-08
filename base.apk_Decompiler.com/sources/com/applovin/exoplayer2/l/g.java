package com.applovin.exoplayer2.l;

public class g {
    private boolean abQ;
    private final d bR;

    public g() {
        this(d.abJ);
    }

    public g(d dVar) {
        this.bR = dVar;
    }

    public synchronized boolean oN() {
        if (this.abQ) {
            return false;
        }
        this.abQ = true;
        notifyAll();
        return true;
    }

    public synchronized boolean oO() {
        boolean z;
        z = this.abQ;
        this.abQ = false;
        return z;
    }

    public synchronized void oP() throws InterruptedException {
        while (!this.abQ) {
            wait();
        }
    }

    public synchronized void oQ() {
        boolean z = false;
        while (!this.abQ) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean hB() {
        return this.abQ;
    }
}
