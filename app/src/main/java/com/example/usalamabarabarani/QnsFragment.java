package com.example.usalamabarabarani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usalamabarabarani.databinding.FragmentOnyoBinding;
import com.example.usalamabarabarani.databinding.FragmentQnsBinding;

import java.util.ArrayList;
import java.util.List;


public class QnsFragment extends Fragment {

    private FragmentQnsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qns, container, false);
        binding = FragmentQnsBinding.bind(view); // Get the root view from the binding


        String[] title = {getResources().getString(R.string.qn1),getResources().getString(R.string.qn2),getResources().getString(R.string.qn3),getResources().getString(R.string.qn4),getResources().getString(R.string.qn5),getResources().getString(R.string.qn6),getResources().getString(R.string.qn7),
                getResources().getString(R.string.qn8),getResources().getString(R.string.qn9),getResources().getString(R.string.qn10),getResources().getString(R.string.qn11),getResources().getString(R.string.qn12),getResources().getString(R.string.qn13),getResources().getString(R.string.qn14)};
        String[] description = {getResources().getString(R.string.ans1),getResources().getString(R.string.ans2),getResources().getString(R.string.ans3),getResources().getString(R.string.ans4),getResources().getString(R.string.ans5),getResources().getString(R.string.ans6),getResources().getString(R.string.ans7),
                getResources().getString(R.string.ans8),getResources().getString(R.string.ans9),getResources().getString(R.string.ans10),getResources().getString(R.string.ans11),getResources().getString(R.string.ans12),getResources().getString(R.string.ans13),getResources().getString(R.string.ans14)};

        ArrayList<Qns> signsArrayList = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            Qns sign = new Qns(title[i], description[i]);
            signsArrayList.add(sign);
        }


        QnsAdapter qnsAdapter = new QnsAdapter(requireContext(), signsArrayList); // Get the ListView reference

        binding.listview.setAdapter(qnsAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object item = parent.getItemAtPosition(position);

                // Get the clicked item
                Qns clickedItem = (Qns) parent.getItemAtPosition(position);

                // Display a toast message with the description
                Toast.makeText(requireContext(), clickedItem.getDescription(), Toast.LENGTH_SHORT).show();


            }
        });

        return view;
    }
}
