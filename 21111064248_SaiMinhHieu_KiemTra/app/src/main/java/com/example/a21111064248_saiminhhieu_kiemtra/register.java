package com.example.a21111064248_saiminhhieu_kiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button register = findViewById(R.id.register);
        EditText user =findViewById(R.id.RlOGIN);
        EditText pwd =findViewById(R.id.RPWD);
        EditText rpwd =findViewById(R.id.REPWD);
        TextView text = findViewById(R.id.text);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = user.getText().toString();
                String password = pwd.getText().toString();
                String re_password = rpwd.getText().toString();

                if(password.equals(re_password)){
                    Intent i = new Intent(register.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",usr);
                    bundle.putString("password",pwd.getText().toString());
                    i.putExtras(bundle);
                    startActivity(i);
                }
                else {
                    text.setText("Mật khẩu không trùng");
                }
            }
        });
    }
}
