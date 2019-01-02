package com.example.medamoniaravind.volley.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.medamoniaravind.volley.EditActivity;
import com.example.medamoniaravind.volley.R;

public class ProfileFragment extends Fragment {
    SharedPreferences sharedPreferences;
    TextView Protv1,Protv2,Protv3;
    Button Probtn;
    String Prombnum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.profilefragment,container,false);
      Protv1=view.findViewById(R.id.pro_tv1);
      Protv2=view.findViewById(R.id.pro_tv2);
      Protv3=view.findViewById(R.id.pro_tv3);
      Probtn=view.findViewById(R.id.pro_btn);

      sharedPreferences = getContext().getSharedPreferences("sp", Context.MODE_PRIVATE);
       Prombnum=sharedPreferences.getString("mobile",null);
       Protv3.setText("mobile: "+Prombnum);
        Probtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(),EditActivity.class));

            }
        });
        return view;
    }

  /*  public void clickeditbtn(View view){

        getContext().startActivity(new Intent(getContext(),EditActivity.class));*/
    //}
}
