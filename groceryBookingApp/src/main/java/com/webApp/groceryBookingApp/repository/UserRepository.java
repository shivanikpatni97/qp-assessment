/**
 * 
 */
package com.webApp.groceryBookingApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.groceryBookingApp.model.User;

/**
 * @author shivanipatni
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmail(String email);

}
