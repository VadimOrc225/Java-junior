package org.junior.lesson3.dz1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junior.lesson3.dz1.Model.*;

public class Dz3Task2 {
/*
       Задача 2*
       СЕРИАЛИЗАЦИЯ СТУДЕНТА ВТОРОЙ ВАРИАНТ

*/

    public static void main(String[] args) {
        List<Student2> students = new ArrayList<>();
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            students = loadFromFile(FILE_JSON);
            System.out.println("Объект Student десериализован!");

        } else {

            students.add(new Student2("Олег", 21, 4.4));
            students.add(new Student2("Макс", 20, 4.5));
            students.add(new Student2("Гриша", 20, 4.3));
//            System.out.println("Имя: " + student.getName());
//            System.out.println("Возраст: " + student.getAge());
//            System.out.println("Средний балл: " + student.getGPA());
            saveToFile(FILE_JSON, students);
            saveToFile(FILE_BIN, students);
            saveToFile(FILE_XML, students);
            System.out.println("Объект Student сериализован!");
        }
        displayStudents(students);
    }
}
