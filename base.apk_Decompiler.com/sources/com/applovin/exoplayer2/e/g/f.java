package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.e.e;
import com.applovin.exoplayer2.g.e.h;
import com.applovin.exoplayer2.g.e.i;
import com.applovin.exoplayer2.g.e.l;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;

final class f {
    static final String[] Ay = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        if (r6 != null) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[LOOP:1: B:17:0x003e->B:18:0x0040, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r5, com.applovin.exoplayer2.g.a r6, com.applovin.exoplayer2.g.a r7, com.applovin.exoplayer2.v.a r8, com.applovin.exoplayer2.g.a... r9) {
        /*
            com.applovin.exoplayer2.g.a r0 = new com.applovin.exoplayer2.g.a
            r1 = 0
            com.applovin.exoplayer2.g.a$a[] r2 = new com.applovin.exoplayer2.g.a.C0047a[r1]
            r0.<init>((com.applovin.exoplayer2.g.a.C0047a[]) r2)
            r2 = 1
            if (r5 != r2) goto L_0x000e
            if (r6 == 0) goto L_0x003c
            goto L_0x003d
        L_0x000e:
            r6 = 2
            if (r5 != r6) goto L_0x003c
            if (r7 == 0) goto L_0x003c
            r5 = 0
        L_0x0014:
            int r6 = r7.kD()
            if (r5 >= r6) goto L_0x003c
            com.applovin.exoplayer2.g.a$a r6 = r7.de(r5)
            boolean r3 = r6 instanceof com.applovin.exoplayer2.g.f.a
            if (r3 == 0) goto L_0x0039
            com.applovin.exoplayer2.g.f.a r6 = (com.applovin.exoplayer2.g.f.a) r6
            java.lang.String r3 = "com.android.capture.fps"
            java.lang.String r4 = r6.Jx
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0039
            com.applovin.exoplayer2.g.a r5 = new com.applovin.exoplayer2.g.a
            com.applovin.exoplayer2.g.a$a[] r7 = new com.applovin.exoplayer2.g.a.C0047a[r2]
            r7[r1] = r6
            r5.<init>((com.applovin.exoplayer2.g.a.C0047a[]) r7)
            r6 = r5
            goto L_0x003d
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x003c:
            r6 = r0
        L_0x003d:
            int r5 = r9.length
        L_0x003e:
            if (r1 >= r5) goto L_0x0049
            r7 = r9[r1]
            com.applovin.exoplayer2.g.a r6 = r6.g(r7)
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0049:
            int r5 = r6.kD()
            if (r5 <= 0) goto L_0x0052
            r8.b((com.applovin.exoplayer2.g.a) r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.f.a(int, com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.v$a, com.applovin.exoplayer2.g.a[]):void");
    }

    public static void a(int i, r rVar, v.a aVar) {
        if (i == 1 && rVar.ij()) {
            aVar.Q(rVar.dO).R(rVar.dP);
        }
    }

    public static a.C0047a z(y yVar) {
        int il = yVar.il() + yVar.px();
        int px = yVar.px();
        int i = (px >> 24) & 255;
        if (i == 169 || i == 253) {
            int i2 = 16777215 & px;
            if (i2 == 6516084) {
                e b = b(px, yVar);
                yVar.fx(il);
                return b;
            } else if (i2 == 7233901 || i2 == 7631467) {
                l a = a(px, "TIT2", yVar);
                yVar.fx(il);
                return a;
            } else if (i2 == 6516589 || i2 == 7828084) {
                l a2 = a(px, "TCOM", yVar);
                yVar.fx(il);
                return a2;
            } else if (i2 == 6578553) {
                l a3 = a(px, "TDRC", yVar);
                yVar.fx(il);
                return a3;
            } else if (i2 == 4280916) {
                l a4 = a(px, "TPE1", yVar);
                yVar.fx(il);
                return a4;
            } else if (i2 == 7630703) {
                l a5 = a(px, "TSSE", yVar);
                yVar.fx(il);
                return a5;
            } else if (i2 == 6384738) {
                l a6 = a(px, "TALB", yVar);
                yVar.fx(il);
                return a6;
            } else if (i2 == 7108978) {
                l a7 = a(px, "USLT", yVar);
                yVar.fx(il);
                return a7;
            } else if (i2 == 6776174) {
                l a8 = a(px, "TCON", yVar);
                yVar.fx(il);
                return a8;
            } else if (i2 == 6779504) {
                l a9 = a(px, "TIT1", yVar);
                yVar.fx(il);
                return a9;
            }
        } else if (px == 1735291493) {
            try {
                return A(yVar);
            } finally {
                yVar.fx(il);
            }
        } else if (px == 1684632427) {
            l b2 = b(px, "TPOS", yVar);
            yVar.fx(il);
            return b2;
        } else if (px == 1953655662) {
            l b3 = b(px, "TRCK", yVar);
            yVar.fx(il);
            return b3;
        } else if (px == 1953329263) {
            h a10 = a(px, "TBPM", yVar, true, false);
            yVar.fx(il);
            return a10;
        } else if (px == 1668311404) {
            h a11 = a(px, "TCMP", yVar, true, true);
            yVar.fx(il);
            return a11;
        } else if (px == 1668249202) {
            com.applovin.exoplayer2.g.e.a B = B(yVar);
            yVar.fx(il);
            return B;
        } else if (px == 1631670868) {
            l a12 = a(px, "TPE2", yVar);
            yVar.fx(il);
            return a12;
        } else if (px == 1936682605) {
            l a13 = a(px, "TSOT", yVar);
            yVar.fx(il);
            return a13;
        } else if (px == 1936679276) {
            l a14 = a(px, "TSO2", yVar);
            yVar.fx(il);
            return a14;
        } else if (px == 1936679282) {
            l a15 = a(px, "TSOA", yVar);
            yVar.fx(il);
            return a15;
        } else if (px == 1936679265) {
            l a16 = a(px, "TSOP", yVar);
            yVar.fx(il);
            return a16;
        } else if (px == 1936679791) {
            l a17 = a(px, "TSOC", yVar);
            yVar.fx(il);
            return a17;
        } else if (px == 1920233063) {
            h a18 = a(px, "ITUNESADVISORY", yVar, false, false);
            yVar.fx(il);
            return a18;
        } else if (px == 1885823344) {
            h a19 = a(px, "ITUNESGAPLESS", yVar, false, true);
            yVar.fx(il);
            return a19;
        } else if (px == 1936683886) {
            l a20 = a(px, "TVSHOWSORT", yVar);
            yVar.fx(il);
            return a20;
        } else if (px == 1953919848) {
            l a21 = a(px, "TVSHOW", yVar);
            yVar.fx(il);
            return a21;
        } else if (px == 757935405) {
            h l = l(yVar, il);
            yVar.fx(il);
            return l;
        }
        q.f("MetadataUtil", "Skipped unknown metadata entry: " + a.ch(px));
        yVar.fx(il);
        return null;
    }

    public static com.applovin.exoplayer2.g.f.a a(y yVar, int i, String str) {
        while (true) {
            int il = yVar.il();
            if (il >= i) {
                return null;
            }
            int px = yVar.px();
            if (yVar.px() == 1684108385) {
                int px2 = yVar.px();
                int px3 = yVar.px();
                int i2 = px - 16;
                byte[] bArr = new byte[i2];
                yVar.r(bArr, 0, i2);
                return new com.applovin.exoplayer2.g.f.a(str, bArr, px3, px2);
            }
            yVar.fx(il + px);
        }
    }

    private static l a(int i, String str, y yVar) {
        int px = yVar.px();
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            return new l(str, (String) null, yVar.fC(px - 16));
        }
        q.h("MetadataUtil", "Failed to parse text attribute: " + a.ch(i));
        return null;
    }

    private static e b(int i, y yVar) {
        int px = yVar.px();
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            String fC = yVar.fC(px - 16);
            return new e("und", fC, fC);
        }
        q.h("MetadataUtil", "Failed to parse comment attribute: " + a.ch(i));
        return null;
    }

    private static h a(int i, String str, y yVar, boolean z, boolean z2) {
        int C = C(yVar);
        if (z2) {
            C = Math.min(1, C);
        }
        if (C < 0) {
            q.h("MetadataUtil", "Failed to parse uint8 attribute: " + a.ch(i));
            return null;
        } else if (z) {
            return new l(str, (String) null, Integer.toString(C));
        } else {
            return new e("und", str, Integer.toString(C));
        }
    }

    private static l b(int i, String str, y yVar) {
        int px = yVar.px();
        if (yVar.px() == 1684108385 && px >= 22) {
            yVar.fz(10);
            int pp = yVar.pp();
            if (pp > 0) {
                String str2 = "" + pp;
                int pp2 = yVar.pp();
                if (pp2 > 0) {
                    str2 = str2 + "/" + pp2;
                }
                return new l(str, (String) null, str2);
            }
        }
        q.h("MetadataUtil", "Failed to parse index/count attribute: " + a.ch(i));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.g.e.l A(com.applovin.exoplayer2.l.y r3) {
        /*
            int r3 = C(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = Ay
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.applovin.exoplayer2.g.e.l r1 = new com.applovin.exoplayer2.g.e.l
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.applovin.exoplayer2.l.q.h(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.f.A(com.applovin.exoplayer2.l.y):com.applovin.exoplayer2.g.e.l");
    }

    private static com.applovin.exoplayer2.g.e.a B(y yVar) {
        int px = yVar.px();
        if (yVar.px() == 1684108385) {
            int cg = a.cg(yVar.px());
            String str = cg == 13 ? "image/jpeg" : cg == 14 ? "image/png" : null;
            if (str == null) {
                q.h("MetadataUtil", "Unrecognized cover art flags: " + cg);
                return null;
            }
            yVar.fz(4);
            int i = px - 16;
            byte[] bArr = new byte[i];
            yVar.r(bArr, 0, i);
            return new com.applovin.exoplayer2.g.e.a(str, (String) null, 3, bArr);
        }
        q.h("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static h l(y yVar, int i) {
        String str = null;
        String str2 = null;
        int i2 = -1;
        int i3 = -1;
        while (yVar.il() < i) {
            int il = yVar.il();
            int px = yVar.px();
            int px2 = yVar.px();
            yVar.fz(4);
            if (px2 == 1835360622) {
                str = yVar.fC(px - 12);
            } else if (px2 == 1851878757) {
                str2 = yVar.fC(px - 12);
            } else {
                if (px2 == 1684108385) {
                    i2 = il;
                    i3 = px;
                }
                yVar.fz(px - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        yVar.fx(i2);
        yVar.fz(16);
        return new i(str, str2, yVar.fC(i3 - 16));
    }

    private static int C(y yVar) {
        yVar.fz(4);
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            return yVar.po();
        }
        q.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
