package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class v {
    private final int a = -1;
    private final IronSource.AD_UNIT b;
    private final b c;
    private u d;
    private u1 e;
    public b7 f;
    public r8 g;
    public ic h;
    public s0 i;
    public k j;
    public oc k;
    private Map<t, a> l;
    private Map<t, a> m;
    private Map<t, a> n;
    private Map<t, a> o;

    private static class a {
        private final int a;
        private final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* access modifiers changed from: package-private */
        public int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.a : this.b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public v(IronSource.AD_UNIT ad_unit, b bVar, u uVar) {
        this.b = ad_unit;
        this.c = bVar;
        this.d = uVar;
        a(ad_unit);
        b();
        this.f = new b7(this);
        this.g = new r8(this);
        this.h = new ic(this);
        this.i = new s0(this);
        this.j = new k(this);
        this.k = new oc(this);
    }

    private int a(t tVar) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.b) && this.l.containsKey(tVar)) {
                return this.l.get(tVar).a(this.c);
            }
            if (IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.b) && this.m.containsKey(tVar)) {
                return this.m.get(tVar).a(this.c);
            }
            if (IronSource.AD_UNIT.BANNER.equals(this.b) && this.n.containsKey(tVar)) {
                return this.n.get(tVar).a(this.c);
            }
            if (!IronSource.AD_UNIT.NATIVE_AD.equals(this.b) || !this.o.containsKey(tVar)) {
                return -1;
            }
            return this.o.get(tVar).a(this.c);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        this.e = (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) || ad_unit.equals(IronSource.AD_UNIT.OFFERWALL)) ? va.i() : n7.i();
    }

    private void d() {
        HashMap hashMap = new HashMap();
        this.o = hashMap;
        hashMap.put(t.INIT_STARTED, new a(IronSourceConstants.NT_MANAGER_INIT_STARTED, -1));
        this.o.put(t.INIT_ENDED, new a(IronSourceConstants.NT_MANAGER_INIT_ENDED, -1));
        this.o.put(t.PLACEMENT_CAPPED, new a(IronSourceConstants.NT_PLACEMENT_CAPPED, -1));
        this.o.put(t.AUCTION_REQUEST, new a(IronSourceConstants.NT_AUCTION_REQUEST, -1));
        this.o.put(t.AUCTION_SUCCESS, new a(IronSourceConstants.NT_AUCTION_SUCCESS, -1));
        this.o.put(t.AUCTION_FAILED, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.o.put(t.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.o.put(t.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.NT_AUCTION_REQUEST_WATERFALL, -1));
        this.o.put(t.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.NT_AUCTION_RESPONSE_WATERFALL, -1));
        this.o.put(t.INIT_SUCCESS, new a(-1, -1));
        this.o.put(t.INIT_FAILED, new a(-1, -1));
        this.o.put(t.AD_OPENED, new a(IronSourceConstants.NT_CALLBACK_SHOW, IronSourceConstants.NT_INSTANCE_SHOW));
        this.o.put(t.AD_CLICKED, new a(IronSourceConstants.NT_CALLBACK_CLICK, IronSourceConstants.NT_INSTANCE_CLICK));
        this.o.put(t.LOAD_AD, new a(4001, 4002));
        this.o.put(t.LOAD_AD_SUCCESS, new a(IronSourceConstants.NT_CALLBACK_LOAD_SUCCESS, 4005));
        this.o.put(t.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.NT_CALLBACK_LOAD_ERROR, IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.o.put(t.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.NT_INSTANCE_LOAD_NO_FILL));
        this.o.put(t.AD_UNIT_CAPPED, new a(IronSourceConstants.NT_AD_UNIT_CAPPED, -1));
        this.o.put(t.COLLECT_TOKEN, new a(IronSourceConstants.NT_COLLECT_TOKENS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN));
        this.o.put(t.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.NT_COLLECT_TOKENS_COMPLETED, -1));
        this.o.put(t.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.NT_COLLECT_TOKENS_FAILED, -1));
        this.o.put(t.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN, -1));
        this.o.put(t.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.o.put(t.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED));
        this.o.put(t.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.o.put(t.DESTROY_AD, new a(IronSourceConstants.NT_DESTROY, IronSourceConstants.NT_INSTANCE_DESTROY));
        this.o.put(t.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING));
        this.o.put(t.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT));
        this.o.put(t.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED));
        this.o.put(t.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR));
        this.o.put(t.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.o.put(t.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.o.put(t.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_NOTIFICATIONS_ERROR, -1));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        HashMap hashMap = new HashMap();
        this.n = hashMap;
        hashMap.put(t.INIT_STARTED, new a(IronSourceConstants.BN_MANAGER_INIT_STARTED, -1));
        this.n.put(t.INIT_ENDED, new a(IronSourceConstants.BN_MANAGER_INIT_ENDED, -1));
        this.n.put(t.PLACEMENT_CAPPED, new a(IronSourceConstants.BN_PLACEMENT_CAPPED, -1));
        this.n.put(t.AUCTION_REQUEST, new a(IronSourceConstants.BN_AUCTION_REQUEST, -1));
        this.n.put(t.AUCTION_SUCCESS, new a(IronSourceConstants.BN_AUCTION_SUCCESS, -1));
        this.n.put(t.AUCTION_FAILED, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.n.put(t.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.n.put(t.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, -1));
        this.n.put(t.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, -1));
        this.n.put(t.INIT_SUCCESS, new a(-1, -1));
        this.n.put(t.INIT_FAILED, new a(-1, -1));
        this.n.put(t.AD_OPENED, new a(IronSourceConstants.BN_CALLBACK_SHOW, 3009));
        this.n.put(t.AD_CLICKED, new a(IronSourceConstants.BN_CALLBACK_CLICK, 3008));
        this.n.put(t.LOAD_AD, new a(3001, 3002));
        this.n.put(t.RELOAD_AD, new a(IronSourceConstants.BN_RELOAD, IronSourceConstants.BN_INSTANCE_RELOAD));
        this.n.put(t.LOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, 3005));
        this.n.put(t.RELOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.n.put(t.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, 3300));
        this.n.put(t.RELOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.n.put(t.LOAD_AD_NO_FILL, new a(-1, 3306));
        this.n.put(t.RELOAD_AD_NO_FILL, new a(-1, IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL));
        this.n.put(t.AD_UNIT_CAPPED, new a(IronSourceConstants.BN_AD_UNIT_CAPPED, -1));
        this.n.put(t.COLLECT_TOKEN, new a(IronSourceConstants.BN_COLLECT_TOKENS, -1));
        this.n.put(t.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, -1));
        this.n.put(t.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, -1));
        this.n.put(t.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN, -1));
        this.n.put(t.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.n.put(t.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED));
        this.n.put(t.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.n.put(t.DESTROY_AD, new a(IronSourceConstants.BN_DESTROY, 3305));
        this.n.put(t.SKIP_RELOAD_AD, new a(IronSourceConstants.BN_SKIP_RELOAD, -1));
        this.n.put(t.AD_LEFT_APPLICATION, new a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, 3304));
        this.n.put(t.AD_PRESENT_SCREEN, new a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN));
        this.n.put(t.AD_DISMISS_SCREEN, new a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN));
        this.n.put(t.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING));
        this.n.put(t.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT));
        this.n.put(t.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED));
        this.n.put(t.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR));
        this.n.put(t.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.n.put(t.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.n.put(t.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, -1));
    }

    /* access modifiers changed from: protected */
    public void a(t tVar, Map<String, Object> map) {
        a(tVar, map, System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public void a(t tVar, Map<String, Object> map, long j2) {
        int a2 = a(tVar);
        if (-1 != a2) {
            HashMap hashMap = new HashMap();
            u uVar = this.d;
            if (uVar != null) {
                hashMap.putAll(uVar.a(tVar));
            }
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(map);
            }
            this.e.a(new y3(a2, j2, new JSONObject(hashMap)));
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c();
        e();
        a();
        d();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        HashMap hashMap = new HashMap();
        this.l = hashMap;
        hashMap.put(t.INIT_STARTED, new a(IronSourceConstants.IS_MANAGER_INIT_STARTED, -1));
        this.l.put(t.INIT_ENDED, new a(IronSourceConstants.IS_MANAGER_INIT_ENDED, -1));
        this.l.put(t.SESSION_CAPPED, new a(-1, IronSourceConstants.IS_CAP_SESSION));
        this.l.put(t.PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CAP_PLACEMENT, -1));
        this.l.put(t.AUCTION_REQUEST, new a(2000, -1));
        this.l.put(t.AUCTION_SUCCESS, new a(IronSourceConstants.IS_AUCTION_SUCCESS, -1));
        this.l.put(t.AUCTION_FAILED, new a(IronSourceConstants.IS_AUCTION_FAILED, -1));
        this.l.put(t.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.IS_AUCTION_FAILED, -1));
        this.l.put(t.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, -1));
        this.l.put(t.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.IS_RESULT_WATERFALL, -1));
        this.l.put(t.INIT_SUCCESS, new a(-1, -1));
        this.l.put(t.INIT_FAILED, new a(-1, -1));
        this.l.put(t.SHOW_AD_SUCCESS, new a(-1, 2202));
        this.l.put(t.AD_OPENED, new a(-1, 2005));
        this.l.put(t.AD_CLOSED, new a(-1, 2204));
        this.l.put(t.AD_CLICKED, new a(-1, 2006));
        this.l.put(t.LOAD_AD, new a(2001, 2002));
        this.l.put(t.LOAD_AD_SUCCESS, new a(IronSourceConstants.IS_CALLBACK_LOAD_SUCCESS, 2003));
        this.l.put(t.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, 2200));
        this.l.put(t.LOAD_AD_NO_FILL, new a(-1, 2213));
        this.l.put(t.SHOW_AD, new a(IronSourceConstants.IS_SHOW_CALLED, 2201));
        this.l.put(t.SHOW_AD_FAILED, new a(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, 2203));
        this.l.put(t.AD_UNIT_CAPPED, new a(2303, -1));
        this.l.put(t.COLLECT_TOKEN, new a(IronSourceConstants.IS_COLLECT_TOKENS, -1));
        this.l.put(t.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, -1));
        this.l.put(t.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.IS_COLLECT_TOKENS_FAILED, -1));
        this.l.put(t.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN, -1));
        this.l.put(t.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, -1));
        this.l.put(t.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, -1));
        this.l.put(t.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, -1));
        this.l.put(t.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING));
        this.l.put(t.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED));
        this.l.put(t.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT));
        this.l.put(t.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR));
        this.l.put(t.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.l.put(t.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.l.put(t.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, -1));
    }

    /* access modifiers changed from: package-private */
    public void e() {
        HashMap hashMap = new HashMap();
        this.m = hashMap;
        hashMap.put(t.INIT_STARTED, new a(IronSourceConstants.RV_MANAGER_INIT_STARTED, -1));
        this.m.put(t.INIT_ENDED, new a(IronSourceConstants.RV_MANAGER_INIT_ENDED, -1));
        this.m.put(t.SESSION_CAPPED, new a(-1, IronSourceConstants.RV_CAP_SESSION));
        this.m.put(t.PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CAP_PLACEMENT, -1));
        this.m.put(t.AUCTION_REQUEST, new a(IronSourceConstants.RV_AUCTION_REQUEST, -1));
        this.m.put(t.AUCTION_SUCCESS, new a(IronSourceConstants.RV_AUCTION_SUCCESS, -1));
        this.m.put(t.AUCTION_FAILED, new a(IronSourceConstants.RV_AUCTION_FAILED, -1));
        this.m.put(t.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.RV_AUCTION_FAILED, -1));
        this.m.put(t.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, -1));
        this.m.put(t.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, -1));
        this.m.put(t.INIT_SUCCESS, new a(-1, -1));
        this.m.put(t.INIT_FAILED, new a(-1, -1));
        this.m.put(t.AD_VISIBLE, new a(-1, 1206));
        this.m.put(t.AD_OPENED, new a(-1, 1005));
        this.m.put(t.AD_CLOSED, new a(-1, 1203));
        this.m.put(t.AD_STARTED, new a(-1, IronSourceConstants.RV_INSTANCE_STARTED));
        this.m.put(t.AD_ENDED, new a(-1, IronSourceConstants.RV_INSTANCE_ENDED));
        this.m.put(t.AD_CLICKED, new a(-1, 1006));
        this.m.put(t.AD_REWARDED, new a(-1, 1010));
        this.m.put(t.AD_AVAILABILITY_CHANGED_TRUE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE));
        this.m.put(t.AD_AVAILABILITY_CHANGED_FALSE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE));
        this.m.put(t.LOAD_AD, new a(1000, 1001));
        this.m.put(t.LOAD_AD_SUCCESS, new a(1003, 1002));
        this.m.put(t.LOAD_AD_FAILED, new a(-1, 1200));
        this.m.put(t.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.RV_MEDIATION_LOAD_ERROR, IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.m.put(t.LOAD_AD_NO_FILL, new a(-1, 1213));
        this.m.put(t.SHOW_AD, new a(IronSourceConstants.RV_API_SHOW_CALLED, 1201));
        this.m.put(t.SHOW_AD_CHANCE, new a(-1, IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.m.put(t.SHOW_AD_FAILED, new a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, 1202));
        this.m.put(t.AD_UNIT_CAPPED, new a(IronSourceConstants.RV_AD_UNIT_CAPPED, -1));
        this.m.put(t.COLLECT_TOKEN, new a(IronSourceConstants.RV_COLLECT_TOKENS, -1));
        this.m.put(t.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, -1));
        this.m.put(t.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, -1));
        this.m.put(t.INSTANCE_COLLECT_TOKEN, new a(1020, -1));
        this.m.put(t.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(1021, 1021));
        this.m.put(t.INSTANCE_COLLECT_TOKEN_FAILED, new a(1022, 1022));
        this.m.put(t.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(1023, 1023));
        this.m.put(t.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING));
        this.m.put(t.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT));
        this.m.put(t.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED));
        this.m.put(t.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED));
        this.m.put(t.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR));
        this.m.put(t.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.m.put(t.TROUBLESHOOTING_WATERFALL_OVERHEAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD));
        this.m.put(t.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, -1));
        this.m.put(t.TROUBLESHOOT_AD_EXPIRED, new a(IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED, IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED));
    }

    public void f() {
        this.d = null;
        this.h = null;
        this.i = null;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
    }
}
