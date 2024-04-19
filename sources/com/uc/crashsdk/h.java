package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class h {
    static final /* synthetic */ boolean a = !h.class.desiredAssertionStatus();
    private static CustomInfo b = null;
    private static VersionInfo c = null;
    private static final Object d = new Object();
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static final Object i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A() {
        return b.mMaxUploadBytesPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B() {
        return b.mMaxUploadCrashLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C() {
        return b.mMaxUploadCustomLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D() {
        return b.mMaxCustomLogCountPerTypePerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E() {
        return b.mUnexpInfoUpdateInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F() {
        return b.mReservedJavaFileHandleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G() {
        return b.mFdDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H() {
        return b.mThreadsDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean I() {
        return b.mAutoDetectLifeCycle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return b.mMonitorBattery;
    }

    public static boolean K() {
        CustomInfo customInfo = b;
        return customInfo == null || customInfo.mDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean L() {
        CustomInfo customInfo = b;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String M() {
        return b.mLogTypeSuffix;
    }

    public static boolean N() {
        return b.mEnableStatReport;
    }

    public static boolean O() {
        return b.mIsInternational;
    }

    public static String P() {
        if (com.uc.crashsdk.a.g.a(c.mVersion)) {
            return a.a();
        }
        return c.mVersion;
    }

    public static String Q() {
        return com.uc.crashsdk.a.g.a(c.mSubVersion) ? "release" : c.mSubVersion;
    }

    public static String R() {
        if (com.uc.crashsdk.a.g.a(c.mBuildId)) {
            return aa();
        }
        return c.mBuildId;
    }

    public static String S() {
        if (f == null) {
            f = com.uc.crashsdk.a.g.b() + File.separatorChar + b.mTagFilesFolderName + File.separatorChar;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String T() {
        if (g == null) {
            g = com.uc.crashsdk.a.g.b() + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String U() {
        String path;
        if (h == null) {
            if (!com.uc.crashsdk.a.g.a(b.mLogsBackupPathName)) {
                String trim = b.mLogsBackupPathName.trim();
                if (!trim.endsWith(File.separator)) {
                    trim = trim + File.separator;
                }
                h = trim;
            } else {
                if (!b.D()) {
                    try {
                        path = Environment.getExternalStorageDirectory().getPath();
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    h = path + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
                }
                path = "/sdcard";
                h = path + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return h;
    }

    private static void V() {
        CustomInfo customInfo = b;
        JNIBridge.nativeSetCrashLogFileNames(customInfo.mNativeCrashLogFileName, customInfo.mUnexpCrashLogFileName, customInfo.mAppId);
    }

    private static void W() {
        boolean L = L();
        CustomInfo customInfo = b;
        JNIBridge.nativeSetCrashCustoms(L, customInfo.mBackupLogs, customInfo.mCrashRestartInterval, customInfo.mMaxCrashLogFilesCount, customInfo.mMaxNativeLogcatLineCount, customInfo.mMaxUnexpLogcatLineCount, customInfo.mOverrideLibcMalloc, K(), b.mIsUsedByUCM, Build.VERSION.SDK_INT, b.mOmitNativeCrash);
    }

    private static void X() {
        CustomInfo customInfo = b;
        JNIBridge.nativeUpdateSignals(customInfo.mDisableSignals, customInfo.mDisableBackgroundSignals, 0);
    }

    private static void Y() {
        CustomInfo customInfo = b;
        JNIBridge.nativeSetZip(customInfo.mZipLog, customInfo.mZippedLogExtension, customInfo.mLogMaxBytesLimit);
    }

    private static void Z() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("thdump", null, b.mThreadsDumpMinLimit, 0L);
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        b = customInfo2;
        c(customInfo2);
        c = new VersionInfo(versionInfo);
        if (b.D()) {
            return;
        }
        try {
            b();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String aa() {
        /*
            java.lang.String r0 = com.uc.crashsdk.h.e
            if (r0 == 0) goto L5
            return r0
        L5:
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = com.uc.crashsdk.a.g.c()     // Catch: java.lang.Throwable -> L38
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch: java.lang.Throwable -> L36
            long r2 = r0.getCrc()     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = java.lang.Long.toHexString(r2)     // Catch: java.lang.Throwable -> L36
            com.uc.crashsdk.h.e = r0     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = "version unique build id: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = com.uc.crashsdk.h.e     // Catch: java.lang.Throwable -> L36
            r0.append(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L36
            com.uc.crashsdk.a.a.b(r0)     // Catch: java.lang.Throwable -> L36
        L32:
            r1.close()     // Catch: java.lang.Throwable -> L46
            goto L46
        L36:
            r0 = move-exception
            goto L3c
        L38:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3c:
            java.lang.String r2 = ""
            com.uc.crashsdk.h.e = r2     // Catch: java.lang.Throwable -> L49
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L46
            goto L32
        L46:
            java.lang.String r0 = com.uc.crashsdk.h.e
            return r0
        L49:
            r0 = move-exception
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Throwable -> L4f
        L4f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.h.aa():java.lang.String");
    }

    private static void ab() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("crver", a.b, 0L, 1L);
        }
    }

    private static void ac() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("inter", null, b.mIsInternational ? 2L : 1L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        b.v();
        b.u();
        if (b.mBackupLogs) {
            File file = new File(U());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
    }

    public static void d() {
        W();
        X();
        Y();
        a(b.mLogTypeSuffix);
    }

    public static void e() {
        ac();
        if (e.h()) {
            JNIBridge.nativeSetCrashLogFilesUploaded();
        }
        CustomInfo customInfo = b;
        JNIBridge.nativeReserveFileHandle(customInfo.mReservedNativeFileHandleCount, customInfo.mFdDumpMinLimit);
        JNIBridge.nativeSetForeground(b.y());
        JNIBridge.nativeSetProcessType(b.A());
        a.d();
        a.f();
        a.h();
        a.j();
        JNIBridge.nativeSetPackageInfo(a.a, "", "");
        Z();
        JNIBridge.nativeSyncInfo("aver", a.a(), 0L, 0L);
        ab();
        b.C();
        com.uc.crashsdk.a.g.j();
    }

    public static String f() {
        return b.mAppId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g() {
        return com.uc.crashsdk.a.g.b(b.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(b.mNativeCrashLogFileName) || com.uc.crashsdk.a.g.b(b.mUnexpCrashLogFileName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        return b.mJavaCrashLogFileName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i() {
        return b.mCrashRestartInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return b.mCallJavaDefaultHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return b.mDumpHprofDataForJavaOOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l() {
        return b.mRenameFileToDefaultName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m() {
        return b.mMaxCrashLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n() {
        return b.mMaxCustomLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o() {
        return b.mMaxJavaLogcatLineCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p() {
        return b.mUnexpDelayMillSeconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q() {
        return b.mUnexpSubTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return b.mBackupLogs;
    }

    public static boolean s() {
        return b.mUploadUcebuCrashLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return b.mSyncUploadSetupCrashLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return b.mOmitJavaCrash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return b.mAutoDeleteOldVersionStats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w() {
        return b.mZipLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x() {
        return b.mZippedLogExtension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y() {
        return b.mLogMaxBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z() {
        return b.mLogMaxUploadBytesLimit;
    }

    public static void a(CustomInfo customInfo) {
        if (!a && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!a && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (i) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (b == null) {
                    b = new CustomInfo();
                }
                CustomInfo customInfo2 = b;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                } else {
                    customInfo2.mAppId = customInfo.mAppId;
                    i3 = 1;
                }
                int i4 = i3;
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    i3++;
                    i4 = 1;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    i3++;
                    i4 = 1;
                }
                if (i4 != 0) {
                    e.b();
                    if (b.d) {
                        V();
                        JNIBridge.nativeUpdateCrashLogNames();
                    }
                }
                if (customInfo2.mPrintStackInfos != customInfo.mPrintStackInfos) {
                    customInfo2.mPrintStackInfos = customInfo.mPrintStackInfos;
                    i3++;
                    z = true;
                } else {
                    z = false;
                }
                if (customInfo2.mDebug != customInfo.mDebug) {
                    customInfo2.mDebug = customInfo.mDebug;
                    i3++;
                    z = true;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    i3++;
                    z = true;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    i3++;
                    z = true;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        i.a();
                    }
                    i3++;
                    z = true;
                }
                if (customInfo2.mMaxCrashLogFilesCount != customInfo.mMaxCrashLogFilesCount) {
                    customInfo2.mMaxCrashLogFilesCount = customInfo.mMaxCrashLogFilesCount;
                    i3++;
                    z = true;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    i3++;
                    z = true;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i3++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    i3++;
                    z = true;
                }
                if (customInfo2.mIsUsedByUCM != customInfo.mIsUsedByUCM) {
                    customInfo2.mIsUsedByUCM = customInfo.mIsUsedByUCM;
                    i3++;
                    z = true;
                }
                if (z && b.d) {
                    W();
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                    z2 = true;
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    i3++;
                    z2 = true;
                }
                if (z2 && b.d) {
                    Y();
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i3++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i3++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i3++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadCrashLogCountPerDay != customInfo.mMaxUploadCrashLogCountPerDay) {
                    customInfo2.mMaxUploadCrashLogCountPerDay = customInfo.mMaxUploadCrashLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i3++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i3++;
                }
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler || customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                        i3++;
                    }
                    if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                        i3++;
                    }
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    if (b.d) {
                        JNIBridge.nativeSetLogStrategy(b.mCallNativeDefaultHandler, b.mDumpUserSolibBuildId, b.mReservedNativeMemoryBytes);
                    }
                    i3++;
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i3++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i3++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i3++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.d) {
                        JNIBridge.nativeReserveFileHandle(0, b.mFdDumpMinLimit);
                    }
                    i3++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    Z();
                }
                if (customInfo2.mUnexpInfoUpdateInterval != customInfo.mUnexpInfoUpdateInterval) {
                    if (customInfo2.mUnexpInfoUpdateInterval <= 0 && customInfo.mUnexpInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mUnexpInfoUpdateInterval = customInfo.mUnexpInfoUpdateInterval;
                    i3++;
                }
                if (!a(customInfo.mLogTypeSuffix, customInfo2.mLogTypeSuffix)) {
                    customInfo2.mLogTypeSuffix = customInfo.mLogTypeSuffix;
                    if (b.d) {
                        a(customInfo2.mLogTypeSuffix);
                    }
                    i3++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.d) {
                        X();
                    }
                    i3++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    if (customInfo2.mEnableStatReport) {
                        e.v();
                    }
                    i3++;
                }
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    ac();
                    i3++;
                }
                if (customInfo2.mAutoDetectLifeCycle != customInfo.mAutoDetectLifeCycle) {
                    customInfo2.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
                    if (customInfo2.mAutoDetectLifeCycle) {
                        b.z();
                    }
                    i3++;
                }
                if (customInfo2.mMonitorBattery != customInfo.mMonitorBattery) {
                    customInfo2.mMonitorBattery = customInfo.mMonitorBattery;
                    e.c(b.y());
                    i3++;
                }
                if (customInfo2.mUnexpSubTypes != customInfo.mUnexpSubTypes) {
                    customInfo2.mUnexpSubTypes = customInfo.mUnexpSubTypes;
                    i3++;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static void c() {
        String b2 = com.uc.crashsdk.a.g.b();
        CustomInfo customInfo = b;
        JNIBridge.nativeSetFolderNames(b2, customInfo.mTagFilesFolderName, customInfo.mCrashLogsFolderName, U());
        JNIBridge.nativeSetProcessNames(e.g(), b.a());
        JNIBridge.nativeSetVersionInfo(P(), Q(), R(), "190513114645");
        JNIBridge.nativeSetMobileInfo(Build.MODEL, Build.VERSION.RELEASE, e.n());
        CustomInfo customInfo2 = b;
        JNIBridge.nativeSetLogStrategy(customInfo2.mCallNativeDefaultHandler, customInfo2.mDumpUserSolibBuildId, customInfo2.mReservedNativeMemoryBytes);
        V();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return b != null;
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (d) {
            c = new VersionInfo(versionInfo);
            e.b();
            if (b.d) {
                JNIBridge.nativeSetVersionInfo(P(), Q(), R(), "190513114645");
                JNIBridge.nativeUpdateCrashLogNames();
            }
        }
    }

    private static void a(String str) {
        String a2 = e.a(str);
        JNIBridge.nativeSyncInfo("mLogTypeSuffix", a2, 0L, 0L);
        if (e.y() || b.D()) {
            return;
        }
        e.b(a2);
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = b;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = c;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.b = string4;
            ab();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
