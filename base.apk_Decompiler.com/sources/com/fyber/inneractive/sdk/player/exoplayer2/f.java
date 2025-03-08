package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.h;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h;
import java.util.Iterator;

public class f extends Handler {
    public final /* synthetic */ g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar, Looper looper) {
        super(looper);
        this.a = gVar;
    }

    public void handleMessage(Message message) {
        g gVar = this.a;
        gVar.getClass();
        boolean z = true;
        switch (message.what) {
            case 0:
                gVar.m--;
                return;
            case 1:
                gVar.k = message.arg1;
                Iterator<e.a> it = gVar.f.iterator();
                while (it.hasNext()) {
                    it.next().a(gVar.j, gVar.k);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                gVar.n = z;
                Iterator<e.a> it2 = gVar.f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(gVar.n);
                }
                return;
            case 3:
                if (gVar.m == 0) {
                    h hVar = (h) message.obj;
                    gVar.i = true;
                    gVar.q = hVar.a;
                    gVar.r = hVar.b;
                    gVar.b.a(hVar.c);
                    Iterator<e.a> it3 = gVar.f.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(gVar.q, gVar.r);
                    }
                    return;
                }
                return;
            case 4:
                int i = gVar.l - 1;
                gVar.l = i;
                if (i == 0) {
                    gVar.t = (h.b) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<e.a> it4 = gVar.f.iterator();
                        while (it4.hasNext()) {
                            it4.next().a();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (gVar.l == 0) {
                    gVar.t = (h.b) message.obj;
                    Iterator<e.a> it5 = gVar.f.iterator();
                    while (it5.hasNext()) {
                        it5.next().a();
                    }
                    return;
                }
                return;
            case 6:
                h.d dVar = (h.d) message.obj;
                gVar.l -= dVar.d;
                if (gVar.m == 0) {
                    gVar.o = dVar.a;
                    gVar.p = dVar.b;
                    gVar.t = dVar.c;
                    Iterator<e.a> it6 = gVar.f.iterator();
                    while (it6.hasNext()) {
                        it6.next().a(gVar.o, gVar.p);
                    }
                    return;
                }
                return;
            case 7:
                m mVar = (m) message.obj;
                if (!gVar.s.equals(mVar)) {
                    gVar.s = mVar;
                    Iterator<e.a> it7 = gVar.f.iterator();
                    while (it7.hasNext()) {
                        it7.next().a(mVar);
                    }
                    return;
                }
                return;
            case 8:
                d dVar2 = (d) message.obj;
                Iterator<e.a> it8 = gVar.f.iterator();
                while (it8.hasNext()) {
                    it8.next().a(dVar2);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
