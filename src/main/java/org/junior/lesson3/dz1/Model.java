package org.junior.lesson3.dz1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.List;


public class Model {
    public static final String FILE_JSON = "studentdata.json";
    public static final String FILE_BIN = "studentdata.bin";
    public static final String FILE_XML = "studentdata.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    public static void saveToFile(String fileName, Student2 student) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(student);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student2 loadFromFile(String fileName) {
//        List<Student2> students = new ArrayList<>();
        Student2 student = new Student2();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, Student2.class);
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                         student= (Student2) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, Student2.class);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return student;
    }
    public static void displayStudents(List<Student2> students) {
        System.out.println("Список студентов");
        for (int i = 0; i < students.size(); i++) {
            Student2 student = students.get(i);
            System.out.println("Имя: " + student.getName());
            System.out.println("Возраст: " + student.getAge());
            System.out.println("Средний балл: " + student.getGPA());
            System.out.println();
        }
    }
}
