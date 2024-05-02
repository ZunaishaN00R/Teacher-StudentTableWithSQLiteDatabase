package com.zunaisha.loginandsignupwithdbsqlite;

public class TeacherItem {
    String teacherName;
    String teacherDesignation;
    String teacherCourse;
    String teacherPassword;
    public TeacherItem(String teacherName, String teacherDesignation, String teacherCourse, String teacherPassword) {
        this.teacherName = teacherName;
        this.teacherDesignation = teacherDesignation;
        this.teacherCourse = teacherCourse;
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDesignation() {
        return teacherDesignation;
    }

    public void setTeacherDesignation(String teacherDesignation) {
        this.teacherDesignation = teacherDesignation;
    }

    public String getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(String teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
