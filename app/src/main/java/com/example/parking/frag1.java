package com.example.parking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class frag1 extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        // CardView CarsBooking =(CardView)view.findViewById(R.id.Carbook);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        CardView CarBook =  getActivity().findViewById(R.id.Carbook);
//        CarBook .setOnClickListener((View.OnClickListener)this);

        Button Parking = getActivity().findViewById(R.id.park);
        Parking.setOnClickListener((View.OnClickListener)this);

    }


    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(),CarBooking.class);
//        startActivity(intent);
        Intent intent = new Intent(getActivity(),MainParking.class);
        startActivity(intent);

    }
}