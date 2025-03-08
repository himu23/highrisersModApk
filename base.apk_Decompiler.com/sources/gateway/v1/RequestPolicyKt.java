package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import gateway.v1.NativeConfigurationOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/RequestPolicyKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RequestPolicyKt.kt */
public final class RequestPolicyKt {
    public static final RequestPolicyKt INSTANCE = new RequestPolicyKt();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lgateway/v1/RequestPolicyKt$Dsl;", "", "_builder", "Lgateway/v1/NativeConfigurationOuterClass$RequestPolicy$Builder;", "(Lgateway/v1/NativeConfigurationOuterClass$RequestPolicy$Builder;)V", "value", "Lgateway/v1/NativeConfigurationOuterClass$RequestRetryPolicy;", "retryPolicy", "getRetryPolicy", "()Lgateway/v1/NativeConfigurationOuterClass$RequestRetryPolicy;", "setRetryPolicy", "(Lgateway/v1/NativeConfigurationOuterClass$RequestRetryPolicy;)V", "Lgateway/v1/NativeConfigurationOuterClass$RequestTimeoutPolicy;", "timeoutPolicy", "getTimeoutPolicy", "()Lgateway/v1/NativeConfigurationOuterClass$RequestTimeoutPolicy;", "setTimeoutPolicy", "(Lgateway/v1/NativeConfigurationOuterClass$RequestTimeoutPolicy;)V", "_build", "Lgateway/v1/NativeConfigurationOuterClass$RequestPolicy;", "clearRetryPolicy", "", "clearTimeoutPolicy", "hasRetryPolicy", "", "hasTimeoutPolicy", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RequestPolicyKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final NativeConfigurationOuterClass.RequestPolicy.Builder _builder;

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.RequestPolicy.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(NativeConfigurationOuterClass.RequestPolicy.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/RequestPolicyKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/RequestPolicyKt$Dsl;", "builder", "Lgateway/v1/NativeConfigurationOuterClass$RequestPolicy$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: RequestPolicyKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.RequestPolicy.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ NativeConfigurationOuterClass.RequestPolicy _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (NativeConfigurationOuterClass.RequestPolicy) build;
        }

        public final NativeConfigurationOuterClass.RequestRetryPolicy getRetryPolicy() {
            NativeConfigurationOuterClass.RequestRetryPolicy retryPolicy = this._builder.getRetryPolicy();
            Intrinsics.checkNotNullExpressionValue(retryPolicy, "_builder.getRetryPolicy()");
            return retryPolicy;
        }

        public final void setRetryPolicy(NativeConfigurationOuterClass.RequestRetryPolicy requestRetryPolicy) {
            Intrinsics.checkNotNullParameter(requestRetryPolicy, m2.h.X);
            this._builder.setRetryPolicy(requestRetryPolicy);
        }

        public final void clearRetryPolicy() {
            this._builder.clearRetryPolicy();
        }

        public final boolean hasRetryPolicy() {
            return this._builder.hasRetryPolicy();
        }

        public final NativeConfigurationOuterClass.RequestTimeoutPolicy getTimeoutPolicy() {
            NativeConfigurationOuterClass.RequestTimeoutPolicy timeoutPolicy = this._builder.getTimeoutPolicy();
            Intrinsics.checkNotNullExpressionValue(timeoutPolicy, "_builder.getTimeoutPolicy()");
            return timeoutPolicy;
        }

        public final void setTimeoutPolicy(NativeConfigurationOuterClass.RequestTimeoutPolicy requestTimeoutPolicy) {
            Intrinsics.checkNotNullParameter(requestTimeoutPolicy, m2.h.X);
            this._builder.setTimeoutPolicy(requestTimeoutPolicy);
        }

        public final void clearTimeoutPolicy() {
            this._builder.clearTimeoutPolicy();
        }

        public final boolean hasTimeoutPolicy() {
            return this._builder.hasTimeoutPolicy();
        }
    }

    private RequestPolicyKt() {
    }
}
