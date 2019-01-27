package com.example.shoppinglist.ui.item_list.presenter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shoppinglist.data.model.Item;
import com.example.shoppinglist.data.model.ItemFragment;
import com.example.shoppinglist.data.model.RecyclerViewAdapter;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter extends MvpBasePresenter<IView>{


    public List<Item> creteItemList(){
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i <= 25; i ++)
            itemList.add(new Item(i, "name " + i + "s", "content " + i));
        return itemList;
    }

    public void initPresenter(RecyclerView recyclerView, Context context, List<Item> itemList,
                              ItemFragment.OnListFragmentInteractionListener listener){
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemList, listener);
        recyclerView.setAdapter(adapter);
    }


}
