package com.yhpark.daumsearchex;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.yhpark.daumsearchex.adapters.SearchResultAdapter;
import com.yhpark.daumsearchex.presenter.SearchPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchPresenterImpl.ViewHandler {

    @BindView(R.id.navigation)
    public BottomNavigationView navigation;

    @BindView(R.id.rvResult)
    public RecyclerView rvResult;
    @BindView(R.id.etSearchKeyword)
    public EditText etSearchKeyword;
    @BindView(R.id.ibSearch)
    public ImageButton ibSearch;
    @BindView(R.id.llSearchBar)
    public LinearLayout llSearchBar;
    @BindView(R.id.container)
    LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SearchPresenterImpl.getInstance().setView(this);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                SearchPresenterImpl.getInstance().changeTab(item.getItemId());
                return true;
            }
        });
    }

    @Override
    public void showList(SearchResultAdapter adapter) {
        if (rvResult.getAdapter() == null) {
            rvResult.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @OnClick(R.id.ibSearch)
    public void onViewClicked() {
        SearchPresenterImpl.getInstance().searchImage(etSearchKeyword.getText().toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        SearchPresenterImpl.getInstance().onConfigurationChanged(newConfig);
    }
}
