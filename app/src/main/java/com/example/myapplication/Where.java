package com.example.myapplication;

// 어디있을까?

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Where extends Fragment {
    ArrayAdapter arrayAdapter;
    private View view;
    public static Where newInstance(){return new Where();}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.where, container, false);
        Log.v("dfsfs","1");
        //상단 툴바 설정
        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        Log.v("dfsfs","2");
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        Log.v("dfsfs","3");
       // ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.v("dfsfs","4");
       // ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
//        //Spinner객체 생성
      // final Spinner spinner_field = (Spinner)view.findViewById(R.id.spinner_field);
//        //1번에서 생성한 field.xml의 item을 String 배열로 가져오기
//        String[] str = getResources().getStringArray(R.array.spinnerArray);
//        //2번에서 생성한 spinner_item.xml과 str을 인자로 어댑터 생성.
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, str);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner_field.setAdapter(adapter);
//        //spinner 이벤트 리스너
//        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (spinner_field.getSelectedItemPosition() > 0) {
//                    //선택된 항목
//                    Log.v("알림", spinner_field.getSelectedItem().toString() + "is selected");
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
        String[] str = getResources().getStringArray(R.array.spinnerArray);
        ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, str);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner = (Spinner)view.findViewById(R.id.spinner_field);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("d","selected");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}