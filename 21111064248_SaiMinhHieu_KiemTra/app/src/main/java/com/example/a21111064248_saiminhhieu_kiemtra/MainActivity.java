package com.example.a21111064248_saiminhhieu_kiemtra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.Login);
        Button logup = findViewById(R.id.Logup);
        EditText usr = findViewById(R.id.UlOGIN);
        EditText pwd = findViewById(R.id.UPWD);

        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangky = new Intent(MainActivity.this,register.class);
                startActivity(dangky);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                Bundle b = i.getExtras();

                if (b != null){
                    String user = b.getString("username");
                    String password = b.getString("password");

                    boolean u = user.equals(usr.getText().toString());
                    boolean p = password.equals(pwd.getText().toString());

                    if(u && p){
                        Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,home.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}