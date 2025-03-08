package com.applovin.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.applovin.exoplayer2.b.g;
import com.applovin.exoplayer2.b.h;
import com.applovin.exoplayer2.b.n;
import com.applovin.exoplayer2.f.k;
import com.applovin.exoplayer2.g.e;
import com.applovin.exoplayer2.g.f;
import com.applovin.exoplayer2.i.l;
import com.applovin.exoplayer2.i.m;
import com.applovin.exoplayer2.m.a.b;
import java.util.ArrayList;

public class n implements au {
    private final Context E;
    private int bd = 0;
    private long be = 5000;
    private boolean bf;
    private k bg = k.IR;
    private boolean bh;
    private boolean bi;
    private boolean bj;
    private boolean bk;
    private boolean bl;
    private boolean bm;

    /* access modifiers changed from: protected */
    public void a(Context context, Handler handler, int i, ArrayList<ar> arrayList) {
    }

    public n(Context context) {
        this.E = context;
    }

    public ar[] a(Handler handler, com.applovin.exoplayer2.m.n nVar, g gVar, l lVar, e eVar) {
        ArrayList arrayList = new ArrayList();
        a(this.E, this.bd, this.bg, this.bf, handler, nVar, this.be, (ArrayList<ar>) arrayList);
        h a = a(this.E, this.bk, this.bl, this.bm);
        if (a != null) {
            a(this.E, this.bd, this.bg, this.bf, a, handler, gVar, (ArrayList<ar>) arrayList);
        }
        ArrayList arrayList2 = arrayList;
        a(this.E, lVar, handler.getLooper(), this.bd, (ArrayList<ar>) arrayList2);
        a(this.E, eVar, handler.getLooper(), this.bd, (ArrayList<ar>) arrayList2);
        a(this.E, this.bd, arrayList);
        Handler handler2 = handler;
        a(this.E, handler, this.bd, (ArrayList<ar>) arrayList);
        return (ar[]) arrayList.toArray(new ar[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
        throw new java.lang.RuntimeException("Error instantiating AV1 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007f A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r15, int r16, com.applovin.exoplayer2.f.k r17, boolean r18, android.os.Handler r19, com.applovin.exoplayer2.m.n r20, long r21, java.util.ArrayList<com.applovin.exoplayer2.ar> r23) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r11 = r23
            java.lang.String r12 = "DefaultRenderersFactory"
            com.applovin.exoplayer2.m.h r13 = new com.applovin.exoplayer2.m.h
            r10 = 50
            r2 = r13
            r3 = r15
            r4 = r17
            r5 = r21
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            boolean r2 = r1.bh
            r13.M(r2)
            boolean r2 = r1.bi
            r13.N(r2)
            boolean r2 = r1.bj
            r13.O(r2)
            r11.add(r13)
            if (r0 != 0) goto L_0x002f
            return
        L_0x002f:
            int r2 = r23.size()
            r3 = 2
            if (r0 != r3) goto L_0x0038
            int r2 = r2 + -1
        L_0x0038:
            r0 = 50
            r4 = 3
            r5 = 0
            r6 = 4
            r7 = 1
            java.lang.String r8 = "com.applovin.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r9[r7] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class<com.applovin.exoplayer2.m.n> r10 = com.applovin.exoplayer2.m.n.class
            r9[r3] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r7] = r19     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r3] = r20     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            com.applovin.exoplayer2.ar r8 = (com.applovin.exoplayer2.ar) r8     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            int r9 = r2 + 1
            r11.add(r2, r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x007f }
            java.lang.String r2 = "Loaded LibvpxVideoRenderer."
            com.applovin.exoplayer2.l.q.g(r12, r2)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x007f }
            goto L_0x0089
        L_0x007d:
            r2 = r9
            goto L_0x0088
        L_0x007f:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating VP9 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0088:
            r9 = r2
        L_0x0089:
            java.lang.String r2 = "com.applovin.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r8[r7] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Class<com.applovin.exoplayer2.m.n> r10 = com.applovin.exoplayer2.m.n.class
            r8[r3] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r4] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r7] = r19     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r3] = r20     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            r8[r4] = r10     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            java.lang.Object r2 = r2.newInstance(r8)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            com.applovin.exoplayer2.ar r2 = (com.applovin.exoplayer2.ar) r2     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00ca }
            int r8 = r9 + 1
            r11.add(r9, r2)     // Catch:{ ClassNotFoundException -> 0x00c8, Exception -> 0x00ca }
            java.lang.String r2 = "Loaded Libgav1VideoRenderer."
            com.applovin.exoplayer2.l.q.g(r12, r2)     // Catch:{ ClassNotFoundException -> 0x00c8, Exception -> 0x00ca }
            goto L_0x00d4
        L_0x00c8:
            r9 = r8
            goto L_0x00d3
        L_0x00ca:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating AV1 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00d3:
            r8 = r9
        L_0x00d4:
            java.lang.String r2 = "com.applovin.exoplayer2.ext.ffmpeg.FfmpegVideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r9[r7] = r10     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Class<com.applovin.exoplayer2.m.n> r10 = com.applovin.exoplayer2.m.n.class
            r9[r3] = r10     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Long r9 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r6[r5] = r9     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r6[r7] = r19     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r6[r3] = r20     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r6[r4] = r0     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.Object r0 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            com.applovin.exoplayer2.ar r0 = (com.applovin.exoplayer2.ar) r0     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            r11.add(r8, r0)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            java.lang.String r0 = "Loaded FfmpegVideoRenderer."
            com.applovin.exoplayer2.l.q.g(r12, r0)     // Catch:{ ClassNotFoundException -> 0x011a, Exception -> 0x0111 }
            goto L_0x011a
        L_0x0111:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FFmpeg extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.n.a(android.content.Context, int, com.applovin.exoplayer2.f.k, boolean, android.os.Handler, com.applovin.exoplayer2.m.n, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r13, int r14, com.applovin.exoplayer2.f.k r15, boolean r16, com.applovin.exoplayer2.b.h r17, android.os.Handler r18, com.applovin.exoplayer2.b.g r19, java.util.ArrayList<com.applovin.exoplayer2.ar> r20) {
        /*
            r12 = this;
            r1 = r12
            r0 = r14
            r9 = r20
            java.lang.String r10 = "DefaultRenderersFactory"
            com.applovin.exoplayer2.b.q r11 = new com.applovin.exoplayer2.b.q
            r2 = r11
            r3 = r13
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r19
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8)
            boolean r2 = r1.bh
            r11.M(r2)
            boolean r2 = r1.bi
            r11.N(r2)
            boolean r2 = r1.bj
            r11.O(r2)
            r9.add(r11)
            if (r0 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r20.size()
            r3 = 2
            if (r0 != r3) goto L_0x0034
            int r2 = r2 + -1
        L_0x0034:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.applovin.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<com.applovin.exoplayer2.b.g> r8 = com.applovin.exoplayer2.b.g.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<com.applovin.exoplayer2.b.h> r8 = com.applovin.exoplayer2.b.h.class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r0] = r18     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r5] = r19     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r3] = r17     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            com.applovin.exoplayer2.ar r6 = (com.applovin.exoplayer2.ar) r6     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            int r7 = r2 + 1
            r9.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x006a }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.applovin.exoplayer2.l.q.g(r10, r2)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x006a }
            goto L_0x0074
        L_0x0068:
            r2 = r7
            goto L_0x0073
        L_0x006a:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating Opus extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0073:
            r7 = r2
        L_0x0074:
            java.lang.String r2 = "com.applovin.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<com.applovin.exoplayer2.b.g> r8 = com.applovin.exoplayer2.b.g.class
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<com.applovin.exoplayer2.b.h> r8 = com.applovin.exoplayer2.b.h.class
            r6[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r0] = r18     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r5] = r19     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r3] = r17     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            com.applovin.exoplayer2.ar r2 = (com.applovin.exoplayer2.ar) r2     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            int r6 = r7 + 1
            r9.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x00a7 }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.applovin.exoplayer2.l.q.g(r10, r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x00a7 }
            goto L_0x00b1
        L_0x00a5:
            r7 = r6
            goto L_0x00b0
        L_0x00a7:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FLAC extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00b0:
            r6 = r7
        L_0x00b1:
            java.lang.String r2 = "com.applovin.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<com.applovin.exoplayer2.b.g> r8 = com.applovin.exoplayer2.b.g.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<com.applovin.exoplayer2.b.h> r8 = com.applovin.exoplayer2.b.h.class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r0] = r18     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r5] = r19     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r3] = r17     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            com.applovin.exoplayer2.ar r0 = (com.applovin.exoplayer2.ar) r0     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r9.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.applovin.exoplayer2.l.q.g(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            goto L_0x00e9
        L_0x00e0:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FFmpeg extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.n.a(android.content.Context, int, com.applovin.exoplayer2.f.k, boolean, com.applovin.exoplayer2.b.h, android.os.Handler, com.applovin.exoplayer2.b.g, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, l lVar, Looper looper, int i, ArrayList<ar> arrayList) {
        arrayList.add(new m(lVar, looper));
    }

    /* access modifiers changed from: protected */
    public void a(Context context, e eVar, Looper looper, int i, ArrayList<ar> arrayList) {
        arrayList.add(new f(eVar, looper));
    }

    /* access modifiers changed from: protected */
    public void a(Context context, int i, ArrayList<ar> arrayList) {
        arrayList.add(new b());
    }

    /* access modifiers changed from: protected */
    public h a(Context context, boolean z, boolean z2, boolean z3) {
        return new com.applovin.exoplayer2.b.n(com.applovin.exoplayer2.b.e.d(context), new n.c(new com.applovin.exoplayer2.b.f[0]), z, z2, z3 ? 1 : 0);
    }
}
