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
    public static final String GROUP_NUMBER="groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group2);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        StudentsGroup group = StudentsGroup.getGroup(grpNumber);

        EditText txtGrpNumber = (EditText) findViewById(R.id.grpNumberEdit);
        txtGrpNumber.setText(group.getNumber());

        EditText txtFaculty = (EditText) findViewById(R.id.facultyEdit);
        txtFaculty.setText(group.getFacultyName());

        TextView txtImgGrpNumber = (TextView) findViewById(R.id.grpNumberImageText);
        txtImgGrpNumber.setText(group.getNumber());

        TextView  txtImgFaculty = (TextView) findViewById(R.id.facultyNameImageText);
        txtImgFaculty.setText(group.getFacultyName());

        if (group.getEducationLevel()==0){
            ((RadioButton) findViewById(R.id.edu_level_bachelor)).setChecked(true);
        }else {
            ((RadioButton) findViewById(R.id.edu_level_master)).setChecked(true);

        }
        ((CheckBox) findViewById(R.id.contract_flg)).setChecked(
                group.isContractExistFlg()
        );
        ((CheckBox) findViewById(R.id.privilege_flg)).setChecked(
                group.isPrivilageExistFlg()
        );
    }
    public void onOkBtnClick(View view){
        String outStirng= "Група "+((TextView) findViewById(R.id.grpNumberEdit)).getText()+"\n";
        outStirng += "Факультет "+((TextView) findViewById(R.id.facultyEdit)).getText()+"\n";
        if(((RadioButton) findViewById(R.id.edu_level_master)).isChecked()){
            outStirng += "рівень освіти "+"магістр\n";
        }else {
            outStirng += "рівень освіти "+"бакалавр\n";
        }

        if(((CheckBox) findViewById(R.id.contract_flg)).isChecked()){
            outStirng += "контрактники є\n";
        }else{
            outStirng += "контрактників нема\n";
        }

        if(((CheckBox) findViewById(R.id.privilege_flg)).isChecked()){
            outStirng += "є пільговики\n";
        }else{
            outStirng += "пільговиків нема\n";
        }
        Toast.makeText(this,outStirng, Toast.LENGTH_LONG).show();
    }
}