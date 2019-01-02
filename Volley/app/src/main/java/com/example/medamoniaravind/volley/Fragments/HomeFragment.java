package com.example.medamoniaravind.volley.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medamoniaravind.volley.CustomAdapter.CustomhomeAdapter;
import com.example.medamoniaravind.volley.EventzPojo;
import com.example.medamoniaravind.volley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    ListView listvw;
    List<EventzPojo> data=new ArrayList<EventzPojo>();
    String url="http://vdtlabs.com/eventzapp/list_events.json";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        listvw=view.findViewById(R.id.hmlv);
     /*   String[] t1={"cricket","valiball","movies","pro Kabaddi"};
        String[] t2={"300","250","400","150"};
        Integer[] image1={R.drawable.mytickets,R.drawable.mytickets,R.drawable.mytickets,R.drawable.mytickets};
        CustomhomeAdapter customhomeAdapter=new CustomhomeAdapter(getContext(),t1,t2,image1);
        listvw.setAdapter(customhomeAdapter);*/
     fetchevents();
        return view;

    }
    public void fetchevents(){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest( url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("events",response.toString());
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String title=jsonObject.getString("title");
                        String price=jsonObject.getString("price");
                        String image=jsonObject.getString("image");
                        String date=jsonObject.getString("date");
                        String venue=jsonObject.getString("venue");


                      /*  eventzPojo.getP_date();
                        eventzPojo.getP_image();
                        eventzPojo.getP_price();
                        eventzPojo.getP_title();
                        eventzPojo.getP_venue();*/
                        data.add(new EventzPojo(title,price,image,date,venue));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                CustomhomeAdapter customhomeAdapter=new CustomhomeAdapter(getContext(),data);
                customhomeAdapter.notifyDataSetChanged();
                listvw.setAdapter(customhomeAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }


}
