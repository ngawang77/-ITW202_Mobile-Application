package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        messageTextView = findViewById(R.id.textview);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        messageTextView.setText(message);

        Spinner spinner = findViewById(R.id.labels_spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, R.layout.support_simple_spinner_dropdown_item);
        if (spinner !=null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioClick(View view) {
        boolean isChecked = ((RadioButton)view).isChecked();

        switch (view.getId()) {
            case R.id.radio_btn1:
                displayToast(getString(R.string.same_day));
                break;

            case R.id.radio_btn2:
                displayToast(getString(R.string.next_day));
                break;

            case R.id.radio_btn3:
                displayToast(getString(R.string.pick_up));
                break;

            default:
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String mesg = parent.getItemAtPosition(position).toString();
        displayToast(mesg);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }
}