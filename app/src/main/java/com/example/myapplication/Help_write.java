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
import androidx.fragment.app.FragmentManager;

public class Help_write extends Fragment {
    public static Help_write newInstance(){return new Help_write();}
    private View view;
    Button end;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.help_write, container,false);
        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        end = view.findViewById(R.id.end);

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ((MainActivity2)getActivity()).replaceFragment(Help.newInstance(),null);
            }
        });
        return view;

    }
}
