package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.fyber.inneractive.sdk.util.u;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class y {
    public static final Pattern g = Pattern.compile("max-age=(\\d+)");
    public static final SimpleDateFormat h = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
    public final byte[] a;
    public final Map<String, String> b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;

    public y(byte[] bArr, Map<String, String> map, String str, String str2, int i, String str3) {
        this.a = bArr;
        this.b = map;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = str3;
    }

    public boolean a() {
        boolean z;
        String str;
        if (TextUtils.isEmpty(this.f)) {
            return false;
        }
        loop0:
        while (true) {
            z = true;
            for (String next : this.b.keySet()) {
                if (!z) {
                    break loop0;
                }
                if (next != null && next.equalsIgnoreCase("Cache-Control")) {
                    String str2 = this.b.get(next);
                    if (str2 != null) {
                        Pattern pattern = g;
                        Locale locale = Locale.ENGLISH;
                        Matcher matcher = pattern.matcher(str2.toLowerCase(locale));
                        int a2 = (!matcher.find() || matcher.groupCount() != 1) ? 0 : u.a(matcher.group(1), 0);
                        if ((str2.toLowerCase(locale).contains("public") || str2.toLowerCase(locale).contains("private") || ((long) a2) > TimeUnit.SECONDS.convert(1, TimeUnit.HOURS)) && !str2.toLowerCase(locale).contains("no-") && !str2.toLowerCase(locale).contains("must-")) {
                        }
                    } else {
                        continue;
                    }
                } else if (next == null || !next.equalsIgnoreCase("Vary")) {
                    if (next != null && next.equalsIgnoreCase("Pragma")) {
                        String str3 = this.b.get(next);
                        if (str3 != null) {
                            z = !str3.equalsIgnoreCase("no-cache");
                        }
                    } else if (!(next == null || !next.equalsIgnoreCase("Expires") || (str = this.b.get(next)) == null)) {
                        try {
                            Date parse = h.parse(str);
                            if (parse != null && parse.getTime() + TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS) > System.currentTimeMillis()) {
                            }
                        } catch (ParseException unused) {
                            continue;
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        return z;
    }

    public WebResourceResponse b() {
        return new WebResourceResponse(this.c, this.d, this.e, this.f, this.b, new ByteArrayInputStream(this.a));
    }
}
