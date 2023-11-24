package com.example.findmycarpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;

import com.mapbox.android.core.location.LocationEngineListener;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, LocationEngineListener, PermissionsListener   {
    private MapView mMap;
    private MapboxMap map;
    private PermissionsManager permissions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.token_mapbox));
        setContentView(R.layout.activity_map);
        mMap = (MapView) findViewById(R.id.mapView);
        mMap.onCreate(savedInstanceState);
    }
    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        map = mapboxMap;
        enableLocation();

    }
    private void enableLocation(){
        if (PermissionsManager.areLocationPermissionsGranted(this)){
            //TODO hay permisos
        }else {
            permissions = new PermissionsManager( this);
            permissions.requestLocationPermissions(this);
        }
    }
    public void onPermissionResult(boolean granted){
        if (granted){
            enableLocation();
        }
    }
    @Override
    public void onConnected() {

    }
    @Override
    public void onLocationChanged(Location location) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        mMap.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMap.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        mMap.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mMap.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMap.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMap.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissions.toString(requestCode, permissions, grantResults);
    }

    //  public void onRequestPermissionsResult(){

//    }


    }

