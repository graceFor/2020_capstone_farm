package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class Help_start extends Fragment {
    public static Help_start newInstance(){return new Help_start();}
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.help_start,container,false);
        Button help_start = (Button)view.findViewById(R.id.help_start);

        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        help_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Help.newInstance(),null);
            }
        });


        return view;
    }
}
