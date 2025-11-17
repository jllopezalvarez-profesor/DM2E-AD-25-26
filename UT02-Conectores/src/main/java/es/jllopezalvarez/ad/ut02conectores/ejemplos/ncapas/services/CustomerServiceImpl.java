package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.services;

import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess.CustomerDataAccess;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDataAccess customerDataAccess;

    public CustomerServiceImpl(CustomerDataAccess customerDataAccess) {
        this.customerDataAccess = customerDataAccess;
    }

    @Override
    public List<Customer> findAll() {
        return customerDataAccess.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("El identificador del cliente no puede ser menor que 1");
        }

        return customerDataAccess.findById(id);
    }
}
