package es.jllopezalvarez.ad.ut02conectores.ejercicios;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio04 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";
    private static final String SQL_FIND_ARTISTS = "select artist_id, name from artist where name like ?";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce lo que quieres buscar en los artistas: ");
        String searchString = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ARTISTS)) {

            searchString = "%" +  searchString + "%";

            statement.setString(1, searchString);

            try(ResultSet rs = statement.executeQuery()) {


                if (!rs.isBeforeFirst()) {
                    System.out.println("No se han encontrado artistas para el criterio de búsqueda");
                    return;
                }

                while (rs.next()) {
                    System.out.printf("%d - %s \n", rs.getInt("artist_id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD o al ejecutar la sentencia.");
            e.printStackTrace();
        }
    }
}
