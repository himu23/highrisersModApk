package com.ironsource;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/ironsource/y6;", "Lcom/ironsource/z6;", "", "url", "", "d", "Lkotlin/Result;", "Landroid/graphics/drawable/Drawable;", "b", "(Ljava/lang/String;)Ljava/lang/Object;", "c", "a", "Lcom/ironsource/h2;", "Lcom/ironsource/h2;", "connectionFactory", "<init>", "(Lcom/ironsource/h2;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class y6 implements z6 {
    private final h2 a;

    public y6() {
        this((h2) null, 1, (DefaultConstructorMarker) null);
    }

    public y6(h2 h2Var) {
        Intrinsics.checkNotNullParameter(h2Var, "connectionFactory");
        this.a = h2Var;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y6(h2 h2Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? a3.a : h2Var);
    }

    private final Object b(String str) {
        Object createFromPath;
        Exception exc;
        File file = new File(str);
        if (!file.exists()) {
            Result.Companion companion = Result.Companion;
            exc = new Exception("file does not exists");
        } else {
            createFromPath = Drawable.createFromPath(file.getPath());
            if (createFromPath == null) {
                Result.Companion companion2 = Result.Companion;
                exc = new Exception("failed to create a drawable");
            } else {
                Result.Companion companion3 = Result.Companion;
                return Result.m144constructorimpl(createFromPath);
            }
        }
        createFromPath = ResultKt.createFailure(exc);
        return Result.m144constructorimpl(createFromPath);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object c(java.lang.String r3) {
        /*
            r2 = this;
            com.ironsource.h2 r0 = r2.a
            java.io.InputStream r0 = r0.a(r3)
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x002e }
            r1.<init>(r3)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = r1.getName()     // Catch:{ all -> 0x002e }
            android.graphics.drawable.Drawable r3 = android.graphics.drawable.Drawable.createFromStream(r0, r3)     // Catch:{ all -> 0x002e }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            if (r3 != 0) goto L_0x0027
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Exception r3 = new java.lang.Exception
            java.lang.String r0 = "failed to create a drawable"
            r3.<init>(r0)
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            goto L_0x0029
        L_0x0027:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
        L_0x0029:
            java.lang.Object r3 = kotlin.Result.m144constructorimpl(r3)
            return r3
        L_0x002e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.y6.c(java.lang.String):java.lang.Object");
    }

    private final boolean d(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    public Object a(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            return d(str) ? c(str) : b(str);
        } catch (Exception e) {
            Result.Companion companion = Result.Companion;
            return Result.m144constructorimpl(ResultKt.createFailure(e));
        }
    }
}
