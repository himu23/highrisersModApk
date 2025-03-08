package com.applovin.exoplayer2.f;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
    private static final Pattern IS = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<i>> IT = new HashMap<>();
    private static int IU = -1;

    private interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        MediaCodecInfo dd(int i);

        int kA();

        boolean kB();
    }

    private interface f<T> {
        int getScore(T t);
    }

    private static int cW(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int cX(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    private static int cY(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int cZ(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    private static int da(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return 256;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int db(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int dc(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static class b extends Exception {
        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static i ky() throws b {
        return a("audio/raw", false, false);
    }

    public static i a(String str, boolean z, boolean z2) throws b {
        List<i> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<i> getDecoderInfos(String str, boolean z, boolean z2) throws b {
        c cVar;
        synchronized (l.class) {
            a aVar = new a(str, z, z2);
            HashMap<a, List<i>> hashMap = IT;
            List<i> list = hashMap.get(aVar);
            if (list != null) {
                return list;
            }
            if (ai.acV >= 21) {
                cVar = new e(z, z2);
            } else {
                cVar = new d();
            }
            ArrayList<i> a2 = a(aVar, cVar);
            if (z && a2.isEmpty() && 21 <= ai.acV && ai.acV <= 23) {
                a2 = a(aVar, (c) new d());
                if (!a2.isEmpty()) {
                    q.h("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a2.get(0).name);
                }
            }
            a(str, (List<i>) a2);
            List<i> unmodifiableList = Collections.unmodifiableList(a2);
            hashMap.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static List<i> a(List<i> list, v vVar) {
        ArrayList arrayList = new ArrayList(list);
        a(arrayList, new l$$ExternalSyntheticLambda7(vVar));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(v vVar, i iVar) {
        try {
            return iVar.l(vVar) ? 1 : 0;
        } catch (b unused) {
            return -1;
        }
    }

    public static int kz() throws b {
        if (IU == -1) {
            int i = 0;
            i a2 = a(MimeTypes.VIDEO_H264, false, false);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] jV = a2.jV();
                int length = jV.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(cW(jV[i].level), i2);
                    i++;
                }
                i = Math.max(i2, ai.acV >= 21 ? 345600 : 172800);
            }
            IU = i;
        }
        return IU;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r3.equals("av01") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> r(com.applovin.exoplayer2.v r6) {
        /*
            java.lang.String r0 = r6.dw
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = r6.dw
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = "video/dolby-vision"
            java.lang.String r3 = r6.dz
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001f
            java.lang.String r6 = r6.dw
            android.util.Pair r6 = a((java.lang.String) r6, (java.lang.String[]) r0)
            return r6
        L_0x001f:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case 3004662: goto L_0x0071;
                case 3006243: goto L_0x0066;
                case 3006244: goto L_0x005b;
                case 3199032: goto L_0x0050;
                case 3214780: goto L_0x0045;
                case 3356560: goto L_0x003a;
                case 3624515: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = -1
            goto L_0x007a
        L_0x002f:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 6
            goto L_0x007a
        L_0x003a:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0043
            goto L_0x002d
        L_0x0043:
            r2 = 5
            goto L_0x007a
        L_0x0045:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x004e
            goto L_0x002d
        L_0x004e:
            r2 = 4
            goto L_0x007a
        L_0x0050:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0059
            goto L_0x002d
        L_0x0059:
            r2 = 3
            goto L_0x007a
        L_0x005b:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0064
            goto L_0x002d
        L_0x0064:
            r2 = 2
            goto L_0x007a
        L_0x0066:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x006f
            goto L_0x002d
        L_0x006f:
            r2 = 1
            goto L_0x007a
        L_0x0071:
            java.lang.String r4 = "av01"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x007a
            goto L_0x002d
        L_0x007a:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0093;
                case 2: goto L_0x0093;
                case 3: goto L_0x008c;
                case 4: goto L_0x008c;
                case 5: goto L_0x0085;
                case 6: goto L_0x007e;
                default: goto L_0x007d;
            }
        L_0x007d:
            return r1
        L_0x007e:
            java.lang.String r6 = r6.dw
            android.util.Pair r6 = d(r6, r0)
            return r6
        L_0x0085:
            java.lang.String r6 = r6.dw
            android.util.Pair r6 = e(r6, r0)
            return r6
        L_0x008c:
            java.lang.String r6 = r6.dw
            android.util.Pair r6 = b(r6, r0)
            return r6
        L_0x0093:
            java.lang.String r6 = r6.dw
            android.util.Pair r6 = c(r6, r0)
            return r6
        L_0x009a:
            java.lang.String r1 = r6.dw
            com.applovin.exoplayer2.m.b r6 = r6.dK
            android.util.Pair r6 = a((java.lang.String) r1, (java.lang.String[]) r0, (com.applovin.exoplayer2.m.b) r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.l.r(com.applovin.exoplayer2.v):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r1.Hu == false) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0106 A[SYNTHETIC, Splitter:B:63:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x012f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.applovin.exoplayer2.f.i> a(com.applovin.exoplayer2.f.l.a r24, com.applovin.exoplayer2.f.l.c r25) throws com.applovin.exoplayer2.f.l.b {
        /*
            r1 = r24
            r2 = r25
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0154 }
            r5.<init>()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r15 = r1.eg     // Catch:{ Exception -> 0x0154 }
            int r14 = r25.kA()     // Catch:{ Exception -> 0x0154 }
            boolean r13 = r25.kB()     // Catch:{ Exception -> 0x0154 }
            r0 = 0
            r12 = 0
        L_0x0019:
            if (r12 >= r14) goto L_0x0153
            android.media.MediaCodecInfo r0 = r2.dd(r12)     // Catch:{ Exception -> 0x0154 }
            boolean r6 = a(r0)     // Catch:{ Exception -> 0x0154 }
            if (r6 == 0) goto L_0x002d
        L_0x0025:
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x0125
        L_0x002d:
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x0154 }
            boolean r6 = a(r0, r11, r13, r15)     // Catch:{ Exception -> 0x0154 }
            if (r6 != 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            java.lang.String r10 = a((android.media.MediaCodecInfo) r0, (java.lang.String) r11, (java.lang.String) r15)     // Catch:{ Exception -> 0x0154 }
            if (r10 != 0) goto L_0x003f
            goto L_0x0025
        L_0x003f:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x00f4 }
            boolean r6 = r2.a(r4, r10, r9)     // Catch:{ Exception -> 0x00f4 }
            boolean r7 = r2.b(r4, r10, r9)     // Catch:{ Exception -> 0x00f4 }
            boolean r8 = r1.hi     // Catch:{ Exception -> 0x00f4 }
            if (r8 != 0) goto L_0x0051
            if (r7 != 0) goto L_0x0025
        L_0x0051:
            boolean r7 = r1.hi     // Catch:{ Exception -> 0x00f4 }
            if (r7 == 0) goto L_0x0058
            if (r6 != 0) goto L_0x0058
            goto L_0x0025
        L_0x0058:
            boolean r6 = r2.a(r3, r10, r9)     // Catch:{ Exception -> 0x00f4 }
            boolean r7 = r2.b(r3, r10, r9)     // Catch:{ Exception -> 0x00f4 }
            boolean r8 = r1.Hu     // Catch:{ Exception -> 0x00f4 }
            if (r8 != 0) goto L_0x0066
            if (r7 != 0) goto L_0x0025
        L_0x0066:
            boolean r7 = r1.Hu     // Catch:{ Exception -> 0x00f4 }
            if (r7 == 0) goto L_0x006d
            if (r6 != 0) goto L_0x006d
            goto L_0x0025
        L_0x006d:
            boolean r16 = c((android.media.MediaCodecInfo) r0)     // Catch:{ Exception -> 0x00f4 }
            boolean r17 = e(r0)     // Catch:{ Exception -> 0x00f4 }
            boolean r0 = g(r0)     // Catch:{ Exception -> 0x00f4 }
            if (r13 == 0) goto L_0x007f
            boolean r7 = r1.Hu     // Catch:{ Exception -> 0x00f4 }
            if (r7 == r6) goto L_0x0085
        L_0x007f:
            if (r13 != 0) goto L_0x00b8
            boolean r7 = r1.Hu     // Catch:{ Exception -> 0x00aa }
            if (r7 != 0) goto L_0x00b8
        L_0x0085:
            r18 = 0
            r19 = 0
            r6 = r11
            r7 = r15
            r8 = r10
            r20 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            r22 = r12
            r12 = r0
            r23 = r13
            r13 = r18
            r18 = r14
            r14 = r19
            com.applovin.exoplayer2.f.i r0 = com.applovin.exoplayer2.f.i.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00a8 }
            r5.add(r0)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x0125
        L_0x00a8:
            r0 = move-exception
            goto L_0x00b5
        L_0x00aa:
            r0 = move-exception
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
        L_0x00b5:
            r1 = r21
            goto L_0x00fe
        L_0x00b8:
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            if (r23 != 0) goto L_0x0125
            if (r6 == 0) goto L_0x0125
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r6.<init>()     // Catch:{ Exception -> 0x00a8 }
            r14 = r21
            r6.append(r14)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = ".secure"
            r6.append(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00f1 }
            r13 = 0
            r19 = 1
            r7 = r15
            r8 = r20
            r10 = r16
            r11 = r17
            r12 = r0
            r1 = r14
            r14 = r19
            com.applovin.exoplayer2.f.i r0 = com.applovin.exoplayer2.f.i.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00ef }
            r5.add(r0)     // Catch:{ Exception -> 0x00ef }
            return r5
        L_0x00ef:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f1:
            r0 = move-exception
            r1 = r14
            goto L_0x00fe
        L_0x00f4:
            r0 = move-exception
            r20 = r10
            r1 = r11
            r22 = r12
            r23 = r13
            r18 = r14
        L_0x00fe:
            int r6 = com.applovin.exoplayer2.l.ai.acV     // Catch:{ Exception -> 0x0154 }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x012f
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0154 }
            if (r6 != 0) goto L_0x012f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r0.<init>()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r6 = "Skipping codec "
            r0.append(r6)     // Catch:{ Exception -> 0x0154 }
            r0.append(r1)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0154 }
            com.applovin.exoplayer2.l.q.i(r8, r0)     // Catch:{ Exception -> 0x0154 }
        L_0x0125:
            int r12 = r22 + 1
            r1 = r24
            r14 = r18
            r13 = r23
            goto L_0x0019
        L_0x012f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r2.<init>()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x0154 }
            r2.append(r1)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x0154 }
            r1 = r20
            r2.append(r1)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0154 }
            com.applovin.exoplayer2.l.q.i(r8, r1)     // Catch:{ Exception -> 0x0154 }
            throw r0     // Catch:{ Exception -> 0x0154 }
        L_0x0153:
            return r5
        L_0x0154:
            r0 = move-exception
            com.applovin.exoplayer2.f.l$b r1 = new com.applovin.exoplayer2.f.l$b
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.l.a(com.applovin.exoplayer2.f.l$a, com.applovin.exoplayer2.f.l$c):java.util.ArrayList");
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (ai.acV < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (ai.acV < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(ai.acW) || ("Xiaomi".equals(ai.acX) && ai.acW.startsWith("HM")))) {
            return false;
        }
        if (ai.acV == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(ai.acW) || "protou".equals(ai.acW) || "ville".equals(ai.acW) || "villeplus".equals(ai.acW) || "villec2".equals(ai.acW) || ai.acW.startsWith("gee") || "C6602".equals(ai.acW) || "C6603".equals(ai.acW) || "C6606".equals(ai.acW) || "C6616".equals(ai.acW) || "L36h".equals(ai.acW) || "SO-02E".equals(ai.acW))) {
            return false;
        }
        if (ai.acV == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(ai.acW) || "C1505".equals(ai.acW) || "C1604".equals(ai.acW) || "C1605".equals(ai.acW))) {
            return false;
        }
        if (ai.acV < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(ai.acX) && (ai.acW.startsWith("zeroflte") || ai.acW.startsWith("zerolte") || ai.acW.startsWith("zenlte") || "SC-05G".equals(ai.acW) || "marinelteatt".equals(ai.acW) || "404SC".equals(ai.acW) || "SC-04G".equals(ai.acW) || "SCV31".equals(ai.acW)))) {
            return false;
        }
        if (ai.acV <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(ai.acX) && (ai.acW.startsWith("d2") || ai.acW.startsWith("serrano") || ai.acW.startsWith("jflte") || ai.acW.startsWith("santos") || ai.acW.startsWith("t0"))) {
            return false;
        }
        if (ai.acV <= 19 && ai.acW.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    private static void a(String str, List<i> list) {
        if ("audio/raw".equals(str)) {
            if (ai.acV < 26 && ai.acW.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(i.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
            }
            a(list, new l$$ExternalSyntheticLambda4());
        }
        if (ai.acV < 21 && list.size() > 1) {
            String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                a(list, new l$$ExternalSyntheticLambda5());
            }
        }
        if (ai.acV < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            list.add(list.remove(0));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int d(i iVar) {
        String str = iVar.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (ai.acV >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int c(i iVar) {
        return iVar.name.startsWith("OMX.google") ? 1 : 0;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        return ai.acV >= 29 && b(mediaCodecInfo);
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean c(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return d(mediaCodecInfo);
        }
        return !e(mediaCodecInfo);
    }

    private static boolean d(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return f(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || (!lowerCase.startsWith("omx.") && !lowerCase.startsWith("c2.")))) {
            return true;
        }
        return false;
    }

    private static boolean f(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean g(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return h(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        return !lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("c2.android.") && !lowerCase.startsWith("c2.google.");
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        if (strArr.length < 3) {
            q.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = IS.matcher(strArr[1]);
        if (!matcher.matches()) {
            q.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer X = X(group);
        if (X == null) {
            q.h("MediaCodecUtil", "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer Y = Y(str2);
        if (Y != null) {
            return new Pair<>(X, Y);
        }
        q.h("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        if (strArr.length < 4) {
            q.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = IS.matcher(strArr[1]);
        if (!matcher.matches()) {
            q.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if ("2".equals(group)) {
                i = 2;
            } else {
                q.h("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer W = W(str2);
        if (W != null) {
            return new Pair<>(Integer.valueOf(i), W);
        }
        q.h("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    private static Pair<Integer, Integer> c(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = parseInt;
            } else {
                q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int cX = cX(i2);
            if (cX == -1) {
                q.h("MediaCodecUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int cY = cY(i);
            if (cY != -1) {
                return new Pair<>(Integer.valueOf(cX), Integer.valueOf(cY));
            }
            q.h("MediaCodecUtil", "Unknown AVC level: " + i);
            return null;
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> d(String str, String[] strArr) {
        if (strArr.length < 3) {
            q.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int cZ = cZ(parseInt);
            if (cZ == -1) {
                q.h("MediaCodecUtil", "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int da = da(parseInt2);
            if (da != -1) {
                return new Pair<>(Integer.valueOf(cZ), Integer.valueOf(da));
            }
            q.h("MediaCodecUtil", "Unknown VP9 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr, com.applovin.exoplayer2.m.b bVar) {
        if (strArr.length < 4) {
            q.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                q.h("MediaCodecUtil", "Unknown AV1 profile: " + parseInt);
                return null;
            } else if (parseInt3 == 8 || parseInt3 == 10) {
                if (parseInt3 != 8) {
                    i = (bVar == null || !(bVar.adl != null || bVar.yk == 7 || bVar.yk == 6)) ? 2 : 4096;
                }
                int db = db(parseInt2);
                if (db != -1) {
                    return new Pair<>(Integer.valueOf(i), Integer.valueOf(db));
                }
                q.h("MediaCodecUtil", "Unknown AV1 level: " + parseInt2);
                return null;
            } else {
                q.h("MediaCodecUtil", "Unknown AV1 bit depth: " + parseInt3);
                return null;
            }
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> e(String str, String[] strArr) {
        int dc;
        if (strArr.length != 3) {
            q.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(u.fv(Integer.parseInt(strArr[1], 16))) && (dc = dc(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(dc), 0);
            }
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(f fVar, Object obj, Object obj2) {
        return fVar.getScore(obj2) - fVar.getScore(obj);
    }

    private static <T> void a(List<T> list, f<T> fVar) {
        Collections.sort(list, new l$$ExternalSyntheticLambda6(fVar));
    }

    private static final class e implements c {
        private final int IV;
        private MediaCodecInfo[] IW;

        public boolean kB() {
            return true;
        }

        public e(boolean z, boolean z2) {
            this.IV = (z || z2) ? 1 : 0;
        }

        public int kA() {
            kC();
            return this.IW.length;
        }

        public MediaCodecInfo dd(int i) {
            kC();
            return this.IW[i];
        }

        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        private void kC() {
            if (this.IW == null) {
                this.IW = new MediaCodecList(this.IV).getCodecInfos();
            }
        }
    }

    private static final class d implements c {
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public boolean kB() {
            return false;
        }

        private d() {
        }

        public int kA() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo dd(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }
    }

    private static final class a {
        public final boolean Hu;
        public final String eg;
        public final boolean hi;

        public a(String str, boolean z, boolean z2) {
            this.eg = str;
            this.Hu = z;
            this.hi = z2;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = (((this.eg.hashCode() + 31) * 31) + (this.Hu ? 1231 : 1237)) * 31;
            if (!this.hi) {
                i = 1237;
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.equals(this.eg, aVar.eg) && this.Hu == aVar.Hu && this.hi == aVar.hi) {
                return true;
            }
            return false;
        }
    }

    private static Integer W(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c2 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c2 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c2 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c2 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c2 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c2 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c2 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c2 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c2 = 8;
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c2 = 10;
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c2 = 13;
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c2 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c2 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c2 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c2 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c2 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c2 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c2 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c2 = 25;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    private static Integer X(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            default:
                return null;
        }
    }

    private static Integer Y(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            default:
                return null;
        }
    }
}
