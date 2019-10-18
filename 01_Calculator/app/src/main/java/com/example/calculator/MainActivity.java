package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultField; // текстовое поле для вывода результата
    TextView numberField; // текстовое поле для вывода результата
    Double operand = null;  // операнд операции
    String lastOperation = "="; // последняя операция

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем все поля по id из activity_main.xml
        resultField = (TextView) findViewById(R.id.resultField);
        numberField = (TextView) findViewById(R.id.numberField);
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        numberField.setText(lastOperation);
    }

    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view) {
        Button button = (Button) view;
        numberField.append(button.getText());
        if (lastOperation.equals("=") && operand != null) {
            operand = null;
        }
    }

    // обработка нажатия на кнопку-разделитель разрядов
    public void onPointClick(View view) {
        Button button = (Button) view;
        numberField.append(button.getText());
    }

    // обработка нажатия на кнопку знака плюс-минус числа
    public void onPlusMinusClick(View view) {
        Button button = (Button) view;
        String number = numberField.getText().toString();
        if (number.substring(0, 1).equals("-")) {
            number = number.substring(1);
        } else {
            number = "-" + number;
        }
        numberField.setText(number);


    }

    // обработка нажатия на кнопку операции
    public void onOperationClick(View view) {

        Button button = (Button) view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        // если введенно что-нибудь
        if (number.length() > 0) {
            if (lastOperation.equals("=")) number = number.substring(0);
            else number = number.substring(1);
            try {
                performOperation(Double.valueOf(number), op);
            } catch (NumberFormatException ex) {
                numberField.setText("");
            }
        }
        lastOperation = op;
        numberField.setText(lastOperation);
    }

    public void onDeleteClick(View view) {
        Button button = (Button) view;
        resultField = (TextView) findViewById(R.id.resultField);
        numberField = (TextView) findViewById(R.id.numberField);
        String temp = button.getText().toString();

        switch (temp) {
            case "C":
                numberField.setText("");
                resultField.setText("");
                operand = null;
                break;
            case "<-":
                String str = numberField.getText().toString();
                if (str != null && str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                numberField.setText(str);
                break;
        }
    }

    private void performOperation(Double number, String operation) {

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if (operand == null) {
            operand = number;
        } else {
            if (lastOperation.equals("=")) {
                lastOperation = operation;
            }
            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
            }
        }
        resultField.setTextSize(28);
        resultField.setText(operand.toString());    //.replace('.', ','));
        numberField.setText("");
    }

}
