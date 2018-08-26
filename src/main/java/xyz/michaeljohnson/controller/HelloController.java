package xyz.michaeljohnson.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	
	@GetMapping("/hello/{name}")
	public String helloName(@PathVariable("name") String name, HttpServletResponse response) {
		Cookie testCookie = new Cookie("michael_johnson", UUID.randomUUID().toString());
		testCookie.setHttpOnly(true);
		testCookie.setSecure(true);
		testCookie.setMaxAge(-1);
		response.addCookie(testCookie);
		return "Hello " + name + "!";
	}
}
