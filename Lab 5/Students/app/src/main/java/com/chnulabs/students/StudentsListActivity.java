package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StudentsListActivity extends AppCompatActivity {
    public static final String GROUP_NUMBER="groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);

        String txtStudents="";
        for (Student s: Student.getStudents(grpNumber)){
                txtStudents += s.getName() + "\n";
        }
        ListView listView = (ListView) findViewById(R.id.studentsList);
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(
                this, android.R.layout.simple_list_item_1,
                Student.getStudents(grpNumber)
        );
        listView.setAdapter(adapter);

    }
    public void onSendBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список студентів");
        startActivity(intent);
    }

}