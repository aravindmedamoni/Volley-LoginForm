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

import com.example.medamoniaravind.volley.R;

public class CustomMyticketsAdapter extends ArrayAdapter {
    Context ctx1;
    String[] event,cost;
    Integer[] image21;
    ImageView img;
    TextView mytv1,mytv2;

    public CustomMyticketsAdapter(Context context, String[] t1, String[] t2, Integer[] image1) {
        super(context,R.layout.mytickets_custom,t1);
        this.ctx1=context;
        this.event=t1;
        this.cost=t2;
        this.image21=image1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater.from(ctx1));
        convertView=layoutInflater.inflate(R.layout.mytickets_custom,null,false);
        img=convertView.findViewById(R.id.image11);
        img.setImageResource(image21[position]);
        mytv1=convertView.findViewById(R.id.mttv1);
        mytv1.setText(event[position]);
        mytv2=convertView.findViewById(R.id.mttv2);
        mytv2.setText(cost[position]);
        return convertView;
    }
}
