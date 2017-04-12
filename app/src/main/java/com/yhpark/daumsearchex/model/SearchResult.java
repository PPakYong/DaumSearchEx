package com.yhpark.daumsearchex.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchResult implements Parcelable {
    @SerializedName("channel")
    public DetailResult channel;

//    @SerializedName("title")
//    String title; //검색 제목
//    @SerializedName("link")
//    String link; //서비스 URL
//    @SerializedName("description")
//    String description; //검색 결과의 간략한 소개
//    @SerializedName("lastBuildDate")
//    String lastBuildDate; //검색 시간
//    @SerializedName("totalCount")
//    int totalCount;    //전체 검색 결과의 수(추정치)
//    @SerializedName("pageCount")
//    int pageCount;    //보여줄 수 있는 문서의 수(추정치)
//
//    @SerializedName("result")
//    List<SearchDetailResult> result = new ArrayList<>();  //한 페이지에 출력될 결과수

    protected SearchResult(Parcel in) {
    }

    public static final Creator<SearchResult> CREATOR = new Creator<SearchResult>() {
        @Override
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        @Override
        public SearchResult[] newArray(int size) {
            return new SearchResult[size];
        }
    };

    public String toString() {
        return new Gson().toJson(channel).toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}

