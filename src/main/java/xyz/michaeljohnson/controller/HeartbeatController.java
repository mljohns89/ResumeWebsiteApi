package xyz.michaeljohnson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeartbeatController {

	
	@RequestMapping("/heartbeat")
	public String heartbeat() {
		return "heartbeat";
	}
	
	@GetMapping("/heartbeat2")
	public String heartbeat2() {
		return "heartbeat2";
	}
}
