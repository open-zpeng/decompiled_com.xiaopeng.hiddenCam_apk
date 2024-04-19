package defpackage;
/* compiled from: LongSparseArray.java */
/* renamed from: g0  reason: default package */
/* loaded from: classes.dex */
public class g0<E> implements Cloneable {
    private static final Object f = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public g0() {
        this(10);
    }

    public void a(long j) {
        int a = f0.a(this.c, this.e, j);
        if (a >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[a];
            Object obj2 = f;
            if (obj != obj2) {
                objArr[a] = obj2;
                this.b = true;
            }
        }
    }

    public E b(long j) {
        return b(j, null);
    }

    public void c(long j, E e) {
        int a = f0.a(this.c, this.e, j);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        int i = ~a;
        if (i < this.e) {
            Object[] objArr = this.d;
            if (objArr[i] == f) {
                this.c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.b && this.e >= this.c.length) {
            b();
            i = ~f0.a(this.c, this.e, j);
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int c = f0.c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr2 = new Object[c];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.d = objArr2;
        }
        int i3 = this.e;
        if (i3 - i != 0) {
            long[] jArr3 = this.c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i4, this.e - i);
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    public void clear() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public String toString() {
        if (a() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public g0(int i) {
        this.b = false;
        if (i == 0) {
            this.c = f0.b;
            this.d = f0.c;
        } else {
            int c = f0.c(i);
            this.c = new long[c];
            this.d = new Object[c];
        }
        this.e = 0;
    }

    public E b(long j, E e) {
        int a = f0.a(this.c, this.e, j);
        if (a >= 0) {
            Object[] objArr = this.d;
            if (objArr[a] != f) {
                return (E) objArr[a];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public g0<E> m4clone() {
        try {
            g0<E> g0Var = (g0) super.clone();
            g0Var.c = (long[]) this.c.clone();
            g0Var.d = (Object[]) this.d.clone();
            return g0Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private void b() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public int a() {
        if (this.b) {
            b();
        }
        return this.e;
    }

    public long a(int i) {
        if (this.b) {
            b();
        }
        return this.c[i];
    }

    public void a(long j, E e) {
        int i = this.e;
        if (i != 0 && j <= this.c[i - 1]) {
            c(j, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            b();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int c = f0.c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr = new Object[c];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i2] = j;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public E b(int i) {
        if (this.b) {
            b();
        }
        return (E) this.d[i];
    }
}
