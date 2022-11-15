package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentsGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_group);
    }
    public void onGrpAddClick(View view){
        EditText number = (EditText) findViewById(R.id.addGroupNumber);
        EditText faculty = (EditText) findViewById(R.id.addFaculty);

        Intent intent = NavUtils.getParentActivityIntent(this);

        SQLiteOpenHelper sqliteHelper = new StudentsDatabaseHelper(this);
        try {
            SQLiteDatabase db = sqliteHelper.getReadableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("number", number.getText().toString());
            contentValues.put("facultyName", faculty.getText().toString());
            contentValues.put("educationLevel", 0);
            contentValues.put("contractExistsFlg", 0);
            contentValues.put("privilageExistsFlg", 0);

            db.insert("Groups", null, contentValues);
            db.close();
            Toast toast = Toast.makeText(this, "Group have been successfully added",Toast.LENGTH_SHORT);
            toast.show();
            NavUtils.navigateUpTo(this, intent);
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}