package es.jllopezalvarez.ad.ut02conectores.ejemplos;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Ejemplo02 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    private static final String SQL_CLIENT_INVOICES = """
            select invoice_id,
                   customer_id,
                   invoice_date,
                   billing_address,
                   billing_city,
                   billing_state,
                   billing_country,
                   billing_postal_code,
                   total
            from invoice
            where customer_id = ? and total > ?
            """;


    public static void main(String[] args) {

        int customerId = 4;
        double minInvoiceTotal = 10;


        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_CLIENT_INVOICES);) {
            statement.setInt(1, customerId);
            statement.setDouble(2, minInvoiceTotal);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No hay facturas");
                } else
                {
                    while(resultSet.next()) {
                        System.out.printf("%s - %s - %s \n", resultSet.getString("invoice_id"), resultSet.getString("invoice_date"), resultSet.getString("total"));
//                        System.out.println("Línea");
                    }
                }

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
