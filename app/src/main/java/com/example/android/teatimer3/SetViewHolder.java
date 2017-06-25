package com.example.android.teatimer3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maksk on 6/25/2017.
 */

public class SetViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_name;
    public TextView txt_temp;
    public TextView txt_time;

    public SetViewHolder(View itemView) {
        super(itemView);
        txt_name = (TextView) itemView.findViewById(R.id.item_name);
        txt_temp = (TextView) itemView.findViewById(R.id.item_temp);
        txt_time = (TextView) itemView.findViewById(R.id.item_time);
    }
}
