package com.xiaopeng.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPC.java */
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(String str, IpcMessage ipcMessage) throws RemoteException;

    void a(String str, b bVar) throws RemoteException;

    void b(String str, b bVar) throws RemoteException;

    /* compiled from: IPC.java */
    /* renamed from: com.xiaopeng.ipc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0017a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.ipc.IPC");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0018a(iBinder);
        }

        /* compiled from: IPC.java */
        /* renamed from: com.xiaopeng.ipc.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0018a implements a {
            private IBinder b;

            C0018a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.xiaopeng.ipc.a
            public void a(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.xiaopeng.ipc.a
            public void b(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.ipc.a
            public void a(String str, IpcMessage ipcMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    if (ipcMessage != null) {
                        obtain.writeInt(1);
                        ipcMessage.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
