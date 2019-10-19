package com.example.a03_studentslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.ArrayList;
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

    // кол-во студентов
    @Override
    public int getCount() {
        return students.size();
    }

    // элемент по позиции
    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    public View getView(int position, View convertView, ViewGroup parent) {

        // используем созданные, но не используемые view
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(this.layout, parent, false);
        }
        //View view=inflater.inflate(this.layout, parent, false);

        Student student = getStudent(position);


        ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView surnameView = (TextView) view.findViewById(R.id.surname);
        TextView groupView = (TextView) view.findViewById(R.id.group);

        // заполняем View в пункте списка данными студентов: иконка, Имя, Фамилия, Группа
        flagView.setImageResource(student.getFlagResource());
        nameView.setText(student.getName());
        surnameView.setText(student.getSurname());
        groupView.setText(student.getGroup());

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);

        // присваиваем чекбоксу обработчик
        checkBox.setOnCheckedChangeListener(myCheckChangeList);

        // пишем позицию
        checkBox.setTag(position);

        // заполняем данными
        checkBox.setChecked(student.box);

        return view;
    }

    // Студент по позиции
    Student getStudent(int position) {
        return ((Student) getItem(position));
    }

    // обработчик для чекбоксов
    OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            getStudent((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
