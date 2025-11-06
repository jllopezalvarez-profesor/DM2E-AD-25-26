package es.jllopezalvarez.ad.ut02conectores.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio06 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";
    private static final String SQL_INSERT_TRANSACTION = "insert into prueba_transaccion(contenido) values (?)";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_TRANSACTION)) {

            connection.setAutoCommit(false);

            String contenido = "";

            while (!contenido.equalsIgnoreCase("fin")) {
                System.out.print("Dime el contenido: ");
                contenido = scanner.nextLine();

                if (contenido.equalsIgnoreCase("error")) {
                    throw new UserCanceledException("El usuario ha escrito fin");
                }
                if (!contenido.equalsIgnoreCase("fin")) {
                    preparedStatement.setString(1, contenido);
                    preparedStatement.executeUpdate();
                }
            }

            connection.commit();


        } catch (UserCanceledException e) {
            System.out.println("El usuario ha escrito fin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
