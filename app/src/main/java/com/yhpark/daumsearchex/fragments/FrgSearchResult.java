package com.yhpark.daumsearchex.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.yhpark.daumsearchex.Constants;
import com.yhpark.daumsearchex.R;
import com.yhpark.daumsearchex.interfaces.SearchApi;
import com.yhpark.daumsearchex.model.SearchResult;
import com.yhpark.daumsearchex.retrofit.RetrofitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class FrgSearchResult extends Fragment implements Callback<SearchResult> {
    @BindView(R.id.rvResult)
    RecyclerView rvResult;
    @BindView(R.id.etSearchKeyword)
    EditText etSearchKeyword;
    @BindView(R.id.ibSearch)
    ImageButton ibSearch;
    @BindView(R.id.llSearchBar)
    LinearLayout llSearchBar;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frg_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ibSearch)
    public void onViewClicked() {
        SearchApi searchApi = new RetrofitClient<SearchApi>().getClient(SearchApi.class);
        searchApi.getImageSearchResult(
                Constants.API_KEY,
                etSearchKeyword.getText().toString(),
                20,
                "n",
                1,
                Constants.SORT_DATE,
                Constants.OUTPUT_TO_JSON
        ).enqueue(this);
    }

    @Override
    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
        if (response.isSuccessful()) {
            Log.i(getClass().getSimpleName(), "onResponse");
        } else {

        }
    }

    @Override
    public void onFailure(Call<SearchResult> call, Throwable t) {

    }
}
