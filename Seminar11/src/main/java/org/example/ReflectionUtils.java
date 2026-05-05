package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtils {

    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getSimpleName());

        if (clazz.getPackage() != null) {
            System.out.println("Package name: " + clazz.getPackage().getName());
        } else {
            System.out.println("Package name: default package");
        }

        System.out.println("Superclass: " + clazz.getSuperclass().getSimpleName());

        System.out.println("Implemented interfaces:");
        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> interfaceClass : interfaces) {
            System.out.println(interfaceClass.getSimpleName());
        }
    }

    public static void listFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Type: " + field.getType().getSimpleName());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println();
        }
    }

    public static void listMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getSimpleName());
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));

            System.out.print("Parameters: ");
            Class<?>[] parameters = method.getParameterTypes();

            for (Class<?> parameter : parameters) {
                System.out.print(parameter.getSimpleName() + " ");
            }

            System.out.println();
            System.out.println();
        }
    }

    public static Object createObjectDynamically(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    public static void callPublicMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        method.invoke(obj);
    }

    public static void accessPrivateField(Object obj, String fieldName, Object newValue) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        System.out.println("Old value: " + field.get(obj));

        field.set(obj, newValue);

        System.out.println("New value: " + field.get(obj));
    }

    public static void invokePrivateMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
    }

    public static Object createUsingConstructor(Class<?> clazz, Object... args) throws Exception {
        Class<?>[] parameterTypes = new Class<?>[args.length];

        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();

            if (parameterTypes[i] == Integer.class) {
                parameterTypes[i] = int.class;
            }

            if (parameterTypes[i] == Double.class) {
                parameterTypes[i] = double.class;
            }
        }

        Constructor<?> constructor = clazz.getConstructor(parameterTypes);
        return constructor.newInstance(args);
    }

    public static void inspect(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        System.out.println("Inspecting object of class: " + clazz.getSimpleName());

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            System.out.println(field.getName() + " = " + field.get(obj));
        }
    }
}