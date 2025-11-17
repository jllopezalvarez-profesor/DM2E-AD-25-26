package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

public class ChinookConnectionPool {
    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/chinook";
    private static final String USERNAME = "chinook";
    private static final String PASSWORD = "chinook";

    @Getter
    private static ChinookConnectionPool instance = new ChinookConnectionPool();

    private final HikariPool pool;

    private ChinookConnectionPool() {
        HikariConfig config = new HikariConfig();
        // config.setDriverClassName("org.postgresql.Driver"); // No es necesario en Java moderno
        config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);

        // Ejemplo de cosas que se pueden configurar
        // config.addDataSourceProperty("cachePrepStmts", "true");
        // config.addDataSourceProperty("prepStmtCacheSize", "250");
        // config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        // config.addDataSourceProperty("useServerPrepStmts", "true");
        // config.addDataSourceProperty("useLocalSessionState", "true");
        // config.addDataSourceProperty("rewriteBatchedStatements", "true");
        // config.addDataSourceProperty("cacheResultSetMetadata", "true");
        // config.addDataSourceProperty("cacheServerConfiguration", "true");
        // config.addDataSourceProperty("elideSetAutoCommits", "true");

        pool = new HikariPool(config);
    }

    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }
}
