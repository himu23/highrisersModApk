package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class i {
    public final HashMap<String, h> a;
    public final SparseArray<String> b;
    public final b c;
    public final Cipher d;
    public final SecretKeySpec e;
    public boolean f;
    public o g;

    public i(File file, byte[] bArr) {
        if (bArr != null) {
            a.a(bArr.length == 16);
            try {
                this.d = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                this.e = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            this.d = null;
            this.e = null;
        }
        this.a = new HashMap<>();
        this.b = new SparseArray<>();
        this.c = new b(new File(file, "cached_content_index.exi"));
    }

    public h a(String str) {
        return this.a.get(str);
    }

    public void b(String str) {
        h remove = this.a.remove(str);
        if (remove != null) {
            a.b(remove.c.isEmpty());
            this.b.remove(remove.a);
            this.f = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            com.fyber.inneractive.sdk.player.exoplayer2.util.b r3 = r11.c     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            java.io.InputStream r3 = r3.a()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            int r1 = r3.readInt()     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r4 = 1
            if (r1 == r4) goto L_0x001d
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r3)
            return r0
        L_0x001d:
            int r1 = r3.readInt()     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r1 = r1 & r4
            if (r1 == 0) goto L_0x0056
            javax.crypto.Cipher r1 = r11.d     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            if (r1 != 0) goto L_0x002c
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r3)
            return r0
        L_0x002c:
            r1 = 16
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r3.readFully(r1)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            javax.crypto.spec.IvParameterSpec r5 = new javax.crypto.spec.IvParameterSpec     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r5.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            javax.crypto.Cipher r1 = r11.d     // Catch:{ InvalidKeyException -> 0x004f, InvalidAlgorithmParameterException -> 0x004d }
            javax.crypto.spec.SecretKeySpec r6 = r11.e     // Catch:{ InvalidKeyException -> 0x004f, InvalidAlgorithmParameterException -> 0x004d }
            r7 = 2
            r1.init(r7, r6, r5)     // Catch:{ InvalidKeyException -> 0x004f, InvalidAlgorithmParameterException -> 0x004d }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            javax.crypto.CipherInputStream r5 = new javax.crypto.CipherInputStream     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            javax.crypto.Cipher r6 = r11.d     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r5.<init>(r2, r6)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            goto L_0x005d
        L_0x004d:
            r1 = move-exception
            goto L_0x0050
        L_0x004f:
            r1 = move-exception
        L_0x0050:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            throw r2     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
        L_0x0056:
            javax.crypto.Cipher r1 = r11.d     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
            if (r1 == 0) goto L_0x005c
            r11.f = r4     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0093, all -> 0x0091 }
        L_0x005c:
            r1 = r3
        L_0x005d:
            int r2 = r1.readInt()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            r3 = 0
            r5 = 0
        L_0x0063:
            if (r3 >= r2) goto L_0x0081
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h r6 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            int r7 = r1.readInt()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            java.lang.String r8 = r1.readUTF()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            long r9 = r1.readLong()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            r6.<init>(r7, r8, r9)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            r11.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h) r6)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            int r6 = r6.a()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            int r5 = r5 + r6
            int r3 = r3 + 1
            goto L_0x0063
        L_0x0081:
            int r2 = r1.readInt()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x009b }
            if (r2 == r5) goto L_0x008b
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r1)
            return r0
        L_0x008b:
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r1)
            return r4
        L_0x008f:
            goto L_0x00b0
        L_0x0091:
            r0 = move-exception
            goto L_0x00aa
        L_0x0093:
            r1 = move-exception
            r2 = r1
            r1 = r3
            goto L_0x009c
        L_0x0097:
            goto L_0x00b1
        L_0x0099:
            r0 = move-exception
            goto L_0x00a9
        L_0x009b:
            r2 = move-exception
        L_0x009c:
            java.lang.String r3 = "CachedContentIndex"
            java.lang.String r4 = "Error reading cache content index file."
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x00a8
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r1)
        L_0x00a8:
            return r0
        L_0x00a9:
            r3 = r1
        L_0x00aa:
            if (r3 == 0) goto L_0x00af
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r3)
        L_0x00af:
            throw r0
        L_0x00b0:
            r3 = r1
        L_0x00b1:
            if (r3 == 0) goto L_0x00b6
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r3)
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i.a():boolean");
    }

    public void c() throws a.C0128a {
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        IOException e2;
        if (this.f) {
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream b2 = this.c.b();
                o oVar = this.g;
                if (oVar == null) {
                    this.g = new o(b2);
                } else {
                    oVar.a(b2);
                }
                dataOutputStream = new DataOutputStream(this.g);
                try {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeInt(this.d != null ? 1 : 0);
                    if (this.d != null) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        try {
                            this.d.init(1, this.e, new IvParameterSpec(bArr));
                            dataOutputStream.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(this.g, this.d));
                        } catch (InvalidKeyException e3) {
                            e = e3;
                            throw new IllegalStateException(e);
                        } catch (InvalidAlgorithmParameterException e4) {
                            e = e4;
                            throw new IllegalStateException(e);
                        }
                    } else {
                        dataOutputStream2 = dataOutputStream;
                    }
                    dataOutputStream2.writeInt(this.a.size());
                    int i = 0;
                    for (h next : this.a.values()) {
                        dataOutputStream2.writeInt(next.a);
                        dataOutputStream2.writeUTF(next.b);
                        dataOutputStream2.writeLong(next.d);
                        i += next.a();
                    }
                    dataOutputStream2.writeInt(i);
                    b bVar = this.c;
                    bVar.getClass();
                    dataOutputStream2.close();
                    bVar.b.delete();
                    int i2 = u.a;
                    this.f = false;
                } catch (IOException e5) {
                    e2 = e5;
                    try {
                        throw new a.C0128a(e2);
                    } catch (Throwable th3) {
                        DataOutputStream dataOutputStream3 = dataOutputStream;
                        th2 = th3;
                        dataOutputStream2 = dataOutputStream3;
                        Throwable th4 = th2;
                        dataOutputStream = dataOutputStream2;
                        th = th4;
                        u.a((Closeable) dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    u.a((Closeable) dataOutputStream);
                    throw th;
                }
            } catch (IOException e6) {
                IOException iOException = e6;
                dataOutputStream = dataOutputStream2;
                e2 = iOException;
                throw new a.C0128a(e2);
            } catch (Throwable th6) {
                th2 = th6;
                Throwable th42 = th2;
                dataOutputStream = dataOutputStream2;
                th = th42;
                u.a((Closeable) dataOutputStream);
                throw th;
            }
        }
    }

    public void b() {
        LinkedList linkedList = new LinkedList();
        for (h next : this.a.values()) {
            if (next.c.isEmpty()) {
                linkedList.add(next.b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b((String) it.next());
        }
    }

    public final void a(h hVar) {
        this.a.put(hVar.b, hVar);
        this.b.put(hVar.a, hVar.b);
    }

    public final h a(String str, long j) {
        int i;
        SparseArray<String> sparseArray = this.b;
        int size = sparseArray.size();
        int i2 = 0;
        if (size == 0) {
            i = 0;
        } else {
            i = sparseArray.keyAt(size - 1) + 1;
        }
        if (i < 0) {
            while (i2 < size && i2 == sparseArray.keyAt(i2)) {
                i2++;
            }
            i = i2;
        }
        h hVar = new h(i, str, j);
        this.a.put(str, hVar);
        this.b.put(i, str);
        this.f = true;
        return hVar;
    }
}
