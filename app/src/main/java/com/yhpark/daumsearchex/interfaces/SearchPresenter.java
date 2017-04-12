package com.yhpark.daumsearchex.interfaces;

import com.yhpark.daumsearchex.MainActivity;
import com.yhpark.daumsearchex.adapters.SearchResultAdapter;
import com.yhpark.daumsearchex.model.SearchDetailResult;

/**
 * Created by ppyh0 on 2017-04-12.
 */

public interface SearchPresenter {
    public void setView(MainActivity activity);
    public void searchImage(String keyword);
    public void storageImage(SearchDetailResult result);
    public void changeTab(int menuId);

    public interface ViewHandler {
        void showList(SearchResultAdapter adapter);
    }
}
