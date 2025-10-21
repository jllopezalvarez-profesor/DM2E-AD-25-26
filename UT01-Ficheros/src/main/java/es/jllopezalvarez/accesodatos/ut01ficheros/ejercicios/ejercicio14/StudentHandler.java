package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio14;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentHandler extends DefaultHandler {


    private List<ModificationInfo> modifications = new ArrayList<>();

    private boolean inStudent = false;
    private boolean inFullName = false;

    StringBuilder fullName = new StringBuilder();
    //    LocalDateTime modifiedDate;
    ModificationInfo modification;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "alumno":
                inStudent = true;
                modification = new ModificationInfo();

//                modifiedDate = LocalDateTime.parse(attributes.getValue("fechaModificacion"));
                fullName.setLength(0);
                modification.setModifiedDate(LocalDateTime.parse(attributes.getValue("fechaModificacion")));
                break;
            case "nombreCompleto":
                inFullName = true;
                break;

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inFullName) {
            fullName.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "alumno":
                inStudent = false;
                break;
            case "nombreCompleto":
//                System.out.printf("%s - %s\n", modifiedDate, fullName.toString());
                //modifications.add(new ModificationInfo(fullName.toString(), modifiedDate));
                modification.setFullName(fullName.toString());
                modifications.add(modification);
                inFullName = false;
                break;

        }

    }

    public List<ModificationInfo> getModifications() {
        return List.copyOf(modifications) ;
    }
}
