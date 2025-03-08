package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class d {
    public static final a a = new a("OMX.google.raw.decoder", (String) null, (MediaCodecInfo.CodecCapabilities) null, false);
    public static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap<a, List<a>> c = new HashMap<>();
    public static final SparseIntArray d;
    public static final SparseIntArray e;
    public static final Map<String, Integer> f;
    public static int g = -1;

    public static final class a {
        public final String a;
        public final boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (!TextUtils.equals(this.a, aVar.a) || this.b != aVar.b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    public static class b extends Exception {
        public b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d$d  reason: collision with other inner class name */
    public static final class C0123d implements c {
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        public boolean b() {
            return false;
        }

        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return MimeTypes.VIDEO_H264.equals(str);
        }
    }

    public static a a(String str, boolean z) throws b {
        List<T> list;
        c cVar;
        synchronized (d.class) {
            a aVar = new a(str, z);
            list = c.get(aVar);
            if (list == null) {
                int i = u.a;
                if (i >= 21) {
                    cVar = new e(z);
                } else {
                    cVar = new C0123d();
                }
                List<a> a2 = a(aVar, cVar);
                if (z && ((ArrayList) a2).isEmpty() && 21 <= i && i <= 23) {
                    a2 = a(aVar, (c) new C0123d());
                    ArrayList arrayList = (ArrayList) a2;
                    if (!arrayList.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((a) arrayList.get(0)).a);
                    }
                }
                if (i < 26) {
                    int i2 = 1;
                    if (a2.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(a2.get(0).a)) {
                        while (true) {
                            if (i2 >= a2.size()) {
                                break;
                            }
                            a aVar2 = a2.get(i2);
                            if ("OMX.google.raw.decoder".equals(aVar2.a)) {
                                a2.remove(i2);
                                a2.add(0, aVar2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                list = Collections.unmodifiableList(a2);
                c.put(aVar, list);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return (a) list.get(0);
    }

    public static final class e implements c {
        public final int a;
        public MediaCodecInfo[] b;

        public e(boolean z) {
            this.a = z ? 1 : 0;
        }

        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        public boolean b() {
            return true;
        }

        public int a() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.b.length;
        }

        public MediaCodecInfo a(int i) {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.b[i];
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    public static int a() throws b {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i;
        if (g == -1) {
            int i2 = 0;
            a a2 = a(MimeTypes.VIDEO_H264, false);
            if (a2 != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = a2.e;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = codecProfileLevelArr[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, u.a >= 21 ? 345600 : 172800);
            }
            g = i2;
        }
        return g;
    }

    public static List<a> a(a aVar, c cVar) throws b {
        ArrayList arrayList;
        String name;
        String str;
        boolean z;
        a aVar2 = aVar;
        c cVar2 = cVar;
        try {
            arrayList = new ArrayList();
            String str2 = aVar2.a;
            int a2 = cVar.a();
            boolean b2 = cVar.b();
            int i = 0;
            while (i < a2) {
                MediaCodecInfo a3 = cVar2.a(i);
                name = a3.getName();
                if (a(a3, name, b2)) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        str = supportedTypes[i2];
                        if (str.equalsIgnoreCase(str2)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str);
                            boolean a4 = cVar2.a(str2, capabilitiesForType);
                            if (u.a <= 22) {
                                String str3 = u.d;
                                if ((str3.equals("ODROID-XU3") || str3.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                    z = true;
                                    if ((b2 && aVar2.b == a4) || (!b2 && !aVar2.b)) {
                                        arrayList.add(new a(name, str2, capabilitiesForType, z));
                                    } else if (!b2 && a4) {
                                        arrayList.add(new a(name + ".secure", str2, capabilitiesForType, z));
                                        return arrayList;
                                    }
                                }
                            }
                            z = false;
                            if (b2 || aVar2.b == a4) {
                                arrayList.add(new a(name + ".secure", str2, capabilitiesForType, z));
                                return arrayList;
                            }
                            arrayList.add(new a(name, str2, capabilitiesForType, z));
                        }
                        i2++;
                        cVar2 = cVar;
                    }
                    continue;
                }
                i++;
                cVar2 = cVar;
            }
            return arrayList;
        } catch (Exception e2) {
            if (u.a <= 23) {
                if (!arrayList.isEmpty()) {
                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                }
            }
            Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str + ")");
            throw e2;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = u.a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(u.b)) {
            return false;
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str2 = u.b;
            if ("dlxu".equals(str2) || "protou".equals(str2) || "ville".equals(str2) || "villeplus".equals(str2) || "villec2".equals(str2) || str2.startsWith("gee") || "C6602".equals(str2) || "C6603".equals(str2) || "C6606".equals(str2) || "C6616".equals(str2) || "L36h".equals(str2) || "SO-02E".equals(str2)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str3 = u.b;
            if ("C1504".equals(str3) || "C1505".equals(str3) || "C1604".equals(str3) || "C1605".equals(str3)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(u.c)) {
            String str4 = u.b;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        if (i > 19 || !u.b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return true;
        }
        return false;
    }
}
