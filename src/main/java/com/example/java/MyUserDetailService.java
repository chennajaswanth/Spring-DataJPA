package com.example.java;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.java.model.MyUserDetails;
import com.example.java.model.User;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userRepository.findByUserName(username);
		user.orElseThrow(()->new UsernameNotFoundException("username not found with this user"+username));
		if(user.get().isActive()) {
			return user.map(MyUserDetails::new).get();
		}
		else {
			return null;
		}
		
	}
	

}
