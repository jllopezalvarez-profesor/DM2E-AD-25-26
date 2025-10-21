package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ModificationInfo {
    private  String fullName;
    private  LocalDateTime modifiedDate;

//    public ModificationInfo(String fullName, LocalDateTime modifiedDate) {
//        this.fullName = fullName;
//        this.modifiedDate = modifiedDate;
//    }
}
