package com.ironsource.mediationsdk.adquality;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.adqualitysdk.sdk.ISAdQualityConfig;
import com.ironsource.adqualitysdk.sdk.ISAdQualityDeviceIdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.m2;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n;
import com.ironsource.q4;
import com.ironsource.r4;
import com.ironsource.va;
import com.ironsource.y3;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B1\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¨\u0006\u0019"}, d2 = {"Lcom/ironsource/mediationsdk/adquality/AdQualityBridge;", "", "", "logLevel", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityLogLevel;", "convertToAdQualityLogLevel", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityDeviceIdType;", "getDeviceIdType", "", "getCoppaValue", "", "userId", "", "changeUserId", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "segment", "setSegment", "Landroid/content/Context;", "context", "appKey", "Lcom/ironsource/n;", "adQualityDataProvider", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/ironsource/n;I)V", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class AdQualityBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0003J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0003¨\u0006\u0012"}, d2 = {"Lcom/ironsource/mediationsdk/adquality/AdQualityBridge$Companion;", "", "()V", "adQualityAvailable", "", "getAdQualitySdkVersion", "", "isGetVersionMethodExist", "logEvent", "", "eventId", "", "errorCode", "errorReason", "(ILjava/lang/Integer;Ljava/lang/String;)V", "versionCompare", "ver1", "ver2", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final String getAdQualitySdkVersion() {
            if (!isGetVersionMethodExist()) {
                return new String();
            }
            String sDKVersion = IronSourceAdQuality.getSDKVersion();
            Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final boolean isGetVersionMethodExist() {
            try {
                return Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality").getDeclaredMethods().length >= 10;
            } catch (Throwable unused) {
                logEvent$default(this, 84, (Integer) null, (String) null, 6, (Object) null);
                return false;
            }
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final void logEvent(int i, Integer num, String str) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            if (num != null) {
                mediationAdditionalData.put("errorCode", num.intValue());
            }
            if (str != null) {
                mediationAdditionalData.put("reason", str);
            }
            va.i().a(new y3(i, mediationAdditionalData));
        }

        static /* synthetic */ void logEvent$default(Companion companion, int i, Integer num, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                num = null;
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            companion.logEvent(i, num, str);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int versionCompare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return -1;
            }
            int i = 0;
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) new Regex("[^0-9.]").replace((CharSequence) str, ""), new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) new Regex("[^0-9.]").replace((CharSequence) str2, ""), new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            while (i < strArr.length && i < strArr2.length && Intrinsics.areEqual((Object) strArr[i], (Object) strArr2[i])) {
                i++;
            }
            if (i >= strArr.length || i >= strArr2.length) {
                return Integer.signum(strArr.length - strArr2.length);
            }
            int intValue = Integer.valueOf(strArr[i]).intValue();
            Integer valueOf = Integer.valueOf(strArr2[i]);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(vals2[i])");
            return Integer.signum(Intrinsics.compare(intValue, valueOf.intValue()));
        }

        @JvmStatic
        public final boolean adQualityAvailable() {
            return versionCompare(getAdQualitySdkVersion(), "7.9.0") >= 0;
        }
    }

    public AdQualityBridge(Context context, String str, String str2, n nVar, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        Intrinsics.checkNotNullParameter(nVar, "adQualityDataProvider");
        ISAdQualityConfig.Builder deviceIdType = new ISAdQualityConfig.Builder().setInitializationSource("LevelPlay").setLogLevel(convertToAdQualityLogLevel(i)).setAdQualityInitListener(new AdQualityBridge$configBuilder$1()).setCoppa(getCoppaValue()).setDeviceIdType(getDeviceIdType());
        if (!TextUtils.isEmpty(str2)) {
            deviceIdType.setUserId(str2);
        }
        Companion companion = Companion;
        if (companion.versionCompare(companion.getAdQualitySdkVersion(), "7.14.1") >= 0) {
            JSONObject a = nVar.a();
            if (a.length() > 0) {
                deviceIdType.setMetaData(a);
            }
        }
        Companion.logEvent$default(companion, 80, (Integer) null, (String) null, 6, (Object) null);
        IronSourceAdQuality.getInstance().initialize(context, str, deviceIdType.build());
    }

    @JvmStatic
    public static final boolean adQualityAvailable() {
        return Companion.adQualityAvailable();
    }

    private final ISAdQualityLogLevel convertToAdQualityLogLevel(int i) {
        return i != 0 ? i != 2 ? i != 3 ? ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.ERROR : ISAdQualityLogLevel.WARNING : ISAdQualityLogLevel.VERBOSE;
    }

    @JvmStatic
    private static final String getAdQualitySdkVersion() {
        return Companion.getAdQualitySdkVersion();
    }

    private final boolean getCoppaValue() {
        String a = q4.a().a("is_coppa");
        return a != null && Boolean.parseBoolean(a);
    }

    private final ISAdQualityDeviceIdType getDeviceIdType() {
        return !TextUtils.isEmpty(q4.a().a(r4.L)) ? ISAdQualityDeviceIdType.NONE : ISAdQualityDeviceIdType.GAID;
    }

    @JvmStatic
    private static final boolean isGetVersionMethodExist() {
        return Companion.isGetVersionMethodExist();
    }

    @JvmStatic
    private static final void logEvent(int i, Integer num, String str) {
        Companion.logEvent(i, num, str);
    }

    @JvmStatic
    private static final int versionCompare(String str, String str2) {
        return Companion.versionCompare(str, str2);
    }

    public final void changeUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        IronSourceAdQuality.getInstance().changeUserId(str);
    }

    public final void setSegment(IronSourceSegment ironSourceSegment) {
        Intrinsics.checkNotNullParameter(ironSourceSegment, "segment");
        ISAdQualitySegment.Builder builder = new ISAdQualitySegment.Builder();
        if (ironSourceSegment.getSegmentName() != null) {
            builder.setSegmentName(ironSourceSegment.getSegmentName());
        }
        if (ironSourceSegment.getAge() > -1) {
            builder.setAge(ironSourceSegment.getAge());
        }
        if (ironSourceSegment.getGender() != null) {
            builder.setGender(ironSourceSegment.getGender());
        }
        if (ironSourceSegment.getLevel() > -1) {
            builder.setLevel(ironSourceSegment.getLevel());
        }
        if (ironSourceSegment.getIsPaying() != null) {
            builder.setIsPaying(ironSourceSegment.getIsPaying().get());
        }
        if (ironSourceSegment.getIapt() > -1.0d) {
            builder.setInAppPurchasesTotal(ironSourceSegment.getIapt());
        }
        if (ironSourceSegment.getUcd() > 0) {
            builder.setUserCreationDate(ironSourceSegment.getUcd());
        }
        Iterator<Pair<String, String>> it = ironSourceSegment.getSegmentData().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            String str = (String) next.first;
            String str2 = (String) next.second;
            Intrinsics.checkNotNullExpressionValue(str, m2.h.W);
            if (StringsKt.startsWith$default(str, "custom_", false, 2, (Object) null)) {
                builder.setCustomData(StringsKt.removePrefix(str, (CharSequence) "custom_"), str2);
            }
        }
        IronSourceAdQuality.getInstance().setSegment(builder.build());
    }
}
