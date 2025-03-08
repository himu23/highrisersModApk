package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\b\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0010"}, d2 = {"Lcom/ironsource/rb;", "", "", "eventId", "errorCode", "", "errorReason", "", "a", "(ILjava/lang/Integer;Ljava/lang/String;)V", "Lorg/json/JSONArray;", "b", "c", "d", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class rb {
    public static final rb a = new rb();

    private rb() {
    }

    private final JSONArray a() {
        ConcurrentHashMap<String, List<String>> d = yb.a.d();
        if (d.containsKey(y8.g)) {
            return new JSONArray(d.get(y8.g));
        }
        return null;
    }

    private final void a(int i, Integer num, String str) {
        yb ybVar = yb.a;
        JSONObject a2 = ybVar.a(false);
        if (num != null) {
            a2.put("errorCode", num.intValue());
            JSONArray a3 = a();
            if (a3 != null) {
                a2.put(y8.g, a3);
            }
        }
        if (str != null) {
            a2.put("reason", str);
        }
        ybVar.a(i, a2);
    }

    static /* synthetic */ void a(rb rbVar, int i, Integer num, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        rbVar.a(i, num, str);
    }

    public final void a(int i) {
        a(72, Integer.valueOf(i), (String) null);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "errorReason");
        a(74, Integer.valueOf(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED), str);
    }

    public final void b() {
        a(this, 70, (Integer) null, (String) null, 6, (Object) null);
    }

    public final void c() {
        a(this, 71, (Integer) null, (String) null, 6, (Object) null);
    }

    public final void d() {
        a(this, 73, (Integer) null, (String) null, 6, (Object) null);
    }
}
