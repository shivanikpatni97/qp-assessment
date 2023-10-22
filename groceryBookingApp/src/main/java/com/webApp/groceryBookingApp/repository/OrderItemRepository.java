/**
 * 
 */
package com.webApp.groceryBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.groceryBookingApp.model.OrderItem;

/**
 * @author shivanipatni
 *
 */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
