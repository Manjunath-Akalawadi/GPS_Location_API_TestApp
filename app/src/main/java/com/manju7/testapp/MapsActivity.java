package com.manju7.testapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String latString , longiString , demo , name;
    double lat , longi;
    String[] temp;
    private static final String TAG = "MapsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent=getIntent();
        name=intent.getExtras().getString("name");
        String coordinates=intent.getExtras().getString("coordinates");


        String result = coordinates.replaceAll("\\[", "").replaceAll("\\]","");
        temp = result.split(",");
        latString = temp[0];
        longiString = temp[1];
        demo = temp[2];

        lat = Double.parseDouble(latString);
        longi = Double.parseDouble(longiString);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng car = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(car).title("Car Name "+name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(car));
    }
}
