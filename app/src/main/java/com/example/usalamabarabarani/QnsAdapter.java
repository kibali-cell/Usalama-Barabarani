package com.example.usalamabarabarani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QnsAdapter extends ArrayAdapter<Qns> {


    public QnsAdapter(Context context, ArrayList<Qns> qnsArrayList){
        super(context, R.layout.qns_item, qnsArrayList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Qns qns = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.qns_item,parent,false);
        }

//        ImageView imageView = convertView.findViewById(R.id.qnsImg);
        TextView title = convertView.findViewById(R.id.question);
        TextView description = convertView.findViewById(R.id.answer);

//        imageView.setImageResource(qns.imageId);
        title.setText(qns.title);
        description.setText(qns.description);

        return convertView;
    }
}
