package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;

public final class a {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final MediaCodecInfo.CodecCapabilities e;

    public a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z) {
        this.a = (String) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(str);
        this.d = str2;
        this.e = codecCapabilities;
        boolean z2 = true;
        this.b = !z && codecCapabilities != null && a(codecCapabilities);
        this.c = (codecCapabilities == null || !b(codecCapabilities)) ? false : z2;
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public boolean a(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        } else if (a(videoCapabilities, i, i2, d2)) {
            return true;
        } else {
            if (i >= i2 || !a(videoCapabilities, i2, i, d2)) {
                a("sizeAndRate.support, " + i + "x" + i2 + "x" + d2);
                return false;
            }
            Log.d("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d2) + "] [" + this.a + ", " + this.d + "] [" + u.e + m2.i.e);
            return true;
        }
    }

    public final void a(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.d + "] [" + u.e + m2.i.e);
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
    }
}
