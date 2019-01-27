package com.example.shoppinglist.ui.item_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.shoppinglist.R;
import com.example.shoppinglist.data.model.Item;
import com.example.shoppinglist.data.model.ItemFragment;
import com.example.shoppinglist.data.model.RecyclerViewAdapter;
import com.example.shoppinglist.data.model.dummy.DummyContent;
import com.example.shoppinglist.ui.item_list.presenter.IView;
import com.example.shoppinglist.ui.item_list.presenter.MainActivityPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvpActivity<IView, MainActivityPresenter> implements
        ItemFragment.OnListFragmentInteractionListener

{

    private ItemFragment.OnListFragmentInteractionListener listener;
    private List<Item> itemList;
    private RecyclerView recyclerView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initResources();
        initFAB();
        presenter.initPresenter(recyclerView, this, itemList, listener);
    }

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ItemClickListener(final Item item) {
        Log.d("TAG", "Checked item " + item.getId());
        Toast.makeText(this, "Checked item " + item.getId(), Toast.LENGTH_SHORT).show();
    }
    private void initResources(){
        listener = this;
        recyclerView = findViewById(R.id.item_recycler);
        itemList = presenter.creteItemList();
        checkBox = findViewById(R.id.item_checkbox);

    }

    private void initFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create new Item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
