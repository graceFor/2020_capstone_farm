package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class Main extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //토글버튼 객체 생성
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerToggle.syncState(); // 삼선 메뉴 만들기
        mDrawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
