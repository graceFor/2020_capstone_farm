package com.example.myapplication;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class Where extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    private Button button;
    private String strs;
    private EditText editText;
    private View view;
    private String ga = "강일텃밭";
    private String il = "일자산텃밭";

    public static Where newInstance(){return new Where();}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.where, container, false);
        super.onCreate(savedInstanceState);
        button=(Button)view.findViewById(R.id.button);
        //상단 툴바 설정
        Toolbar sub_toolbar = (Toolbar)view.findViewById(R.id.sub_toolbar);
        ((MainActivity2)getActivity()).setSupportActionBar(sub_toolbar);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity2)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);


        String[] str = getResources().getStringArray(R.array.spinnerArray);
        final ArrayAdapter adapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_item, str);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        final Spinner spinner = (Spinner)view.findViewById(R.id.spinner_field);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strs= (String)spinner.getSelectedItem();

                Log.i("i", "Spinner selected item = "+strs);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(getContext());

        // 맵 터치 이벤트 구현 //
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions mOptions = new MarkerOptions();
                // 마커 타이틀
                mOptions.title("마커 좌표");
                Double latitude = point.latitude; // 위도
                Double longitude = point.longitude; // 경도
                // 마커의 스니펫(간단한 텍스트) 설정
                mOptions.snippet(latitude.toString() + ", " + longitude.toString());
                // LatLng: 위도 경도 쌍을 나타냄
                mOptions.position(new LatLng(latitude, longitude));
                // 마커(핀) 추가
                googleMap.addMarker(mOptions);
            }
        });

        ////////////////////

        // 버튼 이벤트
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
//                String str=editText.getText().toString();
                Log.i("i", "item = "+strs);
                List<Address> addressList = null;
                try {
                    // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                    addressList = geocoder.getFromLocationName(
                            strs, // 주소
                            10); // 최대 검색 결과 개수
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(addressList.get(0).toString());
                // 콤마를 기준으로 split
                String []splitStr = addressList.get(0).toString().split(",");
                String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2); // 주소
                System.out.println(address);

                String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
                String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도
                System.out.println(latitude);
                System.out.println(longitude);

                // 좌표(위도, 경도) 생성
                LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                // 마커 생성
                MarkerOptions mOptions2 = new MarkerOptions();
                mOptions2.title(strs);
                mOptions2.snippet(address);
                mOptions2.position(point);
                // 마커 추가
                mMap.addMarker(mOptions2);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,14));
                mMap.setOnMarkerClickListener(markerClickListener);
                // 해당 좌표로 화면 줌


            }
            GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Log.d("d", marker.getTitle());
                    if( (marker.getTitle()).equals(ga)){
                        ((MainActivity2)getActivity()).replaceFragment(Where_Detail.newInstance(),null);
                    }
                    else if((marker.getTitle()).equals(il)){
                        ((MainActivity2)getActivity()).replaceFragment(Where_Detail_1.newInstance(),null);}

                    return false;

                }
            };
        });

        ////////////////////

        // Add a marker in Sydney and move the camera
        LatLng gangdon = new LatLng(37.54973325023804, 127.14698369875);
        mMap.addMarker(new MarkerOptions().position(gangdon).title("서울시 강동구"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gangdon,12));
    }

}
