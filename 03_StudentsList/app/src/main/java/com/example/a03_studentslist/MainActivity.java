package com.example.a03_studentslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> students = new ArrayList();
    ListView studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();

        // получаем элемент ListView
        studentsList = (ListView) findViewById(R.id.studentsList);

        // создаем адаптер
        StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.list_item, students);

        // устанавливаем адаптер
        studentsList.setAdapter(studentAdapter);

        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                SparseBooleanArray sp= studentsList.getCheckedItemPositions();

                // получаем выбранный пункт
                Student selectedState = (Student)parent.getItemAtPosition(position);
            }
        };

        studentsList.setOnItemClickListener(itemListener);
    }

    private void setInitialData(){

        students.add(new Student ("Ivan","Suroviy", "IT", R.drawable.male ));
        students.add(new Student ("Elena","Troyanskay", "IT", R.drawable.female ));
        students.add(new Student ("Evgen","Baston", "IT", R.drawable.male ));
        students.add(new Student ("Kate","Velicaya", "IT", R.drawable.female ));
    }
}
