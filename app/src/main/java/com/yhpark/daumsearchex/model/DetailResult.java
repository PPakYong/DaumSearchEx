package com.yhpark.daumsearchex.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by YongHyeon on 2017-04-12.
 */

public class DetailResult implements Parcelable {
    @SerializedName("title")
    public String title; //검색 제목
    @SerializedName("link")
    public String link; //서비스 URL
    @SerializedName("description")
    public String description; //검색 결과의 간략한 소개
    @SerializedName("lastBuildDate")
    public String lastBuildDate; //검색 시간
    @SerializedName("totalCount")
    public int totalCount;    //전체 검색 결과의 수(추정치)
    @SerializedName("pageCount")
    public int pageCount;    //보여줄 수 있는 문서의 수(추정치)
    @SerializedName("result")
    public int result;    //한 페이지에 출력될 결과수
    @SerializedName("item")
    public List<SearchDetailResult> item;  //한 페이지에 출력될 결과수

    protected DetailResult(Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();
        lastBuildDate = in.readString();
        totalCount = in.readInt();
        pageCount = in.readInt();
        result = in.readInt();
        item = in.createTypedArrayList(SearchDetailResult.CREATOR);
    }

    public static final Creator<DetailResult> CREATOR = new Creator<DetailResult>() {
        @Override
        public DetailResult createFromParcel(Parcel in) {
            return new DetailResult(in);
        }

        @Override
        public DetailResult[] newArray(int size) {
            return new DetailResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeString(description);
        parcel.writeString(lastBuildDate);
        parcel.writeInt(totalCount);
        parcel.writeInt(pageCount);
        parcel.writeInt(result);
        parcel.writeTypedList(item);
    }
}
