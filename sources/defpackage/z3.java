package defpackage;

import com.xiaopeng.hiddenCam.bean.DownloadInfo;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.INFENCESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.REGFENCEFILESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.REGGARAGEINFOSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.REGLISTF;
import com.xiaopeng.hiddenCam.state.ENUM.ROADATTR;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADYSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.GpsUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
/* compiled from: ProcessGpsGarageRunable.java */
/* renamed from: z3  reason: default package */
/* loaded from: classes.dex */
public class z3 implements Runnable {
    OssService b;
    StateCollection c;
    l4 d;
    public boolean e = false;
    public REGGARAGEINFOSTATUS f = REGGARAGEINFOSTATUS.INITIAL;
    public REGFENCEFILESTATUS g = REGFENCEFILESTATUS.INITIAL;
    private int h = -1;

    public z3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        this.b = ossService;
        this.c = stateCollection;
        this.d = l4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.e && this.c.getXpu_ready_status() == XPUREADYSTATUS.READY.value) {
            FileSaver.loadDownloadedInfo();
            this.d.g();
            this.e = true;
        }
        if (this.c.getReg_listF_status() == REGLISTF.INITIAL && this.c.getXpu_ready_status() == XPUREADYSTATUS.READY.value && this.c.getTbox_rsrp() > -95) {
            StringBuilder sb = new StringBuilder();
            sb.append("oss tbox_rsrp  ");
            sb.append(this.c.getTbox_rsrp());
            sb.append(" ret: ");
            sb.append(this.c.getTbox_rsrp() > -95);
            LogUtils.d(sb.toString());
            this.c.setReg_listF_status(REGLISTF.DOWNLOADING);
            this.b.b(this.c.getVinCode());
        }
        if (this.f == REGGARAGEINFOSTATUS.INITIAL && this.c.getReg_listF_status() == REGLISTF.FINISH_DOWNLOADING && this.c.getTbox_rsrp() > -95) {
            this.b.a();
            this.f = REGGARAGEINFOSTATUS.DOWNLOADING;
        }
        if (this.g == REGFENCEFILESTATUS.INITIAL && this.c.getXpu_ready_status() == XPUREADYSTATUS.READY.value && this.c.getTbox_rsrp() > -95 && this.c.getCarType() == CARTYPE.D55.value && GpsUtils.getCityInfo(this.c.getCity_info()) == 0 && x3.d == 1) {
            String str = this.c.getCity_info().city_id;
            String str2 = this.c.getCity_info().city_name;
            LogUtils.d(" gps onground started to download fence of city_ID: " + str + " city_name: " + str2);
            if (str != "") {
                this.g = REGFENCEFILESTATUS.DOWNLOADING;
                this.b.a(str, str2);
            }
        }
        if (this.c.getStop_all_task() == STOPALLTASK.NORMAL && this.c.getCfc() >= CFC.HIGH.value) {
            try {
                if (this.c.getRoad_attr() != ROADATTR.ROADATTR_1.value && this.c.getRoad_attr() != ROADATTR.ROADATTR_2.value && this.c.getRoad_attr() != ROADATTR.ROADATTR_7.value) {
                    if (this.c.getScu_locat_spd() > 0.1d && this.c.getScu_locat_spd() < 9.0f && DrivingData.getInstance().GSV_Sat_Cnt > 4.0f) {
                        int knnSearch = GpsUtils.knnSearch((float) this.c.getLast_gps().b, (float) this.c.getLast_gps().a);
                        LogUtils.d("gps knn search ret_value : " + knnSearch + " cur: " + this.h);
                        if (knnSearch > -1) {
                            if (knnSearch == 2) {
                                this.d.i().b().setParkingGroundState(1);
                                GpsUtils.getGarageInfo(this.c.getGarage_info());
                                String str3 = this.c.getGarage_info().city_id;
                                int i = this.c.getGarage_info().garage_id;
                                String str4 = this.c.getGarage_info().city_name;
                                String str5 = this.c.getGarage_info().map_name;
                                long j = this.c.getGarage_info().update_time;
                                LogUtils.d("gps started to download garage: " + i + " city_name: " + str4);
                                if (!FileSaver.mapDownloadedInfos.containsKey(str5)) {
                                    DownloadInfo downloadInfo = new DownloadInfo();
                                    downloadInfo.update_time = j;
                                    LogUtils.d("gps Downloading time = " + j);
                                    FileSaver.mapDownloadedInfos.put(str5, downloadInfo);
                                    this.b.a(str3, str4, i, str5);
                                } else {
                                    DownloadInfo downloadInfo2 = FileSaver.mapDownloadedInfos.get(str5);
                                    long j2 = downloadInfo2.update_time;
                                    LogUtils.d("gps old time: " + j2 + " new time: " + j);
                                    if (j != j2) {
                                        this.b.a(str3, str4, i, str5);
                                        downloadInfo2.update_time = j;
                                        FileSaver.mapDownloadedInfos.put(str5, downloadInfo2);
                                    }
                                }
                            }
                            if (this.h != knnSearch && knnSearch != 2) {
                                this.h = knnSearch;
                                LogUtils.d("gps mode switch!!!!!!!! : " + this.h);
                                this.d.i().b().setParkingGroundState(this.h);
                            }
                        }
                    } else if (this.c.getScu_locat_spd() > 10.0f && this.c.getLast_indoor_status() == INDOORSTATUS.OUTDOOR.value && this.h != 0) {
                        this.h = 0;
                        this.d.i().b().setParkingGroundState(this.h);
                    }
                    if (!this.c.isbFetchFence() || this.c.getLast_indoor_status() != INDOORSTATUS.OUTDOOR.value || this.c.getScu_locat_spd() <= 0.1d || this.c.getScu_locat_spd() >= 9.0f) {
                        return;
                    }
                    this.c.setInfence_status(GpsUtils.knnSearchfence((float) this.c.getLast_gps().b, (float) this.c.getLast_gps().a));
                    if (this.c.getInfence_status() > INFENCESTATUS.INITIAL.value) {
                        JniUtil.setInfenceStatus(this.c.getInfence_status());
                        if (this.c.getInfence_status() > INFENCESTATUS.INITIAL.value) {
                            LogUtils.d("onground infence_status:  " + this.c.getInfence_status());
                            int fenceId = GpsUtils.getFenceId();
                            if (fenceId > 0) {
                                JniUtil.setFenceId(fenceId);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
                LogUtils.e("gps mProcessGpsGarage fail!! ");
            }
        }
    }
}
