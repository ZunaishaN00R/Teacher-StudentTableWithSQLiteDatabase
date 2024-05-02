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

public class StudentActivity extends AppCompatActivity {
    ActivityStudentBinding binding;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    TextView ViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_student);

        databaseHelper = new DatabaseHelper(this);
        ViewStudent = findViewById(R.id.ViewStudent);
        EditText editTextStudentName = findViewById(R.id.editTextStudentName);
        EditText editTextStudentClass = findViewById(R.id.editTextStudentClass);
        EditText editTextStudentCourse = findViewById(R.id.editTextStudentCourse);
        EditText editTextStudentPassword = findViewById(R.id.editTextStudentPassword);

        Button buttonInsertStudent = findViewById(R.id.buttonInsertStudent);


        buttonInsertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = editTextStudentName.getText().toString();
                String studentClass = editTextStudentClass.getText().toString();
                String studentCourse = editTextStudentCourse.getText().toString();
                String studentPassword = editTextStudentPassword.getText().toString();

                long result = databaseHelper.insertStudentData(studentName, studentClass, studentCourse, studentPassword);
                if (result != -1) {
                    Toast.makeText(StudentActivity.this, "Student data inserted successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StudentActivity.this, "Failed to insert student data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.ViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this, ViewStudentActivity.class);
                startActivity(intent);
            }
        });
    }

}






//
//
//public class StudentActivity extends AppCompatActivity {
//    ActivityStudentBinding binding;
//    private DatabaseHelper databaseHelper;
//    private RecyclerView recyclerView;
//    private StudentAdapter adapter;
//    private List<StudentItem> studentList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityStudentBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        databaseHelper = new DatabaseHelper(this);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        studentList = new ArrayList<>();
//        adapter = new StudentAdapter(this, studentList);
//        recyclerView.setAdapter(adapter);
//
//        loadStudentData();
//
//        // Other code remains the same
//    }
//
//    private void loadStudentData() {
//        Cursor cursor = databaseHelper.getAllStudents();
//        if (cursor.moveToFirst()) {
//            do {
//                String studentName = cursor.getString(cursor.getColumnIndex("Name"));
//                String studentClass = cursor.getString(cursor.getColumnIndex("Class"));
//                String studentCourse = cursor.getString(cursor.getColumnIndex("Course"));
//                String studentPassword = cursor.getString(cursor.getColumnIndex("Password"));
//
//                StudentItem studentItem = new StudentItem(studentName, studentClass, studentCourse, studentPassword);
//                studentList.add(studentItem);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        adapter.notifyDataSetChanged();
//    }
//
//    // Other code remains the same
//}
