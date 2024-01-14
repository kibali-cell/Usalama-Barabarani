package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentAskariBinding;

import java.util.ArrayList;

public class AskariFragment extends Fragment {

    private FragmentAskariBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAskariBinding.inflate(inflater, container, false);
        View view = binding.getRoot(); // Get the root view from the binding

        int[] imageId = {R.drawable.kotesimama, R.drawable.mbelesimama, R.drawable.nyumasimama, R.drawable.rukhsambele, R.drawable.ruksanyuma};
        String[] description = {getResources().getString(R.string.askari1),  getResources().getString(R.string.askari2),  getResources().getString(R.string.askari3),  getResources().getString(R.string.askari4),  getResources().getString(R.string.askari5),  };

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