package com.ironsource;

import com.ironsource.y;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ironsource/ua;", "configs", "", "isManual", "Lcom/ironsource/y;", "b", "mediationsdk_release"}, k = 2, mv = {1, 8, 0})
public final class ra {
    /* access modifiers changed from: private */
    public static final y b(ua uaVar, boolean z) {
        return new y(z ? y.a.MANUAL : uaVar.k().e() ? y.a.AUTOMATIC_LOAD_WHILE_SHOW : y.a.AUTOMATIC_LOAD_AFTER_CLOSE, uaVar.k().j(), uaVar.k().b(), -1);
    }
}
