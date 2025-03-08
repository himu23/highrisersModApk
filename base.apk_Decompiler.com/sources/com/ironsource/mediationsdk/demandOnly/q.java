package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/q;", "", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "c", "a", "b", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface q {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/q$a;", "", "Lcom/ironsource/mediationsdk/demandOnly/h;", "loadParams", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "a", "", "Ljava/lang/String;", "adFormat", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private final String a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "adFormat");
            this.a = str;
        }

        public final IronSourceError a(h hVar) {
            Intrinsics.checkNotNullParameter(hVar, "loadParams");
            h.b bVar = (h.b) hVar;
            if (bVar.f() == null) {
                return new IronSourceError(1060, this.a + " was initialized and loaded without Activity");
            } else if (bVar.g() == null) {
                return new IronSourceError(510, "Missing banner layout");
            } else {
                if (bVar.g().isDestroyed()) {
                    return new IronSourceError(510, "Banner layout is destroyed");
                }
                ISBannerSize size = bVar.g().getSize();
                if (size == null) {
                    return new IronSourceError(510, "Missing banner size");
                }
                if (l.f == size.getDescription() && (size.getHeight() <= 0 || size.getWidth() <= 0)) {
                    return new IronSourceError(510, "Unsupported banner size. Height and width must be bigger than 0");
                }
                if (bVar.b() == null) {
                    return new IronSourceError(510, "Missing instance Id");
                }
                String a2 = bVar.a();
                if ((a2 == null || a2.length() == 0) && hVar.d()) {
                    return new IronSourceError(510, "Missing adm");
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/q$b;", "", "Lcom/ironsource/mediationsdk/demandOnly/h$d;", "loadParams", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "a", "", "Ljava/lang/String;", "adFormat", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        private final String a;

        public b(String str) {
            Intrinsics.checkNotNullParameter(str, "adFormat");
            this.a = str;
        }

        public final IronSourceError a(h.d dVar) {
            Intrinsics.checkNotNullParameter(dVar, "loadParams");
            if (dVar.e() == null) {
                return new IronSourceError(1060, this.a + " was initialized and loaded without Activity");
            } else if (dVar.b() == null) {
                return new IronSourceError(510, "Missing instance Id");
            } else {
                String a2 = dVar.a();
                if ((a2 == null || a2.length() == 0) && dVar.d()) {
                    return new IronSourceError(510, "Missing adm");
                }
                return null;
            }
        }
    }

    IronSourceError c();
}
