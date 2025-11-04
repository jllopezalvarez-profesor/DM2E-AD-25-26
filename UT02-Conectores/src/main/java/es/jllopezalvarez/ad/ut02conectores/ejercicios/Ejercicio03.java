package es.jllopezalvarez.ad.ut02conectores.ejercicios;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio03 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce lo que quieres buscar en los artistas: ");
        String searchString = sc.nextLine();

        String searchSql = "select artist_id, name from artist where name like '%" + searchString + "%'";

        System.out.println("Se va a ejecutar esta sentencia:");
        System.out.println(searchSql);

        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(searchSql)) {

            if (!rs.isBeforeFirst()){
                System.out.println("No se han encontrado artistas para el criterio de búsqueda");
                return;
            }

            while (rs.next()) {
                System.out.printf("%d - %s \n", rs.getInt("artist_id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD o al ejecutar la sentencia.");
            e.printStackTrace();
        }
    }
}
