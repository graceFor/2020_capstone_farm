package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.DrawerMenu.Drawer_MyPage;
import com.example.myapplication.DrawerMenu.Drawer_MyPage_edit;
import com.example.myapplication.DrawerMenu.Main;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle drawerToggle;
    public static FragmentManager fm;
    public static FragmentTransaction ft;
    Main main  = new Main();
    Where where  = new Where();
    Drawer_MyPage mypage = new Drawer_MyPage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //토글버튼 객체 생성
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerToggle.syncState(); // 삼선 메뉴 만들기
        mDrawerLayout.addDrawerListener(drawerToggle);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //기본 화면을 홈 화면으로 해줌
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.main_frame,main);
        ft.commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                String frag = item.toString();
                Log.d("TAG", "현재 프래그먼트" + frag);
                switch (item.getItemId()) {
                    case R.id.mypage:
                        ft.replace(R.id.main_frame, mypage);
                        break;
                }
                ft.addToBackStack(null);
                ft.commit();
                return true;
            }
        });
   }

    //프래그먼트 끼리의 화면 전환을 함
    public void replaceFragment(Fragment fragment, Bundle msg){
        fragment.setArguments(msg);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.main_frame,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    //프래그먼트에서 뒤로가기 버튼을 눌렀을 때 실행
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
