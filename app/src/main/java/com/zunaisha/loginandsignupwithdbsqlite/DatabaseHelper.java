package com.zunaisha.loginandsignupwithdbsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "university.db";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating student table
        String createStudentTable = "CREATE TABLE student (" +
                "uid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "Class TEXT," +
                "Course TEXT," +
                "Password TEXT)";
        db.execSQL(createStudentTable);

        // Creating teacher table
        String createTeacherTable = "CREATE TABLE teacher (" +
                "uid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "designation TEXT," +
                "course TEXT," +
                "password TEXT)";
        db.execSQL(createTeacherTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        db.execSQL("DROP TABLE IF EXISTS teacher");
        onCreate(db);
    }

    // Insert student data
    public long insertStudentData(String name, String cclass, String course, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Class", cclass);
        contentValues.put("Course", course);
        contentValues.put("Password", password);
        return db.insert("student", null, contentValues);
    }

    // Insert teacher data
    public long insertTeacherData(String name, String designation, String course, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Designation", designation);
        contentValues.put("Course", course);
        contentValues.put("Password", password);
        return db.insert("teacher", null, contentValues);
    }

    // Check if email exists in student or teacher table
    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE Name=?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor = db.rawQuery("SELECT * FROM teacher WHERE Name=?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    // Check email and password in student or teacher table
    public boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE Name=? AND Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor = db.rawQuery("SELECT * FROM teacher WHERE Name=? AND Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }
    // Retrieve all student data
    public Cursor getAllStudents() {
        SQLiteDatabase student_db = this.getReadableDatabase();
        return student_db.rawQuery("SELECT * FROM student", null);
    }

    // Retrieve all teacher data
    public Cursor getAllTeachers() {
        SQLiteDatabase teacher_db = this.getReadableDatabase();
        return teacher_db.rawQuery("SELECT * FROM teacher", null);
    }
}