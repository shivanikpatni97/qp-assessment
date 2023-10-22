/**
 * 
 */
package com.webApp.groceryBookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shivanipatni
 *
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroceryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String productName;
	
	@NotNull
	private double price;
	
	@NotNull
	private double quantity;
	
	
	//Getters and Setters
	
	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	} 

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
