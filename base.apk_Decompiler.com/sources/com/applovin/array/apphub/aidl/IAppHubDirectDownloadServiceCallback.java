package com.applovin.array.apphub.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppHubDirectDownloadServiceCallback extends IInterface {

    public static class Default implements IAppHubDirectDownloadServiceCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onAppDetailsDismissed(String str) throws RemoteException {
        }

        public void onAppDetailsShown(String str) throws RemoteException {
        }

        public void onDownloadStarted(String str) throws RemoteException {
        }

        public void onError(String str, String str2) throws RemoteException {
        }
    }

    void onAppDetailsDismissed(String str) throws RemoteException;

    void onAppDetailsShown(String str) throws RemoteException;

    void onDownloadStarted(String str) throws RemoteException;

    void onError(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IAppHubDirectDownloadServiceCallback {
        private static final String DESCRIPTOR = "com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback";
        static final int TRANSACTION_onAppDetailsDismissed = 2;
        static final int TRANSACTION_onAppDetailsShown = 1;
        static final int TRANSACTION_onDownloadStarted = 3;
        static final int TRANSACTION_onError = 4;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAppHubDirectDownloadServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAppHubDirectDownloadServiceCallback)) {
                return new Proxy(iBinder);
            }
            return (IAppHubDirectDownloadServiceCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAppDetailsShown(parcel.readString());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAppDetailsDismissed(parcel.readString());
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onDownloadStarted(parcel.readString());
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onError(parcel.readString(), parcel.readString());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IAppHubDirectDownloadServiceCallback {
            public static IAppHubDirectDownloadServiceCallback sDefaultImpl;
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

            public void onAppDetailsShown(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAppDetailsShown(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onAppDetailsDismissed(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAppDetailsDismissed(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onDownloadStarted(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onDownloadStarted(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onError(str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAppHubDirectDownloadServiceCallback iAppHubDirectDownloadServiceCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iAppHubDirectDownloadServiceCallback == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iAppHubDirectDownloadServiceCallback;
                return true;
            }
        }

        public static IAppHubDirectDownloadServiceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
