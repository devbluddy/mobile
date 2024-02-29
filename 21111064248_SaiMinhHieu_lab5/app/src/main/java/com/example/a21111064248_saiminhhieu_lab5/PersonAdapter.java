package com.example.a21111064248_saiminhhieu_lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    public PersonAdapter (@NonNull Context context, int resource, @NonNull List<Person> listPerson){
        super(context,resource,listPerson);
    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.spinner_item,parent,true);
        }
        ImageView imageViewPerson = convertView.findViewById(R.id.imageViewspinner);
        TextView textViewPerson = convertView.findViewById(R.id.textViewspinner);

        Person person= getItem(position);
        if (person != null){
            imageViewPerson.setImageResource(person.getImagePerson());
            textViewPerson.setText(person.getNamePerson());
        }
        return convertView;
    }
}
