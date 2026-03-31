import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> studenti = citesteStudenti("studenti.txt");

        System.out.println("Lista studenti:");

        for (Student s : studenti) {
            System.out.println(s);
        }
    }


    public static ArrayList<Student> citesteStudenti(String fisier) {

        ArrayList<Student> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fisier))) {

            String linie;

            while ((linie = br.readLine()) != null) {

                String[] valori = linie.split(",");

                String name = valori[0];
                Integer age = Integer.parseInt(valori[1]);
                String specializare = valori[2];

                Student student = new Student(name, age, specializare);

                lista.add(student);
            }

        } catch (IOException e) {
            System.out.println("Eroare la citire fisier");
        }

        return lista;
    }
}