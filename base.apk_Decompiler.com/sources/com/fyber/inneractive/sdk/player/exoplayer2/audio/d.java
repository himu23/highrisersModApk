package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class d implements b {
    public int b = -1;
    public int c = -1;
    public int[] d;
    public boolean e;
    public int[] f;
    public ByteBuffer g;
    public ByteBuffer h;
    public boolean i;

    public d() {
        ByteBuffer byteBuffer = b.a;
        this.g = byteBuffer;
        this.h = byteBuffer;
    }

    public boolean a(int i2, int i3, int i4) throws b.a {
        boolean z = !Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        } else if (i4 != 2) {
            throw new b.a(i2, i3, i4);
        } else if (!z && this.c == i2 && this.b == i3) {
            return false;
        } else {
            this.c = i2;
            this.b = i3;
            this.e = i3 != iArr.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.e = (i6 != i5) | this.e;
                    i5++;
                } else {
                    throw new b.a(i2, i3, i4);
                }
            }
        }
    }

    public boolean b() {
        return this.i && this.h == b.a;
    }

    public void c() {
        this.i = true;
    }

    public boolean d() {
        return this.e;
    }

    public int e() {
        return 2;
    }

    public int f() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    public void flush() {
        this.h = b.a;
        this.i = false;
    }

    public void g() {
        flush();
        this.g = b.a;
        this.b = -1;
        this.c = -1;
        this.f = null;
        this.e = false;
    }

    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.b * 2)) * this.f.length * 2;
        if (this.g.capacity() < length) {
            this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f) {
                this.g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.b * 2;
        }
        byteBuffer.position(limit);
        this.g.flip();
        this.h = this.g;
    }

    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.h;
        this.h = b.a;
        return byteBuffer;
    }
}
