package com.applovin.exoplayer2.l;

import java.util.Collections;
import java.util.PriorityQueue;

public final class aa {
    private final PriorityQueue<Integer> acK = new PriorityQueue<>(10, Collections.reverseOrder());
    private int acL = Integer.MIN_VALUE;
    private final Object rT = new Object();

    public void cR(int i) {
        synchronized (this.rT) {
            this.acK.add(Integer.valueOf(i));
            this.acL = Math.max(this.acL, i);
        }
    }

    public void fF(int i) {
        synchronized (this.rT) {
            this.acK.remove(Integer.valueOf(i));
            this.acL = this.acK.isEmpty() ? Integer.MIN_VALUE : ((Integer) ai.R(this.acK.peek())).intValue();
            this.rT.notifyAll();
        }
    }
}
