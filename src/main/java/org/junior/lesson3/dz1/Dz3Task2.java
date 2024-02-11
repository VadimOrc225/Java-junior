package org.junior.lesson3.dz1;

import java.io.File;

import static org.junior.lesson3.dz1.Model.*;

public class Dz3Task2 {
/*
       Задача 2*
       СЕРИАЛИЗАЦИЯ СТУДЕНТА ВТОРОЙ ВАРИАНТ

*/

    public static void main(String[] args) {

        File f = new File(FILE_JSON);
        Student2 student = new Student2("Олег", 21, 4.4);
        if (f.exists() && !f.isDirectory()) {
            Student2 studentForLoad = null;
            studentForLoad = loadFromFile(FILE_JSON);
            System.out.println("Объект Student десериализован!");
            System.out.println("Имя: " + studentForLoad.getName());
            System.out.println("Возраст: " + studentForLoad.getAge());
            System.out.println("Средний балл: " + studentForLoad.getGPA());
        } else {


            System.out.println("Имя: " + student.getName());
            System.out.println("Возраст: " + student.getAge());
            System.out.println("Средний балл: " + student.getGPA());
            saveToFile(FILE_JSON, student);
            saveToFile(FILE_BIN, student);
            saveToFile(FILE_XML, student);
            System.out.println("Объект Student сериализован!");
        }

    }
}
