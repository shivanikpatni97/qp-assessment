package com.webApp.groceryBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.groceryBookingApp.model.Order;

/**
 * @author shivanipatni
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
