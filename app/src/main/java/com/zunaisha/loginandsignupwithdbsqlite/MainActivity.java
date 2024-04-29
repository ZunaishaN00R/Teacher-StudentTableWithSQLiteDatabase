package com.zunaisha.loginandsignupwithdbsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextClass, editTextCourse, editTextPassword;
    Button buttonInsert;
    TextView textViewData;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextClass = findViewById(R.id.editTextClass);
        editTextCourse = findViewById(R.id.editTextCourse);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonInsert = findViewById(R.id.buttonInsert);
        textViewData = findViewById(R.id.textViewData);
        databaseHelper = new DatabaseHelper(this);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String cclass = editTextClass.getText().toString();
                String course = editTextCourse.getText().toString();
                String password = editTextPassword.getText().toString();

                long result = databaseHelper.insertStudentData(name, cclass, course, password);
                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Data inserted successfully!", Toast.LENGTH_SHORT).show();
                    // Clear the EditText fields after insertion
                    editTextName.setText("");
                    editTextClass.setText("");
                    editTextCourse.setText("");
                    editTextPassword.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Failed to insert data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Cursor cursor = databaseHelper.getAllStudents();
        displayData(cursor);

    }
    private void displayData(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String cclass = cursor.getString(cursor.getColumnIndex("Class"));
                String course = cursor.getString(cursor.getColumnIndex("Course"));
                stringBuilder.append("Name: ").append(name).append(", Class: ").append(cclass).append(", Course: ").append(course).append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        textViewData.setText(stringBuilder.toString());
    }
}