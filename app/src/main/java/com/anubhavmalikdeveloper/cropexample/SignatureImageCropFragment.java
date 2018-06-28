package com.anubhavmalikdeveloper.cropexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImageView;

import static android.app.Activity.RESULT_OK;

public class SignatureImageCropFragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 12;
    CropImageView cropImageView;
    Button saveBtn, retakeBtn;
    Activity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signature, container, false);

        openImagePicker();
        cropImageView = view.findViewById(R.id.cropImageView);
        saveBtn = view.findViewById(R.id.save_btn);
        retakeBtn = view.findViewById(R.id.clear_btn);

        retakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker();
            }
        });

//        activity = (Main2Activity)getContext();
//        Toast.makeText(activity, activity.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        return view;
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST) {
            if (resultCode == RESULT_OK) {
                //TODO: INTEGRATE IMAGE CROP.
                if (data != null && data.getData() != null) {
                    cropImageView.setAspectRatio(2,1);
                    cropImageView.setFixedAspectRatio(true);
                    cropImageView.setMaxCropResultSize(700, 350);
                    cropImageView.setMinCropResultSize(700,350);
                    cropImageView.setAutoZoomEnabled(false);
                    cropImageView.setImageUriAsync(data.getData());

                } else {
                    Toast.makeText(getContext(), "Oops something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        }
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//                Uri resultUri;
//                if (result != null && result.getUri() != null) {
//                    resultUri = result.getUri();
//
//                    Toast.makeText(getContext(), resultUri.toString(), Toast.LENGTH_SHORT).show();
////                    iv.setImageURI(resultUri);
//                }
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
////                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
    }
}

