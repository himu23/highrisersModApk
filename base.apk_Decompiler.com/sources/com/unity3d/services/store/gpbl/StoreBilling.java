package com.unity3d.services.store.gpbl;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientBuilderFactory;
import com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import com.unity3d.services.store.listeners.IPurchaseHistoryResponseListener;
import com.unity3d.services.store.listeners.IPurchaseUpdatedResponseListener;
import com.unity3d.services.store.listeners.IPurchasesResponseListener;
import com.unity3d.services.store.listeners.ISkuDetailsResponseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class StoreBilling {
    private final IBillingClient _billingClientBridge;

    public StoreBilling(Context context, IPurchaseUpdatedResponseListener iPurchaseUpdatedResponseListener) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this._billingClientBridge = BillingClientBuilderFactory.getBillingClientBuilder(context).setListener(new PurchaseUpdatedListenerProxy(iPurchaseUpdatedResponseListener)).enablePendingPurchases().build();
    }

    public void initialize(IBillingClientStateListener iBillingClientStateListener) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this._billingClientBridge.startConnection(new BillingClientStateListenerProxy(iBillingClientStateListener));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int isFeatureSupported(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "inapp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0011
            com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient r2 = r1._billingClientBridge
            boolean r2 = r2.isReady()
            if (r2 == 0) goto L_0x0027
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "subs"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x001b
            java.lang.String r2 = "subscriptions"
        L_0x001b:
            com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient r0 = r1._billingClientBridge
            com.unity3d.services.store.gpbl.BillingResultResponseCode r2 = r0.isFeatureSupported(r2)
            com.unity3d.services.store.gpbl.BillingResultResponseCode r0 = com.unity3d.services.store.gpbl.BillingResultResponseCode.OK
            if (r2 != r0) goto L_0x0027
        L_0x0025:
            r2 = 0
            goto L_0x0028
        L_0x0027:
            r2 = -1
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.store.gpbl.StoreBilling.isFeatureSupported(java.lang.String):int");
    }

    public void getPurchases(String str, IPurchasesResponseListener iPurchasesResponseListener) throws ClassNotFoundException {
        this._billingClientBridge.queryPurchasesAsync(str, new PurchasesResponseListenerProxy(iPurchasesResponseListener));
    }

    public void getSkuDetails(String str, ArrayList<String> arrayList, ISkuDetailsResponseListener iSkuDetailsResponseListener) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this._billingClientBridge.querySkuDetailsAsync(SkuDetailsParamsBridge.newBuilder().setSkuList(arrayList).setType(str).build(), new SkuDetailsResponseListenerProxy(iSkuDetailsResponseListener));
    }

    public void getPurchaseHistory(String str, int i, IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener) throws ClassNotFoundException {
        this._billingClientBridge.queryPurchaseHistoryAsync(str, new PurchaseHistoryResponseListenerProxy(iPurchaseHistoryResponseListener, i));
    }
}
