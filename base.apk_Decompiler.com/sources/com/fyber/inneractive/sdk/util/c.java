package com.fyber.inneractive.sdk.util;

import java.util.concurrent.RejectedExecutionException;

public class c implements Runnable {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ b b;

    public c(b bVar, Object[] objArr) {
        this.b = bVar;
        this.a = objArr;
    }

    public void run() {
        this.b.getClass();
        b bVar = this.b;
        boolean z = bVar.f;
        if (!z) {
            d dVar = new d(bVar, this.a);
            bVar.d = dVar;
            if (!z) {
                try {
                    bVar.a.execute(dVar);
                } catch (RejectedExecutionException e) {
                    IAlog.e("AsyncTaskExecutor : execute(): Unable to execute the task: %s", e.getMessage());
                } catch (NullPointerException e2) {
                    IAlog.e("AsyncTaskExecutor : execute(): Unable to execute the null task: %s", e2.getMessage());
                }
            }
        }
    }
}
