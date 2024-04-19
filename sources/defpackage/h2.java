package defpackage;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
/* renamed from: h2  reason: default package */
/* loaded from: classes.dex */
public class h2 {
    private static Field a;
    private static boolean b;
    private static WeakHashMap<View, String> c;
    private static WeakHashMap<View, l2> d;

    /* compiled from: ViewCompat.java */
    /* renamed from: h2$a */
    /* loaded from: classes.dex */
    static class a implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ e2 a;

        a(e2 e2Var) {
            this.a = e2Var;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) p2.a(this.a.a(view, p2.a(windowInsets)));
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: h2$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(View view, KeyEvent keyEvent);
    }

    static {
        new AtomicInteger(1);
        d = null;
    }

    public static void a(View view, r1 r1Var) {
        view.setAccessibilityDelegate(r1Var == null ? null : r1Var.a());
    }

    public static ColorStateList b(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof g2) {
            return ((g2) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof g2) {
            return ((g2) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static int d(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!b) {
            try {
                a = View.class.getDeclaredField("mMinHeight");
                a.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static String f(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = c;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static boolean h(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean j(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean k(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static void l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void m(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof z1) {
            ((z1) view).stopNestedScroll();
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: h2$c */
    /* loaded from: classes.dex */
    static class c {
        private static final ArrayList<WeakReference<View>> d = new ArrayList<>();
        private WeakHashMap<View, Boolean> a = null;
        private SparseArray<WeakReference<View>> b = null;
        private WeakReference<KeyEvent> c = null;

        c() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.b == null) {
                this.b = new SparseArray<>();
            }
            return this.b;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b != null) {
                            return b;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(m0.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((b) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        static c a(View view) {
            c cVar = (c) view.getTag(m0.tag_unhandled_key_event_manager);
            if (cVar == null) {
                c cVar2 = new c();
                view.setTag(m0.tag_unhandled_key_event_manager, cVar2);
                return cVar2;
            }
            return cVar;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (d.isEmpty()) {
                return;
            }
            synchronized (d) {
                if (this.a == null) {
                    this.a = new WeakHashMap<>();
                }
                for (int size = d.size() - 1; size >= 0; size--) {
                    View view = d.get(size).get();
                    if (view == null) {
                        d.remove(size);
                    } else {
                        this.a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b));
                }
            }
            return b != null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> a = a();
                if (keyEvent.getAction() == 1 && (indexOfKey = a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = a.valueAt(indexOfKey);
                    a.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = a.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && h2.j(view)) {
                        c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static void a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(keyEvent);
    }

    public static l2 a(View view) {
        if (d == null) {
            d = new WeakHashMap<>();
        }
        l2 l2Var = d.get(view);
        if (l2Var == null) {
            l2 l2Var2 = new l2(view);
            d.put(view, l2Var2);
            return l2Var2;
        }
        return l2Var;
    }

    public static void a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (c == null) {
            c = new WeakHashMap<>();
        }
        c.put(view, str);
    }

    public static void a(View view, e2 e2Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (e2Var == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new a(e2Var));
            }
        }
    }

    public static p2 a(View view, p2 p2Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) p2.a(p2Var);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return p2.a(windowInsets);
        }
        return p2Var;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof g2) {
            ((g2) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof g2) {
            ((g2) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(view, keyEvent);
    }
}
