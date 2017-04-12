package com.yhpark.daumsearchex.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchDetailResult implements Parcelable {
    @SerializedName("item")
    public String item; //	개별 검색 결과 정보
    @SerializedName("title")
    public String title; //개별 검색 결과의 제목
    @SerializedName("link")
    public String link; //개별 검색 결과의 link url
    @SerializedName("image")
    public String image; //이미지 URL
    @SerializedName("thumbnail")
    public String thumbnail; //썸네일 URL
    @SerializedName("width")
    public String width; //이미지의 가로 크기
    @SerializedName("height")
    public String height; //이미지의 세로 크기
    @SerializedName("pubDate")
    public String pubDate; //등록일
    @SerializedName("cpname")
    public String cpname; //컨텐츠 제공처

    protected SearchDetailResult(Parcel in) {
        item = in.readString();
        title = in.readString();
        link = in.readString();
        image = in.readString();
        thumbnail = in.readString();
        width = in.readString();
        height = in.readString();
        pubDate = in.readString();
        cpname = in.readString();
    }

    public static final Creator<SearchDetailResult> CREATOR = new Creator<SearchDetailResult>() {
        @Override
        public SearchDetailResult createFromParcel(Parcel in) {
            return new SearchDetailResult(in);
        }

        @Override
        public SearchDetailResult[] newArray(int size) {
            return new SearchDetailResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(item);
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeString(image);
        parcel.writeString(thumbnail);
        parcel.writeString(width);
        parcel.writeString(height);
        parcel.writeString(pubDate);
        parcel.writeString(cpname);
    }
}
