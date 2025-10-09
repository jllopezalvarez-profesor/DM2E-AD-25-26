package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio16;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Program {

    private static final Path INPUT_FILE = Paths.get("ejercicios", "grupo-alumnos-01.xml");
    private static final Path OUTPUT_FILE = Paths.get("ejercicios", "grupo-alumnos-01-modificado.xml");


    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            try {
                Document doc = db.parse(INPUT_FILE.toFile());
                modifyXmlDocument(doc);
                saveNewXmlDocument(doc, OUTPUT_FILE);


            } catch (SAXException | IOException e) {
                throw new RuntimeException("Error al parsear el fichero XML", e);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Error al crear el objeto DocumentBuilder", e);
        }
    }

    private static void saveNewXmlDocument(Document doc, Path outputFile) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = null;

            transformer = tf.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Source source = new DOMSource(doc);
            Result result = new StreamResult(outputFile.toFile());
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new RuntimeException("Error al exportar el fichero XML", e);
        }
    }

    private static void modifyXmlDocument(Document doc) {
        NodeList nodes = doc.getElementsByTagName("alumno");
        for (int i = 0; i < nodes.getLength(); i++) {
            var node = nodes.item(i);
            Element student = (Element) node;
            String fullName = "";
            Node firstName = student.getElementsByTagName("nombre").item(0);
            if (firstName != null) {
                fullName = firstName.getTextContent();
            }
            Node lastName = student.getElementsByTagName("apellido").item(0);
            if (lastName != null) {
                fullName += " " + lastName.getTextContent();
            }

            // Añadirlo al elemento
            Element fullNameElement = doc.createElement("nombreCompleto");
            fullNameElement.setTextContent(fullName);
            student.appendChild(fullNameElement);

            // añadir fecha de modificación
            student.setAttribute("fechaModificacion", LocalDateTime.now().toString());
        }

    }

}
