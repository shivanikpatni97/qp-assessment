/**
 * 
 */
package com.webApp.groceryBookingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApp.groceryBookingApp.CustomExceptions.NotEnoughStockException;
import com.webApp.groceryBookingApp.model.GroceryItem;
import com.webApp.groceryBookingApp.repository.GroceryItemRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author shivanipatni
 *
 */

@Service
public class GroceryItemService {

	@Autowired
	GroceryItemRepository groceryItemRepository;

	//Get all items present in inventory
	public List<GroceryItem> getAllGroceryItems() {
		return groceryItemRepository.findAll();
	}

	//Get item by Id
	public GroceryItem getGroceryItemById(Long id) {
		return groceryItemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Grocery item not found with id: " + id));
	}

	//Save item to database
	public GroceryItem saveGroceryItem(GroceryItem groceryItem) {
		return groceryItemRepository.save(groceryItem);
	}

	//Update Grocery Item
	public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
		GroceryItem existingItem = getGroceryItemById(id);
		existingItem.setProductName(updatedItem.getProductName());
		existingItem.setPrice(updatedItem.getPrice());
		existingItem.setQuantity(updatedItem.getQuantity());
		return groceryItemRepository.save(existingItem);
	}

	//Delete Grocery Item
	public void deleteGroceryItem(Long id) {
		GroceryItem existingItem = getGroceryItemById(id);
		groceryItemRepository.delete(existingItem);
	}

	//Manage Inventory
	public void decreaseInventory(Long productId, int quantity) throws NotEnoughStockException {
		GroceryItem item = groceryItemRepository.findById(productId)
				.orElseThrow(() -> new EntityNotFoundException("Grocery Item not found"));
		if (item.getQuantity() >= quantity) {
			item.setQuantity(item.getQuantity() - quantity);
			groceryItemRepository.save(item);
		} 
		else {
			throw new NotEnoughStockException("Not enough stock available for this item");
		}
	}
}
