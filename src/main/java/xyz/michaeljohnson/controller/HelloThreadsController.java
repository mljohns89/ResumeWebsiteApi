package xyz.michaeljohnson.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.michaeljohnson.service.ThreadService;

@RestController
@RequestMapping("/concurrent")
public class HelloThreadsController {
	
	
	private final ThreadService threadService;
	
	public HelloThreadsController(ThreadService threadService) {
		this.threadService = threadService;
	}

	private double count = 0;

	@GetMapping("/thread")
	public String thread() {
		StringBuilder result = new StringBuilder();
		count++;

		result.append("ThreadName:  ").append(Thread.currentThread().getName());
		result.append("\n")
		.append("Count:  ").append(count);


		return result.toString();
	}
	
	@GetMapping("/thread2")
	public String thread2(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder result = new StringBuilder();
		count++;

		result.append("ThreadName:  ").append(Thread.currentThread().getName());
		result.append("\n")
		.append("Count:  ").append(count);
		
		threadService.getHello(request, response);
		


		return result.toString();
	}
	

	@GetMapping("/callable")
	public Callable<String> getAsyncResource() {

		return ()->{
			StringBuilder result = new StringBuilder();
			count++;

			result.append("ThreadName:  ").append(Thread.currentThread().getName());
			result.append("\n")
			.append("Count:  ").append(count);


			return result.toString();
		};

	}

	@Async
	@GetMapping("/future")
	public CompletableFuture<String> getFutureResource() {

		return CompletableFuture.supplyAsync(()->{
			StringBuilder result = new StringBuilder();
			count++;

			result.append("ThreadName:  ").append(Thread.currentThread().getName());
			result.append("\n")
			.append("Count:  ").append(count);


			return result.toString();
		});

	}
	
	@Async
	@GetMapping("/async")
	public String getAsync() {
		
		return "async";
	}
}
