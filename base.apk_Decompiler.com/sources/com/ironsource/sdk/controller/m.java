package com.ironsource.sdk.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0003J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/ironsource/sdk/controller/m;", "", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface m {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/ironsource/sdk/controller/m$a;", "Lcom/ironsource/sdk/controller/m;", "", "a", "Ljava/lang/String;", "funToCall", "b", "parameters", "c", "onSuccessCallback", "d", "onFailCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements m {
        private final String a;
        private final String b;
        private final String c;
        private final String d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str) {
            this(str, (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "funToCall");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            this(str, str2, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "funToCall");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3) {
            this(str, str2, str3, (String) null, 8, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "funToCall");
        }

        public a(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "funToCall");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }

        public String a() {
            String str = "SSA_CORE.SDKController.runFunction('" + this.a;
            String str2 = this.b;
            if (str2 != null && str2.length() > 0) {
                str = str + "?parameters=" + this.b;
            }
            String str3 = this.c;
            if (str3 != null && str3.length() > 0) {
                str = str + "','" + this.c;
            }
            String str4 = this.d;
            if (str4 != null && str4.length() > 0) {
                str = str + "','" + this.d;
            }
            return str + "');";
        }
    }

    String a();
}
