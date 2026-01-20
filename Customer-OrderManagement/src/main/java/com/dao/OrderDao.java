
package com.dao;

import com.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderDao {
    Order add(Order order);
    List<Order> addAll(List<Order> orders);
    Order update(Long id, Order incoming);
    void delete(Long id);
    Optional<Order> get(Long id);
    List<Order> getAll();
}
