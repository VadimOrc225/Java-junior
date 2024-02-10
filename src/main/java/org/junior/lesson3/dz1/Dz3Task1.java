package org.junior.lesson3.dz1;

import java.io.IOException;
import java.io.*;

public class Dz3Task1 {
    /*
           Задача 1
           СЕРИАЛИЗАЦИЯ СТУДЕНТА ПЕРВЫЙ ВАРИАНТ

    */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Олег", 21, 4.4);

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл : " + student.getGPA());
        try (FileOutputStream fileOut = new FileOutputStream("studentdata.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(student);
            System.out.println("Объект Student сериализован!");
        }

        try (FileInputStream fileIn = new FileInputStream("studentdata.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            student = (Student)in.readObject();
            System.out.println("Объект Student десериализован!");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл (Поля, помеченные ключевым словом transient, не сериализуются.): " + student.getGPA());



    }
}
