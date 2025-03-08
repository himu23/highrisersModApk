package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import com.ironsource.f;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0004\u0004\u0003\u0007\u0006J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/h;", "Lcom/ironsource/mediationsdk/demandOnly/q;", "", "b", "a", "", "d", "c", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface h extends q {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B#\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/h$a;", "Lcom/ironsource/mediationsdk/demandOnly/h;", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "c", "", "b", "a", "", "d", "Ljava/lang/String;", "instanceId", "adMarkup", "Z", "bidding", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class a implements h {
        private final String a;
        private final String b;
        private final boolean c;

        public a(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }

        public abstract IronSourceError c();

        public boolean d() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/h$b;", "Lcom/ironsource/mediationsdk/demandOnly/h$a;", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "c", "", "d", "Ljava/lang/String;", "adFormat", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", "f", "()Landroid/app/Activity;", "activity", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "g", "()Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "banner", "instanceId", "adMarkup", "", "bidding", "<init>", "(Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;Ljava/lang/String;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends a {
        private final String d;
        private final Activity e;
        private final ISDemandOnlyBannerLayout f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, Activity activity, String str2, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str3, boolean z) {
            super(str2, str3, z);
            Intrinsics.checkNotNullParameter(str, "adFormat");
            this.d = str;
            this.e = activity;
            this.f = iSDemandOnlyBannerLayout;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, Activity activity, String str2, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, activity, str2, iSDemandOnlyBannerLayout, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : z);
        }

        public IronSourceError c() {
            IronSourceError a = new q.a(this.d).a(this);
            if (a != null) {
                return a;
            }
            return null;
        }

        public final Activity f() {
            return this.e;
        }

        public final ISDemandOnlyBannerLayout g() {
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0004\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0004\u001a\u00020\u0010J\u0006\u0010\u0007\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/h$c;", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adFormat", "a", "", "instanceId", "b", "Landroid/app/Activity;", "activity", "defaultActivity", "", "bidding", "adMarkup", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "banner", "Lcom/ironsource/mediationsdk/demandOnly/h$b;", "Lcom/ironsource/mediationsdk/demandOnly/h$d;", "Ljava/lang/String;", "Landroid/app/Activity;", "c", "d", "Z", "e", "f", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c {
        private String a = "";
        private Activity b;
        private String c;
        private boolean d;
        private String e;
        private ISDemandOnlyBannerLayout f;

        public final b a() {
            return new b(this.a, this.b, this.c, this.f, this.e, this.d);
        }

        public final c a(Activity activity) {
            this.b = activity;
            return this;
        }

        public final c a(Activity activity, Activity activity2) {
            if (activity == null) {
                activity = activity2;
            }
            this.b = activity;
            return this;
        }

        public final c a(IronSource.AD_UNIT ad_unit) {
            Intrinsics.checkNotNullParameter(ad_unit, "adFormat");
            String ad_unit2 = ad_unit.toString();
            Intrinsics.checkNotNullExpressionValue(ad_unit2, "adFormat.toString()");
            this.a = ad_unit2;
            return this;
        }

        public final c a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
            this.f = iSDemandOnlyBannerLayout;
            return this;
        }

        public final c a(String str) {
            this.e = str;
            return this;
        }

        public final c a(boolean z) {
            this.d = z;
            return this;
        }

        public final c b(String str) {
            this.c = str;
            return this;
        }

        public final d b() {
            return new d(this.a, this.b, this.c, this.e, this.d);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/h$d;", "Lcom/ironsource/mediationsdk/demandOnly/h$a;", "Lcom/ironsource/f;", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "c", "Landroid/app/Activity;", "e", "", "d", "Ljava/lang/String;", "adFormat", "Landroid/app/Activity;", "activity", "instanceId", "adMarkup", "", "bidding", "<init>", "(Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends a implements f {
        private final String d;
        private final Activity e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, Activity activity, String str2, String str3, boolean z) {
            super(str2, str3, z);
            Intrinsics.checkNotNullParameter(str, "adFormat");
            this.d = str;
            this.e = activity;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(String str, Activity activity, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, activity, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? false : z);
        }

        public IronSourceError c() {
            IronSourceError a = new q.b(this.d).a(this);
            if (a != null) {
                return a;
            }
            return null;
        }

        public Activity e() {
            return this.e;
        }
    }

    String a();

    String b();

    boolean d();
}
