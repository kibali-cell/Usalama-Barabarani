package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentMaelekezoBinding;
import com.example.usalamabarabarani.databinding.FragmentOnyoBinding;

import java.util.ArrayList;


public class MaelekezoFragment extends Fragment {

    private FragmentMaelekezoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maelekezo, container, false);
        binding = FragmentMaelekezoBinding.bind(view);

        int[] imageId = {R.drawable.mkoa, R.drawable.mto, R.drawable.muelekeocu, R.drawable.kablayamzunguko, R.drawable.barabara, R.drawable.baadayamkutano, R.drawable.mchepuo, R.drawable.hudumakwanza, R.drawable.simu,  R.drawable.mafuta,
                R.drawable.malazi, R.drawable.chakula, R.drawable.viburudisho, R.drawable.picnic, R.drawable.trailer, R.drawable.kuogelea, R.drawable.njiachomoza, R.drawable.njiaingia, R.drawable.barabarachagua,};
        //String[] title = {"Stop", "Kunja Kushoto", "Kunja Kulia"};
        String[] description = {getResources().getString(R.string.maelekezo1), getResources().getString(R.string.maelekezo2), getResources().getString(R.string.maelekezo3), getResources().getString(R.string.maelekezo4), getResources().getString(R.string.maelekezo5), getResources().getString(R.string.maelekezo6), getResources().getString(R.string.maelekezo7), getResources().getString(R.string.maelekezo8), getResources().getString(R.string.maelekezo9), getResources().getString(R.string.maelekezo10),
                getResources().getString(R.string.maelekezo11), getResources().getString(R.string.maelekezo12), getResources().getString(R.string.maelekezo13), getResources().getString(R.string.maelekezo14), getResources().getString(R.string.maelekezo15), getResources().getString(R.string.maelekezo16), getResources().getString(R.string.maelekezo17), getResources().getString(R.string.maelekezo18), getResources().getString(R.string.maelekezo19) };

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