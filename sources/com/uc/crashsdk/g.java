package com.uc.crashsdk;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
final class g implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return com.uc.crashsdk.a.g.b(str) && str.endsWith(".st");
    }
}
