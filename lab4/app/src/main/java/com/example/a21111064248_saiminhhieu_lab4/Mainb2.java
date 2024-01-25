package com.example.a21111064248_saiminhhieu_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Mainb2 extends AppCompatActivity {
    private EditText inputl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1_bai2);
        inputl1 = findViewById(R.id.inputl1);
        Button l1b1 = findViewById(R.id.l1b2);
        l1b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainb2.this,Secondb2.class);
                startActivity(intent);
                String input = inputl1.getText().toString();
            }
        });

    }
}
