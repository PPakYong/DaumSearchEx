package com.yhpark.daumsearchex.presenter;

import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.yhpark.daumsearchex.Constants;
import com.yhpark.daumsearchex.MainActivity;
import com.yhpark.daumsearchex.R;
import com.yhpark.daumsearchex.adapters.SearchResultAdapter;
import com.yhpark.daumsearchex.interfaces.SearchApi;
import com.yhpark.daumsearchex.interfaces.SearchPresenter;
import com.yhpark.daumsearchex.model.DetailResult;
import com.yhpark.daumsearchex.model.SearchDetailResult;
import com.yhpark.daumsearchex.model.SearchResult;
import com.yhpark.daumsearchex.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by YongHyeon on 2017-04-12.
 */

public class SearchPresenterImpl implements SearchPresenter, Callback<SearchResult> {
    //Singleton -S
    private static final SearchPresenterImpl ourInstance = new SearchPresenterImpl();

    public static SearchPresenterImpl getInstance() {
        return ourInstance;
    }
    //Singleton -E

    MainActivity activity;
    SearchPresenter.ViewHandler view;

    @Override
    public void setView(MainActivity activity) {
        this.activity = activity;
        this.view = activity;
    }

    /**
     * 검색 결과를 담아둔다
     */
    DetailResult searchResult;

    public void setSearchResult(DetailResult searchResult) {
        this.searchResult = searchResult;
    }

    /**
     * 선택한 item list만을 담아둔다
     */
    List<SearchDetailResult> storageList = new ArrayList<>();

    /**
     * RecyclerView Adapter
     */
    SearchResultAdapter adapter;

    @Override
    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
        Log.i(getClass().getSimpleName(), "onResponse");
        if (activity != null) {
            if (response.isSuccessful()) {
                Log.i(getClass().getSimpleName(), "response.isSuccessful");
                SearchPresenterImpl.getInstance().setSearchResult(response.body().channel);

                if (activity.rvResult.getLayoutManager() == null) {
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(activity);
                    activity.rvResult.setLayoutManager(manager);
                }

                if (adapter == null) {
                    adapter = new SearchResultAdapter(response.body().channel.item);
                } else {
                    adapter.setItem(response.body().channel.item);
                }
                view.showList(adapter);
            } else {
                Toast.makeText(activity, "response code : " + response.code(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.i(getClass().getSimpleName(), "onFailure");
        if (activity != null && t != null) {
            Toast.makeText(activity, "retrofit request is fail by : " + t.getCause(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void searchImage(String keyword) {
        if (!"".equals(keyword)) {
            Map<String, String> data = new HashMap<>();
            data.put("output", Constants.OUTPUT_TO_JSON);
            SearchApi searchApi = new RetrofitClient<SearchApi>().getClient(SearchApi.class);
            searchApi.getImageSearchResult(
                    Constants.API_KEY,
                    keyword,
                    data
            ).enqueue(this);
        } else {
            if (activity != null) {
                Toast.makeText(activity, "keyword is empty.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void storageImage(SearchDetailResult result) {
        if (activity != null) {
            if (storageList.contains(result)) {
                Toast.makeText(activity, "item (" + result.title + ") is already saved.", Toast.LENGTH_SHORT).show();
            } else {
                storageList.add(result);
                Toast.makeText(activity, "item (" + result.title + ") is saved.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void changeTab(int menuId) {
        if (adapter != null && activity != null) {
            switch (menuId) {
                case R.id.navi_search:
                    adapter.setItem(searchResult.item);
                    activity.llSearchBar.setVisibility(VISIBLE);
                    break;
                case R.id.navi_storage:
                    adapter.setItem(storageList);
                    activity.llSearchBar.setVisibility(GONE);
                    break;
            }

            view.showList(adapter);
        }
    }

    public MainActivity getActivity() {
        return activity;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (view != null && adapter != null) {
            view.showList(adapter);
        }
    }
}
