package es.jllopezalvarez.ad.ut02conectores.ejemplos.desfaseor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDataAccessSinPool {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    private static final String SQL_GET_ALL = """
            select a.artist_id, a.name, count(t.track_id) as track_count
            from artist a
                     inner join public.album ab on a.artist_id = ab.artist_id
                     inner join public.track t on ab.album_id = t.album_id
            group by a.artist_id, a.name
            order by a.name;
            """;

    public List<ArtistInfo> getAllArtistInfo() {
        // Abrir conexion
        // Crear sentencia
        // ejecutar la sentencia
        // Convertir los datos a objetos
        // Devolver los objetos

        List<ArtistInfo> artistInfos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                artistInfos.add(new ArtistInfo(rs.getInt("artist_id"),
                        rs.getString("name"),
                        rs.getInt("track_count")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return artistInfos;
    }
}
