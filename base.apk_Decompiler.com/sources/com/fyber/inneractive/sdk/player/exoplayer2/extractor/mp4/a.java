package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class a {
    public static final int A = u.a("trun");
    public static final int A0 = u.a("udta");
    public static final int B = u.a("sidx");
    public static final int B0 = u.a("meta");
    public static final int C = u.a("moov");
    public static final int C0 = u.a("ilst");
    public static final int D = u.a("mvhd");
    public static final int D0 = u.a("mean");
    public static final int E = u.a("trak");
    public static final int E0 = u.a("name");
    public static final int F = u.a("mdia");
    public static final int F0 = u.a("data");
    public static final int G = u.a("minf");
    public static final int G0 = u.a("emsg");
    public static final int H = u.a("stbl");
    public static final int H0 = u.a("st3d");
    public static final int I = u.a("avcC");
    public static final int I0 = u.a("sv3d");
    public static final int J = u.a("hvcC");
    public static final int J0 = u.a("proj");
    public static final int K = u.a("esds");
    public static final int K0 = u.a("vp08");
    public static final int L = u.a("moof");
    public static final int L0 = u.a("vp09");
    public static final int M = u.a("traf");
    public static final int M0 = u.a("vpcC");
    public static final int N = u.a("mvex");
    public static final int N0 = u.a("camm");
    public static final int O = u.a("mehd");
    public static final int O0 = u.a("alac");
    public static final int P = u.a("tkhd");
    public static final int Q = u.a("edts");
    public static final int R = u.a("elst");
    public static final int S = u.a("mdhd");
    public static final int T = u.a("hdlr");
    public static final int U = u.a("stsd");
    public static final int V = u.a("pssh");
    public static final int W = u.a("sinf");
    public static final int X = u.a("schm");
    public static final int Y = u.a("schi");
    public static final int Z = u.a("tenc");
    public static final int a0 = u.a("encv");
    public static final int b = u.a("ftyp");
    public static final int b0 = u.a("enca");
    public static final int c = u.a("avc1");
    public static final int c0 = u.a("frma");
    public static final int d = u.a("avc3");
    public static final int d0 = u.a("saiz");
    public static final int e = u.a("hvc1");
    public static final int e0 = u.a("saio");
    public static final int f = u.a("hev1");
    public static final int f0 = u.a("sbgp");
    public static final int g = u.a("s263");
    public static final int g0 = u.a("sgpd");
    public static final int h = u.a("d263");
    public static final int h0 = u.a("uuid");
    public static final int i = u.a("mdat");
    public static final int i0 = u.a("senc");
    public static final int j = u.a("mp4a");
    public static final int j0 = u.a("pasp");
    public static final int k = u.a(".mp3");
    public static final int k0 = u.a("TTML");
    public static final int l = u.a("wave");
    public static final int l0 = u.a("mp4v");
    public static final int m = u.a("lpcm");
    public static final int m0 = u.a("stts");
    public static final int n = u.a("sowt");
    public static final int n0 = u.a("stss");
    public static final int o = u.a("ac-3");
    public static final int o0 = u.a("ctts");
    public static final int p = u.a("dac3");
    public static final int p0 = u.a("stsc");
    public static final int q = u.a("ec-3");
    public static final int q0 = u.a("stsz");
    public static final int r = u.a("dec3");
    public static final int r0 = u.a("stz2");
    public static final int s = u.a("dtsc");
    public static final int s0 = u.a("stco");
    public static final int t = u.a("dtsh");
    public static final int t0 = u.a("co64");
    public static final int u = u.a("dtsl");
    public static final int u0 = u.a("tx3g");
    public static final int v = u.a("dtse");
    public static final int v0 = u.a("wvtt");
    public static final int w = u.a("ddts");
    public static final int w0 = u.a("stpp");
    public static final int x = u.a("tfdt");
    public static final int x0 = u.a("c608");
    public static final int y = u.a("tfhd");
    public static final int y0 = u.a("samr");
    public static final int z = u.a("trex");
    public static final int z0 = u.a("sawb");
    public final int a;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a  reason: collision with other inner class name */
    public static final class C0120a extends a {
        public final long P0;
        public final List<b> Q0 = new ArrayList();
        public final List<C0120a> R0 = new ArrayList();

        public C0120a(int i, long j) {
            super(i);
            this.P0 = j;
        }

        public C0120a c(int i) {
            int size = this.R0.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0120a aVar = this.R0.get(i2);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public b d(int i) {
            int size = this.Q0.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.Q0.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        public String toString() {
            return a.a(this.a) + " leaves: " + Arrays.toString(this.Q0.toArray()) + " containers: " + Arrays.toString(this.R0.toArray());
        }
    }

    public static final class b extends a {
        public final k P0;

        public b(int i, k kVar) {
            super(i);
            this.P0 = kVar;
        }
    }

    static {
        u.a("vmhd");
    }

    public a(int i2) {
        this.a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public static int b(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return a(this.a);
    }
}
