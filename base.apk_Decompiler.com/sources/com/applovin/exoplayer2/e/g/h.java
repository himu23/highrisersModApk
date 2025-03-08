package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class h {
    public static byte[] c(UUID uuid, byte[] bArr) {
        return a(uuid, (UUID[]) null, bArr);
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean w(byte[] bArr) {
        return z(bArr) != null;
    }

    public static UUID x(byte[] bArr) {
        a z = z(bArr);
        if (z == null) {
            return null;
        }
        return z.ey;
    }

    public static int y(byte[] bArr) {
        a z = z(bArr);
        if (z == null) {
            return -1;
        }
        return z.mH;
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        a z = z(bArr);
        if (z == null) {
            return null;
        }
        if (uuid.equals(z.ey)) {
            return z.AI;
        }
        q.h("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + z.ey + ".");
        return null;
    }

    private static a z(byte[] bArr) {
        y yVar = new y(bArr);
        if (yVar.pk() < 32) {
            return null;
        }
        yVar.fx(0);
        if (yVar.px() != yVar.pj() + 4 || yVar.px() != 1886614376) {
            return null;
        }
        int cf = a.cf(yVar.px());
        if (cf > 1) {
            q.h("PsshAtomUtil", "Unsupported pssh version: " + cf);
            return null;
        }
        UUID uuid = new UUID(yVar.pz(), yVar.pz());
        if (cf == 1) {
            yVar.fz(yVar.pD() * 16);
        }
        int pD = yVar.pD();
        if (pD != yVar.pj()) {
            return null;
        }
        byte[] bArr2 = new byte[pD];
        yVar.r(bArr2, 0, pD);
        return new a(uuid, cf, bArr2);
    }

    private static class a {
        /* access modifiers changed from: private */
        public final byte[] AI;
        /* access modifiers changed from: private */
        public final UUID ey;
        /* access modifiers changed from: private */
        public final int mH;

        public a(UUID uuid, int i, byte[] bArr) {
            this.ey = uuid;
            this.mH = i;
            this.AI = bArr;
        }
    }
}
