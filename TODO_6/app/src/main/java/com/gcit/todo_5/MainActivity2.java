package com.gcit.todo_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_replyMessage = "com.example.todo_5Reply";
    private EditText reply_Message;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent obj = getIntent();
        String messege = obj.getStringExtra(MainActivity.EXTRA_message);
        TextView txt = findViewById(R.id.display_messege);
        txt.setText(messege);
        reply_Message = findViewById(R.id.txt_reply);

    }
    public void Reply(View view){
        Intent obj1 = new Intent();
        String mssg_reply = reply_Message.getText().toString();
        obj1.putExtra(EXTRA_replyMessage, mssg_reply);
        setResult(RESULT_OK, obj1);
        finish();
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
}