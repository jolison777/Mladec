
package com.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dao.OrderDao;
import com.database.DBConnection;
import com.entity.Order;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Order add(Order order) {
        final String sql = "INSERT INTO orders (customer_name, total_amount) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, order.getCustomerName());
            ps.setInt(2, order.getTotalAmount());

            int affected = ps.executeUpdate();
            if (affected != 1) throw new RuntimeException("Insert failed");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) order.setId(rs.getLong(1));
            }
            return order;
        } catch (SQLException e) {
            throw new RuntimeException("Add failed", e);
        }
    }

    @Override
    public List<Order> addAll(List<Order> orders) {
        final String sql = "INSERT INTO orders (customer_name, total_amount) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            for (Order o : orders) {
                ps.setString(1, o.getCustomerName());
                ps.setInt(2, o.getTotalAmount());
                ps.addBatch();
            }
            ps.executeBatch();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                int i = 0;
                while (rs.next() && i < orders.size()) {
                    orders.get(i).setId(rs.getLong(1));
                    i++;
                }
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException("Bulk insert failed", e);
        }
    }

    @Override
    public Order update(Long id, Order incoming) {
        final String sql = "UPDATE orders SET customer_name=?, total_amount=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, incoming.getCustomerName());
            ps.setInt(2, incoming.getTotalAmount());
            ps.setLong(3, id);

            int affected = ps.executeUpdate();
            if (affected == 0) throw new RuntimeException("Order not found: " + id);

            incoming.setId(id);
            return incoming;
        } catch (SQLException e) {
            throw new RuntimeException("Update failed", e);
        }
    }

    @Override
    public void delete(Long id) {
        final String sql = "DELETE FROM orders WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            int affected = ps.executeUpdate();
            if (affected == 0) throw new RuntimeException("Order not found: " + id);
        } catch (SQLException e) {
            throw new RuntimeException("Delete failed", e);
        }
    }

    @Override
    public Optional<Order> get(Long id) {
        final String sql = "SELECT id, customer_name, total_amount FROM orders WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(map(rs));
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Get failed", e);
        }
    }

    @Override
    public List<Order> getAll() {
        final String sql = "SELECT id, customer_name, total_amount FROM orders ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            List<Order> list = new ArrayList<>();
            while (rs.next()) list.add(map(rs));
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("GetAll failed", e);
        }
    }

    private Order map(ResultSet rs) throws SQLException {
        Order o = new Order();
        o.setId(rs.getLong("id"));
        o.setCustomerName(rs.getString("customer_name"));
        o.setTotalAmount(rs.getInt("total_amount"));
        return o;
    }
}
