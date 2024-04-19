package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* renamed from: j0  reason: default package */
/* loaded from: classes.dex */
public class j0<K, V> {
    static Object[] e;
    static int f;
    static Object[] g;
    static int h;
    int[] b;
    Object[] c;
    int d;

    public j0() {
        this.b = f0.a;
        this.c = f0.c;
        this.d = 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return f0.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (d0.class) {
                if (g != null) {
                    Object[] objArr = g;
                    this.c = objArr;
                    g = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (d0.class) {
                if (e != null) {
                    Object[] objArr2 = e;
                    this.c = objArr2;
                    e = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.b = new int[i];
        this.c = new Object[i << 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.d * 2;
        Object[] objArr = this.c;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V c(int i) {
        int i2;
        Object[] objArr = this.c;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.d;
        if (i4 <= 1) {
            a(this.b, objArr, i4);
            this.b = f0.a;
            this.c = f0.c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.b;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.b;
                Object[] objArr2 = this.c;
                e(i5);
                if (i4 != this.d) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.b, 0, i);
                    System.arraycopy(objArr2, 0, this.c, 0, i3);
                }
                if (i < i2) {
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, this.b, i, i7);
                    System.arraycopy(objArr2, i6 << 1, this.c, i3, i7 << 1);
                }
            } else {
                if (i < i2) {
                    int[] iArr3 = this.b;
                    int i8 = i + 1;
                    int i9 = i2 - i;
                    System.arraycopy(iArr3, i8, iArr3, i, i9);
                    Object[] objArr3 = this.c;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.c;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 == this.d) {
            this.d = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.b;
            Object[] objArr = this.c;
            this.b = f0.a;
            this.c = f0.c;
            this.d = 0;
            a(iArr, objArr, i);
        }
        if (this.d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        return (V) this.c[(i << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            j0 j0Var = (j0) obj;
            if (size() != j0Var.size()) {
                return false;
            }
            for (int i = 0; i < this.d; i++) {
                try {
                    K b = b(i);
                    V d = d(i);
                    Object obj2 = j0Var.get(b);
                    if (d == null) {
                        if (obj2 != null || !j0Var.containsKey(b)) {
                            return false;
                        }
                    } else if (!d.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    K b2 = b(i2);
                    V d2 = d(i2);
                    Object obj3 = map.get(b2);
                    if (d2 == null) {
                        if (obj3 != null || !map.containsKey(b2)) {
                            return false;
                        }
                    } else if (!d2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return (V) this.c[(a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i = this.d;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.d <= 0;
    }

    public V put(K k, V v) {
        int i;
        int a;
        int i2 = this.d;
        if (k == null) {
            a = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            a = a(k, hashCode);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object[] objArr = this.c;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~a;
        if (i2 >= this.b.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.b;
            Object[] objArr2 = this.c;
            e(i5);
            if (i2 == this.d) {
                int[] iArr2 = this.b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.c, 0, objArr2.length);
                }
                a(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.b;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.d - i4) << 1);
        }
        int i7 = this.d;
        if (i2 == i7) {
            int[] iArr4 = this.b;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.c;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.d = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return c(a);
        }
        return null;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V d = d(i);
            if (d != this) {
                sb.append(d);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    int a(Object obj, int i) {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int a = a(this.b, i2, i);
        if (a >= 0 && !obj.equals(this.c[a << 1])) {
            int i3 = a + 1;
            while (i3 < i2 && this.b[i3] == i) {
                if (obj.equals(this.c[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a - 1; i4 >= 0 && this.b[i4] == i; i4--) {
                if (obj.equals(this.c[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a;
    }

    public j0(int i) {
        if (i == 0) {
            this.b = f0.a;
            this.c = f0.c;
        } else {
            e(i);
        }
        this.d = 0;
    }

    public K b(int i) {
        return (K) this.c[i << 1];
    }

    int a() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        int a = a(this.b, i, 0);
        if (a >= 0 && this.c[a << 1] != null) {
            int i2 = a + 1;
            while (i2 < i && this.b[i2] == 0) {
                if (this.c[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a - 1; i3 >= 0 && this.b[i3] == 0; i3--) {
                if (this.c[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return a;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (d0.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (d0.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        }
    }

    public void a(int i) {
        int i2 = this.d;
        int[] iArr = this.b;
        if (iArr.length < i) {
            Object[] objArr = this.c;
            e(i);
            if (this.d > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.d != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.c;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }
}
