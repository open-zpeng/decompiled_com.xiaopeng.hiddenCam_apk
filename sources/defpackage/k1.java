package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import defpackage.l1;
import defpackage.v0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: FontsContractCompat.java */
/* renamed from: k1  reason: default package */
/* loaded from: classes.dex */
public class k1 {
    static final h0<String, Typeface> a = new h0<>(16);
    private static final l1 b = new l1("fonts", 10, IpcConfig.MessageCenterConfig.IPC_ID_SUBSCRIBE);
    static final Object c = new Object();
    static final j0<String, ArrayList<l1.d<g>>> d = new j0<>();
    private static final Comparator<byte[]> e = new d();

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$a */
    /* loaded from: classes.dex */
    static class a implements Callable<g> {
        final /* synthetic */ Context a;
        final /* synthetic */ j1 b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        a(Context context, j1 j1Var, int i, String str) {
            this.a = context;
            this.b = j1Var;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        public g call() throws Exception {
            g a = k1.a(this.a, this.b, this.c);
            Typeface typeface = a.a;
            if (typeface != null) {
                k1.a.a(this.d, typeface);
            }
            return a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$b */
    /* loaded from: classes.dex */
    static class b implements l1.d<g> {
        final /* synthetic */ v0.a a;
        final /* synthetic */ Handler b;

        b(v0.a aVar, Handler handler) {
            this.a = aVar;
            this.b = handler;
        }

        @Override // defpackage.l1.d
        public void a(g gVar) {
            if (gVar == null) {
                this.a.a(1, this.b);
                return;
            }
            int i = gVar.b;
            if (i == 0) {
                this.a.a(gVar.a, this.b);
            } else {
                this.a.a(i, this.b);
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$c */
    /* loaded from: classes.dex */
    static class c implements l1.d<g> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // defpackage.l1.d
        public void a(g gVar) {
            synchronized (k1.c) {
                ArrayList<l1.d<g>> arrayList = k1.d.get(this.a);
                if (arrayList == null) {
                    return;
                }
                k1.d.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$d */
    /* loaded from: classes.dex */
    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$e */
    /* loaded from: classes.dex */
    public static class e {
        private final int a;
        private final f[] b;

        public e(int i, f[] fVarArr) {
            this.a = i;
            this.b = fVarArr;
        }

        public f[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$f */
    /* loaded from: classes.dex */
    public static class f {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            q1.a(uri);
            this.a = uri;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.b;
        }

        public Uri c() {
            return this.a;
        }

        public int d() {
            return this.c;
        }

        public boolean e() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontsContractCompat.java */
    /* renamed from: k1$g */
    /* loaded from: classes.dex */
    public static final class g {
        final Typeface a;
        final int b;

        g(Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    static g a(Context context, j1 j1Var, int i) {
        try {
            e a2 = a(context, (CancellationSignal) null, j1Var);
            if (a2.b() == 0) {
                Typeface a3 = z0.a(context, null, a2.a(), i);
                return new g(a3, a3 != null ? 0 : -3);
            }
            return new g(null, a2.b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface a(Context context, j1 j1Var, v0.a aVar, Handler handler, boolean z, int i, int i2) {
        String str = j1Var.c() + "-" + i2;
        Typeface b2 = a.b(str);
        if (b2 != null) {
            if (aVar != null) {
                aVar.a(b2);
            }
            return b2;
        } else if (z && i == -1) {
            g a2 = a(context, j1Var, i2);
            if (aVar != null) {
                int i3 = a2.b;
                if (i3 == 0) {
                    aVar.a(a2.a, handler);
                } else {
                    aVar.a(i3, handler);
                }
            }
            return a2.a;
        } else {
            a aVar2 = new a(context, j1Var, i2, str);
            if (z) {
                try {
                    return ((g) b.a(aVar2, i)).a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            b bVar = aVar == null ? null : new b(aVar, handler);
            synchronized (c) {
                if (d.containsKey(str)) {
                    if (bVar != null) {
                        d.get(str).add(bVar);
                    }
                    return null;
                }
                if (bVar != null) {
                    ArrayList<l1.d<g>> arrayList = new ArrayList<>();
                    arrayList.add(bVar);
                    d.put(str, arrayList);
                }
                b.a(aVar2, new c(str));
                return null;
            }
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, f1.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static e a(Context context, CancellationSignal cancellationSignal, j1 j1Var) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), j1Var, context.getResources());
        if (a2 == null) {
            return new e(1, null);
        }
        return new e(0, a(context, j1Var, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, j1 j1Var, Resources resources) throws PackageManager.NameNotFoundException {
        String d2 = j1Var.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(j1Var.e())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, e);
                List<List<byte[]>> a3 = a(j1Var, resources);
                for (int i = 0; i < a3.size(); i++) {
                    ArrayList arrayList = new ArrayList(a3.get(i));
                    Collections.sort(arrayList, e);
                    if (a(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + j1Var.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
    }

    private static List<List<byte[]>> a(j1 j1Var, Resources resources) {
        if (j1Var.a() != null) {
            return j1Var.a();
        }
        return s0.a(resources, j1Var.b());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    static f[] a(Context context, j1 j1Var, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(ClientConstants.BINDER.SCHEME).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(ClientConstants.BINDER.SCHEME).authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{j1Var.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{j1Var.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new f(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
