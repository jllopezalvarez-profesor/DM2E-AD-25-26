package es.jllopezalvarez.ad.ut02conectores.ejercicios;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio05 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";
    private static final String SQL_INSERT_CUSTOMER = """
            insert into customer (first_name, 
                                  last_name, 
                                  company, 
                                  address, 
                                  city, 
                                  state, 
                                  country, 
                                  postal_code, 
                                  phone,
                                  fax, 
                                  email, 
                                  support_rep_id)
                        values (?,?,?,?,?,?,?,?,?,?,?,?);
            """;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CUSTOMER, Statement.RETURN_GENERATED_KEYS);) {

            // Pedir datos del nuevo cliente
            System.out.println("Dime el nombre del cliente: ");
            String firstName = sc.nextLine();
            System.out.println("Dime el apellido del cliente: ");
            String lastName = sc.nextLine();
            System.out.println("Dime la compañia del cliente: ");
            String company = sc.nextLine();
            System.out.println("Dime la dirección del cliente: ");
            String address = sc.nextLine();
            System.out.println("Dime la ciudad del cliente: ");
            String city = sc.nextLine();
            System.out.println("Dime el estado del cliente: ");
            String state = sc.nextLine();
            System.out.println("Dime el país del cliente: ");
            String country = sc.nextLine();
            System.out.println("Dime el código postal del cliente: ");
            String postalCode = sc.nextLine();
            System.out.println("Dime el teléfono del cliente: ");
            String phone = sc.nextLine();
            System.out.println("Dime el nº de fax del cliente: ");
            String fax = sc.nextLine();
            System.out.println("Dime el correo electrónico del cliente: ");
            String email = sc.nextLine();
            System.out.println("Dime el código del representante de soporte del cliente (pulsa intro sin escribir nada si no tiene representante): ");
            String supportRepId = sc.nextLine();

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, company);
            statement.setString(4, address);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, country);
            statement.setString(8, postalCode);
            statement.setString(9, phone);
            statement.setString(10, fax);
            statement.setString(11, email);
            if (supportRepId.isBlank()) {
                statement.setNull(12, Types.INTEGER);
            } else {
                statement.setInt(12, Integer.parseInt(supportRepId));
            }

            int affectedRowCount = statement.executeUpdate();

            if (affectedRowCount > 0) {
                // Insertado correctamente
                System.out.println("Registro creado con éxito.");
                // Obtener las claves
                try ( ResultSet keys = statement.getGeneratedKeys()){
                    if (keys.next()) {
                        System.out.println("La clave generada es: " + keys.getInt(1));
                    }
                    else {
                        System.out.println("No se ha podido recuperar la clave generada");
                    }
                }
            } else {
                // No se ha insertado
                System.out.println("No se pudo registrar el cliente");
            }


        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD o al ejecutar la sentencia.");
            e.printStackTrace();
        }
    }


}
