package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas;

import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess.CustomerDataAccess;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess.CustomerDataAccessImpl;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities.Customer;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.services.CustomerService;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.services.CustomerServiceImpl;

import java.util.Optional;
import java.util.Scanner;

/**
 * Esto sería la capa de UI / Aplicación
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el id del cliente: ");
        int id = sc.nextInt();

        CustomerDataAccess customerDataAccess = new CustomerDataAccessImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDataAccess);

        try
        {

            Optional<Customer> customer = customerService.findById(id);

            if (customer.isPresent()) {
                System.out.println(customer.orElseThrow());
            }else {
                System.out.println("El cliente no existe");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
