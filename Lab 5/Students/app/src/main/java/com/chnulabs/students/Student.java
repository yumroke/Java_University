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
    private final static ArrayList<Student> students= new ArrayList<Student>(
            Arrays.asList(
               new Student("Калачов Євген","301"),
               new Student("Мартинова Ганна","301"),
               new Student("Сергєєва Поліна","302"),
               new Student("Білоусова Надія","302"),
               new Student("Тарасов Дмитро","308"),
               new Student("Соколов Олександр","308"),
               new Student("Скворцова Марія","309"),
               new Student("Агєєва Аліна","309")
            )
    );
    public static ArrayList<Student> getStudents(String groupNumber){
        ArrayList<Student> stList = new ArrayList<>();
        for (Student s: students){
            if(s.getGroupNumber().equals(groupNumber)){
                stList.add(s);
            }
        }
        return stList;
    }
    @Override
    public String toString(){
        return name;
    }

}
