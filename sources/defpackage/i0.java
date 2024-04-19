package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapCollections.java */
/* renamed from: i0  reason: default package */
/* loaded from: classes.dex */
public abstract class i0<K, V> {
    i0<K, V>.b a;
    i0<K, V>.c b;
    i0<K, V>.e c;

    /* compiled from: MapCollections.java */
    /* renamed from: i0$a */
    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {
        final int b;
        int c;
        int d;
        boolean e = false;

        a(int i) {
            this.b = i;
            this.c = i0.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.c;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) i0.this.a(this.d, this.b);
                this.d++;
                this.e = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.e) {
                this.d--;
                this.c--;
                this.e = false;
                i0.this.a(this.d);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: i0$b */
    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int c = i0.this.c();
            for (Map.Entry<K, V> entry : collection) {
                i0.this.a((i0) entry.getKey(), (K) entry.getValue());
            }
            return c != i0.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            i0.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int a = i0.this.a(entry.getKey());
                if (a < 0) {
                    return false;
                }
                return f0.a(i0.this.a(a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return i0.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int c = i0.this.c() - 1; c >= 0; c--) {
                Object a = i0.this.a(c, 0);
                Object a2 = i0.this.a(c, 1);
                i += (a == null ? 0 : a.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return i0.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return i0.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: i0$c */
    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            i0.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return i0.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return i0.a((Map) i0.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return i0.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int c = i0.this.c() - 1; c >= 0; c--) {
                Object a = i0.this.a(c, 0);
                i += a == null ? 0 : a.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return i0.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a = i0.this.a(obj);
            if (a >= 0) {
                i0.this.a(a);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return i0.b(i0.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return i0.c(i0.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return i0.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return i0.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) i0.this.a(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: i0$d */
    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int b;
        boolean d = false;
        int c = -1;

        d() {
            this.b = i0.this.c() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.d) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return f0.a(entry.getKey(), i0.this.a(this.c, 0)) && f0.a(entry.getValue(), i0.this.a(this.c, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.d) {
                return (K) i0.this.a(this.c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.d) {
                return (V) i0.this.a(this.c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.d) {
                Object a = i0.this.a(this.c, 0);
                Object a2 = i0.this.a(this.c, 1);
                return (a == null ? 0 : a.hashCode()) ^ (a2 != null ? a2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            next();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.d) {
                i0.this.a(this.c);
                this.c--;
                this.b--;
                this.d = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.d) {
                return (V) i0.this.a(this.c, (int) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.c++;
                this.d = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: i0$e */
    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            i0.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return i0.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return i0.this.c() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b = i0.this.b(obj);
            if (b >= 0) {
                i0.this.a(b);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int c = i0.this.c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (collection.contains(i0.this.a(i, 1))) {
                    i0.this.a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int c = i0.this.c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (!collection.contains(i0.this.a(i, 1))) {
                    i0.this.a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return i0.this.c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return i0.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) i0.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a();

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract int c();

    public Set<Map.Entry<K, V>> d() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public Set<K> e() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public Collection<V> f() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] a(T[] tArr, int i) {
        int c2 = c();
        if (tArr.length < c2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), c2));
        }
        for (int i2 = 0; i2 < c2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > c2) {
            tArr[c2] = null;
        }
        return tArr;
    }

    public Object[] b(int i) {
        int c2 = c();
        Object[] objArr = new Object[c2];
        for (int i2 = 0; i2 < c2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
