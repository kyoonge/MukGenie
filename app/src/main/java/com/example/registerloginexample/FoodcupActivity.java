package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FoodcupActivity extends AppCompatActivity {

    Button btn_start;
    private RadioGroup radioGroup;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcup);

        Intent intent = getIntent();
        btn_start = (Button)findViewById(R.id.btn_start);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupClickListener);



        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FoodcupActivity.this,FoodcupGameActivity.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
       });
    }



    RadioGroup.OnCheckedChangeListener radioGroupClickListener = new RadioGroup.OnCheckedChangeListener() {  // 중요
    @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.rbtn_16) type = "16";
            else if (i == R.id.rbtn_32) type = "32";
            else type = "64";
        }
    };

}