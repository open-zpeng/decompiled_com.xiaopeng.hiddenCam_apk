package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.uc.crashsdk.CrashLogFilesUploader;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.h;
import com.uc.crashsdk.i;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class CrashApi {
    private static CrashApi a = null;
    private static boolean d = true;
    private static boolean e = false;
    private boolean b;
    private boolean c;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str, boolean z, boolean z2, boolean z3) {
        this.b = false;
        this.c = false;
        Context a2 = a(context);
        b(a2);
        this.b = z2;
        b.g = z3;
        if (b.D()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (this.b && e.f("libcrashsdk.so")) {
                b.f = true;
                b();
            }
        } else if (customInfo != null && versionInfo != null) {
            h.a(customInfo);
            try {
                e.a(str, true);
                a(a2, customInfo, versionInfo, iCrashClient);
            } catch (Throwable th) {
                a(th);
            }
            if (z) {
                try {
                    a();
                } catch (Throwable th2) {
                    a(th2);
                }
            }
            try {
                i.a();
                com.uc.crashsdk.a.h.a();
                d.a();
                g.i();
            } catch (Throwable th3) {
                g.a(th3);
            }
            try {
                if (!b.a(a2)) {
                    a.c("crashsdk", "registerLifecycleCallbacks failed!");
                }
            } catch (Throwable th4) {
                g.a(th4);
            }
            try {
                com.uc.crashsdk.a.m();
                e.u();
                e.v();
            } catch (Throwable th5) {
                g.a(th5);
            }
            try {
                if (h.s() && b.A() && !this.c) {
                    CrashLogFilesUploader.a(a2);
                    this.c = true;
                }
            } catch (Throwable th6) {
                g.b(th6);
            }
        } else {
            a.c("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw new NullPointerException();
        }
    }

    private static void a() {
        if (b.a) {
            a.c("Has enabled java log!");
            return;
        }
        e.o();
        e.l();
        b.a = true;
    }

    private void b() {
        synchronized (b.e) {
            if (this.b && b.f) {
                if (b.b) {
                    a.c("Has enabled native log!");
                    return;
                }
                c();
                e.w();
                b.b = true;
                JNIBridge.nativeBreakpadInited(Build.FINGERPRINT);
                h.e();
            }
        }
    }

    private static void c() {
        if (b.d) {
            return;
        }
        h.c();
        JNIBridge.nativeInitNative();
        h.d();
        b.d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            if (a == null) {
                a = new CrashApi(context, customInfo, versionInfo, iCrashClient, str, z, z2, z3);
            }
            crashApi = a;
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str != null && str2 != null) {
            return com.uc.crashsdk.a.b(str, str2);
        }
        throw new NullPointerException();
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        if (dumpFileInfo != null) {
            String str2 = dumpFileInfo.mCategory;
            if (str2 != null && (str = dumpFileInfo.mFileTobeDump) != null) {
                int i = dumpFileInfo.mLogType;
                if ((i & 273) == 0) {
                    return 0;
                }
                return com.uc.crashsdk.a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }

    public void addHeaderInfo(String str, String str2) {
        if (str != null) {
            com.uc.crashsdk.a.a(str, str2);
            return;
        }
        throw new NullPointerException();
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (!g.a(str)) {
            if (str.length() <= 24) {
                if (str2 != null && str2.length() > 512) {
                    str2 = str2.substring(0, IInputController.KEYCODE_BACK_BUTTON);
                }
                return com.uc.crashsdk.a.h.a(str, str2);
            }
            throw new IllegalArgumentException("key is too long!");
        }
        throw new NullPointerException();
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f = true;
        b();
        synchronized (b.e) {
            if (b.g && b.f && !b.c) {
                if (!b.d) {
                    c();
                    h.e();
                }
                e.r();
                b.c = true;
            }
        }
        com.uc.crashsdk.a.m();
        e.j();
    }

    public int createCachedInfo(String str, int i, int i2) {
        if (str != null) {
            if (i > 0) {
                if ((i2 & 273) == 0) {
                    return 0;
                }
                return com.uc.crashsdk.a.a(str, i, i2);
            }
            throw new IllegalArgumentException("capacity must > 0!");
        }
        throw new NullPointerException();
    }

    public void disableLog(int i) {
        synchronized (b.e) {
            b.b(i);
            if (LogType.isForJava(i) && b.a) {
                e.p();
                b.a = false;
            }
            if (LogType.isForNative(i)) {
                if (b.b) {
                    JNIBridge.nativeUninstallBreakpad();
                    b.b = false;
                } else {
                    this.b = false;
                }
            }
            if (LogType.isForUnexp(i)) {
                if (b.c) {
                    if (e.t()) {
                        b.c = false;
                    }
                } else {
                    b.g = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        if (customLogInfo != null) {
            if (customLogInfo.mData != null && (str = customLogInfo.mLogType) != null) {
                if (!str.contains("_") && !customLogInfo.mLogType.contains(" ")) {
                    ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
                    if (arrayList == null || arrayList.size() <= 0) {
                        sb = null;
                    } else {
                        sb = new StringBuilder();
                        Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next().intValue());
                            sb.append(" ");
                        }
                    }
                    return e.a(customLogInfo.mData, customLogInfo.mLogType, customLogInfo.mAddHeader, customLogInfo.mAddFooter, customLogInfo.mAddLogcat, customLogInfo.mAddThreadsDump, customLogInfo.mUploadNow, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
                }
                throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
            }
            throw new NullPointerException("mData or mLogType is null!");
        }
        throw new NullPointerException();
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (!b.d) {
            a.c("crashsdk", "Crash so is not loaded!");
            return false;
        }
        return JNIBridge.nativeGenerateTraces(str, j);
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.i();
    }

    public ParcelFileDescriptor getHostFd() {
        return e.x();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.x();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.B();
    }

    public Throwable getUncaughtException() {
        return e.q();
    }

    public void onExit() {
        b.t();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        if (valueCallback != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return com.uc.crashsdk.d.b(valueCallback);
                        }
                        throw new IllegalArgumentException("Unknown event type: " + i);
                    }
                    return com.uc.crashsdk.d.d(valueCallback);
                }
                return com.uc.crashsdk.d.c(valueCallback);
            }
            return com.uc.crashsdk.d.a(valueCallback);
        }
        throw new NullPointerException();
    }

    public int registerInfoCallback(String str, int i) {
        if (str != null) {
            if ((i & 273) == 0) {
                return 0;
            }
            return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
        }
        throw new NullPointerException();
    }

    public int registerThread(int i, String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        return e.b(z, true);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        return e.e(z);
    }

    public void setCrashLogUploadUrl(String str) {
        if (a("setCrashLogUploadUrl")) {
            return;
        }
        e.a(str, false);
    }

    public void setForeground(boolean z) {
        b.a(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.s();
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        if (customInfo != null) {
            return h.b(customInfo);
        }
        throw new NullPointerException();
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        if (versionInfo != null) {
            h.a(versionInfo);
            return;
        }
        throw new NullPointerException();
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        d = bundle.getBoolean("useApplicationContext", true);
        Context a2 = a(context);
        b(a2);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = true;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        CustomInfo a3 = h.a(customInfo, bundle);
        VersionInfo a4 = h.a(bundle);
        boolean z2 = bundle.getBoolean("enableJavaLog", true);
        boolean z3 = bundle.getBoolean("enableNativeLog", true);
        boolean z4 = bundle.getBoolean("enableUnexpLog", b.A());
        CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, e.d(a3.mIsInternational), z2, z3, z4);
        if (z3 || z4) {
            if (e.f("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                a.c("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && b.A()) {
            e.b(i);
        }
        return createInstance;
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw new NullPointerException();
        }
        if ((i & 273) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int updateCustomInfo(Bundle bundle) {
        if (bundle != null) {
            return updateCustomInfo(h.a((CustomInfo) null, bundle));
        }
        throw new NullPointerException();
    }

    public void updateVersionInfo(Bundle bundle) {
        if (bundle != null) {
            updateVersionInfo(h.a(bundle));
            return;
        }
        throw new NullPointerException();
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str) {
        return createInstance(context, customInfo, versionInfo, iCrashClient, str, true, true, true);
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, String str) {
        return createInstance(context, customInfo, versionInfo, (ICrashClient) null, str);
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        h.a(customInfo, versionInfo);
        if (b.D()) {
            return;
        }
        e.m();
        e.a(context);
    }

    public static CrashApi createInstance(Context context, String str, Bundle bundle) {
        return createInstance(context, str, bundle, (ValueCallback<Bundle>) null, (ValueCallback<Bundle>) null);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public static CrashApi createInstance(Context context, String str, Bundle bundle, ValueCallback<Bundle> valueCallback, ValueCallback<Bundle> valueCallback2) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle != null) {
            d = bundle.getBoolean("useApplicationContext", true);
            Context a2 = a(context);
            b(a2);
            CrashApi createInstance = createInstance(a2, h.a((CustomInfo) null, bundle), h.a(bundle), null, str, bundle.getBoolean("enableJavaLog", true), bundle.getBoolean("enableNativeLog", true), bundle.getBoolean("enableUnexpLog", b.A()));
            if (valueCallback != null) {
                com.uc.crashsdk.d.d(valueCallback);
            }
            if (valueCallback2 != null) {
                com.uc.crashsdk.d.a(valueCallback2);
            }
            String string = bundle.getString("soPathName");
            if (g.b(string) && e.e(string)) {
                createInstance.crashSoLoaded();
            }
            return createInstance;
        }
        throw new NullPointerException();
    }

    private static Context a(Context context) {
        if (context != null) {
            if (!d || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            a.c("crashsdk", "Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }
        a.c("crashsdk", "context can not be null!");
        throw new NullPointerException();
    }

    private static void b(Context context) {
        try {
            if (e) {
                return;
            }
            g.a(context);
            com.uc.crashsdk.a.a = context.getPackageName();
            e = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    private static boolean a(String str) {
        if (b.D()) {
            a.c("crashsdk", "Can not call '" + str + "' in isolated process!");
            return true;
        }
        return false;
    }
}
