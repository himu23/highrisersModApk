package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.metadata.a;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j {
    public static final g.a c = new a();
    public static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    public class a implements g.a {
    }

    public boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar) {
        int parseInt;
        int parseInt2;
        int i = 0;
        while (true) {
            a.b[] bVarArr = aVar.a;
            if (i >= bVarArr.length) {
                return false;
            }
            a.b bVar = bVarArr[i];
            if (bVar instanceof e) {
                e eVar = (e) bVar;
                String str = eVar.c;
                String str2 = eVar.d;
                if (!"iTunSMPB".equals(str)) {
                    continue;
                } else {
                    Matcher matcher = d.matcher(str2);
                    if (matcher.find()) {
                        try {
                            parseInt = Integer.parseInt(matcher.group(1), 16);
                            parseInt2 = Integer.parseInt(matcher.group(2), 16);
                            if (parseInt > 0 || parseInt2 > 0) {
                                this.a = parseInt;
                                this.b = parseInt2;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i++;
        }
        this.a = parseInt;
        this.b = parseInt2;
        return true;
    }
}
