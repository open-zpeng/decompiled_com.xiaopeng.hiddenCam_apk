package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.b0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* renamed from: v  reason: default package */
/* loaded from: classes.dex */
public class v extends MenuInflater {
    static final Class<?>[] e = {Context.class};
    static final Class<?>[] f = e;
    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* renamed from: v$a */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] c = {MenuItem.class};
        private Object a;
        private Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public v(Context context) {
        super(context);
        this.c = context;
        this.a = new Object[]{context};
        this.b = this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r6 = r15;
        r8 = null;
        r15 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r15 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r6 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r6 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r6 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r6.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r6.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r6.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r0.c() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        r6 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (r6.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
        if (r6.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r6.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        if (r6.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r0.b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r6.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        a(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b8, code lost:
        r7 = true;
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        r6 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            v$b r0 = new v$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r15
            r8 = r4
            r15 = r5
            r7 = r15
        L41:
            if (r15 != 0) goto Lc7
            if (r6 == r3) goto Lbf
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r6 == r1) goto L8f
            r11 = 3
            if (r6 == r11) goto L50
            goto Lba
        L50:
            java.lang.String r6 = r13.getName()
            if (r7 == 0) goto L5f
            boolean r11 = r6.equals(r8)
            if (r11 == 0) goto L5f
            r8 = r4
            r7 = r5
            goto Lba
        L5f:
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto L69
            r0.d()
            goto Lba
        L69:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L87
            boolean r6 = r0.c()
            if (r6 != 0) goto Lba
            s1 r6 = r0.A
            if (r6 == 0) goto L83
            boolean r6 = r6.a()
            if (r6 == 0) goto L83
            r0.b()
            goto Lba
        L83:
            r0.a()
            goto Lba
        L87:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto Lba
            r15 = r3
            goto Lba
        L8f:
            if (r7 == 0) goto L92
            goto Lba
        L92:
            java.lang.String r6 = r13.getName()
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto La0
            r0.a(r14)
            goto Lba
        La0:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto Laa
            r0.b(r14)
            goto Lba
        Laa:
            boolean r9 = r6.equals(r2)
            if (r9 == 0) goto Lb8
            android.view.SubMenu r6 = r0.b()
            r12.a(r13, r14, r6)
            goto Lba
        Lb8:
            r7 = r3
            r8 = r6
        Lba:
            int r6 = r13.next()
            goto L41
        Lbf:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof g1)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.c.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* renamed from: v$b */
    /* loaded from: classes.dex */
    public class b {
        s1 A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = v.this.c.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.b = obtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.c = obtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.d = obtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.e = obtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = v.this.c.obtainStyledAttributes(attributeSet, j.MenuItem);
            this.i = obtainStyledAttributes.getResourceId(j.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(j.MenuItem_android_menuCategory, this.c) & (-65536)) | (obtainStyledAttributes.getInt(j.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = obtainStyledAttributes.getText(j.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(j.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(j.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(j.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(j.MenuItem_alphabeticModifiers, 4096);
            this.p = a(obtainStyledAttributes.getString(j.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(j.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(j.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = obtainStyledAttributes.getBoolean(j.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(j.MenuItem_android_visible, this.f);
            this.u = obtainStyledAttributes.getBoolean(j.MenuItem_android_enabled, this.g);
            this.v = obtainStyledAttributes.getInt(j.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(j.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(j.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(j.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(j.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (s1) a(this.y, v.f, v.this.b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(j.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTintMode)) {
                this.E = b0.a(obtainStyledAttributes.getInt(j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!v.this.c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(v.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof k;
            if (z2) {
                k kVar = (k) menuItem;
            }
            if (this.r >= 2) {
                if (z2) {
                    ((k) menuItem).c(true);
                } else if (menuItem instanceof l) {
                    ((l) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, v.e, v.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            s1 s1Var = this.A;
            if (s1Var != null) {
                x1.a(menuItem, s1Var);
            }
            x1.a(menuItem, this.B);
            x1.b(menuItem, this.C);
            x1.a(menuItem, this.n, this.o);
            x1.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                x1.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                x1.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.h = true;
            a(this.a.add(this.b, this.i, this.j, this.k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = v.this.c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    Object a() {
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
