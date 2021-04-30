package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class categoryQuiz extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgC,imgJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_quiz);
        imgC=findViewById(R.id.imgC);
        imgC.setOnClickListener(this);
        imgJava=findViewById(R.id.imgJava);
        imgJava.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imgC:
                Intent intent=new Intent(categoryQuiz.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.imgJava:
                Intent intent1=new Intent(categoryQuiz.this,JavaQuiz.class);
                startActivity(intent1);
                break;

        }

    }
}