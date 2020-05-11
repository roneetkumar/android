package com.example.finalexam2020roneetkumar.model;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalexam2020roneetkumar.R;

//RONEET KUMAR

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Client extends android.app.Fragment {

    public Fragment_Client() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__client, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView name,total, subTotal, clientType;

        name = getActivity().findViewById(R.id.name);
        total = getActivity().findViewById(R.id.total);
        subTotal = getActivity().findViewById(R.id.subTotal);
        clientType = getActivity().findViewById(R.id.clientType);

        Client client = (Client) getArguments().getSerializable("client");

        name.setText(client.getName());
        total.setText(client.getTotal().toString());
        subTotal.setText(client.getSubTotal().toString());
        clientType.setText(client.getClientType());
    }
}
