package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import defpackage.k1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* compiled from: TypefaceCompatApi21Impl.java */
/* renamed from: a1  reason: default package */
/* loaded from: classes.dex */
class a1 extends e1 {
    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    @Override // defpackage.e1
    public Typeface a(Context context, CancellationSignal cancellationSignal, k1.f[] fVarArr, int i) {
        if (fVarArr.length < 1) {
            return null;
        }
        k1.f a = a(fVarArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a.c(), "r", cancellationSignal);
            File a2 = a(openFileDescriptor);
            if (a2 != null && a2.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(a2);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface a3 = super.a(context, fileInputStream);
            fileInputStream.close();
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return a3;
        } catch (IOException unused) {
            return null;
        }
    }
}
