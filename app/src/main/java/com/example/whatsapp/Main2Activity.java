package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
ImageView image_person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image_person=findViewById(R.id.image_person);
        Bundle extras = getIntent().getExtras();
        image_person.setImageResource(extras.getInt("image"));
    }
}
