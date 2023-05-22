package com.example.java;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityTest {
	
	@RequestMapping("/")
	public String logonPage() {
		return "<h1>hello this is Landing page Jaswanth</h1>";
	}
	
	@RequestMapping("/user-map")
	public String landingpageForUser() {
		return "<h1>hello this is User page Jaswanth</h1>";
	}
	
	@RequestMapping("/admin-map")
	public String landingpageForAdmin() {
		return "<h1>hello this is Admin page Jaswanth</h1>";
	}

	

}
