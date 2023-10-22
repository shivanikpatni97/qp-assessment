/**
 * 
 */
package com.webApp.groceryBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.groceryBookingApp.model.GroceryItem;
import com.webApp.groceryBookingApp.service.GroceryItemService;

import jakarta.validation.Valid;

/**
 * @author shivanipatni
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	GroceryItemService groceryItemService;
	
	@PostMapping("/addGroceryItem")
	public ResponseEntity<GroceryItem> addGroceryItem(@Valid @RequestBody GroceryItem groceryItem) {
		 GroceryItem savedItem = groceryItemService.saveGroceryItem(groceryItem);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
	}
	
	@GetMapping("/groceryItems")
	public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> groceryItems = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItems);
    }
	
	 @DeleteMapping("/groceryitems/{id}")
	    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
	        groceryItemService.deleteGroceryItem(id);
	        return ResponseEntity.ok().build();
	    }
	 
	 @PutMapping("/groceryItems/{id}")
	    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @Valid @RequestBody GroceryItem updatedItem) {
	        GroceryItem updatedGroceryItem = groceryItemService.updateGroceryItem(id, updatedItem);
	        return ResponseEntity.ok(updatedGroceryItem);
	    }
	
}
