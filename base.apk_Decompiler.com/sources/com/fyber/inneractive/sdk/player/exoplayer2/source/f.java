package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.os.Handler;
import com.fyber.inneractive.sdk.player.exoplayer2.b;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import java.io.IOException;

public interface f {

    public static final class a {
        public final Handler a;
        public final f b;
        public final long c;

        public a(Handler handler, f fVar) {
            this(handler, fVar, 0);
        }

        public static long a(a aVar, long j) {
            aVar.getClass();
            long b2 = b.b(j);
            if (b2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return aVar.c + b2;
        }

        public a(Handler handler, f fVar, long j) {
            this.a = fVar != null ? (Handler) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(handler) : null;
            this.b = fVar;
            this.c = j;
        }

        public void b(j jVar, int i, long j, long j2, long j3) {
            if (this.b != null) {
                b bVar = r0;
                b bVar2 = new b(this, jVar, i, -1, (i) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
                this.a.post(bVar);
            }
        }

        public void a(j jVar, int i, long j, long j2, long j3) {
            if (this.b != null) {
                c cVar = r0;
                c cVar2 = new c(this, jVar, i, -1, (i) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
                this.a.post(cVar);
            }
        }

        public void a(j jVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            if (this.b != null) {
                d dVar = r0;
                d dVar2 = new d(this, jVar, i, -1, (i) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
                this.a.post(dVar);
            }
        }
    }
}
