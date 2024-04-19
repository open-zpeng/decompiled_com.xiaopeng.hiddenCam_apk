package com.xiaopeng.lib.framework.moduleinterface.aiassistantmodule.sensor;

import java.lang.reflect.Field;
/* loaded from: classes.dex */
public abstract class BaseSensor {
    private ISensorCallback mSensorCallback;
    private ISensorListener mSensorListener;

    protected BaseSensor() {
        initField();
    }

    private Field getFieldByClasss(String str, Object obj) {
        Field field = null;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                field = cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return field;
    }

    public void doExtra(String str) {
    }

    public ISensorCallback getSensorCallback() {
        return this.mSensorCallback;
    }

    public ISensorListener getSensorListener() {
        return this.mSensorListener;
    }

    public abstract void initField();

    public String onRequestSensorValue(String str) {
        String str2;
        try {
            Field fieldByClasss = getFieldByClasss(str, this);
            refreshField(str);
            fieldByClasss.setAccessible(true);
            str2 = String.valueOf(fieldByClasss.get(this));
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        if (getSensorCallback() != null) {
            getSensorCallback().onSensorReponse(sensorName(), str, str2);
        }
        return str2;
    }

    public void refreshField(String str) {
    }

    protected void sensing(String str, String str2) {
        if (getSensorListener() != null) {
            getSensorListener().onSensorChange(sensorName(), str, str2);
        }
    }

    public abstract String sensorName();

    public void setSensorCallback(ISensorCallback iSensorCallback) {
        this.mSensorCallback = iSensorCallback;
    }

    public void setSensorListener(ISensorListener iSensorListener) {
        this.mSensorListener = iSensorListener;
    }

    public abstract void startSensing();

    public abstract void stopSensing();

    protected void sensing(String str, Object obj) {
        sensing(str, String.valueOf(obj));
    }
}
