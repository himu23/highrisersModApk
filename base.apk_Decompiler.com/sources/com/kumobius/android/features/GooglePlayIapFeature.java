package com.kumobius.android.features;

import android.app.AlertDialog;
import android.os.Handler;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.kumobius.android.KumoAppActivity;
import com.kumobius.android.Utils;
import com.kumobius.android.features.googleiap.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

public class GooglePlayIapFeature implements IIapFeature, PurchasesUpdatedListener {
    private static final String s_TAG = "KumoInApp";
    /* access modifiers changed from: private */
    public final KumoAppActivity m_Activity;
    private BillingClient m_BillingClient;
    private final Handler m_Handler = new Handler();
    /* access modifiers changed from: private */
    public boolean m_IapAvailable = false;
    /* access modifiers changed from: private */
    public final Map<String, ProductDetails> m_IapDetails = new HashMap();
    /* access modifiers changed from: private */
    public String m_IapError = "";
    /* access modifiers changed from: private */
    public final Object m_IapLock = new Object();
    /* access modifiers changed from: private */
    public int m_IapStatus = 1;
    private final HashSet<String> m_PendingLoadProducts = new HashSet<>();

    public void onDestroy() {
    }

    public GooglePlayIapFeature(KumoAppActivity kumoAppActivity) {
        this.m_Activity = kumoAppActivity;
    }

    public void iapInit() {
        synchronized (this.m_IapLock) {
            try {
                Log.v(s_TAG, "Starting IAP system...");
                BillingClient build = BillingClient.newBuilder(this.m_Activity).setListener(this).enablePendingPurchases().build();
                this.m_BillingClient = build;
                this.m_IapStatus = 1;
                build.startConnection(new OnIabSetupFinishedListener());
            } catch (Exception e) {
                Log.e(s_TAG, "GMS Exception", e);
            }
        }
    }

    private class OnIabSetupFinishedListener implements BillingClientStateListener {
        private OnIabSetupFinishedListener() {
        }

        public void onBillingServiceDisconnected() {
            synchronized (GooglePlayIapFeature.this.m_IapLock) {
                boolean unused = GooglePlayIapFeature.this.m_IapAvailable = false;
                int unused2 = GooglePlayIapFeature.this.m_IapStatus = -1;
                String unused3 = GooglePlayIapFeature.this.m_IapError = "Service Disconnected";
                Log.e(GooglePlayIapFeature.s_TAG, "IAP Disconnected: " + GooglePlayIapFeature.this.m_IapError);
            }
        }

        public void onBillingSetupFinished(BillingResult billingResult) {
            synchronized (GooglePlayIapFeature.this.m_IapLock) {
                if (GooglePlayIapFeature.isSuccess(billingResult)) {
                    boolean unused = GooglePlayIapFeature.this.m_IapAvailable = true;
                    int unused2 = GooglePlayIapFeature.this.m_IapStatus = 0;
                    Log.v(GooglePlayIapFeature.s_TAG, "IAP Connected");
                    GooglePlayIapFeature.this.doRestore(false);
                } else {
                    boolean unused3 = GooglePlayIapFeature.this.m_IapAvailable = false;
                    int unused4 = GooglePlayIapFeature.this.m_IapStatus = -1;
                    String unused5 = GooglePlayIapFeature.this.m_IapError = billingResult.getDebugMessage();
                    Log.e(GooglePlayIapFeature.s_TAG, "IAP Disconnected: " + GooglePlayIapFeature.this.m_IapError);
                }
            }
        }
    }

    public void onStart() {
        doRestore(false);
    }

    public void onResume() {
        doRestore(false);
    }

    public int iapGetStatus() {
        int i;
        synchronized (this.m_IapLock) {
            i = this.m_IapStatus;
        }
        return i;
    }

    public String iapGetError() {
        String str;
        synchronized (this.m_IapLock) {
            str = this.m_IapError;
        }
        return str;
    }

    public void iapLoadProducts(String[] strArr) {
        synchronized (this.m_IapLock) {
            Collections.addAll(this.m_PendingLoadProducts, strArr);
            iapLoadProductsPending();
        }
    }

    /* access modifiers changed from: private */
    public void iapLoadProductsPending() {
        synchronized (this.m_IapLock) {
            if (iapIsAvailable()) {
                Vector vector = new Vector();
                Iterator<String> it = this.m_PendingLoadProducts.iterator();
                while (it.hasNext()) {
                    String lowerCase = it.next().toLowerCase(Locale.US);
                    if (!this.m_IapDetails.containsKey(lowerCase)) {
                        vector.add(QueryProductDetailsParams.Product.newBuilder().setProductId(lowerCase).setProductType("inapp").build());
                    } else {
                        return;
                    }
                }
                this.m_PendingLoadProducts.clear();
                if (vector.size() > 0) {
                    this.m_IapStatus = 1;
                    this.m_Activity.runOnUiThread(new GooglePlayIapFeature$$ExternalSyntheticLambda6(this, vector));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$iapLoadProductsPending$0$com-kumobius-android-features-GooglePlayIapFeature  reason: not valid java name */
    public /* synthetic */ void m39lambda$iapLoadProductsPending$0$comkumobiusandroidfeaturesGooglePlayIapFeature(Vector vector) {
        synchronized (this.m_IapLock) {
            try {
                this.m_BillingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(vector).build(), new QueryProductDetailsResponseListener());
            } catch (Exception e) {
                Log.e(s_TAG, "GMS Exception", e);
            }
        }
    }

    private class QueryProductDetailsResponseListener implements ProductDetailsResponseListener {
        private QueryProductDetailsResponseListener() {
        }

        public void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
            try {
                if (!GooglePlayIapFeature.isSuccess(billingResult) || list == null) {
                    synchronized (GooglePlayIapFeature.this.m_IapLock) {
                        int unused = GooglePlayIapFeature.this.m_IapStatus = -1;
                        String unused2 = GooglePlayIapFeature.this.m_IapError = billingResult.getDebugMessage();
                    }
                    Log.e(GooglePlayIapFeature.s_TAG, "IAP Error: " + GooglePlayIapFeature.this.m_IapError);
                    return;
                }
                try {
                    synchronized (GooglePlayIapFeature.this.m_IapLock) {
                        for (ProductDetails next : list) {
                            Log.v(GooglePlayIapFeature.s_TAG, next.getProductId() + " = " + next.getOneTimePurchaseOfferDetails().getFormattedPrice());
                            GooglePlayIapFeature.this.m_IapDetails.put(next.getProductId(), next);
                        }
                        int unused3 = GooglePlayIapFeature.this.m_IapStatus = 0;
                    }
                } catch (Exception e) {
                    Log.e(GooglePlayIapFeature.s_TAG, "GMS Exception", e);
                }
            } catch (Exception e2) {
                Log.e(GooglePlayIapFeature.s_TAG, "GMS Exception", e2);
            }
        }
    }

    public void iapPurchase(String str) {
        synchronized (this.m_IapLock) {
            if (iapIsAvailable()) {
                String lowerCase = str.toLowerCase(Locale.US);
                this.m_IapStatus = 2;
                ProductDetails productDetails = this.m_IapDetails.get(lowerCase);
                if (productDetails == null) {
                    Log.e(s_TAG, "Unknown SKU: " + lowerCase);
                    return;
                }
                this.m_Activity.runOnUiThread(new GooglePlayIapFeature$$ExternalSyntheticLambda4(this, productDetails));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$iapPurchase$1$com-kumobius-android-features-GooglePlayIapFeature  reason: not valid java name */
    public /* synthetic */ void m40lambda$iapPurchase$1$comkumobiusandroidfeaturesGooglePlayIapFeature(ProductDetails productDetails) {
        synchronized (this.m_IapLock) {
            try {
                Vector vector = new Vector();
                vector.add(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build());
                this.m_BillingClient.launchBillingFlow(this.m_Activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(vector).build());
            } catch (Exception e) {
                Log.e(s_TAG, "GMS Exception", e);
            }
        }
    }

    public boolean iapCanPurchase(String str) {
        boolean containsKey;
        synchronized (this.m_IapLock) {
            containsKey = this.m_IapDetails.containsKey(str.toLowerCase(Locale.US));
        }
        return containsKey;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void onPurchasesUpdated(com.android.billingclient.api.BillingResult r4, java.util.List<com.android.billingclient.api.Purchase> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "IAP Error: "
            r1 = 0
            boolean r2 = isSuccess(r4)     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x000f
            if (r5 == 0) goto L_0x000f
            r3.handlePurchases(r5)     // Catch:{ Exception -> 0x003d }
            goto L_0x0045
        L_0x000f:
            int r5 = r4.getResponseCode()     // Catch:{ Exception -> 0x003d }
            r2 = 1
            if (r5 == r2) goto L_0x0027
            r2 = 7
            if (r5 == r2) goto L_0x0024
            com.kumobius.android.KumoAppActivity r5 = r3.m_Activity     // Catch:{ Exception -> 0x003d }
            com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda5 r2 = new com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda5     // Catch:{ Exception -> 0x003d }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x003d }
            r5.runOnUiThread(r2)     // Catch:{ Exception -> 0x003d }
            goto L_0x0027
        L_0x0024:
            r3.doRestore(r1)     // Catch:{ Exception -> 0x003d }
        L_0x0027:
            java.lang.String r5 = "KumoInApp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = r4.getDebugMessage()     // Catch:{ Exception -> 0x003d }
            r2.append(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x003d }
            android.util.Log.e(r5, r4)     // Catch:{ Exception -> 0x003d }
            goto L_0x0045
        L_0x003d:
            r4 = move-exception
            java.lang.String r5 = "KumoInApp"
            java.lang.String r0 = "GMS Exception"
            android.util.Log.e(r5, r0, r4)
        L_0x0045:
            java.lang.Object r4 = r3.m_IapLock
            monitor-enter(r4)
            r3.m_IapStatus = r1     // Catch:{ all -> 0x004c }
            monitor-exit(r4)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.features.GooglePlayIapFeature.onPurchasesUpdated(com.android.billingclient.api.BillingResult, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onPurchasesUpdated$3$com-kumobius-android-features-GooglePlayIapFeature  reason: not valid java name */
    public /* synthetic */ void m41lambda$onPurchasesUpdated$3$comkumobiusandroidfeaturesGooglePlayIapFeature(BillingResult billingResult) {
        AlertDialog create = new AlertDialog.Builder(this.m_Activity).create();
        create.setButton(-3, "Ok", new GooglePlayIapFeature$$ExternalSyntheticLambda3());
        create.setTitle("Couldn't Make Purchase");
        create.setMessage(billingResult.getDebugMessage());
        create.show();
    }

    public void iapRestore() {
        doRestore(true);
    }

    /* access modifiers changed from: private */
    public void doRestore(boolean z) {
        synchronized (this.m_IapLock) {
            if (iapIsAvailable()) {
                Log.i(s_TAG, "Restoring IAPs...");
                this.m_IapStatus = 2;
                this.m_Handler.postDelayed(new GooglePlayIapFeature$$ExternalSyntheticLambda2(this, z), 1500);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$doRestore$4$com-kumobius-android-features-GooglePlayIapFeature  reason: not valid java name */
    public /* synthetic */ void m38lambda$doRestore$4$comkumobiusandroidfeaturesGooglePlayIapFeature(boolean z) {
        synchronized (this.m_IapLock) {
            try {
                this.m_BillingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), (PurchasesResponseListener) new QueryInventoryFinishedListener(z));
            } catch (Exception e) {
                Log.e(s_TAG, "GMS Exception", e);
            }
        }
    }

    private class QueryInventoryFinishedListener implements PurchasesResponseListener {
        private final boolean m_DialogResult;

        public QueryInventoryFinishedListener(boolean z) {
            this.m_DialogResult = z;
        }

        public void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            try {
                if (GooglePlayIapFeature.isSuccess(billingResult)) {
                    GooglePlayIapFeature.this.handlePurchases(list);
                    if (this.m_DialogResult) {
                        GooglePlayIapFeature.this.m_Activity.runOnUiThread(new GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda2(this, list));
                    }
                } else {
                    if (this.m_DialogResult) {
                        GooglePlayIapFeature.this.m_Activity.runOnUiThread(new GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda3(this, billingResult));
                    }
                    Log.e(GooglePlayIapFeature.s_TAG, "IAP Error: " + billingResult.getDebugMessage());
                }
            } catch (Exception e) {
                Log.e(GooglePlayIapFeature.s_TAG, "GMS Exception", e);
            }
            synchronized (GooglePlayIapFeature.this.m_IapLock) {
                int unused = GooglePlayIapFeature.this.m_IapStatus = 0;
            }
            GooglePlayIapFeature.this.iapLoadProductsPending();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onQueryPurchasesResponse$1$com-kumobius-android-features-GooglePlayIapFeature$QueryInventoryFinishedListener  reason: not valid java name */
        public /* synthetic */ void m42lambda$onQueryPurchasesResponse$1$comkumobiusandroidfeaturesGooglePlayIapFeature$QueryInventoryFinishedListener(List list) {
            AlertDialog create = new AlertDialog.Builder(GooglePlayIapFeature.this.m_Activity).create();
            create.setButton(-3, "Ok", new GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda1());
            create.setTitle(R.string.restorePurchases);
            if (list.size() <= 0) {
                create.setMessage(Utils.getString(GooglePlayIapFeature.this.m_Activity, R.string.restoreNone));
            } else {
                create.setMessage(Utils.getString(GooglePlayIapFeature.this.m_Activity, R.string.restoreOk));
            }
            create.show();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onQueryPurchasesResponse$3$com-kumobius-android-features-GooglePlayIapFeature$QueryInventoryFinishedListener  reason: not valid java name */
        public /* synthetic */ void m43lambda$onQueryPurchasesResponse$3$comkumobiusandroidfeaturesGooglePlayIapFeature$QueryInventoryFinishedListener(BillingResult billingResult) {
            AlertDialog create = new AlertDialog.Builder(GooglePlayIapFeature.this.m_Activity).create();
            create.setButton(-3, "Ok", new GooglePlayIapFeature$QueryInventoryFinishedListener$$ExternalSyntheticLambda0());
            create.setTitle("Couldn't Restore Purchases");
            create.setMessage(billingResult.getDebugMessage());
            create.show();
        }
    }

    public String iapGetName(String str) {
        String title;
        synchronized (this.m_IapLock) {
            ProductDetails productDetails = this.m_IapDetails.get(str.toLowerCase(Locale.US));
            title = productDetails != null ? productDetails.getTitle() : "UNKNOWN";
        }
        return title;
    }

    public String iapGetDescription(String str) {
        String description;
        synchronized (this.m_IapLock) {
            ProductDetails productDetails = this.m_IapDetails.get(str.toLowerCase(Locale.US));
            description = productDetails != null ? productDetails.getDescription() : "UNKNOWN";
        }
        return description;
    }

    public String iapGetPrice(String str) {
        String formattedPrice;
        synchronized (this.m_IapLock) {
            ProductDetails productDetails = this.m_IapDetails.get(str.toLowerCase(Locale.US));
            formattedPrice = productDetails != null ? productDetails.getOneTimePurchaseOfferDetails().getFormattedPrice() : "UNKNOWN";
        }
        return formattedPrice;
    }

    private boolean iapIsAvailable() {
        boolean z;
        synchronized (this.m_IapLock) {
            z = this.m_BillingClient != null && this.m_IapAvailable && this.m_IapStatus <= 0;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        if (r4.equalsIgnoreCase(r9) != false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handlePurchases(java.util.List<com.android.billingclient.api.Purchase> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "KumoInApp"
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0138 }
            r1.<init>()     // Catch:{ Exception -> 0x0138 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0138 }
            r2.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r3.<init>()     // Catch:{ Exception -> 0x0138 }
            int r4 = r13.size()     // Catch:{ Exception -> 0x0138 }
            r3.append(r4)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r4 = " IAP Purchases/Restored"
            r3.append(r4)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0138 }
            android.util.Log.i(r0, r3)     // Catch:{ Exception -> 0x0138 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x0138 }
        L_0x0028:
            boolean r3 = r13.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r13.next()     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.Purchase r3 = (com.android.billingclient.api.Purchase) r3     // Catch:{ Exception -> 0x0138 }
            java.lang.String r4 = r3.getOrderId()     // Catch:{ Exception -> 0x0138 }
            int r5 = r3.getPurchaseState()     // Catch:{ Exception -> 0x0138 }
            r6 = 1
            if (r5 == r6) goto L_0x0054
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r3.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r5 = "Purchase still pending "
            r3.append(r5)     // Catch:{ Exception -> 0x0138 }
            r3.append(r4)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0138 }
            android.util.Log.e(r0, r3)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0028
        L_0x0054:
            java.util.ArrayList r5 = r3.getSkus()     // Catch:{ Exception -> 0x0138 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0138 }
            r7 = 0
        L_0x005d:
            boolean r8 = r5.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r8 == 0) goto L_0x00a1
            java.lang.Object r8 = r5.next()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0138 }
            java.lang.String r9 = ""
            if (r4 == 0) goto L_0x0073
            boolean r10 = r4.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0138 }
            if (r10 == 0) goto L_0x0074
        L_0x0073:
            r4 = r8
        L_0x0074:
            com.kumobius.android.KumoAppActivity r10 = r12.m_Activity     // Catch:{ Exception -> 0x0138 }
            int r10 = com.kumobius.android.NativeInterface.iapComplete(r10, r4, r8)     // Catch:{ Exception -> 0x0138 }
            if (r10 == 0) goto L_0x007d
            r7 = 1
        L_0x007d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r10.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r11 = "IAP Purchases/Restored: "
            r10.append(r11)     // Catch:{ Exception -> 0x0138 }
            r10.append(r8)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r8 = " - "
            r10.append(r8)     // Catch:{ Exception -> 0x0138 }
            r10.append(r4)     // Catch:{ Exception -> 0x0138 }
            if (r7 == 0) goto L_0x0096
            java.lang.String r9 = " (consumable"
        L_0x0096:
            r10.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0138 }
            android.util.Log.i(r0, r8)     // Catch:{ Exception -> 0x0138 }
            goto L_0x005d
        L_0x00a1:
            if (r7 == 0) goto L_0x00a7
            r1.add(r3)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0028
        L_0x00a7:
            boolean r4 = r3.isAcknowledged()     // Catch:{ Exception -> 0x0138 }
            if (r4 != 0) goto L_0x0028
            r2.add(r3)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0028
        L_0x00b2:
            java.util.Iterator r13 = r1.iterator()     // Catch:{ Exception -> 0x0138 }
        L_0x00b6:
            boolean r1 = r13.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r1 == 0) goto L_0x00f5
            java.lang.Object r1 = r13.next()     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.Purchase r1 = (com.android.billingclient.api.Purchase) r1     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r3.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r4 = "Consuming Purchase: "
            r3.append(r4)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r4 = r1.getPurchaseToken()     // Catch:{ Exception -> 0x0138 }
            r3.append(r4)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0138 }
            android.util.Log.i(r0, r3)     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.BillingClient r3 = r12.m_BillingClient     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.ConsumeParams$Builder r4 = com.android.billingclient.api.ConsumeParams.newBuilder()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r1 = r1.getPurchaseToken()     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.ConsumeParams$Builder r1 = r4.setPurchaseToken(r1)     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.ConsumeParams r1 = r1.build()     // Catch:{ Exception -> 0x0138 }
            com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda0 r4 = new com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0138 }
            r4.<init>()     // Catch:{ Exception -> 0x0138 }
            r3.consumeAsync(r1, r4)     // Catch:{ Exception -> 0x0138 }
            goto L_0x00b6
        L_0x00f5:
            java.util.Iterator r13 = r2.iterator()     // Catch:{ Exception -> 0x0138 }
        L_0x00f9:
            boolean r1 = r13.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r1 == 0) goto L_0x013e
            java.lang.Object r1 = r13.next()     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.Purchase r1 = (com.android.billingclient.api.Purchase) r1     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r2.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = "Acknowledging Purchase: "
            r2.append(r3)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = r1.getPurchaseToken()     // Catch:{ Exception -> 0x0138 }
            r2.append(r3)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0138 }
            android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.BillingClient r2 = r12.m_BillingClient     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.AcknowledgePurchaseParams$Builder r3 = com.android.billingclient.api.AcknowledgePurchaseParams.newBuilder()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r4 = r1.getPurchaseToken()     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.AcknowledgePurchaseParams$Builder r3 = r3.setPurchaseToken(r4)     // Catch:{ Exception -> 0x0138 }
            com.android.billingclient.api.AcknowledgePurchaseParams r3 = r3.build()     // Catch:{ Exception -> 0x0138 }
            com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda1 r4 = new com.kumobius.android.features.GooglePlayIapFeature$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x0138 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0138 }
            r2.acknowledgePurchase(r3, r4)     // Catch:{ Exception -> 0x0138 }
            goto L_0x00f9
        L_0x0138:
            r13 = move-exception
            java.lang.String r1 = "GMS Exception"
            android.util.Log.e(r0, r1, r13)
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.features.GooglePlayIapFeature.handlePurchases(java.util.List):void");
    }

    static /* synthetic */ void lambda$handlePurchases$5(BillingResult billingResult, String str) {
        if (isSuccess(billingResult)) {
            Log.i(s_TAG, "IAP Purchase Consumed: " + str);
            return;
        }
        Log.e(s_TAG, "Failed to Consume Purchase: " + str);
    }

    static /* synthetic */ void lambda$handlePurchases$6(Purchase purchase, BillingResult billingResult) {
        if (isSuccess(billingResult)) {
            Log.i(s_TAG, "IAP Purchase Acknowledged: " + purchase.getPurchaseToken());
            return;
        }
        Log.e(s_TAG, "Failed to Acknowledge Purchase: " + purchase.getPurchaseToken());
    }

    /* access modifiers changed from: private */
    public static boolean isSuccess(BillingResult billingResult) {
        return billingResult != null && billingResult.getResponseCode() == 0;
    }
}
