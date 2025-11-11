package es.jllopezalvarez.ad.ut02conectores.ejemplos.desfaseor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import es.jllopezalvarez.ad.ut02conectores.ejemplos.singleton.EagerSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Wrapper;

public class ConnectionPool {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    private static ConnectionPool instance;

    static {
        instance = new ConnectionPool();
    }

    private HikariPool pool ;



    private ConnectionPool() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        pool = new HikariPool(config);
    }

     Connection getConnection() throws SQLException {
        return pool.getConnection();
     }

     public static ConnectionPool getInstance(){
        return instance;
     }


}
