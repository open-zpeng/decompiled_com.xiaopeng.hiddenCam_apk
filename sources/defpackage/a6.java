package defpackage;
/* renamed from: a6  reason: default package */
/* loaded from: classes.dex */
final class a6 {
    private int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a6 a6Var) {
        this.a = a6Var.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.a < 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        int i = this.a;
        this.a = i <= 3 ? 0 : i <= 9 ? i - 3 : i - 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.a = this.a < 7 ? 8 : 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a = this.a >= 7 ? 10 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.a = this.a < 7 ? 9 : 11;
    }
}
