package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess;

import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDataAccess {
    List<Customer> findAll();
    Optional<Customer> findById(int id);


}
