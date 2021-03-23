package com.gcit.todo_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "com.example.todo_5";
    private EditText send_Message;

    private static final String LOG_TAG = MainActivity2.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private TextView reply_header;
    private TextView reply_messege;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_Message = findViewById(R.id.txt_send);
        reply_header= findViewById(R.id.textView1);
        reply_messege = findViewById(R.id.display_reply);

    }
    public void Send(View v){
        Intent obj = new Intent(this,MainActivity2.class);
        String mssg = send_Message.getText().toString();
        obj.putExtra(EXTRA_message, mssg);
        startActivityForResult(obj, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String final_mssg = data.getStringExtra(MainActivity2.EXTRA_replyMessage);
                reply_header.setVisibility(View.VISIBLE);
                reply_messege.setText(final_mssg);
                reply_messege.setVisibility(View.VISIBLE);
            }
        }
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