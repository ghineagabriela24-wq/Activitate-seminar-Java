public class Animal
{
    String name;
    int age;

    void sound()
    {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal
{
    void sound()
    {
        System.out.println("Dog barks");
    }
};

class Cat extends Animal
{
    void sound()
    {
        System.out.println("Cat meows");
    }
}