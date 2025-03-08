package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "Lcom/unity3d/ads/core/configuration/MetadataReader;", "", "jsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", "(Lcom/unity3d/services/core/misc/JsonStorage;)V", "invoke", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlternativeFlowReader.kt */
public final class AlternativeFlowReader extends MetadataReader<Boolean> {
    public static final String ALTERNATIVE_FLOW_ENABLED_KEY = "adsGateway.value";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlternativeFlowReader(JsonStorage jsonStorage) {
        super(jsonStorage, ALTERNATIVE_FLOW_ENABLED_KEY);
        Intrinsics.checkNotNullParameter(jsonStorage, "jsonStorage");
    }

    public final boolean invoke() {
        boolean booleanValue;
        Object obj = getJsonStorage().get(ALTERNATIVE_FLOW_ENABLED_KEY);
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            booleanValue = Boolean.parseBoolean((String) obj);
        } else if (!(obj instanceof Boolean)) {
            return false;
        } else {
            booleanValue = ((Boolean) obj).booleanValue();
        }
        return booleanValue;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/core/configuration/AlternativeFlowReader$Companion;", "", "()V", "ALTERNATIVE_FLOW_ENABLED_KEY", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AlternativeFlowReader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
