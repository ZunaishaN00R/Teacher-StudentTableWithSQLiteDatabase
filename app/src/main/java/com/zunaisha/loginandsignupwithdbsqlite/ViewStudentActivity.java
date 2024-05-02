package com.zunaisha.loginandsignupwithdbsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewStudentActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private StudentAdapter adapter;
    private List<StudentItem> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        databaseHelper = new DatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.student_recycler_view);

//        View recyclerView = findViewById(R.id.student_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(adapter);

        loadStudentData();
    }

    private void loadStudentData() {
        Cursor cursor = databaseHelper.getAllStudents();
        if (cursor.moveToFirst()) {
            do {
                String studentName;
                String studentClass;
                String studentCourse;
                String studentPassword;
                studentName = cursor.getString(cursor.getColumnIndex("Name"));

                studentClass = cursor.getString(cursor.getColumnIndex("Class"));

                studentCourse = cursor.getString(cursor.getColumnIndex("Course"));

                studentPassword = cursor.getString(cursor.getColumnIndex("Password"));

                StudentItem studentItem = new StudentItem(studentName, studentClass, studentCourse, studentPassword);
                studentList.add(studentItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}