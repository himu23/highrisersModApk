package com.applovin.exoplayer2.l;

import android.media.MediaFormat;
import com.applovin.exoplayer2.m.b;
import java.nio.ByteBuffer;
import java.util.List;

public final class t {
    public static void a(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void a(MediaFormat mediaFormat, b bVar) {
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.yk);
            a(mediaFormat, "color-standard", bVar.yj);
            a(mediaFormat, "color-range", bVar.yl);
            a(mediaFormat, "hdr-static-info", bVar.adl);
        }
    }
}
