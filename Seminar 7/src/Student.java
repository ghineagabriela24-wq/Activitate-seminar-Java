public class Student {

    private String name;
    private Integer age;
    private String specializare;

    public Student(String name, Integer age, String specializare) {
        this.name = name;
        this.age = age;
        this.specializare = specializare;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSpecializare() {
        return specializare;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + specializare;
    }
}