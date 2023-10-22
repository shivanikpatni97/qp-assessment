///**
// * 
// */
//package com.webApp.groceryBookingApp.securityconfig;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.webApp.groceryBookingApp.model.User;
//import com.webApp.groceryBookingApp.repository.UserRepository;
//
///**
// * @author shivanipatni
// *
// */
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepository;
//
//	    @Override
//	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	        User user = userRepository.findByEmail(email)
//	                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//	        List<GrantedAuthority> authorities = new ArrayList<>();
//	        if (user.isAdmin()) {
//	            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	        } else {
//	            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//	        }
//	        return new User(user.getEmail(), user.getPasswordHash(), authorities);
//	    }
//
//}
