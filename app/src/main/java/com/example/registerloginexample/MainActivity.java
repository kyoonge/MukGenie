package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView btn_roulette, btn_logout, btn_worldcup, btn_list;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_roulette = findViewById(R.id.btn_roulette);
        btn_worldcup = findViewById(R.id.btn_worldcup);
        btn_logout = findViewById(R.id.btn_logout);
        btn_list = findViewById(R.id.btn_list);
        name = findViewById(R.id.dashboard_adminName);
        Intent intent = getIntent();
        //String userID = intent.getStringExtra("userID");
        //String userPass = intent.getStringExtra("userPass");
        String userName = intent.getStringExtra("userName");


        name.setText(userName + "님");

        //음식 월드컵
        btn_worldcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FoodcupActivity.class);
                //intent.putExtra("userID",userID);
                startActivity(intent);
            }
        });

        //룰렛돌리기
        btn_roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,rouletteActivity.class);

                startActivity(intent);
                intent.putExtra("userName",userName);
            }
        });

        //푸드리스트
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                //intent.putExtra("userID",userID);
                startActivity(intent);
            }
        });


        //로그아웃
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}