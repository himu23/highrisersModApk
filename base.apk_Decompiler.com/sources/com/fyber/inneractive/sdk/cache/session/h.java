package com.fyber.inneractive.sdk.cache.session;

import java.util.PriorityQueue;

public class h extends PriorityQueue<e> {
    public int a;

    public h(int i) {
        super(1, new i());
        this.a = i;
    }

    /* renamed from: a */
    public boolean add(e eVar) {
        boolean add = super.add(eVar);
        if (super.size() > this.a) {
            poll();
        }
        return add;
    }

    public int size() {
        return super.size();
    }
}
