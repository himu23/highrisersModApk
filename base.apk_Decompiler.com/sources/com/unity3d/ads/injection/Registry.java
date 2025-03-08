package com.unity3d.ads.injection;

import com.ironsource.d1;
import com.ironsource.m2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007J.\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\r\u0018\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\b\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0013H\bø\u0001\u0000J \u0010\u0014\u001a\u0002H\r\"\u0006\b\u0000\u0010\r\u0018\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\b¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\b¢\u0006\u0002\u0010\u0015J.\u0010\u0017\u001a\u00020\u0006\"\u0006\b\u0000\u0010\r\u0018\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\b\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0013H\bø\u0001\u0000R$\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"Lcom/unity3d/ads/injection/Registry;", "", "()V", "_services", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/unity3d/ads/injection/EntryKey;", "Lkotlin/Lazy;", "services", "getServices", "()Ljava/util/Map;", "add", "", "T", "key", "instance", "factory", "named", "", "Lkotlin/Function0;", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrNull", "single", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Registry.kt */
public final class Registry {
    private final MutableStateFlow<Map<EntryKey, Lazy<?>>> _services = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    public final Map<EntryKey, Lazy<?>> getServices() {
        return this._services.getValue();
    }

    public static /* synthetic */ EntryKey single$default(Registry registry, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, d1.o);
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        registry.add(entryKey, LazyKt.lazy(function0));
        return entryKey;
    }

    public final /* synthetic */ <T> EntryKey single(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, d1.o);
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        add(entryKey, LazyKt.lazy(function0));
        return entryKey;
    }

    public static /* synthetic */ EntryKey factory$default(Registry registry, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, d1.o);
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        registry.add(entryKey, new Factory(function0));
        return entryKey;
    }

    public final /* synthetic */ <T> EntryKey factory(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, d1.o);
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        add(entryKey, new Factory(function0));
        return entryKey;
    }

    public final <T> void add(EntryKey entryKey, Lazy<? extends T> lazy) {
        Map<EntryKey, Lazy<?>> value;
        Intrinsics.checkNotNullParameter(entryKey, m2.h.W);
        Intrinsics.checkNotNullParameter(lazy, d1.o);
        if (!getServices().containsKey(entryKey)) {
            MutableStateFlow<Map<EntryKey, Lazy<?>>> mutableStateFlow = this._services;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, (Map<EntryKey, Lazy<?>>) MapsKt.mapOf(TuplesKt.to(entryKey, lazy)))));
            return;
        }
        throw new IllegalStateException("Cannot have identical entries.".toString());
    }

    public static /* synthetic */ Object get$default(Registry registry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        Lazy lazy = registry.getServices().get(entryKey);
        if (lazy != null) {
            Object value = lazy.getValue();
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj2 = value;
            return value;
        }
        throw new IllegalStateException("No entry found for " + entryKey);
    }

    public final /* synthetic */ <T> T get(String str) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        EntryKey entryKey = new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        Lazy lazy = getServices().get(entryKey);
        if (lazy != null) {
            T value = lazy.getValue();
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj = (Object) value;
            return value;
        }
        throw new IllegalStateException("No entry found for " + entryKey);
    }

    public static /* synthetic */ Object getOrNull$default(Registry registry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        Lazy lazy = registry.getServices().get(new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
        if (lazy == null) {
            return null;
        }
        Object value = lazy.getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        Object obj2 = value;
        return value;
    }

    public final /* synthetic */ <T> T getOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        Lazy lazy = getServices().get(new EntryKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
        if (lazy == null) {
            return null;
        }
        T value = lazy.getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        Object obj = (Object) value;
        return value;
    }
}
