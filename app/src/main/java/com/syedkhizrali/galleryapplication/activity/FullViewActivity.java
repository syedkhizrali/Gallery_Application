package com.syedkhizrali.galleryapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.syedkhizrali.galleryapplication.R;

public class FullViewActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        int img_id = getIntent().getExtras().getInt("img_id");
        imageView.setImageResource(img_id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //method calls
        init();
        //method calls


    }

    private void init() {
        imageView = findViewById(R.id.img_full);
    }
}