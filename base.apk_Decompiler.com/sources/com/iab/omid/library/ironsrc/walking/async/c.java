package com.iab.omid.library.ironsrc.walking.async;

import com.iab.omid.library.ironsrc.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {
    private final BlockingQueue<Runnable> a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque<b> c = new ArrayDeque<>();
    private b d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b poll = this.c.poll();
        this.d = poll;
        if (poll != null) {
            poll.a(this.b);
        }
    }

    public void a(b bVar) {
        this.d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a((b.a) this);
        this.c.add(bVar);
        if (this.d == null) {
            a();
        }
    }
}
