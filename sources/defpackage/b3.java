package defpackage;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.f;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import defpackage.c3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* renamed from: b3  reason: default package */
/* loaded from: classes.dex */
public class b3 extends a3 {
    static boolean c = false;
    private final f a;
    private final c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: b3$b */
    /* loaded from: classes.dex */
    public static class b<D> implements l<D> {
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: b3$c */
    /* loaded from: classes.dex */
    static class c extends o {
        private static final p.a b = new a();
        private k0<a> a = new k0<>();

        /* compiled from: LoaderManagerImpl.java */
        /* renamed from: b3$c$a */
        /* loaded from: classes.dex */
        static class a implements p.a {
            a() {
            }

            @Override // androidx.lifecycle.p.a
            public <T extends o> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c a(q qVar) {
            return (c) new p(qVar, b).a(c.class);
        }

        void b() {
            int a2 = this.a.a();
            for (int i = 0; i < a2; i++) {
                this.a.e(i).c();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.o
        public void a() {
            super.a();
            if (this.a.a() <= 0) {
                this.a.clear();
            } else {
                this.a.e(0).a(true);
                throw null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.a.a() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.a.a() <= 0) {
                    return;
                }
                a e = this.a.e(0);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.a.c(0));
                printWriter.print(": ");
                printWriter.println(e.toString());
                e.a(str2, fileDescriptor, printWriter, strArr);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b3(f fVar, q qVar) {
        this.a = fVar;
        this.b = c.a(qVar);
    }

    @Override // defpackage.a3
    public void a() {
        this.b.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        n1.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: b3$a */
    /* loaded from: classes.dex */
    public static class a<D> extends k<D> implements c3.a<D> {
        private final int j;
        private final Bundle k;
        private final c3<D> l;
        private f m;
        private b<D> n;
        private c3<D> o;

        @Override // androidx.lifecycle.LiveData
        protected void a() {
            if (b3.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.l.c();
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b3.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.l.d();
            throw null;
        }

        void c() {
            f fVar = this.m;
            b<D> bVar = this.n;
            if (fVar == null || bVar == null) {
                return;
            }
            super.a((l) bVar);
            a(fVar, bVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.j);
            sb.append(" : ");
            n1.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(l<? super D> lVar) {
            super.a((l) lVar);
            this.m = null;
            this.n = null;
        }

        c3<D> a(boolean z) {
            if (b3.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l.a();
            throw null;
        }

        @Override // androidx.lifecycle.k, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
            c3<D> c3Var = this.o;
            if (c3Var == null) {
                return;
            }
            c3Var.b();
            throw null;
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j);
            printWriter.print(" mArgs=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            c3<D> c3Var = this.l;
            c3Var.a(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }
    }

    @Override // defpackage.a3
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.a(str, fileDescriptor, printWriter, strArr);
    }
}
