package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzkb<FieldDescriptorType extends zzkd<FieldDescriptorType>> {
    private static final zzkb zzov = new zzkb(true);
    final zzmi<FieldDescriptorType, Object> zzos = zzmi.zzav(16);
    private boolean zzot;
    private boolean zzou = false;

    private zzkb() {
    }

    public static <T extends zzkd<T>> zzkb<T> zzcn() {
        return zzov;
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    private zzkb(boolean z) {
        zzbp();
    }

    public final void zzbp() {
        if (!this.zzot) {
            this.zzos.zzbp();
            this.zzot = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkb)) {
            return false;
        }
        return this.zzos.equals(((zzkb) obj).zzos);
    }

    public final int hashCode() {
        return this.zzos.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.entrySet().iterator());
        }
        return this.zzos.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.zzet().iterator());
        }
        return this.zzos.zzet().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzos.get(fielddescriptortype);
        return obj instanceof zzkt ? zzkt.zzdp() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzcs()) {
            zza(fielddescriptortype.zzcq(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(fielddescriptortype.zzcq(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.put(fielddescriptortype, obj);
    }

    private static void zza(zznm zznm, Object obj) {
        boolean z;
        zzkm.checkNotNull(obj);
        switch (zzkc.zzow[zznm.zzfj().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzjc) || (obj instanceof byte[])) {
                    return;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzkn)) {
                    return;
                }
            case 9:
                if ((obj instanceof zzlq) || (obj instanceof zzkt)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzos.zzer(); i++) {
            if (!zzb(this.zzos.zzaw(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzos.zzes()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzkd zzkd = (zzkd) entry.getKey();
        if (zzkd.zzcr() == zznr.MESSAGE) {
            if (zzkd.zzcs()) {
                for (zzlq isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzlq) {
                    if (!((zzlq) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzkt) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzkb<FieldDescriptorType> zzkb) {
        for (int i = 0; i < zzkb.zzos.zzer(); i++) {
            zzc(zzkb.zzos.zzaw(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzkb.zzos.zzes()) {
            zzc(zzc);
        }
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzef();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzkd zzkd = (zzkd) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzkt) {
            value = zzkt.zzdp();
        }
        if (zzkd.zzcs()) {
            Object zza = zza(zzkd);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zze : (List) value) {
                ((List) zza).add(zze(zze));
            }
            this.zzos.put(zzkd, zza);
        } else if (zzkd.zzcr() == zznr.MESSAGE) {
            Object zza2 = zza(zzkd);
            if (zza2 == null) {
                this.zzos.put(zzkd, zze(value));
                return;
            }
            if (zza2 instanceof zzlx) {
                obj = zzkd.zza((zzlx) zza2, (zzlx) value);
            } else {
                obj = zzkd.zza(((zzlq) zza2).zzcy(), (zzlq) value).zzdf();
            }
            this.zzos.put(zzkd, obj);
        } else {
            this.zzos.put(zzkd, zze(value));
        }
    }

    static void zza(zzjr zzjr, zznm zznm, int i, Object obj) throws IOException {
        if (zznm == zznm.GROUP) {
            zzlq zzlq = (zzlq) obj;
            zzkm.zzf(zzlq);
            zzjr.zzb(i, 3);
            zzlq.zzb(zzjr);
            zzjr.zzb(i, 4);
            return;
        }
        zzjr.zzb(i, zznm.zzfk());
        switch (zzkc.zzox[zznm.ordinal()]) {
            case 1:
                zzjr.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzjr.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzjr.zzl(((Long) obj).longValue());
                return;
            case 4:
                zzjr.zzl(((Long) obj).longValue());
                return;
            case 5:
                zzjr.zzx(((Integer) obj).intValue());
                return;
            case 6:
                zzjr.zzn(((Long) obj).longValue());
                return;
            case 7:
                zzjr.zzaa(((Integer) obj).intValue());
                return;
            case 8:
                zzjr.zzc(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzlq) obj).zzb(zzjr);
                return;
            case 10:
                zzjr.zzb((zzlq) obj);
                return;
            case 11:
                if (obj instanceof zzjc) {
                    zzjr.zza((zzjc) obj);
                    return;
                } else {
                    zzjr.zzl((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzjc) {
                    zzjr.zza((zzjc) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzjr.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzjr.zzy(((Integer) obj).intValue());
                return;
            case 14:
                zzjr.zzaa(((Integer) obj).intValue());
                return;
            case 15:
                zzjr.zzn(((Long) obj).longValue());
                return;
            case 16:
                zzjr.zzz(((Integer) obj).intValue());
                return;
            case 17:
                zzjr.zzm(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzkn) {
                    zzjr.zzx(((zzkn) obj).zzcp());
                    return;
                } else {
                    zzjr.zzx(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzco() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzos.zzer(); i2++) {
            i += zzd(this.zzos.zzaw(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzos.zzes()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzkd zzkd = (zzkd) entry.getKey();
        Object value = entry.getValue();
        if (zzkd.zzcr() != zznr.MESSAGE || zzkd.zzcs() || zzkd.zzct()) {
            return zzb((zzkd<?>) zzkd, value);
        }
        if (value instanceof zzkt) {
            return zzjr.zzb(((zzkd) entry.getKey()).zzcp(), (zzkx) (zzkt) value);
        }
        return zzjr.zzb(((zzkd) entry.getKey()).zzcp(), (zzlq) value);
    }

    static int zza(zznm zznm, int i, Object obj) {
        int zzab = zzjr.zzab(i);
        if (zznm == zznm.GROUP) {
            zzkm.zzf((zzlq) obj);
            zzab <<= 1;
        }
        return zzab + zzb(zznm, obj);
    }

    private static int zzb(zznm zznm, Object obj) {
        switch (zzkc.zzox[zznm.ordinal()]) {
            case 1:
                return zzjr.zzb(((Double) obj).doubleValue());
            case 2:
                return zzjr.zzb(((Float) obj).floatValue());
            case 3:
                return zzjr.zzo(((Long) obj).longValue());
            case 4:
                return zzjr.zzp(((Long) obj).longValue());
            case 5:
                return zzjr.zzac(((Integer) obj).intValue());
            case 6:
                return zzjr.zzr(((Long) obj).longValue());
            case 7:
                return zzjr.zzaf(((Integer) obj).intValue());
            case 8:
                return zzjr.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzjr.zzd((zzlq) obj);
            case 10:
                if (obj instanceof zzkt) {
                    return zzjr.zza((zzkx) (zzkt) obj);
                }
                return zzjr.zzc((zzlq) obj);
            case 11:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzm((String) obj);
            case 12:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzc((byte[]) obj);
            case 13:
                return zzjr.zzad(((Integer) obj).intValue());
            case 14:
                return zzjr.zzag(((Integer) obj).intValue());
            case 15:
                return zzjr.zzs(((Long) obj).longValue());
            case 16:
                return zzjr.zzae(((Integer) obj).intValue());
            case 17:
                return zzjr.zzq(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzkn) {
                    return zzjr.zzah(((zzkn) obj).zzcp());
                }
                return zzjr.zzah(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzkd<?> zzkd, Object obj) {
        zznm zzcq = zzkd.zzcq();
        int zzcp = zzkd.zzcp();
        if (!zzkd.zzcs()) {
            return zza(zzcq, zzcp, obj);
        }
        int i = 0;
        if (zzkd.zzct()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzcq, zzb);
            }
            return zzjr.zzab(zzcp) + i + zzjr.zzaj(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzcq, zzcp, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzkb zzkb = new zzkb();
        for (int i = 0; i < this.zzos.zzer(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzaw = this.zzos.zzaw(i);
            zzkb.zza((zzkd) zzaw.getKey(), zzaw.getValue());
        }
        for (Map.Entry next : this.zzos.zzes()) {
            zzkb.zza((zzkd) next.getKey(), next.getValue());
        }
        zzkb.zzou = this.zzou;
        return zzkb;
    }
}
