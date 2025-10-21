package es.jllopezalvarez.accesodatos.ut01ficheros.ejemplos.ejemplousomapssax;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjemploUsoMapsHandler extends DefaultHandler {

    // El mapa guarda la información de las zonas.
    // Se usa el nombre de la zona como clave.
    // Inicialmente está vacío, no hay información de ninguna zona
    @Getter
    private Map<String, InfoZona> infoZonas = new HashMap<>();
    // Usando TreeMap podemos ordenar como queramos
//    private Map<String, InfoZona> infoZonas = new TreeMap<>((o1, o2) -> {
//        int value = -Integer.compare(o1.length(), o2.length());
//        if (value == 0) {
//            value = o1.compareTo(o2);
//
//        }
//        return value;
//    }
//    );

    // Flags para controlar cuando estamos en un elemento
    private boolean enPlant = false;
    private boolean enZone = false;
    private boolean enPrice = false;
    private boolean enLight = false;

    // Variables para guardar datos a medida que se recogen
    private String currentZone;
    private double currentPrice;
    private String currentLight;

    // String builder para guardar los datos de texto de cada elemento
    private StringBuilder textBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "plant":
                enPlant = true;
                break;
            case "zone":
                enZone = true;
                textBuilder.setLength(0);
                break;
            case "price":
                enPrice = true;
                textBuilder.setLength(0);
                break;
            case "light":
                enLight = true;
                textBuilder.setLength(0);
                break;
            // No hace falta caso "default". Se ignora.
            //default:


        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (enZone || enLight || enPrice) {
            textBuilder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "plant":
                enPlant = false;
                // Aquí hemos terminado una planta, así que contabilizamos
                // los valores acumulados
                contabilizarPlanta(this.currentZone, this.currentPrice, this.currentLight);
                break;
            case "zone":
                enZone = false;
                currentZone = textBuilder.toString();
                break;
            case "price":
                enPrice = false;
                currentPrice = Double.parseDouble(textBuilder.substring(1)); // Quitar el $
                break;
            case "light":
                currentLight = textBuilder.toString();
                enLight = false;
                break;
        }
    }

    private void contabilizarPlanta(String currentZone, Double currentPrice, String currentLight) {
        // Buscar en el mapa si ya hay un objeto con información de la zona
        // Si no hay, añado una nueva información para la zona, con valores "0"
        infoZonas.putIfAbsent(currentZone, new InfoZona(currentZone));
        // Alternativa: usar !infoZonas.containsKey(currentZone) y añadir con put

        // Obtener el objeto existente, que será el nuevo añadido, o el antiguo si ya
        // Se habia encontrado antes esta zona
        InfoZona infoZona = infoZonas.get(currentZone);

        // Comprobar precio de la planta
        if (currentPrice > 5) {
            infoZona.setCuantosPrecioMayorCinco(infoZona.getCuantosPrecioMayorCinco() + 1);
        } else {
            infoZona.setCuantosPrecioMayorCinco(infoZona.getCuantosPrecioMayorCinco() + 1);
        }

        // Comprobar luz "Shade" y "Sunny"
        if (currentLight != null) {
            if (currentLight.equalsIgnoreCase("Shade")) {
                infoZona.setCuantosShade(infoZona.getCuantosShade() + 1);
            }
            if (currentLight.equalsIgnoreCase("Sunny")) {
                infoZona.setCuantosSunny(infoZona.getCuantosSunny() + 1);
            }
        }
    }
}
