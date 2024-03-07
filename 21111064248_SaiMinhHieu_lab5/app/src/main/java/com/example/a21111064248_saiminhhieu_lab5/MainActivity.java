package com.example.a21111064248_saiminhhieu_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPerson = findViewById(R.id.spinnerPerson);

        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 1"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 2"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 3"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 4"));

        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.spinner_item,listPerson);

        spinnerPerson.setAdapter(personAdapter);

        spinnerPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person selectedPerson = personAdapter.getItem(position);
                if(selectedPerson != null){
                    String selectedName = selectedPerson.getNamePerson();
                    Toast.makeText(MainActivity.this, "Ban da chon "+selectedName,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}