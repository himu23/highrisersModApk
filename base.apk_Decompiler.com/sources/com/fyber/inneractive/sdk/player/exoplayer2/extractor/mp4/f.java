package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.Stack;

public final class f implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f, m {
    public static final int p = u.a("qt  ");
    public final k a = new k(i.a);
    public final k b = new k(4);
    public final k c = new k(16);
    public final Stack<a.C0120a> d = new Stack<>();
    public int e;
    public int f;
    public long g;
    public int h;
    public k i;
    public int j;
    public int k;
    public h l;
    public a[] m;
    public long n;
    public boolean o;

    public static final class a {
        public final h a;
        public final k b;
        public final n c;
        public int d;

        public a(h hVar, k kVar, n nVar) {
            this.a = hVar;
            this.b = kVar;
            this.c = nVar;
        }
    }

    public void a(h hVar) {
        this.l = hVar;
    }

    public boolean a() {
        return true;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return g.a(gVar, false);
    }

    public void b() {
    }

    public long c() {
        return this.n;
    }

    public final void d() {
        this.e = 0;
        this.h = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc A[Catch:{ all -> 0x0229 }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0825  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3 A[Catch:{ all -> 0x0229 }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0225 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(long r71) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        /*
            r70 = this;
            r1 = r70
        L_0x0002:
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0a2e
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            java.lang.Object r0 = r0.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r0
            long r3 = r0.P0
            int r0 = (r3 > r71 ? 1 : (r3 == r71 ? 0 : -1))
            if (r0 != 0) goto L_0x0a2e
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            java.lang.Object r0 = r0.pop()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r0
            int r3 = r0.a
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C
            if (r3 != r4) goto L_0x0a13
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.j r4 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
            r4.<init>()
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r5 = r0.d(r5)
            r6 = 12
            r7 = 0
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0254
            boolean r10 = r1.o
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a
            if (r10 == 0) goto L_0x0045
            goto L_0x024d
        L_0x0045:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r5.P0
            r10 = 8
            r5.e(r10)
        L_0x004c:
            int r11 = r5.a()
            if (r11 < r10) goto L_0x024d
            int r11 = r5.b
            int r12 = r5.c()
            int r13 = r5.c()
            int r14 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.B0
            if (r13 != r14) goto L_0x0244
            r5.e(r11)
            int r11 = r11 + r12
            r5.f(r6)
        L_0x0067:
            int r12 = r5.b
            if (r12 >= r11) goto L_0x024d
            int r13 = r5.c()
            int r14 = r5.c()
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0
            if (r14 != r15) goto L_0x023b
            r5.e(r12)
            int r12 = r12 + r13
            r5.f(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0083:
            int r11 = r5.b
            if (r11 >= r12) goto L_0x022e
            int r13 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a
            int r13 = r5.c()
            int r11 = r11 + r13
            int r13 = r5.c()
            int r14 = r13 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = 169(0xa9, float:2.37E-43)
            java.lang.String r2 = "TCON"
            java.lang.String r6 = "MetadataUtil"
            if (r14 == r15) goto L_0x0181
            r15 = 65533(0xfffd, float:9.1831E-41)
            if (r14 != r15) goto L_0x00a5
            goto L_0x0181
        L_0x00a5:
            int r14 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.m     // Catch:{ all -> 0x0229 }
            if (r13 != r14) goto L_0x00cb
            int r13 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r5)     // Catch:{ all -> 0x0229 }
            if (r13 <= 0) goto L_0x00b9
            java.lang.String[] r14 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.D     // Catch:{ all -> 0x0229 }
            int r15 = r14.length     // Catch:{ all -> 0x0229 }
            if (r13 > r15) goto L_0x00b9
            int r13 = r13 + -1
            r13 = r14[r13]     // Catch:{ all -> 0x0229 }
            goto L_0x00ba
        L_0x00b9:
            r13 = r7
        L_0x00ba:
            if (r13 == 0) goto L_0x00c3
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r6 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j     // Catch:{ all -> 0x0229 }
            r6.<init>(r2, r7, r13)     // Catch:{ all -> 0x0229 }
            goto L_0x021c
        L_0x00c3:
            java.lang.String r2 = "Failed to parse standard genre code"
            android.util.Log.w(r6, r2)     // Catch:{ all -> 0x0229 }
            r2 = r7
            goto L_0x021d
        L_0x00cb:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.o     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x00d7
            java.lang.String r2 = "TPOS"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x00d7:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.p     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x00e3
            java.lang.String r2 = "TRCK"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x00e3:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.q     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x00ef
            java.lang.String r2 = "TBPM"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5, r8, r9)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x00ef:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.r     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x00fb
            java.lang.String r2 = "TCMP"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5, r8, r8)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x00fb:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.l     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0108
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.a r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r5)     // Catch:{ all -> 0x0229 }
            r5.e(r11)
            goto L_0x0220
        L_0x0108:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.s     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0114
            java.lang.String r2 = "TPE2"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0114:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.t     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0120
            java.lang.String r2 = "TSOT"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0120:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.u     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x012b
            java.lang.String r2 = "TSO2"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x012b:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.v     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0136
            java.lang.String r2 = "TSOA"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0136:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.w     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0141
            java.lang.String r2 = "TSOP"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0141:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.x     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x014c
            java.lang.String r2 = "TSOC"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x014c:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.y     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0157
            java.lang.String r2 = "ITUNESADVISORY"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5, r9, r9)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0157:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.z     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0162
            java.lang.String r2 = "ITUNESGAPLESS"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a(r13, r2, r5, r9, r8)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0162:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.A     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x016d
            java.lang.String r2 = "TVSHOWSORT"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x016d:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.B     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x0178
            java.lang.String r2 = "TVSHOW"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0178:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.C     // Catch:{ all -> 0x0229 }
            if (r13 != r2) goto L_0x01ef
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r5, (int) r11)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0181:
            r14 = 16777215(0xffffff, float:2.3509886E-38)
            r14 = r14 & r13
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.c     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x0190
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a((int) r13, (com.fyber.inneractive.sdk.player.exoplayer2.util.k) r5)     // Catch:{ all -> 0x0229 }
        L_0x018d:
            r6 = r2
            goto L_0x021c
        L_0x0190:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.a     // Catch:{ all -> 0x0229 }
            if (r14 == r15) goto L_0x0214
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x019a
            goto L_0x0214
        L_0x019a:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.h     // Catch:{ all -> 0x0229 }
            if (r14 == r15) goto L_0x020c
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.i     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01a4
            goto L_0x020c
        L_0x01a4:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.d     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01af
            java.lang.String r2 = "TDRC"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01af:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.e     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01ba
            java.lang.String r2 = "TPE1"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01ba:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.f     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01c5
            java.lang.String r2 = "TSSE"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01c5:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.g     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01d0
            java.lang.String r2 = "TALB"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01d0:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.j     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01db
            java.lang.String r2 = "USLT"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01db:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.k     // Catch:{ all -> 0x0229 }
            if (r14 != r15) goto L_0x01e4
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01e4:
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.n     // Catch:{ all -> 0x0229 }
            if (r14 != r2) goto L_0x01ef
            java.lang.String r2 = "TIT1"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x01ef:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0229 }
            r2.<init>()     // Catch:{ all -> 0x0229 }
            java.lang.String r14 = "Skipped unknown metadata entry: "
            r2.append(r14)     // Catch:{ all -> 0x0229 }
            java.lang.String r13 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a(r13)     // Catch:{ all -> 0x0229 }
            r2.append(r13)     // Catch:{ all -> 0x0229 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0229 }
            android.util.Log.d(r6, r2)     // Catch:{ all -> 0x0229 }
            r5.e(r11)
            r2 = r7
            goto L_0x0220
        L_0x020c:
            java.lang.String r2 = "TCOM"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x0214:
            java.lang.String r2 = "TIT2"
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e.b(r13, r2, r5)     // Catch:{ all -> 0x0229 }
            goto L_0x018d
        L_0x021c:
            r2 = r6
        L_0x021d:
            r5.e(r11)
        L_0x0220:
            if (r2 == 0) goto L_0x0225
            r10.add(r2)
        L_0x0225:
            r6 = 12
            goto L_0x0083
        L_0x0229:
            r0 = move-exception
            r5.e(r11)
            throw r0
        L_0x022e:
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L_0x0235
            goto L_0x024d
        L_0x0235:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r2 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.a
            r2.<init>((java.util.List<? extends com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b>) r10)
            goto L_0x024e
        L_0x023b:
            int r13 = r13 + -8
            r5.f(r13)
            r6 = 12
            goto L_0x0067
        L_0x0244:
            int r12 = r12 + -8
            r5.f(r12)
            r6 = 12
            goto L_0x004c
        L_0x024d:
            r2 = r7
        L_0x024e:
            if (r2 == 0) goto L_0x0255
            r4.a(r2)
            goto L_0x0255
        L_0x0254:
            r2 = r7
        L_0x0255:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 0
        L_0x0260:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r13 = r0.R0
            int r13 = r13.size()
            if (r12 >= r13) goto L_0x09ef
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r13 = r0.R0
            java.lang.Object r13 = r13.get(r12)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r13 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r13
            int r14 = r13.a
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E
            if (r14 == r15) goto L_0x0286
        L_0x0276:
            r45 = r0
            r52 = r2
            r49 = r3
            r54 = r4
            r50 = r5
            r47 = r10
            r53 = r12
            goto L_0x0843
        L_0x0286:
            int r14 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r18 = r0.d(r14)
            boolean r14 = r1.o
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r21 = 0
            r17 = r13
            r22 = r14
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r14 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r17, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r18, (long) r19, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r21, (boolean) r22)
            if (r14 != 0) goto L_0x02a0
            goto L_0x0276
        L_0x02a0:
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r13 = r13.c(r15)
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r13 = r13.c(r15)
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r13 = r13.c(r15)
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r15 = r13.d(r15)
            if (r15 == 0) goto L_0x02c0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$c r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$c
            r7.<init>(r15)
            goto L_0x02ce
        L_0x02c0:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.r0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r7 = r13.d(r7)
            if (r7 == 0) goto L_0x09e7
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$d r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$d
            r15.<init>(r7)
            r7 = r15
        L_0x02ce:
            int r15 = r7.a()
            if (r15 != 0) goto L_0x02fe
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k
            long[] r13 = new long[r9]
            int[] r15 = new int[r9]
            long[] r8 = new long[r9]
            r45 = r0
            int[] r0 = new int[r9]
            r20 = 0
            r17 = r7
            r18 = r13
            r19 = r15
            r21 = r8
            r22 = r0
            r17.<init>(r18, r19, r20, r21, r22)
            r52 = r2
            r49 = r3
            r54 = r4
            r50 = r5
            r47 = r10
            r53 = r12
            r3 = r14
            goto L_0x083f
        L_0x02fe:
            r45 = r0
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r13.d(r0)
            if (r0 != 0) goto L_0x0310
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r13.d(r0)
            r8 = 1
            goto L_0x0311
        L_0x0310:
            r8 = 0
        L_0x0311:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            int r9 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.p0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r9 = r13.d(r9)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r9 = r9.P0
            r47 = r10
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r10 = r13.d(r10)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r10.P0
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r11 = r13.d(r11)
            if (r11 == 0) goto L_0x0332
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r11.P0
            r49 = r3
            goto L_0x0335
        L_0x0332:
            r49 = r3
            r11 = 0
        L_0x0335:
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r3 = r13.d(r3)
            if (r3 == 0) goto L_0x0340
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r3.P0
            goto L_0x0341
        L_0x0340:
            r3 = 0
        L_0x0341:
            r13 = 12
            r0.e(r13)
            r50 = r5
            int r5 = r0.o()
            r9.e(r13)
            int r6 = r9.o()
            int r13 = r9.c()
            r17 = r6
            r6 = 1
            if (r13 != r6) goto L_0x035e
            r13 = 1
            goto L_0x035f
        L_0x035e:
            r13 = 0
        L_0x035f:
            java.lang.String r6 = "first_chunk must be 1"
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r13, r6)
            r6 = 12
            r10.e(r6)
            int r13 = r10.o()
            r16 = 1
            int r13 = r13 + -1
            int r16 = r10.o()
            r52 = r2
            int r2 = r10.o()
            if (r3 == 0) goto L_0x0385
            r3.e(r6)
            int r18 = r3.o()
            goto L_0x0387
        L_0x0385:
            r18 = 0
        L_0x0387:
            r19 = -1
            if (r11 == 0) goto L_0x039f
            r11.e(r6)
            int r20 = r11.o()
            if (r20 <= 0) goto L_0x039d
            int r21 = r11.o()
            r22 = 1
            int r21 = r21 + -1
            goto L_0x03a3
        L_0x039d:
            r11 = 0
            goto L_0x03a1
        L_0x039f:
            r20 = 0
        L_0x03a1:
            r21 = -1
        L_0x03a3:
            boolean r22 = r7.c()
            if (r22 == 0) goto L_0x03bf
            com.fyber.inneractive.sdk.player.exoplayer2.i r6 = r14.f
            java.lang.String r6 = r6.f
            r53 = r12
            java.lang.String r12 = "audio/raw"
            boolean r6 = r12.equals(r6)
            if (r6 == 0) goto L_0x03c1
            if (r13 != 0) goto L_0x03c1
            if (r18 != 0) goto L_0x03c1
            if (r20 != 0) goto L_0x03c1
            r6 = 1
            goto L_0x03c2
        L_0x03bf:
            r53 = r12
        L_0x03c1:
            r6 = 0
        L_0x03c2:
            r22 = 0
            if (r6 != 0) goto L_0x053e
            long[] r6 = new long[r15]
            int[] r12 = new int[r15]
            r25 = r13
            long[] r13 = new long[r15]
            int[] r1 = new int[r15]
            r28 = r2
            r54 = r14
            r31 = r22
            r33 = r31
            r35 = r33
            r2 = 0
            r14 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r37 = -1
            r55 = 0
            r68 = r16
            r16 = r4
            r4 = r21
            r21 = r25
            r25 = r68
            r69 = r20
            r20 = r10
            r10 = r69
        L_0x03f8:
            if (r14 >= r15) goto L_0x04c5
            r68 = r30
            r30 = r15
            r15 = r68
        L_0x0400:
            if (r55 != 0) goto L_0x0442
            r38 = r10
            int r10 = r37 + 1
            if (r10 != r5) goto L_0x040d
            r55 = r29
            r29 = 0
            goto L_0x0436
        L_0x040d:
            if (r8 == 0) goto L_0x0414
            long r33 = r0.p()
            goto L_0x0418
        L_0x0414:
            long r33 = r0.m()
        L_0x0418:
            if (r10 != r15) goto L_0x0430
            int r29 = r9.o()
            r15 = 4
            r9.f(r15)
            int r17 = r17 + -1
            if (r17 <= 0) goto L_0x042f
            int r15 = r9.o()
            r35 = 1
            int r15 = r15 + -1
            goto L_0x0430
        L_0x042f:
            r15 = -1
        L_0x0430:
            r55 = r29
            r35 = r33
            r29 = 1
        L_0x0436:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r29)
            r37 = r10
            r33 = r35
            r10 = r38
            r29 = r55
            goto L_0x0400
        L_0x0442:
            r38 = r10
            if (r3 == 0) goto L_0x0457
        L_0x0446:
            if (r26 != 0) goto L_0x0455
            if (r18 <= 0) goto L_0x0455
            int r26 = r3.o()
            int r27 = r3.c()
            int r18 = r18 + -1
            goto L_0x0446
        L_0x0455:
            int r26 = r26 + -1
        L_0x0457:
            r10 = r27
            r6[r14] = r33
            r27 = r6
            int r6 = r7.b()
            r12[r14] = r6
            if (r6 <= r2) goto L_0x0466
            r2 = r6
        L_0x0466:
            r39 = r7
            long r6 = (long) r10
            long r6 = r31 + r6
            r13[r14] = r6
            if (r11 != 0) goto L_0x0471
            r6 = 1
            goto L_0x0472
        L_0x0471:
            r6 = 0
        L_0x0472:
            r1[r14] = r6
            if (r14 != r4) goto L_0x0487
            r6 = 1
            r1[r14] = r6
            int r7 = r38 + -1
            if (r7 <= 0) goto L_0x0482
            int r4 = r11.o()
            int r4 = r4 - r6
        L_0x0482:
            r40 = r2
            r6 = r28
            goto L_0x048d
        L_0x0487:
            r40 = r2
            r6 = r28
            r7 = r38
        L_0x048d:
            r28 = r1
            long r1 = (long) r6
            long r31 = r31 + r1
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x04a5
            if (r21 <= 0) goto L_0x04a5
            int r1 = r20.o()
            int r2 = r20.o()
            int r21 = r21 + -1
            r25 = r1
            goto L_0x04a6
        L_0x04a5:
            r2 = r6
        L_0x04a6:
            r1 = r12[r14]
            r6 = r2
            long r1 = (long) r1
            long r33 = r33 + r1
            int r55 = r55 + -1
            int r14 = r14 + 1
            r1 = r28
            r2 = r40
            r28 = r6
            r6 = r27
            r27 = r10
            r10 = r7
            r7 = r39
            r68 = r30
            r30 = r15
            r15 = r68
            goto L_0x03f8
        L_0x04c5:
            r28 = r1
            r27 = r6
            r38 = r10
            r30 = r15
            if (r26 != 0) goto L_0x04d1
            r0 = 1
            goto L_0x04d2
        L_0x04d1:
            r0 = 0
        L_0x04d2:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) r0)
        L_0x04d5:
            if (r18 <= 0) goto L_0x04e9
            int r0 = r3.o()
            if (r0 != 0) goto L_0x04df
            r0 = 1
            goto L_0x04e0
        L_0x04df:
            r0 = 0
        L_0x04e0:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) r0)
            r3.c()
            int r18 = r18 + -1
            goto L_0x04d5
        L_0x04e9:
            if (r38 != 0) goto L_0x04f7
            if (r25 != 0) goto L_0x04f7
            r0 = r55
            if (r0 != 0) goto L_0x04f9
            if (r21 == 0) goto L_0x04f4
            goto L_0x04f9
        L_0x04f4:
            r3 = r54
            goto L_0x0536
        L_0x04f7:
            r0 = r55
        L_0x04f9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Inconsistent stbl box for track "
            r1.<init>(r3)
            r3 = r54
            int r4 = r3.a
            r1.append(r4)
            java.lang.String r4 = ": remainingSynchronizationSamples "
            r1.append(r4)
            r7 = r38
            r1.append(r7)
            java.lang.String r4 = ", remainingSamplesAtTimestampDelta "
            r1.append(r4)
            r4 = r25
            r1.append(r4)
            java.lang.String r4 = ", remainingSamplesInChunk "
            r1.append(r4)
            r1.append(r0)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r1.append(r0)
            r0 = r21
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "AtomParsers"
            android.util.Log.w(r1, r0)
        L_0x0536:
            r34 = r2
            r8 = r27
            r9 = r28
            goto L_0x05ee
        L_0x053e:
            r16 = r4
            r39 = r7
            r3 = r14
            r30 = r15
            long[] r1 = new long[r5]
            int[] r4 = new int[r5]
            r6 = r17
            r12 = r22
            r7 = 0
            r10 = 0
            r11 = -1
        L_0x0550:
            r14 = 1
            int r11 = r11 + r14
            if (r11 != r5) goto L_0x0557
            r14 = 4
            r15 = 0
            goto L_0x057b
        L_0x0557:
            if (r8 == 0) goto L_0x055e
            long r12 = r0.p()
            goto L_0x0562
        L_0x055e:
            long r12 = r0.m()
        L_0x0562:
            if (r11 != r7) goto L_0x0579
            int r10 = r9.o()
            r14 = 4
            r9.f(r14)
            int r6 = r6 + -1
            if (r6 <= 0) goto L_0x0577
            int r7 = r9.o()
            r15 = 1
            int r7 = r7 - r15
            goto L_0x057a
        L_0x0577:
            r7 = -1
            goto L_0x057a
        L_0x0579:
            r14 = 4
        L_0x057a:
            r15 = 1
        L_0x057b:
            if (r15 == 0) goto L_0x0582
            r1[r11] = r12
            r4[r11] = r10
            goto L_0x0550
        L_0x0582:
            int r0 = r39.b()
            long r6 = (long) r2
            r2 = 8192(0x2000, float:1.14794E-41)
            int r2 = r2 / r0
            r8 = 0
            r9 = 0
        L_0x058c:
            if (r8 >= r5) goto L_0x0598
            r10 = r4[r8]
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r10, (int) r2)
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x058c
        L_0x0598:
            long[] r8 = new long[r9]
            int[] r12 = new int[r9]
            long[] r13 = new long[r9]
            int[] r9 = new int[r9]
            r10 = 0
            r11 = 0
            r14 = 0
            r15 = 0
        L_0x05a4:
            if (r10 >= r5) goto L_0x05ea
            r17 = r4[r10]
            r18 = r1[r10]
            r68 = r17
            r17 = r1
            r1 = r68
        L_0x05b0:
            if (r1 <= 0) goto L_0x05de
            int r20 = java.lang.Math.min(r2, r1)
            r8[r15] = r18
            r21 = r2
            int r2 = r0 * r20
            r12[r15] = r2
            int r11 = java.lang.Math.max(r11, r2)
            r24 = r4
            r2 = r5
            long r4 = (long) r14
            long r4 = r4 * r6
            r13[r15] = r4
            r4 = 1
            r9[r15] = r4
            r4 = r12[r15]
            long r4 = (long) r4
            long r18 = r18 + r4
            int r14 = r14 + r20
            int r1 = r1 - r20
            int r15 = r15 + 1
            r5 = r2
            r2 = r21
            r4 = r24
            goto L_0x05b0
        L_0x05de:
            r21 = r2
            r24 = r4
            r2 = r5
            int r10 = r10 + 1
            r1 = r17
            r2 = r21
            goto L_0x05a4
        L_0x05ea:
            r34 = r11
            r31 = r22
        L_0x05ee:
            long[] r0 = r3.i
            r1 = 1000000(0xf4240, double:4.940656E-318)
            if (r0 == 0) goto L_0x0825
            boolean r0 = r16.a()
            if (r0 == 0) goto L_0x05fd
            goto L_0x0825
        L_0x05fd:
            long[] r0 = r3.i
            int r4 = r0.length
            r5 = 1
            if (r4 != r5) goto L_0x068a
            int r4 = r3.b
            if (r4 != r5) goto L_0x068a
            int r4 = r13.length
            r5 = 2
            if (r4 < r5) goto L_0x068a
            long[] r4 = r3.j
            r5 = 0
            r6 = r4[r5]
            r24 = r0[r5]
            long r10 = r3.c
            long r14 = r3.d
            r26 = r10
            r28 = r14
            long r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r24, (long) r26, (long) r28)
            long r10 = r10 + r6
            r14 = r13[r5]
            int r0 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x068a
            r0 = 1
            r4 = r13[r0]
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 >= 0) goto L_0x068a
            int r4 = r13.length
            int r4 = r4 - r0
            r4 = r13[r4]
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x068a
            int r0 = (r10 > r31 ? 1 : (r10 == r31 ? 0 : -1))
            if (r0 > 0) goto L_0x068a
            long r24 = r31 - r10
            long r35 = r6 - r14
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r3.f
            int r0 = r0.s
            long r4 = (long) r0
            long r6 = r3.c
            r37 = r4
            r39 = r6
            long r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r35, (long) r37, (long) r39)
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r3.f
            int r0 = r0.s
            long r6 = (long) r0
            long r10 = r3.c
            r26 = r6
            r28 = r10
            long r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r24, (long) r26, (long) r28)
            int r0 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r0 != 0) goto L_0x0662
            int r0 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x068a
        L_0x0662:
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x068a
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x068a
            int r0 = (int) r4
            r4 = r16
            r4.a = r0
            int r0 = (int) r6
            r4.b = r0
            long r5 = r3.c
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long[]) r13, (long) r1, (long) r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k
            r31 = r7
            r32 = r8
            r33 = r12
            r35 = r13
            r36 = r9
            r31.<init>(r32, r33, r34, r35, r36)
            goto L_0x06c7
        L_0x068a:
            r4 = r16
            long[] r0 = r3.i
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x06cb
            r46 = 0
            r1 = r0[r46]
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 != 0) goto L_0x06cb
            r0 = 0
        L_0x069b:
            int r1 = r13.length
            if (r0 >= r1) goto L_0x06b8
            r1 = r13[r0]
            long[] r5 = r3.j
            r6 = r5[r46]
            long r16 = r1 - r6
            long r1 = r3.c
            r18 = 1000000(0xf4240, double:4.940656E-318)
            r20 = r1
            long r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r16, (long) r18, (long) r20)
            r13[r0] = r1
            int r0 = r0 + 1
            r46 = 0
            goto L_0x069b
        L_0x06b8:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k
            r31 = r7
            r32 = r8
            r33 = r12
            r35 = r13
            r36 = r9
            r31.<init>(r32, r33, r34, r35, r36)
        L_0x06c7:
            r54 = r4
            goto L_0x083f
        L_0x06cb:
            int r0 = r3.b
            r1 = 1
            if (r0 != r1) goto L_0x06d2
            r0 = 1
            goto L_0x06d3
        L_0x06d2:
            r0 = 0
        L_0x06d3:
            r1 = 0
            r2 = 0
            r5 = 0
            r6 = 0
        L_0x06d7:
            long[] r7 = r3.i
            int r10 = r7.length
            r14 = -1
            if (r1 >= r10) goto L_0x0715
            long[] r10 = r3.j
            r16 = r12
            r11 = r10[r1]
            int r10 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r10 == 0) goto L_0x070e
            r24 = r7[r1]
            long r14 = r3.c
            r7 = r9
            long r9 = r3.d
            r26 = r14
            r28 = r9
            long r9 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r24, (long) r26, (long) r28)
            r14 = 1
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(r13, r11, r14, r14)
            long r11 = r11 + r9
            r9 = 0
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(r13, r11, r0, r9)
            int r9 = r10 - r15
            int r2 = r2 + r9
            if (r5 == r15) goto L_0x0709
            r5 = 1
            goto L_0x070a
        L_0x0709:
            r5 = 0
        L_0x070a:
            r5 = r5 | r6
            r6 = r5
            r5 = r10
            goto L_0x070f
        L_0x070e:
            r7 = r9
        L_0x070f:
            int r1 = r1 + 1
            r9 = r7
            r12 = r16
            goto L_0x06d7
        L_0x0715:
            r7 = r9
            r16 = r12
            r1 = r30
            if (r2 == r1) goto L_0x071e
            r1 = 1
            goto L_0x071f
        L_0x071e:
            r1 = 0
        L_0x071f:
            r1 = r1 | r6
            if (r1 == 0) goto L_0x0725
            long[] r5 = new long[r2]
            goto L_0x0726
        L_0x0725:
            r5 = r8
        L_0x0726:
            if (r1 == 0) goto L_0x072b
            int[] r6 = new int[r2]
            goto L_0x072d
        L_0x072b:
            r6 = r16
        L_0x072d:
            if (r1 == 0) goto L_0x0731
            r34 = 0
        L_0x0731:
            if (r1 == 0) goto L_0x0736
            int[] r9 = new int[r2]
            goto L_0x0737
        L_0x0736:
            r9 = r7
        L_0x0737:
            long[] r2 = new long[r2]
            r23 = r22
            r27 = r34
            r10 = 0
            r11 = 0
        L_0x073f:
            long[] r12 = r3.i
            int r14 = r12.length
            if (r10 >= r14) goto L_0x07f3
            long[] r14 = r3.j
            r28 = r6
            r15 = r7
            r6 = r14[r10]
            r29 = r12[r10]
            r25 = -1
            int r12 = (r6 > r25 ? 1 : (r6 == r25 ? 0 : -1))
            if (r12 == 0) goto L_0x07d2
            r12 = r15
            long r14 = r3.c
            r31 = r9
            r32 = r10
            long r9 = r3.d
            r17 = r29
            r19 = r14
            r21 = r9
            long r9 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r17, (long) r19, (long) r21)
            long r9 = r9 + r6
            r14 = 1
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(r13, r6, r14, r14)
            r14 = 0
            int r9 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(r13, r9, r0, r14)
            if (r1 == 0) goto L_0x0789
            int r10 = r9 - r15
            java.lang.System.arraycopy(r8, r15, r5, r11, r10)
            r14 = r16
            r16 = r0
            r0 = r28
            java.lang.System.arraycopy(r14, r15, r0, r11, r10)
            r54 = r4
            r4 = r31
            java.lang.System.arraycopy(r12, r15, r4, r11, r10)
            goto L_0x0793
        L_0x0789:
            r54 = r4
            r14 = r16
            r4 = r31
            r16 = r0
            r0 = r28
        L_0x0793:
            r10 = r27
        L_0x0795:
            r28 = r8
            if (r15 >= r9) goto L_0x07cf
            r31 = r9
            long r8 = r3.d
            r19 = 1000000(0xf4240, double:4.940656E-318)
            r17 = r23
            r21 = r8
            long r8 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r17, (long) r19, (long) r21)
            r17 = r13[r15]
            long r33 = r17 - r6
            r17 = r6
            long r6 = r3.c
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r37 = r6
            long r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r33, (long) r35, (long) r37)
            long r8 = r8 + r6
            r2[r11] = r8
            if (r1 == 0) goto L_0x07c4
            r6 = r0[r11]
            if (r6 <= r10) goto L_0x07c4
            r10 = r14[r15]
        L_0x07c4:
            int r11 = r11 + 1
            int r15 = r15 + 1
            r6 = r17
            r8 = r28
            r9 = r31
            goto L_0x0795
        L_0x07cf:
            r27 = r10
            goto L_0x07e0
        L_0x07d2:
            r54 = r4
            r4 = r9
            r32 = r10
            r12 = r15
            r14 = r16
            r16 = r0
            r0 = r28
            r28 = r8
        L_0x07e0:
            long r23 = r23 + r29
            int r10 = r32 + 1
            r6 = r0
            r9 = r4
            r7 = r12
            r0 = r16
            r8 = r28
            r4 = r54
            r16 = r14
            r14 = r25
            goto L_0x073f
        L_0x07f3:
            r54 = r4
            r0 = r6
            r4 = r9
            r1 = 0
            r6 = 0
        L_0x07f9:
            int r7 = r4.length
            if (r1 >= r7) goto L_0x080b
            if (r6 != 0) goto L_0x080b
            r7 = r4[r1]
            r8 = 1
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0806
            r7 = 1
            goto L_0x0807
        L_0x0806:
            r7 = 0
        L_0x0807:
            r6 = r6 | r7
            int r1 = r1 + 1
            goto L_0x07f9
        L_0x080b:
            if (r6 == 0) goto L_0x081d
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k
            r24 = r7
            r25 = r5
            r26 = r0
            r28 = r2
            r29 = r4
            r24.<init>(r25, r26, r27, r28, r29)
            goto L_0x083f
        L_0x081d:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0825:
            r28 = r8
            r14 = r12
            r54 = r16
            r12 = r9
            long r4 = r3.c
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long[]) r13, (long) r1, (long) r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k
            r31 = r7
            r32 = r28
            r33 = r14
            r35 = r13
            r36 = r12
            r31.<init>(r32, r33, r34, r35, r36)
        L_0x083f:
            int r0 = r7.a
            if (r0 != 0) goto L_0x084e
        L_0x0843:
            r10 = r47
            r3 = r49
            r1 = r50
            r0 = r54
            r5 = 0
            goto L_0x09d8
        L_0x084e:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f$a r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f$a
            r1 = r70
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r2 = r1.l
            int r4 = r3.b
            r9 = r53
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r2 = r2.a(r9, r4)
            r0.<init>(r3, r7, r2)
            int r4 = r7.d
            int r4 = r4 + 30
            r22 = r4
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r3.f
            com.fyber.inneractive.sdk.player.exoplayer2.i r6 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r16 = r6
            java.lang.String r8 = r5.a
            r17 = r8
            java.lang.String r10 = r5.e
            r18 = r10
            java.lang.String r11 = r5.f
            r19 = r11
            java.lang.String r12 = r5.c
            r20 = r12
            int r13 = r5.b
            r21 = r13
            int r14 = r5.j
            r23 = r14
            int r15 = r5.k
            r24 = r15
            float r1 = r5.l
            r25 = r1
            int r9 = r5.m
            r26 = r9
            r55 = r7
            float r7 = r5.n
            r27 = r7
            r56 = r0
            byte[] r0 = r5.p
            r28 = r0
            r57 = r2
            int r2 = r5.o
            r29 = r2
            r44 = r2
            com.fyber.inneractive.sdk.player.exoplayer2.video.b r2 = r5.q
            r30 = r2
            r58 = r2
            int r2 = r5.r
            r31 = r2
            r59 = r2
            int r2 = r5.s
            r32 = r2
            r60 = r2
            int r2 = r5.t
            r33 = r2
            r61 = r2
            int r2 = r5.u
            r34 = r2
            int r2 = r5.v
            r35 = r2
            int r2 = r5.x
            r36 = r2
            r62 = r2
            java.lang.String r2 = r5.y
            r37 = r2
            r63 = r2
            int r2 = r5.z
            r38 = r2
            r65 = r0
            r64 = r1
            long r0 = r5.w
            r39 = r0
            r66 = r0
            java.util.List<byte[]> r0 = r5.h
            r41 = r0
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r0 = r5.i
            r42 = r0
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r0 = r5.d
            r43 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r42, r43)
            int r0 = r3.b
            r1 = 1
            if (r0 != r1) goto L_0x09b3
            boolean r0 = r54.a()
            if (r0 == 0) goto L_0x0940
            r0 = r54
            int r5 = r0.a
            r34 = r5
            int r5 = r0.b
            r35 = r5
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r16 = r5
            java.util.List<byte[]> r1 = r6.h
            r41 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r1 = r6.i
            r42 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r1 = r6.d
            r43 = r1
            r17 = r8
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r22 = r4
            r23 = r14
            r24 = r15
            r25 = r64
            r26 = r9
            r27 = r7
            r28 = r65
            r29 = r44
            r30 = r58
            r31 = r59
            r32 = r60
            r33 = r61
            r36 = r62
            r37 = r63
            r38 = r2
            r39 = r66
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r42, r43)
            r6 = r5
            goto L_0x0942
        L_0x0940:
            r0 = r54
        L_0x0942:
            if (r52 == 0) goto L_0x09b5
            com.fyber.inneractive.sdk.player.exoplayer2.i r1 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r17 = r1
            java.lang.String r2 = r6.a
            r18 = r2
            java.lang.String r2 = r6.e
            r19 = r2
            java.lang.String r2 = r6.f
            r20 = r2
            java.lang.String r2 = r6.c
            r21 = r2
            int r2 = r6.b
            r22 = r2
            int r2 = r6.g
            r23 = r2
            int r2 = r6.j
            r24 = r2
            int r2 = r6.k
            r25 = r2
            float r2 = r6.l
            r26 = r2
            int r2 = r6.m
            r27 = r2
            float r2 = r6.n
            r28 = r2
            byte[] r2 = r6.p
            r29 = r2
            int r2 = r6.o
            r30 = r2
            com.fyber.inneractive.sdk.player.exoplayer2.video.b r2 = r6.q
            r31 = r2
            int r2 = r6.r
            r32 = r2
            int r2 = r6.s
            r33 = r2
            int r2 = r6.t
            r34 = r2
            int r2 = r6.u
            r35 = r2
            int r2 = r6.v
            r36 = r2
            int r2 = r6.x
            r37 = r2
            java.lang.String r2 = r6.y
            r38 = r2
            int r2 = r6.z
            r39 = r2
            long r4 = r6.w
            r40 = r4
            java.util.List<byte[]> r2 = r6.h
            r42 = r2
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r2 = r6.i
            r43 = r2
            r44 = r52
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44)
            r6 = r1
            goto L_0x09b5
        L_0x09b3:
            r0 = r54
        L_0x09b5:
            r1 = r57
            r1.a(r6)
            long r1 = r3.e
            r5 = r50
            long r1 = java.lang.Math.max(r5, r1)
            r3 = r49
            r4 = r56
            r3.add(r4)
            r7 = r55
            long[] r4 = r7.b
            r5 = 0
            r6 = r4[r5]
            int r4 = (r6 > r47 ? 1 : (r6 == r47 ? 0 : -1))
            if (r4 >= 0) goto L_0x09d6
            r10 = r6
            goto L_0x09d8
        L_0x09d6:
            r10 = r47
        L_0x09d8:
            int r12 = r53 + 1
            r7 = 0
            r8 = 1
            r9 = 0
            r4 = r0
            r5 = r1
            r0 = r45
            r2 = r52
            r1 = r70
            goto L_0x0260
        L_0x09e7:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x09ef:
            r1.n = r5
            int r0 = r3.size()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f$a[] r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f.a[r0]
            java.lang.Object[] r0 = r3.toArray(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f$a[] r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f.a[]) r0
            r1.m = r0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r0 = r1.l
            r0.c()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r0 = r1.l
            r0.a(r1)
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            r0.clear()
            r0 = 2
            r1.e = r0
            goto L_0x0002
        L_0x0a13:
            r45 = r0
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0002
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r1.d
            java.lang.Object r0 = r0.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r0
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r0 = r0.R0
            r2 = r45
            r0.add(r2)
            goto L_0x0002
        L_0x0a2e:
            int r0 = r1.e
            r2 = 2
            if (r0 == r2) goto L_0x0a36
            r70.d()
        L_0x0a36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f.c(long):void");
    }

    public void a(long j2, long j3) {
        this.d.clear();
        this.h = 0;
        this.j = 0;
        this.k = 0;
        if (j2 == 0) {
            d();
            return;
        }
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                k kVar = aVar.b;
                int a2 = kVar.a(j3);
                if (a2 == -1) {
                    a2 = kVar.b(j3);
                }
                aVar.d = a2;
            }
        }
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        a[] aVarArr;
        int i2;
        boolean z;
        boolean z2;
        g gVar2 = gVar;
        l lVar2 = lVar;
        while (true) {
            int i3 = this.e;
            if (i3 == 0) {
                if (this.h == 0) {
                    if (!((b) gVar2).b(this.c.a, 0, 8, true)) {
                        return -1;
                    }
                    this.h = 8;
                    this.c.e(0);
                    this.g = this.c.m();
                    this.f = this.c.c();
                }
                if (this.g == 1) {
                    ((b) gVar2).b(this.c.a, 8, 8, false);
                    this.h += 8;
                    this.g = this.c.p();
                }
                int i4 = this.f;
                if (i4 == a.C || i4 == a.E || i4 == a.F || i4 == a.G || i4 == a.H || i4 == a.Q) {
                    long j2 = (((b) gVar2).c + this.g) - ((long) this.h);
                    this.d.add(new a.C0120a(this.f, j2));
                    if (this.g == ((long) this.h)) {
                        c(j2);
                    } else {
                        d();
                    }
                } else if (i4 == a.S || i4 == a.D || i4 == a.T || i4 == a.U || i4 == a.m0 || i4 == a.n0 || i4 == a.o0 || i4 == a.R || i4 == a.p0 || i4 == a.q0 || i4 == a.r0 || i4 == a.s0 || i4 == a.t0 || i4 == a.P || i4 == a.b || i4 == a.A0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.h == 8);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.g <= 2147483647L);
                    k kVar = new k((int) this.g);
                    this.i = kVar;
                    System.arraycopy(this.c.a, 0, kVar.a, 0, 8);
                    this.e = 1;
                } else {
                    this.i = null;
                    this.e = 1;
                }
            } else if (i3 == 1) {
                long j3 = this.g;
                int i5 = this.h;
                long j4 = j3 - ((long) i5);
                b bVar = (b) gVar2;
                long j5 = bVar.c + j4;
                k kVar2 = this.i;
                if (kVar2 != null) {
                    bVar.b(kVar2.a, i5, (int) j4, false);
                    if (this.f == a.b) {
                        k kVar3 = this.i;
                        kVar3.e(8);
                        if (kVar3.c() == p) {
                            z2 = true;
                        } else {
                            kVar3.f(4);
                            while (true) {
                                if (kVar3.a() > 0) {
                                    if (kVar3.c() == p) {
                                        break;
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        this.o = z2;
                    } else if (!this.d.isEmpty()) {
                        this.d.peek().Q0.add(new a.b(this.f, this.i));
                    }
                } else if (j4 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    bVar.c((int) j4);
                } else {
                    lVar2.a = j5;
                    z = true;
                    c(j5);
                    if (z && this.e != 2) {
                        return 1;
                    }
                }
                z = false;
                c(j5);
                return 1;
            } else if (i3 == 2) {
                long j6 = Long.MAX_VALUE;
                int i6 = 0;
                int i7 = -1;
                while (true) {
                    aVarArr = this.m;
                    if (i6 >= aVarArr.length) {
                        break;
                    }
                    a aVar = aVarArr[i6];
                    int i8 = aVar.d;
                    k kVar4 = aVar.b;
                    if (i8 != kVar4.a) {
                        long j7 = kVar4.b[i8];
                        if (j7 < j6) {
                            i7 = i6;
                            j6 = j7;
                        }
                    }
                    i6++;
                }
                if (i7 == -1) {
                    return -1;
                }
                a aVar2 = aVarArr[i7];
                n nVar = aVar2.c;
                int i9 = aVar2.d;
                k kVar5 = aVar2.b;
                long j8 = kVar5.b[i9];
                int i10 = kVar5.c[i9];
                if (aVar2.a.g == 1) {
                    j8 += 8;
                    i10 -= 8;
                }
                b bVar2 = (b) gVar2;
                int i11 = i10;
                long j9 = (j8 - bVar2.c) + ((long) this.j);
                if (j9 < 0 || j9 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    lVar2.a = j8;
                    return 1;
                }
                bVar2.c((int) j9);
                int i12 = aVar2.a.k;
                if (i12 == 0) {
                    while (true) {
                        int i13 = this.j;
                        i2 = i11;
                        if (i13 >= i2) {
                            break;
                        }
                        int a2 = nVar.a(gVar2, i2 - i13, false);
                        this.j += a2;
                        this.k -= a2;
                        i11 = i2;
                    }
                } else {
                    byte[] bArr = this.b.a;
                    boolean z3 = false;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i14 = 4 - i12;
                    i2 = i11;
                    while (this.j < i2) {
                        int i15 = this.k;
                        if (i15 == 0) {
                            bVar2.b(this.b.a, i14, i12, z3);
                            this.b.e(z3 ? 1 : 0);
                            this.k = this.b.o();
                            this.a.e(z3);
                            nVar.a(this.a, 4);
                            this.j += 4;
                            i2 += i14;
                        } else {
                            int a3 = nVar.a(gVar2, i15, z3);
                            this.j += a3;
                            this.k -= a3;
                            z3 = false;
                        }
                    }
                }
                k kVar6 = aVar2.b;
                nVar.a(kVar6.e[i9], kVar6.f[i9], i2, 0, (byte[]) null);
                aVar2.d++;
                this.j = 0;
                this.k = 0;
                return 0;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public long a(long j2) {
        long j3 = Long.MAX_VALUE;
        for (a aVar : this.m) {
            k kVar = aVar.b;
            int a2 = kVar.a(j2);
            if (a2 == -1) {
                a2 = kVar.b(j2);
            }
            long j4 = kVar.b[a2];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }
}
