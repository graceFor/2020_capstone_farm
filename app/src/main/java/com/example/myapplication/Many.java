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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// 다잇다 (물물교환)
public class Many extends Fragment {
    public static Many newInstance(){return new Many();}
    private View view;
    private ArrayList<ManyItem> dataList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.many, container,false);
        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.InitializeData();

        recyclerView  = (RecyclerView)view.findViewById(R.id.recyclerview_account_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager); // LayoutManager 등록
        adapter = new ManyAdapter(getActivity(), dataList);
        recyclerView.setAdapter(adapter);

        Button button = (Button)view.findViewById(R.id.add_many);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Many_write.newInstance(),null);
            }
        });


        return view;

    }

    public void InitializeData() {
        dataList = new ArrayList<ManyItem>();
        dataList.add(new ManyItem(R.drawable.union,"양파 나눔해요~","54초 전",5, 34));
        dataList.add(new ManyItem(R.drawable.o1,"가지 다잇다 하실 분","10분 전",13, 25));
        dataList.add(new ManyItem(R.drawable.pot,"감자 나눔해요!","10분 전",13, 25));
        dataList.add(new ManyItem(R.drawable.pp34,"처음 키워본 토마토","1시간 전",45, 134));
        dataList.add(new ManyItem(R.drawable.po,"유기농 자색고구마","1일 전",5, 34));
        dataList.add(new ManyItem(R.drawable.b1,"브로콜리 나눔","1일 전",13, 25));




    }
}
