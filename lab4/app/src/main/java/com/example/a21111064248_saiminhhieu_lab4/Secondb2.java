package com.example.a21111064248_saiminhhieu_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Secondb2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2_bai2);

        Button l1b1 = findViewById(R.id.l2b2);
        l1b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Secondb2.this,Mainb2.class);
                startActivity(intent);
            }
        });

    }
}
