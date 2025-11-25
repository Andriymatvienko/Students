package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsGroupActivity extends AppCompatActivity {

    public static final String GROUP_NUMBER = "groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group); // Используем LinearLayout

        // Получение данных из Intent
        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        StudentsGroup group = StudentsGroup.getGroup(grpNumber);

        if (group != null) {
            // 1. Заполнение полей номеру группы и факультета (EditText)
            EditText txtGrpNumber = (EditText) findViewById(R.id.grpNumberEdit);
            txtGrpNumber.setText(group.getNumber());

            EditText txtFacultyName = (EditText) findViewById(R.id.facultyEdit);
            txtFacultyName.setText(group.getFacultyName());

            // 2. Заполнение полей поверх картинки (TextView)
            TextView txtImgGrp = (TextView) findViewById(R.id.grpNumberImageTxt);
            txtImgGrp.setText(group.getNumber());

            TextView txtImgFaculty = (TextView) findViewById(R.id.facultyNameImageTxt);
            txtImgFaculty.setText(group.getFacultyName());

            // 3. Заполнение RadioButton (Уровень образования)
            if (group.getEducationLevel() == 0) {
                ((RadioButton) findViewById(R.id.edu_level_bachelor)).setChecked(true);
            } else {
                ((RadioButton) findViewById(R.id.edu_level_master)).setChecked(true);
            }

            // 4. Заполнение CheckBox (Дополнительные сведения)
            ((CheckBox) findViewById(R.id.contract_flg)).setChecked(group.isContractExistsFlg());
            ((CheckBox) findViewById(R.id.privilege_flg)).setChecked(group.isPrivilegeExistsFlg());
        }
    }

    // Обработчик события для кнопки "ОК" (android:onClick="onOkBntClick")
    public void onOkBntClick(View view) {
        String outString = "Група " + ((TextView) findViewById(R.id.grpNumberEdit)).getText() + "\n";
        outString += "Факультет " + ((TextView) findViewById(R.id.facultyEdit)).getText() + "\n";

        // Уровень образования
        if (((RadioButton) findViewById(R.id.edu_level_master)).isChecked()) {
            outString += "Рівень освіти - магістр\n";
        } else {
            outString += "Рівень освіти - бакалавр\n";
        }

        // Контрактники
        if (((CheckBox) findViewById(R.id.contract_flg)).isChecked()) {
            outString += "Контрактники є\n";
        } else {
            outString += "Контрактників немає\n";
        }

        // Льготники
        if (((CheckBox) findViewById(R.id.privilege_flg)).isChecked()) {
            outString += "Пільговики є\n";
        } else {
            outString += "Пільговиків немає\n";
        }

        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();
    }
}