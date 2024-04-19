package com.xiaopeng.speech.protocol.query.music.bean;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class PlayInfo {
    public static final int ERROR_CURRENT_NOT_PLAY = 20001;
    public static final int ERROR_SUPPORT_PLAY_TYPE_GET = 20002;
    public static final int TYPE_AUDIO_BOOK = 2;
    public static final int TYPE_BT_FM = 5;
    public static final int TYPE_FM = 3;
    public static final int TYPE_NETWORK_FM = 4;
    public static final int TYPE_SONG = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_USB_MUSIC = 6;
    private String album;
    private String artist;
    private int error;
    private long playTime;
    private int playType;
    private long remainingTime;
    private String title;

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getError() {
        return this.error;
    }

    public long getPlayTime() {
        return this.playTime;
    }

    public int getPlayType() {
        return this.playType;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setError(int i) {
        this.error = i;
    }

    public void setPlayTime(long j) {
        this.playTime = j;
    }

    public void setPlayType(int i) {
        this.playType = i;
    }

    public void setRemainingTime(long j) {
        this.remainingTime = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PlayInfo{title='" + this.title + "', artist='" + this.artist + "', album='" + this.album + "', playTime=" + this.playTime + ", remainingTime=" + this.remainingTime + ", playType=" + this.playType + ", error=" + this.error + '}';
    }
}
