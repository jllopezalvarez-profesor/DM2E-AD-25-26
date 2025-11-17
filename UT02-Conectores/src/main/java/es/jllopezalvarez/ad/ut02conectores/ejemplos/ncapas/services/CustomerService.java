package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.services;

import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(int id);


}
