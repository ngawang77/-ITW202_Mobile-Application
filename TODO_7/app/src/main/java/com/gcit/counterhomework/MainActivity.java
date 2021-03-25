package com.gcit.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int number;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);

        if(savedInstanceState != null){
            number = savedInstanceState.getInt("count_number");
            count.setText(String.valueOf(number));
        }
    }
    public void Count(View view){
        number++;
        count.setText(""+number);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("count_number", number);
    }
}