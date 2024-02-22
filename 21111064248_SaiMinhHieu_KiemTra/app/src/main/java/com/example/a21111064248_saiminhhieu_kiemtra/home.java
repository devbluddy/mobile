package com.example.a21111064248_saiminhhieu_kiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
