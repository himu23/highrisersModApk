package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.bb;
import com.ironsource.environment.ContextProvider;
import com.ironsource.h7;
import com.ironsource.jc;
import com.ironsource.m2;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n9;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.SSAFactory;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.tb;
import com.ironsource.w9;
import com.ironsource.y2;
import com.ironsource.z3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class SupersonicAdsAdapter extends AbstractAdapter implements n9, w9, ContextProvider.a {
    private static final String VERSION = "7.6.1";
    /* access modifiers changed from: private */
    public static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static AtomicBoolean mDidSetInitParams = new AtomicBoolean(false);
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String DYNAMIC_CONTROLLER_CONFIG = m2.i.M;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = m2.d.c;
    private final String DYNAMIC_CONTROLLER_URL = tb.b;
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_SIGNATURE = "itemSignature";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String OW_PLACEMENT_ID = m2.i;
    private final String SDK_PLUGIN_TYPE = jc.g1;
    private final String SESSION_ID = z3.g;
    private final String TIMESTAMP = y2.a.d;
    /* access modifiers changed from: private */
    public boolean mConsent;
    /* access modifiers changed from: private */
    public boolean mDidSetConsent;
    /* access modifiers changed from: private */
    public h7 mOfferwallListener;
    /* access modifiers changed from: private */
    public bb mSSAPublisher;

    private SupersonicAdsAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose("");
        ContextProvider.getInstance().registerLifeCycleListener(this);
    }

    private void addItemNameCountSignature(HashMap<String, String> hashMap, JSONObject jSONObject) {
        boolean z;
        try {
            String optString = jSONObject.optString("itemName");
            int optInt = jSONObject.optInt("itemCount", -1);
            String optString2 = jSONObject.optString("privateKey");
            boolean z2 = false;
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                hashMap.put("itemName", optString);
                z = true;
            }
            if (!TextUtils.isEmpty(optString2)) {
                z2 = z;
            }
            if (optInt != -1) {
                hashMap.put("itemCount", String.valueOf(optInt));
                if (z2) {
                    int currentTimestamp = IronSourceUtils.getCurrentTimestamp();
                    hashMap.put(y2.a.d, String.valueOf(currentTimestamp));
                    hashMap.put("itemSignature", createItemSig(currentTimestamp, optString, optInt, optString2));
                }
            }
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error(" addItemNameCountSignature" + e);
        }
    }

    /* access modifiers changed from: private */
    public void applyConsent(boolean z) {
        if (this.mSSAPublisher != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(m2.i.Z, String.valueOf(z));
                jSONObject.put("demandSourceName", getProviderName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mSSAPublisher.a(jSONObject);
        }
    }

    private String createItemSig(int i, String str, int i2, String str2) {
        return IronSourceUtils.getMD5(i + str + i2 + str2);
    }

    public static String getAdapterSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    private HashMap<String, String> getGenenralExtraParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(jc.g1, pluginType);
        }
        return hashMap;
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(jc.g1, pluginType);
        }
        if (!TextUtils.isEmpty(p.o().t())) {
            hashMap.put(z3.g, p.o().t());
        }
        return hashMap;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData(IronSourceConstants.SUPERSONIC_CONFIG_NAME, "7.6.1");
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String optString = jSONObject.optString("language");
        if (!TextUtils.isEmpty(optString)) {
            genenralExtraParams.put("language", optString);
        }
        genenralExtraParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            genenralExtraParams.putAll(offerwallCustomParams);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        return genenralExtraParams;
    }

    private void setParamsBeforeInit(JSONObject jSONObject) {
        if (mDidSetInitParams.compareAndSet(false, true)) {
            SDKUtils.setControllerUrl(jSONObject.optString(tb.b));
            int optInt = jSONObject.optInt(m2.d.c, 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            SDKUtils.setDebugMode(optInt);
            JSONObject optJSONObject = jSONObject.optJSONObject(m2.i.M);
            String jSONObject2 = optJSONObject != null ? optJSONObject.toString() : "";
            SDKUtils.setControllerConfig(jSONObject2);
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + "setting controller url to " + jSONObject.optString(tb.b));
            ironLog.verbose(getProviderName() + "setting controller config to " + jSONObject2);
            ironLog.verbose(getProviderName() + "setting debug mode to " + optInt);
        }
    }

    public static SupersonicAdsAdapter startAdapter(String str) {
        return new SupersonicAdsAdapter(str);
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        IronSourceUtils.sendAutomationLog(getProviderName() + ": earlyInit");
        if (mDidInitSdk.compareAndSet(false, true)) {
            SDKUtils.setDebugMode(isAdaptersDebugEnabled() ? 3 : jSONObject.optInt(m2.d.c, 0));
            SDKUtils.setControllerUrl(jSONObject.optString(tb.b));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " IronSourceNetwork setting controller url to  " + jSONObject.optString(tb.b));
            SDKUtils.setControllerConfig(jSONObject.optString(m2.i.M, ""));
            ironLog.verbose(getProviderName() + " IronSourceNetwork setting controller config to  " + jSONObject.optString(m2.i.M));
            HashMap<String, String> initParams = getInitParams();
            IronSourceNetwork.initSDK(ContextProvider.getInstance().getApplicationContext(), p.o().p(), str2, initParams);
            ironLog.verbose("initSDK with appKey=" + p.o().p() + " userId=" + str2 + " parameters " + initParams);
        }
    }

    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    public void getOfferwallCredits() {
        if (this.mSSAPublisher != null) {
            p.o().p();
            String q = p.o().q();
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.getOfferWallCredits userId=" + q);
            this.mSSAPublisher.a(p.o().p(), q, (w9) this);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling getOfferwallCredits");
    }

    public String getVersion() {
        return "7.6.1";
    }

    public void initOfferwall(String str, final String str2, final JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " userId=" + str2);
        setParamsBeforeInit(jSONObject);
        AbstractAdapter.postOnUIThread(new Runnable() {
            public void run() {
                try {
                    HashMap access$000 = SupersonicAdsAdapter.this.getOfferwallExtraParams(jSONObject);
                    bb unused = SupersonicAdsAdapter.this.mSSAPublisher = SSAFactory.getPublisherInstance(ContextProvider.getInstance().getCurrentActiveActivity());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                        supersonicAdsAdapter.applyConsent(supersonicAdsAdapter.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initOfferWall");
                    SupersonicAdsAdapter.this.mSSAPublisher.a(p.o().p(), str2, access$000, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.error(SupersonicAdsAdapter.this.getProviderName() + ":initOfferwall(userId:" + str2 + ")" + e);
                    h7 access$600 = SupersonicAdsAdapter.this.mOfferwallListener;
                    StringBuilder sb = new StringBuilder("Adapter initialization failure - ");
                    sb.append(SupersonicAdsAdapter.this.getProviderName());
                    sb.append(" - ");
                    sb.append(e.getMessage());
                    access$600.a(false, ErrorBuilder.buildInitFailedError(sb.toString(), IronSourceConstants.OFFERWALL_AD_UNIT));
                }
            }
        });
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onGetOfferwallCreditsFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        h7 h7Var = this.mOfferwallListener;
        if (h7Var != null) {
            h7Var.onOfferwallClosed();
        }
    }

    public boolean onOWAdCredited(int i, int i2, boolean z) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        h7 h7Var = this.mOfferwallListener;
        return h7Var != null && h7Var.onOfferwallAdCredited(i, i2, z);
    }

    public void onOWShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onOfferwallShowFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOWShowSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        } else {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
        }
        h7 h7Var = this.mOfferwallListener;
        if (h7Var != null) {
            h7Var.onOfferwallOpened();
        }
    }

    public void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        }
    }

    public void onOfferwallInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.a(false, ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOfferwallInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        h7 h7Var = this.mOfferwallListener;
        if (h7Var != null) {
            h7Var.onOfferwallAvailable(true);
        }
    }

    public void onPause(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onPause");
            this.mSSAPublisher.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onResume");
            this.mSSAPublisher.onResume(activity);
        }
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": setConsent (");
        sb.append(z ? "true" : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        this.mDidSetConsent = true;
        this.mConsent = z;
        applyConsent(z);
    }

    public void setInternalOfferwallListener(h7 h7Var) {
        this.mOfferwallListener = h7Var;
    }

    /* access modifiers changed from: protected */
    public void setMetaData(String str, List<String> list) {
        if (!list.isEmpty()) {
            String str2 = list.get(0);
            if (!mDidInitSdk.get()) {
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("key=" + str + ", value=" + str2);
                if (!MetaDataUtils.isValidCCPAMetaData(str, str2)) {
                    ironLog.verbose("not valid");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(str, str2);
                    IronSourceNetwork.updateMetadata(jSONObject);
                } catch (JSONException e) {
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.error("error - " + e);
                    e.printStackTrace();
                }
            }
        }
    }

    public void showOfferwall(String str, JSONObject jSONObject) {
        HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams(jSONObject);
        if (offerwallExtraParams != null) {
            offerwallExtraParams.put(m2.i, str);
        }
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showOfferWall");
            this.mSSAPublisher.a(ContextProvider.getInstance().getCurrentActiveActivity(), offerwallExtraParams);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling showOfferwall");
    }
}
