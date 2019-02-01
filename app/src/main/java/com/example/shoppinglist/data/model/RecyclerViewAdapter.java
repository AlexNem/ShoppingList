package com.example.shoppinglist.data.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.shoppinglist.R;
import com.example.shoppinglist.data.model.ItemFragment.OnListFragmentInteractionListener;
import com.example.shoppinglist.data.room.Item;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Item> itemList;
    private final OnListFragmentInteractionListener mListener;

    public RecyclerViewAdapter(List<Item> items, OnListFragmentInteractionListener listener) {
        itemList = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = itemList.get(position);
        holder.mIdView.setText(itemList.get(position).getName());
        holder.mContentView.setText(itemList.get(position).getContent());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mListener.ItemCheckListener(holder.mItem);
            }
        });
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.ItemAddListener(holder.mItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final CheckBox checkBox;
        private final Button btnAdd;
        private final TextView mIdView;
        private final TextView mContentView;
        private Item mItem;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            checkBox = view.findViewById(R.id.item_checkbox);
            btnAdd = view.findViewById(R.id.btn_add);
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
