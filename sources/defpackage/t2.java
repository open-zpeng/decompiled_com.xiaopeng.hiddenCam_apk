package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import defpackage.u2;
/* compiled from: CursorAdapter.java */
/* renamed from: t2  reason: default package */
/* loaded from: classes.dex */
public abstract class t2 extends BaseAdapter implements Filterable, u2.a {
    protected boolean b;
    protected boolean c;
    protected Cursor d;
    protected Context e;
    protected int f;
    protected a g;
    protected DataSetObserver h;
    protected u2 i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: t2$a */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            t2.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: t2$b */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            t2 t2Var = t2.this;
            t2Var.b = true;
            t2Var.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            t2 t2Var = t2.this;
            t2Var.b = false;
            t2Var.notifyDataSetInvalidated();
        }
    }

    public t2(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.c = true;
        } else {
            this.c = false;
        }
        boolean z = cursor != null;
        this.d = cursor;
        this.b = z;
        this.e = context;
        this.f = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.g = new a();
            this.h = new b();
        } else {
            this.g = null;
            this.h = null;
        }
        if (z) {
            a aVar = this.g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    public void changeCursor(Cursor cursor) {
        Cursor a2 = a(cursor);
        if (a2 != null) {
            a2.close();
        }
    }

    public abstract CharSequence convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // defpackage.u2.a
    public Cursor getCursor() {
        return this.d;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.b) {
            this.d.moveToPosition(i);
            if (view == null) {
                view = a(this.e, this.d, viewGroup);
            }
            a(view, this.e, this.d);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new u2(this);
        }
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.b || (cursor = this.d) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.b && (cursor = this.d) != null && cursor.moveToPosition(i)) {
            return this.d.getLong(this.f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.b) {
            if (this.d.moveToPosition(i)) {
                if (view == null) {
                    view = b(this.e, this.d, viewGroup);
                }
                a(view, this.e, this.d);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public Cursor a(Cursor cursor) {
        Cursor cursor2 = this.d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.g;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.d = cursor;
        if (cursor != null) {
            a aVar2 = this.g;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f = cursor.getColumnIndexOrThrow("_id");
            this.b = true;
            notifyDataSetChanged();
        } else {
            this.f = -1;
            this.b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    protected void a() {
        Cursor cursor;
        if (!this.c || (cursor = this.d) == null || cursor.isClosed()) {
            return;
        }
        this.b = this.d.requery();
    }
}
