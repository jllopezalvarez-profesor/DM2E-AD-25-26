package es.jllopezalvarez.ad.ut02conectores.ejemplos;

import java.sql.*;

public class Ejemplo01 {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chinook", "chinook", "chinook")) {
            System.out.printf("Connected to database at: %s\n", connection.getMetaData().getURL());
            System.out.printf("El tipo del objeto connection es %s\n", connection.getClass().getCanonicalName());
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("select  name, genre_id from genre")) {

                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No hay resultados");
                } else {
                    System.out.println("Géneros encontrados:");
                    while (resultSet.next()) {
                        //System.out.printf("%s - %s \n",  resultSet.getString(1), resultSet.getString(2) );
                        //System.out.printf("%s - %s \n", resultSet.getString("genre_id"), resultSet.getString("name"));

                        int genreId =  resultSet.getInt("genre_id");
                        // La siguiente línea falla porque el nombre no puede convertirse a int
                        // int name = resultSet.getInt("name");
                        String name = resultSet.getString("name");

                        System.out.printf("%s - %s \n", genreId, name);



                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


}
