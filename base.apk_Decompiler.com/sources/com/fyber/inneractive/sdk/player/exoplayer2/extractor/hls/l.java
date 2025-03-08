package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.text.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l implements f {
    public static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(\\d+)");
    public final String a;
    public final r b;
    public final k c = new k();
    public h d;
    public byte[] e = new byte[1024];
    public int f;

    public l(String str, r rVar) {
        this.a = str;
        this.b = rVar;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    public void b() {
    }

    public void a(h hVar) {
        this.d = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        throw new IllegalStateException();
    }

    public int a(g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws IOException, InterruptedException {
        Matcher matcher;
        String d2;
        int i;
        b bVar = (b) gVar;
        int i2 = (int) bVar.b;
        int i3 = this.f;
        byte[] bArr = this.e;
        if (i3 == bArr.length) {
            if (i2 != -1) {
                i = i2;
            } else {
                i = bArr.length;
            }
            this.e = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i4 = this.f;
        int a2 = bVar.a(bArr2, i4, bArr2.length - i4);
        if (a2 != -1) {
            int i5 = this.f + a2;
            this.f = i5;
            if (i2 == -1 || i5 != i2) {
                return 0;
            }
        }
        k kVar = new k(this.e);
        try {
            Pattern pattern = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a;
            String d3 = kVar.d();
            if (d3 == null || !com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.b.matcher(d3).matches()) {
                throw new a("Expected WEBVTT. Got " + d3);
            }
            long j = 0;
            long j2 = 0;
            while (true) {
                String d4 = kVar.d();
                if (TextUtils.isEmpty(d4)) {
                    while (true) {
                        String d5 = kVar.d();
                        if (d5 == null) {
                            matcher = null;
                            break;
                        } else if (com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a.matcher(d5).matches()) {
                            do {
                                d2 = kVar.d();
                                if (d2 == null) {
                                    break;
                                }
                            } while (d2.isEmpty());
                        } else {
                            matcher = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.a.a.matcher(d5);
                            if (matcher.matches()) {
                                break;
                            }
                        }
                    }
                    if (matcher == null) {
                        a(0);
                    } else {
                        long a3 = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a(matcher.group(1));
                        long a4 = this.b.a((j2 + a3) - j);
                        n a5 = a(a4 - a3);
                        this.c.a(this.e, this.f);
                        a5.a(this.c, this.f);
                        a5.a(a4, 1, this.f, 0, (byte[]) null);
                    }
                    return -1;
                } else if (d4.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher2 = g.matcher(d4);
                    if (matcher2.find()) {
                        Matcher matcher3 = h.matcher(d4);
                        if (matcher3.find()) {
                            j = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a(matcher2.group(1));
                            j2 = (Long.parseLong(matcher3.group(1)) * 1000000) / 90000;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("X-TIMESTAMP-MAP doesn't contain media timestamp: " + d4);
                        }
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("X-TIMESTAMP-MAP doesn't contain local timestamp: " + d4);
                    }
                }
            }
        } catch (a e2) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.l((Throwable) e2);
        }
    }

    public final n a(long j) {
        n a2 = this.d.a(0, 3);
        a2.a(i.a((String) null, "text/vtt", (String) null, -1, 0, this.a, -1, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, j, Collections.emptyList()));
        this.d.c();
        return a2;
    }
}
