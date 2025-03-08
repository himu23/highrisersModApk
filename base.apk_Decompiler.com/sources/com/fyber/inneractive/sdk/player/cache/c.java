package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c implements Closeable {
    public static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream q = new b();
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public long h = 0;
    public Writer i;
    public final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    public int k;
    public e l;
    public long m = 0;
    public final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> o = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object call() throws java.lang.Exception {
            /*
                r3 = this;
                com.fyber.inneractive.sdk.player.cache.c r0 = com.fyber.inneractive.sdk.player.cache.c.this
                monitor-enter(r0)
                com.fyber.inneractive.sdk.player.cache.c r1 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0023 }
                java.io.Writer r2 = r1.i     // Catch:{ all -> 0x0023 }
                if (r2 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0023 }
                goto L_0x0021
            L_0x000b:
                r1.f()     // Catch:{ all -> 0x0023 }
                com.fyber.inneractive.sdk.player.cache.c r1 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0023 }
                boolean r1 = r1.b()     // Catch:{ all -> 0x0023 }
                if (r1 == 0) goto L_0x0020
                com.fyber.inneractive.sdk.player.cache.c r1 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0023 }
                r1.e()     // Catch:{ all -> 0x0023 }
                com.fyber.inneractive.sdk.player.cache.c r1 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0023 }
                r2 = 0
                r1.k = r2     // Catch:{ all -> 0x0023 }
            L_0x0020:
                monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            L_0x0021:
                r0 = 0
                return r0
            L_0x0023:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0023 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.a.call():java.lang.Object");
        }
    }

    public class b extends OutputStream {
        public void write(int i) throws IOException {
        }
    }

    public interface e {
    }

    public final class f implements Closeable {
        public final InputStream[] a;

        public f(c cVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }

        public void close() {
            for (InputStream a2 : this.a) {
                m.a((Closeable) a2);
            }
        }
    }

    public c(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.a = file2;
        this.e = i2;
        this.b = new File(file2, "journal");
        this.c = new File(file2, "journal.tmp");
        this.d = new File(file2, "journal.bkp");
        this.g = i3;
        this.f = j2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r10.k++;
        r10.i.append("READ " + r11 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (b() == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r10.n.submit(r10.o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        return new com.fyber.inneractive.sdk.player.cache.c.f(r10, r11, r0.e, r8, r0.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006e */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.fyber.inneractive.sdk.player.cache.c.f b(java.lang.String r11) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            r10.a()     // Catch:{ all -> 0x007e }
            r10.e(r11)     // Catch:{ all -> 0x007e }
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r0 = r10.j     // Catch:{ all -> 0x007e }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x007e }
            com.fyber.inneractive.sdk.player.cache.c$d r0 = (com.fyber.inneractive.sdk.player.cache.c.d) r0     // Catch:{ all -> 0x007e }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r10)
            return r1
        L_0x0014:
            boolean r2 = r0.c     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x001a
            monitor-exit(r10)
            return r1
        L_0x001a:
            int r2 = r10.g     // Catch:{ all -> 0x007e }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x007e }
            r2 = 0
            r3 = 0
        L_0x0020:
            int r4 = r10.g     // Catch:{ FileNotFoundException -> 0x006e }
            if (r3 >= r4) goto L_0x0032
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006e }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x006e }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x006e }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x006e }
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0032:
            int r1 = r10.k     // Catch:{ all -> 0x007e }
            int r1 = r1 + 1
            r10.k = r1     // Catch:{ all -> 0x007e }
            java.io.Writer r1 = r10.i     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r2.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x007e }
            r2.append(r11)     // Catch:{ all -> 0x007e }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007e }
            r1.append(r2)     // Catch:{ all -> 0x007e }
            boolean r1 = r10.b()     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0060
            java.util.concurrent.ThreadPoolExecutor r1 = r10.n     // Catch:{ all -> 0x007e }
            java.util.concurrent.Callable<java.lang.Void> r2 = r10.o     // Catch:{ all -> 0x007e }
            r1.submit(r2)     // Catch:{ all -> 0x007e }
        L_0x0060:
            com.fyber.inneractive.sdk.player.cache.c$f r1 = new com.fyber.inneractive.sdk.player.cache.c$f     // Catch:{ all -> 0x007e }
            long r6 = r0.e     // Catch:{ all -> 0x007e }
            long[] r9 = r0.b     // Catch:{ all -> 0x007e }
            r3 = r1
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r8, r9)     // Catch:{ all -> 0x007e }
            monitor-exit(r10)
            return r1
        L_0x006e:
            int r11 = r10.g     // Catch:{ all -> 0x007e }
            if (r2 >= r11) goto L_0x007c
            r11 = r8[r2]     // Catch:{ all -> 0x007e }
            if (r11 == 0) goto L_0x007c
            com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r11)     // Catch:{ all -> 0x007e }
            int r2 = r2 + 1
            goto L_0x006e
        L_0x007c:
            monitor-exit(r10)
            return r1
        L_0x007e:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.b(java.lang.String):com.fyber.inneractive.sdk.player.cache.c$f");
    }

    public final void c(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            d dVar = this.j.get(str2);
            if (dVar == null) {
                dVar = new d(str2);
                this.j.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.c = true;
                dVar.d = null;
                if (split.length == c.this.g) {
                    int i3 = 0;
                    while (i3 < split.length) {
                        try {
                            dVar.b[i3] = Long.parseLong(split[i3]);
                            i3++;
                        } catch (NumberFormatException unused2) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(split));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.d = new C0107c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public synchronized void close() throws IOException {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                C0107c cVar = ((d) it.next()).d;
                if (cVar != null) {
                    cVar.a();
                }
            }
            f();
            this.i.close();
            this.i = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.k = r0 - r9.j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        if (r2.e == -1) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        r9.i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.b, true), com.fyber.inneractive.sdk.player.cache.m.a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0063 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0063=Splitter:B:16:0x0063, B:23:0x008f=Splitter:B:23:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            com.fyber.inneractive.sdk.player.cache.l r2 = new com.fyber.inneractive.sdk.player.cache.l
            java.io.FileInputStream r3 = new java.io.FileInputStream
            java.io.File r4 = r9.b
            r3.<init>(r4)
            java.nio.charset.Charset r4 = com.fyber.inneractive.sdk.player.cache.m.a
            r5 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r5, r4)
            java.lang.String r3 = r2.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r4 = r2.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = r2.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r6 = r2.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = r2.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = "libcore.io.DiskLruCache"
            boolean r8 = r8.equals(r3)     // Catch:{ all -> 0x00b8 }
            if (r8 == 0) goto L_0x008f
            java.lang.String r8 = "1"
            boolean r8 = r8.equals(r4)     // Catch:{ all -> 0x00b8 }
            if (r8 == 0) goto L_0x008f
            int r8 = r9.e     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x00b8 }
            boolean r5 = r8.equals(r5)     // Catch:{ all -> 0x00b8 }
            if (r5 == 0) goto L_0x008f
            int r5 = r9.g     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x00b8 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x00b8 }
            if (r5 == 0) goto L_0x008f
            java.lang.String r5 = ""
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x00b8 }
            if (r5 == 0) goto L_0x008f
            r0 = 0
        L_0x0059:
            java.lang.String r1 = r2.b()     // Catch:{ EOFException -> 0x0063 }
            r9.c(r1)     // Catch:{ EOFException -> 0x0063 }
            int r0 = r0 + 1
            goto L_0x0059
        L_0x0063:
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r1 = r9.j     // Catch:{ all -> 0x00b8 }
            int r1 = r1.size()     // Catch:{ all -> 0x00b8 }
            int r0 = r0 - r1
            r9.k = r0     // Catch:{ all -> 0x00b8 }
            int r0 = r2.e     // Catch:{ all -> 0x00b8 }
            r1 = -1
            if (r0 != r1) goto L_0x0075
            r9.e()     // Catch:{ all -> 0x00b8 }
            goto L_0x008b
        L_0x0075:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00b8 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00b8 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b8 }
            java.io.File r4 = r9.b     // Catch:{ all -> 0x00b8 }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00b8 }
            java.nio.charset.Charset r4 = com.fyber.inneractive.sdk.player.cache.m.a     // Catch:{ all -> 0x00b8 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x00b8 }
            r0.<init>(r1)     // Catch:{ all -> 0x00b8 }
            r9.i = r0     // Catch:{ all -> 0x00b8 }
        L_0x008b:
            com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r2)
            return
        L_0x008f:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r8.<init>(r1)     // Catch:{ all -> 0x00b8 }
            r8.append(r3)     // Catch:{ all -> 0x00b8 }
            r8.append(r0)     // Catch:{ all -> 0x00b8 }
            r8.append(r4)     // Catch:{ all -> 0x00b8 }
            r8.append(r0)     // Catch:{ all -> 0x00b8 }
            r8.append(r6)     // Catch:{ all -> 0x00b8 }
            r8.append(r0)     // Catch:{ all -> 0x00b8 }
            r8.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = "]"
            r8.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x00b8 }
            r5.<init>(r0)     // Catch:{ all -> 0x00b8 }
            throw r5     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.d():void");
    }

    /* renamed from: com.fyber.inneractive.sdk.player.cache.c$c  reason: collision with other inner class name */
    public final class C0107c {
        public final d a;
        public final boolean[] b;
        public boolean c;

        /* renamed from: com.fyber.inneractive.sdk.player.cache.c$c$a */
        public class a extends FilterOutputStream {
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = C0107c.this.c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = C0107c.this.c = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = C0107c.this.c = true;
                }
            }

            public a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = C0107c.this.c = true;
                }
            }
        }

        public C0107c(d dVar) {
            this.a = dVar;
            this.b = dVar.c ? null : new boolean[c.this.g];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0022 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream a(int r5) throws java.io.IOException {
            /*
                r4 = this;
                if (r5 < 0) goto L_0x0042
                com.fyber.inneractive.sdk.player.cache.c r0 = com.fyber.inneractive.sdk.player.cache.c.this
                int r1 = r0.g
                if (r5 >= r1) goto L_0x0042
                monitor-enter(r0)
                com.fyber.inneractive.sdk.player.cache.c$d r1 = r4.a     // Catch:{ all -> 0x003f }
                com.fyber.inneractive.sdk.player.cache.c$c r2 = r1.d     // Catch:{ all -> 0x003f }
                if (r2 != r4) goto L_0x0039
                boolean r2 = r1.c     // Catch:{ all -> 0x003f }
                if (r2 != 0) goto L_0x0018
                boolean[] r2 = r4.b     // Catch:{ all -> 0x003f }
                r3 = 1
                r2[r5] = r3     // Catch:{ all -> 0x003f }
            L_0x0018:
                java.io.File r5 = r1.b(r5)     // Catch:{ all -> 0x003f }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0022 }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0022 }
                goto L_0x002e
            L_0x0022:
                com.fyber.inneractive.sdk.player.cache.c r1 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x003f }
                java.io.File r1 = r1.a     // Catch:{ all -> 0x003f }
                r1.mkdirs()     // Catch:{ all -> 0x003f }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0035 }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0035 }
            L_0x002e:
                com.fyber.inneractive.sdk.player.cache.c$c$a r5 = new com.fyber.inneractive.sdk.player.cache.c$c$a     // Catch:{ all -> 0x003f }
                r5.<init>(r1)     // Catch:{ all -> 0x003f }
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return r5
            L_0x0035:
                java.io.OutputStream r5 = com.fyber.inneractive.sdk.player.cache.c.q     // Catch:{ all -> 0x003f }
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return r5
            L_0x0039:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003f }
                r5.<init>()     // Catch:{ all -> 0x003f }
                throw r5     // Catch:{ all -> 0x003f }
            L_0x003f:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r5
            L_0x0042:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Expected index "
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r5 = " to be greater than 0 and less than the maximum value count of "
                r1.append(r5)
                com.fyber.inneractive.sdk.player.cache.c r5 = com.fyber.inneractive.sdk.player.cache.c.this
                int r5 = r5.g
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.C0107c.a(int):java.io.OutputStream");
        }

        public void a() throws IOException {
            c.a(c.this, this, false);
        }
    }

    public final class d {
        public final String a;
        public final long[] b;
        public boolean c;
        public C0107c d;
        public long e;

        public d(String str) {
            this.a = str;
            this.b = new long[c.this.g];
        }

        public File b(int i) {
            File file = c.this.a;
            return new File(file, this.a + "." + i + ".tmp");
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public File a(int i) {
            File file = c.this.a;
            return new File(file, this.a + "." + i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.fyber.inneractive.sdk.player.cache.c r9, com.fyber.inneractive.sdk.player.cache.c.C0107c r10, boolean r11) throws java.io.IOException {
        /*
            monitor-enter(r9)
            com.fyber.inneractive.sdk.player.cache.c$d r0 = r10.a     // Catch:{ all -> 0x00fb }
            com.fyber.inneractive.sdk.player.cache.c$c r1 = r0.d     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0046
            boolean r2 = r0.c     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0046
            r2 = 0
        L_0x000f:
            int r3 = r9.g     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0046
            boolean[] r3 = r10.b     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002c
            java.io.File r3 = r0.b(r2)     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x0029
            r10.a()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            goto L_0x00f4
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002c:
            r10.a()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0046:
            int r10 = r9.g     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x0076
            java.io.File r10 = r0.b(r1)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0070
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x0073
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x00fb }
            r10.renameTo(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.b     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            long r5 = r2.length()     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.b     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.h     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.h = r7     // Catch:{ all -> 0x00fb }
            goto L_0x0073
        L_0x0070:
            a((java.io.File) r10)     // Catch:{ all -> 0x00fb }
        L_0x0073:
            int r1 = r1 + 1
            goto L_0x0046
        L_0x0076:
            int r10 = r9.k     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.k = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.d = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.c     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00b7
            boolean unused = r0.c = r1     // Catch:{ all -> 0x00fb }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r1.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r0.a     // Catch:{ all -> 0x00fb }
            r1.append(r3)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x00fb }
            r1.append(r3)     // Catch:{ all -> 0x00fb }
            r1.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fb }
            r10.write(r1)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.m     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.m = r1     // Catch:{ all -> 0x00fb }
            r0.e = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00b7:
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r10 = r9.j     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.a     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = r0.a     // Catch:{ all -> 0x00fb }
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.write(r11)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.h     // Catch:{ all -> 0x00fb }
            long r0 = r9.f     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.b()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.n     // Catch:{ all -> 0x00fb }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.o     // Catch:{ all -> 0x00fb }
            r10.submit(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
        L_0x00f4:
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.a(com.fyber.inneractive.sdk.player.cache.c, com.fyber.inneractive.sdk.player.cache.c$c, boolean):void");
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void e() throws IOException {
        Writer writer = this.i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), m.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.j.values()) {
                if (next.d != null) {
                    bufferedWriter.write("DIRTY " + next.a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.a + next.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.b.exists()) {
                a(this.b, this.d, true);
            }
            a(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), m.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public final void f() throws IOException {
        while (this.h > this.f) {
            String str = (String) this.j.entrySet().iterator().next().getKey();
            e eVar = this.l;
            if (eVar == null) {
                d(str);
            } else if (((n) eVar).a(this, str)) {
                d(str);
            } else {
                boolean z = false;
                for (String next : this.j.keySet()) {
                    if (((n) this.l).a(this, next)) {
                        z |= d(next);
                    }
                }
                if (!z) {
                    return;
                }
            }
        }
    }

    public final boolean b() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    public final void e(String str) {
        if (!p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final void c() throws IOException {
        a(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.d == null) {
                while (i2 < this.g) {
                    this.h += next.b[i2];
                    i2++;
                }
            } else {
                next.d = null;
                while (i2 < this.g) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0093 }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "DiskLruCache remove %s"
            com.fyber.inneractive.sdk.util.IAlog.d(r3, r1)     // Catch:{ all -> 0x0093 }
            r8.a()     // Catch:{ all -> 0x0093 }
            r8.e(r9)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r1 = r8.j     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x0093 }
            com.fyber.inneractive.sdk.player.cache.c$d r1 = (com.fyber.inneractive.sdk.player.cache.c.d) r1     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0091
            com.fyber.inneractive.sdk.player.cache.c$c r3 = r1.d     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0091
        L_0x0021:
            int r3 = r8.g     // Catch:{ all -> 0x0093 }
            if (r2 >= r3) goto L_0x005d
            java.io.File r3 = r1.a((int) r2)     // Catch:{ all -> 0x0093 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x004d
            boolean r4 = r3.delete()     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x0036
            goto L_0x004d
        L_0x0036:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r0.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0093 }
            r0.append(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
            r9.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x004d:
            long r3 = r8.h     // Catch:{ all -> 0x0093 }
            long[] r5 = r1.b     // Catch:{ all -> 0x0093 }
            r6 = r5[r2]     // Catch:{ all -> 0x0093 }
            long r3 = r3 - r6
            r8.h = r3     // Catch:{ all -> 0x0093 }
            r3 = 0
            r5[r2] = r3     // Catch:{ all -> 0x0093 }
            int r2 = r2 + 1
            goto L_0x0021
        L_0x005d:
            int r1 = r8.k     // Catch:{ all -> 0x0093 }
            int r1 = r1 + r0
            r8.k = r1     // Catch:{ all -> 0x0093 }
            java.io.Writer r1 = r8.i     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            r2.append(r9)     // Catch:{ all -> 0x0093 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
            r1.append(r2)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r1 = r8.j     // Catch:{ all -> 0x0093 }
            r1.remove(r9)     // Catch:{ all -> 0x0093 }
            boolean r9 = r8.b()     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x008f
            java.util.concurrent.ThreadPoolExecutor r9 = r8.n     // Catch:{ all -> 0x0093 }
            java.util.concurrent.Callable<java.lang.Void> r1 = r8.o     // Catch:{ all -> 0x0093 }
            r9.submit(r1)     // Catch:{ all -> 0x0093 }
        L_0x008f:
            monitor-exit(r8)
            return r0
        L_0x0091:
            monitor-exit(r8)
            return r2
        L_0x0093:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.c.d(java.lang.String):boolean");
    }

    public static c a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            c cVar = new c(file, i2, i3, j2);
            if (cVar.b.exists()) {
                try {
                    cVar.d();
                    cVar.c();
                    return cVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    IAlog.d("DiskLruCache delete cache", new Object[0]);
                    cVar.close();
                    m.a(cVar.a);
                }
            }
            file.mkdirs();
            c cVar2 = new c(file, i2, i3, j2);
            cVar2.e();
            return cVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void a(File file) throws IOException {
        IAlog.d("DiskLruCache deleteIfExists - %s", file);
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public File a(String str, int i2) {
        a();
        e(str);
        d dVar = this.j.get(str);
        if (dVar == null) {
            return null;
        }
        return dVar.a(i2);
    }

    public C0107c a(String str) throws IOException {
        synchronized (this) {
            a();
            e(str);
            d dVar = this.j.get(str);
            if (dVar == null) {
                dVar = new d(str);
                this.j.put(str, dVar);
            } else if (dVar.d != null) {
                return null;
            }
            C0107c cVar = new C0107c(dVar);
            dVar.d = cVar;
            Writer writer = this.i;
            writer.write("DIRTY " + str + 10);
            this.i.flush();
            return cVar;
        }
    }

    public final void a() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
