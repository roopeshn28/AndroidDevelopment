package com.example.task5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button capturebtn,detectbtn;
    private ImageView imageView;
    private TextView textView;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capturebtn=findViewById(R.id.capture_image);
        detectbtn=findViewById(R.id.detect_text_image);
        imageView=findViewById(R.id.image_view);
        textView=findViewById(R.id.text_display);

        capturebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              dispatchTakePictureIntent();
              textView.setText("");
            }
        });
        detectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                detectTextFromImage();
            }
        });
    }


    private void dispatchTakePictureIntent()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void detectTextFromImage()
    {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(imageBitmap);
        FirebaseVisionTextDetector FirebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector;
        FirebaseVisionTextDetector.detectInImage(FirebaseVisionImage).addOnSuccessListener(new View.OnSuccessListener(){
        @Override
        public void onSuccess (FirebaseVisionText firebaseVisionText)
        {
          displayTextFromImage(firebaseVisionText);
        }
    }).addOnFailureListener(new OnFailureListener(){
        @Override
         public void onFailure(@NonNull Exception e)
        {
            Toast.makeText(context:MainActivity.this, text:"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.d("Error: ",getMessage());
        }

    });
    }

    private void displayTextFromImage(FirebaseVisionText firebaseVisionText)
    {
        List<FirebaseVisionText.Block>blockList=FirebaseVisionText.getBlocks();
        if(blockList.size == 0)
        {
            Toast.makeText(this, "no text found in image.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            for (FirebaseVisionText.Block : firebaseVisionText.getBlocks())
            {
                String text=block.getText();
                textView.setText(text);
            }
        }
    }

}