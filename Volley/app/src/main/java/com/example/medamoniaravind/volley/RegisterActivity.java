package com.example.medamoniaravind.volley;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText useret,mailet,mbnumet,passwordet;
    String rgusrname,rgusrmail,rgusrmbnum,rgusrpswd;

   // ProgressDialog progressDialog;
    String url="http://vdtlabs.com/eventzapp/api.php?url=user_registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        useret=findViewById(R.id.rgname);
        mailet=findViewById(R.id.rgmail);
        mbnumet=findViewById(R.id.rgmbnum);
        passwordet=findViewById(R.id.rgpswd);

    }

    public void clickregisterbtn(View view) {
        rgusrname=useret.getText().toString();
        rgusrmail=mailet.getText().toString();
        rgusrmbnum=mbnumet.getText().toString();
        rgusrpswd=passwordet.getText().toString();
   //     progressDialog=new ProgressDialog(RegisterActivity.this);
       // progressDialog.setCancelable(false);
       // progressDialog.setMessage("please waite");
       // progressDialog.show();

        StringRequest strequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jso=new JSONObject(response);
                    String status=jso.getString("error");
                    String msg=jso.getString("msg");
                    if (status.equals("FALSE")){
                        useret.setText("");
                        mailet.setText("");
                        mbnumet.setText("");
                        passwordet.setText("");
                        Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_LONG).show();
                        finish();
                    }else {
                        useret.setText("");
                        mailet.setText("");
                        mbnumet.setText("");
                        passwordet.setText("");
                        Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
              //  progressDialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("name",rgusrname);
                hashMap.put("email",rgusrmail);
                hashMap.put("mobile",rgusrmbnum);
                hashMap.put("password",rgusrpswd);
                return hashMap;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(RegisterActivity.this);
        requestQueue.add(strequest);
    }
}
