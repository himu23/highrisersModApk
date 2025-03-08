package com.google.android.gms.internal.drive;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.drive.zzkk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzjx {
    private static volatile boolean zzol;
    private static final Class<?> zzom = zzch();
    private static volatile zzjx zzon;
    static final zzjx zzoo = new zzjx(true);
    private final Map<zza, zzkk.zzd<?, ?>> zzop;

    private static Class<?> zzch() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzjx zzci() {
        return zzjw.zzcf();
    }

    public static zzjx zzcj() {
        zzjx zzjx = zzon;
        if (zzjx == null) {
            synchronized (zzjx.class) {
                zzjx = zzon;
                if (zzjx == null) {
                    zzjx = zzjw.zzcg();
                    zzon = zzjx;
                }
            }
        }
        return zzjx;
    }

    static zzjx zzcg() {
        return zzki.zza(zzjx.class);
    }

    public final <ContainingType extends zzlq> zzkk.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzop.get(new zza(containingtype, i));
    }

    zzjx() {
        this.zzop = new HashMap();
    }

    private zzjx(boolean z) {
        this.zzop = Collections.emptyMap();
    }
}
