package com.gcit.todo_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView HelloTextView;
    private String[] colorArray = {"blue", "purple_700", "red", "yellow","purple_200",
            "teal_200", "maroon", "lime","white", "teal_700", "purple_500"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloTextView = findViewById(R.id.hello_textview);

    }
    public void changeColor(View view){
        Random random = new Random();
        String colorName = colorArray[random.nextInt(11)];

        int colorResourceName = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        HelloTextView.setTextColor(colorRes);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("color",HelloTextView.getCurrentTextColor());
    }
}