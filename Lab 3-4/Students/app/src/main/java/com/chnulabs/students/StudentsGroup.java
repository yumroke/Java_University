package com.chnulabs.students;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentsGroup {
    private String number;
    private String facultyName;
    private int educationLevel;
    private boolean contractExistFlg;
    private boolean privilageExistFlg;


    public StudentsGroup(String number,String facultyName,int educationLevel,
                         boolean contractExistFlg, boolean privilageExistFlg){
        this.number=number;
        this.facultyName=facultyName;
        this.educationLevel=educationLevel;
        this.contractExistFlg=contractExistFlg;
        this.privilageExistFlg=privilageExistFlg;
    }
    public String getNumber(){
        return number;
    }
    public String getFacultyName(){
        return facultyName;
    }
    public int getEducationLevel(){return educationLevel;}
    public boolean isContractExistFlg(){return contractExistFlg;}
    public boolean isPrivilageExistFlg(){return  privilageExistFlg;}
    private final static ArrayList<StudentsGroup> group = new ArrayList<StudentsGroup>(
            Arrays.asList(
                    new StudentsGroup("301","Комп'ютерних наук",0,true,false),
                    new StudentsGroup("302","Комп'ютерних наук",0,true,false),
                    new StudentsGroup("308","Комп'ютерних наук",0,true,true),
                    new StudentsGroup("309","Комп'ютерних наук",0,true,false),
                    new StudentsGroup("501m","Комп'ютерних наук",1,false,false)

            )
    );
    public static StudentsGroup getGroup(String groupNumber){
        for(StudentsGroup g:group){
            if(g.getNumber().equals(groupNumber)){
                return g;
            }
        }
        return null;
    }
}
