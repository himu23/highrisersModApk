package com.ironsource;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0005\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\n¨\u0006\f"}, d2 = {"Lcom/ironsource/r5;", "T", "", "listener", "", "a", "(Ljava/lang/Object;)V", "", "instanceId", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;)Ljava/lang/Object;", "b", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface r5<T> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/r5$a;", "Lcom/ironsource/r5;", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyInterstitialListener;", "listener", "", "a", "", "instanceId", "b", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyInterstitialListener;", "defaultListener", "", "Lcom/ironsource/q5;", "Ljava/util/Map;", "listenerWrappers", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements r5<ISDemandOnlyInterstitialListener> {
        private ISDemandOnlyInterstitialListener a = new q5();
        private final Map<String, q5> b = new HashMap();

        public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            Intrinsics.checkNotNullParameter(iSDemandOnlyInterstitialListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a = new q5(iSDemandOnlyInterstitialListener);
            for (String put : this.b.keySet()) {
                Map<String, q5> map = this.b;
                ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener2 = this.a;
                Intrinsics.checkNotNull(iSDemandOnlyInterstitialListener2, "null cannot be cast to non-null type com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListenerWrapper");
                map.put(put, (q5) iSDemandOnlyInterstitialListener2);
            }
        }

        public void a(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            Intrinsics.checkNotNullParameter(iSDemandOnlyInterstitialListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.put(str, new q5(iSDemandOnlyInterstitialListener));
        }

        /* renamed from: b */
        public ISDemandOnlyInterstitialListener a(String str) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            q5 q5Var = this.b.get(str);
            return q5Var != null ? q5Var : this.a;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/r5$b;", "Lcom/ironsource/r5;", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyRewardedVideoListener;", "listener", "", "a", "", "instanceId", "b", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyRewardedVideoListener;", "defaultListener", "", "Lcom/ironsource/s5;", "Ljava/util/Map;", "listenerWrappers", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements r5<ISDemandOnlyRewardedVideoListener> {
        private ISDemandOnlyRewardedVideoListener a = new s5();
        private final Map<String, s5> b = new HashMap();

        public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            Intrinsics.checkNotNullParameter(iSDemandOnlyRewardedVideoListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a = new s5(iSDemandOnlyRewardedVideoListener);
            for (String put : this.b.keySet()) {
                Map<String, s5> map = this.b;
                ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener2 = this.a;
                Intrinsics.checkNotNull(iSDemandOnlyRewardedVideoListener2, "null cannot be cast to non-null type com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListenerWrapper");
                map.put(put, (s5) iSDemandOnlyRewardedVideoListener2);
            }
        }

        public void a(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            Intrinsics.checkNotNullParameter(iSDemandOnlyRewardedVideoListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.put(str, new s5(iSDemandOnlyRewardedVideoListener));
        }

        /* renamed from: b */
        public ISDemandOnlyRewardedVideoListener a(String str) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            s5 s5Var = this.b.get(str);
            return s5Var != null ? s5Var : this.a;
        }
    }

    T a(String str);

    void a(T t);

    void a(String str, T t);
}
