package com.unity3d.services.core.di;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.android.gms.net.CronetProviderInstaller;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.datasource.AnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidMediationDataSource;
import com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.datasource.DefaultByteStringMigration;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.FetchGLInfoDataMigration;
import com.unity3d.ads.core.data.datasource.ForcefulPreservingByteStringPreferenceMigration;
import com.unity3d.ads.core.data.datasource.GetAuidData;
import com.unity3d.ads.core.data.datasource.GetIdfiData;
import com.unity3d.ads.core.data.datasource.MediationDataSource;
import com.unity3d.ads.core.data.datasource.PreservingByteStringPreferenceMigration;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.model.ByteStringSerializer;
import com.unity3d.ads.core.data.model.UniversalRequestStoreSerializer;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.AndroidAdRepository;
import com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository;
import com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository;
import com.unity3d.ads.core.data.repository.AndroidMediationRepository;
import com.unity3d.ads.core.data.repository.AndroidSessionRepository;
import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase;
import com.unity3d.ads.core.domain.AndroidLoad;
import com.unity3d.ads.core.domain.AndroidRefresh;
import com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.AndroidShow;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAdRequest;
import com.unity3d.ads.core.domain.GetAdRequestPolicy;
import com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.ads.core.domain.GetAndroidAdRequest;
import com.unity3d.ads.core.domain.GetAndroidClientInfo;
import com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetAndroidInitializationRequest;
import com.unity3d.ads.core.domain.GetAndroidOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetAndroidSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetClientInfo;
import com.unity3d.ads.core.domain.GetCommonWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.GetInitRequestPolicy;
import com.unity3d.ads.core.domain.GetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetInitializationRequest;
import com.unity3d.ads.core.domain.GetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetOperativeEventRequestPolicy;
import com.unity3d.ads.core.domain.GetOtherRequestPolicy;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.HandleAndroidGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import com.unity3d.ads.core.domain.HandleGatewayAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.Load;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.Show;
import com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializeListener;
import com.unity3d.ads.core.domain.events.DiagnosticEventObserver;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.events.OperativeEventObserver;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.lifecycle.LifecycleCache;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import defpackage.ByteStringStoreOuterClass;
import defpackage.UniversalRequestStoreOuterClass;
import gateway.v1.DiagnosticEventsConfigurationKt;
import gateway.v1.NativeConfigurationKt;
import gateway.v1.NativeConfigurationOuterClass;
import gateway.v1.RequestPolicyKt;
import gateway.v1.RequestRetryPolicyKt;
import gateway.v1.RequestTimeoutPolicyKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000¢\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000204H\u0002J\u0016\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u0010 \u001a\u00020!H\u0002J,\u00108\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u0016\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020709H\u0002J&\u0010>\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\b\u0010E\u001a\u00020FH\u0002J \u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0002J8\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010\"\u001a\u00020#2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0018\u0010[\u001a\u00020L2\u0006\u0010 \u001a\u00020!2\u0006\u0010\\\u001a\u00020]H\u0002J\u0018\u0010^\u001a\u00020_2\u0006\u0010\"\u001a\u00020#2\u0006\u0010`\u001a\u00020\u001fH\u0002J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u000207062\u0006\u0010b\u001a\u00020cH\u0002J\u001e\u0010d\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010e\u001a\u00020f2\u0006\u0010`\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0002J(\u0010k\u001a\u00020l2\u0006\u0010Q\u001a\u00020R2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020AH\u0002J(\u0010o\u001a\u00020p2\u0006\u0010Q\u001a\u00020R2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020AH\u0002JP\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020A2\u0006\u0010{\u001a\u00020|2\u0006\u0010i\u001a\u00020jH\u0002J\u0019\u0010}\u001a\u00020~2\u0006\u00101\u001a\u0002022\u0007\u0010\u001a\u00030\u0001H\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\u0006\u0010Q\u001a\u00020R2\u0006\u0010m\u001a\u00020HH\u0002J5\u0010\u0001\u001a\u00030\u00012\u0006\u0010Q\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020~2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020H2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020c2\u0006\u00101\u001a\u000202H\u0002J\t\u0010\u0001\u001a\u00020CH\u0002J\u0013\u0010\u0001\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u0001H\u0002J,\u0010\u0001\u001a\u00030\u00012\u0006\u0010B\u001a\u00020C2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020H2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010\"\u001a\u00020#H\u0002J%\u0010\u0001\u001a\u00030\u00012\u0006\u0010 \u001a\u00020!2\u0007\u0010\u0001\u001a\u0002042\b\u0010\u0001\u001a\u00030\u0001H\u0002J.\u0010\u0001\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020706H\u0002Jj\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020.2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010m\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020r2\u0006\u00101\u001a\u0002022\u0006\u0010n\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020_2\u0006\u0010i\u001a\u00020j2\u0007\u0010 \u0001\u001a\u00020vH\u0002J&\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u00012\u0006\u00101\u001a\u0002022\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\u0019\u0010§\u0001\u001a\u00020h2\u0006\u00101\u001a\u0002022\u0006\u0010m\u001a\u00020HH\u0002J5\u0010¨\u0001\u001a\u00020\u001f2\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030¬\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010i\u001a\u00020j2\u0006\u0010 \u001a\u00020!H\u0002J\u0017\u0010­\u0001\u001a\b\u0012\u0004\u0012\u000207062\u0006\u0010 \u001a\u00020!H\u0002J=\u0010®\u0001\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u000207062\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u0011\u0010±\u0001\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0001\u0010²\u0001\u001a\u00030³\u00012\u0006\u0010\"\u001a\u00020#2\b\u0010´\u0001\u001a\u00030\u00012\u0007\u0010µ\u0001\u001a\u0002002\b\u0010¶\u0001\u001a\u00030¢\u00012\u0007\u0010·\u0001\u001a\u00020f2\u0006\u00101\u001a\u0002022\b\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010º\u0001\u001a\u00030»\u00012\u0006\u0010i\u001a\u00020j2\u0006\u0010U\u001a\u00020V2\u0006\u0010m\u001a\u00020H2\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u0014\u0010À\u0001\u001a\u00030Á\u00012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0002J6\u0010Ä\u0001\u001a\u00030Å\u00012\u0007\u0010Æ\u0001\u001a\u00020#2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010\u0001\u001a\u00020.2\u0006\u0010i\u001a\u00020j2\u0006\u00101\u001a\u000202H\u0002J?\u0010É\u0001\u001a\u00030Ê\u00012\u0007\u0010Æ\u0001\u001a\u00020#2\b\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010\u0001\u001a\u00020.2\u0006\u0010i\u001a\u00020j2\u0007\u0010 \u0001\u001a\u00020v2\u0006\u00101\u001a\u000202H\u0002J\t\u0010Í\u0001\u001a\u00020]H\u0002JH\u0010Î\u0001\u001a\u00030È\u00012\u0006\u0010\"\u001a\u00020#2\u0007\u0010Ï\u0001\u001a\u00020p2\u0007\u0010Ð\u0001\u001a\u0002002\b\u0010Ñ\u0001\u001a\u00030\u00012\u0006\u00101\u001a\u0002022\u0007\u0010·\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020.H\u0002J\u0014\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030Á\u0001H\u0002J\u0014\u0010Õ\u0001\u001a\u00030\u00012\b\u0010Ö\u0001\u001a\u00030Ó\u0001H\u0002J4\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010Q\u001a\u00020R2\u0006\u0010\"\u001a\u00020#2\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0011\u0010Û\u0001\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0011\u0010Ü\u0001\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0011\u0010Ý\u0001\u001a\u00020N2\u0006\u0010 \u001a\u00020!H\u0002J\u001f\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J,\u0010ß\u0001\u001a\u00020x2\u0006\u0010\"\u001a\u00020#2\u0007\u0010à\u0001\u001a\u00020l2\u0007\u0010á\u0001\u001a\u0002002\u0007\u0010·\u0001\u001a\u00020fH\u0002J\t\u0010â\u0001\u001a\u00020#H\u0002J.\u0010ã\u0001\u001a\u00030ä\u00012\u0006\u0010\"\u001a\u00020#2\b\u0010«\u0001\u001a\u00030¬\u00012\u0006\u0010i\u001a\u00020j2\b\u0010å\u0001\u001a\u00030æ\u0001H\u0002J\n\u0010ç\u0001\u001a\u00030æ\u0001H\u0002J\u001c\u0010è\u0001\u001a\u00030¦\u00012\u0006\u0010\"\u001a\u00020#2\b\u0010é\u0001\u001a\u00030ä\u0001H\u0002J\u001a\u0010ê\u0001\u001a\u00030\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010i\u001a\u00020jH\u0002J-\u0010ë\u0001\u001a\u0002022\u0007\u0010ì\u0001\u001a\u00020<2\u0007\u0010í\u0001\u001a\u00020<2\u0007\u0010î\u0001\u001a\u00020<2\u0007\u0010ï\u0001\u001a\u00020FH\u0002J\u001d\u0010ð\u0001\u001a\u00030Ì\u00012\u0007\u0010\u0001\u001a\u00020.2\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0002J6\u0010ó\u0001\u001a\u00020J2\u0006\u0010 \u001a\u00020!2\u0007\u0010ô\u0001\u001a\u00020<2\u0007\u0010õ\u0001\u001a\u00020<2\u0007\u0010ö\u0001\u001a\u00020<2\b\u0010÷\u0001\u001a\u00030ø\u0001H\u0002J&\u0010ù\u0001\u001a\u00030¤\u00012\b\u0010ú\u0001\u001a\u00030\u00012\u0007\u0010µ\u0001\u001a\u0002002\u0007\u0010·\u0001\u001a\u00020fH\u0002J\u0012\u0010û\u0001\u001a\u00030»\u00012\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010ü\u0001\u001a\u00020X2\r\u0010=\u001a\t\u0012\u0005\u0012\u00030ý\u000109H\u0002J \u0010þ\u0001\u001a\t\u0012\u0005\u0012\u00030ý\u0001092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u001f\u0010ÿ\u0001\u001a\b\u0012\u0004\u0012\u000207092\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0002"}, d2 = {"Lcom/unity3d/services/core/di/ServiceProvider;", "Lcom/unity3d/services/core/di/IServiceProvider;", "()V", "DATA_STORE_AUID", "", "DATA_STORE_GATEWAY_CACHE", "DATA_STORE_GL_INFO", "DATA_STORE_IDFI", "DATA_STORE_PRIVACY", "DATA_STORE_PRIVACY_FSM", "DATA_STORE_UNIVERSAL_REQUEST", "DEV_CONSENT_PRIVACY_RULES", "GATEWAY_HOST", "GATEWAY_PORT", "", "HTTP_CACHE_DISK_SIZE", "", "HTTP_CLIENT_FETCH_TIMEOUT", "LEGACY_PRIVACY_RULES", "NAMED_AD_REQ", "NAMED_INIT_REQ", "NAMED_OPERATIVE_REQ", "NAMED_OTHER_REQ", "NAMED_SDK", "PREF_AUID", "PREF_DEFAULT", "PREF_GL_INFO", "PREF_IDFI", "serviceRegistry", "Lcom/unity3d/services/core/di/IServicesRegistry;", "buildNetworkClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "context", "Landroid/content/Context;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Landroid/content/Context;Lcom/unity3d/services/core/domain/ISDKDispatchers;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultRequestPolicy", "Lgateway/v1/NativeConfigurationOuterClass$RequestPolicy;", "getDefaultRequestRetryPolicy", "Lgateway/v1/NativeConfigurationOuterClass$RequestRetryPolicy;", "getDefaultRequestTimeoutPolicy", "Lgateway/v1/NativeConfigurationOuterClass$RequestTimeoutPolicy;", "getRegistry", "initialize", "provideAdRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "provideAdRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "provideAndroidWebViewClient", "Lcom/unity3d/ads/adplayer/AndroidWebViewClient;", "provideAuidDataMigration", "Landroidx/datastore/core/DataMigration;", "LByteStringStoreOuterClass$ByteStringStore;", "provideAuidDataStore", "Landroidx/datastore/core/DataStore;", "auidMigration", "provideByteStringDataSource", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "dataStore", "provideByteStringDataStore", "dataStoreFile", "provideCampaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "provideDefaultDataMigration", "provideDefaultNativeConfiguration", "Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;", "provideDeviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "staticDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;", "dynamicDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/DynamicDeviceInfoDataSource;", "privacyDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;", "provideDiagnosticEventObserver", "Lcom/unity3d/ads/core/domain/events/DiagnosticEventObserver;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getDiagnosticEventBatchRequest", "Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventBatchRequest;", "diagnosticEventRepository", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "universalRequestDataSource", "Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "backgroundWorker", "Lcom/unity3d/ads/core/domain/work/BackgroundWorker;", "provideDynamicDeviceInfoDataSource", "lifecycleCache", "Lcom/unity3d/services/core/lifecycle/LifecycleCache;", "provideExecuteAdViewerRequest", "Lcom/unity3d/ads/core/domain/ExecuteAdViewerRequest;", "httpClient", "provideFetchGLInfoDataMigration", "getOpenGLRendererInfo", "Lcom/unity3d/ads/core/domain/GetOpenGLRendererInfo;", "provideGatewayCacheDataStore", "provideGatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "handleGatewayUniversalResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayUniversalResponse;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "provideGetAdDataRefreshRequest", "Lcom/unity3d/ads/core/domain/GetAdDataRefreshRequest;", "deviceInfoRepository", "campaignStateRepository", "provideGetAdRequest", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "provideGetAndroidExposureUseCase", "Lcom/unity3d/ads/core/domain/HandleAndroidInvocationsUseCase;", "getAndroidAdPlayerContext", "Lcom/unity3d/ads/core/domain/GetAndroidAdPlayerContext;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "refresh", "Lcom/unity3d/ads/core/domain/Refresh;", "handleOpenUrl", "Lcom/unity3d/ads/core/domain/HandleOpenUrl;", "sendPrivacyUpdateRequest", "Lcom/unity3d/ads/core/domain/SendPrivacyUpdateRequest;", "provideGetClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "mediationRepository", "Lcom/unity3d/ads/core/data/repository/MediationRepository;", "provideGetInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;", "provideGetInitializationRequest", "Lcom/unity3d/ads/core/domain/GetInitializationRequest;", "getClientInfo", "legacyUserConsentRepository", "Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;", "provideGetOpenGLRendererInfo", "provideGetSharedDataTimestamps", "provideGetUniversalRequestForPayLoad", "getUniversalRequestSharedData", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "provideGetUniversalRequestSharedData", "developerConsentRepository", "Lcom/unity3d/ads/core/data/repository/DeveloperConsentRepository;", "provideGetWebViewBridgeUseCase", "Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;", "provideGetWebViewContainerUseCase", "Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;", "androidWebViewClient", "sendWebViewClientErrorDiagnostics", "Lcom/unity3d/ads/core/domain/SendWebViewClientErrorDiagnostics;", "provideGlInfoDataStore", "fetchGLInfo", "provideHandleGatewayAdResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "adRepository", "getWebViewContainerUseCase", "getWebViewBridge", "getHandleAndroidInvocationsUseCase", "executeAdViewerRequest", "operativeEventApi", "provideHandleGatewayInitializationResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;", "triggerInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "provideHandleGatewayUniversalResponse", "provideHttpClient", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "provideIdfiDataMigration", "provideIdfiDataStore", "idfiMigration", "defaultIdfi", "provideInitRequestPolicy", "provideInitializeBoldSDK", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "getInitializeRequest", "getInitRequestPolicy", "handleGatewayInitializationResponse", "gatewayClient", "eventObservers", "Lcom/unity3d/ads/core/domain/events/EventObservers;", "triggerInitializeListener", "Lcom/unity3d/ads/core/domain/TriggerInitializeListener;", "storageManager", "Lcom/unity3d/ads/core/data/manager/StorageManager;", "sdkPropertiesManager", "Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;", "provideJsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", "storageType", "Lcom/unity3d/services/core/device/StorageManager$StorageType;", "provideLegacyLoadUseCase", "Lcom/unity3d/ads/core/domain/LegacyLoadUseCase;", "dispatcher", "load", "Lcom/unity3d/ads/core/domain/Load;", "provideLegacyShowUseCase", "Lcom/unity3d/ads/core/domain/LegacyShowUseCase;", "show", "Lcom/unity3d/ads/core/domain/Show;", "provideLifeCycleCache", "provideLoad", "getAdRequest", "getOtherRequestPolicy", "handleGatewayAdResponse", "provideMediationDataSource", "Lcom/unity3d/ads/core/data/datasource/MediationDataSource;", "publicStorage", "provideMediationRepository", "mediationDataSource", "provideOperativeEventObserver", "Lcom/unity3d/ads/core/domain/events/OperativeEventObserver;", "operativeEventRepository", "Lcom/unity3d/ads/core/data/repository/OperativeEventRepository;", "provideOperativeEventRequestPolicy", "provideOtherRequestPolicy", "providePrivacyDeviceInfoDataSource", "providePrivacyFsmDataStore", "provideRefresh", "getAdDataRefreshRequest", "getRequestPolicy", "provideSDKDispatchers", "provideSDKErrorHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "provideSDKMetricSender", "provideSDKScope", "errorHandler", "provideSendWebViewClientErrorDiagnostics", "provideSessionRepository", "gatewayCacheDataSource", "privacyDataSource", "privacyFsmDataSource", "nativeConfiguration", "provideShow", "gameServerIdReader", "Lcom/unity3d/ads/core/configuration/GameServerIdReader;", "provideStaticDeviceInfoDataSource", "idfiStore", "auidStore", "glInfoStore", "analyticsDataSource", "Lcom/unity3d/ads/core/data/datasource/AnalyticsDataSource;", "provideTriggerInitializationCompletedRequest", "getInitializationCompletedRequest", "provideTriggerInitializeListener", "provideUniversalRequestDataSource", "LUniversalRequestStoreOuterClass$UniversalRequestStore;", "provideUniversalRequestDataStore", "provideUserConsentDataStore", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
public final class ServiceProvider implements IServiceProvider {
    public static final String DATA_STORE_AUID = "auid.pb";
    public static final String DATA_STORE_GATEWAY_CACHE = "gateway_cache.pb";
    public static final String DATA_STORE_GL_INFO = "glinfo.pb";
    public static final String DATA_STORE_IDFI = "idfi.pb";
    public static final String DATA_STORE_PRIVACY = "privacy.pb";
    public static final String DATA_STORE_PRIVACY_FSM = "privacy_fsm.pb";
    public static final String DATA_STORE_UNIVERSAL_REQUEST = "universal_request.pb";
    public static final String DEV_CONSENT_PRIVACY_RULES = "dev_consent_privacy_rules";
    public static final String GATEWAY_HOST = "gateway.unityads.unity3d.com";
    public static final int GATEWAY_PORT = 443;
    public static final long HTTP_CACHE_DISK_SIZE = 5242880;
    public static final long HTTP_CLIENT_FETCH_TIMEOUT = 500;
    public static final ServiceProvider INSTANCE;
    public static final String LEGACY_PRIVACY_RULES = "legacy_privacy_rules";
    public static final String NAMED_AD_REQ = "ad_req";
    public static final String NAMED_INIT_REQ = "init_req";
    public static final String NAMED_OPERATIVE_REQ = "op_event_req";
    public static final String NAMED_OTHER_REQ = "other_req";
    public static final String NAMED_SDK = "sdk";
    public static final String PREF_AUID = "supersonic_shared_preferen";
    public static final String PREF_DEFAULT = "default-migration";
    public static final String PREF_GL_INFO = "glinfo";
    public static final String PREF_IDFI = "unityads-installinfo";
    private static final IServicesRegistry serviceRegistry;

    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    private ServiceProvider() {
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(ServiceProvider$initialize$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final MediationDataSource provideMediationDataSource(JsonStorage jsonStorage) {
        return new AndroidMediationDataSource(jsonStorage);
    }

    /* access modifiers changed from: private */
    public final MediationRepository provideMediationRepository(MediationDataSource mediationDataSource) {
        return new AndroidMediationRepository(mediationDataSource);
    }

    /* access modifiers changed from: private */
    public final GetRequestPolicy provideInitRequestPolicy(SessionRepository sessionRepository) {
        return new GetInitRequestPolicy(sessionRepository);
    }

    /* access modifiers changed from: private */
    public final GetRequestPolicy provideOtherRequestPolicy(SessionRepository sessionRepository) {
        return new GetOtherRequestPolicy(sessionRepository);
    }

    /* access modifiers changed from: private */
    public final GetRequestPolicy provideAdRequestPolicy(SessionRepository sessionRepository) {
        return new GetAdRequestPolicy(sessionRepository);
    }

    /* access modifiers changed from: private */
    public final GetRequestPolicy provideOperativeEventRequestPolicy(SessionRepository sessionRepository) {
        return new GetOperativeEventRequestPolicy(sessionRepository);
    }

    /* access modifiers changed from: private */
    public final GetWebViewBridgeUseCase provideGetWebViewBridgeUseCase(ISDKDispatchers iSDKDispatchers) {
        return new GetCommonWebViewBridgeUseCase(iSDKDispatchers.getDefault());
    }

    /* access modifiers changed from: private */
    public final OperativeEventObserver provideOperativeEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, ISDKDispatchers iSDKDispatchers, OperativeEventRepository operativeEventRepository, UniversalRequestDataSource universalRequestDataSource, BackgroundWorker backgroundWorker) {
        return new OperativeEventObserver(getUniversalRequestForPayLoad, iSDKDispatchers.getDefault(), operativeEventRepository, universalRequestDataSource, backgroundWorker);
    }

    /* access modifiers changed from: private */
    public final DiagnosticEventObserver provideDiagnosticEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest, ISDKDispatchers iSDKDispatchers, DiagnosticEventRepository diagnosticEventRepository, UniversalRequestDataSource universalRequestDataSource, BackgroundWorker backgroundWorker) {
        return new DiagnosticEventObserver(getUniversalRequestForPayLoad, getDiagnosticEventBatchRequest, iSDKDispatchers.getDefault(), diagnosticEventRepository, universalRequestDataSource, backgroundWorker);
    }

    /* access modifiers changed from: private */
    public final TriggerInitializeListener provideTriggerInitializeListener(ISDKDispatchers iSDKDispatchers) {
        return new TriggerInitializeListener(iSDKDispatchers.getMain());
    }

    /* access modifiers changed from: private */
    public final AndroidGetWebViewContainerUseCase provideGetWebViewContainerUseCase(Context context, AndroidWebViewClient androidWebViewClient, SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics) {
        return new AndroidGetWebViewContainerUseCase(context, androidWebViewClient, sendWebViewClientErrorDiagnostics);
    }

    /* access modifiers changed from: private */
    public final SendWebViewClientErrorDiagnostics provideSendWebViewClientErrorDiagnostics(ISDKDispatchers iSDKDispatchers, SendDiagnosticEvent sendDiagnosticEvent) {
        return new AndroidSendWebViewClientErrorDiagnostics(iSDKDispatchers.getIo(), sendDiagnosticEvent);
    }

    /* access modifiers changed from: private */
    public final ISDKDispatchers provideSDKDispatchers() {
        return new SDKDispatchers();
    }

    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler provideSDKErrorHandler(ISDKDispatchers iSDKDispatchers, AlternativeFlowReader alternativeFlowReader, SendDiagnosticEvent sendDiagnosticEvent, SDKMetricsSender sDKMetricsSender) {
        return new SDKErrorHandler(iSDKDispatchers.getIo(), alternativeFlowReader, sendDiagnosticEvent, sDKMetricsSender);
    }

    /* access modifiers changed from: private */
    public final CoroutineScope provideSDKScope(ISDKDispatchers iSDKDispatchers, CoroutineExceptionHandler coroutineExceptionHandler) {
        return CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(coroutineExceptionHandler));
    }

    /* access modifiers changed from: private */
    public final SDKMetricsSender provideSDKMetricSender() {
        SDKMetricsSender instance = SDKMetrics.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    /* access modifiers changed from: private */
    public final HttpClient provideHttpClient(ConfigFileFromLocalStorage configFileFromLocalStorage, AlternativeFlowReader alternativeFlowReader, ISDKDispatchers iSDKDispatchers, SendDiagnosticEvent sendDiagnosticEvent, Context context) {
        return (HttpClient) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ServiceProvider$provideHttpClient$1(alternativeFlowReader, sendDiagnosticEvent, iSDKDispatchers, context, configFileFromLocalStorage, (Continuation<? super ServiceProvider$provideHttpClient$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final JsonStorage provideJsonStorage(StorageManager.StorageType storageType) {
        if (StorageManager.init(ClientProperties.getApplicationContext())) {
            Storage storage = StorageManager.getStorage(storageType);
            Intrinsics.checkNotNullExpressionValue(storage, "getStorage(storageType)");
            return storage;
        }
        throw new IllegalStateException("StorageManager failed to initialize".toString());
    }

    /* access modifiers changed from: private */
    public final InitializeBoldSDK provideInitializeBoldSDK(ISDKDispatchers iSDKDispatchers, GetInitializationRequest getInitializationRequest, GetRequestPolicy getRequestPolicy, HandleGatewayInitializationResponse handleGatewayInitializationResponse, GatewayClient gatewayClient, SessionRepository sessionRepository, EventObservers eventObservers, TriggerInitializeListener triggerInitializeListener, SendDiagnosticEvent sendDiagnosticEvent, DiagnosticEventRepository diagnosticEventRepository, DeviceInfoRepository deviceInfoRepository, com.unity3d.ads.core.data.manager.StorageManager storageManager, SDKPropertiesManager sDKPropertiesManager) {
        return new InitializeAndroidBoldSDK(iSDKDispatchers.getDefault(), getInitializationRequest, getRequestPolicy, handleGatewayInitializationResponse, gatewayClient, sessionRepository, eventObservers, triggerInitializeListener, sendDiagnosticEvent, diagnosticEventRepository, deviceInfoRepository, storageManager, sDKPropertiesManager);
    }

    /* access modifiers changed from: private */
    public final GetInitializationRequest provideGetInitializationRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, GetClientInfo getClientInfo, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, LegacyUserConsentRepository legacyUserConsentRepository) {
        return new GetAndroidInitializationRequest(getUniversalRequestForPayLoad, getClientInfo, sessionRepository, deviceInfoRepository, legacyUserConsentRepository);
    }

    /* access modifiers changed from: private */
    public final HandleGatewayUniversalResponse provideHandleGatewayUniversalResponse(SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository) {
        return new HandleAndroidGatewayUniversalResponse(sessionRepository, deviceInfoRepository);
    }

    /* access modifiers changed from: private */
    public final HandleGatewayInitializationResponse provideHandleGatewayInitializationResponse(TriggerInitializationCompletedRequest triggerInitializationCompletedRequest, SessionRepository sessionRepository, CoroutineScope coroutineScope) {
        return new HandleAndroidGatewayInitializationResponse(triggerInitializationCompletedRequest, sessionRepository, coroutineScope);
    }

    /* access modifiers changed from: private */
    public final UniversalRequestDataSource provideUniversalRequestDataSource(DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> dataStore) {
        return new UniversalRequestDataSource(dataStore);
    }

    /* access modifiers changed from: private */
    public final ByteStringDataSource provideByteStringDataSource(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        return new AndroidByteStringDataSource(dataStore);
    }

    /* access modifiers changed from: private */
    public final SessionRepository provideSessionRepository(ByteStringDataSource byteStringDataSource, ByteStringDataSource byteStringDataSource2, ByteStringDataSource byteStringDataSource3, NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration) {
        return new AndroidSessionRepository(byteStringDataSource, byteStringDataSource2, byteStringDataSource3, nativeConfiguration);
    }

    /* access modifiers changed from: private */
    public final GetClientInfo provideGetClientInfo(SessionRepository sessionRepository, MediationRepository mediationRepository) {
        return new GetAndroidClientInfo(sessionRepository, mediationRepository);
    }

    /* access modifiers changed from: private */
    public final GatewayClient provideGatewayClient(HttpClient httpClient, HandleGatewayUniversalResponse handleGatewayUniversalResponse, SendDiagnosticEvent sendDiagnosticEvent) {
        return new CommonGatewayClient(httpClient, handleGatewayUniversalResponse, sendDiagnosticEvent);
    }

    /* access modifiers changed from: private */
    public final GetUniversalRequestForPayLoad provideGetUniversalRequestForPayLoad(GetUniversalRequestSharedData getUniversalRequestSharedData) {
        return new GetAndroidUniversalRequestForPayLoad(getUniversalRequestSharedData);
    }

    /* access modifiers changed from: private */
    public final GetUniversalRequestSharedData provideGetUniversalRequestSharedData(GetSharedDataTimestamps getSharedDataTimestamps, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, DeveloperConsentRepository developerConsentRepository) {
        return new GetAndroidUniversalRequestSharedData(getSharedDataTimestamps, sessionRepository, deviceInfoRepository, developerConsentRepository);
    }

    /* access modifiers changed from: private */
    public final GetSharedDataTimestamps provideGetSharedDataTimestamps() {
        return new GetAndroidSharedDataTimestamps();
    }

    /* access modifiers changed from: private */
    public final DeviceInfoRepository provideDeviceInfoRepository(StaticDeviceInfoDataSource staticDeviceInfoDataSource, DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource, PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource) {
        return new AndroidDeviceInfoRepository(staticDeviceInfoDataSource, dynamicDeviceInfoDataSource, privacyDeviceInfoDataSource);
    }

    /* access modifiers changed from: private */
    public final StaticDeviceInfoDataSource provideStaticDeviceInfoDataSource(Context context, ByteStringDataSource byteStringDataSource, ByteStringDataSource byteStringDataSource2, ByteStringDataSource byteStringDataSource3, AnalyticsDataSource analyticsDataSource) {
        return new AndroidStaticDeviceInfoDataSource(context, byteStringDataSource, byteStringDataSource2, byteStringDataSource3, analyticsDataSource);
    }

    /* access modifiers changed from: private */
    public final DynamicDeviceInfoDataSource provideDynamicDeviceInfoDataSource(Context context, LifecycleCache lifecycleCache) {
        return new AndroidDynamicDeviceInfoDataSource(context, lifecycleCache);
    }

    /* access modifiers changed from: private */
    public final PrivacyDeviceInfoDataSource providePrivacyDeviceInfoDataSource(Context context) {
        return new AndroidPrivacyDeviceInfoDataSource(context);
    }

    /* access modifiers changed from: private */
    public final LifecycleCache provideLifeCycleCache() {
        LifecycleCache lifecycleListener = CachedLifecycle.getLifecycleListener();
        Intrinsics.checkNotNullExpressionValue(lifecycleListener, "getLifecycleListener()");
        return lifecycleListener;
    }

    /* access modifiers changed from: private */
    public final Load provideLoad(ISDKDispatchers iSDKDispatchers, GetAdRequest getAdRequest, GetRequestPolicy getRequestPolicy, HandleGatewayAdResponse handleGatewayAdResponse, SessionRepository sessionRepository, GatewayClient gatewayClient, AdRepository adRepository) {
        return new AndroidLoad(iSDKDispatchers.getDefault(), getAdRequest, getRequestPolicy, handleGatewayAdResponse, sessionRepository, gatewayClient, adRepository);
    }

    /* access modifiers changed from: private */
    public final Refresh provideRefresh(ISDKDispatchers iSDKDispatchers, GetAdDataRefreshRequest getAdDataRefreshRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        return new AndroidRefresh(iSDKDispatchers.getDefault(), getAdDataRefreshRequest, getRequestPolicy, gatewayClient);
    }

    /* access modifiers changed from: private */
    public final GetAdRequest provideGetAdRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, CampaignStateRepository campaignStateRepository) {
        return new GetAndroidAdRequest(getUniversalRequestForPayLoad, sessionRepository, deviceInfoRepository, campaignStateRepository);
    }

    /* access modifiers changed from: private */
    public final GetAdDataRefreshRequest provideGetAdDataRefreshRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, CampaignStateRepository campaignStateRepository) {
        return new GetAndroidAdDataRefreshRequest(getUniversalRequestForPayLoad, sessionRepository, deviceInfoRepository, campaignStateRepository);
    }

    /* access modifiers changed from: private */
    public final HandleGatewayAdResponse provideHandleGatewayAdResponse(AdRepository adRepository, AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase, GetWebViewBridgeUseCase getWebViewBridgeUseCase, ISDKDispatchers iSDKDispatchers, DeviceInfoRepository deviceInfoRepository, HandleAndroidInvocationsUseCase handleAndroidInvocationsUseCase, SessionRepository sessionRepository, CampaignStateRepository campaignStateRepository, ExecuteAdViewerRequest executeAdViewerRequest, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi) {
        return new HandleGatewayAndroidAdResponse(adRepository, androidGetWebViewContainerUseCase, getWebViewBridgeUseCase, iSDKDispatchers.getDefault(), deviceInfoRepository, handleAndroidInvocationsUseCase, sessionRepository, campaignStateRepository, executeAdViewerRequest, sendDiagnosticEvent, getOperativeEventApi);
    }

    /* access modifiers changed from: private */
    public final AdRepository provideAdRepository() {
        return new AndroidAdRepository();
    }

    /* access modifiers changed from: private */
    public final CampaignStateRepository provideCampaignStateRepository(GetSharedDataTimestamps getSharedDataTimestamps) {
        return new AndroidCampaignStateRepository(getSharedDataTimestamps);
    }

    /* access modifiers changed from: private */
    public final Show provideShow(AdRepository adRepository, GameServerIdReader gameServerIdReader) {
        return new AndroidShow(adRepository, gameServerIdReader);
    }

    /* access modifiers changed from: private */
    public final HandleAndroidInvocationsUseCase provideGetAndroidExposureUseCase(GetAndroidAdPlayerContext getAndroidAdPlayerContext, GetOperativeEventApi getOperativeEventApi, Refresh refresh, HandleOpenUrl handleOpenUrl, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, CampaignStateRepository campaignStateRepository, SendPrivacyUpdateRequest sendPrivacyUpdateRequest, SendDiagnosticEvent sendDiagnosticEvent) {
        return new HandleAndroidInvocationsUseCase(getAndroidAdPlayerContext, getOperativeEventApi, refresh, handleOpenUrl, sessionRepository, deviceInfoRepository, campaignStateRepository, sendPrivacyUpdateRequest, sendDiagnosticEvent);
    }

    /* access modifiers changed from: private */
    public final AndroidWebViewClient provideAndroidWebViewClient() {
        return new AndroidWebViewClient();
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideGatewayCacheDataStore(Context context, ISDKDispatchers iSDKDispatchers) {
        return provideByteStringDataStore(context, iSDKDispatchers, DATA_STORE_GATEWAY_CACHE);
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideUserConsentDataStore(Context context, ISDKDispatchers iSDKDispatchers) {
        return provideByteStringDataStore(context, iSDKDispatchers, DATA_STORE_PRIVACY);
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> providePrivacyFsmDataStore(Context context, ISDKDispatchers iSDKDispatchers) {
        return provideByteStringDataStore(context, iSDKDispatchers, DATA_STORE_PRIVACY_FSM);
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideIdfiDataStore(Context context, ISDKDispatchers iSDKDispatchers, DataMigration<ByteStringStoreOuterClass.ByteStringStore> dataMigration, DataMigration<ByteStringStoreOuterClass.ByteStringStore> dataMigration2) {
        DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
        ByteStringSerializer byteStringSerializer = new ByteStringSerializer();
        return dataStoreFactory.create(byteStringSerializer, new ReplaceFileCorruptionHandler(ServiceProvider$provideIdfiDataStore$1.INSTANCE), CollectionsKt.listOf(dataMigration, dataMigration2), CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), new ServiceProvider$provideIdfiDataStore$2(context));
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideAuidDataStore(Context context, ISDKDispatchers iSDKDispatchers, DataMigration<ByteStringStoreOuterClass.ByteStringStore> dataMigration) {
        DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
        ByteStringSerializer byteStringSerializer = new ByteStringSerializer();
        return dataStoreFactory.create(byteStringSerializer, new ReplaceFileCorruptionHandler(ServiceProvider$provideAuidDataStore$1.INSTANCE), CollectionsKt.listOf(dataMigration), CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), new ServiceProvider$provideAuidDataStore$2(context));
    }

    /* access modifiers changed from: private */
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideGlInfoDataStore(Context context, ISDKDispatchers iSDKDispatchers, DataMigration<ByteStringStoreOuterClass.ByteStringStore> dataMigration) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), (ReplaceFileCorruptionHandler) null, CollectionsKt.listOf(dataMigration), CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), new ServiceProvider$provideGlInfoDataStore$1(context), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> provideAuidDataMigration(Context context) {
        return new ForcefulPreservingByteStringPreferenceMigration(context, "supersonic_shared_preferen", "auid", new GetAuidData());
    }

    /* access modifiers changed from: private */
    public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> provideIdfiDataMigration(Context context) {
        return new PreservingByteStringPreferenceMigration(context, "unityads-installinfo", AndroidStaticDeviceInfoDataSource.PREF_KEY_IDFI, new GetIdfiData());
    }

    /* access modifiers changed from: private */
    public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> provideDefaultDataMigration() {
        return new DefaultByteStringMigration("unityads-installinfo", AndroidStaticDeviceInfoDataSource.PREF_KEY_IDFI, new GetIdfiData());
    }

    /* access modifiers changed from: private */
    public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> provideFetchGLInfoDataMigration(GetOpenGLRendererInfo getOpenGLRendererInfo) {
        return new FetchGLInfoDataMigration(getOpenGLRendererInfo);
    }

    /* access modifiers changed from: private */
    public final GetOpenGLRendererInfo provideGetOpenGLRendererInfo(SessionRepository sessionRepository) {
        return new GetAndroidOpenGLRendererInfo(sessionRepository);
    }

    private final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideByteStringDataStore(Context context, ISDKDispatchers iSDKDispatchers, String str) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), (ReplaceFileCorruptionHandler) null, (List) null, CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), new ServiceProvider$provideByteStringDataStore$1(context, str), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> provideUniversalRequestDataStore(Context context, ISDKDispatchers iSDKDispatchers) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new UniversalRequestStoreSerializer(), (ReplaceFileCorruptionHandler) null, (List) null, CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), new ServiceProvider$provideUniversalRequestDataStore$1(context), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final GetInitializationCompletedRequest provideGetInitializationCompletedRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, DeviceInfoRepository deviceInfoRepository) {
        return new GetAndroidInitializationCompletedRequest(getUniversalRequestForPayLoad, deviceInfoRepository);
    }

    /* access modifiers changed from: private */
    public final TriggerInitializationCompletedRequest provideTriggerInitializationCompletedRequest(GetInitializationCompletedRequest getInitializationCompletedRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        return new TriggerAndroidInitializationCompletedRequest(getInitializationCompletedRequest, getRequestPolicy, gatewayClient);
    }

    /* access modifiers changed from: private */
    public final ExecuteAdViewerRequest provideExecuteAdViewerRequest(ISDKDispatchers iSDKDispatchers, HttpClient httpClient) {
        return new AndroidExecuteAdViewerRequest(iSDKDispatchers.getIo(), httpClient);
    }

    /* access modifiers changed from: private */
    public final LegacyShowUseCase provideLegacyShowUseCase(ISDKDispatchers iSDKDispatchers, Show show, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, SessionRepository sessionRepository) {
        return new LegacyShowUseCase(iSDKDispatchers.getMain(), show, adRepository, sendDiagnosticEvent, getOperativeEventApi, sessionRepository);
    }

    /* access modifiers changed from: private */
    public final LegacyLoadUseCase provideLegacyLoadUseCase(ISDKDispatchers iSDKDispatchers, Load load, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent, SessionRepository sessionRepository) {
        return new LegacyLoadUseCase(iSDKDispatchers.getMain(), load, sendDiagnosticEvent, sessionRepository, adRepository);
    }

    /* access modifiers changed from: private */
    public final Object buildNetworkClient(Context context, ISDKDispatchers iSDKDispatchers, Continuation<? super HttpClient> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CronetProviderInstaller.installProvider(context).addOnCompleteListener(new ServiceProvider$buildNetworkClient$2$1(context, cancellableContinuationImpl, iSDKDispatchers));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final NativeConfigurationOuterClass.RequestPolicy getDefaultRequestPolicy() {
        RequestPolicyKt.Dsl.Companion companion = RequestPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestPolicy.Builder newBuilder = NativeConfigurationOuterClass.RequestPolicy.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        RequestPolicyKt.Dsl _create = companion._create(newBuilder);
        ServiceProvider serviceProvider = INSTANCE;
        _create.setRetryPolicy(serviceProvider.getDefaultRequestRetryPolicy());
        _create.setTimeoutPolicy(serviceProvider.getDefaultRequestTimeoutPolicy());
        return _create._build();
    }

    private final NativeConfigurationOuterClass.RequestRetryPolicy getDefaultRequestRetryPolicy() {
        RequestRetryPolicyKt.Dsl.Companion companion = RequestRetryPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestRetryPolicy.Builder newBuilder = NativeConfigurationOuterClass.RequestRetryPolicy.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        RequestRetryPolicyKt.Dsl _create = companion._create(newBuilder);
        _create.setMaxDuration(30000);
        _create.setRetryWaitBase(30000);
        _create.setRetryJitterPct(0.1f);
        _create.setShouldStoreLocally(false);
        return _create._build();
    }

    private final NativeConfigurationOuterClass.RequestTimeoutPolicy getDefaultRequestTimeoutPolicy() {
        RequestTimeoutPolicyKt.Dsl.Companion companion = RequestTimeoutPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder newBuilder = NativeConfigurationOuterClass.RequestTimeoutPolicy.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        RequestTimeoutPolicyKt.Dsl _create = companion._create(newBuilder);
        _create.setConnectTimeoutMs(30000);
        _create.setReadTimeoutMs(30000);
        _create.setWriteTimeoutMs(30000);
        return _create._build();
    }

    /* access modifiers changed from: private */
    public final NativeConfigurationOuterClass.NativeConfiguration provideDefaultNativeConfiguration() {
        NativeConfigurationKt.Dsl.Companion companion = NativeConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.NativeConfiguration.Builder newBuilder = NativeConfigurationOuterClass.NativeConfiguration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        NativeConfigurationKt.Dsl _create = companion._create(newBuilder);
        ServiceProvider serviceProvider = INSTANCE;
        _create.setInitPolicy(serviceProvider.getDefaultRequestPolicy());
        _create.setAdPolicy(serviceProvider.getDefaultRequestPolicy());
        _create.setOtherPolicy(serviceProvider.getDefaultRequestPolicy());
        _create.setOperativeEventPolicy(serviceProvider.getDefaultRequestPolicy());
        DiagnosticEventsConfigurationKt.Dsl.Companion companion2 = DiagnosticEventsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration.Builder newBuilder2 = NativeConfigurationOuterClass.DiagnosticEventsConfiguration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
        DiagnosticEventsConfigurationKt.Dsl _create2 = companion2._create(newBuilder2);
        _create2.setEnabled(false);
        _create2.setMaxBatchSize(1);
        _create2.setMaxBatchIntervalMs(1000);
        _create2.setTtmEnabled(false);
        _create.setDiagnosticEvents(_create2._build());
        return _create._build();
    }
}
