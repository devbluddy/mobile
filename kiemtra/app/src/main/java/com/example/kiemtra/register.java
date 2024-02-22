package com.example.kiemtra;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button register = findViewById(R.id.register);
        EditText user =findViewById(R.id.RlOGIN);
        EditText pwd =findViewById(R.id.RPWD);
        EditText rpwd =findViewById(R.id.REPWD);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(register.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",user.getText().toString());
                bundle.putString("password",pwd.getText().toString());
                i.putExtras(bundle);
            }
        });
    }
}
