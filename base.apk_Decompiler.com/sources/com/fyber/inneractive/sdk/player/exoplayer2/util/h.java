package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.text.TextUtils;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;

public final class h {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (trim.startsWith("vp9")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            return "audio/mp4a-latm";
        }
        if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (trim.startsWith("opus")) {
            return "audio/opus";
        }
        if (trim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        return null;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (d(str)) {
            return 1;
        }
        if (e(str)) {
            return 2;
        }
        if (m2.h.K0.equals(b(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
            return 4;
        }
        return -1;
    }

    public static boolean d(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(b(str));
    }

    public static boolean e(String str) {
        return MimeTypes.BASE_TYPE_VIDEO.equals(b(str));
    }
}
