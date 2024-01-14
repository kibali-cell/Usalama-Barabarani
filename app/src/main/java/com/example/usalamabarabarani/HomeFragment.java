package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView learn, jihami, questions, lijueGari;
        Button learnBtn;

        learn = view.findViewById(R.id.parent);
        jihami = view.findViewById(R.id.kujihami);
        questions = view.findViewById(R.id.maswaliCard);
        lijueGari = view.findViewById(R.id.juaGariCard);
        learnBtn = view.findViewById(R.id.jifunzeBtn);

        learnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearnFragment learn2 = new LearnFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, learn2, "null").addToBackStack(null).commit();
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearnFragment learn1 = new LearnFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, learn1, "null").addToBackStack(null).commit();
            }
        });

        jihami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UderevaKujihamiFragment jihami1 = new UderevaKujihamiFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, jihami1, "null").addToBackStack(null).commit();

            }
        });

        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QnsFragment question1 = new QnsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, question1, "null").addToBackStack(null).commit();

                BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView);
                bottomNavigationView.setSelectedItemId(R.id.questions);
            }
        });

        lijueGari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LijueGariFragment lijueGari1 = new LijueGariFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, lijueGari1, "null").addToBackStack(null).commit();
            }
        });



        return view;

    }

    @Override
    public void onClick(View v) {

    }
}