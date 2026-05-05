package org.example;

public class Student implements Learner {
    private String name;
    private int age;
    public double grade;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.grade = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 0;
        this.grade = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grade = 0;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    private void secretMethod() {
        System.out.println("This is a private method.");
    }

    @Override
    public void study() {
        System.out.println(name + " is studying.");
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }
}