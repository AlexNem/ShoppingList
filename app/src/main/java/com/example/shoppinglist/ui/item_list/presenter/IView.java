package com.example.shoppinglist.ui.item_list.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IView extends MvpView{

    void createItem();
    void checkItem();
    void addToBox();

}
