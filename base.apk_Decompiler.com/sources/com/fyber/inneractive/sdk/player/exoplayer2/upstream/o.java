package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.i9;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class o implements g {
    public static final Pattern q = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> r = new AtomicReference<>();
    public final boolean a;
    public final int b;
    public final int c;
    public final String d;
    public final m<String> e = null;
    public final w f;
    public final w g;
    public final a0<? super o> h;
    public j i;
    public HttpURLConnection j;
    public InputStream k;
    public boolean l;
    public long m;
    public long n;
    public long o;
    public long p;

    public o(String str, m<String> mVar, a0<? super o> a0Var, int i2, int i3, boolean z, w wVar) {
        this.d = a.a(str);
        this.h = a0Var;
        this.g = new w();
        this.b = i2;
        this.c = i3;
        this.a = z;
        this.f = wVar;
    }

    public Uri a() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(j jVar) throws IOException {
        HttpURLConnection a2;
        j jVar2 = jVar;
        URL url = new URL(jVar2.a.toString());
        byte[] bArr = jVar2.b;
        long j2 = jVar2.d;
        long j3 = jVar2.e;
        boolean a3 = jVar2.a(1);
        if (!this.a) {
            return a(url, bArr, j2, j3, a3, true);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 <= 20) {
                long j4 = j2;
                int i4 = i3;
                a2 = a(url, bArr, j2, j3, a3, false);
                int responseCode = a2.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    String headerField = a2.getHeaderField("Location");
                    a2.disconnect();
                    if (headerField != null) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || ProxyConfig.MATCH_HTTP.equals(protocol)) {
                            bArr = null;
                            url = url2;
                            i2 = i4;
                            j2 = j4;
                        } else {
                            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
                        }
                    } else {
                        throw new ProtocolException("Null location redirect");
                    }
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i3);
            }
        }
        return a2;
    }

    public void close() throws t {
        try {
            if (this.k != null) {
                HttpURLConnection httpURLConnection = this.j;
                long j2 = this.n;
                if (j2 != -1) {
                    j2 -= this.p;
                }
                a(httpURLConnection, j2);
                this.k.close();
            }
            this.k = null;
            b();
            if (this.l) {
                this.l = false;
                a0<? super o> a0Var = this.h;
                if (a0Var != null) {
                    ((l) a0Var).a(this);
                }
            }
        } catch (IOException e2) {
            throw new t(e2, this.i, 3);
        } catch (Throwable th) {
            this.k = null;
            b();
            if (this.l) {
                this.l = false;
                a0<? super o> a0Var2 = this.h;
                if (a0Var2 != null) {
                    ((l) a0Var2).a(this);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r7 != 0) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r20) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.t {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "Unable to connect to "
            java.lang.String r0 = "Inconsistent headers ["
            r1.i = r2
            r4 = 0
            r1.p = r4
            r1.o = r4
            r6 = 1
            java.net.HttpURLConnection r7 = r19.b(r20)     // Catch:{ IOException -> 0x0161 }
            r1.j = r7     // Catch:{ IOException -> 0x0161 }
            int r3 = r7.getResponseCode()     // Catch:{ IOException -> 0x0144 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r3 < r7) goto L_0x0128
            r8 = 299(0x12b, float:4.19E-43)
            if (r3 <= r8) goto L_0x0025
            goto L_0x0128
        L_0x0025:
            java.net.HttpURLConnection r8 = r1.j
            java.lang.String r8 = r8.getContentType()
            com.fyber.inneractive.sdk.player.exoplayer2.util.m<java.lang.String> r9 = r1.e
            if (r9 == 0) goto L_0x003f
            boolean r9 = r9.a(r8)
            if (r9 == 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            r19.b()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.u r0 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.u
            r0.<init>(r8, r2)
            throw r0
        L_0x003f:
            if (r3 != r7) goto L_0x0048
            long r7 = r2.d
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r7 = r4
        L_0x0049:
            r1.m = r7
            boolean r3 = r2.a(r6)
            if (r3 != 0) goto L_0x0104
            long r7 = r2.e
            r9 = -1
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x005d
            r1.n = r7
            goto L_0x0108
        L_0x005d:
            java.net.HttpURLConnection r3 = r1.j
            java.lang.String r7 = "Content-Length"
            java.lang.String r7 = r3.getHeaderField(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r11 = "DefaultHttpDataSource"
            java.lang.String r12 = "]"
            if (r8 != 0) goto L_0x0088
            long r13 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x0074 }
            goto L_0x0089
        L_0x0074:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r13 = "Unexpected Content-Length ["
            r8.<init>(r13)
            r8.append(r7)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r11, r8)
        L_0x0088:
            r13 = r9
        L_0x0089:
            java.lang.String r8 = "Content-Range"
            java.lang.String r3 = r3.getHeaderField(r8)
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x00f5
            java.util.regex.Pattern r8 = q
            java.util.regex.Matcher r8 = r8.matcher(r3)
            boolean r15 = r8.find()
            if (r15 == 0) goto L_0x00f5
            r15 = 2
            java.lang.String r15 = r8.group(r15)     // Catch:{ NumberFormatException -> 0x00e1 }
            long r15 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException -> 0x00e1 }
            java.lang.String r8 = r8.group(r6)     // Catch:{ NumberFormatException -> 0x00e1 }
            long r17 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x00e1 }
            long r15 = r15 - r17
            r17 = 1
            long r9 = r15 + r17
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x00be
            r13 = r9
            goto L_0x00f5
        L_0x00be:
            int r4 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x00f5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00e1 }
            r4.<init>(r0)     // Catch:{ NumberFormatException -> 0x00e1 }
            r4.append(r7)     // Catch:{ NumberFormatException -> 0x00e1 }
            java.lang.String r0 = "] ["
            r4.append(r0)     // Catch:{ NumberFormatException -> 0x00e1 }
            r4.append(r3)     // Catch:{ NumberFormatException -> 0x00e1 }
            r4.append(r12)     // Catch:{ NumberFormatException -> 0x00e1 }
            java.lang.String r0 = r4.toString()     // Catch:{ NumberFormatException -> 0x00e1 }
            android.util.Log.w(r11, r0)     // Catch:{ NumberFormatException -> 0x00e1 }
            long r13 = java.lang.Math.max(r13, r9)     // Catch:{ NumberFormatException -> 0x00e1 }
            goto L_0x00f5
        L_0x00e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected Content-Range ["
            r0.<init>(r4)
            r0.append(r3)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r11, r0)
        L_0x00f5:
            r3 = -1
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0100
            long r3 = r1.m
            long r9 = r13 - r3
            goto L_0x0101
        L_0x0100:
            r9 = r3
        L_0x0101:
            r1.n = r9
            goto L_0x0108
        L_0x0104:
            long r3 = r2.e
            r1.n = r3
        L_0x0108:
            java.net.HttpURLConnection r0 = r1.j     // Catch:{ IOException -> 0x011e }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x011e }
            r1.k = r0     // Catch:{ IOException -> 0x011e }
            r1.l = r6
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.o> r0 = r1.h
            if (r0 == 0) goto L_0x011b
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r1, r2)
        L_0x011b:
            long r2 = r1.n
            return r2
        L_0x011e:
            r0 = move-exception
            r19.b()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.t r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.t
            r3.<init>((java.io.IOException) r0, (com.fyber.inneractive.sdk.player.exoplayer2.upstream.j) r2, (int) r6)
            throw r3
        L_0x0128:
            java.net.HttpURLConnection r0 = r1.j
            java.util.Map r0 = r0.getHeaderFields()
            r19.b()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.v r4 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.v
            r4.<init>(r3, r0, r2)
            r0 = 416(0x1a0, float:5.83E-43)
            if (r3 != r0) goto L_0x0143
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h r0 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
            r2 = 0
            r0.<init>(r2)
            r4.initCause(r0)
        L_0x0143:
            throw r4
        L_0x0144:
            r0 = move-exception
            r4 = r0
            r19.b()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.t r0 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.t
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            android.net.Uri r3 = r2.a
            java.lang.String r3 = r3.toString()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r0.<init>(r3, r4, r2, r6)
            throw r0
        L_0x0161:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.t r4 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.t
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            android.net.Uri r3 = r2.a
            java.lang.String r3 = r3.toString()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3, r0, r2, r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.o.a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j):long");
    }

    public final void c() throws IOException {
        if (this.o != this.m) {
            byte[] andSet = r.getAndSet((Object) null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j2 = this.o;
                long j3 = this.m;
                if (j2 != j3) {
                    int read = this.k.read(andSet, 0, (int) Math.min(j3 - j2, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        long j4 = (long) read;
                        this.o += j4;
                        a0<? super o> a0Var = this.h;
                        if (a0Var != null) {
                            l lVar = (l) a0Var;
                            synchronized (lVar) {
                                lVar.d += j4;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    r.set(andSet);
                    return;
                }
            }
        }
    }

    public final int b(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.n;
        if (j2 != -1) {
            long j3 = j2 - this.p;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = this.k.read(bArr, i2, i3);
        if (read != -1) {
            long j4 = (long) read;
            this.p += j4;
            a0<? super o> a0Var = this.h;
            if (a0Var != null) {
                l lVar = (l) a0Var;
                synchronized (lVar) {
                    lVar.d += j4;
                }
            }
            return read;
        } else if (this.n == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.j = null;
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws t {
        try {
            c();
            return b(bArr, i2, i3);
        } catch (IOException e2) {
            throw new t(e2, this.i, 2);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) throws IOException {
        Map<String, String> map;
        Map<String, String> map2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        w wVar = this.f;
        if (wVar != null) {
            synchronized (wVar) {
                if (wVar.b == null) {
                    wVar.b = Collections.unmodifiableMap(new HashMap(wVar.a));
                }
                map2 = wVar.b;
            }
            for (Map.Entry next : map2.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        w wVar2 = this.g;
        synchronized (wVar2) {
            if (wVar2.b == null) {
                wVar2.b = Collections.unmodifiableMap(new HashMap(wVar2.a));
            }
            map = wVar2.b;
        }
        for (Map.Entry next2 : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) next2.getKey(), (String) next2.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.d);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(i9.b);
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static void a(HttpURLConnection httpURLConnection, long j2) {
        int i2 = u.a;
        if (i2 == 19 || i2 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }
}
