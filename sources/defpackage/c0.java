package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* renamed from: c0  reason: default package */
/* loaded from: classes.dex */
public class c0<K, V> implements Iterable<Map.Entry<K, V>> {
    c<K, V> b;
    private c<K, V> c;
    private WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap<>();
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$a */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.c0.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.e;
        }

        @Override // defpackage.c0.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$b */
    /* loaded from: classes.dex */
    private static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.c0.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // defpackage.c0.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$c */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        final K b;
        final V c;
        c<K, V> d;
        c<K, V> e;

        c(K k, V v) {
            this.b = k;
            this.c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.b.equals(cVar.b) && this.c.equals(cVar.c);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$d */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private c<K, V> b;
        private boolean c = true;

        d() {
        }

        @Override // defpackage.c0.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2) {
                this.b = cVar2.e;
                this.c = this.b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return c0.this.b != null;
            }
            c<K, V> cVar = this.b;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.b = c0.this.b;
            } else {
                c<K, V> cVar = this.b;
                this.b = cVar != null ? cVar.d : null;
            }
            return this.b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$e */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        c<K, V> b;
        c<K, V> c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.b = cVar2;
            this.c = cVar;
        }

        @Override // defpackage.c0.f
        public void a(c<K, V> cVar) {
            if (this.b == cVar && cVar == this.c) {
                this.c = null;
                this.b = null;
            }
            c<K, V> cVar2 = this.b;
            if (cVar2 == cVar) {
                this.b = b(cVar2);
            }
            if (this.c == cVar) {
                this.c = a();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.c;
            this.c = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.c;
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: c0$f */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.b;
        while (cVar != null && !cVar.b.equals(k)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.c;
        }
        a(k, v);
        return null;
    }

    public c0<K, V>.d c() {
        c0<K, V>.d dVar = new d();
        this.d.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (size() != c0Var.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = c0Var.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.b, this.c);
        this.d.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            for (f<K, V> fVar : this.d.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.e;
        if (cVar != null) {
            cVar.d = a2.d;
        } else {
            this.b = a2.d;
        }
        c<K, V> cVar2 = a2.d;
        if (cVar2 != null) {
            cVar2.e = a2.e;
        } else {
            this.c = a2.e;
        }
        a2.d = null;
        a2.e = null;
        return a2.c;
    }

    public int size() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.e++;
        c<K, V> cVar2 = this.c;
        if (cVar2 == null) {
            this.b = cVar;
            this.c = this.b;
            return cVar;
        }
        cVar2.d = cVar;
        cVar.e = cVar2;
        this.c = cVar;
        return cVar;
    }

    public Map.Entry<K, V> b() {
        return this.b;
    }

    public Iterator<Map.Entry<K, V>> a() {
        b bVar = new b(this.c, this.b);
        this.d.put(bVar, false);
        return bVar;
    }
}
