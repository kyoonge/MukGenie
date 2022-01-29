package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DatasetRequest extends StringRequest {

    //서버 URL 설정 (php파일 연동)
    final static private String URL = "http://kyoonge.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public DatasetRequest(String userID, String userPassword, String userName, int userAge, int spi0, int spi1, int tem0, int tem1, int rec0, int rec1, int rec2, int rec3, int rec4, int rec5, int rec6, int rec7, int igd0, int igd1, int igd2, int igd3, int igd4, int igd5, int igd6, int igd7, int igd8, int ctr0, int ctr1, int ctr2, int ctr3, int ctr4, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userAge",userAge+"");
        map.put("spi0",spi0+"");
        map.put("spi1",spi1+"");
        map.put("tem0",tem0+"");
        map.put("tem1",tem1+"");
        map.put("rec0",rec0+"");
        map.put("rec1",rec1+"");
        map.put("rec2",rec2+"");
        map.put("rec3",rec3+"");
        map.put("rec4",rec4+"");
        map.put("rec5",rec5+"");
        map.put("rec6",rec6+"");
        map.put("rec7",rec7+"");
        map.put("igd0",igd0+"");
        map.put("igd1",igd1+"");
        map.put("igd2",igd2+"");
        map.put("igd3",igd3+"");
        map.put("igd4",igd4+"");
        map.put("igd5",igd5+"");
        map.put("igd6",igd6+"");
        map.put("igd7",igd7+"");
        map.put("igd8",igd8+"");
        map.put("ctr0",ctr0+"");
        map.put("ctr1",ctr1+"");
        map.put("ctr2",ctr2+"");
        map.put("ctr3",ctr3+"");
        map.put("ctr4",ctr4+"");

    };

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
