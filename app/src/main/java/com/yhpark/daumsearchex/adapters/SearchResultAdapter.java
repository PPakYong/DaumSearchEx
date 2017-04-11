package com.yhpark.daumsearchex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yhpark.daumsearchex.R;
import com.yhpark.daumsearchex.model.SearchDetailResult;
import com.yhpark.daumsearchex.model.SearchResultHolder;

import java.util.List;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultHolder> {
    Context context;
    List<SearchDetailResult> item;

    public SearchResultAdapter(Context context, List<SearchDetailResult> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public SearchResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchResultHolder(LayoutInflater.from(context).inflate(R.layout.row_result, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchResultHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
