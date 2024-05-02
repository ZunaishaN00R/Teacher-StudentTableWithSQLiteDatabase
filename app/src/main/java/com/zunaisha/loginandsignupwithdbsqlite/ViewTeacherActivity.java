package com.zunaisha.loginandsignupwithdbsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewTeacherActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TeacherAdapter adapter;
    private List<TeacherItem> teacherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teacher);
        databaseHelper = new DatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.teacher_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teacherList = new ArrayList<>();
        adapter = new TeacherAdapter(this, teacherList);
        recyclerView.setAdapter(adapter);

        loadTeacherData();
    }

    private void loadTeacherData() {
        Cursor cursor = databaseHelper.getAllTeachers();
        if (cursor.moveToFirst()) {
            do {
                String teacherName;
                String teacherDesignation;
                String teacherCourse;
                String teacherPassword;
                teacherName = cursor.getString(cursor.getColumnIndex("Name"));

                teacherDesignation = cursor.getString(cursor.getColumnIndex("designation"));

                teacherCourse = cursor.getString(cursor.getColumnIndex("course"));

                teacherPassword = cursor.getString(cursor.getColumnIndex("password"));

                TeacherItem teacherItem = new TeacherItem(teacherName, teacherDesignation, teacherCourse, teacherPassword);
                teacherList.add(teacherItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}