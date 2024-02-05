package org.junior.lesson2.dz1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Animal[] animals = {new Cat("Barsik", "black", 2), new Dog("Reks", "grey", 3)};
        Class<?> personalClass = Class.forName("org.junior.lesson2.dz1.Animal");
        for (Animal animal : animals) {
            Field nameField = personalClass.getDeclaredField("name");
            System.out.println("Имя: " + nameField.get(animal));

            Field ageField = personalClass.getDeclaredField("age");
            System.out.println("Возраст: " + ageField.get(animal));

            ageField.set(animal, 20); // для тренировки
            System.out.println("Возраст: " + ageField.get(animal));

            Method voice = personalClass.getDeclaredMethod("makeSound"); //голос! будет разный
            voice.invoke(animal);
        }

    }
}
