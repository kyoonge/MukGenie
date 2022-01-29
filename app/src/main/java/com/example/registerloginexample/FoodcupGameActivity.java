package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class FoodcupGameActivity extends AppCompatActivity {


    TextView type_txt, text1, text2;
    ImageButton img1, img2;
    String[] foodlist  = {"모듬전",	"짜장면",	"두부김치",	"샐러드",	"김치찌개",	"된장찌개",	"샤브샤브",	"순두부찌개",	"인도커리",	"청국장",	"콩나물해장국",	"훠궈",	"오코노미야끼",	"돈까스",	"오돌뼈",	"제육볶음",	"육회",	"갈비탕",	"감자탕",	"곰탕",	"보쌈",	"부대찌개",	"불고기",	"뼈다귀해장국",	"선짓국",	"설렁탕",	"육개장",	"등갈비김치찜",	"소갈비찜",	"족발",	"곱창",	"돼지갈비",	"돼지껍데기",	"막창",	"삼겹살",	"소갈비",	"스테이크",	"양갈비",	"양꼬치",	"닭강정",	"양념치킨",	"후라이드치킨",	"닭똥집",	"닭발",	"누룽지백숙",	"닭한마리",	"삼계탕",	"닭도리탕",	"찜닭",	"닭갈비",
            "오리주물럭",	"함박스테이크",	"낙지볶음",	"오징어볶음",	"쭈꾸미볶음",	"꼬막무침",	"물회",	"간장게장",	"산낙지",	"양념게장",	"매운탕",	"미역국",	"전복죽",	"짬뽕",	"갈치조림",	"고등어조림",	"대게찜",	"문어숙회",	"아구찜",	"해물찜",	"갈치구이",	"꼼장어",	"조개구이",	"연어장",	"초밥",	"회",	"추어탕",	"장어구이",	"야키소바",	"파스타",	"막국수",	"메밀국수",	"물냉면",	"비빔국수",	"비빔냉면",	"쫄면",	"콩국수",	"탄탄멘",	"고기국수",	"라멘",	"라면",	"만두전골",	"수제비",	"쌀국수",	"우동",	"잔치국수",	"해물칼국수",	"떡볶이",	"즉석떡볶이",	"샌드위치",	"타코",	"토스트",
            "피자",	"햄버거",	"가츠동",	"김치볶음밥",	"리조또",	"알밥",	"오므라이스",	"잡채밥",	"팟타이",	"필라프",	"규동",	"김밥",	"비빔밥",	"연어덮밥",	"우렁쌈밥",	"케밥",	"회덮밥",	"단팥죽",	"돼지국밥",	"떡국",	"순대국밥", "카레우동", "마라샹궈", "마라탕", "그릭요거트", "낙곱새"};
    public int now = 0;
    int removeIndex = 0;
    String type;
    Integer gameType;
    String food1 = "";
    String food2 = "";


    List<Integer> indexList = new ArrayList<>();
    List<String> foodlistRan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcup_game);

        InitializeBinding();

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        gameType = Integer.parseInt(type);

        //랜덤음식배열 생성
        CreateRandomFoodList();

 //       while (true) {

        type_txt.setText(gameType + "강");
        ShowPictures(now);
           // typeInt = typeInt / 2;
 //      }

        // 버튼 이벤트
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodlistRan.remove(food2);
                now++;
                ShowPictures(now);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodlistRan.remove(food1);
                now++;
                ShowPictures(now);
            }
        });
    }

    private void ShowPictures(int i) {

        if(now == gameType/2) {
            now = 0;
            i = 0;
            gameType = gameType/2;
            if(gameType == 2) // 결승 표시
                type_txt.setText("결승");
            else if(gameType == 1){ //최후의 1음식이 나오면 화면전환
                int imgNum = Arrays.asList(foodlist).indexOf(foodlistRan.get(i)) + 1;

                Intent intent = new Intent(FoodcupGameActivity.this,FoodcupResultActivity.class);
                intent.putExtra("winnerIdx", String.valueOf(imgNum));
                intent.putExtra("winner",foodlistRan.get(0));
                startActivity(intent);
            }
            else type_txt.setText(gameType + "강");
        }

        //이미지1, 텍스트1 로드
        int imgNum = Arrays.asList(foodlist).indexOf(foodlistRan.get(i)) + 1;

        String tmpSign = "f" + String.valueOf(imgNum);
        int lid = this.getResources().getIdentifier(tmpSign, "drawable", this.getPackageName());
        ((ImageButton) img1.findViewById(R.id.img1)).setImageResource(lid);

        text1.setText(foodlistRan.get(i));
        food1 = foodlistRan.get(i);


        //이미지2, 텍스트2 로드
        imgNum = Arrays.asList(foodlist).indexOf(foodlistRan.get(i + 1)) + 1;

        tmpSign = "f" + String.valueOf(imgNum);
        lid = this.getResources().getIdentifier(tmpSign, "drawable", this.getPackageName());
        ((ImageButton) img2.findViewById(R.id.img2)).setImageResource(lid);

        text2.setText(foodlistRan.get(i + 1));
        food2 = foodlistRan.get(i+1);
    }

    private void CreateRandomFoodList() {
        for (int i = 0; i < foodlist.length; i++) {
            indexList.add(i);
        }

        Collections.shuffle(indexList);
        for (int i = 0; i < gameType; i++) {
            foodlistRan.add(foodlist[indexList.get(i)]);
        }
    }

    private void InitializeBinding() {
        type_txt = (TextView) findViewById(R.id.type_txt);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        img1 = (ImageButton) findViewById(R.id.img1);
        img2 = (ImageButton) findViewById(R.id.img2);
    }
}