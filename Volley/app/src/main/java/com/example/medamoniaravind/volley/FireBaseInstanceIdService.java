package com.example.medamoniaravind.volley;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FireBaseInstanceIdService extends FirebaseInstanceIdService {
    String Tokenid,usrid;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Tokenid = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token", Tokenid.toString());
        sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("token",Tokenid);
        editor.commit();



       /**/
    }
}
