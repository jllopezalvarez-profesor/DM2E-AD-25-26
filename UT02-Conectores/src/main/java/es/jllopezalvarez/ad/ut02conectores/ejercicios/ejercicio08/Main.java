package es.jllopezalvarez.ad.ut02conectores.ejercicios.ejercicio08;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        CustomerDataAccess customerDataAccess = new CustomerDataAccessImpl();

        System.out.println("Introduce el nombre del cliente: ");
        String name = sc.nextLine();

        List<CustomerDetails> customerDetails = customerDataAccess.findCustomerDetails(name);

        customerDetails.forEach(System.out::println);
    }


}
