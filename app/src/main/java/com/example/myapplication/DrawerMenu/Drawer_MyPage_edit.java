package com.example.myapplication.DrawerMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.Signout;

public class Drawer_MyPage_edit extends Fragment {
    private View view;
    Drawer_MyPage drawer_myPage = new Drawer_MyPage();

    public static Drawer_MyPage_edit newInstance(){
        return new Drawer_MyPage_edit();
    }
    EditText birth, phone_num, email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.drawer_mypage_edit,container,false);
        birth = view.findViewById(R.id.user_birthday);
        phone_num = view.findViewById(R.id.user_phone_number);
        email = view.findViewById(R.id.user_email);

        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        /*수정완료 클릭 시 수정완료 토스트와 함께 내정보 화면으로 이동*/
        TextView complete = (TextView)view.findViewById(R.id.complete_btn);
        complete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Bundle edit = new Bundle();
                edit.putString("Birth", birth.getText().toString());
                edit.putString("Phone_num", phone_num.getText().toString());
                edit.putString("Email",email.getText().toString());

                birth.setText(birth.getText().toString());
                phone_num.setText(phone_num.getText().toString());
                email.setText(email.getText().toString());
                drawer_myPage.setArguments(edit);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_frame, drawer_myPage);
                ft.commit();
            }
        });
        /*회원탈퇴 클릭 시 sign_out화면으로 이동*/
        TextView sign_out = (TextView)view.findViewById(R.id.sign_out);
        sign_out.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Signout.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
