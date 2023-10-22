/**
 * 
 */
package com.webApp.groceryBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.groceryBookingApp.model.GroceryItem;

/**
 * @author shivanipatni
 *
 */

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{

}
