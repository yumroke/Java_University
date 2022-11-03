package com.chnulabs.students;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private String groupNumber;

    public Student(String name, String groupNumber){
        this.name=name;
        this.groupNumber=groupNumber;
    }
    public String getName(){
        return name;
    }
    public String getGroupNumber(){
        return groupNumber;
    }
    private  final static ArrayList<Student> students=new ArrayList<Student>(
            Arrays.asList(
                    new Student("Сурков Ігор","301"),
                    new Student("Шевченко Данило","301"),
                    new Student("Фаріон Іван","301"),
                    new Student("Таран Максим","301"),
                    new Student("Іван Іванов","302"),
                    new Student("Васильєв Максим","302"),
                    new Student("Смірнов Кирило","308"),
                    new Student("Петренко Семен","309")
            )
    );

    public static ArrayList<Student> getStudents(String groupNumber) {
        ArrayList<Student> stList=new ArrayList<>();
        for (Student s:students){
            if (s.getGroupNumber().equals(groupNumber)){
                stList.add(s);
            }
        }
        return stList;
    }
}
