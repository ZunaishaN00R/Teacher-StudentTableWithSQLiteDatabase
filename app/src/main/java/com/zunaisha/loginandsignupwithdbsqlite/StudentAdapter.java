package com.zunaisha.loginandsignupwithdbsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    Context context;
    List<StudentItem> items;

    public StudentAdapter(Context context, List<StudentItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.student_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentholder, int studentposition) {
        studentholder.studentNameView.setText(items.get(studentposition).getStudentName());
        studentholder.studentCourseView.setText(items.get(studentposition).getStudentCourse());
        studentholder.studentClassView.setText(items.get(studentposition).getStudentClass());
        studentholder.studentPasswordView.setText(items.get(studentposition).getStudentPassword());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
