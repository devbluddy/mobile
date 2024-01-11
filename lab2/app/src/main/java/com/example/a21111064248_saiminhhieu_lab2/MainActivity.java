package com.example.a21111064248_saiminhhieu_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView test;
    private EditText inputtext;
    private RadioGroup radiogroup;
    private RadioButton radiobtn1;
    private RadioButton radiobtn2;
    private LinearLayout checkboxgroup;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private Button bnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.test);
        inputtext = findViewById(R.id.inputtext);
        radiogroup = findViewById(R.id.radiogroup);
        radiobtn1 = findViewById(R.id.radiobtn1);
        radiobtn2 = findViewById(R.id.radiobtn2);
        checkboxgroup = findViewById(R.id.checkboxgroup);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        bnt = findViewById(R.id.bnt);

        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputtext.getText().toString();
                String gender = radiobtn1.isChecked() ? "Nam":"Nữ";
                String hobbies = getHobbiesString();
                String displayText = "Tên: "+ name + "\nGiới tính: "+gender+"\n Sở thích: " + hobbies;
                test.setText(displayText);
            }
        });
    }
    private String getHobbiesString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(cb1.isChecked()){
            stringBuilder.append("Âm nhạc ");
        }
        if (cb2.isChecked()){
            stringBuilder.append("Du lịch ");
        }
        if(cb3.isChecked()){
            stringBuilder.append("Thể thao ");
        }
        return stringBuilder.toString().trim();
    }
}

