package org.junior.lesson3.dz1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.*;

public class Student2 implements Externalizable {
    String name;
    int age;
    transient double GPA;

    public Student2(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student2() {

    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    @JsonIgnore
    public double getGPA() {
        return GPA;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(GPA);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        GPA = in.readDouble();
    }
}
