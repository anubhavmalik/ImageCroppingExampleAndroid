package com.anubhavmalikdeveloper.cropexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.theartofdev.edmodo.cropper.CropImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new SignatureImageCropFragment())
                .commit();
    }
}
