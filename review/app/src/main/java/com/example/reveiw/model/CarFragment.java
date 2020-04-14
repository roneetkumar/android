package com.example.reveiw.model;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.reveiw.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CarFragment extends android.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Car car = (Car) getArguments().getSerializable("car");

        TextView id = getActivity().findViewById(R.id.id);
        TextView brand = getActivity().findViewById(R.id.brand);
        TextView model = getActivity().findViewById(R.id.model);
        TextView price = getActivity().findViewById(R.id.price);
        TextView year = getActivity().findViewById(R.id.year);

        id.setText(car.getId());
        brand.setText(car.getBrand());
        model.setText(car.getModel());
        price.setText(car.getPrice().toString());
        year.setText(car.getYear().toString());

        Log.d(TAG, "onActivityCreated: " + id.getText());
    }
}
