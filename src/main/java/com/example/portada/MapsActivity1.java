package com.example.portada;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button bNormal, bSatelital, bTerreno, bHibrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        bNormal = findViewById(R.id.btnNormal);
        bHibrido = findViewById(R.id.btnHibrido);
        bSatelital = findViewById(R.id.btnSatelital);
        bTerreno = findViewById(R.id.btnTerreno);

    }

    public void cambiarHibrido(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void cambiarNormal(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void cambiarTerreno(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void cambiarSatelital(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng localizacion = new LatLng(43.3042072, -2.0165072222222222);
        mMap.addMarker(new MarkerOptions().position(localizacion).title("Sede en Donostia de Greenphone").snippet("Las oficinas de Greenphone en la ciudad de San Sebastián").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacion, 7));

        mMap.getUiSettings().setZoomControlsEnabled(true); //Para los controles del zoom
    }
}
