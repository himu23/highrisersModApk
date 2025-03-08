package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.webkit.ProxyConfig;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.exoplayer2.k.t;
import com.applovin.exoplayer2.l.ai;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class q extends e implements t {
    private InputStream Zi;
    private boolean Zk;
    private Predicate<String> aaA;
    private HttpURLConnection aaB;
    private int aaC;
    private long aaD;
    private long aaE;
    private final boolean aau;
    private final int aav;
    private final int aaw;
    private final t.f aax;
    private final t.f aay;
    private final boolean aaz;
    private final String ta;
    private l tw;

    public static final class a implements t.b {
        private aa MH;
        private Predicate<String> aaA;
        private int aaF = GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY;
        private int aaG = GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY;
        private boolean aau;
        private final t.f aax = new t.f();
        private boolean aaz;
        private String ta;

        public a aO(String str) {
            this.ta = str;
            return this;
        }

        /* renamed from: ow */
        public q ox() {
            q qVar = new q(this.ta, this.aaF, this.aaG, this.aau, this.aax, this.aaA, this.aaz);
            aa aaVar = this.MH;
            if (aaVar != null) {
                qVar.c(aaVar);
            }
            return qVar;
        }
    }

    @Deprecated
    public q() {
        this((String) null, GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY, GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY);
    }

    @Deprecated
    public q(String str, int i, int i2) {
        this(str, i, i2, false, (t.f) null);
    }

    @Deprecated
    public q(String str, int i, int i2, boolean z, t.f fVar) {
        this(str, i, i2, z, fVar, (Predicate<String>) null, false);
    }

    private q(String str, int i, int i2, boolean z, t.f fVar, Predicate<String> predicate, boolean z2) {
        super(true);
        this.ta = str;
        this.aav = i;
        this.aaw = i2;
        this.aau = z;
        this.aax = fVar;
        this.aaA = predicate;
        this.aay = new t.f();
        this.aaz = z2;
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.aaB;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public Map<String, List<String>> kT() {
        HttpURLConnection httpURLConnection = this.aaB;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public long a(l lVar) throws t.c {
        byte[] bArr;
        this.tw = lVar;
        long j = 0;
        this.aaE = 0;
        this.aaD = 0;
        b(lVar);
        try {
            HttpURLConnection d = d(lVar);
            this.aaB = d;
            this.aaC = d.getResponseCode();
            String responseMessage = d.getResponseMessage();
            int i = this.aaC;
            long j2 = -1;
            if (i < 200 || i > 299) {
                Map headerFields = d.getHeaderFields();
                if (this.aaC == 416) {
                    if (lVar.uc == u.aQ(d.getHeaderField("Content-Range"))) {
                        this.Zk = true;
                        c(lVar);
                        if (lVar.wC != -1) {
                            return lVar.wC;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = d.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = ai.a(errorStream);
                    } catch (IOException unused) {
                        bArr = ai.ada;
                    }
                } else {
                    bArr = ai.ada;
                }
                byte[] bArr2 = bArr;
                ov();
                throw new t.e(this.aaC, responseMessage, this.aaC == 416 ? new j(2008) : null, headerFields, lVar, bArr2);
            }
            String contentType = d.getContentType();
            Predicate<String> predicate = this.aaA;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.aaC == 200 && lVar.uc != 0) {
                    j = lVar.uc;
                }
                boolean a2 = a(d);
                if (a2) {
                    this.aaD = lVar.wC;
                } else if (lVar.wC != -1) {
                    this.aaD = lVar.wC;
                } else {
                    long d2 = u.d(d.getHeaderField("Content-Length"), d.getHeaderField("Content-Range"));
                    if (d2 != -1) {
                        j2 = d2 - j;
                    }
                    this.aaD = j2;
                }
                try {
                    this.Zi = d.getInputStream();
                    if (a2) {
                        this.Zi = new GZIPInputStream(this.Zi);
                    }
                    this.Zk = true;
                    c(lVar);
                    try {
                        a(j, lVar);
                        return this.aaD;
                    } catch (IOException e) {
                        ov();
                        if (e instanceof t.c) {
                            throw ((t.c) e);
                        }
                        throw new t.c(e, lVar, 2000, 1);
                    }
                } catch (IOException e2) {
                    ov();
                    throw new t.c(e2, lVar, 2000, 1);
                }
            } else {
                ov();
                throw new t.d(contentType, lVar);
            }
        } catch (IOException e3) {
            ov();
            throw t.c.a(e3, lVar, 1);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws t.c {
        try {
            return l(bArr, i, i2);
        } catch (IOException e) {
            throw t.c.a(e, (l) ai.R(this.tw), 2);
        }
    }

    public void close() throws t.c {
        try {
            InputStream inputStream = this.Zi;
            if (inputStream != null) {
                long j = this.aaD;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.aaE;
                }
                a(this.aaB, j2);
                inputStream.close();
            }
            this.Zi = null;
            ov();
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
        } catch (IOException e) {
            throw new t.c(e, (l) ai.R(this.tw), 2000, 3);
        } catch (Throwable th) {
            this.Zi = null;
            ov();
            if (this.Zk) {
                this.Zk = false;
                oe();
            }
            throw th;
        }
    }

    private HttpURLConnection d(l lVar) throws IOException {
        HttpURLConnection a2;
        URL url;
        l lVar2 = lVar;
        URL url2 = new URL(lVar2.ef.toString());
        int i = lVar2.Zy;
        byte[] bArr = lVar2.Zz;
        long j = lVar2.uc;
        long j2 = lVar2.wC;
        boolean fg = lVar2.fg(1);
        if (!this.aau && !this.aaz) {
            return a(url2, i, bArr, j, j2, fg, true, lVar2.ZA);
        }
        int i2 = 0;
        URL url3 = url2;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 <= 20) {
                long j3 = j;
                long j4 = j;
                int i5 = i3;
                int i6 = i4;
                URL url4 = url3;
                long j5 = j2;
                a2 = a(url3, i3, bArr2, j3, j2, fg, false, lVar2.ZA);
                int responseCode = a2.getResponseCode();
                String headerField = a2.getHeaderField("Location");
                if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    a2.disconnect();
                    url3 = a(url4, headerField, lVar2);
                    i3 = i5;
                } else if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return a2;
                } else {
                    a2.disconnect();
                    if (!this.aaz || responseCode != 302) {
                        bArr2 = null;
                        url = url4;
                        i3 = 1;
                    } else {
                        i3 = i5;
                        url = url4;
                    }
                    url3 = a(url, headerField, lVar2);
                }
                i2 = i6;
                j = j4;
                j2 = j5;
            } else {
                throw new t.c((IOException) new NoRouteToHostException("Too many redirects: " + i4), lVar2, 2001, 1);
            }
        }
        return a2;
    }

    private HttpURLConnection a(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection a2 = a(url);
        a2.setConnectTimeout(this.aav);
        a2.setReadTimeout(this.aaw);
        HashMap hashMap = new HashMap();
        t.f fVar = this.aax;
        if (fVar != null) {
            hashMap.putAll(fVar.oy());
        }
        hashMap.putAll(this.aay.oy());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            a2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String A = u.A(j, j2);
        if (A != null) {
            a2.setRequestProperty("Range", A);
        }
        String str = this.ta;
        if (str != null) {
            a2.setRequestProperty("User-Agent", str);
        }
        a2.setRequestProperty("Accept-Encoding", z ? "gzip" : "identity");
        a2.setInstanceFollowRedirects(z2);
        a2.setDoOutput(bArr != null);
        a2.setRequestMethod(l.ff(i));
        if (bArr != null) {
            a2.setFixedLengthStreamingMode(bArr.length);
            a2.connect();
            OutputStream outputStream = a2.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            a2.connect();
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private URL a(URL url, String str, l lVar) throws t.c {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                    throw new t.c("Unsupported protocol redirect: " + protocol, lVar, 2001, 1);
                } else if (this.aau || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new t.c("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", lVar, 2001, 1);
                }
            } catch (MalformedURLException e) {
                throw new t.c((IOException) e, lVar, 2001, 1);
            }
        } else {
            throw new t.c("Null location redirect", lVar, 2001, 1);
        }
    }

    private void a(long j, l lVar) throws IOException {
        if (j != 0) {
            byte[] bArr = new byte[4096];
            while (j > 0) {
                int read = ((InputStream) ai.R(this.Zi)).read(bArr, 0, (int) Math.min(j, (long) 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new t.c((IOException) new InterruptedIOException(), lVar, 2000, 1);
                } else if (read != -1) {
                    j -= (long) read;
                    fe(read);
                } else {
                    throw new t.c(lVar, 2008, 1);
                }
            }
        }
    }

    private int l(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.aaD;
        if (j != -1) {
            long j2 = j - this.aaE;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j2);
        }
        int read = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.aaE += (long) read;
        fe(read);
        return read;
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (httpURLConnection != null && ai.acV >= 19 && ai.acV <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) com.applovin.exoplayer2.l.a.checkNotNull(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void ov() {
        HttpURLConnection httpURLConnection = this.aaB;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                com.applovin.exoplayer2.l.q.c("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.aaB = null;
        }
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }
}
