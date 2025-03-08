package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class w0 extends h implements g {
    public final OkHttpClient a = new OkHttpClient().newBuilder().build();

    public static class a extends j {
        public final Response g;

        public a(j jVar, Response response) {
            this.g = response;
            a(jVar.d());
            a(jVar.b());
            a(jVar.c());
            a(jVar.e());
        }

        public void a() throws IOException {
            super.a();
            Response response = this.g;
            if (response != null) {
                response.close();
            }
        }
    }

    public <T> j a(c0<T> c0Var, String str, String str2) throws Exception {
        IAlog.a("%s okhttp network stack is in use", "OkHttpExecutorImpl");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0Var.a());
            Pair<List<String>, Response> a2 = a(c0Var.a(), c0Var, arrayList, str, str2);
            Object obj = a2.second;
            String message = obj != null ? ((Response) obj).message() : "";
            InputStream a3 = a((Response) a2.second);
            Object obj2 = a2.second;
            int code = obj2 == null ? -1 : ((Response) obj2).code();
            Map<String, List<String>> b = b((Response) a2.second);
            Response response = (Response) a2.second;
            a aVar = new a(a(a3, code, message, b, response != null ? response.headers().get("Last-Modified") : null), (Response) a2.second);
            for (String add : (List) a2.first) {
                aVar.f.add(add);
            }
            return aVar;
        } catch (b e) {
            IAlog.b("%s cannot connect exception: %s", "OkHttpExecutorImpl", e.getMessage());
            throw e;
        } catch (Exception e2) {
            IAlog.b("%s exception: %s", "OkHttpExecutorImpl", e2.getMessage());
            throw e2;
        }
    }

    public final Map<String, List<String>> b(Response response) {
        HashMap hashMap = new HashMap();
        if (response != null) {
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String name = headers.name(i);
                hashMap.put(name, Collections.singletonList(headers.get(name)));
            }
        }
        return hashMap;
    }

    public void b() {
    }

    public final <T> Pair<List<String>, Response> a(String str, c0<T> c0Var, List<String> list, String str2, String str3) throws Exception {
        String header;
        c0<T> c0Var2 = c0Var;
        List<String> list2 = list;
        u0 n = c0Var.n();
        Request.Builder builder = new Request.Builder();
        a(builder, "Accept-Encoding", "gzip");
        a(builder, "User-Agent", str2);
        a(builder, "If-Modified-Since", str3);
        Map<String, String> w = c0Var.w();
        if (w != null) {
            for (String next : w.keySet()) {
                a(builder, next, w.get(next));
            }
        }
        String str4 = str;
        builder.url(str);
        if (c0Var.r() == z.POST || c0Var.r() == z.PUT) {
            byte[] u = c0Var.u();
            if (u != null) {
                builder.post(RequestBody.create(u, MediaType.parse(c0Var.q())));
            } else {
                throw new Exception("Could not create ok http request. post payload is null");
            }
        }
        Request build = builder.build();
        OkHttpClient.Builder followSslRedirects = this.a.newBuilder().followRedirects(c0Var.l()).followSslRedirects(c0Var.l());
        long j = (long) n.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient build2 = followSslRedirects.connectTimeout(j, timeUnit).readTimeout((long) n.b, timeUnit).build();
        c0Var.b(System.currentTimeMillis());
        IAlog.a("OkHttpExecutorImpl: start connection timestamp: %s", c0Var.f());
        try {
            Response execute = build2.newCall(build).execute();
            if (c0Var.l() || (!((execute.code() > 300 && execute.code() < 304) || execute.code() == 307 || execute.code() == 308) || (header = execute.header("Location", "")) == null)) {
                Pair<List<String>, Response> pair = new Pair<>(list2, execute);
                c0Var.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
                return pair;
            }
            if (!header.startsWith(ProxyConfig.MATCH_HTTP) && !header.contains("://") && list.size() > 0) {
                Uri parse = Uri.parse(list2.get(list.size() - 1));
                header = String.format(header.startsWith("/") ? "%s://%s%s" : "%s://%s/%s", new Object[]{parse.getScheme(), parse.getHost(), header});
            }
            list2.add(header);
            if (list.size() <= 5) {
                Pair<List<String>, Response> a2 = a(header, c0Var, list, str2, str3);
                c0Var.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
                return a2;
            }
            throw new b("Url chain too big for us");
        } catch (Exception e) {
            throw new b((Throwable) e);
        } catch (Throwable th) {
            c0Var.a(System.currentTimeMillis());
            IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", c0Var.f());
            throw th;
        }
    }

    public final InputStream a(Response response) {
        if (response == null) {
            return null;
        }
        try {
            if (response.body() == null) {
                return null;
            }
            return a(response.body().byteStream(), TextUtils.equals("gzip", response.headers().get("content-encoding")));
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(Request.Builder builder, String str, String str2) {
        int i = IAlog.a;
        IAlog.a(1, (Exception) null, "%s %s : %s", "REQUEST_HEADER", str, str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            builder.addHeader(str, str2);
        }
    }
}
