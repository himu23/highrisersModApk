package com.applovin.impl.sdk.network;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import java.util.Map;

public class PostbackServiceImpl implements AppLovinPostbackService {
    private final n sdk;

    public String toString() {
        return "PostbackService{}";
    }

    public PostbackServiceImpl(n nVar) {
        this.sdk = nVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(i.E(this.sdk).cW(str).aS(false).Ig(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(iVar, q.b.POSTBACKS, appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, q.b bVar, AppLovinPostbackListener appLovinPostbackListener) {
        j jVar = new j(iVar, bVar, this.sdk, appLovinPostbackListener);
        jVar.bf(a(iVar));
        this.sdk.BO().a((d) jVar, bVar);
    }

    private boolean a(i iVar) {
        Map HR = iVar.HR();
        if (HR == null) {
            return false;
        }
        Object obj = HR.get(NotificationCompat.CATEGORY_EVENT);
        if ("postinstall".equals(obj)) {
            obj = HR.get("sub_event");
        }
        return EventServiceImpl.ALLOW_PRE_INIT_EVENT_TYPES.contains(obj);
    }
}
