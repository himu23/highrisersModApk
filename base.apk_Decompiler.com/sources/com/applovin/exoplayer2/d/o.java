package com.applovin.exoplayer2.d;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.d.m;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class o implements m {
    public static final m.c tq = new o$$ExternalSyntheticLambda2();
    private final UUID ey;
    private int sp = 1;
    private final MediaDrm tr;

    public int hN() {
        return 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ m d(UUID uuid) {
        try {
            return b(uuid);
        } catch (t unused) {
            q.i("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new k();
        }
    }

    public static o b(UUID uuid) throws t {
        try {
            return new o(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new t(1, e);
        } catch (Exception e2) {
            throw new t(2, e2);
        }
    }

    private o(UUID uuid) throws UnsupportedSchemeException {
        com.applovin.exoplayer2.l.a.checkNotNull(uuid);
        com.applovin.exoplayer2.l.a.checkArgument(!h.ak.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.ey = uuid;
        MediaDrm mediaDrm = new MediaDrm(c(uuid));
        this.tr = mediaDrm;
        if (h.am.equals(uuid) && hR()) {
            a(mediaDrm);
        }
    }

    public void a(m.b bVar) {
        this.tr.setOnEventListener(bVar == null ? null : new o$$ExternalSyntheticLambda1(this, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(m.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        bVar.a(this, bArr, i, i2, bArr2);
    }

    public byte[] hL() throws MediaDrmException {
        return this.tr.openSession();
    }

    public void p(byte[] bArr) {
        this.tr.closeSession(bArr);
    }

    public m.a a(byte[] bArr, List<e.a> list, int i, HashMap<String, String> hashMap) throws NotProvisionedException {
        e.a aVar;
        String str;
        byte[] bArr2;
        if (list != null) {
            aVar = a(this.ey, list);
            bArr2 = a(this.ey, (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar.tf));
            str = a(this.ey, aVar.eg);
        } else {
            aVar = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.tr.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] b = b(this.ey, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && aVar != null && !TextUtils.isEmpty(aVar.te)) {
            defaultUrl = aVar.te;
        }
        return new m.a(b, defaultUrl, ai.acV >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (h.al.equals(this.ey)) {
            bArr2 = a.m(bArr2);
        }
        return this.tr.provideKeyResponse(bArr, bArr2);
    }

    public m.d hM() {
        MediaDrm.ProvisionRequest provisionRequest = this.tr.getProvisionRequest();
        return new m.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public void q(byte[] bArr) throws DeniedByServerException {
        this.tr.provideProvisionResponse(bArr);
    }

    public Map<String, String> r(byte[] bArr) {
        return this.tr.queryKeyStatus(bArr);
    }

    public boolean a(byte[] bArr, String str) {
        if (ai.acV >= 31) {
            return a.a(this.tr, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.ey, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    public synchronized void release() {
        int i = this.sp - 1;
        this.sp = i;
        if (i == 0) {
            this.tr.release();
        }
    }

    public void b(byte[] bArr, byte[] bArr2) {
        this.tr.restoreKeys(bArr, bArr2);
    }

    public String C(String str) {
        return this.tr.getPropertyString(str);
    }

    /* renamed from: t */
    public n s(byte[] bArr) throws MediaCryptoException {
        return new n(c(this.ey), bArr, ai.acV < 21 && h.am.equals(this.ey) && "L3".equals(C("securityLevel")));
    }

    private static e.a a(UUID uuid, List<e.a> list) {
        if (!h.am.equals(uuid)) {
            return list.get(0);
        }
        if (ai.acV >= 28 && list.size() > 1) {
            e.a aVar = list.get(0);
            int i = 0;
            int i2 = 0;
            while (i < list.size()) {
                e.a aVar2 = list.get(i);
                byte[] bArr = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar2.tf);
                if (ai.r(aVar2.eg, aVar.eg) && ai.r(aVar2.te, aVar.te) && com.applovin.exoplayer2.e.g.h.w(bArr)) {
                    i2 += bArr.length;
                    i++;
                }
            }
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                byte[] bArr3 = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(list.get(i4).tf);
                int length = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i3, length);
                i3 += length;
            }
            return aVar.o(bArr2);
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            e.a aVar3 = list.get(i5);
            int y = com.applovin.exoplayer2.e.g.h.y((byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.tf));
            if (ai.acV < 23 && y == 0) {
                return aVar3;
            }
            if (ai.acV >= 23 && y == 1) {
                return aVar3;
            }
        }
        return list.get(0);
    }

    private static UUID c(UUID uuid) {
        return (ai.acV >= 27 || !h.al.equals(uuid)) ? uuid : h.ak;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        r2 = com.applovin.exoplayer2.e.g.h.a(r3, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(java.util.UUID r2, byte[] r3) {
        /*
            java.util.UUID r0 = com.applovin.exoplayer2.h.an
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x001a
            byte[] r0 = com.applovin.exoplayer2.e.g.h.a(r3, r2)
            if (r0 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r3 = r0
        L_0x0010:
            java.util.UUID r0 = com.applovin.exoplayer2.h.an
            byte[] r3 = u(r3)
            byte[] r3 = com.applovin.exoplayer2.e.g.h.c(r0, r3)
        L_0x001a:
            int r0 = com.applovin.exoplayer2.l.ai.acV
            r1 = 23
            if (r0 >= r1) goto L_0x0028
            java.util.UUID r0 = com.applovin.exoplayer2.h.am
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0062
        L_0x0028:
            java.util.UUID r0 = com.applovin.exoplayer2.h.an
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = com.applovin.exoplayer2.l.ai.acX
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "AFTB"
            java.lang.String r1 = com.applovin.exoplayer2.l.ai.acY
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "AFTS"
            java.lang.String r1 = com.applovin.exoplayer2.l.ai.acY
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "AFTM"
            java.lang.String r1 = com.applovin.exoplayer2.l.ai.acY
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "AFTT"
            java.lang.String r1 = com.applovin.exoplayer2.l.ai.acY
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0069
        L_0x0062:
            byte[] r2 = com.applovin.exoplayer2.e.g.h.a(r3, r2)
            if (r2 == 0) goto L_0x0069
            return r2
        L_0x0069:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.d.o.a(java.util.UUID, byte[]):byte[]");
    }

    private static String a(UUID uuid, String str) {
        return (ai.acV >= 26 || !h.al.equals(uuid) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) ? str : "cenc";
    }

    private static byte[] b(UUID uuid, byte[] bArr) {
        return h.al.equals(uuid) ? a.l(bArr) : bArr;
    }

    private static void a(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static boolean hR() {
        return "ASUS_Z00AD".equals(ai.acY);
    }

    private static byte[] u(byte[] bArr) {
        y yVar = new y(bArr);
        int py = yVar.py();
        short ps = yVar.ps();
        short ps2 = yVar.ps();
        if (ps == 1 && ps2 == 1) {
            String b = yVar.b(yVar.ps(), Charsets.UTF_16LE);
            if (b.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = b.indexOf("</DATA>");
            if (indexOf == -1) {
                q.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String str = b.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + b.substring(indexOf);
            int i = py + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i);
            allocate.putShort((short) ps);
            allocate.putShort((short) ps2);
            allocate.putShort((short) (str.length() * 2));
            allocate.put(str.getBytes(Charsets.UTF_16LE));
            return allocate.array();
        }
        q.g("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }
}
