package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.cache.d;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.w;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class j {
    public final Context a;
    public i b = new i();
    public List<b> c = new CopyOnWriteArrayList();
    public boolean d = false;
    public final d e = new d();

    public class a implements w<i> {
        public a() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            i iVar = (i) obj;
            if (iVar != null) {
                j jVar = j.this;
                jVar.getClass();
                if (!iVar.equals(jVar.b)) {
                    jVar.d = true;
                    jVar.b = iVar;
                    for (b onGlobalConfigChanged : jVar.c) {
                        onGlobalConfigChanged.onGlobalConfigChanged(jVar, jVar.b);
                    }
                }
            }
        }
    }

    public interface b {
        void onGlobalConfigChanged(j jVar, i iVar);
    }

    public j(Context context) {
        this.a = context;
    }

    public i a() {
        return this.b;
    }

    public void b() {
        g0 g0Var = new g0(new a(), this.a, this.e);
        IAConfigManager.M.s.a.offer(g0Var);
        g0Var.a(r0.QUEUED);
    }
}
