package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.v8;
import com.ironsource.w3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J)\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/o;", "Lcom/ironsource/w3;", "", "T", "Lcom/ironsource/v8;", "mapper", "a", "(Lcom/ironsource/v8;)Ljava/lang/Object;", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface o extends w3<String> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/o$a;", "Lcom/ironsource/mediationsdk/demandOnly/o;", "T", "Lcom/ironsource/v8;", "", "mapper", "a", "(Lcom/ironsource/v8;)Ljava/lang/Object;", "b", "Ljava/lang/String;", "rowAdm", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements o {
        private final String a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "rowAdm");
            this.a = str;
        }

        public <T> T a(v8<String, T> v8Var) {
            Intrinsics.checkNotNullParameter(v8Var, "mapper");
            return v8Var.a(this.a);
        }

        /* renamed from: b */
        public String a() {
            return this.a;
        }
    }

    <T> T a(v8<String, T> v8Var);
}
