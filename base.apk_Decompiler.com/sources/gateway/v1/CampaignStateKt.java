package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.ironsource.m2;
import gateway.v1.CampaignStateOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/CampaignStateKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CampaignStateKt.kt */
public final class CampaignStateKt {
    public static final CampaignStateKt INSTANCE = new CampaignStateKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003'()B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0001J%\u0010\u0010\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0013J%\u0010\u0010\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0014J+\u0010\u0015\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0007¢\u0006\u0002\b\u0018J+\u0010\u0015\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0007¢\u0006\u0002\b\u0019J\u001d\u0010\u001a\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u001bJ\u001d\u0010\u001a\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0006H\u0007¢\u0006\u0002\b\u001cJ&\u0010\u001d\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\n¢\u0006\u0002\b\u001eJ,\u0010\u001d\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\n¢\u0006\u0002\b\u001fJ&\u0010\u001d\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\n¢\u0006\u0002\b J,\u0010\u001d\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\n¢\u0006\u0002\b!J.\u0010\"\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0002\b%J.\u0010\"\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0002\b&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\n¨\u0006*"}, d2 = {"Lgateway/v1/CampaignStateKt$Dsl;", "", "_builder", "Lgateway/v1/CampaignStateOuterClass$CampaignState$Builder;", "(Lgateway/v1/CampaignStateOuterClass$CampaignState$Builder;)V", "loadedCampaigns", "Lcom/google/protobuf/kotlin/DslList;", "Lgateway/v1/CampaignStateOuterClass$Campaign;", "Lgateway/v1/CampaignStateKt$Dsl$LoadedCampaignsProxy;", "getLoadedCampaigns", "()Lcom/google/protobuf/kotlin/DslList;", "shownCampaigns", "Lgateway/v1/CampaignStateKt$Dsl$ShownCampaignsProxy;", "getShownCampaigns", "_build", "Lgateway/v1/CampaignStateOuterClass$CampaignState;", "add", "", "value", "addLoadedCampaigns", "addShownCampaigns", "addAll", "values", "", "addAllLoadedCampaigns", "addAllShownCampaigns", "clear", "clearLoadedCampaigns", "clearShownCampaigns", "plusAssign", "plusAssignLoadedCampaigns", "plusAssignAllLoadedCampaigns", "plusAssignShownCampaigns", "plusAssignAllShownCampaigns", "set", "index", "", "setLoadedCampaigns", "setShownCampaigns", "Companion", "LoadedCampaignsProxy", "ShownCampaignsProxy", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CampaignStateKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final CampaignStateOuterClass.CampaignState.Builder _builder;

        public /* synthetic */ Dsl(CampaignStateOuterClass.CampaignState.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(CampaignStateOuterClass.CampaignState.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/CampaignStateKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/CampaignStateKt$Dsl;", "builder", "Lgateway/v1/CampaignStateOuterClass$CampaignState$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: CampaignStateKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(CampaignStateOuterClass.CampaignState.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ CampaignStateOuterClass.CampaignState _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (CampaignStateOuterClass.CampaignState) build;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lgateway/v1/CampaignStateKt$Dsl$LoadedCampaignsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: CampaignStateKt.kt */
        public static final class LoadedCampaignsProxy extends DslProxy {
            private LoadedCampaignsProxy() {
            }
        }

        public final /* synthetic */ DslList getLoadedCampaigns() {
            List<CampaignStateOuterClass.Campaign> loadedCampaignsList = this._builder.getLoadedCampaignsList();
            Intrinsics.checkNotNullExpressionValue(loadedCampaignsList, "_builder.getLoadedCampaignsList()");
            return new DslList(loadedCampaignsList);
        }

        public final /* synthetic */ void addLoadedCampaigns(DslList dslList, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            this._builder.addLoadedCampaigns(campaign);
        }

        public final /* synthetic */ void plusAssignLoadedCampaigns(DslList<CampaignStateOuterClass.Campaign, LoadedCampaignsProxy> dslList, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            addLoadedCampaigns(dslList, campaign);
        }

        public final /* synthetic */ void addAllLoadedCampaigns(DslList dslList, Iterable iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            this._builder.addAllLoadedCampaigns(iterable);
        }

        public final /* synthetic */ void plusAssignAllLoadedCampaigns(DslList<CampaignStateOuterClass.Campaign, LoadedCampaignsProxy> dslList, Iterable<CampaignStateOuterClass.Campaign> iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            addAllLoadedCampaigns(dslList, iterable);
        }

        public final /* synthetic */ void setLoadedCampaigns(DslList dslList, int i, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            this._builder.setLoadedCampaigns(i, campaign);
        }

        public final /* synthetic */ void clearLoadedCampaigns(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearLoadedCampaigns();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lgateway/v1/CampaignStateKt$Dsl$ShownCampaignsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: CampaignStateKt.kt */
        public static final class ShownCampaignsProxy extends DslProxy {
            private ShownCampaignsProxy() {
            }
        }

        public final /* synthetic */ DslList getShownCampaigns() {
            List<CampaignStateOuterClass.Campaign> shownCampaignsList = this._builder.getShownCampaignsList();
            Intrinsics.checkNotNullExpressionValue(shownCampaignsList, "_builder.getShownCampaignsList()");
            return new DslList(shownCampaignsList);
        }

        public final /* synthetic */ void addShownCampaigns(DslList dslList, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            this._builder.addShownCampaigns(campaign);
        }

        public final /* synthetic */ void plusAssignShownCampaigns(DslList<CampaignStateOuterClass.Campaign, ShownCampaignsProxy> dslList, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            addShownCampaigns(dslList, campaign);
        }

        public final /* synthetic */ void addAllShownCampaigns(DslList dslList, Iterable iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            this._builder.addAllShownCampaigns(iterable);
        }

        public final /* synthetic */ void plusAssignAllShownCampaigns(DslList<CampaignStateOuterClass.Campaign, ShownCampaignsProxy> dslList, Iterable<CampaignStateOuterClass.Campaign> iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            addAllShownCampaigns(dslList, iterable);
        }

        public final /* synthetic */ void setShownCampaigns(DslList dslList, int i, CampaignStateOuterClass.Campaign campaign) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(campaign, m2.h.X);
            this._builder.setShownCampaigns(i, campaign);
        }

        public final /* synthetic */ void clearShownCampaigns(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearShownCampaigns();
        }
    }

    private CampaignStateKt() {
    }
}
