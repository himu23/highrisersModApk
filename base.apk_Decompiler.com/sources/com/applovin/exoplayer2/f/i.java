package com.applovin.exoplayer2.f;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.applovin.exoplayer2.c.h;
import com.applovin.exoplayer2.f.l;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import com.ironsource.m2;

public final class i {
    public final String Hr;
    public final MediaCodecInfo.CodecCapabilities Hs;
    public final boolean Ht;
    public final boolean Hu;
    public final boolean Hv;
    public final boolean Hw;
    public final boolean Hx;
    private final boolean Hy;
    public final String eg;
    public final boolean hi;
    public final String name;

    public String toString() {
        return this.name;
    }

    public static i a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new i(str, str2, str3, codecCapabilities, z, z2, z3, !z4 && codecCapabilities != null && a(codecCapabilities) && !M(str), codecCapabilities != null && c(codecCapabilities), z5 || (codecCapabilities != null && e(codecCapabilities)));
    }

    i(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.name = (String) a.checkNotNull(str);
        this.eg = str2;
        this.Hr = str3;
        this.Hs = codecCapabilities;
        this.Hv = z;
        this.Hw = z2;
        this.Hx = z3;
        this.Ht = z4;
        this.hi = z5;
        this.Hu = z6;
        this.Hy = u.aX(str2);
    }

    public MediaCodecInfo.CodecProfileLevel[] jV() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.Hs.profileLevels;
    }

    public boolean l(v vVar) throws l.b {
        boolean z = false;
        if (!m(vVar)) {
            return false;
        }
        if (!this.Hy) {
            if (ai.acV >= 21) {
                if (vVar.dM != -1 && !cS(vVar.dM)) {
                    return false;
                }
                if (vVar.dL == -1 || cT(vVar.dL)) {
                    return true;
                }
                return false;
            }
            return true;
        } else if (vVar.dE <= 0 || vVar.height <= 0) {
            return true;
        } else {
            if (ai.acV >= 21) {
                return a(vVar.dE, vVar.height, (double) vVar.dF);
            }
            if (vVar.dE * vVar.height <= l.kz()) {
                z = true;
            }
            if (!z) {
                K("legacyFrameSize, " + vVar.dE + "x" + vVar.height);
            }
            return z;
        }
    }

    public boolean m(v vVar) {
        String aZ;
        if (vVar.dw == null || this.eg == null || (aZ = u.aZ(vVar.dw)) == null) {
            return true;
        }
        if (!this.eg.equals(aZ)) {
            K("codec.mime " + vVar.dw + ", " + aZ);
            return false;
        }
        Pair<Integer, Integer> r = l.r(vVar);
        if (r == null) {
            return true;
        }
        int intValue = ((Integer) r.first).intValue();
        int intValue2 = ((Integer) r.second).intValue();
        if (!this.Hy && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] jV = jV();
        if (ai.acV <= 23 && "video/x-vnd.on2.vp9".equals(this.eg) && jV.length == 0) {
            jV = g(this.Hs);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : jV) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        K("codec.profileLevel, " + vVar.dw + ", " + aZ);
        return false;
    }

    public boolean jW() {
        if (ai.acV >= 29 && "video/x-vnd.on2.vp9".equals(this.eg)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : jV()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean n(v vVar) {
        if (this.Hy) {
            return this.Ht;
        }
        Pair<Integer, Integer> r = l.r(vVar);
        return r != null && ((Integer) r.first).intValue() == 42;
    }

    public h a(v vVar, v vVar2) {
        int i = !ai.r(vVar.dz, vVar2.dz) ? 8 : 0;
        if (this.Hy) {
            if (vVar.dG != vVar2.dG) {
                i |= 1024;
            }
            if (!this.Ht && !(vVar.dE == vVar2.dE && vVar.height == vVar2.height)) {
                i |= 512;
            }
            if (!ai.r(vVar.dK, vVar2.dK)) {
                i |= 2048;
            }
            if (N(this.name) && !vVar.a(vVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new h(this.name, vVar, vVar2, vVar.a(vVar2) ? 3 : 2, 0);
            }
        } else {
            if (vVar.dL != vVar2.dL) {
                i |= 4096;
            }
            if (vVar.dM != vVar2.dM) {
                i |= 8192;
            }
            if (vVar.dN != vVar2.dN) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.eg)) {
                Pair<Integer, Integer> r = l.r(vVar);
                Pair<Integer, Integer> r2 = l.r(vVar2);
                if (!(r == null || r2 == null)) {
                    int intValue = ((Integer) r.first).intValue();
                    int intValue2 = ((Integer) r2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new h(this.name, vVar, vVar2, 3, 0);
                    }
                }
            }
            if (!vVar.a(vVar2)) {
                i |= 32;
            }
            if (O(this.eg)) {
                i |= 2;
            }
            if (i == 0) {
                return new h(this.name, vVar, vVar2, 1, 0);
            }
        }
        return new h(this.name, vVar, vVar2, 0, i);
    }

    public boolean a(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            K("sizeAndRate.vCaps");
            return false;
        } else if (a(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !P(this.name) || !a(videoCapabilities, i2, i, d)) {
                K("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            L("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
            return true;
        }
    }

    public Point D(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i, i2);
    }

    public boolean cS(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            K("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            K("sampleRate.support, " + i);
            return false;
        }
    }

    public boolean cT(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            K("channelCount.aCaps");
            return false;
        } else if (a(this.name, this.eg, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        } else {
            K("channelCount.support, " + i);
            return false;
        }
    }

    private void K(String str) {
        q.f("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.eg + "] [" + ai.acZ + m2.i.e);
    }

    private void L(String str) {
        q.f("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.eg + "] [" + ai.acZ + m2.i.e);
    }

    private static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((ai.acV >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        if ("audio/ac3".equals(str2)) {
            i2 = 6;
        } else {
            i2 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        q.h("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + m2.i.e);
        return i2;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 19 && b(codecCapabilities);
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 21 && d(codecCapabilities);
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 21 && f(codecCapabilities);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point a = a(videoCapabilities, i, i2);
        int i3 = a.x;
        int i4 = a.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(ai.N(i, widthAlignment) * widthAlignment, ai.N(i2, heightAlignment) * heightAlignment);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = r3.getVideoCapabilities();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.media.MediaCodecInfo.CodecProfileLevel[] g(android.media.MediaCodecInfo.CodecCapabilities r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0018
            android.media.MediaCodecInfo$VideoCapabilities r3 = r3.getVideoCapabilities()
            if (r3 == 0) goto L_0x0018
            android.util.Range r3 = r3.getBitrateRange()
            java.lang.Comparable r3 = r3.getUpper()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            r1 = 180000000(0xaba9500, float:1.7967196E-32)
            r2 = 1
            if (r3 < r1) goto L_0x0022
            r3 = 1024(0x400, float:1.435E-42)
            goto L_0x0069
        L_0x0022:
            r1 = 120000000(0x7270e00, float:1.2567798E-34)
            if (r3 < r1) goto L_0x002a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x0069
        L_0x002a:
            r1 = 60000000(0x3938700, float:8.670878E-37)
            if (r3 < r1) goto L_0x0032
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0032:
            r1 = 30000000(0x1c9c380, float:7.411627E-38)
            if (r3 < r1) goto L_0x003a
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0069
        L_0x003a:
            r1 = 18000000(0x112a880, float:2.6936858E-38)
            if (r3 < r1) goto L_0x0042
            r3 = 64
            goto L_0x0069
        L_0x0042:
            r1 = 12000000(0xb71b00, float:1.6815582E-38)
            if (r3 < r1) goto L_0x004a
            r3 = 32
            goto L_0x0069
        L_0x004a:
            r1 = 7200000(0x6ddd00, float:1.0089349E-38)
            if (r3 < r1) goto L_0x0052
            r3 = 16
            goto L_0x0069
        L_0x0052:
            r1 = 3600000(0x36ee80, float:5.044674E-39)
            if (r3 < r1) goto L_0x005a
            r3 = 8
            goto L_0x0069
        L_0x005a:
            r1 = 1800000(0x1b7740, float:2.522337E-39)
            if (r3 < r1) goto L_0x0061
            r3 = 4
            goto L_0x0069
        L_0x0061:
            r1 = 800000(0xc3500, float:1.121039E-39)
            if (r3 < r1) goto L_0x0068
            r3 = 2
            goto L_0x0069
        L_0x0068:
            r3 = 1
        L_0x0069:
            android.media.MediaCodecInfo$CodecProfileLevel r1 = new android.media.MediaCodecInfo$CodecProfileLevel
            r1.<init>()
            r1.profile = r2
            r1.level = r3
            android.media.MediaCodecInfo$CodecProfileLevel[] r3 = new android.media.MediaCodecInfo.CodecProfileLevel[r2]
            r3[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.i.g(android.media.MediaCodecInfo$CodecCapabilities):android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    private static boolean M(String str) {
        return ai.acV <= 22 && ("ODROID-XU3".equals(ai.acY) || "Nexus 10".equals(ai.acY)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static boolean N(String str) {
        return ai.acY.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean O(String str) {
        return "audio/opus".equals(str);
    }

    private static final boolean P(String str) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(ai.acW);
    }
}
