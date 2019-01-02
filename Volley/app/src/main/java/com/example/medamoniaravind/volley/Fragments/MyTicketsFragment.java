package com.example.medamoniaravind.volley.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.medamoniaravind.volley.CustomAdapter.CustomMyticketsAdapter;
import com.example.medamoniaravind.volley.R;

public class MyTicketsFragment extends Fragment {
    ListView lstvw;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.mytickesfragment,container,false);
        lstvw=view.findViewById(R.id.mylv);
        String[] t1={"cricket","valiball","movies","pro Kabaddi"};
        String[] t2={"300","250","400","150"};
        Integer[] image1={R.drawable.mytickets,R.drawable.mytickets,R.drawable.mytickets,R.drawable.mytickets};
        CustomMyticketsAdapter customMyticketsAdapter=new CustomMyticketsAdapter(getContext(),t1,t2,image1);
        lstvw.setAdapter(customMyticketsAdapter);
        return view;
    }
}
