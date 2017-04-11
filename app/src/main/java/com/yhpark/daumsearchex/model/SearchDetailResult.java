package com.yhpark.daumsearchex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchDetailResult {
    @SerializedName("item")
    String item; //	개별 검색 결과 정보
    @SerializedName("title")
    String title; //개별 검색 결과의 제목
    @SerializedName("link")
    String link; //개별 검색 결과의 link url
    @SerializedName("image")
    String image; //이미지 URL
    @SerializedName("thumbnail")
    String thumbnail; //썸네일 URL
    @SerializedName("width")
    String width; //이미지의 가로 크기
    @SerializedName("height")
    String height; //이미지의 세로 크기
    @SerializedName("pubDate")
    String pubDate; //등록일
    @SerializedName("cpname")
    String cpname; //컨텐츠 제공처
}
