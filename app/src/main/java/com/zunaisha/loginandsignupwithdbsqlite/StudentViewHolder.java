package com.zunaisha.loginandsignupwithdbsqlite;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    ImageView studentImageView;
    TextView studentNameView,studentCourseView,studentClassView,studentPasswordView;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        studentImageView = itemView.findViewById(R.id.student_image_view);
        studentNameView = itemView.findViewById(R.id.student_name);
        studentCourseView = itemView.findViewById(R.id.student_course);
        studentClassView = itemView.findViewById(R.id.student_class);
        studentPasswordView = itemView.findViewById(R.id.student_password);
    }
}
