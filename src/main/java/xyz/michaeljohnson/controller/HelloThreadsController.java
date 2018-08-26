package xyz.michaeljohnson.controller;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.michaeljohnson.database.ResumeDatabase;

@RestController
@RequestMapping("/concurrent")
public class HelloThreadsController {

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
	
	@GetMapping("/resume")
	public Map<String, String> resume() {
		return ResumeDatabase.getResumeData();
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
