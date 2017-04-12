package com.yhpark.daumsearchex.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.yhpark.daumsearchex.R;
import com.yhpark.daumsearchex.model.SearchDetailResult;
import com.yhpark.daumsearchex.model.SearchResultHolder;
import com.yhpark.daumsearchex.presenter.SearchPresenterImpl;

import java.util.List;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultHolder> {
    private List<SearchDetailResult> item;
    boolean isStorageTab = false;

    public void setStorageTab(boolean storageTab) {
        isStorageTab = storageTab;
    }

    public List<SearchDetailResult> getItem() {
        return item;
    }

    public void setItem(List<SearchDetailResult> item) {
        this.item = item;
    }

//    public void addItem(SearchDetailResult newResult) {
//        item.add(newResult);
//    }

    public SearchResultAdapter(List<SearchDetailResult> item) {
        setItem(item);
    }

    @Override
    public SearchResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchResultHolder(LayoutInflater.from(SearchPresenterImpl.getInstance().getActivity()).inflate(R.layout.row_result, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchResultHolder holder, int position) {
        final SearchDetailResult currentResult = getItem().get(position);
        if (currentResult != null) {
            DrawableRequestBuilder<String> thumbnailRequest = Glide.with(SearchPresenterImpl.getInstance().getActivity()).load(currentResult.thumbnail);
            Glide.with(SearchPresenterImpl.getInstance().getActivity()).load(currentResult.image)
                    .fitCenter()
                    .thumbnail(thumbnailRequest)
                    .into(holder.ivResult);

            holder.tvTitle.setText(currentResult.title);
            holder.tvPubDate.setText(currentResult.pubDate);

            holder.ibSave.setVisibility(isStorageTab ? View.GONE : View.VISIBLE);
            holder.ibSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SearchPresenterImpl.getInstance().storageImage(currentResult);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
