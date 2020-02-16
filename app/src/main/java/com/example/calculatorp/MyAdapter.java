package com.example.calculatorp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<ModelClass> {

    public MyAdapter(@NonNull Context context, ArrayList<ModelClass> myArrayList) {
        super(context, 0,myArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listview_items,parent,false);
        }

        ModelClass currentItem = getItem(position);
        TextView result_tv = listItemView.findViewById(R.id.calculation_tv);
        result_tv.setText(currentItem.getResult());
        TextView calculation_TextView = listItemView.findViewById(R.id.result_tv);
        calculation_TextView.setText(String.valueOf(currentItem.getCalculate()));
        TextView date_TextView = listItemView.findViewById(R.id.date_tv);
        date_TextView.setText(currentItem.getDate());

        return listItemView;
    }
}
