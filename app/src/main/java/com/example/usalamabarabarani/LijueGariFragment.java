package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentAmriBinding;
import com.example.usalamabarabarani.databinding.FragmentLijueGariBinding;

import java.util.ArrayList;


public class LijueGariFragment extends Fragment {

    private FragmentLijueGariBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLijueGariBinding.inflate(inflater, container, false);
        View view = binding.getRoot(); // Get the root view from the binding

        int[] imageId = {R.drawable.enginetemperature, R.drawable.oilpressure, R.drawable.engine, R.drawable.pressuremonitoring,
        R.drawable.brakesystem, R.drawable.abslight, R.drawable.stability, R.drawable.transmission, R.drawable.battery, R.drawable.airbag, R.drawable.lowfuel, R.drawable.doors };
        String[] title = {"Temperature Warning", "Oil Pressure", "Check Engine", "Tire Pressure", "Brake System", "ABS Warning", "Electronic Stability Control",
        "Transmission Temperature", "Battery Warning", "Airbag Warning", "Low Fuel", "Door Ajar"};
        String[] description = {getResources().getString(R.string.temperature), getResources().getString(R.string.OilPressure), getResources().getString(R.string.EngineCheck), getResources().getString(R.string.TirePressure), getResources().getString(R.string.BrakeSystem),
                getResources().getString(R.string.AbsWarning), getResources().getString(R.string.Stability), getResources().getString(R.string.TransmissionTemp), getResources().getString(R.string.Battery), getResources().getString(R.string.Airbag),getResources().getString(R.string.Fuel), getResources().getString(R.string.Doors),  };

        ArrayList<Signs> signsArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {
            Signs sign = new Signs(title[i], description[i], imageId[i]);
            signsArrayList.add(sign);
        }

        ListAdapter listAdapter = new ListAdapter(requireContext(), signsArrayList); // Get the ListView reference

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // Get the clicked item
                Signs clickedItem = (Signs) parent.getItemAtPosition(position);

                // Display a toast message with the description
                Toast.makeText(requireContext(), clickedItem.getDescription(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}