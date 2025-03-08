package com.fyber.inneractive.sdk.player.exoplayer2;

import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f;

public interface e {

    public interface a {
        void a();

        void a(d dVar);

        void a(m mVar);

        void a(p pVar, Object obj);

        void a(s sVar, f fVar);

        void a(boolean z);

        void a(boolean z, int i);
    }

    public interface b {
        void a(int i, Object obj) throws d;
    }

    public static final class c {
        public final b a;
        public final int b;
        public final Object c;

        public c(b bVar, int i, Object obj) {
            this.a = bVar;
            this.b = i;
            this.c = obj;
        }
    }
}
