package es.jllopezalvarez.accesodatos.ut01ficheros.ejemplos.ejemplousomapssax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;

public class EjemploUsoMapsSax {
    private static final Path XML_FILE_PATH= Path.of("xml-files", "plants-catalog.xml");
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EjemploUsoMapsHandler handler = new EjemploUsoMapsHandler();

        parser.parse(XML_FILE_PATH.toFile(),handler);

        handler.getInfoZonas().values().forEach(infoZona -> {
            System.out.printf("Zona: %s\n", infoZona.getZoneName());
            System.out.printf("\tCuantos > 5:\t%d\n", infoZona.getCuantosPrecioMayorCinco());
            System.out.printf("\tCuantos <= 5:\t%d\n", infoZona.getCuantosPrecioMenorCinco());
            System.out.printf("\tCuantos Shade:\t%d\n", infoZona.getCuantosShade());
            System.out.printf("\tCuantos Sunny:\t%d\n", infoZona.getCuantosSunny());


        });


    }
}
