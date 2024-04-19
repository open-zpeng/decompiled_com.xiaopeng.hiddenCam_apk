package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* renamed from: v2  reason: default package */
/* loaded from: classes.dex */
public abstract class v2 extends t2 {
    private int j;
    private int k;
    private LayoutInflater l;

    @Deprecated
    public v2(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.k = i;
        this.j = i;
        this.l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // defpackage.t2
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.k, viewGroup, false);
    }

    @Override // defpackage.t2
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.j, viewGroup, false);
    }
}
