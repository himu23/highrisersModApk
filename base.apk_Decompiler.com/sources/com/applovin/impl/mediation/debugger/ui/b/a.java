package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.mediation.debugger.ui.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.b;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private FrameLayout akw;
    private ListView akx;
    /* access modifiers changed from: private */
    public b aoa;
    private DataSetObserver aqL;
    private com.applovin.impl.adview.a aqM;

    /* access modifiers changed from: protected */
    public n getSdk() {
        b bVar = this.aoa;
        if (bVar != null) {
            return bVar.getSdk();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.akw = (FrameLayout) findViewById(16908290);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter(this.aoa);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        we();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        b bVar = this.aoa;
        if (bVar != null && !bVar.isInitialized()) {
            wf();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.aoa;
        if (bVar != null) {
            bVar.unregisterDataSetObserver(this.aqL);
            this.aoa.a((d.a) null);
        }
    }

    public void setListAdapter(b bVar, final com.applovin.impl.sdk.a aVar) {
        DataSetObserver dataSetObserver;
        b bVar2 = this.aoa;
        if (!(bVar2 == null || (dataSetObserver = this.aqL) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.aoa = bVar;
        this.aqL = new DataSetObserver() {
            public void onChanged() {
                a.this.wg();
                a aVar = a.this;
                aVar.w(aVar);
            }
        };
        w(this);
        this.aoa.registerDataSetObserver(this.aqL);
        this.aoa.a(new d.a() {
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, final c cVar) {
                int wP = aVar.wP();
                if (wP == b.e.APP_INFO.ordinal()) {
                    u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                } else if (wP == b.e.MAX.ordinal()) {
                    n sdk = a.this.aoa.getSdk();
                    if (sdk.Cl().isEnabled()) {
                        int wQ = aVar.wQ();
                        if (sdk.Cl().zX() == d.a.TERMS) {
                            wQ++;
                        }
                        if (wQ == b.c.PRIVACY_POLICY_URL.ordinal()) {
                            if (sdk.Cl().getPrivacyPolicyUri() != null) {
                                s.a(sdk.Cl().getPrivacyPolicyUri(), n.getApplicationContext(), sdk);
                                return;
                            } else {
                                u.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", (Context) a.this);
                                return;
                            }
                        } else if (wQ == b.c.TERMS_OF_SERVICE_URL.ordinal()) {
                            if (sdk.Cl().getTermsOfServiceUri() != null) {
                                s.a(sdk.Cl().getTermsOfServiceUri(), n.getApplicationContext(), sdk);
                                return;
                            }
                            return;
                        }
                    }
                    u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                } else if (wP == b.e.PRIVACY.ordinal()) {
                    if (aVar.wQ() == b.d.CMP.ordinal()) {
                        if (StringUtils.isValidString(a.this.aoa.getSdk().Cm().Am())) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTcfInfoListActivity.class, aVar, new b.a<MaxDebuggerTcfInfoListActivity>() {
                                /* renamed from: a */
                                public void onActivityCreated(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                                    maxDebuggerTcfInfoListActivity.initialize(a.this.aoa.getSdk());
                                }
                            });
                        } else {
                            u.a("", cVar.vQ(), (Context) a.this);
                        }
                    } else if (aVar.wQ() == b.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTcfConsentStatusesListActivity.class, aVar, new b.a<MaxDebuggerTcfConsentStatusesListActivity>() {
                            /* renamed from: a */
                            public void onActivityCreated(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                                maxDebuggerTcfConsentStatusesListActivity.initialize(a.this.aoa.getSdk());
                            }
                        });
                    }
                } else if (wP == b.e.ADS.ordinal()) {
                    if (aVar.wQ() == b.a.AD_UNITS.ordinal()) {
                        if (a.this.aoa.wi().size() > 0) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerAdUnitsListActivity.class, aVar, new b.a<MaxDebuggerAdUnitsListActivity>() {
                                /* renamed from: a */
                                public void onActivityCreated(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(a.this.aoa.wi(), false, a.this.aoa.getSdk());
                                }
                            });
                        } else {
                            u.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", (Context) a.this);
                        }
                    } else if (aVar.wQ() == b.a.SELECT_LIVE_NETWORKS.ordinal()) {
                        if (a.this.aoa.wl().size() <= 0 && a.this.aoa.wm().size() <= 0) {
                            u.a("Complete Integrations", "Please complete integrations in order to access this.", (Context) a.this);
                        } else if (a.this.aoa.getSdk().CE().isEnabled()) {
                            u.a("Restart Required", cVar.vQ(), (Context) a.this);
                        } else {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTestLiveNetworkActivity.class, aVar, new b.a<MaxDebuggerTestLiveNetworkActivity>() {
                                /* renamed from: a */
                                public void onActivityCreated(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                    maxDebuggerTestLiveNetworkActivity.initialize(a.this.aoa.wl(), a.this.aoa.wm(), a.this.aoa.getSdk());
                                }
                            });
                        }
                    } else if (aVar.wQ() == b.a.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                        if (!a.this.aoa.getSdk().CE().isEnabled()) {
                            a.this.getSdk().CE().xl();
                            u.a("Restart Required", cVar.vQ(), (Context) a.this);
                        } else if (a.this.aoa.wn().size() > 0) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTestModeNetworkActivity.class, aVar, new b.a<MaxDebuggerTestModeNetworkActivity>() {
                                /* renamed from: a */
                                public void onActivityCreated(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                                    maxDebuggerTestModeNetworkActivity.initialize(a.this.aoa.wn(), a.this.aoa.getSdk());
                                }
                            });
                        } else {
                            u.a("Complete Integrations", "Please complete integrations in order to access this.", (Context) a.this);
                        }
                    } else if (aVar.wQ() == b.a.INITIALIZATION_AD_UNITS.ordinal()) {
                        com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerAdUnitsListActivity.class, aVar, new b.a<MaxDebuggerAdUnitsListActivity>() {
                            /* renamed from: a */
                            public void onActivityCreated(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                maxDebuggerAdUnitsListActivity.initialize(a.this.aoa.wj(), true, a.this.aoa.getSdk());
                            }
                        });
                    }
                } else if ((wP == b.e.INCOMPLETE_NETWORKS.ordinal() || wP == b.e.COMPLETED_NETWORKS.ordinal()) && (cVar instanceof com.applovin.impl.mediation.debugger.ui.b.a.a)) {
                    com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerDetailActivity.class, aVar, new b.a<MaxDebuggerDetailActivity>() {
                        /* renamed from: a */
                        public void onActivityCreated(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((com.applovin.impl.mediation.debugger.ui.b.a.a) cVar).wA());
                        }
                    });
                }
            }
        });
    }

    private void we() {
        String wo = this.aoa.wo();
        if (!TextUtils.isEmpty(wo)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("android.intent.extra.TEXT", wo);
            intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
            intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
            startActivity(Intent.createChooser(intent, (CharSequence) null));
        }
    }

    private void wf() {
        wg();
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(this, 50, 16842874);
        this.aqM = aVar;
        aVar.setColor(-3355444);
        this.akw.addView(this.aqM, new FrameLayout.LayoutParams(-1, -1, 17));
        this.akw.bringChildToFront(this.aqM);
        this.aqM.qN();
    }

    /* access modifiers changed from: private */
    public void wg() {
        com.applovin.impl.adview.a aVar = this.aqM;
        if (aVar != null) {
            aVar.qO();
            this.akw.removeView(this.aqM);
            this.aqM = null;
        }
    }

    /* access modifiers changed from: private */
    public void w(Context context) {
        if (StringUtils.isValidString(this.aoa.vQ()) && !this.aoa.wh()) {
            this.aoa.az(true);
            runOnUiThread(new a$$ExternalSyntheticLambda0(this, context));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Context context) {
        u.a(this.aoa.wk(), this.aoa.vQ(), context);
    }
}
