package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudentsGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_group);
    }

    public void onGrpAddClick(View view) {
        EditText number = findViewById(R.id.addGroupNumber);
        EditText faculty = findViewById(R.id.addFaculty);

        StudentsGroup.addGroup(
                new StudentsGroup(
                        number.getText().toString(),
                        faculty.getText().toString(),
                        0, // Бакалавр
                        false,
                        false
                )
        );

        // ГАРАНТИРОВАННЫЙ ВОЗВРАТ
        finish();
    }
}