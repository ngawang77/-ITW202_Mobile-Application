package com.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks,editTextId;
    Button btnAddBtn;
    Button view;
    Button update;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.fname);
        editSurname = findViewById(R.id.lname);
        editMarks = findViewById(R.id.marks);
        editTextId = findViewById(R.id.IDnumber);
        btnAddBtn = findViewById(R.id.button);
        view = findViewById(R.id.button2);
        update = findViewById(R.id.button3);
        delete = findViewById(R.id.button4);
    }

    public void AddData(View view){
        boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString() );
        if(isInserted == true)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

    }

    public void ViewAll(View view){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0){
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Student Id : "+ res.getString(0)+"\n");
            buffer.append("Frist Name : "+ res.getString(1)+"\n");
            buffer.append("Last Name : "+ res.getString(2)+"\n");
            buffer.append("ITW202 Marks : "+ res.getString(3)+"\n");
        }

        showMessage("List of Students", buffer.toString());
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateAll(View view) {
        boolean isUpdate = myDb.updateDate(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(), editMarks.getText().toString());
        if(isUpdate == true){
            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteAll(View view) {
        Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
        if(deleteRows > 0)
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
    }
}