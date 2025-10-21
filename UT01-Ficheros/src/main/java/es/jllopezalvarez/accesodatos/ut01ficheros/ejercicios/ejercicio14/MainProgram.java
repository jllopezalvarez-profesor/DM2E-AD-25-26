package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio14;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainProgram {
    private static final Path INPUT_FILE = Paths.get("ejercicios", "grupo-alumnos-01-modificado.xml");
    private static final Path OUTPUT_FILE = Paths.get("ejercicios", "grupo-alumnos-01-informe.txt");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        StudentHandler studentHandler = new StudentHandler();

        parser.parse(INPUT_FILE.toFile(), studentHandler);

        List<ModificationInfo> modifications = studentHandler.getModifications();

//
//        modifications.forEach(modificationInfo -> {
//            System.out.printf("%s-%s\n", modificationInfo.getFullName(), modificationInfo.getModifiedDate());
//        });

        generarInforme(modifications);

        



    }

    private static void generarInforme(List<ModificationInfo> modifications) {
        try(PrintWriter pw = new PrintWriter(OUTPUT_FILE.toFile())) {
            pw.printf("| %-35.35s | %-40.40s |\n", "-".repeat(37), "-".repeat(42));
            pw.printf("| %-35.35s | %-40.40s |\n", "Fecha", "Nombre completo");
            pw.printf("| %-35.35s | %-40.40s |\n", "-".repeat(37), "-".repeat(42));
            modifications.forEach(modification -> {
                pw.printf("| %-35.35s | %-40.40s |\n", modification.getModifiedDate(), modification.getFullName());
            });
            pw.printf("| %-35.35s | %-40.40s |\n", "-".repeat(37), "-".repeat(42));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
