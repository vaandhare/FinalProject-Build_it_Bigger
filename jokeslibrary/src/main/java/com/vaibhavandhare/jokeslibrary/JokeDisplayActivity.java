package com.vaibhavandhare.jokeslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        TextView jokes = findViewById(R.id.tvJokALib_Joke);

        if (intent.hasExtra("jokes")) {
            jokes.setText(intent.getStringExtra("jokes"));
        } else {
            jokes.setText(R.string.joke_not_fount);
        }
    }
}
