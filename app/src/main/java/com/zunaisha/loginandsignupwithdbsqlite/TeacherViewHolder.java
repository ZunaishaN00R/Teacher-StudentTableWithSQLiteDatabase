package com.zunaisha.loginandsignupwithdbsqlite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TeacherViewHolder extends RecyclerView.ViewHolder {
    ImageView teacherImageView;
    TextView teacherNameView,teacherCourseView,teacherDesignationView,teacherPasswordView;
    public TeacherViewHolder(@NonNull View itemView) {
        super(itemView);
        teacherImageView = itemView.findViewById(R.id.teacher_image_view);
        teacherNameView = itemView.findViewById(R.id.teacher_name);
        teacherCourseView = itemView.findViewById(R.id.teacher_course);
        teacherDesignationView = itemView.findViewById(R.id.teacher_designation);
        teacherPasswordView = itemView.findViewById(R.id.teacher_password);
    }
}
