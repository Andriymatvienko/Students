package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Метод для кнопки "Детальніше" (Навигация)
    public void onGrpBtnClick(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String grpNumber = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, StudentsGroupActivity.class);
        intent.putExtra(StudentsGroupActivity.GROUP_NUMBER, grpNumber);
        startActivity(intent);
    }

    // Метод для кнопки "ПОКАЗАТИ СПИСОК" (Заглушка)
    public void onBtnClick(View view) {
        Toast.makeText(this, "Список студентів не реалізовано (це інша лабораторна робота)", Toast.LENGTH_SHORT).show();
    }
}