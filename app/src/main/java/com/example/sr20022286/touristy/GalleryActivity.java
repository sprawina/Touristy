package com.example.sr20022286.touristy;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));

        getIncomingIntent();

    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("imageUrl") && getIntent().hasExtra("imageName")){

            String img_url = getIntent().getStringExtra("imageUrl");
            String img_name = getIntent().getStringExtra("imageName");

            setImage(img_url,img_name);
        }
    }

    private void setImage(String img_url ,String img_name){

        TextView name = findViewById(R.id.img_desc);
        name.setText(img_name);

        ImageView image = findViewById(R.id.img);

        Glide.with(this)
                .asBitmap()
                .load(img_url)
                .into(image);

    }
}
