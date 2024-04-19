package com.xiaopeng.hiddenCam.oss;

import java.util.Vector;
/* compiled from: Observable.java */
/* loaded from: classes.dex */
public class a {
    private Vector<b> a = new Vector<>();

    public synchronized void a(b bVar) {
        if (bVar != null) {
            if (!this.a.contains(bVar)) {
                this.a.addElement(bVar);
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void a(Object obj) {
        Object[] array;
        synchronized (this) {
            array = this.a.toArray();
        }
        for (int length = array.length - 1; length >= 0; length--) {
            ((b) array[length]).a(this, obj);
        }
    }
}
