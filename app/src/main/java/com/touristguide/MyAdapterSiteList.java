package com.touristguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public  class MyAdapterSiteList extends ArrayAdapter<TouristSiteDetail> {

    private final Context context;
    private final ArrayList<TouristSiteDetail> data;

    public MyAdapterSiteList(Context context, ArrayList<TouristSiteDetail> data) {
        super(context, R.layout.site_layout, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the item_card layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.site_layout, parent, false);

        // Get the TextView and ImageView
        TextView textView = view.findViewById(R.id.map_site_name);
        TextView categoryView = view.findViewById(R.id.map_site_category);
        ImageView imageView = view.findViewById(R.id.map_site_image);  // Get the ImageView by ID
        textView.setText(data.get(position).name);
        categoryView.setText(data.get(position).category);
        imageView.setImageResource(data.get(position).imageResourceId);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the car data (name) for the clicked position
                String siteName = data.get(position).name;
                String siteCategory = data.get(position).category;
                String siteDescription = data.get(position).description;
                String imageResourceId = String.valueOf(data.get(position).imageResourceId);

                Intent intent = new Intent(context, SiteDetail.class);

                intent.putExtra("siteName", siteName);
                intent.putExtra("siteCategory",siteCategory);
                intent.putExtra("siteDescription",siteDescription);
                intent.putExtra("imageResourceId",imageResourceId);

                context.startActivity(intent);
            }
        });
        return view;
    }
}
