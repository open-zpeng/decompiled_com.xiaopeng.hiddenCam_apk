package com.xiaopeng.hiddenCam.http.bean;

import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.StateCollection;
import java.io.Serializable;
/* loaded from: classes.dex */
public class EventBean<T> implements Serializable {
    public EventBean(int i, T t, String str, String str2, String str3, int i2) {
        StateCollection.getInstance().getCfc();
        if (i2 == CARTYPE.NOT_INITIAL.value || i2 == CARTYPE.E28.value || i2 == CARTYPE.D21.value || i2 == CARTYPE.D55.value) {
            return;
        }
        int i3 = CARTYPE.D20.value;
    }

    public EventBean(String str, int i, T t, String str2, String str3, String str4, int i2) {
        StateCollection.getInstance().getCfc();
        if (i2 == CARTYPE.NOT_INITIAL.value || i2 == CARTYPE.E28.value || i2 == CARTYPE.D21.value || i2 == CARTYPE.D55.value) {
            return;
        }
        int i3 = CARTYPE.D20.value;
    }
}
