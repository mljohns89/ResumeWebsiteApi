package xyz.michaeljohnson.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomThreadUtil {
	
	
	
	public static void getHello(HttpServletRequest request, HttpServletResponse response) {
		
		response.addHeader("my-custom-header", "hello thread util");
	}

}
