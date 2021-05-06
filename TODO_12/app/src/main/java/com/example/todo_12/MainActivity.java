package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Donut(View view) {
        Toast.makeText(this,"You ordered a Donut.", Toast.LENGTH_SHORT).show();
    }

    public void IceCream(View view) {
        Toast.makeText(this,"You ordered an Ice cream.", Toast.LENGTH_SHORT).show();
    }

    public void Foryo(View view) {
        Toast.makeText(this,"You ordered a Foryo.", Toast.LENGTH_SHORT).show();
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 17936253"));
        startActivity(intent);
    }
}