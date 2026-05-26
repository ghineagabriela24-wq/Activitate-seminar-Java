package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element radacina = document.createElement("biblioteca");
            document.appendChild(radacina);

            adaugaCarte(document, radacina, "1", "Baltagul", "Mihail Sadoveanu", 1930, 35.50);
            adaugaCarte(document, radacina, "2", "Ion", "Liviu Rebreanu", 1920, 42.00);
            adaugaCarte(document, radacina, "3", "Enigma Otiliei", "George Calinescu", 1938, 39.99);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource sursa = new DOMSource(document);
            StreamResult rezultat = new StreamResult(new File("biblioteca.xml"));

            transformer.transform(sursa, rezultat);

            System.out.println("Documentul XML a fost generat cu succes.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void adaugaCarte(Document document, Element radacina,
                                    String id, String titlu, String autor,
                                    int an, double pret) {
        Element carte = document.createElement("carte");
        carte.setAttribute("id", id);

        Element titluElement = document.createElement("titlu");
        titluElement.appendChild(document.createTextNode(titlu));
        carte.appendChild(titluElement);

        Element autorElement = document.createElement("autor");
        autorElement.appendChild(document.createTextNode(autor));
        carte.appendChild(autorElement);

        Element anElement = document.createElement("an");
        anElement.appendChild(document.createTextNode(String.valueOf(an)));
        carte.appendChild(anElement);

        Element pretElement = document.createElement("pret");
        pretElement.appendChild(document.createTextNode(String.valueOf(pret)));
        carte.appendChild(pretElement);

        radacina.appendChild(carte);
    }
}