public class Main
{
    public static void main()
    {
//        Books book1 = new Books();
//        Books book2 = new Books("Amintiri din copilarie", "Ion Creanga", 300);
//        Dog d1 = new Dog();
//        d1.sound();

        Animal a;
        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}