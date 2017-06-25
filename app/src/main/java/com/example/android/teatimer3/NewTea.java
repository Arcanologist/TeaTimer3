package com.example.android.teatimer3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewTea extends AppCompatActivity {
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityNewTeaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_new_tea);  //niedziajce smieci
        setContentView(R.layout.activity_new_tea);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveToDB();
                //Toast.makeText(getApplicationContext(), "Button", Toast.LENGTH_LONG).show();
            }
        });



    }




    private void saveToDB() {
        SQLiteDatabase database = new DBSQLiteHelper(this).getWritableDatabase();
        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editTemp = (EditText) findViewById(R.id.editTemp);
        EditText editTime = (EditText) findViewById(R.id.editTime);

        ContentValues values = new ContentValues();
        values.put(DB.Tea.COLUMN_NAME, editName.getText().toString());
        values.put(DB.Tea.COLUMN_TEMP, editTemp.getText().toString());

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((new SimpleDateFormat("m/s")).parse(
                    editTime.getText().toString()));
            long date = calendar.getTimeInMillis();
            values.put(DB.Tea.COLUMN_TIME, date);
        }
        catch (Exception e) {
            Log.e("newTea", "Error", e);
            Toast.makeText(this, "Time is in the wrong format", Toast.LENGTH_LONG).show();
            return;
        }
        database.insert(DB.Tea.TABLE_NAME, null, values);
        Toast.makeText(this, "New tea added", Toast.LENGTH_LONG).show();

    }
}
