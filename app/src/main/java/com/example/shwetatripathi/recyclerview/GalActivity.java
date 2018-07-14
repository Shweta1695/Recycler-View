package com.example.shwetatripathi.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalActivity extends AppCompatActivity{

    private static final String TAG="GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getIncomingIntent();
    }

    private void getIncomingIntent()
    {
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name"))
        {
            String imageURL=getIntent().getStringExtra("image_url");
            String imageName=getIntent().getStringExtra("image_name");
            setImage(imageURL,imageName);
        }
    }

    private void setImage(String imageURL,String imageName)
    {
        TextView name=findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image=findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(image);
    }
}
