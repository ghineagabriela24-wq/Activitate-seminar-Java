public class Student extends Person implements StudentBehaviour
{
    void activity()
    {
        System.out.println("I study");
    }

    public void gradesAverage()
    {
        System.out.println("Grades average is...");
    }
}
