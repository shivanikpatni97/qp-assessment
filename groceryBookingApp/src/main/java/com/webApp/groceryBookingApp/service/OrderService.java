/**
 * 
 */
package com.webApp.groceryBookingApp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApp.groceryBookingApp.CustomExceptions.NotEnoughStockException;
import com.webApp.groceryBookingApp.model.GroceryItem;
import com.webApp.groceryBookingApp.model.Order;
import com.webApp.groceryBookingApp.model.OrderItem;
import com.webApp.groceryBookingApp.repository.GroceryItemRepository;
import com.webApp.groceryBookingApp.repository.OrderItemRepository;
import com.webApp.groceryBookingApp.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author shivanipatni
 *
 */

@Service
public class OrderService {

	@Autowired 
	OrderRepository orderRepository;

	@Autowired
	GroceryItemService groceryItemService;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	GroceryItemRepository groceryItemRepository;


	public Order placeOrder(List<OrderItem> orderItems) throws NotEnoughStockException {
		// Retrieve user
		//	        User user = userRepository.findById(userId)
		//	                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

		// Create a new order
		Order order = new Order();
		order.setCreatedAt(LocalDateTime.now());
		Order savedOrder = orderRepository.save(order); 
		//  order.setUser(user);

		double totalPrice = 0;
		List<OrderItem> savedOrderItems = new ArrayList<>();

		for (OrderItem orderItem : orderItems) {
			// Retrieve the grocery item
			GroceryItem groceryItem = groceryItemRepository.findById(orderItem.getOrderItemId())
					.orElseThrow(() -> new EntityNotFoundException("GroceryItem not found with ID: " +
							orderItem.getOrderItemId()));

			// Check if there is enough stock
			if (groceryItem.getQuantity() < orderItem.getQuantity()) {
				throw new NotEnoughStockException("Not enough stock for product ID: " + groceryItem.getId());
			}

			// Update quantity in stock
			groceryItem.setQuantity(groceryItem.getQuantity() - orderItem.getQuantity());
			groceryItemRepository.save(groceryItem);

			// Calculate item total price
			double itemTotalPrice = orderItem.getPrice() * orderItem.getQuantity();
			totalPrice += itemTotalPrice;

			// Set associations and save order item
			orderItem.setOrder(savedOrder);
			orderItem.setGroceryItem(groceryItem);
			orderItem.setPrice(itemTotalPrice);
			orderItemRepository.save(orderItem);
			savedOrderItems.add(orderItem);
		}

		// Set total price and save the order
		order.setTotalPrice(totalPrice);
		order.setOrderItems(savedOrderItems);
		return orderRepository.save(order);
	}
}
