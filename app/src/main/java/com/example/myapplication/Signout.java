package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_out);

        Button yes = (Button) findViewById(R.id.sign_out_yes);
        yes.setOnClickListener(new View.OnClickListener(){  //확인 버튼 클릭시...
            public void onClick(View v){

            }
        });
        Button no = (Button) findViewById(R.id.sign_out_no);
        no.setOnClickListener(new View.OnClickListener(){   //취소 버튼 클릭 시 내정보 화면으로 이동
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                Toast.makeText(Signout.this.getApplicationContext(), "취소하였습니다", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
