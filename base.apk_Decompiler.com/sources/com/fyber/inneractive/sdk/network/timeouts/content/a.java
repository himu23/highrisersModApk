package com.fyber.inneractive.sdk.network.timeouts.content;

import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.util.IAlog;

public class a extends com.fyber.inneractive.sdk.network.timeouts.a {
    public final j h;
    public int i = 0;

    public a(String str, String str2, int i2, boolean z, String str3, s sVar) {
        j jVar = (j) sVar.a(j.class);
        this.h = jVar;
        a(jVar.e());
        int a = a(str, z, str3);
        if (a > i2) {
            a(str, str2, str3);
        }
        a(a, i2);
    }

    public final int a(String str, boolean z, String str2) {
        if (z) {
            return this.h.b(str, str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            return this.h.c(str, str2);
        }
        return this.h.e(str);
    }

    public final void a(String str, String str2, String str3) {
        boolean isEmpty = TextUtils.isEmpty(str3);
        int i2 = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        if (isEmpty) {
            j jVar = this.h;
            jVar.getClass();
            this.e = jVar.a(j.a(str, str2, "retry_interval"), 100);
            this.f = this.h.d();
            j jVar2 = this.h;
            jVar2.getClass();
            String a = j.a(str, str2, "ilat");
            if (!jVar2.g(str)) {
                i2 = 10000;
            }
            this.d = jVar2.a(a, i2);
            return;
        }
        j jVar3 = this.h;
        jVar3.getClass();
        this.e = jVar3.a(j.a(str, str2, "retry_interval", j.i(str3)), jVar3.a(j.a("retry_interval", "all_mediators"), 100));
        this.f = this.h.f(str3);
        j jVar4 = this.h;
        jVar4.getClass();
        String a2 = j.a(str, str2, "ilat", j.i(str3));
        String a3 = j.a(str, str2, "ilat", "all_mediators");
        if (!jVar4.g(str)) {
            i2 = 10000;
        }
        this.d = jVar4.a(a2, jVar4.a(a3, i2));
    }

    public final void a(int i2, int i3) {
        int i4 = i2 - (this.f + i3);
        IAlog.a("%s : LoadAdContentTimeout resolveLoadAdTimeout : usedTime: %d, global timeout: %d, timeout: %d", IAlog.a((Class<?>) a.class), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4));
        this.c = Math.max(i4, 0);
        int a = a();
        this.a = a;
        if (a == 0) {
            this.d = this.c;
        }
        IAlog.a("%s : LoadAdContentTimeout onFixedLoadAdTimeoutUpdated : Calculated: %d attempts with LeftoverTime: %d", IAlog.a((Object) this), Integer.valueOf(this.a), Integer.valueOf(this.i));
        int i5 = this.a;
        if (i5 > 0) {
            int i6 = this.c;
            int i7 = this.f;
            int i8 = this.e;
            for (int i9 = 0; i9 <= i5; i9++) {
                i6 -= this.d + (this.b * i9);
            }
            this.i = Math.max(0, i6 - ((i7 * i5) + (i8 * i5)));
        }
    }

    public int a(int i2) {
        if (this.g) {
            i2 = this.a - i2;
        }
        return this.d + (this.b * i2) + (i2 == this.a ? this.i : 0);
    }
}
