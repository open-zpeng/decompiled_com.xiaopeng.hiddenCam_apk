package com.xiaopeng.speech.protocol.node.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.speech.common.bean.BaseBean;
/* loaded from: classes.dex */
public class SearchMusic extends BaseBean {
    public static final Parcelable.Creator<SearchMusic> CREATOR = new a();
    private String age;
    private String album;
    private String artist;
    private String genre;
    private String language;
    private String mode;
    private String module;
    private String mood;
    private String region;
    private String theme;
    private String title;
    private String type;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SearchMusic> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchMusic createFromParcel(Parcel parcel) {
            return new SearchMusic(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchMusic[] newArray(int i) {
            return new SearchMusic[i];
        }
    }

    public SearchMusic() {
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean
    public String getTitle() {
        return this.title;
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean
    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "SearchMusic{artist='" + this.artist + "', title='" + this.title + "', album='" + this.album + "', module='" + this.module + "', genre='" + this.genre + "', language='" + this.language + "', age='" + this.age + "', region='" + this.region + "', mood='" + this.mood + "', theme='" + this.theme + "', type='" + this.type + "', mode='" + this.mode + "'}";
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.artist);
        parcel.writeString(this.title);
        parcel.writeString(this.album);
        parcel.writeString(this.module);
        parcel.writeString(this.genre);
        parcel.writeString(this.language);
        parcel.writeString(this.age);
        parcel.writeString(this.region);
        parcel.writeString(this.mood);
        parcel.writeString(this.theme);
        parcel.writeString(this.type);
        parcel.writeString(this.mode);
    }

    protected SearchMusic(Parcel parcel) {
        super(parcel);
        this.artist = parcel.readString();
        this.title = parcel.readString();
        this.album = parcel.readString();
        this.module = parcel.readString();
        this.genre = parcel.readString();
        this.age = parcel.readString();
        this.region = parcel.readString();
        this.mood = parcel.readString();
        this.theme = parcel.readString();
        this.language = parcel.readString();
        this.type = parcel.readString();
        this.mode = parcel.readString();
    }
}
