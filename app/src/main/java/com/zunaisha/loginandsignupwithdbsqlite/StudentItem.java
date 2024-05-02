package com.zunaisha.loginandsignupwithdbsqlite;

public class StudentItem {
    String studentName;
    String studentClass;
    String studentCourse;
    String studentPassword;

    public StudentItem(String studentName, String studentClass, String studentCourse, String studentPassword) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentCourse = studentCourse;
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
