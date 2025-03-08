package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.d1;
import com.ironsource.mediationsdk.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0003J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/a;", "", "", "a", "", "isEmpty", "instanceName", "Lcom/ironsource/d1;", "", "index", "get", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface a {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/a$a;", "Lcom/ironsource/mediationsdk/demandOnly/a;", "", "a", "", "isEmpty", "instanceName", "Lcom/ironsource/d1;", "", "index", "get", "", "Ljava/util/List;", "waterfall", "<init>", "(Ljava/util/List;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    /* renamed from: com.ironsource.mediationsdk.demandOnly.a$a  reason: collision with other inner class name */
    public static final class C0015a implements a {
        private final List<d1> a;

        public C0015a() {
            this((List) null, 1, (DefaultConstructorMarker) null);
        }

        public C0015a(List<d1> list) {
            Intrinsics.checkNotNullParameter(list, d.g);
            this.a = list;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0015a(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : list);
        }

        public d1 a(String str) {
            T t;
            Intrinsics.checkNotNullParameter(str, "instanceName");
            Iterator<T> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual((Object) ((d1) t).c(), (Object) str)) {
                    break;
                }
            }
            return (d1) t;
        }

        public String a() {
            if (this.a.isEmpty()) {
                return "";
            }
            return "1" + ((d1) CollectionsKt.first(this.a)).c();
        }

        public d1 get(int i) {
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }
    }

    d1 a(String str);

    String a();

    d1 get(int i);

    boolean isEmpty();
}
