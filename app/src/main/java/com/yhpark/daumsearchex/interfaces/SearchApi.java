package com.yhpark.daumsearchex.interfaces;

import com.yhpark.daumsearchex.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public interface SearchApi {
    /**
     * @param apikey daumkakao application api key
     * @param q 검색을 원하는 질의어
     * @param result 한 페이지에 출력될 결과수
     * @param advance 상세 검색 기능 사용 여부
     * @param pageno 검색 결과 페이지 번호
     * @param sort 검색 결과의 정렬 순서
     * @param output 포맷
     * @return
     */
    @GET("/search/image")
    Call<SearchResult> getImageSearchResult(
            @Query("apikey") String apikey,
            @Query("q") String q,
            @Query("result") int result,
            @Query("advance") String advance,
            @Query("pageno") int pageno,
            @Query("sort") String sort,
            @Query("output") String output
    );
}
