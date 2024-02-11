package org.junior.lesson3.dz1;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Dz3Task2Var2 {
    public static void main(String[] args) throws IOException {

        StudentVar2 studentForSave = new StudentVar2("Ivan", 22, 4.2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentVar2.bin"))) {
            oos.writeObject(studentForSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentVar2 studentForLoad = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studentVar2.bin"))) {
            studentForLoad = (StudentVar2) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(studentForSave);
        System.out.println(studentForLoad);
        // Поле GPA инициализируется 0.0 потому что оно transient - не сериализуется.

        // Для json файла
        JsonMapper objectMapper = new JsonMapper();
        File fileJson = new File("studentVar2.json");

        StudentVar2 studentForSaveJson = new StudentVar2("Oleg", 19, 4.5);
        objectMapper.writeValue(fileJson, studentForSaveJson);
        StudentVar2 studentForLoadJson = objectMapper.readValue(fileJson, StudentVar2.class);

        System.out.println(studentForSaveJson);
        System.out.println(studentForLoadJson);


        // Для xml файла
        XmlMapper xmlMapper = new XmlMapper();
        File fileXml = new File("studentVar2.xml");

        StudentVar2 studentForSaveXml = new StudentVar2("Andrey", 21, 3.9);
        xmlMapper.writeValue(fileXml, studentForSaveXml);
        StudentVar2 studentForLoadXml = xmlMapper.readValue(fileXml, StudentVar2.class);

        System.out.println(studentForSaveXml);
        System.out.println(studentForLoadXml);

    }
}