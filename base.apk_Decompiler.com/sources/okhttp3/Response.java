package okhttp3;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {
    @Nullable
    final ResponseBody body;
    @Nullable
    private volatile CacheControl cacheControl;
    @Nullable
    final Response cacheResponse;
    final int code;
    @Nullable
    final Handshake handshake;
    final Headers headers;
    final String message;
    @Nullable
    final Response networkResponse;
    @Nullable
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sentRequestAtMillis;

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public int code() {
        return this.code;
    }

    @Nullable
    public Handshake handshake() {
        return this.handshake;
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isRedirect() {
        int i = this.code;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case IronSourceConstants.OFFERWALL_AVAILABLE:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    Response(Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    @Nullable
    public String header(String str) {
        return header(str, (String) null);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.body.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.body.contentType(), clone.size(), clone);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl2 = this.cacheControl;
        if (cacheControl2 != null) {
            return cacheControl2;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public static class Builder {
        @Nullable
        ResponseBody body;
        @Nullable
        Response cacheResponse;
        int code;
        @Nullable
        Handshake handshake;
        Headers.Builder headers;
        String message;
        @Nullable
        Response networkResponse;
        @Nullable
        Response priorResponse;
        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;
        @Nullable
        Request request;
        long sentRequestAtMillis;

        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder handshake(@Nullable Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder request(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.networkResponse != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.cacheResponse != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.priorResponse != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            } else if (this.protocol == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.code < 0) {
                throw new IllegalStateException("code < 0: " + this.code);
            } else if (this.message != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }
}
