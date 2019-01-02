package com.example.medamoniaravind.volley;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.medamoniaravind.volley.Fragments.HomeFragment;

public class  SplashScreenActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String mobile12,password21;
    ImageView loading_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        loading_image = findViewById(R.id.loading_image);

        AnimationDrawable ad = (AnimationDrawable)loading_image.getDrawable();
        ad.setCallback(loading_image);
        ad.setVisible(true,true);
        ad.setCallback(loading_image);
        ad.start();
        sharedPreferences = getSharedPreferences("sp",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mobile12 = sharedPreferences.getString("mobile","null");
               password21 = sharedPreferences.getString("password","null");
            //    Log.d("mobile",mobile12);
//                Log.d("pass",password21);
                if (mobile12.equals("null")&&password21.equals("null")){
                    finish();
                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));

                }else {

                    startActivity(new Intent(SplashScreenActivity.this, NavigableActivity.class));
                    finish();

                }

            }
        },4*1000);
    }
}
