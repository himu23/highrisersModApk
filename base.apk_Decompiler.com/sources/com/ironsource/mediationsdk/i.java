package com.ironsource.mediationsdk;

import com.ironsource.b1;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bT\u0010UJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0012j\b\u0012\u0004\u0012\u00020\u0002`\u00138\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0018\u0010\u001cR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0005\u0010\"R\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b\u0010\u0010\u001cR4\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010'8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b$\u0010*\"\u0004\b\u0005\u0010+R.\u00105\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b \u00100\u0012\u0004\b4\u0010-\u001a\u0004\b1\u00102\"\u0004\b\u0005\u00103R\"\u0010:\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u00106\u001a\u0004\b7\u00108\"\u0004\b\u0005\u00109R$\u0010?\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010<\u001a\u0004\b\u0018\u0010=\"\u0004\b\u0005\u0010>R$\u0010F\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\u0005\u0010ER\"\u0010H\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001f\u001a\u0004\bG\u0010!\"\u0004\b\u0010\u0010\"R$\u0010M\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u0010J\u001a\u0004\b\u001e\u0010K\"\u0004\b\u0005\u0010LR\"\u0010P\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0019\u001a\u0004\bO\u0010\u001b\"\u0004\b\u0005\u0010\u001cR\"\u0010R\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0019\u001a\u0004\bN\u0010\u001b\"\u0004\b\u001e\u0010\u001cR\"\u0010S\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0019\u001a\u0004\bQ\u0010\u001b\"\u0004\b$\u0010\u001c¨\u0006V"}, d2 = {"Lcom/ironsource/mediationsdk/i;", "", "Lcom/ironsource/b1;", "instanceInfo", "", "a", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "b", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "h", "()Ljava/util/ArrayList;", "instancesInfo", "c", "Z", "r", "()Z", "(Z)V", "isOneFlow", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "instanceId", "e", "q", "isEncryptedResponse", "", "f", "Ljava/util/Map;", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "getBidders$annotations", "()V", "bidders", "", "Ljava/util/List;", "i", "()Ljava/util/List;", "(Ljava/util/List;)V", "getNonBidders$annotations", "nonBidders", "I", "l", "()I", "(I)V", "sessionDepth", "Lcom/ironsource/mediationsdk/h;", "Lcom/ironsource/mediationsdk/h;", "()Lcom/ironsource/mediationsdk/h;", "(Lcom/ironsource/mediationsdk/h;)V", "auctionHistory", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "j", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "k", "()Lcom/ironsource/mediationsdk/IronSourceSegment;", "(Lcom/ironsource/mediationsdk/IronSourceSegment;)V", "segment", "o", "waterfallString", "Lcom/ironsource/mediationsdk/ISBannerSize;", "Lcom/ironsource/mediationsdk/ISBannerSize;", "()Lcom/ironsource/mediationsdk/ISBannerSize;", "(Lcom/ironsource/mediationsdk/ISBannerSize;)V", "bannerSize", "m", "p", "isDemandOnly", "n", "testSuiteLaunched", "useTestAds", "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class i {
    private final IronSource.AD_UNIT a;
    private final ArrayList<b1> b = new ArrayList<>();
    private boolean c;
    private String d = "";
    private boolean e;
    private Map<String, Object> f = new HashMap();
    private List<String> g = new ArrayList();
    private int h = -1;
    private h i;
    private IronSourceSegment j;
    private String k = "";
    private ISBannerSize l;
    private boolean m;
    private boolean n;
    private boolean o;

    public i(IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        this.a = ad_unit;
    }

    public static /* synthetic */ i a(i iVar, IronSource.AD_UNIT ad_unit, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ad_unit = iVar.a;
        }
        return iVar.a(ad_unit);
    }

    @Deprecated(message = "Use instancesInfo instead")
    public static /* synthetic */ void f() {
    }

    @Deprecated(message = "Use instancesInfo instead")
    public static /* synthetic */ void j() {
    }

    public final IronSource.AD_UNIT a() {
        return this.a;
    }

    public final i a(IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        return new i(ad_unit);
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final void a(b1 b1Var) {
        Intrinsics.checkNotNullParameter(b1Var, "instanceInfo");
        this.b.add(b1Var);
    }

    public final void a(ISBannerSize iSBannerSize) {
        this.l = iSBannerSize;
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.j = ironSourceSegment;
    }

    public final void a(h hVar) {
        this.i = hVar;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.g = list;
    }

    public final void a(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f = map;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    public final IronSource.AD_UNIT b() {
        return this.a;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.k = str;
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final h c() {
        return this.i;
    }

    public final void c(boolean z) {
        this.c = z;
    }

    public final ISBannerSize d() {
        return this.l;
    }

    public final void d(boolean z) {
        this.n = z;
    }

    public final Map<String, Object> e() {
        return this.f;
    }

    public final void e(boolean z) {
        this.o = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.a == ((i) obj).a;
    }

    public final String g() {
        return this.d;
    }

    public final ArrayList<b1> h() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final List<String> i() {
        return this.g;
    }

    public final IronSourceSegment k() {
        return this.j;
    }

    public final int l() {
        return this.h;
    }

    public final boolean m() {
        return this.n;
    }

    public final boolean n() {
        return this.o;
    }

    public final String o() {
        return this.k;
    }

    public final boolean p() {
        return this.m;
    }

    public final boolean q() {
        return this.e;
    }

    public final boolean r() {
        return this.c;
    }

    public String toString() {
        return "AuctionRequestParams(adUnit=" + this.a + ')';
    }
}
