package com.fyber.inneractive.sdk.bidder;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.serverapi.b;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class a implements d, f0.a {
    public static final a h = new a();
    public final TokenParametersOuterClass$TokenParameters.b a;
    public final b b;
    public final c c;
    public e d;
    public final AtomicReference<String> e = new AtomicReference<>((Object) null);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final Object g = new Object();

    /* renamed from: com.fyber.inneractive.sdk.bidder.a$a  reason: collision with other inner class name */
    public class C0086a implements Runnable {
        public C0086a() {
        }

        public void run() {
            a.this.a();
        }
    }

    public a() {
        b bVar = new b(s.b());
        this.b = bVar;
        c cVar = new c(bVar);
        this.c = cVar;
        this.a = TokenParametersOuterClass$TokenParameters.newBuilder();
        IAConfigManager.e().a((f0.a) this);
        c();
        if (IAConfigManager.c().a().a("bidding_token_wait_for_ua", true)) {
            IAConfigManager.f().d();
            cVar.a(IAConfigManager.f().a());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x04b9, code lost:
        if (r8.equals("3") == false) goto L_0x04b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r15.f
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x05ef
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            MessageType r3 = r0.b
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$f r4 = com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.f.NEW_MUTABLE_INSTANCE
            java.lang.Object r3 = r3.dynamicMethod(r4)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r3 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite) r3
            r0.b = r3
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            r3.getClass()
            java.lang.String r3 = "1.2"
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setVersion(r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r0 = r15.e
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x003c
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            r0.a()
        L_0x003c:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setUserAgent(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.c
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setSdkVersion(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.d
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setBundleID(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.e
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceModel(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.f
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setAppVersion(r3)
            java.lang.String r3 = "Android"
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceOS(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r3 = com.fyber.inneractive.sdk.bidder.f.a((int) r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceApi(r3)
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setOsVersion(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.g
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceLanguage(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.h
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setCountryCode(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.i
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setCarrierName(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.j
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setMobileCountryCode(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.k
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setMobileNetworkCode(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.Long r3 = r3.l
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableSInt32$a r4 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.NullableSInt32.newBuilder()
            if (r3 == 0) goto L_0x013a
            int r3 = r3.intValue()
            r4.c()
            MessageType r5 = r4.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableSInt32 r5 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.NullableSInt32) r5
            r5.setData(r3)
        L_0x013a:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r3 = r4.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableSInt32 r3 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.NullableSInt32) r3
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setOffsetFromGMT(r3)
            java.lang.String r3 = com.fyber.inneractive.sdk.config.IAConfigManager.g()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setUserID(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            int r3 = r3.m
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r3 = com.fyber.inneractive.sdk.bidder.f.a((int) r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceWidth(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            int r3 = r3.n
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r3 = com.fyber.inneractive.sdk.bidder.f.a((int) r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setDeviceHeight(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$d r3 = r3.o
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setFrameworkName(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.p
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r4 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r4
            r4.setInputLanguages(r3)
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.I
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setMediationType(r3)
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.d r3 = r0.D
            r4 = 0
            if (r3 == 0) goto L_0x0229
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r5 = r15.a
            android.app.Application r6 = com.fyber.inneractive.sdk.util.p.a
            if (r6 != 0) goto L_0x01c1
            r6 = r4
            goto L_0x01c3
        L_0x01c1:
            java.lang.String r6 = r3.b
        L_0x01c3:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r6 = com.fyber.inneractive.sdk.bidder.f.c(r6)
            r5.c()
            MessageType r7 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r7
            r7.setGdprString(r6)
            java.lang.Boolean r6 = r3.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r6 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r6)
            r5.c()
            MessageType r7 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r7
            r7.setGdprConsent(r6)
            android.app.Application r6 = com.fyber.inneractive.sdk.util.p.a
            if (r6 != 0) goto L_0x01e9
            r6 = r4
            goto L_0x01eb
        L_0x01e9:
            java.lang.String r6 = r3.e
        L_0x01eb:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r6 = com.fyber.inneractive.sdk.bidder.f.c(r6)
            r5.c()
            MessageType r7 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r7
            r7.setCcpaString(r6)
            android.app.Application r6 = com.fyber.inneractive.sdk.util.p.a
            if (r6 != 0) goto L_0x01ff
            r6 = r4
            goto L_0x0201
        L_0x01ff:
            java.lang.Boolean r6 = r3.f
        L_0x0201:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r6 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r6)
            r5.c()
            MessageType r5 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r5 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r5
            r5.setLgpdConsent(r6)
            java.lang.Boolean r3 = r3.g
            if (r3 == 0) goto L_0x0229
            boolean r5 = r3.booleanValue()
            if (r5 == 0) goto L_0x0229
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r5 = r15.a
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r3 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r3)
            r5.c()
            MessageType r5 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r5 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r5
            r5.setCoppaApplies(r3)
        L_0x0229:
            boolean r3 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
            if (r3 != 0) goto L_0x023f
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r3 = r15.a
            boolean r5 = com.fyber.inneractive.sdk.config.l.c()
            r3.c()
            MessageType r3 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r3 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r3
            r3.setDnt(r5)
        L_0x023f:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r3 = r15.a
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.String r5 = r5.q
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r5 = com.fyber.inneractive.sdk.bidder.f.c(r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setNetwork(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$h r5 = r5.r
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setSecureContent(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.B
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setBatteryCharging(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.s
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setHeadsetPlugged(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.t
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setBluetoothPlugged(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.u
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setLowPowerMode(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            boolean r5 = r5.v
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setDarkMode(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.w
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setAirplaneMode(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.x
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setDndMode(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.Boolean r5 = r5.y
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r5 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setIsRingMuted(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            int r5 = r5.z
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r5 = com.fyber.inneractive.sdk.bidder.f.a((int) r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setSessionDuration(r5)
            com.fyber.inneractive.sdk.bidder.c r5 = r15.c
            java.lang.String r5 = r5.C
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r5 = com.fyber.inneractive.sdk.bidder.f.b(r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setBatteryLevel(r5)
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r5 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL
            com.fyber.inneractive.sdk.config.f0 r0 = r0.x
            java.lang.String r6 = "LAST_VAST_SKIPED"
            java.lang.String r0 = r0.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r5, (java.lang.String) r6)
            java.lang.String r5 = "1"
            boolean r0 = android.text.TextUtils.equals(r0, r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r0 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r0)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setPriorSkip(r0)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            java.lang.String r0 = r0.D
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r0 = com.fyber.inneractive.sdk.bidder.f.c(r0)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setKeywords(r0)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            int r0 = r0.E
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r0 = com.fyber.inneractive.sdk.bidder.f.a((int) r0)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setUserAge(r0)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            com.fyber.inneractive.sdk.external.InneractiveUserConfig$Gender r0 = r0.F
            com.fyber.inneractive.sdk.external.InneractiveUserConfig$Gender r6 = com.fyber.inneractive.sdk.external.InneractiveUserConfig.Gender.FEMALE
            if (r0 != r6) goto L_0x0362
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$l r0 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.l.FEMALE
            goto L_0x036b
        L_0x0362:
            com.fyber.inneractive.sdk.external.InneractiveUserConfig$Gender r6 = com.fyber.inneractive.sdk.external.InneractiveUserConfig.Gender.MALE
            if (r0 != r6) goto L_0x0369
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$l r0 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.l.MALE
            goto L_0x036b
        L_0x0369:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$l r0 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.l.UNKNOWN
        L_0x036b:
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setUserGender(r0)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            java.lang.String r0 = r0.H
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r0 = com.fyber.inneractive.sdk.bidder.f.c(r0)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r6
            r6.setZipCode(r0)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            boolean r0 = r0.G
            r3.c()
            MessageType r3 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r3 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r3
            r3.setMuteAudio(r0)
            boolean r0 = com.fyber.inneractive.sdk.config.l.b()
            if (r0 == 0) goto L_0x03b0
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.A
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setAmazonId(r3)
            goto L_0x03c4
        L_0x03b0:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r3 = r15.c
            java.lang.String r3 = r3.A
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r3 = com.fyber.inneractive.sdk.bidder.f.c(r3)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setAaid(r3)
        L_0x03c4:
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r0 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
            int r3 = r0.length
            r6 = 0
        L_0x03ca:
            r7 = 2
            if (r6 >= r3) goto L_0x0505
            r8 = r0[r6]
            boolean r9 = r8.isDeprecated()
            if (r9 != 0) goto L_0x0501
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$k r9 = com.fyber.inneractive.sdk.bidder.f.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8)
            java.util.HashMap<java.lang.String, java.lang.Integer> r10 = com.fyber.inneractive.sdk.serverapi.a.a
            com.fyber.inneractive.sdk.config.IAConfigManager r10 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.f0 r11 = r10.x
            java.lang.String r12 = "LAST_DOMAIN_SHOWED"
            java.lang.String r11 = r11.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8, (java.lang.String) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x03f9
            java.lang.String r12 = ","
            boolean r13 = r11.contains(r12)
            if (r13 == 0) goto L_0x03f9
            java.lang.String[] r11 = r11.split(r12)
            r11 = r11[r1]
        L_0x03f9:
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x0429
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r12 = r15.a
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdomain$a r13 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdomain.newBuilder()
            r13.c()
            MessageType r14 = r13.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdomain r14 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdomain) r14
            r14.setAdomain(r11)
            r13.c()
            MessageType r11 = r13.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdomain r11 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdomain) r11
            r11.setType(r9)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r11 = r13.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdomain r11 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdomain) r11
            r12.c()
            MessageType r12 = r12.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r12 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r12
            r12.addLastAdomains(r11)
        L_0x0429:
            com.fyber.inneractive.sdk.config.f0 r11 = r10.x
            java.lang.String r12 = "LAST_APP_BUNDLE_ID"
            java.lang.String r11 = r11.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8, (java.lang.String) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x0461
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r12 = r15.a
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdvertisedBundle$a r13 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.newBuilder()
            r13.c()
            MessageType r14 = r13.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdvertisedBundle r14 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) r14
            r14.setLastBundle(r11)
            r13.c()
            MessageType r11 = r13.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdvertisedBundle r11 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) r11
            r11.setType(r9)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r11 = r13.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$LastAdvertisedBundle r11 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) r11
            r12.c()
            MessageType r12 = r12.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r12 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r12
            r12.addLastAdvertisedBundles(r11)
        L_0x0461:
            com.fyber.inneractive.sdk.config.f0 r11 = r10.x
            java.lang.String r12 = "LAST_CLICKED"
            java.lang.String r11 = r11.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8, (java.lang.String) r12)
            boolean r11 = android.text.TextUtils.equals(r11, r5)
            if (r11 == 0) goto L_0x047f
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r11 = r15.a
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$k r12 = com.fyber.inneractive.sdk.bidder.f.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8)
            r11.c()
            MessageType r11 = r11.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r11 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r11
            r11.addPriorClicks(r12)
        L_0x047f:
            java.lang.String r11 = "display"
            r15.a(r11, r8, r9)
            boolean r11 = r8.isFullscreenUnit()
            if (r11 == 0) goto L_0x0501
            java.lang.String r11 = "video"
            r15.a(r11, r8, r9)
            com.fyber.inneractive.sdk.config.f0 r10 = r10.x
            java.lang.String r11 = "LAST_VAST_CLICKED_TYPE"
            java.lang.String r8 = r10.a((com.fyber.inneractive.sdk.config.enums.UnitDisplayType) r8, (java.lang.String) r11)
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 != 0) goto L_0x0501
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r10 = r15.a
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$PriorVideoClickType$a r11 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.PriorVideoClickType.newBuilder()
            r8.getClass()
            r8.hashCode()
            int r12 = r8.hashCode()
            r13 = -1
            switch(r12) {
                case 49: goto L_0x04c7;
                case 50: goto L_0x04bc;
                case 51: goto L_0x04b3;
                default: goto L_0x04b1;
            }
        L_0x04b1:
            r7 = -1
            goto L_0x04cf
        L_0x04b3:
            java.lang.String r12 = "3"
            boolean r8 = r8.equals(r12)
            if (r8 != 0) goto L_0x04cf
            goto L_0x04b1
        L_0x04bc:
            java.lang.String r7 = "2"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x04c5
            goto L_0x04b1
        L_0x04c5:
            r7 = 1
            goto L_0x04cf
        L_0x04c7:
            boolean r7 = r8.equals(r5)
            if (r7 != 0) goto L_0x04ce
            goto L_0x04b1
        L_0x04ce:
            r7 = 0
        L_0x04cf:
            switch(r7) {
                case 0: goto L_0x04db;
                case 1: goto L_0x04d8;
                case 2: goto L_0x04d5;
                default: goto L_0x04d2;
            }
        L_0x04d2:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$n r7 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.n.NOCLICK
            goto L_0x04dd
        L_0x04d5:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$n r7 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.n.VIDEOVIEW
            goto L_0x04dd
        L_0x04d8:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$n r7 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.n.COMPANION
            goto L_0x04dd
        L_0x04db:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$n r7 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.n.CTABUTTON
        L_0x04dd:
            r11.c()
            MessageType r8 = r11.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$PriorVideoClickType r8 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.PriorVideoClickType) r8
            r8.setClickType(r7)
            r11.c()
            MessageType r7 = r11.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$PriorVideoClickType r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.PriorVideoClickType) r7
            r7.setType(r9)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r7 = r11.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$PriorVideoClickType r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.PriorVideoClickType) r7
            r10.c()
            MessageType r8 = r10.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r8 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r8
            r8.addPriorClickTypes(r7)
        L_0x0501:
            int r6 = r6 + 1
            goto L_0x03ca
        L_0x0505:
            com.fyber.inneractive.sdk.serverapi.b r0 = r15.b
            r0.getClass()
            com.fyber.inneractive.sdk.config.global.s r2 = com.fyber.inneractive.sdk.config.global.s.b()
            r0.a = r2
            java.lang.String r0 = ""
            r2.a(r0, r1)
            com.fyber.inneractive.sdk.serverapi.b r0 = r15.b
            com.fyber.inneractive.sdk.config.global.s r0 = r0.a
            if (r0 == 0) goto L_0x051f
            org.json.JSONArray r4 = r0.d()
        L_0x051f:
            if (r4 == 0) goto L_0x0567
            r0 = 0
        L_0x0522:
            int r2 = r4.length()
            if (r0 >= r2) goto L_0x0567
            org.json.JSONObject r2 = r4.optJSONObject(r0)
            if (r2 == 0) goto L_0x0564
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$Experiment$a r3 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.Experiment.newBuilder()
            java.lang.String r5 = "id"
            java.lang.String r5 = r2.optString(r5)
            r3.c()
            MessageType r6 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$Experiment r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.Experiment) r6
            r6.setIdentifier(r5)
            java.lang.String r5 = "v"
            java.lang.String r2 = r2.optString(r5)
            r3.c()
            MessageType r5 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$Experiment r5 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.Experiment) r5
            r5.setVariant(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r2 = r15.a
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r3 = r3.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$Experiment r3 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.Experiment) r3
            r2.c()
            MessageType r2 = r2.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r2 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r2
            r2.addAbExperiments(r3)
        L_0x0564:
            int r0 = r0 + 1
            goto L_0x0522
        L_0x0567:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            int r2 = com.fyber.inneractive.sdk.config.f.a
            java.lang.String r2 = "ia.testEnvironmentConfiguration.number"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableUInt32 r2 = com.fyber.inneractive.sdk.bidder.f.b(r2)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setPortal(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            java.lang.String r2 = "ia.testEnvironmentConfiguration.response"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r2 = com.fyber.inneractive.sdk.bidder.f.c(r2)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setMockResponseId(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r2 = r15.c
            java.lang.String r2 = r2.J
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r2 = com.fyber.inneractive.sdk.bidder.f.c(r2)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setIgniteVersion(r2)
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.bidder.c r2 = r15.c
            java.lang.String r2 = r2.K
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableString r2 = com.fyber.inneractive.sdk.bidder.f.c(r2)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setIgnitePackageName(r2)
            com.fyber.inneractive.sdk.bidder.c r0 = r15.c
            boolean r0 = r0.L
            if (r0 == 0) goto L_0x05d5
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$NullableBool r2 = com.fyber.inneractive.sdk.bidder.f.a((java.lang.Boolean) r2)
            r0.c()
            MessageType r0 = r0.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            r0.setChildMode(r2)
        L_0x05d5:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r0 = r15.a
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r0 = r0.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r0 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r0
            byte[] r0 = r0.toByteArray()
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r2 = r15.e
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r7)
            r2.set(r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r15.f
            r0.set(r1)
        L_0x05ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.bidder.a.a():void");
    }

    public void b() {
        q.a(new C0086a());
    }

    public final void c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) p.a.getSystemService("connectivity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && !InneractiveAdManager.isCurrentUserAChild()) {
            connectivityManager.registerDefaultNetworkCallback(new b(this));
        }
        e eVar = new e(this);
        this.d = eVar;
        p.a.registerReceiver(eVar, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        p.a.registerReceiver(eVar, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (i >= 23) {
            p.a.registerReceiver(eVar, new IntentFilter("android.app.action.INTERRUPTION_FILTER_CHANGED"));
        }
        p.a.registerReceiver(eVar, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        p.a.registerReceiver(eVar, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        if (p.b("android.permission.BLUETOOTH")) {
            p.a.registerReceiver(eVar, new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"));
            p.a.registerReceiver(eVar, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    /* JADX WARNING: type inference failed for: r9v8, types: [com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, com.fyber.inneractive.sdk.config.enums.UnitDisplayType r10, com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.k r11) {
        /*
            r8 = this;
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.f0 r0 = r0.x
            com.fyber.inneractive.sdk.cache.session.d r0 = r0.a
            if (r0 == 0) goto L_0x00e7
            java.lang.String r10 = r10.value()
            java.util.HashMap<com.fyber.inneractive.sdk.cache.session.enums.b, com.fyber.inneractive.sdk.cache.session.h> r1 = r0.b
            com.fyber.inneractive.sdk.cache.session.enums.b r10 = com.fyber.inneractive.sdk.cache.session.enums.b.a(r10, r9)
            java.lang.Object r10 = r1.get(r10)
            com.fyber.inneractive.sdk.cache.session.h r10 = (com.fyber.inneractive.sdk.cache.session.h) r10
            r1 = 0
            if (r10 == 0) goto L_0x002e
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r10)
            com.fyber.inneractive.sdk.cache.session.g r4 = new com.fyber.inneractive.sdk.cache.session.g
            r4.<init>(r10)
            java.util.Collections.sort(r3, r4)
            r2.<init>(r3)
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r10 = r0.a()
            if (r10 <= 0) goto L_0x00cf
            if (r2 == 0) goto L_0x00cf
            int r0 = r2.size()
            if (r0 < r10) goto L_0x00cf
            java.lang.String r0 = "video"
            boolean r1 = r9.equals(r0)
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "display"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x0050
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$j r1 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.j.UNITCONTENTTYPEUNKNOWN
            goto L_0x0055
        L_0x0050:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$j r1 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.j.DISPLAY
            goto L_0x0055
        L_0x0053:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$j r1 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.j.VIDEO
        L_0x0055:
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$UserSession$a r3 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.UserSession.newBuilder()
            r3.c()
            MessageType r4 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$UserSession r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.UserSession) r4
            r4.setSubType(r1)
            java.util.Iterator r1 = r2.iterator()
            r2 = 0
        L_0x0068:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00be
            java.lang.Object r4 = r1.next()
            com.fyber.inneractive.sdk.cache.session.e r4 = (com.fyber.inneractive.sdk.cache.session.e) r4
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$SessionData$a r5 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.SessionData.newBuilder()
            int r6 = r4.b
            r5.c()
            MessageType r7 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$SessionData r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.SessionData) r7
            r7.setClicks(r6)
            int r6 = r4.a
            r5.c()
            MessageType r7 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$SessionData r7 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.SessionData) r7
            r7.setImpressions(r6)
            boolean r6 = r9.equals(r0)
            if (r6 != 0) goto L_0x009e
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$k r6 = com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.k.REWARDED
            boolean r6 = r11.equals(r6)
            if (r6 == 0) goto L_0x00aa
        L_0x009e:
            int r4 = r4.c
            r5.c()
            MessageType r6 = r5.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$SessionData r6 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.SessionData) r6
            r6.setCompletions(r4)
        L_0x00aa:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r4 = r5.a()
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$SessionData r4 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.SessionData) r4
            r3.c()
            MessageType r5 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$UserSession r5 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.UserSession) r5
            r5.addSessionDataItems(r4)
            int r2 = r2 + 1
            if (r2 < r10) goto L_0x0068
        L_0x00be:
            r3.c()
            MessageType r9 = r3.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$UserSession r9 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.UserSession) r9
            r9.setType(r11)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r9 = r3.a()
            r1 = r9
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$UserSession r1 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters.UserSession) r1
        L_0x00cf:
            if (r1 == 0) goto L_0x00e7
            java.util.List r9 = r1.getSessionDataItemsList()
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x00e7
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$b r9 = r8.a
            r9.c()
            MessageType r9 = r9.b
            com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters r9 = (com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters) r9
            r9.addUserSessions(r1)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.bidder.a.a(java.lang.String, com.fyber.inneractive.sdk.config.enums.UnitDisplayType, com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters$k):void");
    }
}
