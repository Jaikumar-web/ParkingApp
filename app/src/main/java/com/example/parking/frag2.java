package com.example.parking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class frag2 extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    MapView mapView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = view.findViewById(R.id.mapView);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map = googleMap;
        LatLng ConnaughtPlace = new LatLng(28.631274812109524, 77.21515815486947);
        LatLng RKAshram = new LatLng(28.637640464022933, 77.21090953603719);
        LatLng Birla_Mandir = new LatLng(28.632348336690132, 77.1988074096666);
        map.addMarker(new MarkerOptions().position(Birla_Mandir).title("Birla_Mandir Parking")
                .icon(BitmapFromVector(getContext(),R.drawable.ic_baseline_my_location_24)));
        map.addMarker(new MarkerOptions().position(RKAshram).title("RK Ashram Parking")
                .icon(BitmapFromVector(getContext(),R.drawable.ic_baseline_my_location_24)));
        map.addMarker(new MarkerOptions().position(ConnaughtPlace).title("Connaught Place Parking")
                .icon(BitmapFromVector(getContext(),R.drawable.ic_baseline_my_location_24)));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(ConnaughtPlace,15F));


    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {

        // Line that use to generate drawable
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        vectorDrawable.setBounds(2, 2, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);


    }
}