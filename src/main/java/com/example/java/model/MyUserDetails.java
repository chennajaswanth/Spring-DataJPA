package com.example.java.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	private String userName;
	private String password;
	private boolean active;
	private List<SimpleGrantedAuthority> roles;
	

	public MyUserDetails() {
	}

	public MyUserDetails(User user) {
		this.userName = user.getUserName();
		this.password=user.getPassword();
		this.active=user.isActive();
		this.roles=Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	//setting role to ADMIN or User with "ROLE_ADMIN" or "ROLE_USER".
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	@Override
	public String getUsername() {
		return userName;
	}

}
