package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;

public interface a {

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a$a  reason: collision with other inner class name */
    public static class C0128a extends IOException {
        public C0128a(String str) {
            super(str);
        }

        public C0128a(IOException iOException) {
            super(iOException);
        }
    }

    public interface b {
        void a(a aVar, g gVar);

        void a(a aVar, g gVar, g gVar2);

        void b(a aVar, g gVar);
    }

    long a();

    long a(String str);

    File a(String str, long j, long j2) throws C0128a;

    void a(g gVar) throws C0128a;

    void a(File file) throws C0128a;

    void a(String str, long j) throws C0128a;

    g b(String str, long j) throws InterruptedException, C0128a;

    void b(g gVar);

    g c(String str, long j) throws C0128a;
}
