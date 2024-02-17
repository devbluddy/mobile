package com.example.a21111064248_saiminhhieu_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Mainb2 extends AppCompatActivity {
    private EditText inputl1;
    private TextView output1;
    ActivityResultLauncher<Intent> nhandiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1_bai2);
        inputl1 = findViewById(R.id.inputl1);
        output1=findViewById(R.id.output1);
        Button l1b2 = findViewById(R.id.l1b2);
        Button Btnb2 = findViewById(R.id.btn2);
        l1b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainb2.this,Secondb2.class);
                intent.putExtra("Hoten",inputl1.getText().toString());
                nhandiem.launch(intent);
            }
        });
        Btnb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Mainb2.this,MainActivity.class);
                startActivity(intent2);
            }
        });
        nhandiem  = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult ketquadiem) {
                        if (ketquadiem.getResultCode()==RESULT_OK){
                            Intent intent =ketquadiem.getData();
                            if(intent!=null){
                                Bundle bundle = intent.getExtras();
                                String diemnhan= bundle.getString("diemgui");
                                output1.setText(diemnhan);
                            }
                        }
                    }
                }

        );

    }

}
