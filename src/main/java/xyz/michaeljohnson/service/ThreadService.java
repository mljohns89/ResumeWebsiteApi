package xyz.michaeljohnson.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class ThreadService {

	
	
	
	public void getHello(HttpServletRequest request, HttpServletResponse response) {
		
		response.addHeader("my-custom-header", "hello thread service");
	}
	
	
}
