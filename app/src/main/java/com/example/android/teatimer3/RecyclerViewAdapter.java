package com.example.android.teatimer3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by maksk on 6/25/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Tea> items = Collections.emptyList();

    public RecyclerViewAdapter(Activity activity, List<Tea> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, int position) {
        holder.txt_name.setText(items.get(position).getName());
        holder.txt_temp.setText(items.get(position).getTemp());
        holder.txt_time.setText(items.get(position).getTime());
    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
