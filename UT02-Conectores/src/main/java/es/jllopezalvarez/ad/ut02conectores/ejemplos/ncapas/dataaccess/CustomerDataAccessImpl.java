package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.dataaccess;

import es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDataAccessImpl implements CustomerDataAccess {
    private static final String SQL_FIND_ALL = """
             select customer_id,
             first_name,
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
             support_rep_id
            
            from customer
            
            """;
    private static final String SQL_FIND_BY_ID = """
             select customer_id,
             first_name,
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
             support_rep_id
            
            from customer
            where customer_id = ?
            
            """;

    @Override
    public List<Customer> findAll() {

        List<Customer> returnList = new ArrayList<>();

        try (Connection connection = ChinookConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                returnList.add(Customer.builder()
                        .customerId(resultSet.getInt("customer_id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .company(resultSet.getString("company"))
                        .address(resultSet.getString("address"))
                        .city(resultSet.getString("city"))
                        .state(resultSet.getString("state"))
                        .country(resultSet.getString("country"))
                        .postalCode(resultSet.getString("postal_code"))
                        .fax(resultSet.getString("fax"))
                        .phone(resultSet.getString("phone"))
                        .email(resultSet.getString("email"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar detalles de clientes", e);
        }
        return returnList;
    }

    @Override
    public Optional<Customer> findById(int id) {
        try (Connection connection = ChinookConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(
                            Customer.builder()
                                    .customerId(resultSet.getInt("customer_id"))
                                    .firstName(resultSet.getString("first_name"))
                                    .lastName(resultSet.getString("last_name"))
                                    .company(resultSet.getString("company"))
                                    .address(resultSet.getString("address"))
                                    .city(resultSet.getString("city"))
                                    .state(resultSet.getString("state"))
                                    .country(resultSet.getString("country"))
                                    .postalCode(resultSet.getString("postal_code"))
                                    .fax(resultSet.getString("fax"))
                                    .phone(resultSet.getString("phone"))
                                    .email(resultSet.getString("email"))
                                    .build());
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar detalles de clientes", e);
        }
    }

}
