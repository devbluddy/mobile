package com.example.a21111064248_saiminhhieu_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Secondb2 extends AppCompatActivity {
    private EditText inputl2;
    private TextView output2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2_bai2);
        inputl2 = findViewById(R.id.inputl2);
        output2=findViewById(R.id.output2);
        Button l2b2 = findViewById(R.id.l2b2);
        Intent intent=getIntent();
        output2.setText(intent.getStringExtra("Hoten"));
        Button Btnb2 = findViewById(R.id.btn2);

        l2b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diemsv = inputl2.getText().toString();
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("diemgui",diemsv);
                intent2.putExtras(bundle);
                setResult(RESULT_OK,intent2);
                finish();
            }
        });
        Btnb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Secondb2.this,MainActivity.class);
                startActivity(intent2);
            }
        });

    }

}
