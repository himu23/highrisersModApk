package com.applovin.array.apphub.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppHubService extends IInterface {

    public static class Default implements IAppHubService {
        public IBinder asBinder() {
            return null;
        }

        public void directInstall(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
        }

        public void dismissDirectDownloadAppDetails(String str) throws RemoteException {
        }

        public long getAppHubVersionCode() throws RemoteException {
            return 0;
        }

        public Bundle getEnabledFeatures() throws RemoteException {
            return null;
        }

        public String getRandomUserToken() throws RemoteException {
            return null;
        }

        public void showDirectDownloadAppDetails(String str, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
        }

        public void showDirectDownloadAppDetailsWithExtra(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
        }
    }

    void directInstall(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException;

    void dismissDirectDownloadAppDetails(String str) throws RemoteException;

    long getAppHubVersionCode() throws RemoteException;

    Bundle getEnabledFeatures() throws RemoteException;

    String getRandomUserToken() throws RemoteException;

    void showDirectDownloadAppDetails(String str, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException;

    void showDirectDownloadAppDetailsWithExtra(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IAppHubService {
        private static final String DESCRIPTOR = "com.applovin.array.apphub.aidl.IAppHubService";
        static final int TRANSACTION_directInstall = 7;
        static final int TRANSACTION_dismissDirectDownloadAppDetails = 5;
        static final int TRANSACTION_getAppHubVersionCode = 2;
        static final int TRANSACTION_getEnabledFeatures = 3;
        static final int TRANSACTION_getRandomUserToken = 1;
        static final int TRANSACTION_showDirectDownloadAppDetails = 4;
        static final int TRANSACTION_showDirectDownloadAppDetailsWithExtra = 6;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAppHubService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAppHubService)) {
                return new Proxy(iBinder);
            }
            return (IAppHubService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.applovin.array.apphub.aidl.IAppHubService"
                if (r4 == r0) goto L_0x00aa
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x009c;
                    case 2: goto L_0x008e;
                    case 3: goto L_0x0076;
                    case 4: goto L_0x0063;
                    case 5: goto L_0x0055;
                    case 6: goto L_0x0033;
                    case 7: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0011:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                int r6 = r5.readInt()
                if (r6 == 0) goto L_0x0027
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r5)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0027:
                android.os.IBinder r5 = r5.readStrongBinder()
                com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback r5 = com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback.Stub.asInterface(r5)
                r3.directInstall(r4, r0, r5)
                return r1
            L_0x0033:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                int r6 = r5.readInt()
                if (r6 == 0) goto L_0x0049
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r5)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0049:
                android.os.IBinder r5 = r5.readStrongBinder()
                com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback r5 = com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback.Stub.asInterface(r5)
                r3.showDirectDownloadAppDetailsWithExtra(r4, r0, r5)
                return r1
            L_0x0055:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                r3.dismissDirectDownloadAppDetails(r4)
                r6.writeNoException()
                return r1
            L_0x0063:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                android.os.IBinder r5 = r5.readStrongBinder()
                com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback r5 = com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback.Stub.asInterface(r5)
                r3.showDirectDownloadAppDetails(r4, r5)
                return r1
            L_0x0076:
                r5.enforceInterface(r2)
                android.os.Bundle r4 = r3.getEnabledFeatures()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0089
                r6.writeInt(r1)
                r4.writeToParcel(r6, r1)
                goto L_0x008d
            L_0x0089:
                r4 = 0
                r6.writeInt(r4)
            L_0x008d:
                return r1
            L_0x008e:
                r5.enforceInterface(r2)
                long r4 = r3.getAppHubVersionCode()
                r6.writeNoException()
                r6.writeLong(r4)
                return r1
            L_0x009c:
                r5.enforceInterface(r2)
                java.lang.String r4 = r3.getRandomUserToken()
                r6.writeNoException()
                r6.writeString(r4)
                return r1
            L_0x00aa:
                r6.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.array.apphub.aidl.IAppHubService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements IAppHubService {
            public static IAppHubService sDefaultImpl;
            private IBinder mRemote;

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public String getRandomUserToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRandomUserToken();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getAppHubVersionCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppHubVersionCode();
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getEnabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEnabledFeatures();
                    }
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showDirectDownloadAppDetails(String str, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iAppHubDirectDownloadServiceCallback != null ? iAppHubDirectDownloadServiceCallback.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().showDirectDownloadAppDetails(str, iAppHubDirectDownloadServiceCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void dismissDirectDownloadAppDetails(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().dismissDirectDownloadAppDetails(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showDirectDownloadAppDetailsWithExtra(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iAppHubDirectDownloadServiceCallback != null ? iAppHubDirectDownloadServiceCallback.asBinder() : null);
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().showDirectDownloadAppDetailsWithExtra(str, bundle, iAppHubDirectDownloadServiceCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void directInstall(String str, Bundle bundle, IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iAppHubDirectDownloadServiceCallback != null ? iAppHubDirectDownloadServiceCallback.asBinder() : null);
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().directInstall(str, bundle, iAppHubDirectDownloadServiceCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAppHubService iAppHubService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iAppHubService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iAppHubService;
                return true;
            }
        }

        public static IAppHubService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
