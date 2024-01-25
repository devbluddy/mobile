package com.example.a21111064248_saiminhhieu_lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        l1b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Hoten",inputl1.getText().toString());
                nhandiem.launch(intent);
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