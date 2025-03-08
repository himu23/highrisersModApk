package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.ironsource.m2;
import java.util.Arrays;

public final class j {
    public final Uri a;
    public final byte[] b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public j(Uri uri, int i) {
        this(uri, 0, -1, (String) null, i);
    }

    public boolean a(int i) {
        return (this.g & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.a + ", " + Arrays.toString(this.b) + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + m2.i.e;
    }

    public j(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, (String) null, i);
    }

    public j(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, (byte[]) null, j, j2, j3, str, i);
    }

    public j(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        a.a(j >= 0);
        a.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        a.a(z);
        this.a = uri;
        this.b = null;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = i;
    }
}
