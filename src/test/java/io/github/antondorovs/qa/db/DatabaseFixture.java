package io.github.antondorovs.qa.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFixture {
    private final Connection connection;

    public DatabaseFixture(Connection connection) {
        this.connection = connection;
    }

    public long createCustomer(String name, String email) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO customers (name, email) VALUES (?, ?) RETURNING id")) {
            statement.setString(1, name);
            statement.setString(2, email);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                return result.getLong("id");
            }
        }
    }

    public long createOrder(long customerId, BigDecimal total, String status) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO orders (customer_id, total, status) VALUES (?, ?, ?) RETURNING id")) {
            statement.setLong(1, customerId);
            statement.setBigDecimal(2, total);
            statement.setString(3, status);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                return result.getLong("id");
            }
        }
    }
}
