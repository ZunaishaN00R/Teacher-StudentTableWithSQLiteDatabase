package com.zunaisha.loginandsignupwithdbsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    Button mInsertStudent,mInsertTeacher,mViewStudent,mViewTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        mInsertStudent = findViewById(R.id.main_insert_student);
        mInsertTeacher = findViewById(R.id.main_insert_teacher);
        mViewStudent = findViewById(R.id.main_view_student);
        mViewTeacher = findViewById(R.id.main_view_teacher);

        mInsertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
        mInsertTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TeacherActivity.class);
                startActivity(intent);
            }
        });
        mViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewStudentActivity.class);
                startActivity(intent);
            }
        });
        mViewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewTeacherActivity.class);
                startActivity(intent);
            }
        });
    }
}