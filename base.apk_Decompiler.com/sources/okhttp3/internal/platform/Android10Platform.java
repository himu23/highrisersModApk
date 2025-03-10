package okhttp3.internal.platform;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;
import okhttp3.Protocol;

class Android10Platform extends AndroidPlatform {
    Android10Platform(Class<?> cls) {
        super(cls, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null);
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            enableSessionTickets(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    private void enableSessionTickets(SSLSocket sSLSocket) {
        if (StreamsKt$$ExternalSyntheticApiModelOutline0.m(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(sSLSocket);
        if (m == null || m.isEmpty()) {
            return null;
        }
        return m;
    }

    @Nullable
    public static Platform buildIfSupported() {
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            if (getSdkInt() >= 29) {
                return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }
}
