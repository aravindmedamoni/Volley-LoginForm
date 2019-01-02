package com.example.medamoniaravind.volley.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medamoniaravind.volley.EventzPojo;
import com.example.medamoniaravind.volley.Fragments.HomeFragment;
import com.example.medamoniaravind.volley.R;

import java.util.List;

public class CustomhomeAdapter extends ArrayAdapter {
    Context ctx;
    String[] name,price;
    Integer[] image;
    TextView txvw1,txvw2;
    ImageView imageView;
    List<EventzPojo> list;


   /* public CustomhomeAdapter(Context context, String[] resource,String[] p,Integer[] i) {
        super(context,R.layout.home_custom,resource);
        this.ctx=context;
        this.name=resource;
        this.price=p;
        this.image=i;

    }*/

    public CustomhomeAdapter(Context context, List<EventzPojo> data) {
        super(context,R.layout.home_custom,data);
        this.ctx=context;
        this.list=data;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater.from(ctx));
        convertView=layoutInflater.inflate(R.layout.home_custom,null,false);
        txvw1=convertView.findViewById(R.id.title);
       // txvw1.setText(name[position]);
        txvw2=convertView.findViewById(R.id.price);
       // txvw2.setText(price[position]);
        imageView=convertView.findViewById(R.id.image12);
        //imageView.setImageResource(image[position]);
        EventzPojo id=list.get(position);
        String title=id.getP_title();
        txvw1.setText(title);
        String venue=id.getP_venue();
        txvw2.setText(venue);
        return convertView;
    }
}
