package com.touristguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SiteDetail extends AppCompatActivity {
    private ImageView carImageView,backButton;
    private TextView siteNameView;
    private TextView siteCategoryView;
    private TextView siteDescriptionView,siteTitleView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_detail);
        // Get references to UI elements
        carImageView = findViewById(R.id.site_image_view);
        siteNameView = findViewById(R.id.site_title);
        siteCategoryView = findViewById(R.id.site_category);
        siteTitleView = findViewById(R.id.site_title2);
        siteDescriptionView = findViewById(R.id.site_description);
        backButton = findViewById(R.id.to_site_list);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("siteName")) {
            String siteName = intent.getStringExtra("siteName");
            String siteCategory = intent.getStringExtra("siteCategory");
            String siteDescription = intent.getStringExtra("siteDescription");
            int imageResourceId = Integer.parseInt(intent.getStringExtra("imageResourceId"));
            // Update UI elements with car data (replace with your logic)
            siteNameView.setText(siteName);
            siteTitleView.setText(siteName);
            siteCategoryView.setText(siteCategory);
            siteDescriptionView.setText(siteDescription);
            // You can also load car image based on car name here (replace with your logic)
            carImageView.setImageResource(imageResourceId); // Example for a specific car image
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiteDetail.this, SiteList.class);
                startActivity(intent);
            }
        });
    }
}


