package com.example.registerloginexample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import com.example.registerloginexample.databinding.ActivityMainBinding;
import com.example.registerloginexample.databinding.ActivityListBinding;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.f1,	R.drawable.f2,	R.drawable.f3,	R.drawable.f4,	R.drawable.f5,	R.drawable.f6,	R.drawable.f7,	R.drawable.f8,	R.drawable.f9,	R.drawable.f10,	R.drawable.f11,	R.drawable.f12,	R.drawable.f13,	R.drawable.f14,	R.drawable.f15,	R.drawable.f16,	R.drawable.f17,	R.drawable.f18,	R.drawable.f19,	R.drawable.f20,	R.drawable.f21,	R.drawable.f22,	R.drawable.f23,	R.drawable.f24,	R.drawable.f25,	R.drawable.f26,	R.drawable.f27,	R.drawable.f28,	R.drawable.f29,	R.drawable.f30,	R.drawable.f31,	R.drawable.f32,	R.drawable.f33,	R.drawable.f34,	R.drawable.f35,	R.drawable.f36,	R.drawable.f37,	R.drawable.f38,	R.drawable.f39,	R.drawable.f40,	R.drawable.f41,	R.drawable.f42,	R.drawable.f43,	R.drawable.f44,	R.drawable.f45,	R.drawable.f46,	R.drawable.f47,	R.drawable.f48,	R.drawable.f49,	R.drawable.f50,	R.drawable.f51,	R.drawable.f52,	R.drawable.f53,	R.drawable.f54,	R.drawable.f55,	R.drawable.f56,	R.drawable.f57,	R.drawable.f58,	R.drawable.f59,	R.drawable.f60,	R.drawable.f61,	R.drawable.f62,	R.drawable.f63,	R.drawable.f64,	R.drawable.f65,	R.drawable.f66,	R.drawable.f67,	R.drawable.f68,	R.drawable.f69,	R.drawable.f70,	R.drawable.f71,	R.drawable.f72,	R.drawable.f73,	R.drawable.f74,	R.drawable.f75,	R.drawable.f76,	R.drawable.f77,	R.drawable.f78,	R.drawable.f79,	R.drawable.f80,	R.drawable.f81,	R.drawable.f82,	R.drawable.f83,	R.drawable.f84,	R.drawable.f85,	R.drawable.f86,	R.drawable.f87,	R.drawable.f88,	R.drawable.f89,	R.drawable.f90,	R.drawable.f91,	R.drawable.f92,	R.drawable.f93,	R.drawable.f94,	R.drawable.f95,	R.drawable.f96,	R.drawable.f97,	R.drawable.f98,	R.drawable.f99,	R.drawable.f100,	R.drawable.f101,	R.drawable.f102,	R.drawable.f103,	R.drawable.f104,	R.drawable.f105,	R.drawable.f106,	R.drawable.f107,	R.drawable.f108,	R.drawable.f109,	R.drawable.f110,	R.drawable.f111,	R.drawable.f112,	R.drawable.f113,	R.drawable.f114,	R.drawable.f115,	R.drawable.f116,	R.drawable.f117,	R.drawable.f118,	R.drawable.f119,	R.drawable.f120,	R.drawable.f121,	R.drawable.f122,	R.drawable.f123
        };
        String[] name  = {"?????????",	"?????????",	"????????????",	"?????????",	"????????????",	"????????????",	"????????????",	"???????????????",	"????????????",	"?????????",	"??????????????????",	"??????",	"??????????????????",	"?????????",	"?????????",	"????????????",	"??????",	"?????????",	"?????????",	"??????",	"??????",	"????????????",	"?????????",	"??????????????????",	"?????????",	"?????????",	"?????????",	"??????????????????",	"????????????",	"??????",	"??????",	"????????????",	"???????????????",	"??????",	"?????????",	"?????????",	"????????????",	"?????????",	"?????????",	"?????????",	"????????????",	"??????????????????",	"?????????",	"??????",	"???????????????",	"????????????",	"?????????",	"????????????",	"??????",	"?????????",
                "???????????????",	"??????????????????",	"????????????",	"???????????????",	"???????????????",	"????????????",	"??????",	"????????????",	"?????????",	"????????????",	"?????????",	"?????????",	"?????????",	"??????",	"????????????",	"???????????????",	"?????????",	"????????????",	"?????????",	"?????????",	"????????????",	"?????????",	"????????????",	"?????????",	"??????",	"???",	"?????????",	"????????????",	"????????????",	"?????????",	"?????????",	"????????????",	"?????????",	"????????????",	"????????????",	"??????",	"?????????",	"?????????",	"????????????",	"??????",	"??????",	"????????????",	"?????????",	"?????????",	"??????",	"????????????",	"???????????????",	"?????????",	"???????????????",	"????????????",	"??????",	"?????????",
                "??????",	"?????????",	"?????????",	"???????????????",	"?????????",	"??????",	"???????????????",	"?????????",	"?????????",	"?????????",	"??????",	"??????",	"?????????",	"????????????",	"????????????",	"??????",	"?????????",	"?????????",	"????????????",	"??????",	"????????????", "????????????", "????????????", "?????????", "???????????????", "?????????"};

        String[] foodInfo = {"01770",	"01621",	"01570",	"00474",	"11300",	"01300",	"01380",	"11300",	"01383",	"01300",	"01300",	"01381",	"01072",	"01762",	"11660",	"11660",	"00460",	"01360",	"11360",	"01360",	"01360",	"11360",	"01360",	"11360",	"11360",	"01360",	"11360",	"11160",	"01160",	"01160",	"11060",	"01060",	"11060",	"01060",	"01060",	"01060",	"01064",	"01064",	"01064",	"01750",	"11750",	"01750",	"11650",	"11650",	"01350",	"01350",	"01350",	"11250",	"01150",	"11050",	"11050",	"01054",	"11640",	"11640",	"11640",	"10540",	"10540",	"00440",	"00440",	"10440",	"11340",	"01340",	"01340",	"11341",	"11240",	"11240",	"01140",	"00140",	"11140",	"11140",	"01040",	"11040",	"01040",	"00432",	"00432",	"00432",	"11330",	"01030",	"01622",	"01624",	"10520",	"10520",	"00520",	"10520",	"10520",	"10520",	"00520",	"11521",	"01320",	"01322",	"11320",	"01320",	"01320",	"01323",	"01322",	"01320",	"01320",	"11610",	"11610",	"00514",	"01514",	"01014",	"01014",	"00014",	"01602",	"11600",	"01604",	"01602",	"01604",	"01600",	"01603",	"01604",	"01502",	"00500",	"10500",	"01502",	"01500",	"01504",	"00402",	"01300",	"01300",	"01300",	"11300"  };

        ArrayList<Food> foodArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            Food food = new Food(name[i],foodInfo[i],imageId[i]);
            foodArrayList.add(food);

        }

        ListAdapter listAdapter = new ListAdapter(ListActivity.this, foodArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListActivity.this, FoodActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("foodInfo",foodInfo[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);

            }
        });

    }
}