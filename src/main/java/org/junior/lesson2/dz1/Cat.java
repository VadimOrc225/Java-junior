package org.junior.lesson2.dz1;

public class Cat extends Animal{
    private String color;
    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    @Override
    public void makeSound() {
        System.out.println(name + " say meow");
    }

}
