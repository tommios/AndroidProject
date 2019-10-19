package com.example.a03_studentslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent; // подключаем класс Intent
import android.view.View; // подключаем класс View для обработки нажатия кнопки
import android.widget.EditText; // подключаем класс EditText
import android.widget.RadioButton;
import android.widget.TextView;


public class AddActivity extends AppCompatActivity {

    public final static String ADD_MESSAGE_Name = "ADD_MESSAGE_Name";
    public final static String ADD_MESSAGE_Surname = "ADD_MESSAGE_Surname";
    public final static String ADD_MESSAGE_Group = "ADD_MESSAGE_Group";
    public final static String ADD_MESSAGE_Male = "ADD_MESSAGE_Male";
    String messageMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    // Метод обработки нажатия на кнопку
    public void addMessage(View view) {
        // действия, совершаемые после нажатия на кнопку
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, MainActivity.class);

        // Получаем текстовое поле в текущей Activity
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        EditText editTextGroup = (EditText) findViewById(R.id.editTextGroup);

        // Получаем текст из текстовых полей
        String messageName = editTextName.getText().toString();
        String messageSurname = editTextSurname.getText().toString();
        String messageGroup = editTextGroup.getText().toString();

        // Добавляем с помощью свойства putExtra объект -
        // первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(ADD_MESSAGE_Name, messageName);
        intent.putExtra(ADD_MESSAGE_Surname, messageSurname);
        intent.putExtra(ADD_MESSAGE_Group, messageGroup);
        intent.putExtra(ADD_MESSAGE_Male, messageMale);

        // запуск activity
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();

        // Получаем нажатый переключатель
        switch (view.getId()) {
            case R.id.radioButtonMale:
                if (checked) {
                    messageMale = "Male";
                }
                break;
            case R.id.radioButtonFemale:
                if (checked) {
                    messageMale = "Female";
                }
                break;
        }
    }
}
