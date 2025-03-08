package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class h implements b {
    public int b = -1;
    public int c = -1;
    public g d;
    public float e = 1.0f;
    public float f = 1.0f;
    public ByteBuffer g;
    public ShortBuffer h;
    public ByteBuffer i;
    public long j;
    public long k;
    public boolean l;

    public h() {
        ByteBuffer byteBuffer = b.a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
    }

    public boolean d() {
        return Math.abs(this.e - 1.0f) >= 0.01f || Math.abs(this.f - 1.0f) >= 0.01f;
    }

    public int e() {
        return 2;
    }

    public int f() {
        return this.b;
    }

    public void flush() {
        g gVar = new g(this.c, this.b);
        this.d = gVar;
        gVar.o = this.e;
        gVar.p = this.f;
        this.i = b.a;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r1 = this;
            boolean r0 = r1.l
            if (r0 == 0) goto L_0x000e
            com.fyber.inneractive.sdk.player.exoplayer2.audio.g r0 = r1.d
            if (r0 == 0) goto L_0x000c
            int r0 = r0.r
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.h.b():boolean");
    }

    public void c() {
        int i2;
        g gVar = this.d;
        int i3 = gVar.q;
        float f2 = gVar.o;
        float f3 = gVar.p;
        int i4 = gVar.r + ((int) ((((((float) i3) / (f2 / f3)) + ((float) gVar.s)) / f3) + 0.5f));
        gVar.a((gVar.e * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = gVar.e * 2;
            int i6 = gVar.b;
            if (i5 >= i2 * i6) {
                break;
            }
            gVar.h[(i6 * i3) + i5] = 0;
            i5++;
        }
        gVar.q += i2;
        gVar.a();
        if (gVar.r > i4) {
            gVar.r = i4;
        }
        gVar.q = 0;
        gVar.t = 0;
        gVar.s = 0;
        this.l = true;
    }

    public void g() {
        this.d = null;
        ByteBuffer byteBuffer = b.a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
        this.b = -1;
        this.c = -1;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }

    public boolean a(int i2, int i3, int i4) throws b.a {
        if (i4 != 2) {
            throw new b.a(i2, i3, i4);
        } else if (this.c == i2 && this.b == i3) {
            return false;
        } else {
            this.c = i2;
            this.b = i3;
            return true;
        }
    }

    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.j += (long) remaining;
            g gVar = this.d;
            gVar.getClass();
            int remaining2 = asShortBuffer.remaining();
            int i2 = gVar.b;
            int i3 = remaining2 / i2;
            gVar.a(i3);
            asShortBuffer.get(gVar.h, gVar.q * gVar.b, ((i2 * i3) * 2) / 2);
            gVar.q += i3;
            gVar.a();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i4 = this.d.r * this.b * 2;
        if (i4 > 0) {
            if (this.g.capacity() < i4) {
                ByteBuffer order = ByteBuffer.allocateDirect(i4).order(ByteOrder.nativeOrder());
                this.g = order;
                this.h = order.asShortBuffer();
            } else {
                this.g.clear();
                this.h.clear();
            }
            g gVar2 = this.d;
            ShortBuffer shortBuffer = this.h;
            gVar2.getClass();
            int min = Math.min(shortBuffer.remaining() / gVar2.b, gVar2.r);
            shortBuffer.put(gVar2.j, 0, gVar2.b * min);
            int i5 = gVar2.r - min;
            gVar2.r = i5;
            short[] sArr = gVar2.j;
            int i6 = gVar2.b;
            System.arraycopy(sArr, min * i6, sArr, 0, i5 * i6);
            this.k += (long) i4;
            this.g.limit(i4);
            this.i = this.g;
        }
    }

    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.i;
        this.i = b.a;
        return byteBuffer;
    }
}
