package com.xiaopeng.speech.protocol.node.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.speech.common.bean.BaseBean;
/* loaded from: classes.dex */
public class MusicBean extends BaseBean {
    public static final Parcelable.Creator<MusicBean> CREATOR = new a();
    private String extData;
    private String keyWord;
    private int listed;
    private String metaDataList;
    private String metadata;
    private String page;
    private String params;
    private int searchType;
    private String source;
    private String tracks;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<MusicBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean createFromParcel(Parcel parcel) {
            return new MusicBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean[] newArray(int i) {
            return new MusicBean[i];
        }
    }

    public MusicBean() {
    }

    public String toString() {
        return "MusicBean{params='" + this.params + "', tracks='" + this.tracks + "', page='" + this.page + "', metadata='" + this.metadata + "', keyWord='" + this.keyWord + "', source='" + this.source + "', searchType=" + this.searchType + ", listed=" + this.listed + ", extData=" + this.extData + '}';
    }

    @Override // com.xiaopeng.speech.common.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.params);
        parcel.writeString(this.tracks);
        parcel.writeString(this.page);
        parcel.writeString(this.metadata);
        parcel.writeString(this.keyWord);
        parcel.writeString(this.source);
        parcel.writeInt(this.searchType);
        parcel.writeInt(this.listed);
        parcel.writeString(this.extData);
        parcel.writeString(this.metaDataList);
    }

    protected MusicBean(Parcel parcel) {
        super(parcel);
        this.params = parcel.readString();
        this.tracks = parcel.readString();
        this.page = parcel.readString();
        this.metadata = parcel.readString();
        this.keyWord = parcel.readString();
        this.source = parcel.readString();
        this.searchType = parcel.readInt();
        this.listed = parcel.readInt();
        this.extData = parcel.readString();
        this.metaDataList = parcel.readString();
    }
}
