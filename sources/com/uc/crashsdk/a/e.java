package com.uc.crashsdk.a;

import com.uc.crashsdk.CrashLogFilesUploader;
import com.xiaopeng.speech.protocol.bean.stats.StatCommonBean;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class e implements Runnable {
    static final /* synthetic */ boolean a = !e.class.desiredAssertionStatus();
    private final int b;
    private final Object[] c;

    public e(int i) {
        this.b = i;
        this.c = null;
    }

    public final boolean a() {
        int i = this.b;
        if (i != 451 && i != 452) {
            switch (i) {
                case 351:
                case 352:
                case 353:
                case 354:
                    return h.a(i, this.c);
                default:
                    switch (i) {
                        case 751:
                        case 752:
                        case 753:
                            return com.uc.crashsdk.f.a(i, this.c);
                        default:
                            a.c("crashsdk", "Unknown sync runnable: " + toString());
                            if (a) {
                                return false;
                            }
                            throw new AssertionError();
                    }
            }
        }
        return com.uc.crashsdk.e.b(this.b, this.c);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i == 10) {
            f.a(i, this.c);
        } else if (i == 500) {
            d.a(i);
        } else if (i == 700) {
            com.uc.crashsdk.f.b(i);
        } else if (i == 800) {
            g.a(i);
        } else if (i == 100 || i == 101) {
            com.uc.crashsdk.b.a(this.b);
        } else if (i == 201 || i == 202) {
            com.uc.crashsdk.a.a(this.b);
        } else if (i != 600 && i != 601) {
            switch (i) {
                case 301:
                case 302:
                case 303:
                    h.a(i);
                    return;
                default:
                    switch (i) {
                        case StatCommonBean.EVENT_RECOMMEND_ID /* 401 */:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                        case 407:
                        case 408:
                        case 409:
                        case 410:
                        case 411:
                        case 412:
                        case 413:
                            com.uc.crashsdk.e.a(i, this.c);
                            return;
                        default:
                            a.c("crashsdk", "Unknown async runnable: " + toString());
                            if (!a) {
                                throw new AssertionError();
                            }
                            return;
                    }
            }
        } else {
            CrashLogFilesUploader.a(this.b, this.c);
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.b;
    }

    public e(int i, Object[] objArr) {
        this.b = i;
        this.c = objArr;
    }
}
