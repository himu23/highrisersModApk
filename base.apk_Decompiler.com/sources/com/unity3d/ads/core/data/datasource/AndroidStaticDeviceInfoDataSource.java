package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.unity3d.ads.core.data.model.StorageType;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.MimeTypes;
import com.unity3d.services.core.device.OpenAdvertisingId;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import gateway.v1.StaticDeviceInfoKt;
import gateway.v1.StaticDeviceInfoOuterClass;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.x500.X500Principal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 g2\u00020\u0001:\u0001gB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\u0011\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\u000eJ\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0003J\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\u0011\u00103\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u00104\u001a\u00020\u000eH\u0002J\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u00020\u000eJ\u0011\u00107\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u00108\u001a\u00020\u000eH\u0003J\b\u00109\u001a\u00020\u000eH\u0016J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<H\u0002J\u0012\u0010=\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010?\u001a\u00020\u000eH\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0AH\u0003J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0CH\u0002J\b\u0010D\u001a\u00020\u000eH\u0002J\b\u0010E\u001a\u00020\u000eH\u0016J\b\u0010F\u001a\u00020\u000eH\u0002J\u0006\u0010G\u001a\u00020\u000eJ\b\u0010H\u001a\u00020\u001aH\u0002J\b\u0010I\u001a\u00020\u001aH\u0002J\b\u0010J\u001a\u00020\u001aH\u0002J\b\u0010K\u001a\u00020\u001aH\u0002J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0CJ\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0CH\u0002J\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0CJ\u0006\u0010P\u001a\u00020\u001dJ\u0010\u0010Q\u001a\u00020\u001d2\b\u0010R\u001a\u0004\u0018\u00010/J\b\u0010S\u001a\u00020\u001aH\u0002J\b\u0010T\u001a\u00020\u000eH\u0002J\b\u0010U\u001a\u00020\u000eH\u0002J\u0006\u0010V\u001a\u00020WJ\u0006\u0010X\u001a\u00020WJ\b\u0010Y\u001a\u00020WH\u0002J\u001a\u0010Z\u001a\u00020W2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010^\u001a\u00020W2\u0006\u0010[\u001a\u00020\\H\u0003J\u0006\u0010_\u001a\u00020WJ\b\u0010`\u001a\u00020WH\u0002J\u001a\u0010a\u001a\u00020W2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010b\u001a\u00020W2\u0006\u0010[\u001a\u00020\\H\u0003J\b\u0010c\u001a\u00020WH\u0002J\u0010\u0010d\u001a\u00020W2\u0006\u0010e\u001a\u00020\u000eH\u0002J\u0018\u0010f\u001a\b\u0012\u0004\u0012\u00020\\0C2\b\u0010]\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidStaticDeviceInfoDataSource;", "Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;", "context", "Landroid/content/Context;", "idfiStore", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "auidStore", "glInfoStore", "analyticsDataSource", "Lcom/unity3d/ads/core/data/datasource/AnalyticsDataSource;", "(Landroid/content/Context;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/AnalyticsDataSource;)V", "DEBUG_CERT", "Ljavax/security/auth/x500/X500Principal;", "analyticsUserId", "", "getAnalyticsUserId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "fetch", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndroidStaticDeviceInfo", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo$Android;", "getAdvertisingTrackingId", "getApiLevel", "", "getAppName", "getAppStartTime", "", "getAppVersion", "getAuid", "Lcom/google/protobuf/ByteString;", "getBoard", "getBootloader", "getBrand", "getBuildId", "getBuildVersionIncremental", "getCPUCount", "getCPUModel", "getCertificateFingerprint", "getDevice", "getDisplay", "getDisplayMetricDensity", "", "getExtensionVersion", "getFileForStorageType", "Ljava/io/File;", "storageType", "Lcom/unity3d/ads/core/data/model/StorageType;", "getFingerprint", "getGPUModel", "getGameId", "getHardware", "getHost", "getIdfi", "getInstallerPackageName", "getManufacturer", "getMemoryInfo", "infoType", "Lcom/unity3d/services/core/device/Device$MemoryInfoType;", "getMemoryValueFromString", "memVal", "getModel", "getNewAbiList", "Ljava/util/ArrayList;", "getOldAbiList", "", "getOpenAdvertisingTrackingId", "getOsVersion", "getPlatform", "getProduct", "getScreenDensity", "getScreenHeight", "getScreenLayout", "getScreenWidth", "getSensorList", "Landroid/hardware/Sensor;", "getStores", "getSupportedAbis", "getTotalMemory", "getTotalSpace", "file", "getVersionCode", "getVersionName", "getWebViewUserAgent", "hasX264Decoder", "", "hasX265Decoder", "isAppDebuggable", "isHardwareAccelerated", "codecInfo", "Landroid/media/MediaCodecInfo;", "mimeType", "isHardwareAcceleratedV29", "isLimitOpenAdTrackingEnabled", "isRooted", "isSoftwareOnly", "isSoftwareOnlyV29", "isTestMode", "searchPathForBinary", "binary", "selectAllDecodeCodecs", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidStaticDeviceInfoDataSource.kt */
public final class AndroidStaticDeviceInfoDataSource implements StaticDeviceInfoDataSource {
    public static final String ALGORITHM_SHA1 = "SHA-1";
    public static final String APP_VERSION_FAKE = "FakeVersionName";
    public static final String BINARY_SU = "su";
    public static final String CERTIFICATE_TYPE_X509 = "X.509";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ENVIRONMENT_VARIABLE_PATH = "PATH";
    public static final String PLATFORM_ANDROID = "android";
    public static final String PREF_KEY_AUID = "auid";
    public static final String PREF_KEY_IDFI = "unityads-idfi";
    public static final String PREF_KEY_INSTALLINFO = "unityads-installinfo";
    public static final String PREF_KEY_SUPERSONIC = "supersonic_shared_preferen";
    public static final String STORE_GOOGLE = "google";
    private final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private final AnalyticsDataSource analyticsDataSource;
    private final ByteStringDataSource auidStore;
    private final Context context;
    private final ByteStringDataSource glInfoStore;
    private final ByteStringDataSource idfiStore;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidStaticDeviceInfoDataSource.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        static {
            /*
                com.unity3d.services.core.device.Device$MemoryInfoType[] r0 = com.unity3d.services.core.device.Device.MemoryInfoType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.unity3d.services.core.device.Device$MemoryInfoType r2 = com.unity3d.services.core.device.Device.MemoryInfoType.TOTAL_MEMORY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.unity3d.services.core.device.Device$MemoryInfoType r3 = com.unity3d.services.core.device.Device.MemoryInfoType.FREE_MEMORY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.unity3d.ads.core.data.model.StorageType[] r0 = com.unity3d.ads.core.data.model.StorageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.unity3d.ads.core.data.model.StorageType r3 = com.unity3d.ads.core.data.model.StorageType.INTERNAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.unity3d.ads.core.data.model.StorageType r1 = com.unity3d.ads.core.data.model.StorageType.EXTERNAL     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.WhenMappings.<clinit>():void");
        }
    }

    private final int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    private final String getPlatform() {
        return "android";
    }

    private final int getVersionCode() {
        return 4920;
    }

    private final String getVersionName() {
        return "4.9.2";
    }

    public final Context getContext() {
        return this.context;
    }

    public AndroidStaticDeviceInfoDataSource(Context context2, ByteStringDataSource byteStringDataSource, ByteStringDataSource byteStringDataSource2, ByteStringDataSource byteStringDataSource3, AnalyticsDataSource analyticsDataSource2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(byteStringDataSource, "idfiStore");
        Intrinsics.checkNotNullParameter(byteStringDataSource2, "auidStore");
        Intrinsics.checkNotNullParameter(byteStringDataSource3, "glInfoStore");
        Intrinsics.checkNotNullParameter(analyticsDataSource2, "analyticsDataSource");
        this.context = context2;
        this.idfiStore = byteStringDataSource;
        this.auidStore = byteStringDataSource2;
        this.glInfoStore = byteStringDataSource3;
        this.analyticsDataSource = analyticsDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetch(kotlin.coroutines.Continuation<? super gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1 r0 = (com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1 r0 = new com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r1 = r0.L$3
            gateway.v1.StaticDeviceInfoKt$Dsl r1 = (gateway.v1.StaticDeviceInfoKt.Dsl) r1
            java.lang.Object r2 = r0.L$2
            gateway.v1.StaticDeviceInfoKt$Dsl r2 = (gateway.v1.StaticDeviceInfoKt.Dsl) r2
            java.lang.Object r3 = r0.L$1
            gateway.v1.StaticDeviceInfoKt$Dsl r3 = (gateway.v1.StaticDeviceInfoKt.Dsl) r3
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource r0 = (com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00ee
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            gateway.v1.StaticDeviceInfoKt$Dsl$Companion r7 = gateway.v1.StaticDeviceInfoKt.Dsl.Companion
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo$Builder r2 = gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            gateway.v1.StaticDeviceInfoKt$Dsl r7 = r7._create(r2)
            java.lang.String r2 = r6.getAppName()
            r7.setBundleId(r2)
            java.lang.String r2 = r6.getAppVersion()
            r7.setBundleVersion(r2)
            boolean r2 = r6.isAppDebuggable()
            r7.setAppDebuggable(r2)
            boolean r2 = r6.isRooted()
            r7.setRooted(r2)
            java.lang.String r2 = r6.getOsVersion()
            r7.setOsVersion(r2)
            java.lang.String r2 = r6.getManufacturer()
            r7.setDeviceMake(r2)
            java.lang.String r2 = r6.getModel()
            r7.setDeviceModel(r2)
            java.lang.String r2 = r6.getWebViewUserAgent()
            r7.setWebviewUa(r2)
            int r2 = r6.getScreenDensity()
            r7.setScreenDensity(r2)
            int r2 = r6.getScreenWidth()
            r7.setScreenWidth(r2)
            int r2 = r6.getScreenHeight()
            r7.setScreenHeight(r2)
            int r2 = r6.getScreenLayout()
            r7.setScreenSize(r2)
            com.google.protobuf.kotlin.DslList r2 = r7.getStores()
            java.util.List r4 = r6.getStores()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r7.addAllStores(r2, r4)
            com.unity3d.ads.core.data.model.StorageType r2 = com.unity3d.ads.core.data.model.StorageType.EXTERNAL
            java.io.File r2 = r6.getFileForStorageType(r2)
            long r4 = r6.getTotalSpace(r2)
            r7.setTotalDiskSpace(r4)
            long r4 = r6.getTotalMemory()
            r7.setTotalRamMemory(r4)
            java.lang.String r2 = r6.getCPUModel()
            r7.setCpuModel(r2)
            long r4 = r6.getCPUCount()
            r7.setCpuCount(r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r0 = r6.getGPUModel(r0)
            if (r0 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            r1 = r7
            r2 = r1
            r3 = r2
            r7 = r0
            r0 = r6
        L_0x00ee:
            java.lang.String r7 = (java.lang.String) r7
            r1.setGpuModel(r7)
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo$Android r7 = r0.fetchAndroidStaticDeviceInfo()
            r2.setAndroid(r7)
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r7 = r3._build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.fetch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android fetchAndroidStaticDeviceInfo() {
        StaticDeviceInfoKt staticDeviceInfoKt = StaticDeviceInfoKt.INSTANCE;
        StaticDeviceInfoKt.AndroidKt.Dsl.Companion companion = StaticDeviceInfoKt.AndroidKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder newBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        StaticDeviceInfoKt.AndroidKt.Dsl _create = companion._create(newBuilder);
        _create.setApiLevel(getApiLevel());
        _create.setVersionCode(getVersionCode());
        _create.setAndroidFingerprint(getFingerprint());
        _create.setAppInstaller(getInstallerPackageName());
        _create.setApkDeveloperSigningCertificateHash(getCertificateFingerprint());
        _create.setBuildBoard(getBoard());
        _create.setBuildBrand(getBrand());
        _create.setBuildDevice(getDevice());
        _create.setBuildDisplay(getDisplay());
        _create.setBuildFingerprint(getFingerprint());
        _create.setBuildHardware(getHardware());
        _create.setBuildHost(getHost());
        _create.setBuildBootloader(getBootloader());
        _create.setBuildProduct(getProduct());
        _create.setExtensionVersion(getExtensionVersion());
        String buildId = getBuildId();
        if (buildId != null) {
            _create.setBuildId(buildId);
        }
        return _create._build();
    }

    public String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public String getManufacturer() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str;
    }

    public String getModel() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    private final int getScreenLayout() {
        return this.context.getResources().getConfiguration().screenLayout;
    }

    public final String getAdvertisingTrackingId() {
        String advertisingTrackingId = AdvertisingId.getAdvertisingTrackingId();
        return advertisingTrackingId == null ? "" : advertisingTrackingId;
    }

    private final String getOpenAdvertisingTrackingId() {
        String openAdvertisingTrackingId = OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return openAdvertisingTrackingId == null ? "" : openAdvertisingTrackingId;
    }

    public final boolean isLimitOpenAdTrackingEnabled() {
        return OpenAdvertisingId.getLimitedOpenAdTracking();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getIdfi(kotlin.coroutines.Continuation<? super com.google.protobuf.ByteString> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getIdfi$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getIdfi$1 r0 = (com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getIdfi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getIdfi$1 r0 = new com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getIdfi$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.idfiStore
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.lang.String r0 = "idfiStore.get().data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.getIdfi(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String getAnalyticsUserId() {
        return this.analyticsDataSource.getUserId();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAuid(kotlin.coroutines.Continuation<? super com.google.protobuf.ByteString> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getAuid$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getAuid$1 r0 = (com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getAuid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getAuid$1 r0 = new com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getAuid$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.auidStore
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.lang.String r0 = "auidStore.get().data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.getAuid(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final float getDisplayMetricDensity() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 0.0f;
        }
        return displayMetrics.density;
    }

    private final int getScreenDensity() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.densityDpi;
    }

    private final int getScreenWidth() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.widthPixels;
    }

    private final int getScreenHeight() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.heightPixels;
    }

    private final boolean isRooted() {
        try {
            return searchPathForBinary(BINARY_SU);
        } catch (Exception e) {
            DeviceLog.exception("Rooted check failed", e);
            return false;
        }
    }

    private final boolean searchPathForBinary(String str) {
        List<String> split;
        List list;
        String[] strArr;
        File[] listFiles;
        String str2 = System.getenv(ENVIRONMENT_VARIABLE_PATH);
        if (!(str2 == null || (split = new Regex(":").split(str2, 0)) == null)) {
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt.emptyList();
            if (!(list == null || (strArr = (String[]) list.toArray(new String[0])) == null)) {
                for (String file : strArr) {
                    File file2 = new File(file);
                    if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                        for (File name : listFiles) {
                            if (Intrinsics.areEqual((Object) name.getName(), (Object) str)) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }

    @Deprecated(message = "This constant was deprecated in API level 28. Use GET_SIGNING_CERTIFICATES instead")
    private final String getCertificateFingerprint() {
        try {
            Signature[] signatureArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 64).signatures;
            if (signatureArr == null) {
                return "";
            }
            if (!(!(signatureArr.length == 0))) {
                return "";
            }
            Certificate generateCertificate = CertificateFactory.getInstance(CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
            Intrinsics.checkNotNull(generateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            String hexString = Utilities.toHexString(MessageDigest.getInstance(ALGORITHM_SHA1).digest(((X509Certificate) generateCertificate).getEncoded()));
            Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(publicKey)");
            return hexString;
        } catch (Exception e) {
            DeviceLog.exception("Exception when signing certificate fingerprint", e);
            return "";
        }
    }

    public final String getBoard() {
        String str = Build.BOARD;
        return str == null ? "" : str;
    }

    public final String getBootloader() {
        String str = Build.BOOTLOADER;
        return str == null ? "" : str;
    }

    public final String getBrand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    public final String getDisplay() {
        String str = Build.DISPLAY;
        return str == null ? "" : str;
    }

    public final String getDevice() {
        String str = Build.DEVICE;
        return str == null ? "" : str;
    }

    public final String getHardware() {
        String str = Build.HARDWARE;
        return str == null ? "" : str;
    }

    public final String getHost() {
        String str = Build.HOST;
        return str == null ? "" : str;
    }

    public final String getProduct() {
        String str = Build.PRODUCT;
        return str == null ? "" : str;
    }

    private final String getFingerprint() {
        String str = Build.FINGERPRINT;
        return str == null ? "" : str;
    }

    @Deprecated(message = "This method was deprecated in API level 30. use getInstallSourceInfo")
    private final String getInstallerPackageName() {
        String installerPackageName = this.context.getPackageManager().getInstallerPackageName(this.context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public final List<String> getSupportedAbis() {
        if (getApiLevel() < 21) {
            return getOldAbiList();
        }
        return getNewAbiList();
    }

    public final List<Sensor> getSensorList() {
        Object systemService = this.context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        List<Sensor> sensorList = ((SensorManager) systemService).getSensorList(-1);
        Intrinsics.checkNotNullExpressionValue(sensorList, "sensorManager.getSensorList(Sensor.TYPE_ALL)");
        return sensorList;
    }

    private final String getCPUModel() {
        if (Build.VERSION.SDK_INT < 31) {
            return (String) CollectionsKt.last(FilesKt.readLines$default(new File("/proc/cpuinfo"), (Charset) null, 1, (Object) null));
        }
        String m = g$$ExternalSyntheticApiModelOutline0.m();
        Intrinsics.checkNotNullExpressionValue(m, "{\n            Build.SOC_MODEL\n        }");
        return m;
    }

    private final long getCPUCount() {
        return (long) Runtime.getRuntime().availableProcessors();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGPUModel(kotlin.coroutines.Continuation<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1 r0 = (com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1 r0 = new com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.glInfoStore
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.nio.charset.Charset r0 = kotlin.text.Charsets.ISO_8859_1
            java.lang.String r5 = r5.toString((java.nio.charset.Charset) r0)
            java.lang.String r0 = "glInfoStore.get().data.t…ring(Charsets.ISO_8859_1)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.getGPUModel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getBuildId() {
        return Build.ID;
    }

    public final String getBuildVersionIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    private final List<String> getOldAbiList() {
        List<String> arrayList = new ArrayList<>();
        String str = Build.CPU_ABI;
        Intrinsics.checkNotNullExpressionValue(str, "CPU_ABI");
        arrayList.add(str);
        String str2 = Build.CPU_ABI2;
        Intrinsics.checkNotNullExpressionValue(str2, "CPU_ABI2");
        arrayList.add(str2);
        return arrayList;
    }

    private final ArrayList<String> getNewAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
        arrayList.addAll(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)));
        return arrayList;
    }

    private final String getWebViewUserAgent() {
        String defaultUserAgent = WebSettings.getDefaultUserAgent(this.context);
        Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "getDefaultUserAgent(context)");
        return defaultUserAgent;
    }

    private final List<String> getStores() {
        return CollectionsKt.listOf(STORE_GOOGLE);
    }

    private final long getAppStartTime() {
        return SdkProperties.getInitializationTimeEpoch();
    }

    private final boolean isTestMode() {
        return SdkProperties.isTestMode();
    }

    private final String getGameId() {
        String gameId = ClientProperties.getGameId();
        return gameId == null ? "" : gameId;
    }

    public final long getTotalMemory() {
        return getMemoryInfo(Device.MemoryInfoType.TOTAL_MEMORY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long getMemoryInfo(com.unity3d.services.core.device.Device.MemoryInfoType r6) {
        /*
            r5 = this;
            int[] r0 = com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r0[r6]
            r0 = 1
            if (r6 == r0) goto L_0x000f
            r0 = 2
            if (r6 == r0) goto L_0x000f
            r0 = -1
        L_0x000f:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile
            java.lang.String r1 = "/proc/meminfo"
            java.lang.String r2 = "r"
            r6.<init>(r1, r2)
            java.io.Closeable r6 = (java.io.Closeable) r6
            r1 = r6
            java.io.RandomAccessFile r1 = (java.io.RandomAccessFile) r1     // Catch:{ all -> 0x0033 }
            r2 = 0
            r3 = 0
            r4 = r2
        L_0x0020:
            if (r3 >= r0) goto L_0x0029
            java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x0033 }
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0029:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0033 }
            kotlin.io.CloseableKt.closeFinally(r6, r2)
            long r0 = r5.getMemoryValueFromString(r4)
            return r0
        L_0x0033:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.getMemoryInfo(com.unity3d.services.core.device.Device$MemoryInfoType):long");
    }

    private final long getMemoryValueFromString(String str) {
        if (str == null) {
            return 0;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        if (str2 != null) {
            return Long.parseLong(str2);
        }
        return -1;
    }

    public final long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        return (long) MathKt.roundToInt((float) (file.getTotalSpace() / ((long) 1024)));
    }

    private final File getFileForStorageType(StorageType storageType) {
        int i = WhenMappings.$EnumSwitchMapping$1[storageType.ordinal()];
        if (i == 1) {
            return ClientProperties.getApplicationContext().getCacheDir();
        }
        if (i == 2) {
            return ClientProperties.getApplicationContext().getExternalCacheDir();
        }
        DeviceLog.error("Unhandled storagetype: " + storageType);
        return null;
    }

    public String getAppName() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return packageName;
    }

    private final String getAppVersion() {
        String str;
        String packageName = this.context.getPackageName();
        PackageManager packageManager = this.context.getPackageManager();
        try {
            if (packageManager.getPackageInfo(packageName, 0).versionName == null) {
                str = APP_VERSION_FAKE;
            } else {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if (pm.get…e\n            }\n        }");
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Error getting package info", e);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isAppDebuggable() {
        /*
            r8 = this;
            java.lang.String r0 = "Could not find name"
            android.content.Context r1 = r8.context
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "context.packageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r8.context
            java.lang.String r2 = r2.getPackageName()
            java.lang.String r3 = "context.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 1
            r4 = 0
            android.content.pm.ApplicationInfo r5 = r1.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x0030 }
            java.lang.String r6 = "pm.getApplicationInfo(pkgName, 0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ NameNotFoundException -> 0x0030 }
            int r6 = r5.flags     // Catch:{ NameNotFoundException -> 0x0030 }
            r6 = r6 & 2
            r5.flags = r6     // Catch:{ NameNotFoundException -> 0x0030 }
            int r5 = r5.flags     // Catch:{ NameNotFoundException -> 0x0030 }
            r3 = 0
            if (r5 == 0) goto L_0x0036
            r5 = 1
            goto L_0x0037
        L_0x0030:
            r5 = move-exception
            java.lang.Exception r5 = (java.lang.Exception) r5
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L_0x0036:
            r5 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0085
            r3 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            android.content.pm.Signature[] r1 = r1.signatures     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.lang.String r2 = "signatures"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            int r2 = r1.length     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
        L_0x0047:
            if (r4 >= r2) goto L_0x0085
            r3 = r1[r4]     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.lang.String r6 = "X.509"
            java.security.cert.CertificateFactory r6 = java.security.cert.CertificateFactory.getInstance(r6)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            byte[] r3 = r3.toByteArray()     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            r7.<init>(r3)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.io.InputStream r7 = (java.io.InputStream) r7     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.security.cert.Certificate r3 = r6.generateCertificate(r7)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.lang.String r6 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r6)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            javax.security.auth.x500.X500Principal r3 = r3.getSubjectX500Principal()     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            javax.security.auth.x500.X500Principal r6 = r8.DEBUG_CERT     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ NameNotFoundException -> 0x007f, CertificateException -> 0x0076 }
            if (r5 != 0) goto L_0x0085
            int r4 = r4 + 1
            goto L_0x0047
        L_0x0076:
            r0 = move-exception
            java.lang.String r1 = "Certificate exception"
            java.lang.Exception r0 = (java.lang.Exception) r0
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)
            goto L_0x0085
        L_0x007f:
            r1 = move-exception
            java.lang.Exception r1 = (java.lang.Exception) r1
            com.unity3d.services.core.log.DeviceLog.exception(r0, r1)
        L_0x0085:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource.isAppDebuggable():boolean");
    }

    private final int getExtensionVersion() {
        if (Build.VERSION.SDK_INT >= 30) {
            return SdkExtensions.getExtensionVersion(30);
        }
        return -1;
    }

    public final boolean hasX264Decoder() {
        return !selectAllDecodeCodecs(MimeTypes.VIDEO_H264).isEmpty();
    }

    public final boolean hasX265Decoder() {
        return !selectAllDecodeCodecs(MimeTypes.VIDEO_H265).isEmpty();
    }

    private final List<MediaCodecInfo> selectAllDecodeCodecs(String str) {
        List<MediaCodecInfo> arrayList = new ArrayList<>();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String equals : codecInfoAt.getSupportedTypes()) {
                    if (StringsKt.equals(equals, str, true)) {
                        Intrinsics.checkNotNullExpressionValue(codecInfoAt, "codecInfo");
                        if (isHardwareAccelerated(codecInfoAt, str)) {
                            arrayList.add(codecInfoAt);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo, String str) {
        if (getApiLevel() >= 29) {
            return isHardwareAcceleratedV29(mediaCodecInfo);
        }
        return !isSoftwareOnly(mediaCodecInfo, str);
    }

    private final boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private final boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo, String str) {
        if (getApiLevel() >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        String name = mediaCodecInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "codecInfo.name");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.startsWith$default(lowerCase, "arc.", false, 2, (Object) null)) {
            return false;
        }
        if (StringsKt.startsWith$default(lowerCase, "omx.google.", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "omx.ffmpeg.", false, 2, (Object) null) || ((StringsKt.startsWith$default(lowerCase, "omx.sec.", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".sw.", false, 2, (Object) null)) || Intrinsics.areEqual((Object) lowerCase, (Object) "omx.qcom.video.decoder.hevcswvdec") || StringsKt.startsWith$default(lowerCase, "c2.android.", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "c2.google.", false, 2, (Object) null) || (!StringsKt.startsWith$default(lowerCase, "omx.", false, 2, (Object) null) && !StringsKt.startsWith$default(lowerCase, "c2.", false, 2, (Object) null)))) {
            return true;
        }
        return false;
    }

    private final boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidStaticDeviceInfoDataSource$Companion;", "", "()V", "ALGORITHM_SHA1", "", "APP_VERSION_FAKE", "BINARY_SU", "CERTIFICATE_TYPE_X509", "ENVIRONMENT_VARIABLE_PATH", "PLATFORM_ANDROID", "PREF_KEY_AUID", "PREF_KEY_IDFI", "PREF_KEY_INSTALLINFO", "PREF_KEY_SUPERSONIC", "STORE_GOOGLE", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidStaticDeviceInfoDataSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
