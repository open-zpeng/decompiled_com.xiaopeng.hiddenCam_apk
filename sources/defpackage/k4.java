package defpackage;

import com.xiaopeng.hiddenCam.http.bean.Data;
import com.xiaopeng.hiddenCam.http.bean.EventBean;
import com.xiaopeng.hiddenCam.http.bean.MapBean;
import com.xiaopeng.hiddenCam.state.StateCollection;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: EventUtils.java */
/* renamed from: k4  reason: default package */
/* loaded from: classes.dex */
public class k4 {
    public static EventBean<Data> a(String str, String str2, String str3, int i, int i2, String str4, StateCollection stateCollection, long j, long j2) {
        return new EventBean<>(i, new Data(i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), i2, "", new MapBean(str, str2, str3, stateCollection.getLast_gps().a, stateCollection.getLast_gps().b, j + "", j2 + "")), stateCollection.vinCode, y3.a, str4, stateCollection.getCarType());
    }

    public static EventBean<Data> a(String str, String str2, String str3, String str4, int i, int i2, String str5, StateCollection stateCollection, long j, long j2) {
        return new EventBean<>(str, i, new Data(i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), i2, "", new MapBean(str2, str3, str4, stateCollection.getLast_gps().a, stateCollection.getLast_gps().b, j + "", j2 + "")), stateCollection.vinCode, y3.a, str5, stateCollection.getCarType());
    }
}
