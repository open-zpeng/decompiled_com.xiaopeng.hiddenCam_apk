package defpackage;

import defpackage.c0;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FastSafeIterableMap.java */
/* renamed from: b0  reason: default package */
/* loaded from: classes.dex */
public class b0<K, V> extends c0<K, V> {
    private HashMap<K, c0.c<K, V>> f = new HashMap<>();

    @Override // defpackage.c0
    protected c0.c<K, V> a(K k) {
        return this.f.get(k);
    }

    @Override // defpackage.c0
    public V b(K k, V v) {
        c0.c<K, V> a = a(k);
        if (a != null) {
            return a.c;
        }
        this.f.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f.containsKey(k);
    }

    @Override // defpackage.c0
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.f.get(k).e;
        }
        return null;
    }
}
