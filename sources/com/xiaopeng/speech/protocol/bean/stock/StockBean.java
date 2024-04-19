package com.xiaopeng.speech.protocol.bean.stock;

import com.xiaopeng.speech.common.bean.BaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class StockBean extends BaseBean {
    public float curMaxTransNum;
    public float curMaxTransPrice;
    public int curPosition;
    public a mBaseData;
    public List<Object> mStockList;
    public List<String> mTimeList;
    public String res = "";
    public float baseLineDate = 0.0f;
    public float length = 0.0f;

    /* loaded from: classes.dex */
    public static class a {
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float l;
        public float m;
        public float o;
        public String a = "";
        public String k = "";
        public String n = "";
        public String p = "";
        public String q = "";
        public String r = "";

        public String toString() {
            return "BaseData{symbol='" + this.a + "', low=" + this.b + ", current=" + this.c + ", peLYR=" + this.d + ", peTTM=" + this.e + ", high=" + this.f + ", lastClose=" + this.g + ", percentage=" + this.h + ", change=" + this.i + ", turnoverRate=" + this.j + ", code='" + this.k + "', amount=" + this.l + ", open=" + this.m + ", adate='" + this.n + "', avolume=" + this.o + ", name='" + this.p + "', exchange='" + this.q + "', state='" + this.r + "'}";
        }
    }

    public StockBean() {
        this.mBaseData = null;
        this.mStockList = null;
        this.mTimeList = null;
        this.curPosition = 0;
        this.curMaxTransPrice = 0.0f;
        this.curMaxTransNum = 0.0f;
        this.mStockList = new ArrayList();
        this.curPosition = 0;
        this.curMaxTransPrice = 0.0f;
        this.curMaxTransNum = 0.0f;
        this.mBaseData = new a();
        this.mTimeList = new ArrayList();
    }

    public String toString() {
        return "StockBean{mBaseData=" + this.mBaseData + ", mStockList=" + this.mStockList + ", mTimeList=" + this.mTimeList + ", curPosition=" + this.curPosition + ", curMaxTransPrice=" + this.curMaxTransPrice + ", curMaxTransNum=" + this.curMaxTransNum + ", res='" + this.res + "', baseLineDate=" + this.baseLineDate + ", length=" + this.length + '}';
    }
}
