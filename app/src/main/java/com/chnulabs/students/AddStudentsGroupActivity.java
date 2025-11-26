package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudentsGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_group);
    }

    // Метод для кнопки "ОК" (Добавление группы)
    public void onGrpAddClick(View view) {
        EditText number = (EditText) findViewById(R.id.addGroupNumber);
        EditText faculty = (EditText) findViewById(R.id.addFaculty);

        // Добавление новой группы (с дефолтными значениями для новых полей)
        StudentsGroup.addGroup(
                new StudentsGroup(
                        number.getText().toString(),
                        faculty.getText().toString(),
                        0, // educationLevel = 0 (Бакалавр)
                        false, // contractExistsFlg
                        false  // privilegeExistsFlg
                )
        );

        // Возвращение к родительской активности (GroupsListActivity)
        NavUtils.navigateUpFromSameTask(this);
    }
}