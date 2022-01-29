package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodcupResultActivity extends AppCompatActivity {

    TextView text;
    ImageView img;
    private Button btn_map, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcup_result);

        text = (TextView)findViewById(R.id.text);
        img = (ImageView)findViewById(R.id.img);
        btn_map = (Button)findViewById(R.id.btn_map);
        btn_back = (Button) findViewById(R.id.back_btn);

        Intent intent = getIntent();
        String winnerIdx = intent.getStringExtra("winnerIdx");
        String winner = intent.getStringExtra("winner");

        text.setText(winner);

        String tmpSign = "f" + winnerIdx;

        int lid = this.getResources().getIdentifier(tmpSign, "drawable", this.getPackageName());
//        Toast.makeText(getApplicationContext(), "Lid: "+ lid , Toast.LENGTH_SHORT).show();
        ((ImageView) img.findViewById(R.id.img)).setImageResource(lid);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, url을 넣어줌
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/"+winner));
                startActivity(intent);
            }

        });
    }

}