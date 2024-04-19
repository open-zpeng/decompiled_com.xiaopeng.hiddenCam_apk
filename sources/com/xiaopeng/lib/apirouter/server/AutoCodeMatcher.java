package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
class AutoCodeMatcher {
    private static final String HELPER_CLASS_NAME = "com.xiaopeng.lib.apirouter.server.ManifestHelper";
    private static final String MAPPING = "mapping";
    private static HashMap<String, Pair<IBinder, String>> mapping;

    private void reflectMapping() {
        Field field;
        try {
            Class<?> cls = Class.forName(HELPER_CLASS_NAME);
            if (cls == null || (field = cls.getField(MAPPING)) == null) {
                return;
            }
            mapping = (HashMap) field.get(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pair<IBinder, String> match(String str) {
        if (mapping == null) {
            reflectMapping();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = mapping;
        Pair<IBinder, String> pair = hashMap == null ? null : hashMap.get(str);
        return pair == null ? new Pair<>(null, null) : pair;
    }
}
