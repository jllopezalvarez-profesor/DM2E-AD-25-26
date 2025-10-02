package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio13;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDate unmarshal(String v) {
        return (v == null ? null : LocalDate.parse(v, FORMATTER));
    }

    @Override
    public String marshal(LocalDate v) {
        return (v == null ? null : v.format(FORMATTER));
    }
}

