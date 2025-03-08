package com.ironsource.adapters.ironsource;

import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.z3;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\n\u000b\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\r"}, d2 = {"Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters;", "", "config", "Lorg/json/JSONObject;", "demandOnly", "", "value", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Base", "Constants", "WithLog", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IronSourceLoadParameters {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters$Base;", "Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters;", "loadConfig", "Lorg/json/JSONObject;", "serverData", "", "(Lorg/json/JSONObject;Ljava/lang/String;)V", "config", "demandOnly", "", "value", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Base implements IronSourceLoadParameters {
        private final JSONObject loadConfig;
        private final String serverData;

        public Base(JSONObject jSONObject, String str) {
            Intrinsics.checkNotNullParameter(jSONObject, "loadConfig");
            this.loadConfig = jSONObject;
            this.serverData = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Base(JSONObject jSONObject, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(jSONObject, (i & 2) != 0 ? null : str);
        }

        public JSONObject config() {
            return this.loadConfig;
        }

        public boolean demandOnly() {
            return this.loadConfig.optBoolean(Constants.DEMAND_ONLY, false);
        }

        public HashMap<String, String> value() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isOneFlow", String.valueOf(this.loadConfig.optBoolean("isOneFlow")));
            if (this.serverData != null) {
                String b = d.c().b(this.serverData);
                Intrinsics.checkNotNullExpressionValue(b, "getInstance().getAdmFromServerData(serverData)");
                hashMap.put("adm", b);
                hashMap.putAll(d.c().c(this.serverData));
            }
            return hashMap;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters$Constants;", "", "()V", "ADM_KEY", "", "DEMAND_ONLY", "ONE_FLOW_KEY", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Constants {
        public static final String ADM_KEY = "adm";
        public static final String DEMAND_ONLY = "demandOnly";
        public static final Constants INSTANCE = new Constants();
        public static final String ONE_FLOW_KEY = "isOneFlow";

        private Constants() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters$WithLog;", "Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters;", "loadParameters", "(Lcom/ironsource/adapters/ironsource/IronSourceLoadParameters;)V", "config", "Lorg/json/JSONObject;", "demandOnly", "", "value", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WithLog implements IronSourceLoadParameters {
        private final IronSourceLoadParameters loadParameters;

        public WithLog(IronSourceLoadParameters ironSourceLoadParameters) {
            Intrinsics.checkNotNullParameter(ironSourceLoadParameters, "loadParameters");
            this.loadParameters = ironSourceLoadParameters;
        }

        public JSONObject config() {
            return this.loadParameters.config();
        }

        public boolean demandOnly() {
            return this.loadParameters.demandOnly();
        }

        public HashMap<String, String> value() {
            HashMap<String, String> value = this.loadParameters.value();
            if (!value.isEmpty()) {
                IronLog.ADAPTER_API.verbose("instance extra params:");
                for (String next : value.keySet()) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(next + z3.R + value.get(next));
                }
            }
            return value;
        }
    }

    JSONObject config();

    boolean demandOnly();

    HashMap<String, String> value();
}
