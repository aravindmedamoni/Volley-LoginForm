package com.example.medamoniaravind.volley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.medamoniaravind.volley.Fragments.HomeFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText etusrmobile,etusrpswd;
    String mnusermobile,mnuserpswd;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String url="http://vdtlabs.com/eventzapp/api.php?url=user_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("sp",MODE_PRIVATE);
        etusrmobile=findViewById(R.id.mnmobile);
        etusrpswd=findViewById(R.id.mnusrpswd);

    }

    public void clickloginbtn(View view) {
        mnusermobile=etusrmobile.getText().toString();
        mnuserpswd=etusrpswd.getText().toString();
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        StringRequest strngrqst=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject js=new JSONObject(response);
                    Log.d("Response",js.toString());
                    String status=js.getString("error");
                    String msg=js.getString("msg");
                    Log.d("Response",msg.toString());
                    if (status.equals("FALSE")){

                       String id=js.getString("id");
                        Log.d("Response","Inside If");
                        editor=sharedPreferences.edit();
                        editor.putString("mobile",mnusermobile);
                        editor.putString("password",mnuserpswd);
                        editor.putString("id",id);
                        editor.commit();


                        Intent intent=new Intent(MainActivity.this,NavigableActivity.class);
                        startActivity(intent);
                    //   startActivity(new Intent(MainActivity.this,NavigableActivity.class));
                        finish();
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

                    }else {
                        Log.d("Response","Inside Else");
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("mobile",mnusermobile);
                hashMap.put("password",mnuserpswd);
                return hashMap;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(strngrqst);
    }

    public void clickregisterbtn(View view) {
        etusrmobile.setText("");
        etusrpswd.setText("");
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
    }

    public void clickfogotbtn(View view) {
        startActivity(new Intent(MainActivity.this,ForgotPassActivity.class));
    }
}
