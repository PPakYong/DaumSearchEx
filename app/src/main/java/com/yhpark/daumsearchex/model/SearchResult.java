package com.yhpark.daumsearchex.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchResult {
    @SerializedName("title")
    String title; //검색 제목
    @SerializedName("link")
    String link; //서비스 URL
    @SerializedName("description")
    String description; //검색 결과의 간략한 소개
    @SerializedName("lastBuildDate")
    String lastBuildDate; //검색 시간
    @SerializedName("totalCount")
    int totalCount;    //전체 검색 결과의 수(추정치)
    @SerializedName("pageCount")
    int pageCount;    //보여줄 수 있는 문서의 수(추정치)

    @SerializedName("result")
    List<SearchDetailResult> result = new ArrayList<>();  //한 페이지에 출력될 결과수
}
