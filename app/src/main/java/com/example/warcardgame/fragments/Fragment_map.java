package com.example.warcardgame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.warcardgame.R;
import com.example.warcardgame.objects.WinnerPlayer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment_map extends Fragment implements OnMapReadyCallback {
    public static final double AFEKA_LONGITUDE = 34.817816499999935;
    public static final double AFEKA_LATITUDE = 32.1133371;
    private View view;
    private GoogleMap map;
    private WinnerPlayer userPassed;
    private CameraPosition cameraPosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if(getContext() != null) {
            MapsInitializer.initialize(getContext());
            map = googleMap;
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.addMarker(new MarkerOptions().position(new LatLng(AFEKA_LATITUDE, AFEKA_LONGITUDE)).title(getString(R.string.location_title)));
            cameraPosition = CameraPosition.builder().target(new LatLng(AFEKA_LATITUDE, AFEKA_LONGITUDE)).zoom(16).bearing(0).tilt(45).build();
            map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }

    public void getGameUserInfo(WinnerPlayer winnerPlayer) {
        userPassed = winnerPlayer;
    }

    public void displayLocationOnMap(){
        if (userPassed != null) {
            map.addMarker(new MarkerOptions().position(new LatLng(userPassed.getLatitude(), userPassed.getLongitude())).title(userPassed.getPlayerName()));
            cameraPosition = CameraPosition.builder().target(new LatLng(userPassed.getLatitude(), userPassed.getLongitude())).zoom(16).bearing(0).tilt(45).build();
            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(new LatLng(userPassed.getLatitude(),userPassed.getLongitude()), 15);
            map.animateCamera(location);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapView mMapView = view.findViewById(R.id.map);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null; // now cleaning up!
    }
}
