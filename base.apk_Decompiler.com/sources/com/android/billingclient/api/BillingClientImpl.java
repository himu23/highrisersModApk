package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import androidx.work.WorkRequest;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzin;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zzm;
import com.google.android.gms.internal.play_billing.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
class BillingClientImpl extends BillingClient {
    private ExecutorService zzA;
    /* access modifiers changed from: private */
    public volatile int zza;
    private final String zzb;
    private final Handler zzc;
    /* access modifiers changed from: private */
    public volatile zzh zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public zzbi zzf;
    /* access modifiers changed from: private */
    public volatile zzm zzg;
    private volatile zzao zzh;
    /* access modifiers changed from: private */
    public boolean zzi;
    /* access modifiers changed from: private */
    public boolean zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    /* access modifiers changed from: private */
    public boolean zzm;
    /* access modifiers changed from: private */
    public boolean zzn;
    /* access modifiers changed from: private */
    public boolean zzo;
    /* access modifiers changed from: private */
    public boolean zzp;
    /* access modifiers changed from: private */
    public boolean zzq;
    /* access modifiers changed from: private */
    public boolean zzr;
    /* access modifiers changed from: private */
    public boolean zzs;
    /* access modifiers changed from: private */
    public boolean zzt;
    /* access modifiers changed from: private */
    public boolean zzu;
    /* access modifiers changed from: private */
    public boolean zzv;
    /* access modifiers changed from: private */
    public boolean zzw;
    /* access modifiers changed from: private */
    public boolean zzx;
    private zzbx zzy;
    private boolean zzz;

    private BillingClientImpl(Activity activity, zzbx zzbx, String str) {
        this(activity.getApplicationContext(), zzbx, new zzba(), str, (String) null, (UserChoiceBillingListener) null, (zzbi) null, (ExecutorService) null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbx, AlternativeBillingListener alternativeBillingListener, String str, zzbi zzbi) {
        this.zze = context.getApplicationContext();
        zzin zzv2 = zzio.zzv();
        zzv2.zzj(str);
        zzv2.zzi(this.zze.getPackageName());
        if (zzbi != null) {
            this.zzf = zzbi;
        } else {
            this.zzf = new zzbn(this.zze, (zzio) zzv2.zzc());
        }
        if (purchasesUpdatedListener == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, alternativeBillingListener, this.zzf);
        this.zzy = zzbx;
        this.zzz = alternativeBillingListener != null;
        this.zze.getPackageName();
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        zzba zzba = new zzba(j);
        if (isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            zzba.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzbh.zza(37, 6, zzbk.zzd));
            zzba.onBillingSetupFinished(zzbk.zzd);
        } else if (this.zza == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzbh.zza(38, 6, zzbk.zzm));
            zzba.onBillingSetupFinished(zzbk.zzm);
        } else {
            this.zza = 1;
            zzb.zzj("BillingClient", "Starting in-app billing setup.");
            this.zzh = new zzao(this, zzba, (zzan) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                i = 41;
            } else {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                        i = 40;
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("playBillingLibraryVersion", this.zzb);
                        if (this.zze.bindService(intent2, this.zzh, 1)) {
                            zzb.zzj("BillingClient", "Service was bonded successfully.");
                            return;
                        } else {
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            i = 39;
                        }
                    }
                }
            }
            this.zza = 0;
            zzb.zzj("BillingClient", "Billing service unavailable on device.");
            this.zzf.zza(zzbh.zza(i, 6, zzbk.zzc));
            zzba.onBillingSetupFinished(zzbk.zzc);
        }
    }

    static /* synthetic */ zzce zzX(BillingClientImpl billingClientImpl, String str, int i) {
        Bundle bundle;
        BillingClientImpl billingClientImpl2 = billingClientImpl;
        zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        Bundle zzd2 = zzb.zzd(billingClientImpl2.zzn, billingClientImpl2.zzv, true, false, billingClientImpl2.zzb);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                if (billingClientImpl2.zzn) {
                    bundle = billingClientImpl2.zzg.zzj(z != billingClientImpl2.zzv ? 9 : 19, billingClientImpl2.zze.getPackageName(), str, str2, zzd2);
                    String str3 = str;
                } else {
                    bundle = billingClientImpl2.zzg.zzi(3, billingClientImpl2.zze.getPackageName(), str, str2);
                }
                zzcf zza2 = zzcg.zza(bundle, "BillingClient", "getPurchase()");
                BillingResult zza3 = zza2.zza();
                if (zza3 != zzbk.zzl) {
                    billingClientImpl2.zzf.zza(zzbh.zza(zza2.zzb(), 9, zza3));
                    return new zzce(zza3, list);
                }
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i2 = 0;
                boolean z2 = false;
                while (i2 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i2);
                    String str5 = stringArrayList3.get(i2);
                    zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Purchase purchase = new Purchase(str4, str5);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z2 = true;
                        }
                        arrayList.add(purchase);
                        i2++;
                    } catch (JSONException e) {
                        zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl2.zzf.zza(zzbh.zza(51, 9, zzbk.zzj));
                        return new zzce(zzbk.zzj, (List) null);
                    }
                }
                if (z2) {
                    billingClientImpl2.zzf.zza(zzbh.zza(26, 9, zzbk.zzj));
                }
                str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzce(zzbk.zzl, arrayList);
                }
                list = null;
                z = true;
            } catch (Exception e2) {
                billingClientImpl2.zzf.zza(zzbh.zza(52, 9, zzbk.zzm));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new zzce(zzbk.zzm, (List) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Handler zzY() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzZ(BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new zzj(this, billingResult));
        return billingResult;
    }

    private static String zzab() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get((Object) null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* access modifiers changed from: private */
    public final Future zzac(Callable callable, long j, Runnable runnable, Handler handler) {
        if (this.zzA == null) {
            this.zzA = Executors.newFixedThreadPool(zzb.zza, new zzag(this));
        }
        try {
            Future submit = this.zzA.submit(callable);
            handler.postDelayed(new zzn(submit, runnable), (long) (((double) j) * 0.95d));
            return submit;
        } catch (Exception e) {
            zzb.zzl("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    private final void zzad(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 11, zzbk.zzm));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbk.zzm, (List<PurchaseHistoryRecord>) null);
            return;
        }
        if (zzac(new zzai(this, str, purchaseHistoryResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzy(this, purchaseHistoryResponseListener), zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 11, zzaa));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzaa, (List<PurchaseHistoryRecord>) null);
        }
    }

    private final void zzae(String str, PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 9, zzbk.zzm));
            purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzm, zzaf.zzk());
        } else if (TextUtils.isEmpty(str)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            this.zzf.zza(zzbh.zza(50, 9, zzbk.zzg));
            purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzg, zzaf.zzk());
        } else {
            if (zzac(new zzah(this, str, purchasesResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzs(this, purchasesResponseListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 9, zzaa));
                purchasesResponseListener.onQueryPurchasesResponse(zzaa, zzaf.zzk());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.play_billing.zzic} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.google.android.gms.internal.play_billing.zzhy} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaf(com.android.billingclient.api.BillingResult r9, int r10, int r11) {
        /*
            r8 = this;
            int r0 = r9.getResponseCode()
            r1 = 0
            java.lang.String r2 = "Unable to create logging payload"
            java.lang.String r3 = "BillingLogger"
            r4 = 5
            if (r0 == 0) goto L_0x004d
            com.android.billingclient.api.zzbi r0 = r8.zzf
            com.google.android.gms.internal.play_billing.zzhx r5 = com.google.android.gms.internal.play_billing.zzhy.zzv()     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zzie r6 = com.google.android.gms.internal.play_billing.zzii.zzv()     // Catch:{ Exception -> 0x0045 }
            int r7 = r9.getResponseCode()     // Catch:{ Exception -> 0x0045 }
            r6.zzk(r7)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r9 = r9.getDebugMessage()     // Catch:{ Exception -> 0x0045 }
            r6.zzj(r9)     // Catch:{ Exception -> 0x0045 }
            r6.zzl(r10)     // Catch:{ Exception -> 0x0045 }
            r5.zzi(r6)     // Catch:{ Exception -> 0x0045 }
            r5.zzk(r4)     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zziq r9 = com.google.android.gms.internal.play_billing.zzis.zzv()     // Catch:{ Exception -> 0x0045 }
            r9.zzi(r11)     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zzex r9 = r9.zzc()     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zzis r9 = (com.google.android.gms.internal.play_billing.zzis) r9     // Catch:{ Exception -> 0x0045 }
            r5.zzj(r9)     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zzex r9 = r5.zzc()     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.play_billing.zzhy r9 = (com.google.android.gms.internal.play_billing.zzhy) r9     // Catch:{ Exception -> 0x0045 }
            r1 = r9
            goto L_0x0049
        L_0x0045:
            r9 = move-exception
            com.google.android.gms.internal.play_billing.zzb.zzl(r3, r2, r9)
        L_0x0049:
            r0.zza(r1)
            return
        L_0x004d:
            com.android.billingclient.api.zzbi r9 = r8.zzf
            com.google.android.gms.internal.play_billing.zzib r10 = com.google.android.gms.internal.play_billing.zzic.zzv()     // Catch:{ Exception -> 0x006e }
            r10.zzj(r4)     // Catch:{ Exception -> 0x006e }
            com.google.android.gms.internal.play_billing.zziq r0 = com.google.android.gms.internal.play_billing.zzis.zzv()     // Catch:{ Exception -> 0x006e }
            r0.zzi(r11)     // Catch:{ Exception -> 0x006e }
            com.google.android.gms.internal.play_billing.zzex r11 = r0.zzc()     // Catch:{ Exception -> 0x006e }
            com.google.android.gms.internal.play_billing.zzis r11 = (com.google.android.gms.internal.play_billing.zzis) r11     // Catch:{ Exception -> 0x006e }
            r10.zzi(r11)     // Catch:{ Exception -> 0x006e }
            com.google.android.gms.internal.play_billing.zzex r10 = r10.zzc()     // Catch:{ Exception -> 0x006e }
            com.google.android.gms.internal.play_billing.zzic r10 = (com.google.android.gms.internal.play_billing.zzic) r10     // Catch:{ Exception -> 0x006e }
            r1 = r10
            goto L_0x0072
        L_0x006e:
            r10 = move-exception
            com.google.android.gms.internal.play_billing.zzb.zzl(r3, r2, r10)
        L_0x0072:
            r9.zzb(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzaf(com.android.billingclient.api.BillingResult, int, int):void");
    }

    static /* synthetic */ zzaz zzg(BillingClientImpl billingClientImpl, String str) {
        BillingClientImpl billingClientImpl2 = billingClientImpl;
        zzb.zzj("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzd2 = zzb.zzd(billingClientImpl2.zzn, billingClientImpl2.zzv, true, false, billingClientImpl2.zzb);
        String str2 = null;
        while (billingClientImpl2.zzl) {
            try {
                Bundle zzh2 = billingClientImpl2.zzg.zzh(6, billingClientImpl2.zze.getPackageName(), str, str2, zzd2);
                zzcf zza2 = zzcg.zza(zzh2, "BillingClient", "getPurchaseHistory()");
                BillingResult zza3 = zza2.zza();
                if (zza3 != zzbk.zzl) {
                    billingClientImpl2.zzf.zza(zzbh.zza(zza2.zzb(), 11, zza3));
                    return new zzaz(zza3, (List) null);
                }
                ArrayList<String> stringArrayList = zzh2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzh2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzh2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i = 0;
                boolean z = false;
                while (i < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    zzb.zzj("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                        i++;
                    } catch (JSONException e) {
                        zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl2.zzf.zza(zzbh.zza(51, 11, zzbk.zzj));
                        return new zzaz(zzbk.zzj, (List) null);
                    }
                }
                if (z) {
                    billingClientImpl2.zzf.zza(zzbh.zza(26, 11, zzbk.zzj));
                }
                str2 = zzh2.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzaz(zzbk.zzl, arrayList);
                }
            } catch (RemoteException e2) {
                zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", e2);
                billingClientImpl2.zzf.zza(zzbh.zza(59, 11, zzbk.zzm));
                return new zzaz(zzbk.zzm, (List) null);
            }
        }
        zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzaz(zzbk.zzq, (List) null);
    }

    public final void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 3, zzbk.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzm);
        } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            this.zzf.zza(zzbh.zza(26, 3, zzbk.zzi));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzi);
        } else if (!this.zzn) {
            this.zzf.zza(zzbh.zza(27, 3, zzbk.zzb));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzb);
        } else {
            if (zzac(new zzaf(this, acknowledgePurchaseParams, acknowledgePurchaseResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzk(this, acknowledgePurchaseResponseListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 3, zzaa));
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaa);
            }
        }
    }

    public final void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 4, zzbk.zzm));
            consumeResponseListener.onConsumeResponse(zzbk.zzm, consumeParams.getPurchaseToken());
            return;
        }
        if (zzac(new zzw(this, consumeParams, consumeResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzx(this, consumeResponseListener, consumeParams), zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 4, zzaa));
            consumeResponseListener.onConsumeResponse(zzaa, consumeParams.getPurchaseToken());
        }
    }

    public final void createAlternativeBillingOnlyReportingDetailsAsync(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 15, zzbk.zzm));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzm, (AlternativeBillingOnlyReportingDetails) null);
        } else if (!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 15, zzbk.zzD));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzD, (AlternativeBillingOnlyReportingDetails) null);
        } else {
            if (zzac(new zzo(this, alternativeBillingOnlyReportingDetailsListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzp(this, alternativeBillingOnlyReportingDetailsListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 15, zzaa));
                alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzaa, (AlternativeBillingOnlyReportingDetails) null);
            }
        }
    }

    public final void endConnection() {
        this.zzf.zzb(zzbh.zzb(12));
        try {
            if (this.zzd != null) {
                this.zzd.zze();
            }
            if (this.zzh != null) {
                this.zzh.zzc();
            }
            if (!(this.zzh == null || this.zzg == null)) {
                zzb.zzj("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService = this.zzA;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzA = null;
            }
        } catch (Exception e) {
            zzb.zzl("BillingClient", "There was an exception while ending connection!", e);
        } catch (Throwable th) {
            this.zza = 3;
            throw th;
        }
        this.zza = 3;
    }

    public final void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            this.zzf.zza(zzbh.zza(2, 13, zzbk.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzm, (BillingConfig) null);
        } else if (!this.zzu) {
            zzb.zzk("BillingClient", "Current client doesn't support get billing config.");
            this.zzf.zza(zzbh.zza(32, 13, zzbk.zzz));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzz, (BillingConfig) null);
        } else {
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            if (zzac(new zzl(this, bundle, billingConfigResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzm(this, billingConfigResponseListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 13, zzaa));
                billingConfigResponseListener.onBillingConfigResponse(zzaa, (BillingConfig) null);
            }
        }
    }

    public final int getConnectionState() {
        return this.zza;
    }

    public final void isAlternativeBillingOnlyAvailableAsync(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 14, zzbk.zzm));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzm);
        } else if (!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 14, zzbk.zzD));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzD);
        } else {
            if (zzac(new zzt(this, alternativeBillingOnlyAvailabilityListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzv(this, alternativeBillingOnlyAvailabilityListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 14, zzaa));
                alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzaa);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.android.billingclient.api.BillingResult isFeatureSupported(java.lang.String r14) {
        /*
            r13 = this;
            boolean r0 = r13.isReady()
            r1 = 2
            r2 = 5
            if (r0 != 0) goto L_0x0026
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzm
            int r0 = r14.getResponseCode()
            if (r0 == 0) goto L_0x001a
            com.android.billingclient.api.zzbi r0 = r13.zzf
            com.google.android.gms.internal.play_billing.zzhy r14 = com.android.billingclient.api.zzbh.zza(r1, r2, r14)
            r0.zza(r14)
            goto L_0x0023
        L_0x001a:
            com.android.billingclient.api.zzbi r14 = r13.zzf
            com.google.android.gms.internal.play_billing.zzic r0 = com.android.billingclient.api.zzbh.zzb(r2)
            r14.zzb(r0)
        L_0x0023:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzm
            return r14
        L_0x0026:
            int r0 = com.android.billingclient.api.zzbk.zzF
            int r0 = r14.hashCode()
            r3 = 12
            r4 = 11
            r5 = 8
            r6 = 7
            r7 = 6
            r8 = 3
            r9 = 4
            r10 = 1
            r11 = 10
            r12 = 9
            switch(r0) {
                case -422092961: goto L_0x00c0;
                case 96321: goto L_0x00b6;
                case 97314: goto L_0x00ac;
                case 98307: goto L_0x00a2;
                case 99300: goto L_0x0098;
                case 100293: goto L_0x008e;
                case 101286: goto L_0x0083;
                case 102279: goto L_0x0078;
                case 103272: goto L_0x006d;
                case 104265: goto L_0x0062;
                case 105258: goto L_0x0056;
                case 207616302: goto L_0x004b;
                case 1987365622: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x00ca
        L_0x0040:
            java.lang.String r0 = "subscriptions"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 0
            goto L_0x00cb
        L_0x004b:
            java.lang.String r0 = "priceChangeConfirmation"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 2
            goto L_0x00cb
        L_0x0056:
            java.lang.String r0 = "jjj"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 12
            goto L_0x00cb
        L_0x0062:
            java.lang.String r0 = "iii"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 11
            goto L_0x00cb
        L_0x006d:
            java.lang.String r0 = "hhh"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 10
            goto L_0x00cb
        L_0x0078:
            java.lang.String r0 = "ggg"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 9
            goto L_0x00cb
        L_0x0083:
            java.lang.String r0 = "fff"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 8
            goto L_0x00cb
        L_0x008e:
            java.lang.String r0 = "eee"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 7
            goto L_0x00cb
        L_0x0098:
            java.lang.String r0 = "ddd"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 5
            goto L_0x00cb
        L_0x00a2:
            java.lang.String r0 = "ccc"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 6
            goto L_0x00cb
        L_0x00ac:
            java.lang.String r0 = "bbb"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 3
            goto L_0x00cb
        L_0x00b6:
            java.lang.String r0 = "aaa"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 4
            goto L_0x00cb
        L_0x00c0:
            java.lang.String r0 = "subscriptionsUpdate"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00ca
            r0 = 1
            goto L_0x00cb
        L_0x00ca:
            r0 = -1
        L_0x00cb:
            switch(r0) {
                case 0: goto L_0x019d;
                case 1: goto L_0x0190;
                case 2: goto L_0x0181;
                case 3: goto L_0x0172;
                case 4: goto L_0x0163;
                case 5: goto L_0x0154;
                case 6: goto L_0x0145;
                case 7: goto L_0x0136;
                case 8: goto L_0x0127;
                case 9: goto L_0x0118;
                case 10: goto L_0x0109;
                case 11: goto L_0x00f8;
                case 12: goto L_0x00e7;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r0 = "BillingClient"
            java.lang.String r1 = "Unsupported feature: "
            java.lang.String r14 = r1.concat(r14)
            com.google.android.gms.internal.play_billing.zzb.zzk(r0, r14)
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzy
            r0 = 34
            r13.zzaf(r14, r0, r10)
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzy
            return r14
        L_0x00e7:
            boolean r14 = r13.zzx
            if (r14 == 0) goto L_0x00ee
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x00f0
        L_0x00ee:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzD
        L_0x00f0:
            r0 = 66
            r1 = 14
            r13.zzaf(r14, r0, r1)
            return r14
        L_0x00f8:
            boolean r14 = r13.zzw
            if (r14 == 0) goto L_0x00ff
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x0101
        L_0x00ff:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzC
        L_0x0101:
            r0 = 60
            r1 = 13
            r13.zzaf(r14, r0, r1)
            return r14
        L_0x0109:
            boolean r14 = r13.zzu
            if (r14 == 0) goto L_0x0110
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x0112
        L_0x0110:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzA
        L_0x0112:
            r0 = 33
            r13.zzaf(r14, r0, r3)
            return r14
        L_0x0118:
            boolean r14 = r13.zzu
            if (r14 == 0) goto L_0x011f
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x0121
        L_0x011f:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzz
        L_0x0121:
            r0 = 32
            r13.zzaf(r14, r0, r4)
            return r14
        L_0x0127:
            boolean r14 = r13.zzt
            if (r14 == 0) goto L_0x012e
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x0130
        L_0x012e:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzv
        L_0x0130:
            r0 = 20
            r13.zzaf(r14, r0, r11)
            return r14
        L_0x0136:
            boolean r14 = r13.zzs
            if (r14 == 0) goto L_0x013d
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x013f
        L_0x013d:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzt
        L_0x013f:
            r0 = 61
            r13.zzaf(r14, r0, r12)
            return r14
        L_0x0145:
            boolean r14 = r13.zzs
            if (r14 == 0) goto L_0x014c
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x014e
        L_0x014c:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzt
        L_0x014e:
            r0 = 19
            r13.zzaf(r14, r0, r5)
            return r14
        L_0x0154:
            boolean r14 = r13.zzq
            if (r14 == 0) goto L_0x015b
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x015d
        L_0x015b:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzu
        L_0x015d:
            r0 = 21
            r13.zzaf(r14, r0, r6)
            return r14
        L_0x0163:
            boolean r14 = r13.zzr
            if (r14 == 0) goto L_0x016a
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x016c
        L_0x016a:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzs
        L_0x016c:
            r0 = 31
            r13.zzaf(r14, r0, r7)
            return r14
        L_0x0172:
            boolean r14 = r13.zzp
            if (r14 == 0) goto L_0x0179
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x017b
        L_0x0179:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzw
        L_0x017b:
            r0 = 30
            r13.zzaf(r14, r0, r2)
            return r14
        L_0x0181:
            boolean r14 = r13.zzm
            if (r14 == 0) goto L_0x0188
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x018a
        L_0x0188:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzr
        L_0x018a:
            r0 = 35
            r13.zzaf(r14, r0, r9)
            return r14
        L_0x0190:
            boolean r14 = r13.zzj
            if (r14 == 0) goto L_0x0197
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x0199
        L_0x0197:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzp
        L_0x0199:
            r13.zzaf(r14, r11, r8)
            return r14
        L_0x019d:
            boolean r14 = r13.zzi
            if (r14 == 0) goto L_0x01a4
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzl
            goto L_0x01a6
        L_0x01a4:
            com.android.billingclient.api.BillingResult r14 = com.android.billingclient.api.zzbk.zzo
        L_0x01a6:
            r13.zzaf(r14, r12, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.isFeatureSupported(java.lang.String):com.android.billingclient.api.BillingResult");
    }

    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0481 A[SYNTHETIC, Splitter:B:177:0x0481] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0495 A[Catch:{ CancellationException | TimeoutException -> 0x0506, Exception -> 0x04ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r32, com.android.billingclient.api.BillingFlowParams r33) {
        /*
            r31 = this;
            r8 = r31
            r0 = r32
            java.lang.String r1 = "proxyPackageVersion"
            java.lang.String r9 = "BUY_INTENT"
            com.android.billingclient.api.zzh r2 = r8.zzd
            r10 = 2
            if (r2 == 0) goto L_0x0521
            com.android.billingclient.api.zzh r2 = r8.zzd
            com.android.billingclient.api.PurchasesUpdatedListener r2 = r2.zzd()
            if (r2 == 0) goto L_0x0521
            boolean r2 = r31.isReady()
            if (r2 != 0) goto L_0x002c
            com.android.billingclient.api.zzbi r0 = r8.zzf
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzbk.zzm
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r10, r10, r1)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzm
            r8.zzZ(r0)
            return r0
        L_0x002c:
            java.util.ArrayList r2 = r33.zzg()
            java.util.List r3 = r33.zzh()
            r4 = 0
            java.lang.Object r5 = com.google.android.gms.internal.play_billing.zzak.zza(r2, r4)
            com.android.billingclient.api.SkuDetails r5 = (com.android.billingclient.api.SkuDetails) r5
            java.lang.Object r6 = com.google.android.gms.internal.play_billing.zzak.zza(r3, r4)
            com.android.billingclient.api.BillingFlowParams$ProductDetailsParams r6 = (com.android.billingclient.api.BillingFlowParams.ProductDetailsParams) r6
            if (r5 == 0) goto L_0x004c
            java.lang.String r7 = r5.getSku()
            java.lang.String r11 = r5.getType()
            goto L_0x005c
        L_0x004c:
            com.android.billingclient.api.ProductDetails r7 = r6.zza()
            java.lang.String r7 = r7.getProductId()
            com.android.billingclient.api.ProductDetails r11 = r6.zza()
            java.lang.String r11 = r11.getProductType()
        L_0x005c:
            java.lang.String r12 = "subs"
            boolean r12 = r11.equals(r12)
            r13 = 9
            java.lang.String r14 = "BillingClient"
            if (r12 == 0) goto L_0x0083
            boolean r12 = r8.zzi
            if (r12 == 0) goto L_0x006d
            goto L_0x0083
        L_0x006d:
            java.lang.String r0 = "Current client doesn't support subscriptions."
            com.google.android.gms.internal.play_billing.zzb.zzk(r14, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzbk.zzo
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r13, r10, r1)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzo
            r8.zzZ(r0)
            return r0
        L_0x0083:
            boolean r12 = r33.zzq()
            if (r12 == 0) goto L_0x00a6
            boolean r12 = r8.zzl
            if (r12 == 0) goto L_0x008e
            goto L_0x00a6
        L_0x008e:
            java.lang.String r0 = "Current client doesn't support extra params for buy intent."
            com.google.android.gms.internal.play_billing.zzb.zzk(r14, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 18
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzh
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r10, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzh
            r8.zzZ(r0)
            return r0
        L_0x00a6:
            int r12 = r2.size()
            r15 = 1
            if (r12 <= r15) goto L_0x00ca
            boolean r12 = r8.zzs
            if (r12 == 0) goto L_0x00b2
            goto L_0x00ca
        L_0x00b2:
            java.lang.String r0 = "Current client doesn't support multi-item purchases."
            com.google.android.gms.internal.play_billing.zzb.zzk(r14, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 19
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzt
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r10, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzt
            r8.zzZ(r0)
            return r0
        L_0x00ca:
            boolean r12 = r3.isEmpty()
            if (r12 != 0) goto L_0x00ed
            boolean r12 = r8.zzt
            if (r12 == 0) goto L_0x00d5
            goto L_0x00ed
        L_0x00d5:
            java.lang.String r0 = "Current client doesn't support purchases with ProductDetails."
            com.google.android.gms.internal.play_billing.zzb.zzk(r14, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 20
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzv
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r10, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzv
            r8.zzZ(r0)
            return r0
        L_0x00ed:
            boolean r12 = r8.zzl
            if (r12 == 0) goto L_0x0466
            boolean r12 = r8.zzn
            boolean r13 = r8.zzz
            java.lang.String r10 = r8.zzb
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r15 = "playBillingLibraryVersion"
            r4.putString(r15, r10)
            int r10 = r33.zzb()
            java.lang.String r15 = "prorationMode"
            if (r10 == 0) goto L_0x0111
            int r10 = r33.zzb()
            r4.putInt(r15, r10)
            goto L_0x011e
        L_0x0111:
            int r10 = r33.zza()
            if (r10 == 0) goto L_0x011e
            int r10 = r33.zza()
            r4.putInt(r15, r10)
        L_0x011e:
            java.lang.String r10 = r33.zzc()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0131
            java.lang.String r10 = r33.zzc()
            java.lang.String r15 = "accountId"
            r4.putString(r15, r10)
        L_0x0131:
            java.lang.String r10 = r33.zzd()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0144
            java.lang.String r10 = r33.zzd()
            java.lang.String r15 = "obfuscatedProfileId"
            r4.putString(r15, r10)
        L_0x0144:
            boolean r10 = r33.zzp()
            if (r10 == 0) goto L_0x0150
            java.lang.String r10 = "isOfferPersonalizedByDeveloper"
            r15 = 1
            r4.putBoolean(r10, r15)
        L_0x0150:
            r10 = 0
            boolean r15 = android.text.TextUtils.isEmpty(r10)
            if (r15 != 0) goto L_0x0169
            java.util.ArrayList r15 = new java.util.ArrayList
            java.lang.String[] r17 = new java.lang.String[]{r10}
            java.util.List r10 = java.util.Arrays.asList(r17)
            r15.<init>(r10)
            java.lang.String r10 = "skusToReplace"
            r4.putStringArrayList(r10, r15)
        L_0x0169:
            java.lang.String r10 = r33.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x017c
            java.lang.String r10 = r33.zze()
            java.lang.String r15 = "oldSkuPurchaseToken"
            r4.putString(r15, r10)
        L_0x017c:
            r10 = 0
            boolean r15 = android.text.TextUtils.isEmpty(r10)
            if (r15 != 0) goto L_0x0188
            java.lang.String r15 = "oldSkuPurchaseId"
            r4.putString(r15, r10)
        L_0x0188:
            java.lang.String r15 = r33.zzf()
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x019c
            java.lang.String r15 = r33.zzf()
            java.lang.String r10 = "originalExternalTransactionId"
            r4.putString(r10, r15)
            r10 = 0
        L_0x019c:
            boolean r15 = android.text.TextUtils.isEmpty(r10)
            if (r15 != 0) goto L_0x01a7
            java.lang.String r15 = "paymentsPurchaseParams"
            r4.putString(r15, r10)
        L_0x01a7:
            if (r12 == 0) goto L_0x01b0
            java.lang.String r10 = "enablePendingPurchases"
            r12 = 1
            r4.putBoolean(r10, r12)
            goto L_0x01b1
        L_0x01b0:
            r12 = 1
        L_0x01b1:
            if (r13 == 0) goto L_0x01b8
            java.lang.String r10 = "enableAlternativeBilling"
            r4.putBoolean(r10, r12)
        L_0x01b8:
            boolean r10 = r2.isEmpty()
            java.lang.String r12 = "additionalSkuTypes"
            java.lang.String r13 = "additionalSkus"
            java.lang.String r15 = "SKU_SERIALIZED_DOCID_LIST"
            r17 = r9
            java.lang.String r9 = "skuDetailsTokens"
            java.lang.String r0 = "SKU_OFFER_ID_TOKEN_LIST"
            r18 = r11
            if (r10 != 0) goto L_0x02d1
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r19 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r20 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r21 = r14
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r22 = r2.iterator()
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
        L_0x01f7:
            boolean r27 = r22.hasNext()
            if (r27 == 0) goto L_0x0263
            java.lang.Object r27 = r22.next()
            com.android.billingclient.api.SkuDetails r27 = (com.android.billingclient.api.SkuDetails) r27
            java.lang.String r28 = r27.zzf()
            boolean r28 = r28.isEmpty()
            if (r28 != 0) goto L_0x0217
            r28 = r6
            java.lang.String r6 = r27.zzf()
            r10.add(r6)
            goto L_0x0219
        L_0x0217:
            r28 = r6
        L_0x0219:
            java.lang.String r6 = r27.zzc()
            r29 = r5
            java.lang.String r5 = r27.zzb()
            int r30 = r27.zza()
            java.lang.String r8 = r27.zze()
            r11.add(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r16 = 1
            r6 = r6 ^ 1
            r23 = r23 | r6
            r7.add(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r5 = r5 ^ 1
            r24 = r24 | r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r30)
            r1.add(r5)
            if (r30 == 0) goto L_0x024e
            r5 = 1
            goto L_0x024f
        L_0x024e:
            r5 = 0
        L_0x024f:
            r25 = r25 | r5
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            r5 = r5 ^ 1
            r26 = r26 | r5
            r14.add(r8)
            r8 = r31
            r6 = r28
            r5 = r29
            goto L_0x01f7
        L_0x0263:
            r29 = r5
            r28 = r6
            boolean r5 = r10.isEmpty()
            if (r5 != 0) goto L_0x0270
            r4.putStringArrayList(r9, r10)
        L_0x0270:
            if (r23 == 0) goto L_0x0275
            r4.putStringArrayList(r0, r11)
        L_0x0275:
            if (r24 == 0) goto L_0x027c
            java.lang.String r5 = "SKU_OFFER_ID_LIST"
            r4.putStringArrayList(r5, r7)
        L_0x027c:
            if (r25 == 0) goto L_0x0283
            java.lang.String r5 = "SKU_OFFER_TYPE_LIST"
            r4.putIntegerArrayList(r5, r1)
        L_0x0283:
            if (r26 == 0) goto L_0x0288
            r4.putStringArrayList(r15, r14)
        L_0x0288:
            int r1 = r2.size()
            r5 = 1
            if (r1 <= r5) goto L_0x0384
            java.util.ArrayList r1 = new java.util.ArrayList
            int r6 = r2.size()
            int r6 = r6 + -1
            r1.<init>(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r2.size()
            int r7 = r7 + -1
            r6.<init>(r7)
            r15 = 1
        L_0x02a6:
            int r7 = r2.size()
            if (r15 >= r7) goto L_0x02c9
            java.lang.Object r7 = r2.get(r15)
            com.android.billingclient.api.SkuDetails r7 = (com.android.billingclient.api.SkuDetails) r7
            java.lang.String r7 = r7.getSku()
            r1.add(r7)
            java.lang.Object r7 = r2.get(r15)
            com.android.billingclient.api.SkuDetails r7 = (com.android.billingclient.api.SkuDetails) r7
            java.lang.String r7 = r7.getType()
            r6.add(r7)
            int r15 = r15 + 1
            goto L_0x02a6
        L_0x02c9:
            r4.putStringArrayList(r13, r1)
            r4.putStringArrayList(r12, r6)
            goto L_0x0384
        L_0x02d1:
            r20 = r1
            r29 = r5
            r28 = r6
            r19 = r7
            r21 = r14
            r5 = 1
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r3.size()
            int r2 = r2 + -1
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = r3.size()
            int r6 = r6 + -1
            r2.<init>(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
        L_0x0302:
            int r11 = r3.size()
            if (r10 >= r11) goto L_0x0363
            java.lang.Object r11 = r3.get(r10)
            com.android.billingclient.api.BillingFlowParams$ProductDetailsParams r11 = (com.android.billingclient.api.BillingFlowParams.ProductDetailsParams) r11
            com.android.billingclient.api.ProductDetails r14 = r11.zza()
            java.lang.String r16 = r14.zzb()
            boolean r16 = r16.isEmpty()
            if (r16 != 0) goto L_0x0323
            java.lang.String r5 = r14.zzb()
            r6.add(r5)
        L_0x0323:
            java.lang.String r5 = r11.zzb()
            r7.add(r5)
            java.lang.String r5 = r14.zzc()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x033b
            java.lang.String r5 = r14.zzc()
            r8.add(r5)
        L_0x033b:
            if (r10 <= 0) goto L_0x035f
            java.lang.Object r5 = r3.get(r10)
            com.android.billingclient.api.BillingFlowParams$ProductDetailsParams r5 = (com.android.billingclient.api.BillingFlowParams.ProductDetailsParams) r5
            com.android.billingclient.api.ProductDetails r5 = r5.zza()
            java.lang.String r5 = r5.getProductId()
            r1.add(r5)
            java.lang.Object r5 = r3.get(r10)
            com.android.billingclient.api.BillingFlowParams$ProductDetailsParams r5 = (com.android.billingclient.api.BillingFlowParams.ProductDetailsParams) r5
            com.android.billingclient.api.ProductDetails r5 = r5.zza()
            java.lang.String r5 = r5.getProductType()
            r2.add(r5)
        L_0x035f:
            int r10 = r10 + 1
            r5 = 1
            goto L_0x0302
        L_0x0363:
            r4.putStringArrayList(r0, r7)
            boolean r5 = r6.isEmpty()
            if (r5 != 0) goto L_0x036f
            r4.putStringArrayList(r9, r6)
        L_0x036f:
            boolean r5 = r8.isEmpty()
            if (r5 != 0) goto L_0x0378
            r4.putStringArrayList(r15, r8)
        L_0x0378:
            boolean r5 = r1.isEmpty()
            if (r5 != 0) goto L_0x0384
            r4.putStringArrayList(r13, r1)
            r4.putStringArrayList(r12, r2)
        L_0x0384:
            boolean r0 = r4.containsKey(r0)
            r8 = r31
            if (r0 == 0) goto L_0x03a5
            boolean r0 = r8.zzq
            if (r0 == 0) goto L_0x0391
            goto L_0x03a5
        L_0x0391:
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 21
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzu
            r3 = 2
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r3, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzu
            r8.zzZ(r0)
            return r0
        L_0x03a5:
            java.lang.String r0 = "skuPackageName"
            if (r29 == 0) goto L_0x03bd
            java.lang.String r1 = r29.zzd()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03bd
            java.lang.String r1 = r29.zzd()
            r4.putString(r0, r1)
        L_0x03ba:
            r0 = 0
            r15 = 1
            goto L_0x03db
        L_0x03bd:
            if (r28 == 0) goto L_0x03d9
            com.android.billingclient.api.ProductDetails r1 = r28.zza()
            java.lang.String r1 = r1.zza()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03d9
            com.android.billingclient.api.ProductDetails r1 = r28.zza()
            java.lang.String r1 = r1.zza()
            r4.putString(r0, r1)
            goto L_0x03ba
        L_0x03d9:
            r0 = 0
            r15 = 0
        L_0x03db:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x03e6
            java.lang.String r1 = "accountName"
            r4.putString(r1, r0)
        L_0x03e6:
            android.content.Intent r0 = r32.getIntent()
            if (r0 != 0) goto L_0x03f4
            java.lang.String r0 = "Activity's intent is null."
            r9 = r21
            com.google.android.gms.internal.play_billing.zzb.zzk(r9, r0)
            goto L_0x0425
        L_0x03f4:
            r9 = r21
            java.lang.String r1 = "PROXY_PACKAGE"
            java.lang.String r2 = r0.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0425
            java.lang.String r0 = r0.getStringExtra(r1)
            java.lang.String r1 = "proxyPackage"
            r4.putString(r1, r0)
            android.content.Context r1 = r8.zze     // Catch:{ NameNotFoundException -> 0x041e }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x041e }
            r2 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x041e }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x041e }
            r1 = r20
            r4.putString(r1, r0)     // Catch:{ NameNotFoundException -> 0x0420 }
            goto L_0x0425
        L_0x041e:
            r1 = r20
        L_0x0420:
            java.lang.String r0 = "package not found"
            r4.putString(r1, r0)
        L_0x0425:
            boolean r0 = r8.zzt
            if (r0 == 0) goto L_0x0434
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0434
            r0 = 17
            r3 = 17
            goto L_0x0448
        L_0x0434:
            boolean r0 = r8.zzr
            if (r0 == 0) goto L_0x043f
            if (r15 == 0) goto L_0x043f
            r0 = 15
            r3 = 15
            goto L_0x0448
        L_0x043f:
            boolean r0 = r8.zzn
            if (r0 == 0) goto L_0x0446
            r3 = 9
            goto L_0x0448
        L_0x0446:
            r0 = 6
            r3 = 6
        L_0x0448:
            com.android.billingclient.api.zzab r0 = new com.android.billingclient.api.zzab
            r1 = r0
            r2 = r31
            r7 = r4
            r4 = r19
            r5 = r18
            r6 = r33
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.zzc
            r1 = r31
            r2 = r0
            java.util.concurrent.Future r0 = r1.zzac(r2, r3, r5, r6)
            r1 = 78
            goto L_0x047f
        L_0x0466:
            r19 = r7
            r17 = r9
            r18 = r11
            r9 = r14
            com.android.billingclient.api.zzac r2 = new com.android.billingclient.api.zzac
            r2.<init>(r8, r7, r11)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.zzc
            r1 = r31
            java.util.concurrent.Future r0 = r1.zzac(r2, r3, r5, r6)
            r1 = 80
        L_0x047f:
            if (r0 != 0) goto L_0x0495
            com.android.billingclient.api.zzbi r0 = r8.zzf     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzbk.zzm     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r2 = 25
            r3 = 2
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r2, r3, r1)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r0.zza(r1)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzm     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r8.zzZ(r0)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            return r0
        L_0x0495:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r3 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r0 = r0.get(r3, r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            int r2 = com.google.android.gms.internal.play_billing.zzb.zzb(r0, r9)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            java.lang.String r3 = com.google.android.gms.internal.play_billing.zzb.zzg(r0, r9)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            if (r2 == 0) goto L_0x04d3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r4.<init>()     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            java.lang.String r5 = "Unable to buy item, Error response code: "
            r4.append(r5)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r4.append(r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            java.lang.String r4 = r4.toString()     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.google.android.gms.internal.play_billing.zzb.zzk(r9, r4)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zza(r2, r3)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.android.billingclient.api.zzbi r3 = r8.zzf     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            if (r0 == 0) goto L_0x04c7
            r1 = 23
        L_0x04c7:
            r4 = 2
            com.google.android.gms.internal.play_billing.zzhy r0 = com.android.billingclient.api.zzbh.zza(r1, r4, r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r3.zza(r0)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r8.zzZ(r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            return r2
        L_0x04d3:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            java.lang.Class<com.android.billingclient.api.ProxyBillingActivity> r2 = com.android.billingclient.api.ProxyBillingActivity.class
            r3 = r32
            r1.<init>(r3, r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r2 = r17
            android.os.Parcelable r0 = r0.getParcelable(r2)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r1.putExtra(r2, r0)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            r3.startActivity(r1)     // Catch:{ TimeoutException -> 0x0508, CancellationException -> 0x0506, Exception -> 0x04ed }
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzl
            return r0
        L_0x04ed:
            r0 = move-exception
            java.lang.String r1 = "Exception while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzl(r9, r1, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 5
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzm
            r3 = 2
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r3, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzm
            r8.zzZ(r0)
            return r0
        L_0x0506:
            r0 = move-exception
            goto L_0x0509
        L_0x0508:
            r0 = move-exception
        L_0x0509:
            java.lang.String r1 = "Time out while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzl(r9, r1, r0)
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 4
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzn
            r3 = 2
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r3, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzn
            r8.zzZ(r0)
            return r0
        L_0x0521:
            r3 = 2
            com.android.billingclient.api.zzbi r0 = r8.zzf
            r1 = 12
            com.android.billingclient.api.BillingResult r2 = com.android.billingclient.api.zzbk.zzE
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r1, r3, r2)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    public final void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 7, zzbk.zzm));
            productDetailsResponseListener.onProductDetailsResponse(zzbk.zzm, new ArrayList());
        } else if (!this.zzt) {
            zzb.zzk("BillingClient", "Querying product details is not supported.");
            this.zzf.zza(zzbh.zza(20, 7, zzbk.zzv));
            productDetailsResponseListener.onProductDetailsResponse(zzbk.zzv, new ArrayList());
        } else {
            if (zzac(new zzu(this, queryProductDetailsParams, productDetailsResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzz(this, productDetailsResponseListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 7, zzaa));
                productDetailsResponseListener.onProductDetailsResponse(zzaa, new ArrayList());
            }
        }
    }

    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzae(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 8, zzbk.zzm));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzm, (List<SkuDetails>) null);
            return;
        }
        String skuType = skuDetailsParams.getSkuType();
        List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            zzb.zzk("BillingClient", "Please fix the input params. SKU type can't be empty.");
            this.zzf.zza(zzbh.zza(49, 8, zzbk.zzf));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzf, (List<SkuDetails>) null);
        } else if (skusList == null) {
            zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            this.zzf.zza(zzbh.zza(48, 8, zzbk.zze));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zze, (List<SkuDetails>) null);
        } else {
            if (zzac(new zzq(this, skuType, skusList, (String) null, skuDetailsResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzr(this, skuDetailsResponseListener), zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 8, zzaa));
                skuDetailsResponseListener.onSkuDetailsResponse(zzaa, (List<SkuDetails>) null);
            }
        }
    }

    public final BillingResult showAlternativeBillingOnlyInformationDialog(Activity activity, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 16, zzbk.zzm));
            return zzbk.zzm;
        } else if (!this.zzx) {
            zzb.zzk("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 16, zzbk.zzD));
            return zzbk.zzD;
        } else {
            if (zzac(new zzad(this, activity, new zzak(this, this.zzc, alternativeBillingOnlyInformationDialogListener), alternativeBillingOnlyInformationDialogListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzae(this, alternativeBillingOnlyInformationDialogListener), this.zzc) != null) {
                return zzbk.zzl;
            }
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 16, zzaa));
            return zzaa;
        }
    }

    public final BillingResult showInAppMessages(Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            return zzbk.zzm;
        } else if (!this.zzp) {
            zzb.zzk("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzbk.zzw;
        } else {
            View findViewById = activity.findViewById(16908290);
            IBinder windowToken = findViewById.getWindowToken();
            Rect rect = new Rect();
            findViewById.getGlobalVisibleRect(rect);
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
            bundle.putInt("KEY_DIMEN_LEFT", rect.left);
            bundle.putInt("KEY_DIMEN_TOP", rect.top);
            bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
            bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
            zzac(new zzaa(this, bundle, activity, new zzaj(this, this.zzc, inAppMessageResponseListener)), 5000, (Runnable) null, this.zzc);
            return zzbk.zzl;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzf.zza(zzbh.zza(24, 3, zzbk.zzn));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(BillingResult billingResult) {
        if (this.zzd.zzd() != null) {
            this.zzd.zzd().onPurchasesUpdated(billingResult, (List<Purchase>) null);
            return;
        }
        this.zzd.zzc();
        zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zzf.zza(zzbh.zza(24, 4, zzbk.zzn));
        consumeResponseListener.onConsumeResponse(zzbk.zzn, consumeParams.getPurchaseToken());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        this.zzf.zza(zzbh.zza(24, 15, zzbk.zzn));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzn, (AlternativeBillingOnlyReportingDetails) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(BillingConfigResponseListener billingConfigResponseListener) {
        this.zzf.zza(zzbh.zza(24, 13, zzbk.zzn));
        billingConfigResponseListener.onBillingConfigResponse(zzbk.zzn, (BillingConfig) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        this.zzf.zza(zzbh.zza(24, 14, zzbk.zzn));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(ProductDetailsResponseListener productDetailsResponseListener) {
        this.zzf.zza(zzbh.zza(24, 7, zzbk.zzn));
        productDetailsResponseListener.onProductDetailsResponse(zzbk.zzn, new ArrayList());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzf.zza(zzbh.zza(24, 11, zzbk.zzn));
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbk.zzn, (List<PurchaseHistoryRecord>) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(PurchasesResponseListener purchasesResponseListener) {
        this.zzf.zza(zzbh.zza(24, 9, zzbk.zzn));
        purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzn, zzaf.zzk());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzV(SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zzf.zza(zzbh.zza(24, 8, zzbk.zzn));
        skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzn, (List<SkuDetails>) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        this.zzf.zza(zzbh.zza(24, 16, zzbk.zzn));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzc(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzg.zzg(i, this.zze.getPackageName(), str, str2, (String) null, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzg.zzf(3, this.zze.getPackageName(), str, str2, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            zzm zzm2 = this.zzg;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd2 = zzm2.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zza(zzb.zzb(zzd2, "BillingClient"), zzb.zzg(zzd2, "BillingClient")));
            return null;
        } catch (Exception e) {
            zzb.zzl("BillingClient", "Error acknowledge purchase!", e);
            this.zzf.zza(zzbh.zza(28, 3, zzbk.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzm);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int i;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            zzb.zzj("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzn) {
                zzm zzm2 = this.zzg;
                String packageName = this.zze.getPackageName();
                boolean z = this.zzn;
                String str2 = this.zzb;
                Bundle bundle = new Bundle();
                if (z) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze2 = zzm2.zze(9, packageName, purchaseToken, bundle);
                i = zze2.getInt("RESPONSE_CODE");
                str = zzb.zzg(zze2, "BillingClient");
            } else {
                i = this.zzg.zza(3, this.zze.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzbk.zza(i, str);
            if (i == 0) {
                zzb.zzj("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
                return null;
            }
            zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + i);
            this.zzf.zza(zzbh.zza(23, 4, zza2));
            consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
            return null;
        } catch (Exception e) {
            zzb.zzl("BillingClient", "Error consuming purchase!", e);
            this.zzf.zza(zzbh.zza(29, 4, zzbk.zzm));
            consumeResponseListener.onConsumeResponse(zzbk.zzm, purchaseToken);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzm(Bundle bundle, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        try {
            this.zzg.zzo(18, this.zze.getPackageName(), bundle, new zzau(billingConfigResponseListener, this.zzf, (zzat) null));
        } catch (DeadObjectException e) {
            zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", e);
            this.zzf.zza(zzbh.zza(62, 13, zzbk.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzm, (BillingConfig) null);
        } catch (Exception e2) {
            zzb.zzl("BillingClient", "getBillingConfig got an exception.", e2);
            this.zzf.zza(zzbh.zza(62, 13, zzbk.zzj));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzj, (BillingConfig) null);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzn(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String str;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        String zzb2 = queryProductDetailsParams.zzb();
        zzaf zza2 = queryProductDetailsParams.zza();
        int size = zza2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                str = "";
                i = 0;
                break;
            }
            int i4 = i3 + 20;
            ArrayList arrayList2 = new ArrayList(zza2.subList(i3, i4 > size ? size : i4));
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i5)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                zzm zzm2 = this.zzg;
                int i6 = true != this.zzw ? 17 : 20;
                String packageName = this.zze.getPackageName();
                String str2 = this.zzb;
                if (TextUtils.isEmpty((CharSequence) null)) {
                    this.zze.getPackageName();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("playBillingLibraryVersion", str2);
                bundle2.putBoolean("enablePendingPurchases", true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                int size3 = arrayList2.size();
                zzaf zzaf = zza2;
                int i7 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i7 < size3) {
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add((Object) null);
                    z |= !TextUtils.isEmpty((CharSequence) null);
                    int i8 = size3;
                    if (((QueryProductDetailsParams.Product) arrayList2.get(i7)).zzb().equals("first_party")) {
                        zzx.zzc((Object) null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add((Object) null);
                        z2 = true;
                    }
                    i7++;
                    size3 = i8;
                    arrayList2 = arrayList6;
                }
                if (z) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z2 && !TextUtils.isEmpty((CharSequence) null)) {
                    bundle2.putString("accountName", (String) null);
                }
                i2 = 7;
                try {
                    Bundle zzl2 = zzm2.zzl(i6, packageName, zzb2, bundle, bundle2);
                    str = "Item is unavailable for purchase.";
                    if (zzl2 == null) {
                        zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                        this.zzf.zza(zzbh.zza(44, 7, zzbk.zzB));
                        break;
                    } else if (!zzl2.containsKey("DETAILS_LIST")) {
                        i = zzb.zzb(zzl2, "BillingClient");
                        str = zzb.zzg(zzl2, "BillingClient");
                        if (i != 0) {
                            zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i);
                            this.zzf.zza(zzbh.zza(23, 7, zzbk.zza(i, str)));
                        } else {
                            zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            this.zzf.zza(zzbh.zza(45, 7, zzbk.zza(6, str)));
                        }
                    } else {
                        ArrayList<String> stringArrayList = zzl2.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                            this.zzf.zza(zzbh.zza(46, 7, zzbk.zzB));
                            break;
                        }
                        int i9 = 0;
                        while (i9 < stringArrayList.size()) {
                            try {
                                ProductDetails productDetails = new ProductDetails(stringArrayList.get(i9));
                                zzb.zzj("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                arrayList.add(productDetails);
                                i9++;
                            } catch (JSONException e) {
                                zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                                str = "Error trying to decode SkuDetails.";
                                this.zzf.zza(zzbh.zza(47, 7, zzbk.zza(6, str)));
                                i = 6;
                                productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
                                return null;
                            }
                        }
                        i3 = i4;
                        zza2 = zzaf;
                    }
                } catch (Exception e2) {
                    e = e2;
                    zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                    this.zzf.zza(zzbh.zza(43, i2, zzbk.zzj));
                    str = "An internal error occurred.";
                    i = 6;
                    productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = 7;
                zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                this.zzf.zza(zzbh.zza(43, i2, zzbk.zzj));
                str = "An internal error occurred.";
                i = 6;
                productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
                return null;
            }
        }
        i = 4;
        productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzo(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        String str3;
        int i;
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                str3 = "";
                i = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList arrayList2 = new ArrayList(list.subList(i2, i3 > size ? size : i3));
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle2.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    zzm zzm2 = this.zzg;
                    String packageName = this.zze.getPackageName();
                    int i4 = this.zzk;
                    String str4 = this.zzb;
                    Bundle bundle3 = new Bundle();
                    if (i4 >= 9) {
                        bundle3.putString("playBillingLibraryVersion", str4);
                    }
                    if (i4 >= 9) {
                        bundle3.putBoolean("enablePendingPurchases", true);
                    }
                    bundle = zzm2.zzl(10, packageName, str, bundle2, bundle3);
                    String str5 = str;
                } else {
                    bundle = this.zzg.zzk(3, this.zze.getPackageName(), str, bundle2);
                }
                str3 = "Item is unavailable for purchase.";
                if (bundle == null) {
                    zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                    this.zzf.zza(zzbh.zza(44, 8, zzbk.zzB));
                    break;
                } else if (!bundle.containsKey("DETAILS_LIST")) {
                    int zzb2 = zzb.zzb(bundle, "BillingClient");
                    str3 = zzb.zzg(bundle, "BillingClient");
                    if (zzb2 != 0) {
                        zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + zzb2);
                        this.zzf.zza(zzbh.zza(23, 8, zzbk.zza(zzb2, str3)));
                        i = zzb2;
                    } else {
                        zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        this.zzf.zza(zzbh.zza(45, 8, zzbk.zza(6, str3)));
                    }
                } else {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                        this.zzf.zza(zzbh.zza(46, 8, zzbk.zzB));
                        break;
                    }
                    int i5 = 0;
                    while (i5 < stringArrayList.size()) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                            zzb.zzj("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                            arrayList.add(skuDetails);
                            i5++;
                        } catch (JSONException e) {
                            zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e);
                            str3 = "Error trying to decode SkuDetails.";
                            this.zzf.zza(zzbh.zza(47, 8, zzbk.zza(6, str3)));
                            arrayList = null;
                            i = 6;
                            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i, str3), arrayList);
                            return null;
                        }
                    }
                    i2 = i3;
                }
            } catch (Exception e2) {
                zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
                this.zzf.zza(zzbh.zza(43, 8, zzbk.zzm));
                str3 = "Service connection is disconnected.";
                i = -1;
                arrayList = null;
            }
        }
        arrayList = null;
        i = 4;
        skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i, str3), arrayList);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzp(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzg.zzq(12, this.zze.getPackageName(), bundle, new zzay(new WeakReference(activity), resultReceiver, (zzax) null));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        try {
            this.zzg.zzm(21, this.zze.getPackageName(), new Bundle(), new zzaq(alternativeBillingOnlyReportingDetailsListener, this.zzf, (zzap) null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(70, 15, zzbk.zzj));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzj, (AlternativeBillingOnlyReportingDetails) null);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzr(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        try {
            this.zzg.zzp(21, this.zze.getPackageName(), new Bundle(), new zzaw(alternativeBillingOnlyAvailabilityListener, this.zzf, (zzav) null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(69, 14, zzbk.zzj));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzj);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzs(Activity activity, ResultReceiver resultReceiver, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) throws Exception {
        try {
            this.zzg.zzn(21, this.zze.getPackageName(), new Bundle(), new zzas(new WeakReference(activity), resultReceiver, this.zzf, (zzar) null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(74, 16, zzbk.zzj));
            alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzj);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final BillingResult zzaa() {
        if (this.zza == 0 || this.zza == 3) {
            return zzbk.zzm;
        }
        return zzbk.zzj;
    }

    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(str, purchaseHistoryResponseListener);
    }

    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzae(str, purchasesResponseListener);
    }

    private BillingClientImpl(Context context, zzbx zzbx, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbi, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, zzbx, userChoiceBillingListener, str, (zzbi) null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    BillingClientImpl(String str, Context context, zzbi zzbi, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        String zzab = zzab();
        this.zzb = zzab;
        this.zze = context.getApplicationContext();
        zzin zzv2 = zzio.zzv();
        zzv2.zzj(zzab);
        zzv2.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv2.zzc());
        this.zze.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbx, UserChoiceBillingListener userChoiceBillingListener, String str, zzbi zzbi) {
        this.zze = context.getApplicationContext();
        zzin zzv2 = zzio.zzv();
        zzv2.zzj(str);
        zzv2.zzi(this.zze.getPackageName());
        if (zzbi != null) {
            this.zzf = zzbi;
        } else {
            this.zzf = new zzbn(this.zze, (zzio) zzv2.zzc());
        }
        if (purchasesUpdatedListener == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, userChoiceBillingListener, this.zzf);
        this.zzy = zzbx;
        this.zzz = userChoiceBillingListener != null;
    }

    BillingClientImpl(String str, zzbx zzbx, Context context, zzbq zzbq, zzbi zzbi, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab();
        this.zze = context.getApplicationContext();
        zzin zzv2 = zzio.zzv();
        zzv2.zzj(zzab());
        zzv2.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv2.zzc());
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzh(this.zze, (zzbq) null, this.zzf);
        this.zzy = zzbx;
        this.zze.getPackageName();
    }

    BillingClientImpl(String str, zzbx zzbx, Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbi, ExecutorService executorService) {
        String zzab = zzab();
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab;
        initialize(context, purchasesUpdatedListener, zzbx, alternativeBillingListener, zzab, (zzbi) null);
    }

    BillingClientImpl(String str, zzbx zzbx, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbi, ExecutorService executorService) {
        this(context, zzbx, purchasesUpdatedListener, zzab(), (String) null, userChoiceBillingListener, (zzbi) null, (ExecutorService) null);
    }

    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzbh.zza(37, 6, zzbk.zzd));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzd);
        } else if (this.zza == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzbh.zza(38, 6, zzbk.zzm));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzm);
        } else {
            this.zza = 1;
            zzb.zzj("BillingClient", "Starting in-app billing setup.");
            this.zzh = new zzao(this, billingClientStateListener, (zzan) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                i = 41;
            } else {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                        i = 40;
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("playBillingLibraryVersion", this.zzb);
                        if (this.zze.bindService(intent2, this.zzh, 1)) {
                            zzb.zzj("BillingClient", "Service was bonded successfully.");
                            return;
                        } else {
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            i = 39;
                        }
                    }
                }
            }
            this.zza = 0;
            zzb.zzj("BillingClient", "Billing service unavailable on device.");
            this.zzf.zza(zzbh.zza(i, 6, zzbk.zzc));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzc);
        }
    }
}
