package com.zunaisha.loginandsignupwithdbsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeacherAdapter  extends RecyclerView.Adapter<TeacherViewHolder> {
    Context context;
    List<TeacherItem> items;

    public TeacherAdapter(Context context, List<TeacherItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeacherViewHolder(LayoutInflater.from(context).inflate(R.layout.teacher_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        holder.teacherNameView.setText(items.get(position).getTeacherName());
        holder.teacherCourseView.setText(items.get(position).getTeacherCourse());
        holder.teacherDesignationView.setText(items.get(position).getTeacherDesignation());
        holder.teacherPasswordView.setText(items.get(position).getTeacherPassword());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
