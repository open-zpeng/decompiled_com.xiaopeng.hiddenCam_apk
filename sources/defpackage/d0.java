package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* renamed from: d0  reason: default package */
/* loaded from: classes.dex */
public class d0<K, V> extends j0<K, V> implements Map<K, V> {
    i0<K, V> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: d0$a */
    /* loaded from: classes.dex */
    public class a extends i0<K, V> {
        a() {
        }

        @Override // defpackage.i0
        protected Object a(int i, int i2) {
            return d0.this.c[(i << 1) + i2];
        }

        @Override // defpackage.i0
        protected int b(Object obj) {
            return d0.this.b(obj);
        }

        @Override // defpackage.i0
        protected int c() {
            return d0.this.d;
        }

        @Override // defpackage.i0
        protected int a(Object obj) {
            return d0.this.a(obj);
        }

        @Override // defpackage.i0
        protected Map<K, V> b() {
            return d0.this;
        }

        @Override // defpackage.i0
        protected void a(K k, V v) {
            d0.this.put(k, v);
        }

        @Override // defpackage.i0
        protected V a(int i, V v) {
            return d0.this.a(i, (int) v);
        }

        @Override // defpackage.i0
        protected void a(int i) {
            d0.this.c(i);
        }

        @Override // defpackage.i0
        protected void a() {
            d0.this.clear();
        }
    }

    public d0() {
    }

    private i0<K, V> b() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    public boolean a(Collection<?> collection) {
        return i0.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.d + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }

    public d0(int i) {
        super(i);
    }
}
