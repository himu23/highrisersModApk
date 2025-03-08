package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.a;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.IronSourceSegment;

public final class e {
    public static final int A = u.a("sosn");
    public static final int B = u.a("tvsh");
    public static final int C = u.a("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    public static final int a = u.a("nam");
    public static final int b = u.a("trk");
    public static final int c = u.a("cmt");
    public static final int d = u.a("day");
    public static final int e = u.a("ART");
    public static final int f = u.a("too");
    public static final int g = u.a("alb");
    public static final int h = u.a("com");
    public static final int i = u.a("wrt");
    public static final int j = u.a("lyr");
    public static final int k = u.a(IronSourceSegment.GENDER);
    public static final int l = u.a("covr");
    public static final int m = u.a("gnre");
    public static final int n = u.a("grp");
    public static final int o = u.a("disk");
    public static final int p = u.a("trkn");
    public static final int q = u.a("tmpo");
    public static final int r = u.a("cpil");
    public static final int s = u.a("aART");
    public static final int t = u.a("sonm");
    public static final int u = u.a("soal");
    public static final int v = u.a("soar");
    public static final int w = u.a("soaa");
    public static final int x = u.a("soco");
    public static final int y = u.a("rtng");
    public static final int z = u.a("pgap");

    public static h a(k kVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int i5 = kVar.b;
            if (i5 >= i2) {
                break;
            }
            int c2 = kVar.c();
            int c3 = kVar.c();
            kVar.f(4);
            if (c3 == a.D0) {
                str = kVar.a(c2 - 12);
            } else if (c3 == a.E0) {
                str2 = kVar.a(c2 - 12);
            } else {
                if (c3 == a.F0) {
                    i3 = i5;
                    i4 = c2;
                }
                kVar.f(c2 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        kVar.e(i3);
        kVar.f(16);
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e("und", str2, kVar.a(i4 - 16));
    }

    public static j b(int i2, String str, k kVar) {
        int c2 = kVar.c();
        if (kVar.c() == a.F0) {
            kVar.f(8);
            return new j(str, (String) null, kVar.a(c2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.a(i2));
        return null;
    }

    public static int b(k kVar) {
        kVar.f(4);
        if (kVar.c() == a.F0) {
            kVar.f(8);
            return kVar.l();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e a(int i2, k kVar) {
        int c2 = kVar.c();
        if (kVar.c() == a.F0) {
            kVar.f(8);
            String a2 = kVar.a(c2 - 16);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e("und", a2, a2);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.a(i2));
        return null;
    }

    public static h a(int i2, String str, k kVar, boolean z2, boolean z3) {
        int b2 = b(kVar);
        if (z3) {
            b2 = Math.min(1, b2);
        }
        if (b2 < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i2));
            return null;
        } else if (z2) {
            return new j(str, (String) null, Integer.toString(b2));
        } else {
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e("und", str, Integer.toString(b2));
        }
    }

    public static j a(int i2, String str, k kVar) {
        int c2 = kVar.c();
        if (kVar.c() == a.F0 && c2 >= 22) {
            kVar.f(10);
            int q2 = kVar.q();
            if (q2 > 0) {
                String str2 = "" + q2;
                int q3 = kVar.q();
                if (q3 > 0) {
                    str2 = str2 + "/" + q3;
                }
                return new j(str, (String) null, str2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i2));
        return null;
    }

    public static a a(k kVar) {
        int c2 = kVar.c();
        if (kVar.c() == a.F0) {
            int c3 = kVar.c() & ViewCompat.MEASURED_SIZE_MASK;
            String str = c3 == 13 ? "image/jpeg" : c3 == 14 ? "image/png" : null;
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + c3);
                return null;
            }
            kVar.f(4);
            int i2 = c2 - 16;
            byte[] bArr = new byte[i2];
            System.arraycopy(kVar.a, kVar.b, bArr, 0, i2);
            kVar.b += i2;
            return new a(str, (String) null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }
}
