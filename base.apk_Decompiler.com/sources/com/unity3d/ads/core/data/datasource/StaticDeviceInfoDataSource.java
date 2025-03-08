package com.unity3d.ads.core.data.datasource;

import com.google.protobuf.ByteString;
import gateway.v1.StaticDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H&J\u0011\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010\f\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;", "", "analyticsUserId", "", "getAnalyticsUserId", "()Ljava/lang/String;", "fetch", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppName", "getAuid", "Lcom/google/protobuf/ByteString;", "getIdfi", "getManufacturer", "getModel", "getOsVersion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StaticDeviceInfoDataSource.kt */
public interface StaticDeviceInfoDataSource {
    Object fetch(Continuation<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> continuation);

    String getAnalyticsUserId();

    String getAppName();

    Object getAuid(Continuation<? super ByteString> continuation);

    Object getIdfi(Continuation<? super ByteString> continuation);

    String getManufacturer();

    String getModel();

    String getOsVersion();
}
