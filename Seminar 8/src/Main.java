import java.util.*;

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class MyStack<T> {
    private List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

public class Main {

    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }

        return b;
    }

    public static int countElements(List<?> list) {
        return list.size();
    }

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T element : src) {
            dest.add(element);
        }
    }

    public static void main(String[] args) {

        System.out.println("1. Generic class");

        Box<Integer> intBox = new Box<>(10);
        System.out.println(intBox.getValue());

        intBox.setValue(20);
        System.out.println(intBox.getValue());

        Box<String> stringBox = new Box<>("Hello");
        System.out.println(stringBox.getValue());


        System.out.println("\n2. Generic method printTwice");

        printTwice(100);
        printTwice("Java");


        System.out.println("\n3. Bounded type max");

        System.out.println(max(10, 25));
        System.out.println(max("Ana", "Maria"));


        System.out.println("\n4. Count elements");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> names = Arrays.asList("Ana", "Maria", "Ion");

        System.out.println(countElements(numbers));
        System.out.println(countElements(names));


        System.out.println("\n5. Copy lists");

        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Number> destination = new ArrayList<>();

        copy(source, destination);

        System.out.println(destination);


        System.out.println("\n6. Generic Stack");

        MyStack<String> stack = new MyStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}