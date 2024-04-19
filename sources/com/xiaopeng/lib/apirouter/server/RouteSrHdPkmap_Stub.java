package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.hiddenCam.RouteSrHdPkmap;
/* loaded from: classes.dex */
public class RouteSrHdPkmap_Stub extends Binder implements IInterface {
    public RouteSrHdPkmap provider = new RouteSrHdPkmap();
    public RouteSrHdPkmap_Manifest manifest = new RouteSrHdPkmap_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1598968902) {
            switch (i) {
                case 0:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        this.provider.routeNavi2HdPkmapApplyListF();
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e.getMessage()));
                        return true;
                    }
                case 1:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeSr2HdPkmapTrainingTips((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e2.getMessage()));
                        return true;
                    }
                case 2:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeSr2HdPkmapConfirmInfo((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e3.getMessage()));
                        return true;
                    }
                case 3:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeZGAutoPilot2HdMapApplyMap((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e4.getMessage()));
                        return true;
                    }
                case 4:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeSr2HdPkmapShareInfo((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e5.getMessage()));
                        return true;
                    }
                case 5:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeSr2HdPkmapEvaluation((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e6.getMessage()));
                        return true;
                    }
                case 6:
                    parcel.enforceInterface(RouteSrHdPkmap_Manifest.DESCRIPTOR);
                    try {
                        this.provider.routeSr2HdPkmapBump((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("info"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e7.getMessage()));
                        return true;
                    }
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
        parcel2.writeString(RouteSrHdPkmap_Manifest.DESCRIPTOR);
        return true;
    }
}
