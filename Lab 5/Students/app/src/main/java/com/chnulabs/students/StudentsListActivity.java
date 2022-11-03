package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class StudentsListActivity extends AppCompatActivity {
    public static final String GROUP_NUMBER="groupnumber";
    private float textSize=0;
    private float maxtextSize=32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        Intent intent = getIntent();
        String grpNumber=intent.getStringExtra(GROUP_NUMBER);

        String txtStudents="";
        for (Student s:Student.getStudents(grpNumber)){
            txtStudents+=s.getName()+"\n";
        }

        TextView textView=(TextView) findViewById(R.id.text);
        textView.setText(txtStudents);

        textSize=textView.getTextSize();
        if (savedInstanceState !=null){
            textSize = savedInstanceState.getFloat("textSize");
        }

    }
    public void  onSendBtnClick(View view){
        TextView textView=(TextView) findViewById(R.id.text);

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT,"Список студентів");
        startActivity(intent);
    }
    public void onPlusBtnClick(View view) {
//            textSize = textSize * 1.1f;
        if(textSize <= 64f) {
            textSize = textSize * 1.1f;
        }
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }
}