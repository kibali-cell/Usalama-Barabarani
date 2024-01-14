package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentAmriBinding;

import java.util.ArrayList;

public class AmriFragment extends Fragment {

  private FragmentAmriBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAmriBinding.inflate(inflater, container, false);
        View view = binding.getRoot(); // Get the root view from the binding

        int[] imageId = {
        R.drawable.stop, R.drawable.honihapana, R.drawable.noift, R.drawable.magarimafuta, R.drawable.chiniyahamsini, R.drawable.kipaumbele, R.drawable.mwishokipaumbele, R.drawable.go, R.drawable.kipaumbelekulia, R.drawable.simama,
                R.drawable.magarimarufuku, R.drawable.hapanavyombomoto, R.drawable.hapanapikipiki, R.drawable.trailers, R.drawable.nowalking, R.drawable.nofarasi, R.drawable.nomikokoteni, R.drawable.upana, R.drawable.urefu, R.drawable.gariurefu,
                R.drawable.excel2t, R.drawable.excel12t, R.drawable.marufukukushoto, R.drawable.marufukukulia, R.drawable.marufukuuturn, R.drawable.marufukuovertake, R.drawable.mwishoovertake, R.drawable.notruckovertake, R.drawable.truckovertake, R.drawable.themanin,
                R.drawable.usisimame, R.drawable.noparking, R.drawable.kushoto, R.drawable.kulia, R.drawable.mbelekushoto, R.drawable.mbelekulia, R.drawable.straightorleft, R.drawable.straightorright, R.drawable.kuliaorleft, R.drawable.hukukushoto,
                R.drawable.hukukulia, R.drawable.haparoundabout, R.drawable.watembeaji, R.drawable.njiabaiskeli, R.drawable.watunabaiskeli, R.drawable.kivukohapa, R.drawable.parking, R.drawable.parkingnamuda, R.drawable.basikusimama,
                R.drawable.busparking, R.drawable.mwishobarabara, R.drawable.mwendokasi, R.drawable.mwisho_mwendokasi, R.drawable.makazi, R.drawable.mwishomakazi};


        String[] description = {getResources().getString(R.string.amri1), getResources().getString(R.string.amri2), getResources().getString(R.string.amri3), getResources().getString(R.string.amri4), getResources().getString(R.string.amri5), getResources().getString(R.string.amri6), getResources().getString(R.string.amri7), getResources().getString(R.string.amri8), getResources().getString(R.string.amri9), getResources().getString(R.string.amri10),
                getResources().getString(R.string.amri11), getResources().getString(R.string.amri12), getResources().getString(R.string.amri13), getResources().getString(R.string.amri14), getResources().getString(R.string.amri15), getResources().getString(R.string.amri16), getResources().getString(R.string.amri17), getResources().getString(R.string.amri18), getResources().getString(R.string.amri19),
                getResources().getString(R.string.amri21), getResources().getString(R.string.amri22), getResources().getString(R.string.amri23), getResources().getString(R.string.amri24), getResources().getString(R.string.amri25), getResources().getString(R.string.amri26), getResources().getString(R.string.amri27), getResources().getString(R.string.amri28), getResources().getString(R.string.amri29), getResources().getString(R.string.amri30),
                getResources().getString(R.string.amri31), getResources().getString(R.string.amri32), getResources().getString(R.string.amri33), getResources().getString(R.string.amri34), getResources().getString(R.string.amri35), getResources().getString(R.string.amri36), getResources().getString(R.string.amri37), getResources().getString(R.string.amri38), getResources().getString(R.string.amri39), getResources().getString(R.string.amri40),
                getResources().getString(R.string.amri41), getResources().getString(R.string.amri42), getResources().getString(R.string.amri43), getResources().getString(R.string.amri44), getResources().getString(R.string.amri45), getResources().getString(R.string.amri46), getResources().getString(R.string.amri47), getResources().getString(R.string.amri48), getResources().getString(R.string.amri49), getResources().getString(R.string.amri50),
                getResources().getString(R.string.amri51), getResources().getString(R.string.amri52), getResources().getString(R.string.amri53), getResources().getString(R.string.amri54), getResources().getString(R.string.amri55), getResources().getString(R.string.amri56), getResources().getString(R.string.amri57)};

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