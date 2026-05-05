package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            System.out.println("1. Class information");
            ReflectionUtils.printClassInfo(studentClass);

            System.out.println();

            System.out.println("2. List all fields");
            ReflectionUtils.listFields(studentClass);

            System.out.println("3. List all methods");
            ReflectionUtils.listMethods(studentClass);

            System.out.println("4. Create object dynamically");
            Object obj = ReflectionUtils.createObjectDynamically(studentClass);
            System.out.println(obj);

            System.out.println();

            System.out.println("5. Call public method");
            ReflectionUtils.callPublicMethod(obj, "sayHello");

            System.out.println();

            System.out.println("6. Access private field");
            ReflectionUtils.accessPrivateField(obj, "name", "Ana");

            System.out.println();

            System.out.println("7. Invoke private method");
            ReflectionUtils.invokePrivateMethod(obj, "secretMethod");

            System.out.println();

            System.out.println("8. Constructor selection");
            Student s1 = (Student) ReflectionUtils.createUsingConstructor(Student.class);
            Student s2 = (Student) ReflectionUtils.createUsingConstructor(Student.class, "Maria");
            Student s3 = (Student) ReflectionUtils.createUsingConstructor(Student.class, "Ion", 22);

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);

            System.out.println();

            System.out.println("9. Object inspector");
            ReflectionUtils.inspect(s3);

            System.out.println();

            System.out.println("10. JSON serializer");
            String json = JsonSerializer.toJson(s3);
            System.out.println(json);

            System.out.println();

            System.out.println("11. CSV mapper");
            String header = "name,age,grade";
            String values = "Elena,20,9.75";

            Student csvStudent = CsvMapper.fromCsv(header, values, Student.class);
            System.out.println(csvStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}