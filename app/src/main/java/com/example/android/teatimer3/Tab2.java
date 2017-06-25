package com.example.android.teatimer3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by maksk on 5/28/2017.
 */

public class Tab2 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab2,container, false);
        Button newPage = (Button)v.findViewById(R.id.click);
        newPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewTea.class);
                startActivity(intent);
            }
        });
        return v;
    }
}