package com.example.a21111064248_saiminhhieu_lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.InflateException;
import androidx.annotation.NonNull;

import java.util.List;
import java.util.zip.Inflater;

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
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_person,parent,false);
        }
        ImageView imageViewPerson = convertView.findViewById(R.id.imageviewPerson);
        TextView textViewPerson = convertView.findViewById(R.id.textViewPersonName);

        Person person= getItem(position);
        if (person != null){
            imageViewPerson.setImageResource(person.getImagePerson());
            textViewPerson.setText(person.getNamePerson());
        }
        return convertView;
    }
}
