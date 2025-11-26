package com.chnulabs.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.ShareActionProvider;

public class GroupsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);

        // Создание слушателя кликов
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Исправление ошибки кастинга: получаем StudentsGroup, а не String
                StudentsGroup group = (StudentsGroup) adapterView.getItemAtPosition(i);

                // Запуск активности детализации
                Intent intent = new Intent(GroupsListActivity.this, StudentsGroupActivity.class);
                intent.putExtra(StudentsGroupActivity.GROUP_NUMBER, group.getNumber());
                startActivity(intent);
            }
        };

        ListView listView = (ListView) findViewById(R.id.groups_list);
        listView.setOnItemClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Обновление списка при возвращении на экран
        ListView listView = (ListView) findViewById(R.id.groups_list);

        // Создание адаптера для коллекции StudentsGroup
        ArrayAdapter<StudentsGroup> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                StudentsGroup.getGroups() // Используем метод getGroups()
        );
        listView.setAdapter(adapter);
    }

    // --- Меню действий ---

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.groups_menu, menu);

        // 1. Логика для ShareActionProvider
        String text = "";
        for (StudentsGroup group : StudentsGroup.getGroups()) {
            text += group.getNumber() + "\n";
        }

        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Обработка клика по кнопке "Добавить группу" из меню
        if (item.getItemId() == R.id.action_add_group) {
            startActivity(new Intent(this, AddStudentsGroupActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}