package com.xiaopeng.speech.protocol.bean.config;

import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.Map;
@DontProguardClass
/* loaded from: classes.dex */
public class SpeechMainData {
    private OperationInfoBean info;
    private Map<String, OperationBean> operations;

    public OperationInfoBean getInfo() {
        return this.info;
    }

    public Map<String, OperationBean> getOperations() {
        return this.operations;
    }

    public void setInfo(OperationInfoBean operationInfoBean) {
        this.info = operationInfoBean;
    }

    public void setOperations(Map<String, OperationBean> map) {
        this.operations = map;
    }
}
