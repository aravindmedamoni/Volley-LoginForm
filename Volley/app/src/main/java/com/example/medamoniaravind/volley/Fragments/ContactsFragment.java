package com.example.medamoniaravind.volley.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medamoniaravind.volley.R;

public class ContactsFragment extends Fragment {

    TextView cnctemail,cnctwtsapp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contacts,container,false);
        cnctemail=view.findViewById(R.id.cntct_tv1);
        cnctwtsapp=view.findViewById(R.id.cnct_tv2);
        cnctemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                getContext().startActivity(intent);
            }
        });

        cnctwtsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plane");
                intent.setPackage("www.gbmods.co");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Hey guys install this app enjoy the features");
                intent.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id="+getContext().getPackageName());
                getContext().startActivity(intent);
            }
        });
        return view;
    }
}
