package es.jllopezalvarez.ad.ut02conectores.ejercicios.ejercicio08;

import java.util.List;
import java.util.Optional;

public interface CustomerDataAccess {
    List<CustomerDetails> findCustomerDetails(String search);


}
