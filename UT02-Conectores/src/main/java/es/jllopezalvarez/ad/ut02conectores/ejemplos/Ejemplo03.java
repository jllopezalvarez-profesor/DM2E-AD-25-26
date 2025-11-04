package es.jllopezalvarez.ad.ut02conectores.ejemplos;

import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejemplo03 {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    private static final String SQL_INSERT_ARTIST = """
            insert into artist (name)
            values (?)
            """;

    public static void main(String[] args) {
        Faker faker = new Faker();

        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ARTIST)) {
            statement.setString(1, faker.name().fullName());
            int rowCount =  statement.executeUpdate();
            System.out.printf("%d registros insertados.%n", rowCount);
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
