package com.yhpark.daumsearchex.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.yhpark.daumsearchex.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ppyh0 on 2017-04-11.
 */

public class SearchResultHolder extends RecyclerView.ViewHolder {

    private View itemView;

    public View getItemView() {
        return itemView;
    }

    @BindView(R.id.ivResult)
    public ImageView ivResult;
    @BindView(R.id.tvTitle)
    public TextView tvTitle;
    @BindView(R.id.tvPubDate)
    public TextView tvPubDate;
    @BindView(R.id.ibSave)
    public ImageButton ibSave;

    public SearchResultHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }
}
