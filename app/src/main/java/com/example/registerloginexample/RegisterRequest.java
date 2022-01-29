package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정 (php파일 연동)
    final static private String URL = "http://kyoonge.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userAge",userAge+"");
        map.put("spi0","0 ");
        map.put("spi1","0 ");
        map.put("tem0","0 ");
        map.put("tem1","0 ");
        map.put("rec0","0 ");
        map.put("rec1","0 ");
        map.put("rec2","0 ");
        map.put("rec3","0 ");
        map.put("rec4","0 ");
        map.put("rec5","0 ");
        map.put("rec6","0 ");
        map.put("rec7","0 ");
        map.put("igd0","0 ");
        map.put("igd1","0 ");
        map.put("igd2","0 ");
        map.put("igd3","0 ");
        map.put("igd4","0 ");
        map.put("igd5","0 ");
        map.put("igd6","0 ");
        map.put("igd7","0 ");
        map.put("igd8","0 ");
        map.put("ctr0","0 ");
        map.put("ctr1","0 ");
        map.put("ctr2","0 ");
        map.put("ctr3","0 ");
        map.put("ctr4","0 ");

    };

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
