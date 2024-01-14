package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class LearnFragment extends Fragment implements View.OnClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        CardView amri, maelekezo, onyo, taarifa, usuli, traffic;

        amri = view.findViewById(R.id.option_a);
        onyo = view.findViewById(R.id.option_b);
        maelekezo = view.findViewById(R.id.option_c);
        taarifa = view.findViewById(R.id.option_d);
        usuli = view.findViewById(R.id.option_e);
        traffic = view.findViewById(R.id.option_f);

        amri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmriFragment amri1 = new AmriFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, amri1, "null").addToBackStack(null).commit();
            }
        });
        onyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnyoFragment onyo1 = new OnyoFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, onyo1, "null").addToBackStack(null).commit();
            }
        });

        maelekezo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaelekezoFragment maelekezo1 = new MaelekezoFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, maelekezo1, "null").addToBackStack(null).commit();
            }
        });

        taarifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaarifaFragment taarifa1 = new TaarifaFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, taarifa1, "null").addToBackStack(null).commit();
            }
        });

        usuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuliFragment usuli1 = new UsuliFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, usuli1, "null").addToBackStack(null).commit();
            }
        });

        traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AskariFragment traffic1 = new AskariFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, traffic1, "null").addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}