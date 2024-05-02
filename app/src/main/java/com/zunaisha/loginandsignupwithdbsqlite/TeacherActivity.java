package com.zunaisha.loginandsignupwithdbsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zunaisha.loginandsignupwithdbsqlite.databinding.ActivityStudentBinding;
import com.zunaisha.loginandsignupwithdbsqlite.databinding.ActivityTeacherBinding;

public class TeacherActivity extends AppCompatActivity {
    ActivityTeacherBinding binding;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    TextView ViewTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        ViewTeacher = findViewById(R.id.ViewTeacher);

        EditText editTextTeacherName = findViewById(R.id.editTextTeacherName);
        EditText editTextTeacherDesignation = findViewById(R.id.editTextTeacherDesignation);
        EditText editTextTeacherCourse = findViewById(R.id.editTextTeacherCourse);
        EditText editTextTeacherPassword = findViewById(R.id.editTextTeacherPassword);

        Button buttonInsertTeacher = findViewById(R.id.buttonInsertTeacher);

        // Insert teacher data on button click
        buttonInsertTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teacherName = editTextTeacherName.getText().toString();
                String teacherDesignation = editTextTeacherDesignation.getText().toString();
                String teacherCourse = editTextTeacherCourse.getText().toString();
                String teacherPassword = editTextTeacherPassword.getText().toString();

                long result = databaseHelper.insertTeacherData(teacherName, teacherDesignation, teacherCourse, teacherPassword);
                if (result != -1) {
                    Toast.makeText(TeacherActivity.this, "Teacher data inserted successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TeacherActivity.this, "Failed to insert teacher data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.ViewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherActivity.this, ViewTeacherActivity.class);
                startActivity(intent);
            }
        });
    }
}