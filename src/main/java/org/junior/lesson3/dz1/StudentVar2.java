package org.junior.lesson3.dz1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class StudentVar2 implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public StudentVar2(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public StudentVar2() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    @JsonIgnore
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}