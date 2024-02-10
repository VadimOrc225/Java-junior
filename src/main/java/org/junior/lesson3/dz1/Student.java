package org.junior.lesson3.dz1;

import java.io.*;

public class Student implements Serializable{
    String name;
    int age;
    transient double GPA;

    public Student (String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }



    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }


    }

