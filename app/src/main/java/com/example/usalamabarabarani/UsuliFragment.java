package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentAmriBinding;
import com.example.usalamabarabarani.databinding.FragmentUsuliBinding;

import java.util.ArrayList;

public class UsuliFragment extends Fragment {

    private FragmentUsuliBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUsuliBinding.inflate(inflater, container, false);
        View view = binding.getRoot(); // Get the root view from the binding

        int[] imageId = {R.drawable.konakali, R.drawable.usuli, R.drawable.konakalikushoto, R.drawable.taabarabarani, R.drawable.noovertakingline,
                R.drawable.makutanoline, R.drawable.mstaribarabara, R.drawable.mstaritenganishi, R.drawable.mstarinjano, R.drawable.mstarikupaki};
        String[] description = {getResources().getString(R.string.usuli1), getResources().getString(R.string.usuli2), getResources().getString(R.string.usuli3), getResources().getString(R.string.usuli4), getResources().getString(R.string.usuli5),
                getResources().getString(R.string.usuli6), getResources().getString(R.string.usuli7), getResources().getString(R.string.usuli8), getResources().getString(R.string.usuli9), getResources().getString(R.string.usuli10), };

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