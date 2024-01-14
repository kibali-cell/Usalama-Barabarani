package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentOnyoBinding;

import java.util.ArrayList;


public class OnyoFragment extends Fragment {

    private FragmentOnyoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_onyo, container, false);
        binding = FragmentOnyoBinding.bind(view); // Get the root view from the binding

        int[] imageId = {R.drawable.kunjakushoto, R.drawable.kili, R.drawable.konambilikushoto, R.drawable.konambilikulia, R.drawable.muinuko, R.drawable.mteremko, R.drawable.daraja, R.drawable.mpunguo, R.drawable.mpunguokushoto, R.drawable.mpunguokulia,
                R.drawable.matuta, R.drawable.kazimbele, R.drawable.gravel, R.drawable.mawe, R.drawable.mawekulia, R.drawable.utelezi, R.drawable.darajafunguka, R.drawable.kingo, R.drawable.tutamaji, R.drawable.handaki,
                R.drawable.msalaba, R.drawable.makutano, R.drawable.roundabout, R.drawable.makutanokipaumbele, R.drawable.taa, R.drawable.msongamano, R.drawable.kivukombele, R.drawable.waendakwamiguu, R.drawable.students, R.drawable.baiskeli,
                R.drawable.cow, R.drawable.swala, R.drawable.pishana, R.drawable.airport, R.drawable.upepo, R.drawable.onyo, R.drawable.reli, R.drawable.kivukoreli, R.drawable.relimoja, R.drawable.relimbili };
       // String[] title = {"Stop", "Kunja Kushoto", "Kunja Kulia"};
        String[] description = {getResources().getString(R.string.onyo1), getResources().getString(R.string.onyo2), getResources().getString(R.string.onyo3), getResources().getString(R.string.onyo4), getResources().getString(R.string.onyo5), getResources().getString(R.string.onyo6), getResources().getString(R.string.onyo7), getResources().getString(R.string.onyo8), getResources().getString(R.string.onyo9), getResources().getString(R.string.onyo10),
                getResources().getString(R.string.onyo11), getResources().getString(R.string.onyo12), getResources().getString(R.string.onyo13), getResources().getString(R.string.onyo14), getResources().getString(R.string.onyo15), getResources().getString(R.string.onyo16), getResources().getString(R.string.onyo17), getResources().getString(R.string.onyo18), getResources().getString(R.string.onyo19), getResources().getString(R.string.onyo20),
                getResources().getString(R.string.onyo21), getResources().getString(R.string.onyo22), getResources().getString(R.string.onyo23), getResources().getString(R.string.onyo24), getResources().getString(R.string.onyo25), getResources().getString(R.string.onyo26), getResources().getString(R.string.onyo27), getResources().getString(R.string.onyo28), getResources().getString(R.string.onyo29), getResources().getString(R.string.onyo30),
                getResources().getString(R.string.onyo31), getResources().getString(R.string.onyo32), getResources().getString(R.string.onyo33), getResources().getString(R.string.onyo34), getResources().getString(R.string.onyo35), getResources().getString(R.string.onyo36), getResources().getString(R.string.onyo37), getResources().getString(R.string.onyo38), getResources().getString(R.string.onyo39), getResources().getString(R.string.onyo40), };

        ArrayList<Signs> signsArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {
            Signs sign = new Signs("", description[i], imageId[i]);
            signsArrayList.add(sign);
        }

        ListAdapter listAdapter = new ListAdapter(requireContext(), signsArrayList); // Get the ListView reference

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object item = parent.getItemAtPosition(position);

                // Get the clicked item
                Signs clickedItem = (Signs) parent.getItemAtPosition(position);

                // Display a toast message with the description
                Toast.makeText(requireContext(), clickedItem.getDescription(), Toast.LENGTH_SHORT).show();



            }
        });

        return view;
    }
}