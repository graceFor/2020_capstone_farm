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


import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.Where;

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
                Log.v("sdf", "main");
            }
        });

        return v;
    }

}
