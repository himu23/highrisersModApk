package com.applovin.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.h.o;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.c;
import java.io.IOException;

public final class p extends ak {
    public static final g.a<p> br = new p$$ExternalSyntheticLambda0();
    public final int bs;
    public final String bt;
    public final int bu;
    public final v bv;
    public final int bw;
    public final o bx;
    final boolean by;

    public static /* synthetic */ p $r8$lambda$eNlJ4lrbvCLcY1ApNbk1B6ELKYw(Bundle bundle) {
        return new p(bundle);
    }

    public static p a(IOException iOException, int i) {
        return new p(0, iOException, i);
    }

    public static p a(Throwable th, String str, int i, v vVar, int i2, boolean z, int i3) {
        return new p(1, th, (String) null, i3, str, i, vVar, vVar == null ? 4 : i2, z);
    }

    @Deprecated
    public static p a(RuntimeException runtimeException) {
        return a(runtimeException, 1000);
    }

    public static p a(RuntimeException runtimeException, int i) {
        return new p(2, runtimeException, i);
    }

    private p(int i, Throwable th, int i2) {
        this(i, th, (String) null, i2, (String) null, -1, (v) null, 4, false);
    }

    private p(int i, Throwable th, String str, int i2, String str2, int i3, v vVar, int i4, boolean z) {
        this(a(i, str, str2, i3, vVar, i4), th, i2, i, str2, i3, vVar, i4, (o) null, SystemClock.elapsedRealtime(), z);
    }

    private p(Bundle bundle) {
        super(bundle);
        this.bs = bundle.getInt(t(1001), 2);
        this.bt = bundle.getString(t(1002));
        this.bu = bundle.getInt(t(1003), -1);
        this.bv = (v) c.a(v.br, bundle.getBundle(t(1004)));
        this.bw = bundle.getInt(t(1005), 4);
        this.by = bundle.getBoolean(t(1006), false);
        this.bx = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private p(String str, Throwable th, int i, int i2, String str2, int i3, v vVar, int i4, o oVar, long j, boolean z) {
        super(str, th, i, j);
        int i5 = i2;
        boolean z2 = z;
        boolean z3 = false;
        a.checkArgument(!z2 || i5 == 1);
        a.checkArgument((th != null || i5 == 3) ? true : z3);
        this.bs = i5;
        this.bt = str2;
        this.bu = i3;
        this.bv = vVar;
        this.bw = i4;
        this.bx = oVar;
        this.by = z2;
    }

    /* access modifiers changed from: package-private */
    public p a(o oVar) {
        return new p((String) ai.R(getMessage()), getCause(), this.errorCode, this.bs, this.bt, this.bu, this.bv, this.bw, oVar, this.gp, this.by);
    }

    private static String a(int i, String str, String str2, int i2, v vVar, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + vVar + ", format_supported=" + h.q(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }
}
