package com.example.pokemon_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void botaoGeodude (View view)
    {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);

    }
}
