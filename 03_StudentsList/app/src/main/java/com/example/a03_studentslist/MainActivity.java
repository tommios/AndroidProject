package com.example.a03_studentslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student> students = new ArrayList();
    ListView studentsList;
    StudentAdapter adapter;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();


        // создаем адаптер
        adapter = new StudentAdapter(this, R.layout.list_item, students);

        // получаем элемент ListView
        studentsList = (ListView) findViewById(R.id.studentsList);

        // устанавливаем адаптер
        studentsList.setAdapter(adapter);
    }

    public void onClickAdd(View view){

        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, AddActivity.class);
        // запуск activity
        startActivity(intent);

        // Получаем сообщение из объекта intent

        String msgName = intent.getStringExtra(AddActivity.ADD_MESSAGE_Name);
        String msgSurname = intent.getStringExtra(AddActivity.ADD_MESSAGE_Surname);
        String msgGroup = intent.getStringExtra(AddActivity.ADD_MESSAGE_Group);
        String msgMale = intent.getStringExtra(AddActivity.ADD_MESSAGE_Male);
        String temp = null;
        if(msgMale=="Male") {temp="male";}
        else {temp="female";}

        if(temp != null) {

            students.add(new Student(msgName, msgSurname, msgGroup, R.drawable.male, false));
        }


    }

    public void onClickRemove(View view){

        for (int i=0; i < students.size(); i++) {
            // если отмечен флажком
            if(adapter.getItem(i).getBox()) adapter.remove(students.get(i));

        }

        adapter.notifyDataSetChanged();
    }

    private void setInitialData(){

        students.add(new Student ("Ivan","Suroviy", "IT", R.drawable.male, false ));
        students.add(new Student ("Elena","Troyanskay", "IT", R.drawable.female , false ));
        students.add(new Student ("Evgen","Baston", "IT", R.drawable.male , false ));
        students.add(new Student ("Kate","Velicaya", "IT", R.drawable.female , false ));

    }
}
