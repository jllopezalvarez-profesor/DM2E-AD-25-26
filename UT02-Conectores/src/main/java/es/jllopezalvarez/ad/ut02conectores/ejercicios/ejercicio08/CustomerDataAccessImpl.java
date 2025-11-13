package es.jllopezalvarez.ad.ut02conectores.ejercicios.ejercicio08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDataAccessImpl implements CustomerDataAccess {
    private static final String SQL_FIND_CUSTOMER_DETAILS = """
             select c.customer_id,
                   c.first_name,
                   c.last_name,
                   c.email,
                   c.city,
                   c.state,
                   c.country,
                   c.postal_code,
                   sum(i.total) as total
            from customer c
                     inner join invoice i on c.customer_id = i.customer_id
            where c.first_name like ? or c.last_name like ?
            group by c.customer_id, c.customer_id, c.first_name, c.last_name, 
                     c.email, c.city, c.state, c.country, c.postal_code
            """;

    @Override
    public List<CustomerDetails> findCustomerDetails(String search) {

        List<CustomerDetails> returnList = new ArrayList<>();

        try (Connection connection = ChinookConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_CUSTOMER_DETAILS);
        ) {
            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");



            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    returnList.add(CustomerDetails.builder()
                            .customerId(resultSet.getInt("customer_id"))
                            .firstName(resultSet.getString("first_name"))
                            .lastName(resultSet.getString("last_name"))
                            .email(resultSet.getString("email"))
                            .city(resultSet.getString("city"))
                            .state(resultSet.getString("state"))
                            .postalCode(resultSet.getString("postal_code"))
                            .country(resultSet.getString("country"))
                            .totalInvoiceAmount(resultSet.getDouble("total"))
                            .build());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar detalles de clientes", e);
        }
        return returnList;
    }

}
