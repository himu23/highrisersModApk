package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform extends Platform {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> alpnProtocolNames = alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(alpnProtocolNames));
            this.putMethod.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to set alpn", e);
        }
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to remove alpn", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
            if (!jettyNegoProvider.unsupported && jettyNegoProvider.selected == null) {
                Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (jettyNegoProvider.unsupported) {
                return null;
            } else {
                return jettyNegoProvider.selected;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to get selected protocol", e);
        }
    }

    public static Platform buildIfSupported() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", new Class[]{SSLSocket.class, cls2}), cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    private static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        String selected;
        boolean unsupported;

        JettyNegoProvider(List<String> list) {
            this.protocols = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        List list = (List) obj2;
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (this.protocols.contains(list.get(i))) {
                                String str = (String) list.get(i);
                                this.selected = str;
                                return str;
                            }
                        }
                        String str2 = this.protocols.get(0);
                        this.selected = str2;
                        return str2;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.selected = (String) objArr[0];
                return null;
            }
        }
    }
}
