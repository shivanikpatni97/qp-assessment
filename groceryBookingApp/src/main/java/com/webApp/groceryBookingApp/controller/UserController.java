/**
 * 
 */
package com.webApp.groceryBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.groceryBookingApp.CustomExceptions.NotEnoughStockException;
import com.webApp.groceryBookingApp.model.GroceryItem;
import com.webApp.groceryBookingApp.model.Order;
import com.webApp.groceryBookingApp.model.OrderItem;
import com.webApp.groceryBookingApp.service.GroceryItemService;
import com.webApp.groceryBookingApp.service.OrderService;

/**
 * @author shivanipatni
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	GroceryItemService groceryItemService;

	//	@Autowired
	//	UserService userService;

	@Autowired
	OrderService orderService;

	@GetMapping("/getAllGroceryItems")
	public ResponseEntity<List<GroceryItem>> getAllItems(){
		List<GroceryItem> groceryItems = groceryItemService.getAllGroceryItems();
		return ResponseEntity.ok(groceryItems);
	}

	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody List<OrderItem> orderItems) {
		// try {
		Order placedOrder;
		Long orderId = null;
		try {
			placedOrder = orderService.placeOrder(orderItems);
			orderId = placedOrder.getOrderId();
			return ResponseEntity.ok("Order placed successfully. Order ID: " + orderId);
		} catch (NotEnoughStockException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place the order.");
		}
	}

}
