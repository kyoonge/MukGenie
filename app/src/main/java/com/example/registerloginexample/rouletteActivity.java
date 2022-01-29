package com.example.registerloginexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class rouletteActivity extends AppCompatActivity {

    Button btn_load;
    XmlResourceParser xrp;
    TextView text;
    TextView tv_state1;
    ImageView image;
    Button back_btn;
    Handler handler = new Handler();
    private ImageView wheel;                         // 회전 이미지
    Bitmap foodpic;
    private Bitmap mBitMap;                          // 이미지를 가저온다.
    private float init_angle = 0.0f;                // 초기 각토
    private final int IMG_DP = 300;                 //  이미지 DP
    String a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        tv_state1 = (TextView)findViewById(R.id.state1);
        image = (ImageView)findViewById(R.id.image);
        back_btn = (Button)findViewById(R.id.back_btn);
        // 이미지 SET
        wheel = (ImageView) findViewById(R.id.wheel);
        // 비트맵 이미지를 가저온다.(drawable폴더에 roulette이미지)
        mBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.roulette);
        // 비트맵을 imageview 에 넣는다.(리사이즈한후)
        wheel.setImageBitmap(onResizeImage(mBitMap));

        // 버튼 이벤트
        Button btn = (Button) findViewById(R.id.rotate_btn);

        //뒤로가기 버튼
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //회전버튼 눌렀을 떄
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWheelImage();
                //룰렛 회전
                handler.postDelayed(new Runnable() {
                    @Override
                    //결과 팝업창 뜨기
                    public void run() {

                        show();

                    }
                }, 4000);
            }
        });
    }


    void show() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과");
        //타이틀설정
        String tv_text = tv_state1.getText().toString();

        String[] foodlist  = {"모듬전",	"짜장면",	"두부김치",	"샐러드",	"김치찌개",	"된장찌개",	"샤브샤브",	"순두부찌개",	"인도커리",	"청국장",	"콩나물해장국",	"훠궈",	"오코노미야끼",	"돈까스",	"오돌뼈",	"제육볶음",	"육회",	"갈비탕",	"감자탕",	"곰탕",	"보쌈",	"부대찌개",	"불고기",	"뼈다귀해장국",	"선짓국",	"설렁탕",	"육개장",	"등갈비김치찜",	"소갈비찜",	"족발",	"곱창",	"돼지갈비",	"돼지껍데기",	"막창",	"삼겹살",	"소갈비",	"스테이크",	"양갈비",	"양꼬치",	"닭강정",	"양념치킨",	"후라이드치킨",	"닭똥집",	"닭발",	"누룽지백숙",	"닭한마리",	"삼계탕",	"닭도리탕",	"찜닭",	"닭갈비",
                "오리주물럭",	"함박스테이크",	"낙지볶음",	"오징어볶음",	"쭈꾸미볶음",	"꼬막무침",	"물회",	"간장게장",	"산낙지",	"양념게장",	"매운탕",	"미역국",	"전복죽",	"짬뽕",	"갈치조림",	"고등어조림",	"대게찜",	"문어숙회",	"아구찜",	"해물찜",	"갈치구이",	"꼼장어",	"조개구이",	"연어장",	"초밥",	"회",	"추어탕",	"장어구이",	"야키소바",	"파스타",	"막국수",	"메밀국수",	"물냉면",	"비빔국수",	"비빔냉면",	"쫄면",	"콩국수",	"탄탄멘",	"고기국수",	"라멘",	"라면",	"만두전골",	"수제비",	"쌀국수",	"우동",	"잔치국수",	"해물칼국수",	"떡볶이",	"즉석떡볶이",	"샌드위치",	"타코",	"토스트",
                "피자",	"햄버거",	"가츠동",	"김치볶음밥",	"리조또",	"알밥",	"오므라이스",	"잡채밥",	"팟타이",	"필라프",	"규동",	"김밥",	"비빔밥",	"연어덮밥",	"우렁쌈밥",	"케밥",	"회덮밥",	"단팥죽",	"돼지국밥",	"떡국",	"순대국밥", "카레우동", "마라샹궈", "마라탕", "그릭요거트", "낙곱새"};

        Random oRandom = new Random();
        int randNum = oRandom.nextInt(foodlist.length);
        builder.setMessage(foodlist[randNum]);

        builder.setPositiveButton("먹으러 가기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/"+foodlist[randNum]));
                        startActivity(intent);
                    }
                });

        builder.setNegativeButton("다시하기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(), "취소완료", Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }


    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    /**
     *
     * 이미지를 리사이징한다.
     *
     */
    private Bitmap onResizeImage(Bitmap bitmap){
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        //이미지를 dp로 변경
        Float size = convertDpToPixel(IMG_DP, getApplicationContext());

        Bitmap resized = null;
        while (height > size.intValue()) {
            resized = Bitmap.createScaledBitmap(bitmap, (width * size.intValue()) / height, size.intValue(), true);
            height = resized.getHeight();
            width = resized.getWidth();
        }
        return resized;
    }

    /**
     *
     * 램덤 함수를 가저온다.
     *
     * @param maxNumber
     * @return
     */
    private int getRandom(int maxNumber) {
        return (int)(Math.random()*maxNumber);
    }
    /**
     *
     * 이미지를 회전시킨다.
     *
     */
    private void onWheelImage(){
        runOnUiThread(new Runnable() {
            public void run() {
                // 회전수를 제어
                // 램덤 0~360 + 720 도 + 회전각
                float fromAngle = getRandom(180)+2500+init_angle;
                // 로테이션 에니메이션 초기화.
                // 시작각, 종료각, 자기 원을 그리며 회전 옵션 (Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f)
                RotateAnimation rAnim = new RotateAnimation(init_angle, fromAngle, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                // 초기 시작 각도를 update 한다.
                init_angle = fromAngle;
                // 지속시간 길수록 느려진다.
                rAnim.setDuration(3000);
                // 에니메이션이 종료된후 상태를 고정주는 옵션
                rAnim.setFillEnabled(true);
                rAnim.setFillAfter(true);
                // 회전을 한다.
                wheel.startAnimation(rAnim);
            }
        });
    }



}



