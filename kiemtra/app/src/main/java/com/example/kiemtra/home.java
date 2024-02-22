package com.example.kiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
       Button out = findViewById(R.id.out);
       out.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent out = new Intent(home.this, MainActivity.class);
               startActivity(out);
           }
       });
    }
}
