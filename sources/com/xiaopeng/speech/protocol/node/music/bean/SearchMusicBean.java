package com.xiaopeng.speech.protocol.node.music.bean;

import android.os.Parcel;
import com.xiaopeng.speech.common.bean.BaseBean;
/* loaded from: classes.dex */
public class SearchMusicBean extends BaseBean {
    private boolean canDownload;
    private boolean canPlay;
    private String singers;
    private String songName;
    private boolean vip;

    public String toString() {
        return "MusicBean{singers='" + this.singers + "', songName='" + this.songName + "', vip='" + this.vip + "', canDownload='" + this.canDownload + "', canPlay='" + this.canPlay + "'}";
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.singers);
        parcel.writeString(this.songName);
        parcel.writeByte(this.vip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.canDownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.canPlay ? (byte) 1 : (byte) 0);
    }
}
