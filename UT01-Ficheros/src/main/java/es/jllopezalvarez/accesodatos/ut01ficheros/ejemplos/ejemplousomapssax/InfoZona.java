package es.jllopezalvarez.accesodatos.ut01ficheros.ejemplos.ejemplousomapssax;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoZona {
    private final String zoneName;
    private int cuantosPrecioMayorCinco = 0;
    private int cuantosPrecioMenorCinco = 0;
    private int cuantosShade = 0;
    private int cuantosSunny = 0;


    public InfoZona(String zoneName) {
        this.zoneName = zoneName;
    }
}
