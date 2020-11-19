package com.example.myapplication.DrawerMenu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.Signout;

public class Drawer_MyPage extends Fragment {

    private View view;
    public static Drawer_MyPage newInstance(){
        return new Drawer_MyPage();
    }
    TextView birth, phone_num, email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.drawer_mypage,container,false);

        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        /*수정 버튼 클릭 시 비밀번호를 확인하고 수정화면으로 이동*/
        TextView edit = (TextView)view.findViewById(R.id.edit_btn);
        edit.setOnClickListener(new View.OnClickListener(){ //수정 버튼 클릭 시 AlertDialog 띄워 비밀번호 입력받음
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getContext().getApplicationContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("비밀번호를 입력하세요");
                builder.setView(editText);
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {    //일단 성공했다고 가정하고, 입력받은 pw출력 후 수정 페이지로 넘어감

        //                ((MainActivity2)getActivity()).replaceFragment(Drawer_MyPage_edit.newInstance(),null);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        birth = view.findViewById(R.id.user_birthday);
        phone_num = view.findViewById(R.id.user_phone_number);
        email = view.findViewById(R.id.user_email);
        if(getArguments() != null){
            birth.setText(getArguments().getString("Birth"));
            phone_num.setText(getArguments().getString("Phone_num"));
            email.setText(getArguments().getString("Email"));
        }
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
