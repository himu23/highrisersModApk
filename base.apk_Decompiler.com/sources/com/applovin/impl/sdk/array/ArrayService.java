package com.applovin.impl.sdk.array;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback;
import com.applovin.array.apphub.aidl.IAppHubService;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ArrayService extends IAppHubDirectDownloadServiceCallback.Stub {
    private static final int MAX_RECONNECT_RETRY_COUNT = 3;
    private static final String SERVICE_INTENT_CLASS_NAME = "com.applovin.oem.am.android.external.AppHubService";
    private static final String SERVICE_INTENT_FILTER_ACTION = "com.applovin.am.intent.action.APPHUB_SERVICE";
    private static final String TAG = "ArrayService";
    private String appHubPackageName;
    /* access modifiers changed from: private */
    public IAppHubService appHubService;
    private final Intent appHubServiceIntent;
    private long appHubVersionCode = -1;
    /* access modifiers changed from: private */
    public DirectDownloadState currentDownloadState;
    private int currentRetryCount;
    private final ArrayDataCollector dataCollector;
    private Boolean isDirectDownloadEnabled;
    /* access modifiers changed from: private */
    public final x logger;
    private String randomUserToken;
    private final n sdk;

    public interface DirectDownloadListener {
        void onAppDetailsDismissed();

        void onAppDetailsDisplayed();

        void onFailure();
    }

    public String getAppHubPackageName() {
        return this.appHubPackageName;
    }

    public long getAppHubVersionCode() {
        return this.appHubVersionCode;
    }

    public Boolean getIsDirectDownloadEnabled() {
        return this.isDirectDownloadEnabled;
    }

    public String getRandomUserToken() {
        return this.randomUserToken;
    }

    public boolean isAppHubInstalled() {
        return this.appHubService != null;
    }

    private static class DirectDownloadState {
        /* access modifiers changed from: private */
        public final String adToken;
        /* access modifiers changed from: private */
        public final AtomicBoolean errorCallbackInvoked = new AtomicBoolean();
        /* access modifiers changed from: private */
        public final DirectDownloadListener listener;
        /* access modifiers changed from: private */
        public final Bundle parameters;

        public String getAdToken() {
            return this.adToken;
        }

        public AtomicBoolean getErrorCallbackInvoked() {
            return this.errorCallbackInvoked;
        }

        public DirectDownloadListener getListener() {
            return this.listener;
        }

        public Bundle getParameters() {
            return this.parameters;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof DirectDownloadState;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DirectDownloadState)) {
                return false;
            }
            DirectDownloadState directDownloadState = (DirectDownloadState) obj;
            if (!directDownloadState.canEqual(this)) {
                return false;
            }
            AtomicBoolean errorCallbackInvoked2 = getErrorCallbackInvoked();
            AtomicBoolean errorCallbackInvoked3 = directDownloadState.getErrorCallbackInvoked();
            if (errorCallbackInvoked2 != null ? !errorCallbackInvoked2.equals(errorCallbackInvoked3) : errorCallbackInvoked3 != null) {
                return false;
            }
            String adToken2 = getAdToken();
            String adToken3 = directDownloadState.getAdToken();
            if (adToken2 != null ? !adToken2.equals(adToken3) : adToken3 != null) {
                return false;
            }
            Bundle parameters2 = getParameters();
            Bundle parameters3 = directDownloadState.getParameters();
            if (parameters2 != null ? !parameters2.equals(parameters3) : parameters3 != null) {
                return false;
            }
            DirectDownloadListener listener2 = getListener();
            DirectDownloadListener listener3 = directDownloadState.getListener();
            return listener2 != null ? listener2.equals(listener3) : listener3 == null;
        }

        public int hashCode() {
            AtomicBoolean errorCallbackInvoked2 = getErrorCallbackInvoked();
            int i = 43;
            int hashCode = errorCallbackInvoked2 == null ? 43 : errorCallbackInvoked2.hashCode();
            String adToken2 = getAdToken();
            int hashCode2 = ((hashCode + 59) * 59) + (adToken2 == null ? 43 : adToken2.hashCode());
            Bundle parameters2 = getParameters();
            int hashCode3 = (hashCode2 * 59) + (parameters2 == null ? 43 : parameters2.hashCode());
            DirectDownloadListener listener2 = getListener();
            int i2 = hashCode3 * 59;
            if (listener2 != null) {
                i = listener2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            return "ArrayService.DirectDownloadState(errorCallbackInvoked=" + getErrorCallbackInvoked() + ", adToken=" + getAdToken() + ", parameters=" + getParameters() + ", listener=" + getListener() + ")";
        }

        public DirectDownloadState(String str, Bundle bundle, DirectDownloadListener directDownloadListener) {
            this.adToken = str;
            this.parameters = bundle;
            this.listener = directDownloadListener;
        }
    }

    public ArrayService(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.dataCollector = new ArrayDataCollector(nVar);
        Intent createAppHubServiceIntent = createAppHubServiceIntent();
        this.appHubServiceIntent = createAppHubServiceIntent;
        if (createAppHubServiceIntent != null) {
            bindAppHubService();
        }
        nVar.BM().a(new a() {
            public void onActivityStopped(Activity activity) {
                DirectDownloadState access$000 = ArrayService.this.currentDownloadState;
                if (ArrayService.this.appHubService != null && access$000 != null) {
                    try {
                        x unused = ArrayService.this.logger;
                        if (x.Fn()) {
                            ArrayService.this.logger.f(ArrayService.TAG, "Dismissing Direct Download Activity");
                        }
                        ArrayService.this.appHubService.dismissDirectDownloadAppDetails(access$000.adToken);
                        access$000.listener.onAppDetailsDismissed();
                        DirectDownloadState unused2 = ArrayService.this.currentDownloadState = null;
                    } catch (RemoteException e) {
                        x unused3 = ArrayService.this.logger;
                        if (x.Fn()) {
                            ArrayService.this.logger.c(ArrayService.TAG, "Failed dismiss Direct Download Activity", e);
                        }
                    }
                }
            }
        });
    }

    public void startDirectInstallOrDownloadProcess(ArrayDirectDownloadAd arrayDirectDownloadAd, Bundle bundle, DirectDownloadListener directDownloadListener) {
        if (this.appHubService == null) {
            if (x.Fn()) {
                this.logger.i(TAG, "Cannot begin Direct Install / Download process - service disconnected");
            }
            directDownloadListener.onFailure();
        } else if (!arrayDirectDownloadAd.isDirectDownloadEnabled()) {
            if (x.Fn()) {
                this.logger.i(TAG, "Cannot begin Direct Install / Download process - missing token");
            }
            directDownloadListener.onFailure();
        } else {
            try {
                Bundle directDownloadParameters = arrayDirectDownloadAd.getDirectDownloadParameters();
                if (bundle != null) {
                    directDownloadParameters.putAll(bundle);
                }
                this.currentDownloadState = new DirectDownloadState(arrayDirectDownloadAd.getDirectDownloadToken(), directDownloadParameters, directDownloadListener);
                if (x.Fn()) {
                    this.logger.f(TAG, "Starting Direct Download Activity");
                }
                if (this.appHubVersionCode >= 21) {
                    this.appHubService.showDirectDownloadAppDetailsWithExtra(this.currentDownloadState.adToken, this.currentDownloadState.parameters, this);
                } else {
                    this.appHubService.showDirectDownloadAppDetails(this.currentDownloadState.adToken, this);
                }
                if (x.Fn()) {
                    this.logger.f(TAG, "Activity started");
                }
            } catch (Throwable th) {
                if (x.Fn()) {
                    this.logger.c(TAG, "Failed to execute Direct Install / Download process", th);
                }
                this.sdk.Cs().d(TAG, "directInstallDownload", th);
                this.currentDownloadState = null;
                directDownloadListener.onFailure();
            }
        }
    }

    public void collectAppHubData() {
        if (isAppHubInstalled()) {
            if (x.Fn()) {
                this.logger.f(TAG, "Collecting data...");
            }
            if (this.isDirectDownloadEnabled == null && ((Boolean) this.sdk.a(b.aKO)).booleanValue()) {
                this.isDirectDownloadEnabled = this.dataCollector.collectDirectDownloadEnabled(this.appHubService);
            }
            if (this.appHubVersionCode == -1 && ((Boolean) this.sdk.a(b.aKN)).booleanValue()) {
                this.appHubVersionCode = this.dataCollector.collectAppHubVersionCode(this.appHubService);
            }
            if (TextUtils.isEmpty(this.randomUserToken) && ((Boolean) this.sdk.a(b.aKP)).booleanValue()) {
                this.randomUserToken = this.dataCollector.collectRandomUserToken(this.appHubService);
            }
        }
    }

    public void onError(String str, String str2) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.i(TAG, "Encountered error: " + str2);
        }
        DirectDownloadState directDownloadState = this.currentDownloadState;
        if (directDownloadState != null && directDownloadState.errorCallbackInvoked.compareAndSet(false, true)) {
            directDownloadState.listener.onFailure();
            this.currentDownloadState = null;
        }
    }

    public void onAppDetailsShown(String str) {
        if (x.Fn()) {
            this.logger.f(TAG, "App details shown");
        }
        DirectDownloadState directDownloadState = this.currentDownloadState;
        if (directDownloadState != null) {
            directDownloadState.listener.onAppDetailsDisplayed();
        }
    }

    public void onAppDetailsDismissed(String str) {
        if (x.Fn()) {
            this.logger.f(TAG, "App details dismissed");
        }
        DirectDownloadState directDownloadState = this.currentDownloadState;
        if (directDownloadState != null) {
            directDownloadState.listener.onAppDetailsDismissed();
            this.currentDownloadState = null;
        }
    }

    public void onDownloadStarted(String str) {
        if (x.Fn()) {
            this.logger.f(TAG, "Download started");
        }
    }

    private Intent createAppHubServiceIntent() {
        Intent intent = new Intent(SERVICE_INTENT_FILTER_ACTION);
        List<ResolveInfo> queryIntentServices = n.getApplicationContext().getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            String str = queryIntentServices.get(0).serviceInfo.packageName;
            this.appHubPackageName = str;
            intent.setClassName(str, SERVICE_INTENT_CLASS_NAME);
            return intent;
        } else if (!x.Fn()) {
            return null;
        } else {
            this.logger.h(TAG, "App Hub not available");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void bindAppHubService() {
        if (this.currentRetryCount <= 3) {
            if (x.Fn()) {
                this.logger.f(TAG, "Attempting connection to App Hub service...");
            }
            int i = 1;
            this.currentRetryCount++;
            try {
                if (h.Lg()) {
                    i = InputDeviceCompat.SOURCE_DPAD;
                }
                if (!n.getApplicationContext().bindService(this.appHubServiceIntent, new ServiceConnection() {
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        x unused = ArrayService.this.logger;
                        if (x.Fn()) {
                            x access$200 = ArrayService.this.logger;
                            access$200.f(ArrayService.TAG, "Connection successful: " + componentName);
                        }
                        IAppHubService unused2 = ArrayService.this.appHubService = IAppHubService.Stub.asInterface(iBinder);
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        x unused = ArrayService.this.logger;
                        if (x.Fn()) {
                            x access$200 = ArrayService.this.logger;
                            access$200.i(ArrayService.TAG, "Service disconnected: " + componentName);
                        }
                        IAppHubService unused2 = ArrayService.this.appHubService = null;
                        x unused3 = ArrayService.this.logger;
                        if (x.Fn()) {
                            ArrayService.this.logger.i(ArrayService.TAG, "Retrying...");
                        }
                        ArrayService.this.bindAppHubService();
                    }
                }, i) && x.Fn()) {
                    this.logger.h(TAG, "App Hub not available");
                }
            } catch (Throwable th) {
                if (x.Fn()) {
                    this.logger.c(TAG, "Failed to bind to service", th);
                }
            }
        } else if (x.Fn()) {
            this.logger.h(TAG, "Exceeded maximum retry count");
        }
    }
}
