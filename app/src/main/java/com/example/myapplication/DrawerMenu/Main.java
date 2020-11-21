package com.example.myapplication.DrawerMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.myapplication.Guide_start;
import com.example.myapplication.Help_start;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.Many_start;
import com.example.myapplication.Shop;
import com.example.myapplication.Where;
import com.example.myapplication.R;

public class Main extends Fragment {
    public static Main newInstance(){return new Main();}
    private ImageView[] imageView = new ImageView[5];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main, container, false);
        imageView[0] = v.findViewById(R.id.where); // ID 설정을 합니다
        imageView[1] = v.findViewById(R.id.guide);
        imageView[2] = v.findViewById(R.id.many);
        imageView[3] = v.findViewById(R.id.help);
        imageView[4] = v.findViewById(R.id.shop);

        imageView[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Where.newInstance(),null);
                Log.v("1", "main");
            }
        });
        imageView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Guide_start.newInstance(),null);
                Log.v("2", "guide");
            }
        });
        imageView[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Many_start.newInstance(),null);
                Log.v("3", "many");
            }
        });
        imageView[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Help_start.newInstance(),null);
                Log.v("4", "many");
            }
        });
        imageView[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Shop.newInstance(),null);
                Log.v("5", "shop");
            }
        });


        return v;
    }

}
