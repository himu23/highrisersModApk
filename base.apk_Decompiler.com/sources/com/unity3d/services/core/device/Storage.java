package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/unity3d/services/core/device/Storage;", "Lcom/unity3d/services/core/misc/JsonStorage;", "_targetFileName", "", "type", "Lcom/unity3d/services/core/device/StorageManager$StorageType;", "(Ljava/lang/String;Lcom/unity3d/services/core/device/StorageManager$StorageType;)V", "getType", "()Lcom/unity3d/services/core/device/StorageManager$StorageType;", "clearStorage", "", "initStorage", "readStorage", "sendEvent", "", "eventType", "Lcom/unity3d/services/core/device/StorageEvent;", "value", "", "storageFileExists", "writeStorage", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Storage.kt */
public final class Storage extends JsonStorage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MutableStateFlow<List<Function1<StorageEventInfo, Unit>>> onStorageEventCallbacks = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final String _targetFileName;
    private final StorageManager.StorageType type;

    public final StorageManager.StorageType getType() {
        return this.type;
    }

    public Storage(String str, StorageManager.StorageType storageType) {
        Intrinsics.checkNotNullParameter(str, "_targetFileName");
        Intrinsics.checkNotNullParameter(storageType, "type");
        this._targetFileName = str;
        this.type = storageType;
    }

    public final synchronized boolean readStorage() {
        boolean z;
        z = true;
        try {
            byte[] readFileBytes = Utilities.readFileBytes(new File(this._targetFileName));
            if (readFileBytes == null) {
                return false;
            }
            setData(new JSONObject(new String(readFileBytes, Charsets.UTF_8)));
        } catch (FileNotFoundException e) {
            DeviceLog.debug("Storage JSON file not found in local cache:", e);
        } catch (Exception e2) {
            DeviceLog.debug("Failed to read storage JSON file:", e2);
        }
        z = false;
        return z;
    }

    public final synchronized boolean initStorage() {
        readStorage();
        super.initData();
        return true;
    }

    public final synchronized boolean writeStorage() {
        File file = new File(this._targetFileName);
        if (getData() == null) {
            return false;
        }
        return Utilities.writeFile(file, getData().toString());
    }

    public final synchronized boolean clearStorage() {
        clearData();
        return new File(this._targetFileName).delete();
    }

    public final synchronized boolean storageFileExists() {
        return new File(this._targetFileName).exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (com.unity3d.services.core.webview.WebViewApp.getCurrentApp().sendEvent(com.unity3d.services.core.webview.WebViewEventCategory.STORAGE, r7, r6.type.name(), r8) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void sendEvent(com.unity3d.services.core.device.StorageEvent r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            kotlinx.coroutines.flow.MutableStateFlow<java.util.List<kotlin.jvm.functions.Function1<com.unity3d.services.core.device.StorageEventInfo, kotlin.Unit>>> r0 = onStorageEventCallbacks     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0061 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0061 }
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0061 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0061 }
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0036
            com.unity3d.services.core.device.StorageEventInfo r1 = new com.unity3d.services.core.device.StorageEventInfo     // Catch:{ all -> 0x0061 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0061 }
            com.unity3d.services.core.device.StorageManager$StorageType r2 = r6.type     // Catch:{ all -> 0x0061 }
            r1.<init>(r7, r2, r8)     // Catch:{ all -> 0x0061 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0061 }
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x0061 }
        L_0x0024:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0061 }
            if (r8 == 0) goto L_0x0034
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0061 }
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch:{ all -> 0x0061 }
            r8.invoke(r1)     // Catch:{ all -> 0x0061 }
            goto L_0x0024
        L_0x0034:
            monitor-exit(r6)
            return
        L_0x0036:
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x005a
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0061 }
            com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.STORAGE     // Catch:{ all -> 0x0061 }
            java.lang.Enum r1 = (java.lang.Enum) r1     // Catch:{ all -> 0x0061 }
            java.lang.Enum r7 = (java.lang.Enum) r7     // Catch:{ all -> 0x0061 }
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0061 }
            com.unity3d.services.core.device.StorageManager$StorageType r4 = r6.type     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.name()     // Catch:{ all -> 0x0061 }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x0061 }
            r3[r2] = r8     // Catch:{ all -> 0x0061 }
            boolean r7 = r0.sendEvent(r1, r7, r3)     // Catch:{ all -> 0x0061 }
            if (r7 != 0) goto L_0x005f
        L_0x005a:
            java.lang.String r7 = "Couldn't send storage event to WebApp"
            com.unity3d.services.core.log.DeviceLog.debug(r7)     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r6)
            return
        L_0x0061:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Storage.sendEvent(com.unity3d.services.core.device.StorageEvent, java.lang.Object):void");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u000b\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/unity3d/services/core/device/Storage$Companion;", "", "()V", "onStorageEventCallbacks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlin/Function1;", "Lcom/unity3d/services/core/device/StorageEventInfo;", "", "addStorageEventCallback", "callback", "removeStorageEventCallback", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Storage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void addStorageEventCallback(Function1<? super StorageEventInfo, Unit> function1) {
            Object value;
            Intrinsics.checkNotNullParameter(function1, "callback");
            MutableStateFlow access$getOnStorageEventCallbacks$cp = Storage.onStorageEventCallbacks;
            do {
                value = access$getOnStorageEventCallbacks$cp.getValue();
            } while (!access$getOnStorageEventCallbacks$cp.compareAndSet(value, CollectionsKt.plus((List) value, function1)));
        }

        public final void removeStorageEventCallback(Function1<? super StorageEventInfo, Unit> function1) {
            Object value;
            Intrinsics.checkNotNullParameter(function1, "callback");
            MutableStateFlow access$getOnStorageEventCallbacks$cp = Storage.onStorageEventCallbacks;
            do {
                value = access$getOnStorageEventCallbacks$cp.getValue();
            } while (!access$getOnStorageEventCallbacks$cp.compareAndSet(value, CollectionsKt.minus((List) value, function1)));
        }
    }
}
