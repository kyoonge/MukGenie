package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.registerloginexample.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {

    ActivityFoodBinding binding;
    String[] info0 = {"#순함", "#매콤"};
    String[] info1 = {"#시원", "#따뜻"};
    String[] info2 = {"#구움", "#찜", "#조림", "#끓임", "#날것", "#비빔", "#볶음", "#튀김"};
    String[] info3 = {"#밥", "#빵", "#면", "#생선", "#해물", "#가금류", "#육류", "#야채"};
    String[] info4 = {"#한국", "#중국", "#일본", "#동양", "#서양"};
    Button btn_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        btn_map = (Button)findViewById(R.id.btn_map);

        String name = intent.getStringExtra("name");
        String foodInfo = intent.getStringExtra("foodInfo");
        int imageId = intent.getIntExtra("imageId", R.drawable.f1);

        if (intent != null) {


            String InfoLine = searchInfo(foodInfo);

            binding.nameProfile.setText(name);
            binding.infoProfile.setText(InfoLine);
            binding.profileImage.setImageResource(imageId);
        }

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/"+name));
                startActivity(intent);
            }
        });

    }

    private String searchInfo(String foodInfo) {

        String line = null;
        line = info0[Character.getNumericValue(foodInfo.charAt(0))] + " " + info1[Character.getNumericValue(foodInfo.charAt(1))] + " " +
                info2[Character.getNumericValue(foodInfo.charAt(2))] + " " + info3[Character.getNumericValue(foodInfo.charAt(3))] + " "
                + info4[Character.getNumericValue(foodInfo.charAt(4))];

        return line;
    }


}