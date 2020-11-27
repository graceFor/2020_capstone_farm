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
public class Help extends Fragment {
    public static Help newInstance(){return new Help();}
    private View view;
    private ArrayList<HelpItem> dataList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.help, container,false);
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
        adapter = new HelpAdapter(getActivity(), dataList);
        recyclerView.setAdapter(adapter);

        Button button = (Button)view.findViewById(R.id.add_help);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2)getActivity()).replaceFragment(Help_write.newInstance(),null);
            }
        });


        return view;

    }

    public void InitializeData() {
        dataList = new ArrayList<HelpItem>();
        dataList.add(new HelpItem("김현경","상일텃밭 회원","54초 전","혹시 오늘 상일텃밭 가시는 회원 있으신가요? 제 텃밭에 물을 줘야하는데.. 지금 제가 가지 못해서요ㅠㅜㅠㅜ", 5, 4));
        dataList.add(new HelpItem("이지훈","상일텃밭 회원","10분 전","오늘 상일텃밭 도움 필요하신 분~ 저 오늘 물 주러 가는데 도움 필요하신 분 계신가요~^^?", 6,15));
        dataList.add(new HelpItem("정승환","강일텃밭 회원","10분 전","토요일에 텃밭 가서 고구마 수확하려고 하는데, 도와주실 분 계신가요~~ 다음에 저도 품앗이 하겠습니다!!", 12,11));
        dataList.add(new HelpItem("강대영","암사텃밭 회원","1시간 전","혹시 물뿌리개 있으신 분 계신가요?? 저 좀 빌려주실 분 찾아요~", 3,1));
        dataList.add(new HelpItem("유하은","강일텃밭 회원","1일 전","강일텃밭 회원이신 분들 중 토요일에 도움 필요하신 분 계신가요?", 6,3));
        dataList.add(new HelpItem("원지수","브로콜리 나눔","1일 전","혹시 고구마 모종 구하시는 분~ 많이 남아서 글 남겨요!", 6,12));




    }
}
