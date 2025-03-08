package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.DynamicDeviceInfoKt;
import gateway.v1.DynamicDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"androidOrNull", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android;", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfoOrBuilder;", "getAndroidOrNull", "(Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfoOrBuilder;)Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android;", "iosOrNull", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Ios;", "getIosOrNull", "(Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfoOrBuilder;)Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Ios;", "dynamicDeviceInfo", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "block", "Lkotlin/Function1;", "Lgateway/v1/DynamicDeviceInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedynamicDeviceInfo", "copy", "Lgateway/v1/DynamicDeviceInfoKt$AndroidKt$Dsl;", "Lgateway/v1/DynamicDeviceInfoKt$IosKt$Dsl;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DynamicDeviceInfoKt.kt */
public final class DynamicDeviceInfoKtKt {
    /* renamed from: -initializedynamicDeviceInfo  reason: not valid java name */
    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo m108initializedynamicDeviceInfo(Function1<? super DynamicDeviceInfoKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DynamicDeviceInfoKt.Dsl.Companion companion = DynamicDeviceInfoKt.Dsl.Companion;
        DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder newBuilder = DynamicDeviceInfoOuterClass.DynamicDeviceInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DynamicDeviceInfoKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo copy(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo, Function1<? super DynamicDeviceInfoKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(dynamicDeviceInfo, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        DynamicDeviceInfoKt.Dsl.Companion companion = DynamicDeviceInfoKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = dynamicDeviceInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DynamicDeviceInfoKt.Dsl _create = companion._create((DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android copy(DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android android2, Function1<? super DynamicDeviceInfoKt.AndroidKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(android2, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        DynamicDeviceInfoKt.AndroidKt.Dsl.Companion companion = DynamicDeviceInfoKt.AndroidKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = android2.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DynamicDeviceInfoKt.AndroidKt.Dsl _create = companion._create((DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Ios copy(DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Ios ios, Function1<? super DynamicDeviceInfoKt.IosKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(ios, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        DynamicDeviceInfoKt.IosKt.Dsl.Companion companion = DynamicDeviceInfoKt.IosKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = ios.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DynamicDeviceInfoKt.IosKt.Dsl _create = companion._create((DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Ios.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android getAndroidOrNull(DynamicDeviceInfoOuterClass.DynamicDeviceInfoOrBuilder dynamicDeviceInfoOrBuilder) {
        Intrinsics.checkNotNullParameter(dynamicDeviceInfoOrBuilder, "<this>");
        if (dynamicDeviceInfoOrBuilder.hasAndroid()) {
            return dynamicDeviceInfoOrBuilder.getAndroid();
        }
        return null;
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Ios getIosOrNull(DynamicDeviceInfoOuterClass.DynamicDeviceInfoOrBuilder dynamicDeviceInfoOrBuilder) {
        Intrinsics.checkNotNullParameter(dynamicDeviceInfoOrBuilder, "<this>");
        if (dynamicDeviceInfoOrBuilder.hasIos()) {
            return dynamicDeviceInfoOrBuilder.getIos();
        }
        return null;
    }
}
