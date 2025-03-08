package com.unity3d.ads.core.data.repository;

import com.unity3d.services.core.log.DeviceLog;
import gateway.v1.DiagnosticEventRequestOuterClass;
import gateway.v1.NativeConfigurationOuterClass;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidDiagnosticEventRepository;", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "()V", "_diagnosticEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "allowedEvents", "", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventType;", "batch", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "blockedEvents", "configured", "", "diagnosticEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getDiagnosticEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "enabled", "flushTimer", "Ljava/util/Timer;", "maxBatchSize", "", "addDiagnosticEvent", "", "diagnosticEvent", "clear", "configure", "diagnosticsEventsConfiguration", "Lgateway/v1/NativeConfigurationOuterClass$DiagnosticEventsConfiguration;", "flush", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDiagnosticEventRepository.kt */
public final class AndroidDiagnosticEventRepository implements DiagnosticEventRepository {
    private final MutableSharedFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> _diagnosticEvents;
    /* access modifiers changed from: private */
    public final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEvents = new LinkedHashSet();
    private final MutableStateFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> batch = StateFlowKt.MutableStateFlow(new ArrayList());
    /* access modifiers changed from: private */
    public final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEvents = new LinkedHashSet();
    private final MutableStateFlow<Boolean> configured = StateFlowKt.MutableStateFlow(false);
    private final SharedFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> diagnosticEvents;
    private final MutableStateFlow<Boolean> enabled = StateFlowKt.MutableStateFlow(false);
    private final Timer flushTimer = new Timer();
    private int maxBatchSize = Integer.MAX_VALUE;

    public SharedFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> getDiagnosticEvents() {
        return this.diagnosticEvents;
    }

    public AndroidDiagnosticEventRepository() {
        MutableSharedFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(10, 10, BufferOverflow.DROP_OLDEST);
        this._diagnosticEvents = MutableSharedFlow;
        this.diagnosticEvents = FlowKt.asSharedFlow(MutableSharedFlow);
    }

    public void addDiagnosticEvent(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        Intrinsics.checkNotNullParameter(diagnosticEvent, "diagnosticEvent");
        if (!this.configured.getValue().booleanValue()) {
            this.batch.getValue().add(diagnosticEvent);
        } else if (this.enabled.getValue().booleanValue()) {
            this.batch.getValue().add(diagnosticEvent);
            if (this.batch.getValue().size() >= this.maxBatchSize) {
                flush();
            }
        }
    }

    public void flush() {
        List value = this.batch.getValue();
        DeviceLog.debug("Unity Ads Sending diagnostic batch enabled: " + this.enabled.getValue().booleanValue() + " size: " + value.size() + " :: " + value);
        SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(value), new AndroidDiagnosticEventRepository$flush$1(this)), new AndroidDiagnosticEventRepository$flush$2(this)));
        clear();
        if (!value.isEmpty()) {
            this._diagnosticEvents.tryEmit(value);
        }
    }

    public void configure(NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticEventsConfiguration) {
        Intrinsics.checkNotNullParameter(diagnosticEventsConfiguration, "diagnosticsEventsConfiguration");
        this.enabled.setValue(Boolean.valueOf(diagnosticEventsConfiguration.getEnabled()));
        if (!this.enabled.getValue().booleanValue()) {
            clear();
            return;
        }
        this.maxBatchSize = diagnosticEventsConfiguration.getMaxBatchSize();
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set = this.allowedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEventsList = diagnosticEventsConfiguration.getAllowedEventsList();
        Intrinsics.checkNotNullExpressionValue(allowedEventsList, "diagnosticsEventsConfiguration.allowedEventsList");
        set.addAll(allowedEventsList);
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set2 = this.blockedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEventsList = diagnosticEventsConfiguration.getBlockedEventsList();
        Intrinsics.checkNotNullExpressionValue(blockedEventsList, "diagnosticsEventsConfiguration.blockedEventsList");
        set2.addAll(blockedEventsList);
        long maxBatchIntervalMs = (long) diagnosticEventsConfiguration.getMaxBatchIntervalMs();
        this.flushTimer.scheduleAtFixedRate(new AndroidDiagnosticEventRepository$configure$$inlined$timerTask$1(this), maxBatchIntervalMs, maxBatchIntervalMs);
        flush();
        this.configured.setValue(true);
    }

    public void clear() {
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> value;
        MutableStateFlow<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> mutableStateFlow = this.batch;
        do {
            value = mutableStateFlow.getValue();
            List list = value;
        } while (!mutableStateFlow.compareAndSet(value, new ArrayList()));
    }
}
