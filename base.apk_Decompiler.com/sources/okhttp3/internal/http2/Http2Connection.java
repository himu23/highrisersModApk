package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    private long degradedPingsSent = 0;
    private long degradedPongDeadlineNs = 0;
    private long degradedPongsReceived = 0;
    final String hostname;
    /* access modifiers changed from: private */
    public long intervalPingsSent = 0;
    /* access modifiers changed from: private */
    public long intervalPongsReceived = 0;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* access modifiers changed from: package-private */
    public boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j;
        return j;
    }

    static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j;
        return j;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder2.pushObserver;
        boolean z = builder2.client;
        this.client = z;
        this.listener = builder2.listener;
        this.nextStreamId = builder2.client ? 1 : 2;
        if (builder2.client) {
            this.nextStreamId += 2;
        }
        if (builder2.client) {
            this.okHttpSettings.set(7, 16777216);
        }
        String str = builder2.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder2.pingIntervalMillis != 0) {
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new IntervalPingRunnable(), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, SupportMenu.USER_MASK);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) settings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new Http2Writer(builder2.sink, z);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, z));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream removeStream(int i) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateConnectionFlowControl(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return newStream(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.Http2Writer r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.shutdown     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0073 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.bytesLeftInWriteWindow     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.bytesLeftInWriteWindow     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r10.streams     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            okhttp3.internal.http2.Http2Writer r0 = r10.writer     // Catch:{ all -> 0x0076 }
            r0.synStream(r6, r8, r11, r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.client     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            okhttp3.internal.http2.Http2Writer r0 = r10.writer     // Catch:{ all -> 0x0076 }
            r0.pushPromise(r11, r8, r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            okhttp3.internal.http2.Http2Writer r11 = r10.writer
            r11.flush()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.writer.synReply(z, i, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.writer.maxDataLength());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            okhttp3.internal.http2.Http2Writer r3 = r8.writer     // Catch:{ all -> 0x0056 }
            int r3 = r3.maxDataLength()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.data(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int i, ErrorCode errorCode) {
        try {
            final int i2 = i;
            final ErrorCode errorCode2 = errorCode;
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i2, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int i, long j) {
        try {
            final int i2 = i;
            final long j2 = j;
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i2, j2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.hostname);
        }

        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.failConnection();
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: package-private */
    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    /* access modifiers changed from: package-private */
    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i = this.lastGoodStreamId;
                    this.writer.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public void start(boolean z) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - SupportMenu.USER_MASK));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isHealthy(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.shutdown     // Catch:{ all -> 0x001b }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r6)
            return r1
        L_0x0008:
            long r2 = r6.degradedPongsReceived     // Catch:{ all -> 0x001b }
            long r4 = r6.degradedPingsSent     // Catch:{ all -> 0x001b }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0018
            long r2 = r6.degradedPongDeadlineNs     // Catch:{ all -> 0x001b }
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0018
            monitor-exit(r6)
            return r1
        L_0x0018:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x001b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.isHealthy(long):boolean");
    }

    /* access modifiers changed from: package-private */
    public void sendDegradedPingLater() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j >= j2) {
                this.degradedPingsSent = j2 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
                try {
                    this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.hostname) {
                        public void execute() {
                            Http2Connection.this.writePing(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r4.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4.this$0.close(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r4.reader);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r2.readConnectionPreface(r4)     // Catch:{ IOException -> 0x001c }
            L_0x0009:
                okhttp3.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r3 = 0
                boolean r2 = r2.nextFrame(r3, r4)     // Catch:{ IOException -> 0x001c }
                if (r2 == 0) goto L_0x0013
                goto L_0x0009
            L_0x0013:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001c }
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x001a:
                r2 = move-exception
                goto L_0x002b
            L_0x001c:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.close(r0, r1)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                okhttp3.internal.http2.Http2Reader r0 = r4.reader
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x002b:
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0030 }
                r3.close(r0, r1)     // Catch:{ IOException -> 0x0030 }
            L_0x0030:
                okhttp3.internal.http2.Http2Reader r0 = r4.reader
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.execute():void");
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                Http2Connection.this.updateConnectionFlowControl(j);
                bufferedSource.skip(j);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
            r0.receiveHeaders(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.Header> r13) {
            /*
                r9 = this;
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                boolean r12 = r12.pushedStream(r11)
                if (r12 == 0) goto L_0x000e
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                r12.pushHeadersLater(r11, r13, r10)
                return
            L_0x000e:
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r12)
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream r0 = r0.getStream(r11)     // Catch:{ all -> 0x007f }
                if (r0 != 0) goto L_0x0075
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                boolean r0 = r0.shutdown     // Catch:{ all -> 0x007f }
                if (r0 == 0) goto L_0x0023
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0023:
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                int r0 = r0.lastGoodStreamId     // Catch:{ all -> 0x007f }
                if (r11 > r0) goto L_0x002b
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x002b:
                int r0 = r11 % 2
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                int r1 = r1.nextStreamId     // Catch:{ all -> 0x007f }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0037
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0037:
                okhttp3.Headers r8 = okhttp3.internal.Util.toHeaders(r13)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream r13 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                r10.lastGoodStreamId = r11     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r10 = r10.streams     // Catch:{ all -> 0x007f }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007f }
                r10.put(r0, r13)     // Catch:{ all -> 0x007f }
                java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$1 r0 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x007f }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007f }
                java.lang.String r3 = r3.hostname     // Catch:{ all -> 0x007f }
                r4 = 0
                r2[r4] = r3     // Catch:{ all -> 0x007f }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007f }
                r3 = 1
                r2[r3] = r11     // Catch:{ all -> 0x007f }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x007f }
                r10.execute(r0)     // Catch:{ all -> 0x007f }
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0075:
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                r0.receiveHeaders(r13)
                if (r10 == 0) goto L_0x007e
                r0.receiveFin()
            L_0x007e:
                return
            L_0x007f:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            try {
                final boolean z2 = z;
                final Settings settings2 = settings;
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) {
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z2, settings2);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|7|17|18|19|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0063 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void applyAndAckSettings(boolean r6, okhttp3.internal.http2.Settings r7) {
            /*
                r5 = this;
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
                okhttp3.internal.http2.Http2Writer r0 = r0.writer
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0098 }
                monitor-enter(r1)     // Catch:{ all -> 0x0098 }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Settings r2 = r2.peerSettings     // Catch:{ all -> 0x0095 }
                int r2 = r2.getInitialWindowSize()     // Catch:{ all -> 0x0095 }
                if (r6 == 0) goto L_0x0019
                okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0095 }
                r6.clear()     // Catch:{ all -> 0x0095 }
            L_0x0019:
                okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0095 }
                r6.merge(r7)     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0095 }
                int r6 = r6.getInitialWindowSize()     // Catch:{ all -> 0x0095 }
                r7 = -1
                r3 = 0
                if (r6 == r7) goto L_0x0054
                if (r6 == r2) goto L_0x0054
                int r6 = r6 - r2
                long r6 = (long) r6     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r2.streams     // Catch:{ all -> 0x0095 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0095 }
                if (r2 != 0) goto L_0x0056
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r2.streams     // Catch:{ all -> 0x0095 }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r3.streams     // Catch:{ all -> 0x0095 }
                int r3 = r3.size()     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Stream[] r3 = new okhttp3.internal.http2.Http2Stream[r3]     // Catch:{ all -> 0x0095 }
                java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Stream[] r2 = (okhttp3.internal.http2.Http2Stream[]) r2     // Catch:{ all -> 0x0095 }
                r3 = r2
                goto L_0x0056
            L_0x0054:
                r6 = 0
            L_0x0056:
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0063 }
                okhttp3.internal.http2.Http2Writer r1 = r1.writer     // Catch:{ IOException -> 0x0063 }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0063 }
                okhttp3.internal.http2.Settings r2 = r2.peerSettings     // Catch:{ IOException -> 0x0063 }
                r1.applyAndAckSettings(r2)     // Catch:{ IOException -> 0x0063 }
                goto L_0x0068
            L_0x0063:
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0098 }
                r1.failConnection()     // Catch:{ all -> 0x0098 }
            L_0x0068:
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                r0 = 0
                if (r3 == 0) goto L_0x007d
                int r1 = r3.length
                r2 = 0
            L_0x006e:
                if (r2 >= r1) goto L_0x007d
                r4 = r3[r2]
                monitor-enter(r4)
                r4.addBytesToWriteWindow(r6)     // Catch:{ all -> 0x007a }
                monitor-exit(r4)     // Catch:{ all -> 0x007a }
                int r2 = r2 + 1
                goto L_0x006e
            L_0x007a:
                r6 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x007a }
                throw r6
            L_0x007d:
                java.util.concurrent.ExecutorService r6 = okhttp3.internal.http2.Http2Connection.listenerExecutor
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$3 r7 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$3
                java.lang.String r1 = "OkHttp %s settings"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this
                java.lang.String r3 = r3.hostname
                r2[r0] = r3
                r7.<init>(r1, r2)
                r6.execute(r7)
                return
            L_0x0095:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                throw r6     // Catch:{ all -> 0x0098 }
            L_0x0098:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(boolean, okhttp3.internal.http2.Settings):void");
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    if (i == 1) {
                        try {
                            Http2Connection.access$108(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                boolean unused = Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.bytesLeftInWriteWindow += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }
    }

    /* access modifiers changed from: package-private */
    public void pushRequestLater(int i, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            try {
                final int i2 = i;
                final List<Header> list2 = list;
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
                    public void execute() {
                        if (Http2Connection.this.pushObserver.onRequest(i2, list2)) {
                            try {
                                Http2Connection.this.writer.rstStream(i2, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pushHeadersLater(int i, List<Header> list, boolean z) {
        try {
            final int i2 = i;
            final List<Header> list2 = list;
            final boolean z2 = z;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i2, list2, z2);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.writer.rstStream(i2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.pushObserver.onData(i3, buffer, i4, z2);
                        if (onData) {
                            Http2Connection.this.writer.rstStream(i3, ErrorCode.CANCEL);
                        }
                        if (onData || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    public void pushResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i2, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }
}
