package com.example.a03_studentslist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student>{

    private LayoutInflater inflater;
    private int layout;
    private List<Student> students;

    public StudentAdapter(Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.students = students;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView surnameView = (TextView) view.findViewById(R.id.surname);
        TextView groupView = (TextView) view.findViewById(R.id.group);

        Student student = students.get(position);

        flagView.setImageResource(student.getFlagResource());
        nameView.setText(student.getName());
        surnameView.setText(student.getSurname());
        groupView.setText(student.getGroup());

        return view;
    }
}
