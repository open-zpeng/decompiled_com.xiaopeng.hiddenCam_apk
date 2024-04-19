package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: ArraySet.java */
/* renamed from: e0  reason: default package */
/* loaded from: classes.dex */
public final class e0<E> implements Collection<E>, Set<E> {
    private static final int[] f = new int[0];
    private static final Object[] g = new Object[0];
    private static Object[] h;
    private static int i;
    private static Object[] j;
    private static int k;
    private int[] b;
    Object[] c;
    int d;
    private i0<E, E> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArraySet.java */
    /* renamed from: e0$a */
    /* loaded from: classes.dex */
    public class a extends i0<E, E> {
        a() {
        }

        @Override // defpackage.i0
        protected Object a(int i, int i2) {
            return e0.this.c[i];
        }

        @Override // defpackage.i0
        protected int b(Object obj) {
            return e0.this.indexOf(obj);
        }

        @Override // defpackage.i0
        protected int c() {
            return e0.this.d;
        }

        @Override // defpackage.i0
        protected int a(Object obj) {
            return e0.this.indexOf(obj);
        }

        @Override // defpackage.i0
        protected Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // defpackage.i0
        protected void a(E e, E e2) {
            e0.this.add(e);
        }

        @Override // defpackage.i0
        protected E a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // defpackage.i0
        protected void a(int i) {
            e0.this.b(i);
        }

        @Override // defpackage.i0
        protected void a() {
            e0.this.clear();
        }
    }

    public e0() {
        this(0);
    }

    private int a(Object obj, int i2) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = f0.a(this.b, i3, i2);
        if (a2 >= 0 && !obj.equals(this.c[a2])) {
            int i4 = a2 + 1;
            while (i4 < i3 && this.b[i4] == i2) {
                if (obj.equals(this.c[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && this.b[i5] == i2; i5--) {
                if (obj.equals(this.c[i5])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a2;
    }

    private int b() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = f0.a(this.b, i2, 0);
        if (a2 >= 0 && this.c[a2] != null) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.b[i3] == 0) {
                if (this.c[i3] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.b[i4] == 0; i4--) {
                if (this.c[i4] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (e0.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.c = objArr;
                    j = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (e0.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int a2;
        if (e == null) {
            a2 = b();
            i2 = 0;
        } else {
            int hashCode = e.hashCode();
            i2 = hashCode;
            a2 = a(e, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i3 = ~a2;
        int i4 = this.d;
        if (i4 >= this.b.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.b;
            Object[] objArr = this.c;
            d(i5);
            int[] iArr2 = this.b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            a(iArr, objArr, this.d);
        }
        int i6 = this.d;
        if (i3 < i6) {
            int[] iArr3 = this.b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i3, objArr2, i7, this.d - i3);
        }
        this.b[i3] = i2;
        this.c[i3] = e;
        this.d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        a(this.d + collection.size());
        boolean z = false;
        for (E e : collection) {
            z |= add(e);
        }
        return z;
    }

    public E c(int i2) {
        return (E) this.c[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.d;
        if (i2 != 0) {
            a(this.b, this.c, i2);
            this.b = f;
            this.c = g;
            this.d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    if (!set.contains(c(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.b;
        int i2 = this.d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            b(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E c = c(i2);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public e0(int i2) {
        if (i2 == 0) {
            this.b = f;
            this.c = g;
        } else {
            d(i2);
        }
        this.d = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.d));
        }
        System.arraycopy(this.c, 0, tArr, 0, this.d);
        int length = tArr.length;
        int i2 = this.d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (e0.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (e0.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    public E b(int i2) {
        Object[] objArr = this.c;
        E e = (E) objArr[i2];
        int i3 = this.d;
        if (i3 <= 1) {
            a(this.b, objArr, i3);
            this.b = f;
            this.c = g;
            this.d = 0;
        } else {
            int[] iArr = this.b;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.b;
                Object[] objArr2 = this.c;
                d(i4);
                this.d--;
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.b, 0, i2);
                    System.arraycopy(objArr2, 0, this.c, 0, i2);
                }
                int i5 = this.d;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, this.b, i2, i5 - i2);
                    System.arraycopy(objArr2, i6, this.c, i2, this.d - i2);
                }
            } else {
                this.d--;
                int i7 = this.d;
                if (i2 < i7) {
                    int[] iArr3 = this.b;
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, iArr3, i2, i7 - i2);
                    Object[] objArr3 = this.c;
                    System.arraycopy(objArr3, i8, objArr3, i2, this.d - i2);
                }
                this.c[this.d] = null;
            }
        }
        return e;
    }

    public void a(int i2) {
        int[] iArr = this.b;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            d(i2);
            int i3 = this.d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, this.d);
            }
            a(iArr, objArr, this.d);
        }
    }

    private i0<E, E> a() {
        if (this.e == null) {
            this.e = new a();
        }
        return this.e;
    }
}
