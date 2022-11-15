package com.chnulabs.students;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Univer";
    private static final int DB_VERSION = 2;

    public StudentsDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlText = "CREATE TABLE Groups (\n" +
                "id                 INTEGER   PRIMARY KEY AUTOINCREMENT,\n" +
                "number             TEXT (10) NOT NULL,\n" +
                "facultyName        TIME (100),\n"+
                "educationLevel     INTEGER,\n"+
                "contractExistsFlg  BOOLEAN,\n"+
                "privilageExistsFlg BOOLEAN\n"+
                ");";
        sqLiteDatabase.execSQL(sqlText);

        updateShema(sqLiteDatabase, 0);

        populateDB(sqLiteDatabase);
    }

    private void populateDB(SQLiteDatabase db) {
        populiteGroups(db);
        populateStudent(db);
    }

    private void populiteGroups(SQLiteDatabase db) {
        for(StudentsGroup group: StudentsGroup.getGroups()) {
            insertRowToGroup(db, group);
        }
    }

    private void populateStudent(SQLiteDatabase db) {
        for(Student student: Student.getStudents()) {
            insertRowToStudent(db, student);
        }
    }

    private void  insertRowToGroup(SQLiteDatabase db, StudentsGroup group) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", group.getNumber());
        contentValues.put("facultyName", group.getFacultyName());
        contentValues.put("educationLevel", group.getEducationLevel());
        contentValues.put("contractExistsFlg", group.isContractExistsFlg());
        contentValues.put("privilageExistsFlg", group.isPrivilageExistsFlg());
        db.insert("Groups",null,contentValues);
    }

    private void insertRowToStudent(SQLiteDatabase db, Student student) {
        db.execSQL("insert into Students(name, group_id)\n" +
                "select'"+student.getName()+"', id\n" +
                "from groups\n" +
                "where number='" + student.getGroupNumber() +"'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {
        updateShema(sqLiteDatabase, oldV);
    }

    private void updateShema(SQLiteDatabase db, int oldV) {
        if(oldV < 2) {
            db.execSQL("CREATE TABLE Students (\n"+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, \n"+
                    "name TEXT(100) NOT NULL,\n"+
                    "group_id INTEGER REFERENCES Groups(id) ON DELETE RESTRICT\n"+
                    "ON UPDATE RESTRICT\n"+
                    ");"
            );
            populateStudent(db);
        }
    }
}