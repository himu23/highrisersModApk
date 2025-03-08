package com.unity3d.services.core.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.datasource.AnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.MediationDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.AndroidDeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidLegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase;
import com.unity3d.ads.core.domain.AndroidHandleOpenUrl;
import com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAdRequest;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.ads.core.domain.GetClientInfo;
import com.unity3d.ads.core.domain.GetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetInitializationRequest;
import com.unity3d.ads.core.domain.GetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import com.unity3d.ads.core.domain.HandleGatewayAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.Load;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.Show;
import com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializeListener;
import com.unity3d.ads.core.domain.events.DiagnosticEventObserver;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.events.GetOperativeEventRequest;
import com.unity3d.ads.core.domain.events.HandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.OperativeEventObserver;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.INativeTokenGenerator;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.lifecycle.LifecycleCache;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import defpackage.ByteStringStoreOuterClass;
import defpackage.UniversalRequestStoreOuterClass;
import gateway.v1.NativeConfigurationOuterClass;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/unity3d/services/core/di/ServicesRegistry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$initialize$1 extends Lambda implements Function1<ServicesRegistry, Unit> {
    public static final ServiceProvider$initialize$1 INSTANCE = new ServiceProvider$initialize$1();

    ServiceProvider$initialize$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ServicesRegistry) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final ServicesRegistry servicesRegistry) {
        Intrinsics.checkNotNullParameter(servicesRegistry, "$this$registry");
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class)), LazyKt.lazy(AnonymousClass1.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class)), LazyKt.lazy(AnonymousClass2.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class)), LazyKt.lazy(AnonymousClass3.INSTANCE));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class)), LazyKt.lazy(new Function0<CoroutineExceptionHandler>() {
            public final CoroutineExceptionHandler invoke() {
                return ServiceProvider.INSTANCE.provideSDKErrorHandler((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (AlternativeFlowReader) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), LazyKt.lazy(new Function0<CoroutineScope>() {
            public final CoroutineScope invoke() {
                return ServiceProvider.INSTANCE.provideSDKScope((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class)), LazyKt.lazy(new Function0<HttpClient>() {
            public final HttpClient invoke() {
                return ServiceProvider.INSTANCE.provideHttpClient((ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (AlternativeFlowReader) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("unityads-installinfo", Reflection.getOrCreateKotlinClass(DataMigration.class)), LazyKt.lazy(new Function0<DataMigration<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideIdfiDataMigration((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("supersonic_shared_preferen", Reflection.getOrCreateKotlinClass(DataMigration.class)), LazyKt.lazy(new Function0<DataMigration<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideAuidDataMigration((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.PREF_DEFAULT, Reflection.getOrCreateKotlinClass(DataMigration.class)), LazyKt.lazy(AnonymousClass9.INSTANCE));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.PREF_GL_INFO, Reflection.getOrCreateKotlinClass(DataMigration.class)), LazyKt.lazy(new Function0<DataMigration<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideFetchGLInfoDataMigration((GetOpenGLRendererInfo) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideGatewayCacheDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideUserConsentDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.providePrivacyFsmDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IDFI, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideIdfiDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (DataMigration) servicesRegistry.resolveService(new ServiceKey("unityads-installinfo", Reflection.getOrCreateKotlinClass(DataMigration.class))), (DataMigration) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.PREF_DEFAULT, Reflection.getOrCreateKotlinClass(DataMigration.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_AUID, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideAuidDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (DataMigration) servicesRegistry.resolveService(new ServiceKey("supersonic_shared_preferen", Reflection.getOrCreateKotlinClass(DataMigration.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() {
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return ServiceProvider.INSTANCE.provideGlInfoDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (DataMigration) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.PREF_GL_INFO, Reflection.getOrCreateKotlinClass(DataMigration.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore>>() {
            public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> invoke() {
                return ServiceProvider.INSTANCE.provideUniversalRequestDataStore((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new Function0<InitializeStateNetworkError>() {
            public final InitializeStateNetworkError invoke() {
                return new InitializeStateNetworkError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class)), LazyKt.lazy(new Function0<ConfigFileFromLocalStorage>() {
            public final ConfigFileFromLocalStorage invoke() {
                return new ConfigFileFromLocalStorage((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class)), LazyKt.lazy(new Function0<InitializeStateReset>() {
            public final InitializeStateReset invoke() {
                return new InitializeStateReset((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class)), LazyKt.lazy(new Function0<InitializeStateError>() {
            public final InitializeStateError invoke() {
                return new InitializeStateError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class)), LazyKt.lazy(new Function0<InitializeStateConfigWithLoader>() {
            public final InitializeStateConfigWithLoader invoke() {
                return new InitializeStateConfigWithLoader((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class)), LazyKt.lazy(new Function0<InitializeStateConfig>() {
            public final InitializeStateConfig invoke() {
                return new InitializeStateConfig((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class)), LazyKt.lazy(new Function0<InitializeStateCreate>() {
            public final InitializeStateCreate invoke() {
                return new InitializeStateCreate((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class)), LazyKt.lazy(new Function0<InitializeStateLoadCache>() {
            public final InitializeStateLoadCache invoke() {
                return new InitializeStateLoadCache((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class)), LazyKt.lazy(new Function0<InitializeStateCreateWithRemote>() {
            public final InitializeStateCreateWithRemote invoke() {
                return new InitializeStateCreateWithRemote((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class)), LazyKt.lazy(new Function0<InitializeStateLoadWeb>() {
            public final InitializeStateLoadWeb invoke() {
                return new InitializeStateLoadWeb((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (HttpClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class)), LazyKt.lazy(new Function0<InitializeStateComplete>() {
            public final InitializeStateComplete invoke() {
                return new InitializeStateComplete((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeSDK.class)), LazyKt.lazy(new Function0<InitializeSDK>() {
            public final InitializeSDK invoke() {
                return new InitializeSDK((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (InitializeStateReset) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class))), (InitializeStateError) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class))), (InitializeStateConfig) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class))), (InitializeStateCreate) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class))), (InitializeStateLoadCache) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class))), (InitializeStateCreateWithRemote) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class))), (InitializeStateLoadWeb) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class))), (InitializeStateComplete) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class)), LazyKt.lazy(AnonymousClass30.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class)), LazyKt.lazy(new Function0<AsyncTokenStorage>() {
            public final AsyncTokenStorage invoke() {
                return new InMemoryAsyncTokenStorage((INativeTokenGenerator) null, new Handler(Looper.getMainLooper()), SDKMetrics.getInstance(), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class)), LazyKt.lazy(AnonymousClass32.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChangeMonitor.class)), LazyKt.lazy(new Function0<VolumeChangeMonitor>() {
            public final VolumeChangeMonitor invoke() {
                return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), (VolumeChange) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(StorageManager.StorageType.PUBLIC.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class)), LazyKt.lazy(AnonymousClass34.INSTANCE));
        servicesRegistry.updateService(new ServiceKey(StorageManager.StorageType.PRIVATE.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class)), LazyKt.lazy(AnonymousClass35.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GameServerIdReader.class)), LazyKt.lazy(new Function0<GameServerIdReader>() {
            public final GameServerIdReader invoke() {
                return new GameServerIdReader((JsonStorage) servicesRegistry.resolveService(new ServiceKey(StorageManager.StorageType.PUBLIC.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class)), LazyKt.lazy(new Function0<AlternativeFlowReader>() {
            public final AlternativeFlowReader invoke() {
                return new AlternativeFlowReader((JsonStorage) servicesRegistry.resolveService(new ServiceKey(StorageManager.StorageType.PUBLIC.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() {
            public final GetRequestPolicy invoke() {
                return ServiceProvider.INSTANCE.provideInitRequestPolicy((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_OPERATIVE_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() {
            public final GetRequestPolicy invoke() {
                return ServiceProvider.INSTANCE.provideOperativeEventRequestPolicy((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() {
            public final GetRequestPolicy invoke() {
                return ServiceProvider.INSTANCE.provideOtherRequestPolicy((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() {
            public final GetRequestPolicy invoke() {
                return ServiceProvider.INSTANCE.provideAdRequestPolicy((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass.NativeConfiguration.class)), LazyKt.lazy(AnonymousClass42.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class)), LazyKt.lazy(new Function0<BackgroundWorker>() {
            public final BackgroundWorker invoke() {
                return new BackgroundWorker((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleCache.class)), LazyKt.lazy(AnonymousClass44.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<StaticDeviceInfoDataSource>() {
            public final StaticDeviceInfoDataSource invoke() {
                return ServiceProvider.INSTANCE.provideStaticDeviceInfoDataSource((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IDFI, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_AUID, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (AnalyticsDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class)), LazyKt.lazy(AnonymousClass46.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<DynamicDeviceInfoDataSource>() {
            public final DynamicDeviceInfoDataSource invoke() {
                return ServiceProvider.INSTANCE.provideDynamicDeviceInfoDataSource((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (LifecycleCache) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleCache.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<PrivacyDeviceInfoDataSource>() {
            public final PrivacyDeviceInfoDataSource invoke() {
                return ServiceProvider.INSTANCE.providePrivacyDeviceInfoDataSource((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationDataSource.class)), LazyKt.lazy(new Function0<MediationDataSource>() {
            public final MediationDataSource invoke() {
                return ServiceProvider.INSTANCE.provideMediationDataSource((JsonStorage) servicesRegistry.resolveService(new ServiceKey(StorageManager.StorageType.PUBLIC.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class)), LazyKt.lazy(new Function0<GatewayClient>() {
            public final GatewayClient invoke() {
                return ServiceProvider.INSTANCE.provideGatewayClient((HttpClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))), (HandleGatewayUniversalResponse) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class)), ServiceFactoryKt.factoryOf(AnonymousClass51.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class)), LazyKt.lazy(new Function0<SessionRepository>() {
            public final SessionRepository invoke() {
                return ServiceProvider.INSTANCE.provideSessionRepository((ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (NativeConfigurationOuterClass.NativeConfiguration) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass.NativeConfiguration.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IDFI, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IDFI, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_AUID, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_AUID, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() {
            public final ByteStringDataSource invoke() {
                return ServiceProvider.INSTANCE.provideByteStringDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class)), LazyKt.lazy(new Function0<UniversalRequestDataSource>() {
            public final UniversalRequestDataSource invoke() {
                return ServiceProvider.INSTANCE.provideUniversalRequestDataSource((DataStore) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, Reflection.getOrCreateKotlinClass(DataStore.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)), LazyKt.lazy(new Function0<DeviceInfoRepository>() {
            public final DeviceInfoRepository invoke() {
                return ServiceProvider.INSTANCE.provideDeviceInfoRepository((StaticDeviceInfoDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class))), (DynamicDeviceInfoDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class))), (PrivacyDeviceInfoDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationRepository.class)), LazyKt.lazy(new Function0<MediationRepository>() {
            public final MediationRepository invoke() {
                return ServiceProvider.INSTANCE.provideMediationRepository((MediationDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationDataSource.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleAndroidInvocationsUseCase.class)), LazyKt.lazy(new Function0<HandleAndroidInvocationsUseCase>() {
            public final HandleAndroidInvocationsUseCase invoke() {
                return ServiceProvider.INSTANCE.provideGetAndroidExposureUseCase((GetAndroidAdPlayerContext) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAndroidAdPlayerContext.class))), (GetOperativeEventApi) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class))), (Refresh) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Refresh.class))), (HandleOpenUrl) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleOpenUrl.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (CampaignStateRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class))), (SendPrivacyUpdateRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetClientInfo.class)), LazyKt.lazy(new Function0<GetClientInfo>() {
            public final GetClientInfo invoke() {
                return ServiceProvider.INSTANCE.provideGetClientInfo((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (MediationRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class)), LazyKt.lazy(new Function0<HandleGatewayUniversalResponse>() {
            public final HandleGatewayUniversalResponse invoke() {
                return ServiceProvider.INSTANCE.provideHandleGatewayUniversalResponse((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class)), LazyKt.lazy(new Function0<TriggerInitializeListener>() {
            public final TriggerInitializeListener invoke() {
                return ServiceProvider.INSTANCE.provideTriggerInitializeListener((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class)), LazyKt.lazy(new Function0<InitializeBoldSDK>() {
            public final InitializeBoldSDK invoke() {
                DeviceInfoRepository deviceInfoRepository = (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
                return ServiceProvider.INSTANCE.provideInitializeBoldSDK((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (GetInitializationRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequest.class))), (GetRequestPolicy) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (HandleGatewayInitializationResponse) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class))), (GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (EventObservers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(EventObservers.class))), (TriggerInitializeListener) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (DiagnosticEventRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), deviceInfoRepository, (com.unity3d.ads.core.data.manager.StorageManager) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(com.unity3d.ads.core.data.manager.StorageManager.class))), (SDKPropertiesManager) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequest.class)), LazyKt.lazy(new Function0<GetInitializationRequest>() {
            public final GetInitializationRequest invoke() {
                return ServiceProvider.INSTANCE.provideGetInitializationRequest((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (GetClientInfo) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetClientInfo.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (LegacyUserConsentRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class)), LazyKt.lazy(new Function0<HandleGatewayInitializationResponse>() {
            public final HandleGatewayInitializationResponse invoke() {
                return ServiceProvider.INSTANCE.provideHandleGatewayInitializationResponse((TriggerInitializationCompletedRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CoroutineScope) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.getOrCreateKotlinClass(CoroutineScope.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class)), LazyKt.lazy(new Function0<GetUniversalRequestForPayLoad>() {
            public final GetUniversalRequestForPayLoad invoke() {
                return ServiceProvider.INSTANCE.provideGetUniversalRequestForPayLoad((GetUniversalRequestSharedData) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class)), LazyKt.lazy(new Function0<GetUniversalRequestSharedData>() {
            public final GetUniversalRequestSharedData invoke() {
                return ServiceProvider.INSTANCE.provideGetUniversalRequestSharedData((GetSharedDataTimestamps) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (DeveloperConsentRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class)), LazyKt.lazy(AnonymousClass71.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Load.class)), ServiceFactoryKt.factoryOf(new Function0<Load>() {
            public final Load invoke() {
                return ServiceProvider.INSTANCE.provideLoad((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (GetAdRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdRequest.class))), (GetRequestPolicy) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (HandleGatewayAdResponse) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (AdRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Refresh.class)), LazyKt.lazy(new Function0<Refresh>() {
            public final Refresh invoke() {
                return ServiceProvider.INSTANCE.provideRefresh((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (GetAdDataRefreshRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class))), (GetRequestPolicy) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class)), ServiceFactoryKt.factoryOf(new Function0<LegacyLoadUseCase>() {
            public final LegacyLoadUseCase invoke() {
                return ServiceProvider.INSTANCE.provideLegacyLoadUseCase((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (Load) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Load.class))), (AdRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdRequest.class)), LazyKt.lazy(new Function0<GetAdRequest>() {
            public final GetAdRequest invoke() {
                return ServiceProvider.INSTANCE.provideGetAdRequest((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (CampaignStateRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class)), LazyKt.lazy(new Function0<GetAdDataRefreshRequest>() {
            public final GetAdDataRefreshRequest invoke() {
                return ServiceProvider.INSTANCE.provideGetAdDataRefreshRequest((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (CampaignStateRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class)), ServiceFactoryKt.factoryOf(new Function0<HandleGatewayAdResponse>() {
            public final HandleGatewayAdResponse invoke() {
                return ServiceProvider.INSTANCE.provideHandleGatewayAdResponse((AdRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (AndroidGetWebViewContainerUseCase) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class))), (GetWebViewBridgeUseCase) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (HandleAndroidInvocationsUseCase) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleAndroidInvocationsUseCase.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CampaignStateRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class))), (ExecuteAdViewerRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetOperativeEventApi) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class)), LazyKt.lazy(AnonymousClass78.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class)), LazyKt.lazy(new Function0<CampaignStateRepository>() {
            public final CampaignStateRepository invoke() {
                return ServiceProvider.INSTANCE.provideCampaignStateRepository((GetSharedDataTimestamps) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class)), LazyKt.lazy(new Function0<GetOperativeEventApi>() {
            public final GetOperativeEventApi invoke() {
                return new GetOperativeEventApi((OperativeEventRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class))), (GetOperativeEventRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class)), LazyKt.lazy(new Function0<GetOperativeEventRequest>() {
            public final GetOperativeEventRequest invoke() {
                return new GetOperativeEventRequest((DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CampaignStateRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignStateRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class)), LazyKt.lazy(AnonymousClass82.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class)), LazyKt.lazy(AnonymousClass83.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventObserver.class)), LazyKt.lazy(new Function0<OperativeEventObserver>() {
            public final OperativeEventObserver invoke() {
                return ServiceProvider.INSTANCE.provideOperativeEventObserver((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (OperativeEventRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class))), (UniversalRequestDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class))), (BackgroundWorker) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class)), LazyKt.lazy(new Function0<GetDiagnosticEventRequest>() {
            public final GetDiagnosticEventRequest invoke() {
                return new GetDiagnosticEventRequest((GetSharedDataTimestamps) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class)), LazyKt.lazy(AnonymousClass86.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class)), LazyKt.lazy(new Function0<SendDiagnosticEvent>() {
            public final SendDiagnosticEvent invoke() {
                return new AndroidSendDiagnosticEvent((DiagnosticEventRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), (GetDiagnosticEventRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class)), LazyKt.lazy(AnonymousClass88.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class)), LazyKt.lazy(new Function0<DiagnosticEventObserver>() {
            public final DiagnosticEventObserver invoke() {
                return ServiceProvider.INSTANCE.provideDiagnosticEventObserver((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (GetDiagnosticEventBatchRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class))), (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (DiagnosticEventRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), (UniversalRequestDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class))), (BackgroundWorker) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(EventObservers.class)), LazyKt.lazy(new Function0<EventObservers>() {
            public final EventObservers invoke() {
                return new EventObservers((OperativeEventObserver) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventObserver.class))), (DiagnosticEventObserver) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestEventSender.class)), LazyKt.lazy(new Function0<UniversalRequestEventSender>() {
            public final UniversalRequestEventSender invoke() {
                return new UniversalRequestEventSender((GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (HandleGatewayEventResponse) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Show.class)), LazyKt.lazy(new Function0<Show>() {
            public final Show invoke() {
                return ServiceProvider.INSTANCE.provideShow((AdRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (GameServerIdReader) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GameServerIdReader.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class)), LazyKt.lazy(new Function0<LegacyShowUseCase>() {
            public final LegacyShowUseCase invoke() {
                return ServiceProvider.INSTANCE.provideLegacyShowUseCase((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (Show) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Show.class))), (AdRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetOperativeEventApi) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class)), ServiceFactoryKt.factoryOf(new Function0<AndroidGetWebViewContainerUseCase>() {
            public final AndroidGetWebViewContainerUseCase invoke() {
                return ServiceProvider.INSTANCE.provideGetWebViewContainerUseCase((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (AndroidWebViewClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class))), (SendWebViewClientErrorDiagnostics) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class)), LazyKt.lazy(new Function0<SendWebViewClientErrorDiagnostics>() {
            public final SendWebViewClientErrorDiagnostics invoke() {
                return ServiceProvider.INSTANCE.provideSendWebViewClientErrorDiagnostics((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (SendDiagnosticEvent) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class)), LazyKt.lazy(new Function0<GetWebViewBridgeUseCase>() {
            public final GetWebViewBridgeUseCase invoke() {
                return ServiceProvider.INSTANCE.provideGetWebViewBridgeUseCase((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAndroidAdPlayerContext.class)), LazyKt.lazy(new Function0<GetAndroidAdPlayerContext>() {
            public final GetAndroidAdPlayerContext invoke() {
                return new GetAndroidAdPlayerContext((DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class)), LazyKt.lazy(new Function0<GetInitializationCompletedRequest>() {
            public final GetInitializationCompletedRequest invoke() {
                return ServiceProvider.INSTANCE.provideGetInitializationCompletedRequest((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (DeviceInfoRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class)), LazyKt.lazy(new Function0<TriggerInitializationCompletedRequest>() {
            public final TriggerInitializationCompletedRequest invoke() {
                return ServiceProvider.INSTANCE.provideTriggerInitializationCompletedRequest((GetInitializationCompletedRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class))), (GetRequestPolicy) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleOpenUrl.class)), LazyKt.lazy(new Function0<HandleOpenUrl>() {
            public final HandleOpenUrl invoke() {
                return new AndroidHandleOpenUrl((Context) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class)), LazyKt.lazy(new Function0<GetOpenGLRendererInfo>() {
            public final GetOpenGLRendererInfo invoke() {
                return ServiceProvider.INSTANCE.provideGetOpenGLRendererInfo((SessionRepository) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class)), LazyKt.lazy(new Function0<ExecuteAdViewerRequest>() {
            public final ExecuteAdViewerRequest invoke() {
                return ServiceProvider.INSTANCE.provideExecuteAdViewerRequest((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (HttpClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class)), LazyKt.lazy(new Function0<GetPrivacyUpdateRequest>() {
            public final GetPrivacyUpdateRequest invoke() {
                return new GetPrivacyUpdateRequest((GetUniversalRequestForPayLoad) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class)), LazyKt.lazy(new Function0<SendPrivacyUpdateRequest>() {
            public final SendPrivacyUpdateRequest invoke() {
                return new SendPrivacyUpdateRequest((GetPrivacyUpdateRequest) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class))), (GetRequestPolicy) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class)), LazyKt.lazy(AnonymousClass105.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class)), LazyKt.lazy(new Function0<LegacyUserConsentDataSource>() {
            public final LegacyUserConsentDataSource invoke() {
                return new AndroidLegacyUserConsentDataSource((FlattenerRulesUseCase) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class))), (JsonStorage) servicesRegistry.resolveService(new ServiceKey(StorageManager.StorageType.PRIVATE.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class)), LazyKt.lazy(new Function0<LegacyUserConsentRepository>() {
            public final LegacyUserConsentRepository invoke() {
                return new AndroidLegacyUserConsentRepository((LegacyUserConsentDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class)), LazyKt.lazy(AnonymousClass108.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class)), LazyKt.lazy(new Function0<DeveloperConsentDataSource>() {
            public final DeveloperConsentDataSource invoke() {
                return new AndroidDeveloperConsentDataSource((FlattenerRulesUseCase) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class))), (JsonStorage) servicesRegistry.resolveService(new ServiceKey(StorageManager.StorageType.PUBLIC.name(), Reflection.getOrCreateKotlinClass(JsonStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class)), LazyKt.lazy(new Function0<DeveloperConsentRepository>() {
            public final DeveloperConsentRepository invoke() {
                return new AndroidDeveloperConsentRepository((DeveloperConsentDataSource) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(com.unity3d.ads.core.data.manager.StorageManager.class)), LazyKt.lazy(AnonymousClass111.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class)), LazyKt.lazy(AnonymousClass112.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MeasurementsService.class)), LazyKt.lazy(new Function0<MeasurementsService>() {
            public final MeasurementsService invoke() {
                Context applicationContext = ClientProperties.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                return new MeasurementsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TopicsService.class)), LazyKt.lazy(new Function0<TopicsService>() {
            public final TopicsService invoke() {
                Context applicationContext = ClientProperties.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                return new TopicsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
            }
        }));
    }
}
