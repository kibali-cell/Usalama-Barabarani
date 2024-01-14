package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentAmriBinding;
import com.example.usalamabarabarani.databinding.FragmentTaarifaBinding;

import java.util.ArrayList;


public class TaarifaFragment extends Fragment {

    private FragmentTaarifaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTaarifaBinding.inflate(inflater, container, false);
        View view = binding.getRoot(); // Get the root view from the binding

        int[] imageId = {R.drawable.uelekeo, R.drawable.ainagari, R.drawable.umbali, R.drawable.umbalikatiya, R.drawable.spidi};
    //    String[] title = {"Stop", "Kunja Kushoto", "Kunja Kulia"};
        String[] description = {"Uelekeo ambao ujumbe wa alama kuu unahusika", "Aina ya gari ambalo linahusika na ujumbe wa alama kuu", "Umbali Mita Mbili", "Mwanzo na umbali ambao ujumbe wa alama unahusika", "Spidi ya mwisho kutembelea ni Kilometa 80 kwa lisaa" };

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