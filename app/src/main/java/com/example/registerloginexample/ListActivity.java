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
        String[] name  = {"모듬전",	"짜장면",	"두부김치",	"샐러드",	"김치찌개",	"된장찌개",	"샤브샤브",	"순두부찌개",	"인도커리",	"청국장",	"콩나물해장국",	"훠궈",	"오코노미야끼",	"돈까스",	"오돌뼈",	"제육볶음",	"육회",	"갈비탕",	"감자탕",	"곰탕",	"보쌈",	"부대찌개",	"불고기",	"뼈다귀해장국",	"선짓국",	"설렁탕",	"육개장",	"등갈비김치찜",	"소갈비찜",	"족발",	"곱창",	"돼지갈비",	"돼지껍데기",	"막창",	"삼겹살",	"소갈비",	"스테이크",	"양갈비",	"양꼬치",	"닭강정",	"양념치킨",	"후라이드치킨",	"닭똥집",	"닭발",	"누룽지백숙",	"닭한마리",	"삼계탕",	"닭도리탕",	"찜닭",	"닭갈비",
                "오리주물럭",	"함박스테이크",	"낙지볶음",	"오징어볶음",	"쭈꾸미볶음",	"꼬막무침",	"물회",	"간장게장",	"산낙지",	"양념게장",	"매운탕",	"미역국",	"전복죽",	"짬뽕",	"갈치조림",	"고등어조림",	"대게찜",	"문어숙회",	"아구찜",	"해물찜",	"갈치구이",	"꼼장어",	"조개구이",	"연어장",	"초밥",	"회",	"추어탕",	"장어구이",	"야키소바",	"파스타",	"막국수",	"메밀국수",	"물냉면",	"비빔국수",	"비빔냉면",	"쫄면",	"콩국수",	"탄탄멘",	"고기국수",	"라멘",	"라면",	"만두전골",	"수제비",	"쌀국수",	"우동",	"잔치국수",	"해물칼국수",	"떡볶이",	"즉석떡볶이",	"샌드위치",	"타코",	"토스트",
                "피자",	"햄버거",	"가츠동",	"김치볶음밥",	"리조또",	"알밥",	"오므라이스",	"잡채밥",	"팟타이",	"필라프",	"규동",	"김밥",	"비빔밥",	"연어덮밥",	"우렁쌈밥",	"케밥",	"회덮밥",	"단팥죽",	"돼지국밥",	"떡국",	"순대국밥", "카레우동", "마라샹궈", "마라탕", "그릭요거트", "낙곱새"};

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