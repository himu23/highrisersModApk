package com.ironsource;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002Jo\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0011JG\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ironsource/sb;", "", "Lorg/json/JSONObject;", "a", "", "appKey", "sdkVersion", "bundleId", "appName", "appVersion", "", "consent", "initResponse", "isRewardedVideoManual", "generalProperties", "adaptersVersions", "metaData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lorg/json/JSONObject;ZLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;", "Landroid/content/Context;", "context", "testSuiteControllerUrl", "", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class sb {
    private final String a(String str, String str2, String str3, String str4, String str5, Boolean bool, JSONObject jSONObject, boolean z, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        String jSONObject5 = new JSONObject(MapsKt.mapOf(TuplesKt.to(jc.p0, m2.e), TuplesKt.to("appKey", str), TuplesKt.to("sdkVersion", str2), TuplesKt.to("bundleId", str3), TuplesKt.to("appName", str4), TuplesKt.to("appVersion", str5), TuplesKt.to("initResponse", jSONObject), TuplesKt.to("isRvManual", Boolean.valueOf(z)), TuplesKt.to("generalProperties", jSONObject2), TuplesKt.to("adaptersVersion", jSONObject3), TuplesKt.to("metaData", jSONObject4), TuplesKt.to("gdprConsent", bool))).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject5, "JSONObject(mapOf(\n      …ent\n        )).toString()");
        return jSONObject5;
    }

    private final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : yb.a.d().entrySet()) {
            jSONObject.putOpt((String) next.getKey(), new JSONArray((List) next.getValue()));
        }
        return jSONObject;
    }

    public final void a(Context context, String str, JSONObject jSONObject, String str2, String str3, Boolean bool, boolean z) {
        Context context2 = context;
        String str4 = str3;
        Intrinsics.checkNotNullParameter(context2, "context");
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "appKey");
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "initResponse");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "sdkVersion");
        Intrinsics.checkNotNullParameter(str4, "testSuiteControllerUrl");
        yb ybVar = yb.a;
        String a = a(str5, str6, ybVar.c(context2), ybVar.a(context2), ybVar.b(context2), bool, jSONObject2, z, ybVar.b(), ybVar.c(), a());
        Intent intent = new Intent(context2, TestSuiteActivity.class);
        intent.setFlags(DriveFile.MODE_READ_WRITE);
        intent.putExtra(tb.a, a);
        intent.putExtra(tb.b, str4);
        context2.startActivity(intent);
    }
}
