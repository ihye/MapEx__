package com.cookandroid.mapex__;

import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback {
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnetcionFailedListener

    {


        private GoogleMap mMap;
        private GoogleApiClient mGoogleApiClient;

        //위치 정보 얻는 객체
        private FusedLocationProviderClient mFusedLocationClient;


        //권한 체크 요청 코드 정의
        public static final int REQUEST_CODE_PERMISSIONS = 1000;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);


        //GoogleAPIClient 의 인스턴스 생성
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(context:this)
                        .addOnConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(LocationServices.API)
                    .build();
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(onMapReadyCallback:this);


        //현재 사용자 위치 표시 (수동)

        findViewById(R.id.b_mapmode)
    }



        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity.this);

        ToggleButton b_mapMode = findViewById(R.id.b_mapmode);
        b_mapMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()){
        @Override
        public void onCheckedChanged(CompoundButtonbuttonView, boolean isChecked){
            if (isChecked)
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            else
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    });
    }


    @Override
    protected void onStart () {
        mGoogleApiClient.connect();
        super.onStart();





        ToggleButton b_showCurPos = findViewById(R.id.b_showCurPos);
        b_showCurPos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChange(CompoundButton buttonView, boolean isChecked){
                //권한 체크
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                        !=PackageManger.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                ! = PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions( activity: this,
                            new String() { Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION),
                                REQUEST_CODE_PERMISSIONS);
                return;
                )


               mMap.setMyLocationEnabled(isChecked);

            }
          });
        }



        @Override
        protected void onStart(){
        mGoogleApiClient.connect();
        super.onStart();
        }

        @Override
        protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();

        }





        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap){
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
          //마커 추가
            LatLng kb = new LatLng(37.579770, 126.977020);
            mMap.addMarker(new MarkerOptions().position(kb).title("경복궁"));

            //카메라 이동
            mMap.moveCamera(CameraUpdateFactory.newLatLng(kb));

            //카메라 줌인 (2.0f ~21.0F)
            mMap.animateCamera(CameraUpdateFactory.zoomTo(v:17:0f));

            //*/
                ////////////////////////////////
                // 마커 텍스트 클릭 이벤트
            mMap.setOnInfoWindowdClickListener {
                (new GoogleMap, OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick (Marker marker){
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parese("tel:02-999-1234"));

                            startActivity(intent);
                        }
                });

                //*/

            /////////////////////////////////////////////
            // 보기 설정
            UiSettings ui = mMap.getUiSettings();


             // 줌 컨트롤
            ui.setZoomControlsEnabled(true);
             // 나침반 표시 여부
            ui.setCompassEnabled(false);
             // 현재 나의 위치 표시 버튼 활성화 여부
            ui.setMyLocationButtonEnabled(false);

            //각종 제스처
            ui.setScrollGesturesEnabled(false);
            ui.setZoomGestureEnabled(false);
            ui.setRotateGesturesEnabled(false);
            ui.setTiltGesturesEnabled(false);

            ui.setAllGesturesEnabled(true);


            mMap.setOnMapClickListener(new GoogleMap.onMapClickListener() {
                @Override
                public void onMapClick (LatLnglatLng) {
                    MarkerOptions marker = new MarkerOptions()
                            .center(latLng)
                            .radius(100)
                            .strokeColor(Color.BLUE)
                            .strokeWidth(1.0f)
                            .fillColor(Color.parseColor(colorString:"#220000FF"));
                    mMap.addCircle(circle);


                }
            });

            }


            @Override
            public void onConnected (@Nullable Bundle bundle){
            }
            @Override
            public void onConnectionSuspended (int i){
            }
            @Override
           public void onConnectionFailed (@NonNull ConnectionResult connectionResult){


        }
            public void mCurrentLocation(View v){


           //권한 체크
            if (ActivityCompat.checkSelfPermission(context: this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                 !=PackageManger.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(context:this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    ! = PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(  activity: this,
                    new String[] { Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),
                REQUEST_CODE_PERMISSIONS);
                return;
                    }



                        mFusedLocationClient.getLastLocation().addOnSuccessListener( activity:this,
                                new OnSuccessListener<Location>(){
                                    @Override
                                    public void onSuccess(Location location) {
                                        if (location ! = null){
                                            //현재 위치
                                            LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                            mMap.addMarker(new MarkerOptions()
                                                    .position(myLocation)
                                                    .title("현재 위치"));

                                            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));

                                            //카메라 줌
                                            mMap.animateCamera(CameraUpdateFactory.zoomTo(v:17.0f));
                                        }

                                    }
                                });


                   }

        @Override

                public voidonPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int
                   super.onRequestPermissionResult(requestCode, permissions, grantResults);



                switch (requestCode) {
                    case REQUEST_CODE_PERMISSIONS:
                        if (ActivityCompat.checkSelfPermission(context:this,
                        android.Manifiest.permission.ACCESS_FINE_LOCATION) ! = PackageManager,PERMISSION_GRANTED&&
                            ActivityCompat.checkSelfPermission(context:this,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION) ! = PackageManager.PERMISSION_GRANTED){
                                Toast.makeText(context: this, text = "권한 체크 거부 됨", Toast.LENTH_SHORT).show();
                }
                return;

            }
        }



