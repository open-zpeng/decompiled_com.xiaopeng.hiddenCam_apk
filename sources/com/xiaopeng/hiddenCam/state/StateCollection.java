package com.xiaopeng.hiddenCam.state;

import com.xiaopeng.hiddenCam.bean.CityInfoBean;
import com.xiaopeng.hiddenCam.bean.GarageInfoBean;
import com.xiaopeng.hiddenCam.proto.HDMapMsgProto;
import com.xiaopeng.hiddenCam.state.ENUM.ALCCTRLSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.APSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.APTIPS;
import com.xiaopeng.hiddenCam.state.ENUM.AVMREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.CAMERA;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.ENUM.CONFIG;
import com.xiaopeng.hiddenCam.state.ENUM.DRIVEMODEFB;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.INFENCESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.NETWORKFLAG;
import com.xiaopeng.hiddenCam.state.ENUM.NGPSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.REGLISTF;
import com.xiaopeng.hiddenCam.state.ENUM.ROADATTR;
import com.xiaopeng.hiddenCam.state.ENUM.SIGNALSTATE;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.SUPERACTIVATE;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADY;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import defpackage.x3;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class StateCollection {
    private static StateCollection stateCollection = new StateCollection();
    int avm_type;
    public int carType;
    public String car_in_info;
    int cfc;
    public CityInfoBean city_info;
    private int continus_img_proc_fail_count;
    public int current_gear_;
    private x3.b entrance_gps;
    private boolean extrinsic_send_to_xpu;
    private boolean first_start_cam;
    public GarageInfoBean garage_info;
    public int ishdmap_;
    private x3.b last_gps;
    public int last_pk_map_id;
    public INDOORSTATUS poweron_indoor;
    private int processAvmYuvsCount;
    public boolean screen_light;
    private STOPALLTASK stop_all_task;
    private SUPERACTIVATE super_activate;
    public String vinCode;
    public long xpu_map_time_;
    private int yuv_finish_status;
    private YUVPROCSTATUS yuv_ong_proc_status;
    private YUVPROCSTATUS yuv_out_finish_status;
    private YUVPROCSTATUS yuv_out_proc_status;
    private YUVPROCSTATUS yuv_proc_status;
    public CopyOnWriteArrayList<HDMapMsgProto.HDMapXpuFsdApaFrontSlot> fsd_slot = new CopyOnWriteArrayList<>();
    private byte[] mPreBuffer = null;
    int stop_cam = CAMERA.CAMERA_STATE_NOT_START.value;
    boolean camera_inited = false;
    boolean allow_to_open = false;
    private int resetImgProcFlag = 0;
    private int is_config_init = CONFIG.CONFIG_NOT_INIT.value;
    public REGLISTF reg_listF_status = REGLISTF.INITIAL;
    private boolean bFetchFence = false;
    public float scu_locat_S = 0.0f;
    public String listF_ver = "";
    private float scu_locat_spd = 0.0f;
    n4 avmsocket = null;
    o4 avmsocket_on = null;
    private long onground_apa_time = 0;
    private long power_on_time = 0;
    public int signal_state = SIGNALSTATE.INITIAL.value;
    private XPUREADY xpu_ready_flag = XPUREADY.NOT_READY;
    private int xpu_ready_status = XPUREADYSTATUS.INITIAL.value;
    private int last_indoor_status = INDOORSTATUS.INITIAL.value;
    private int infence_status = INFENCESTATUS.INFENCE_OUTSIDE.value;
    private int last_infence_status = INFENCESTATUS.INITIAL.value;
    public String study_map_name = "";
    private int avm_ready_status = AVMREADYSTATUS.INITIAL.value;
    public int ngp_status_ = NGPSTATUS.INITIAL.value;
    private int keep_slow_count = 0;
    public int network_flag = NETWORKFLAG.NOT_INITIAL.value;
    public int drive_mode_fb = DRIVEMODEFB.INITIAL.value;
    public int ap_status_ = APSTATUS.INITIAL.value;
    public int alc_ctrl_status = ALCCTRLSTATUS.INITIAL.value;
    public int ap_tips_ = APTIPS.INITIAL.value;
    private int tbox_rsrp = -1000;
    private int first_tbox_rsrp = -1000;
    private int charge_status = -1;
    private int brightness = 0;
    private int road_attr = ROADATTR.INITIAL.value;
    private long start_cam_time = 0;

    public StateCollection() {
        YUVPROCSTATUS yuvprocstatus = YUVPROCSTATUS.PROCESS_YUV;
        this.yuv_proc_status = yuvprocstatus;
        this.yuv_finish_status = -1;
        this.yuv_out_proc_status = yuvprocstatus;
        this.yuv_out_finish_status = YUVPROCSTATUS.INITIAL;
        this.yuv_ong_proc_status = YUVPROCSTATUS.PROCESS_YUV;
        this.ishdmap_ = -1;
        this.last_pk_map_id = 0;
        this.xpu_map_time_ = 0L;
        this.continus_img_proc_fail_count = 0;
        this.first_start_cam = false;
        this.extrinsic_send_to_xpu = false;
        this.vinCode = "";
        this.carType = CARTYPE.NOT_INITIAL.value;
        this.cfc = CFC.INVALID.value;
        this.avm_type = 0;
        this.processAvmYuvsCount = 0;
        this.garage_info = new GarageInfoBean();
        this.city_info = new CityInfoBean();
        this.current_gear_ = 0;
        this.poweron_indoor = INDOORSTATUS.INITIAL;
        this.screen_light = false;
        this.car_in_info = "";
        this.super_activate = SUPERACTIVATE.INITIAL;
        this.stop_all_task = STOPALLTASK.NORMAL;
    }

    public static StateCollection getInstance() {
        return stateCollection;
    }

    public int getAlc_ctrl_status() {
        return this.alc_ctrl_status;
    }

    public int getAp_status_() {
        return this.ap_status_;
    }

    public int getAp_tips_() {
        return this.ap_tips_;
    }

    public int getAvm_ready_status() {
        return this.avm_ready_status;
    }

    public int getAvm_type() {
        return this.avm_type;
    }

    public n4 getAvmsocket() {
        return this.avmsocket;
    }

    public o4 getAvmsocket_on() {
        return this.avmsocket_on;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public int getCarType() {
        return this.carType;
    }

    public String getCar_in_info() {
        return this.car_in_info;
    }

    public int getCfc() {
        return this.cfc;
    }

    public int getCharge_status() {
        return this.charge_status;
    }

    public CityInfoBean getCity_info() {
        return this.city_info;
    }

    public int getContinus_img_proc_fail_count() {
        return this.continus_img_proc_fail_count;
    }

    public int getCurrent_gear_() {
        return this.current_gear_;
    }

    public int getDrive_mode_fb() {
        return this.drive_mode_fb;
    }

    public x3.b getEntrance_gps() {
        return this.entrance_gps;
    }

    public int getFirst_tbox_rsrp() {
        return this.first_tbox_rsrp;
    }

    public HDMapMsgProto.HDMapXpuFsdApaFrontSlot[] getFsd_slot() {
        return (HDMapMsgProto.HDMapXpuFsdApaFrontSlot[]) this.fsd_slot.toArray(new HDMapMsgProto.HDMapXpuFsdApaFrontSlot[0]);
    }

    public GarageInfoBean getGarage_info() {
        return this.garage_info;
    }

    public int getInfence_status() {
        return this.infence_status;
    }

    public int getIs_config_init() {
        return this.is_config_init;
    }

    public int getIshdmap_() {
        return this.ishdmap_;
    }

    public int getKeep_slow_count() {
        return this.keep_slow_count;
    }

    public x3.b getLast_gps() {
        return this.last_gps;
    }

    public int getLast_indoor_status() {
        return this.last_indoor_status;
    }

    public int getLast_infence_status() {
        return this.last_infence_status;
    }

    public int getLast_pk_map_id() {
        return this.last_pk_map_id;
    }

    public String getListF_ver() {
        return this.listF_ver;
    }

    public int getNetwork_flag() {
        return this.network_flag;
    }

    public int getNgp_status_() {
        return this.ngp_status_;
    }

    public long getOnground_apa_time() {
        return this.onground_apa_time;
    }

    public long getPower_on_time() {
        return this.power_on_time;
    }

    public INDOORSTATUS getPoweron_indoor() {
        return this.poweron_indoor;
    }

    public int getProcessAvmYuvsCount() {
        return this.processAvmYuvsCount;
    }

    public REGLISTF getReg_listF_status() {
        return this.reg_listF_status;
    }

    public int getResetImgProcFlag() {
        return this.resetImgProcFlag;
    }

    public int getRoad_attr() {
        return this.road_attr;
    }

    public float getScu_locat_S() {
        return this.scu_locat_S;
    }

    public float getScu_locat_spd() {
        return this.scu_locat_spd;
    }

    public int getSignal_state() {
        return this.signal_state;
    }

    public long getStart_cam_time() {
        return this.start_cam_time;
    }

    public STOPALLTASK getStop_all_task() {
        return this.stop_all_task;
    }

    public int getStop_cam() {
        return this.stop_cam;
    }

    public String getStudy_map_name() {
        return this.study_map_name;
    }

    public SUPERACTIVATE getSuper_activate() {
        return this.super_activate;
    }

    public int getTbox_rsrp() {
        return this.tbox_rsrp;
    }

    public String getVinCode() {
        return this.vinCode;
    }

    public long getXpu_map_time_() {
        return this.xpu_map_time_;
    }

    public XPUREADY getXpu_ready_flag() {
        return this.xpu_ready_flag;
    }

    public int getXpu_ready_status() {
        return this.xpu_ready_status;
    }

    public int getYuv_finish_status() {
        return this.yuv_finish_status;
    }

    public YUVPROCSTATUS getYuv_ong_proc_status() {
        return this.yuv_ong_proc_status;
    }

    public YUVPROCSTATUS getYuv_out_finish_status() {
        return this.yuv_out_finish_status;
    }

    public YUVPROCSTATUS getYuv_out_proc_status() {
        return this.yuv_out_proc_status;
    }

    public YUVPROCSTATUS getYuv_proc_status() {
        return this.yuv_proc_status;
    }

    public byte[] getmPreBuffer() {
        return this.mPreBuffer;
    }

    public boolean isAllow_to_open() {
        return this.allow_to_open;
    }

    public boolean isCamera_inited() {
        return this.camera_inited;
    }

    public boolean isFirst_start_cam() {
        return this.first_start_cam;
    }

    public boolean isScreen_light() {
        return this.screen_light;
    }

    public boolean is_extrinsic_send_to_xpu() {
        return this.extrinsic_send_to_xpu;
    }

    public boolean isbFetchFence() {
        return this.bFetchFence;
    }

    public void setAlc_ctrl_status(int i) {
        this.alc_ctrl_status = i;
    }

    public void setAllow_to_open(boolean z) {
        this.allow_to_open = z;
    }

    public void setAp_status_(int i) {
        this.ap_status_ = i;
    }

    public void setAp_tips_(int i) {
        this.ap_tips_ = i;
    }

    public void setAvm_ready_status(int i) {
        this.avm_ready_status = i;
    }

    public void setAvm_type(int i) {
        this.avm_type = i;
    }

    public void setAvmsocket(n4 n4Var) {
        this.avmsocket = n4Var;
    }

    public void setAvmsocket_on(o4 o4Var) {
        this.avmsocket_on = o4Var;
    }

    public void setBrightness(int i) {
        this.brightness = i;
    }

    public void setCamera_inited(boolean z) {
        this.camera_inited = z;
    }

    public void setCarType(int i) {
        this.carType = i;
    }

    public void setCar_in_info(String str) {
        this.car_in_info = str;
    }

    public void setCfc(int i) {
        this.cfc = i;
    }

    public void setCharge_status(int i) {
        this.charge_status = i;
    }

    public void setCity_info(CityInfoBean cityInfoBean) {
        this.city_info = cityInfoBean;
    }

    public void setContinus_img_proc_fail_count(int i) {
        this.continus_img_proc_fail_count = i;
    }

    public void setCurrent_gear_(int i) {
        this.current_gear_ = i;
    }

    public void setDrive_mode_fb(int i) {
        this.drive_mode_fb = i;
    }

    public void setEntrance_gps(x3.b bVar) {
        this.entrance_gps = bVar;
    }

    public void setExtrinsic_send_to_xpu(boolean z) {
        this.extrinsic_send_to_xpu = z;
    }

    public void setFirst_start_cam(boolean z) {
        this.first_start_cam = z;
    }

    public void setFirst_tbox_rsrp(int i) {
        this.first_tbox_rsrp = i;
    }

    public void setGarage_info(GarageInfoBean garageInfoBean) {
        this.garage_info = garageInfoBean;
    }

    public void setInfence_status(int i) {
        this.infence_status = i;
    }

    public void setIs_config_init(int i) {
        this.is_config_init = i;
    }

    public void setIshdmap_(int i) {
        this.ishdmap_ = i;
    }

    public void setKeep_slow_count(int i) {
        this.keep_slow_count = i;
    }

    public void setLast_gps(x3.b bVar) {
        this.last_gps = bVar;
    }

    public void setLast_indoor_status(int i) {
        this.last_indoor_status = i;
    }

    public void setLast_infence_status(int i) {
        this.last_infence_status = i;
    }

    public void setLast_pk_map_id(int i) {
        this.last_pk_map_id = i;
    }

    public void setListF_ver(String str) {
        this.listF_ver = str;
    }

    public void setNetwork_flag(int i) {
        this.network_flag = i;
    }

    public void setNgp_status_(int i) {
        this.ngp_status_ = i;
    }

    public void setOnground_apa_time(long j) {
        this.onground_apa_time = j;
    }

    public void setPower_on_time(long j) {
        this.power_on_time = j;
    }

    public void setPoweron_indoor(INDOORSTATUS indoorstatus) {
        this.poweron_indoor = indoorstatus;
    }

    public void setProcessAvmYuvsCount(int i) {
        this.processAvmYuvsCount = i;
    }

    public void setReg_listF_status(REGLISTF reglistf) {
        this.reg_listF_status = reglistf;
    }

    public void setResetImgProcFlag(int i) {
        this.resetImgProcFlag = i;
    }

    public void setRoad_attr(int i) {
        this.road_attr = i;
    }

    public void setScreen_light(boolean z) {
        this.screen_light = z;
    }

    public void setScu_locat_S(float f) {
        this.scu_locat_S = f;
    }

    public void setScu_locat_spd(float f) {
        this.scu_locat_spd = f;
    }

    public void setSignal_state(int i) {
        this.signal_state = i;
    }

    public void setStart_cam_time(long j) {
        this.start_cam_time = j;
    }

    public void setStop_all_task(STOPALLTASK stopalltask) {
        this.stop_all_task = stopalltask;
    }

    public void setStop_cam(int i) {
        this.stop_cam = i;
    }

    public void setStudy_map_name(String str) {
        this.study_map_name = str;
    }

    public void setSuper_activate(SUPERACTIVATE superactivate) {
        this.super_activate = superactivate;
    }

    public void setTbox_rsrp(int i) {
        this.tbox_rsrp = i;
    }

    public void setVinCode(String str) {
        this.vinCode = str;
    }

    public void setXpu_map_time_(long j) {
        this.xpu_map_time_ = j;
    }

    public void setXpu_ready_flag(XPUREADY xpuready) {
        this.xpu_ready_flag = xpuready;
    }

    public void setXpu_ready_status(int i) {
        this.xpu_ready_status = i;
    }

    public void setYuv_finish_status(int i) {
        this.yuv_finish_status = i;
    }

    public void setYuv_ong_proc_status(YUVPROCSTATUS yuvprocstatus) {
        this.yuv_ong_proc_status = yuvprocstatus;
    }

    public void setYuv_out_finish_status(YUVPROCSTATUS yuvprocstatus) {
        this.yuv_out_finish_status = yuvprocstatus;
    }

    public void setYuv_out_proc_status(YUVPROCSTATUS yuvprocstatus) {
        this.yuv_out_proc_status = yuvprocstatus;
    }

    public void setYuv_proc_status(YUVPROCSTATUS yuvprocstatus) {
        this.yuv_proc_status = yuvprocstatus;
    }

    public void setbFetchFence(boolean z) {
        this.bFetchFence = z;
    }

    public void setmPreBuffer(byte[] bArr) {
        this.mPreBuffer = bArr;
    }
}
